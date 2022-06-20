package com.profdev.ordering.controllers;

import java.util.HashMap;
import java.util.Map;

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
	public Map<CoffeType,Double> getCoffeeTypes() {
		Map<CoffeType,Double> coffee=new HashMap<CoffeType, Double>();
		coffee.put(CoffeType.Cappuccino, (double) 2);
		coffee.put(CoffeType.Espresso, (double) 1);
		coffee.put(CoffeType.Latte, (double) 2.5);
		coffee.put(CoffeType.LongBlack, (double) 1.5);

		return coffee;
	}

	@GetMapping("/size")
	public Map<Size,Double> getSize() {
		Map<Size,Double> sized=new HashMap<Size, Double>();
		sized.put(Size.Large, (double) 2);
		sized.put(Size.Small, (double) 1);
		sized.put(Size.Medium, (double) 1.5);
		return sized;
	}

	@GetMapping("/milk")
	public Map<MilkType,Double> getMilkType() {
		Map<MilkType,Double> milkTypes=new HashMap<MilkType, Double>();
		milkTypes.put(MilkType.AlmondMilk, (double) .52);
		milkTypes.put(MilkType.CowMilk, (double) .75);
		milkTypes.put(MilkType.SoyMilk, (double) .99);
		return milkTypes;
		
		
	}

	@GetMapping("/status")
	public Status[] getStatues() {
		return Status.values();
	}
}
