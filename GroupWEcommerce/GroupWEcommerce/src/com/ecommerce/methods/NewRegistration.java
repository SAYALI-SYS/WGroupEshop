package com.ecommerce.methods;

import java.util.Scanner;

import com.ecommerce.connectivity.Database;
import com.ecommerce.project.CustomerRegistration;

public class NewRegistration {
	Scanner sc = new Scanner(System.in);

	public void setCustomerDetails() {
		System.out.println("\n============================ Customer Registration =============================");
		CustomerRegistration cst = new CustomerRegistration();
		System.out.print("Full Name :");
		cst.setCust_fullName(sc.nextLine());
		System.out.print("Address :");
		cst.setCust_address(sc.nextLine());
		System.out.print("Email Id :");
		cst.setCust_emailId(sc.nextLine());
		System.out.print("Mobile No. :");
		cst.setCust_mobile_no(sc.nextLong());
		System.out.print("Password :");
		cst.setCust_password(sc.next());
		try {
			Database DatabaseImpl = new Database();
			DatabaseImpl.getCustomerDetailsIntoDb(cst);
			Homepage homepage = new Homepage();
			homepage.homepageDisplay();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
