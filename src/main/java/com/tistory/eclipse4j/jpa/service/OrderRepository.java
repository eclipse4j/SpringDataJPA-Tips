package com.tistory.eclipse4j.jpa.service;

import org.springframework.data.repository.CrudRepository;

import com.tistory.eclipse4j.jpa.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
