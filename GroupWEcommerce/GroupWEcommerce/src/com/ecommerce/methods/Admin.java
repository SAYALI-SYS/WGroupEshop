package com.ecommerce.methods;

import java.util.Scanner;

import com.ecommerce.connectivity.Database;

public class Admin {
	Scanner sc = new Scanner(System.in);

	public void adminPage() {
		int homepageOption;
		do {
			System.out.println("\n==================================== Admin =====================================\n");
			System.out.println("1. Check Quantity of each Product");
			System.out.println("2. Registered Customer List");
			System.out.println("3. Customer Purchased History Details");
			System.out.println("4. Back to HomePage");
			System.out.println(".................................................................................");
			homepageOption = sc.nextInt();
			System.out.println("Option Selected :" + homepageOption);
			System.out.println("=================================================================================");
			if (homepageOption == 1 || homepageOption == 2 || homepageOption == 3 || homepageOption == 4) {
				switch (homepageOption) {
				case 1:
					getProductDetails();
					break;
				case 2:
					getCustomerDetails();

					break;
				case 3:
					getCustomerOrderHistory();

					break;
				case 4:
					break;
				default:
				}
			} else {
				System.out.println("Invalid Selection...");
			}

		} while (homepageOption != 4);

	}

	public void getProductDetails() {
		int productId;
		ProductPage productListPage = new ProductPage();

		System.out.print("\nEnter Product Id to Get the Details :");
		productId = sc.nextInt();
		productListPage.getProductQuantityDetails(productId);

	}

	public void getCustomerDetails() {
		
		Database databaseImpl = new Database();
		

		System.out.println("\n========================== Registered customer Details ========================");
		databaseImpl.getRegisteredCustomerDetails();
	}

	public void getCustomerOrderHistory() {
		int customerId;

		System.out.print("\nEnter Customer id to get Order History Details :");
		customerId = sc.nextInt();
		Database databaseImpl = new Database();
		databaseImpl.getCustomerOrderDetails(customerId);
	}
}
