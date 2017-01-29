package com.tistory.eclipse4j.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tistory.eclipse4j.jpa.ThreadSleep;
import com.tistory.eclipse4j.jpa.entity.Order;

@Service
public class OrderTxService {

	@Autowired
	private OrderRepository orderRepository;

	@Transactional(readOnly = false)
	public Order findAndUpdate(Long id, Long productId, long ms) {
		Order order = orderRepository.findOne(id);
		ThreadSleep.sleep(ms);
		order.setProductId(productId);
		orderRepository.save(order);
		return order;
	}

	@Transactional(readOnly = true)
	public Order findById(Long id, long ms) {
		Order order = orderRepository.findOne(id);
		ThreadSleep.sleep(ms);
		return order;
	}
}
