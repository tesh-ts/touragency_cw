package com.example.tourist_cw.controller;

import com.example.tourist_cw.entities.Tour;
import com.example.tourist_cw.repo.TourRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ToursController {

    @Autowired
    TourRep tourRepository;

    @GetMapping("/tours")
    public String showToursPage(HttpServletRequest request, Model model) {
        model.addAttribute("username", request.getUserPrincipal().getName());
        model.addAttribute("linkOutOrUp", "/logout");
        model.addAttribute("textOutOrUp", "Выйти");
        model.addAttribute("linkInOrAccount", "/account");
        model.addAttribute("textInOrAccount", "Аккаунт");

        model.addAttribute("tours", tourRepository.findAll());

        return "tours";
    }

    @GetMapping("/tour/{id}")
    public String getTourInfo(@ModelAttribute("success") Object success,
                              @PathVariable int id, HttpServletRequest request,
                              Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("username", request.getUserPrincipal().getName());
        model.addAttribute("linkOutOrUp", "/logout");
        model.addAttribute("textOutOrUp", "Выйти");
        model.addAttribute("linkInOrAccount", "/account");
        model.addAttribute("textInOrAccount", "Аккаунт");

        Tour tour = tourRepository.findById(id);

        model.addAttribute("tour", tour);

        if (success.getClass() == String.class) {
            model.addAttribute("success", success);
        } else
            model.addAttribute("success", "");

        return "tour";
    }
}

