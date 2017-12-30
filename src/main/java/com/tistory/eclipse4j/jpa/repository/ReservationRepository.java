package com.tistory.eclipse4j.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.tistory.eclipse4j.jpa.entity.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

}
