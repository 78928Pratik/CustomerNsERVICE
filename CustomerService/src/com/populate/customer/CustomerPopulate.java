package com.populate.customer;

import com.core.customer.*;
import com.exception.customer.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerPopulate {

	public static List<Customer> populate() {
		List<Customer> custList = new ArrayList<Customer>();
		Customer c1 = new Customer("Pratik", "Bhadale", "pratik@123", "password123", 2000,
				LocalDate.parse("2001-04-04"), ServicePlans.GOLD);
		Customer c2 = new Customer("Jayesh", "Rathi", "jayesh@123", "password123", 5000, LocalDate.parse("2001-08-05"),
				ServicePlans.DIAMOND);
		Customer c3 = new Customer("Sammer", "Sinha", "sameer@123", "password123ayesh@123", 10000,
				LocalDate.parse("2001-03-13"), ServicePlans.PLATUNUM);
		Customer c4 = new Customer("Sarthak", "Khade", "Sarthal@123", "jayesh@123", 1000, LocalDate.parse("2001-04-04"),
				ServicePlans.SILVER);
		Customer c5 = new Customer("Sarthak", "Khade", "bruh@123", "jayesh@123", 1000, LocalDate.parse("2001-04-04"),
				ServicePlans.SILVER);
		Customer c6 = new Customer("Sarthak", "Khade", "mero@123", "jayesh@123", 1000, LocalDate.parse("2001-04-04"),
				ServicePlans.SILVER);
		
		Customer[] custArry= {c1,c2,c3,c4,c5,c6};
		
		for(Customer a : custArry) {
			custList.add(a);
		}

		return custList;

	}

}
