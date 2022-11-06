package com.ecommerce.methods;

import java.util.Scanner;



public class Login {
	Login login = new Login();
	Scanner scanner = new Scanner(System.in);

	public void adminLogin() {
		System.out.println("Admin Id :");
		scanner.nextInt();
		System.out.println("Admin Password :");
		scanner.next();

	}

}