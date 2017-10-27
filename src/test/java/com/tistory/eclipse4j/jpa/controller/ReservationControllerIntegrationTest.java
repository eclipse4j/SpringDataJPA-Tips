package com.tistory.eclipse4j.jpa.controller;

import com.tistory.eclipse4j.jpa.entity.Reservation;
import org.assertj.core.util.Maps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.tistory.eclipse4j.jpa.entity.Order;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ReservationControllerIntegrationTest {
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void createClient() {
		ResponseEntity<Reservation> responseEntity = restTemplate.getForEntity(
				"http://localhost:8080/reservations/1/products/1/update-tx", Reservation.class, Maps.newHashMap("ms", 0));
		Reservation order = responseEntity.getBody();
		log.info("Reservation=>{}", order);
	}
}
