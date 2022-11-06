package com.ecommerce.methods;

import java.util.List;
import java.util.Scanner;

import com.ecommerce.connectivity.Database;
import com.ecommerce.project.Product;



public class Checkout {
	Database databaseImpl = new Database();
	Homepage homepage = new Homepage();
	ProductPage productListPage = new ProductPage();
	Scanner scanner = new Scanner(System.in);
	int placeOrder;

	public void checkOut(List<Product> listOfCartProduct, int userid) {
		if (listOfCartProduct.size() > 0) {
			System.out.println("1. Place Order");
			System.out.println("2. Cancel Order");
			placeOrder = scanner.nextInt();
			if (placeOrder == 1) {
				confirmCheckOut(listOfCartProduct, userid);

			} else if (placeOrder == 2) {
				listOfCartProduct.clear();
				productListPage.clearCartList();
				homepage.homepageDisplay();

			} else {
				System.err.println("Invalid Option");
				checkOut(listOfCartProduct, userid);
			}
		} else {
			System.out.println("You didn't buy Anything..");
			homepage.homepageDisplay();
		}

	}

	public void confirmCheckOut(List<Product> listOfCartProduct, int userid) {
		displayCartDetails(listOfCartProduct);
		System.out.println("1. Confirm");
		System.out.println("2. Cancel Order");
		placeOrder = scanner.nextInt();
		if (placeOrder == 1) {

			databaseImpl.storeOrderDetailsIntoDb(listOfCartProduct, userid);
			listOfCartProduct.clear();
			productListPage.clearCartList();
			System.out.println("Order placed Successfuly!");
			homepage.homepageDisplay();

		} else if (placeOrder == 2) {
			listOfCartProduct.clear();
			productListPage.clearCartList();
			System.out.println("Order Cancelled");
			homepage.homepageDisplay();

		} else {
			System.err.println("Invalid Option");
			confirmCheckOut(listOfCartProduct, userid);
		}

	}

	public void displayCartDetails(List<Product> listOfCartProduct) {
		float total = 0;
		System.out.println("=============================== Ordered Products ===============================");
		for (Product product : listOfCartProduct) {
			System.out.println("\n" + product.getProduct_id() + "\t" + product.getProduct_name() + "\t"
					+ product.getProduct_quantity() + "\t" + product.getProduct_price() + "\n");

			total = total + product.getProduct_price() * product.getProduct_quantity();
		}

		System.out.println("Total Amount :" + total);
	}

}