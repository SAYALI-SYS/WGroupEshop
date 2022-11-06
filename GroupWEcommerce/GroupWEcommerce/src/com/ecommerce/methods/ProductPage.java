package com.ecommerce.methods;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.ecommerce.connectivity.ConnectionDemo;
import com.ecommerce.project.Product;


public class ProductPage {
	Scanner scanner = new Scanner(System.in);
	Map<Integer, Product> map = new HashMap<>();
	List<Product> listOfCartProduct = new ArrayList<Product>();

	public void clearCartList() {
		listOfCartProduct.clear();
	}

	public void getProductListFromDb(int userid) {

		try {
			ConnectionDemo databaseConnection = new ConnectionDemo();
			Connection connection = databaseConnection.getConnection();
			System.out.println(
					"===========================================================================================================================================================");
			System.out.println("Product Id\tProduct Name\tProduct Price\tProduct Quantity\t\t\tProduct Description");
			System.out.println(
					"===========================================================================================================================================================");
			PreparedStatement prepareStatement = connection
					.prepareStatement("select * from product_list order by product_name");
			ResultSet resultSet = prepareStatement.executeQuery();

			while (resultSet.next()) {
				Product product = new Product();
				product.setProduct_id(resultSet.getInt(1));
				product.setProduct_name(resultSet.getString(2));
				product.setProduct_price(resultSet.getFloat(3));
				product.setProduct_quantity(resultSet.getInt(4));
				product.setProduct_description(resultSet.getString(5));
				System.out.println("\n" + resultSet.getInt(1) + "\t\t" + resultSet.getString(2) + "\t"
						+ resultSet.getFloat(3) + "\t\t" + resultSet.getInt(4) + "\t\t\t" + resultSet.getString(5));

				map.put(resultSet.getInt(1), product);
			}

			System.out.println(
					"............................................................................................................................................................");
			customerInputs(userid);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	public void customerInputs(int userid) {
		Product product = null;
		int selectProduct;
		do {

		
			System.out.print("Enter Product Id or Press 0 to check out/Exit :");
			selectProduct = scanner.nextInt();

			product = map.get(selectProduct);

			if (product != null) {
				System.out.print("Enter Quantity :");
				product.setProduct_quantity(scanner.nextInt());
				System.out.println("Product " + product.getProduct_name() + " Qty " + product.getProduct_quantity()
						+ " added to cart\n");
				listOfCartProduct.add(product);

			} else if (selectProduct != 0) {
				System.err.println("Invalid Product Id");

			}

		} while (selectProduct != 0);
		Checkout checkout = new Checkout();
		checkout.checkOut(listOfCartProduct, userid);

	}

	public void getProductQuantityDetails(int productId) {

		try {
			ConnectionDemo databaseConnection = new ConnectionDemo();
			Connection connection = databaseConnection.getConnection();
			PreparedStatement prepareStatement = connection
					.prepareStatement("select * from product_list where product_id = " + productId);
			ResultSet resultSet = prepareStatement.executeQuery();
			if (resultSet.next() == true) {
				System.out.println(
						"===========================================================================================================================================================");
				System.out
						.println("Product Id\tProduct Name\tProduct Price\tProduct Quantity\t\t\tProduct Description");
				System.out.println(
						"===========================================================================================================================================================");

				System.out.println("\n" + resultSet.getInt(1) + "\t\t" + resultSet.getString(2) + "\t"
						+ resultSet.getFloat(3) + "\t\t" + resultSet.getInt(4) + "\t\t\t" + resultSet.getString(5));

			} else {
				System.err.println("Invalid Product Id");

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}



