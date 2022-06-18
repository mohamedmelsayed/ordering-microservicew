package com.profdev.ordering.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.profdev.ordering.models.CoffeType;
import com.profdev.ordering.models.DeliveryType;
import com.profdev.ordering.models.MilkType;
import com.profdev.ordering.models.Size;
import com.profdev.ordering.models.Status;

@RestController
@RequestMapping("/api/v1/options")
public class OptionsController {
	@GetMapping("/pickup")
	public DeliveryType[] getDeliveryTypes() {
		return DeliveryType.values();
	}

	@GetMapping("/coffee")
	public CoffeType[] getCoffeeTypes() {
		return CoffeType.values();
	}

	@GetMapping("/size")
	public Size[] getSize() {
		return Size.values();
	}

	@GetMapping("/milk")
	public MilkType[] getMilkType() {
		return MilkType.values();
	}

	@GetMapping("/status")
	public Status[] getStatues() {
		return Status.values();
	}
}
