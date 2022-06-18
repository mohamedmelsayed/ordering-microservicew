package com.profdev.ordering.models;

public class OrderRequest {

	private long id;
	
	private String status;

	private String size  ;
	private String milkType;

	private boolean withMilk ;

	private double price ;

	private String coffeeType;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getMilkType() {
		return milkType;
	}

	public void setMilkType(String milkType) {
		this.milkType = milkType;
	}

	public boolean getWithMilk() {
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

	public String getCoffeeType() {
		return coffeeType;
	}

	public void setCoffeeType(String coffeeType) {
		this.coffeeType = coffeeType;
	}
	
	
	

}
