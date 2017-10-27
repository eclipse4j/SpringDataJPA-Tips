package com.tistory.eclipse4j.jpa.service;

import com.tistory.eclipse4j.jpa.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

}
