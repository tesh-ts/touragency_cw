package com.example.tourist_cw;

import com.example.tourist_cw.entities.Tour;
import com.example.tourist_cw.repo.TourRep;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TourRepositoryTest {
	@Autowired
	private TourRep tourRepository;

	@Test
	@DisplayName("TourRepo saving test")
	public void findTourTest(){
		Tour tour = new Tour();
		tour.setName("TEST");
		tour.setCity("TEST");
		tour.setCountry("TEST");
		tour.setStar_rating(0);
		tourRepository.save(tour);

		Assertions.assertEquals("TEST", tourRepository.findByName("TEST").getName());

		tourRepository.delete(tour);
	}

}
