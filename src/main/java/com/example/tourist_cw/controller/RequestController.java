package com.example.tourist_cw.controller;

import com.example.tourist_cw.entities.Adopter;
import com.example.tourist_cw.entities.AdoptionRequest;
import com.example.tourist_cw.entities.Tour;
import com.example.tourist_cw.repo.ARequestRep;
import com.example.tourist_cw.repo.TourRep;
import com.example.tourist_cw.repo.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;

@Controller
public class RequestController {
    @Autowired
    UserRep userRepository;

    @Autowired
    TourRep tourRepository;

    @Autowired
    ARequestRep adoptionRequestRepository;

    @GetMapping("/request/{id}")
    public String makeRequest(@PathVariable int id, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("username", request.getUserPrincipal().getName());
        model.addAttribute("linkOutOrUp", "/logout");
        model.addAttribute("textOutOrUp", "Выйти");
        model.addAttribute("linkInOrAccount", "/account");
        model.addAttribute("textInOrAccount", "Аккаунт");

        Tour tour = tourRepository.findById(id);
        Adopter adopter = userRepository.findByUsername(request.getUserPrincipal().getName());
        model.addAttribute("tour", tour);

        if (adoptionRequestRepository.findByTour(tour) == null) {

            AdoptionRequest adoptionRequest = new AdoptionRequest();
            adoptionRequest.setTour(tour);
            adoptionRequest.setAdopter(adopter);
            adoptionRequestRepository.save(adoptionRequest);

            redirectAttributes.addFlashAttribute("success", "Тур добавлен, его можно увидеть во вкладке аккаунт");
        } else {
            redirectAttributes.addFlashAttribute("success", "Тур уже добавлен, перейдите во вкладку аккаунт");
        }

        return "redirect:/tour/" + String.valueOf(id);
    }
}
