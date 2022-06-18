package com.profdev.ordering.models;


public class OrderProcessing {

	
	private long orderId;

	private States status;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public States getStatus() {
		return status;
	}

	public void setStatus(States status) {
		this.status = status;
	}

}
