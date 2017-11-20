package vhcsoft.blog.oa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import vhcsoft.blog.oa.entities.Order;
import vhcsoft.blog.oa.repositories.OrderRepository;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	
	@Autowired
	private OrderRepository orderRepo;
	
	@JsonView(Views.Public.class)
	@RequestMapping(method = RequestMethod.GET)
	public List<Order> getOrders() {
		return this.orderRepo.findAll();
	}
}
