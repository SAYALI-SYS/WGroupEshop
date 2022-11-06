package com.ecommerce.connectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ecommerce.methods.NewRegistration;
import com.ecommerce.project.CustomerRegistration;
import com.ecommerce.project.Login;
import com.ecommerce.project.Product;





public class Database {
	public void getCustomerDetailsIntoDb(CustomerRegistration customerRegistration) throws SQLException {
		try {
			ConnectionDemo databaseConnection = new ConnectionDemo();
			Connection connection = databaseConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into user_registration (user_fullname, user_address, user_emailid, user_mobileno, user_password,user_identifier) values ('"
							+ customerRegistration.getCust_fullName() + "','" + customerRegistration.getCust_address()
							+ "', '" + customerRegistration.getCust_emailId() + "',"
							+ customerRegistration.getCust_mobile_no() + ",'" + customerRegistration.getCust_password()
							+ "','C')");

			preparedStatement.execute();
			System.out.println("\nRegistration Successfull!\n");
		} catch (Exception e) {

			System.err.println("Database error!");
			NewRegistration newCustomerRegistration = new NewRegistration();
			newCustomerRegistration.setCustomerDetails();

	}


	}
	public int checkCustomerLogin(Login login) {

		int result;
		int userid = -1;
		try {

			ConnectionDemo databaseConnection = new ConnectionDemo();
			Connection connection = databaseConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select count(*), user_id  from "
					+ "user_registration where user_emailid ='" + login.getLogin_id() + "' and " + " user_password = '"
					+ login.getLogin_password() + "' and user_identifier = 'C';");
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			result = resultSet.getInt(1);
			userid = resultSet.getInt(2);
			if (result > 0) {
				return userid;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return userid;
	}
	public int checkAdminLogin(Login login) {

		int result;
		int userid = -1;
		try {

			ConnectionDemo databaseConnection = new ConnectionDemo();
			Connection connection = databaseConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select count(*), user_id  from "
					+ "user_registration where user_emailid ='" + login.getLogin_id() + "' and " + " user_password = '"
					+ login.getLogin_password() + "' and user_identifier = 'P';");
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			result = resultSet.getInt(1);
			userid = resultSet.getInt(2);
			if (result > 0) {
				return userid;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return userid;
	}
	public void storeOrderDetailsIntoDb(List<Product> listOfCartProduct, int userid) {
		try {
			ConnectionDemo databaseConnection = new ConnectionDemo();
			Connection connection = databaseConnection.getConnection();
			for (Product orderedData : listOfCartProduct) {
				PreparedStatement preparedStatement = connection
						.prepareStatement("insert into customer_order_history(cust_id, product_name,	product_price, "
								+ "product_quantity) values (" + userid + ",'" + orderedData.getProduct_name() + "',"
								+ orderedData.getProduct_price() + "," + orderedData.getProduct_quantity() + ")");

				preparedStatement.execute();

				PreparedStatement preparedStatement1 = connection
						.prepareStatement("update product_list set product_quantity= product_quantity-"
								+ orderedData.getProduct_quantity() + " where product_id="
								+ orderedData.getProduct_id());
				preparedStatement1.execute();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void getRegisteredCustomerDetails() {

		try {

			ConnectionDemo databaseConnection = new ConnectionDemo();
			Connection connection = databaseConnection.getConnection();

			PreparedStatement prepareStatement = connection
					.prepareStatement("select * from user_registration where user_identifier ='C' ");
			ResultSet resultSet = prepareStatement.executeQuery();
			if (resultSet.next() == true) {
				System.out.println(
						"===========================================================================================================================================================");
				System.out.println("User Id\t\tUser Name\tUser Address\t\t\tEmail Id\tUser Mobile Number");
				System.out.println(
						"===========================================================================================================================================================");

				do {

					System.out.println(
							"\n" + resultSet.getInt(1) + "\t\t" + resultSet.getString(2) + "\t" + resultSet.getString(3)
									+ "\t\t" + resultSet.getString(4) + "\t\t\t" + resultSet.getString(5));

				} while (resultSet.next());
			} else {
				System.out.println("No Customer is registered");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void getCustomerOrderDetails(int customerId) {

		try {

			ConnectionDemo databaseConnection = new ConnectionDemo();
			Connection connection = databaseConnection.getConnection();

			PreparedStatement prepareStatement = connection
					.prepareStatement("select * from customer_order_history where cust_id = " + customerId);
			ResultSet resultSet = prepareStatement.executeQuery();
			if (resultSet.next() == true) {
				System.out.println(
						"===========================================================================================================================================================");
				System.out.println("Customer Id\tSerial Number\tProduct Name\tProduct Price\tProduct Quantity");
				System.out.println(
						"===========================================================================================================================================================");

				do {

					System.out.println("\n" + resultSet.getInt(1) + "\t\t" + resultSet.getInt(2) + "\t"
							+ resultSet.getString(3) + "\t\t" + resultSet.getFloat(4) + "\t\t\t" + resultSet.getInt(5));

				} while (resultSet.next());
			} else {
				System.out.println("\nCustomer with Id " + customerId + " didn't buy anything till now");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
