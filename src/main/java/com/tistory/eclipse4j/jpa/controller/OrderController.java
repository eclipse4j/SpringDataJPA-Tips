package com.tistory.eclipse4j.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tistory.eclipse4j.jpa.entity.Order;
import com.tistory.eclipse4j.jpa.service.OrderTxService;

@Controller
public class OrderController {

	@Autowired
	private OrderTxService orderTxService;

	@ResponseBody
	@GetMapping(path = "/orders/{orderId}")
	public Order find(@PathVariable("orderId") Long orderId, @RequestParam("ms")long ms) {
		Order order = orderTxService.findById(orderId, ms);
		return order;
	}
	
	@ResponseBody
	@GetMapping(path = "/orders/{orderId}/products/{productId}/update-tx-lock")
	public Order findAndUpdate(@PathVariable("orderId") Long orderId, @PathVariable("productId") Long productId, @RequestParam("ms")long ms) {
		Order order = orderTxService.findAndUpdate(orderId, productId, ms);
		return order;
	}
}
