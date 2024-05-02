package com.exception.customer;

import java.util.Iterator;
import java.time.LocalDate;
import java.util.List;

import com.core.customer.Customer;
import com.core.customer.ServicePlans;

public class CustomerValidation {

	public static LocalDate parseDate(String sdob) {
		return LocalDate.parse(sdob);
	}

	public static ServicePlans checkAndValidate(String splan, double amount) throws CMSException {
		ServicePlans plan = ServicePlans.valueOf(splan.toUpperCase());

		if (amount == plan.getPlanCost()) {
			System.out.println("Valid Registtration Amount with Plans");
			return plan;
		}
		throw new CMSException("Invalid Amount as per Plan recheck Again");

	}

	public static void checkDuplicate(String email, List<Customer> custlist) throws CMSException {
		Customer ecust = new Customer(email);

		if (custlist.contains(ecust))
			throw new CMSException("Duplicate Entry !!");
	}
// This method gives Complexity of On2 so trys maam method
	/*
	 * public static void signup(String email, String password, List<Customer>
	 * custlist) throws CMSException { Customer custe = new Customer(email); if
	 * (custlist.contains(custe)) { int index = custlist.indexOf(custe); Customer
	 * real = custlist.get(index); if (real.getPassword().equals(password)) {
	 * System.out.println("Login Successfully Welcome Sire Pratik");
	 * System.out.println("Customer details : \n"+real); return; } throw new
	 * CMSException("Invalid Password reporting to Police !!"); } throw new
	 * CMSException("Invalid email ID sending Army !!"); }
	 */

	// This one gives O(N) so this is efficient
	// Searching by primary key
	// contains will give more complexity

	public static Customer mdSignUp(String email, String password, List<Customer> custList) throws CMSException {
		Customer cemail = new Customer(email);
		int index = custList.indexOf(cemail);
		if (index == -1)
			throw new CMSException("Invalid Email,Login again");
		if (custList.get(index).getPassword().equals(password)) {
			System.out.println("Login Successful");
			return custList.get(index);
		}
		throw new CMSException("Invalid Passoward");
	}

	public static void unSubscribe(String email, List<Customer> custList) throws CMSException {
		Customer newCustomer = new Customer(email);
		int index = custList.indexOf(newCustomer);
		if (index == -1)
			throw new CMSException("Invalid emial");
		Customer cust = custList.remove(index);
//		Customer customer=custList.get(index);
		System.out.println("Unsubscribe user : " + cust);
	}

	public static Customer validateCustomerInputs(String firstName, String lastName, String email, String password,
			double regAmount, String dob, String plan, List<Customer> customers) throws CMSException {

		checkDuplicate(email, customers);
		ServicePlans servicePlan = checkAndValidate(plan, regAmount);

		LocalDate bithDate = LocalDate.parse(dob);
		return new Customer(firstName, lastName, email, password, regAmount, bithDate, servicePlan);
	}

	public static void findingCustomer(String email, List<Customer> custlist) throws CMSException {
		Customer ecust = new Customer(email);
		int index = custlist.indexOf(ecust);
		if (index == -1) {
			throw new CMSException("Invalid Email id not found");
		}
		System.out.println("Found Customer Details : ");
		System.out.println(custlist.get(index));
	}
	/*
	 * 3. Removal operation Remove all customer details from specified plan born
	 * after specified date. i/p : plan n date
	 */
	public static void removePlanDate(String splan, String sdate, List<Customer> custlist) {
	    ServicePlans plan = ServicePlans.valueOf(splan.toUpperCase());
	    LocalDate date = parseDate(sdate);
	    Iterator<Customer> itr = custlist.iterator();
	    while (itr.hasNext()) {
	        Customer customer = itr.next();
	        if (customer.getServicePlan().equals(plan) && customer.getDob().isAfter(date)) {
	            itr.remove();
	        }
	    }
	}


}
