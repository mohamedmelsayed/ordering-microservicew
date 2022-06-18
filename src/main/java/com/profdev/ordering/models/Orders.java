package com.profdev.ordering.models;

import javax.persistence.Entity;
import javax.persistence.Id;









@Entity
public class Orders {
	@Id
	private long id;

	private Status status=Status.Pending;

	private Size size = Size.Medium;

	private MilkType milkType=null;

	private boolean withMilk = false;

	private double price = 0;

	private CoffeType coffeeType = CoffeType.LongBlack;
	
	
	

	public Orders() {
		super();
	}

	public Orders(long id, String status, String size, String milkType, boolean withMilk, double price,
			String coffeeType) {
		super();
		this.id = id;
		
		this.status =status!=null? Status.valueOf(status):Status.Pending;
		this.size = size!=null?Size.valueOf(size):null;
		this.milkType =milkType!=null? MilkType.valueOf(milkType):null;
		this.withMilk = withMilk;
		this.price = price;
		this.coffeeType =coffeeType!=null? CoffeType.valueOf(coffeeType):CoffeType.LongBlack;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public MilkType getMilkType() {
		return milkType;
	}

	public void setMilkType(MilkType milkType) {
		this.milkType = milkType;
	}

	public boolean isWithMilk() {
		return withMilk;
	}

	public void setWithMilk(boolean withMilk) {
		this.withMilk = withMilk;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public CoffeType getCoffeeType() {
		return coffeeType;
	}

	public void setCoffeeType(CoffeType coffeeType) {
		this.coffeeType = coffeeType;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", status=" + status + ", size=" + size + ", milkType=" + milkType + ", withMilk="
				+ withMilk + ", price=" + price + ", coffeeType=" + coffeeType + "]";
	}
	
	

}