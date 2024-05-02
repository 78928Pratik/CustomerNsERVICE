package com.core.customer;

import java.lang.Comparable;
import java.time.LocalDate;

public class Customer implements Comparable<Customer> {
	private int customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private double regAmount;
	private LocalDate dob;
	private ServicePlans plan;

	private static int counter;

	public Customer(String firstName, String lastName, String email, String password, double regAmount, LocalDate dob,
			ServicePlans plan) {
		super();
		this.customerId = ++counter;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.dob = dob;
		this.plan = plan;

	}

	public Customer(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getDob() {
		return dob;
	}

	public String getLastName() {
		return lastName;
	}

	public ServicePlans getServicePlan() {
		return plan;
	}

	public LocalDate dob() {
		return dob;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", regAmount=" + regAmount + ", dob=" + dob + ", plan=" + plan + "]";
	}

	@Override
	public boolean equals(Object o) {

		if (o instanceof Customer) {
			Customer c = (Customer) o;
			return this.email.equals(c.email);
		}

		return false;

	}

	@Override
	public int compareTo(Customer o) {
		return this.email.compareTo(o.getEmail());
	}
}
