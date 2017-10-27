package com.tistory.eclipse4j.jpa.controller;

import com.tistory.eclipse4j.jpa.service.ReservationTxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tistory.eclipse4j.jpa.entity.Reservation;

@Controller
public class ReservationController {

	@Autowired
	private ReservationTxService reservationTxService;

	@ResponseBody
	@GetMapping(path = "/reservations/{reservationId}")
	public Reservation find(@PathVariable("reservationId") Long reservationId, @RequestParam("ms")long ms) {
		Reservation reservation = reservationTxService.findById(reservationId, ms);
		return reservation;
	}
	
	@ResponseBody
	@GetMapping(path = "/reservations/{reservationId}/products/{productId}/update-tx-lock")
	public Reservation findAndUpdate(@PathVariable("reservationId") Long reservationId, @PathVariable("productId") Long productId, @RequestParam("ms")long ms) {
		Reservation reservation = reservationTxService.findAndUpdate(reservationId, productId, ms);
		return reservation;
	}
}
