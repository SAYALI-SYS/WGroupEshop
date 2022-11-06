
package com.ecommerce.methods;

import java.util.Scanner;

import com.ecommerce.connectivity.Database;
import com.ecommerce.project.Login;



public class CustomerLogin {
	Login login = new Login();
	Database databaseImpl = new Database();
	ProductPage productListPage = new ProductPage();
	Scanner scanner = new Scanner(System.in);
	int userid;

	public void getCustomerLogin() {
		System.out.println("\n================================ Customer Login ================================");
		System.out.print("Email Id :");
		login.setLogin_id(scanner.next());
		System.out.print("Password :");
		login.setLogin_password(scanner.next());
		try {
			Database data = new Database();
			userid = data.checkCustomerLogin(login);
			if (userid > 0) {

				productListPage.getProductListFromDb(userid);
			} else {
				System.err.println("Invalid credentials");
				getCustomerLogin();
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void getAdminLogin() {
		System.out.println("\n================================= Admin Login ==================================");
		Admin adminMenuPage = new Admin();
		System.out.print("Email Id :");
		login.setLogin_id(scanner.next());
		System.out.print("Password :");
		login.setLogin_password(scanner.next());
		try {
			Database DatabaseImpl = new Database();
			userid = DatabaseImpl.checkAdminLogin(login);
			if (userid > 0) {

				adminMenuPage.adminPage();
			} else {
				System.out.println("Invalid credentials");
				getAdminLogin();
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	
	}
}