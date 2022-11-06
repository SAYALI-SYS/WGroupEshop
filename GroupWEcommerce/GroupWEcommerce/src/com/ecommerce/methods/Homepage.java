package com.ecommerce.methods;

import java.util.Scanner;


public class Homepage {

	Scanner sc = new Scanner(System.in);

	public void homepageDisplay() {

		int homepage;
		do {
			System.out.println("============================= Welcome to eCommerce =============================\n");
			System.out.println("1. New Customer Registration");
			System.out.println("2. Customer Login");
			System.out.println("3. Admin Login");
			System.out.println("4. Exit");
			System.out.println("................................................................................");
			homepage = sc.nextInt();
			System.out.println("Option Selected :" +homepage);
			if (homepage== 1 || homepage == 2 || homepage == 3 || homepage == 4) {
				switch (homepage) {
				case 1:
					 NewRegistration newCustomerRegistration = new NewRegistration();
					 newCustomerRegistration.setCustomerDetails();
					break;
				case 2:
					CustomerLogin customerLogin = new CustomerLogin();
					customerLogin.getCustomerLogin();
					break;
				case 3:
					CustomerLogin adminLogin = new CustomerLogin();
					adminLogin.getAdminLogin();
					break;
				case 4:
					System.exit(0);
					break;
				default:
				}
			} else {
				System.err.println("Enter valid option\n");
			}
		} while (homepage > 4);

	}

}