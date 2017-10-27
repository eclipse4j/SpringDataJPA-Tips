package com.tistory.eclipse4j.jpa.service;

import com.tistory.eclipse4j.jpa.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tistory.eclipse4j.jpa.ThreadSleep;

@Service
public class ReservationTxService {

	@Autowired
	private ReservationRepository reservationRepository;

	@Transactional(readOnly = false)
	public Reservation findAndUpdate(Long id, Long productId, long ms) {
		Reservation reservation = reservationRepository.findOne(id);
		ThreadSleep.sleep(ms);
		reservation.setProductId(productId);
		reservationRepository.save(reservation);
		return reservation;
	}

	@Transactional(readOnly = true)
	public Reservation findById(Long id, long ms) {
		Reservation reservation = reservationRepository.findOne(id);
		ThreadSleep.sleep(ms);
		return reservation;
	}
}
