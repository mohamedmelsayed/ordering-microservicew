package com.profdev.ordering.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profdev.ordering.models.Orders;
import com.profdev.ordering.repositories.OrderingRepository;

@Service
public class OrderingService {
	@Autowired
	private OrderingRepository orderingRepo;
	
	public  List<Orders> getAll(){
		return (List<Orders>) orderingRepo.findAll();
	}
	
	
}
