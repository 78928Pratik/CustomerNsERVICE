package com.cms.customer;

import static com.populate.customer.CustomerPopulate.populate;
import java.util.Comparator;
import java.util.Collection;
import java.util.Collections;
import java.security.Policy;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;
import com.core.customer.*;

import static com.exception.customer.CustomerValidation.*;
import static com.exception.customer.CMSException.*;

public class CMSApplication {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			boolean exit = false;

			List<Customer> customerList = populate();// size : 0 , init cap 10

			while (!exit) {
				System.out.println("Options : 1. Customer Sign Up \n2. Display all \n3.Login Page \n4.Change Password"
						+ "\n5.Delet Customer Details\n6.Sorting as per Email\n7.Sorting as per DOB and Last name (anonymous) "
						+ "\n8.Remove Customer as per plan and DOB \n0. Exit");
				System.out.println("Choose");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println(
								"Enter customer details : firstName,  lastName,  email,  password,regAmount,  dob,  plan");
						Customer customer = validateCustomerInputs(sc.next(), sc.next(), sc.next(), sc.next(),
								sc.nextDouble(), sc.next(), sc.next(), customerList);

						customerList.add(customer);
						System.out.println("customer registered....");
						break;
					case 2:
						System.out.println("Display All");
						/*
						 * Iterator<Customer> itr=customerList.iterator(); while(itr.hasNext()) {
						 * System.out.println(itr.next()); }
						 */

						for (Customer c : customerList) {
							System.out.println(c);
						}

						break;
					case 3:
						System.out.println("Enter email and password");
						// signup(sc.next(), sc.next(), customerList);
						customer = mdSignUp(sc.next(), sc.next(), customerList);
						System.out.println("Displaying Login Customer\n" + customer);
						break;
					case 4:
						System.out.println("Change password : ");
						customer = mdSignUp(sc.next(), sc.next(), customerList);
						System.out.println("Enter new Pasword");
						customer.setPassword(sc.next());
						System.out.println("Password Changed Successfully");

						break;
					case 5:
						System.out.println("Enter E-mail and Password to un-Subscribe");
						customer = mdSignUp(sc.next(), sc.next(), customerList);
						// I got
						System.out.println("Removing " + customer + customerList.remove(customer));
						break;

					case 6:
						System.out.println("Sorting As per email ");
						// Sort by email id (primary key)
						Collections.sort(customerList);

						break;
					case 7:
						System.out.println("Sorting as per DOB and Last name (anonymous) ");
						Collections.sort(customerList, new CustomerDobLastname());
						break;
					/*
					 * 3. Removal operation Remove all customer details from specified plan born
					 * after specified date. i/p : plan n date
					 */

					case 8:
						System.out.println("Enter Plan And Date ");
						removePlanDate(sc.next(), sc.next(), customerList);
						break;

					case 0:
						exit = true;
						break;
					}
				} catch (Exception e) {
					sc.nextLine();
					System.out.println(e);// toString
				}
			}
		}

	}

}
