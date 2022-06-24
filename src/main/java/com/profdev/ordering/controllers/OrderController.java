package com.profdev.ordering.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.profdev.ordering.models.CoffeType;
import com.profdev.ordering.models.DeliveryType;
import com.profdev.ordering.models.MilkType;
import com.profdev.ordering.models.OrderProcessing;
import com.profdev.ordering.models.Orders;
import com.profdev.ordering.models.OrderRequest;
import com.profdev.ordering.models.Size;
import com.profdev.ordering.models.States;
import com.profdev.ordering.models.Status;
import com.profdev.ordering.repositories.OrderingRepository;

@RestController
@RequestMapping(value = "/api/v1/order")
public class OrderController {
	@Autowired
	private OrderingRepository orderingRepo;
//	@CrossOrigin(origins = "http://localhost:1222")
	@GetMapping(value = { "", "/" })
	public List<Orders> getAll() {
		return (List<Orders>) orderingRepo.findAll();
	}
    private static final String CREATE_BARISTA_ENDPOINT_URL = "http://localhost:9999/api/v1/process-order";
	@PostMapping
	public Orders insert(@RequestBody OrderRequest order) {
		Orders orderToSave = new Orders(order.getId(), order.getStatus(), order.getSize(), order.getMilkType(),
				order.getWithMilk(), order.getPrice(), order.getCoffeeType(),order.getDelivery());
		System.out.println(order.toString());
		Orders saved = orderingRepo.save(orderToSave);
		if (saved != null) {
			OrderProcessing processing = new OrderProcessing();
			processing.setOrderId(saved.getId());
			processing.setStatus(States.Waiting);

			RestTemplate restTemplate = new RestTemplate();
			try {
				
				OrderProcessing result = restTemplate.postForObject(CREATE_BARISTA_ENDPOINT_URL, processing,
						OrderProcessing.class);

			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		return saved;
	}
	@CrossOrigin(origins = "http://localhost:1222")
	@RequestMapping(value="{orderId}",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Orders update(@RequestBody OrderRequest orderRequest, @PathVariable long orderId) {
		System.out.println(orderId);
		Orders order = orderingRepo.findById(orderId).get();
		Status old=order.getStatus();
		if (order != null) {
			order.setStatus(orderRequest.getStatus()!=null?Status.valueOf(orderRequest.getStatus()):order.getStatus());
			order.setSize(orderRequest.getSize()!=null?Size.valueOf(orderRequest.getSize()):order.getSize());
			order.setMilkType(orderRequest.getMilkType()!=null?MilkType.valueOf(orderRequest.getMilkType()):order.getMilkType());
			order.setCoffeeType(orderRequest.getCoffeeType()!=null?CoffeType.valueOf(orderRequest.getCoffeeType()):order.getCoffeeType());
			order.setPrice(orderRequest.getPrice()!=0?orderRequest.getPrice():order.getPrice());
			
			order.setDelivery(orderRequest.getDelivery()!=null?DeliveryType.valueOf(orderRequest.getDelivery()):order.getDelivery());

			}
			return orderingRepo.save(order);
		
		
	}

	@DeleteMapping("/{orderId}")
	public boolean delete(@PathVariable long orderId) {
		Orders order = orderingRepo.findById(orderId).get();
		if (order != null) {
			orderingRepo.delete(order);
			return true;
		}
		return false;
	}

}
