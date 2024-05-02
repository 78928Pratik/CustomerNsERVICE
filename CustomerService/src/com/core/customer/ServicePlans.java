package com.core.customer;

public enum ServicePlans {

	SILVER(1000), GOLD(2000), DIAMOND(5000), PLATUNUM(10000);

	private double planCost;

	private ServicePlans(double cost) {
		this.planCost = cost;
	}

	public double getPlanCost() {
		return planCost;
	}

}
