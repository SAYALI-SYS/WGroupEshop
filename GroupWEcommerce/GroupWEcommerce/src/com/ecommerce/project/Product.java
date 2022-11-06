package com.ecommerce.project;

public class Product {
	int product_id;
	String product_name;
	float product_price;
	int product_quantity;
	String product_description;
	int cust_inserted_qty;

	public int getCust_inserted_qty() {
		return cust_inserted_qty;
	}

	public void setCust_inserted_qty(int cust_inserted_qty) {
		this.cust_inserted_qty = cust_inserted_qty;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public float getProduct_price() {
		return product_price;
	}

	public void setProduct_price(float product_price) {
		this.product_price = product_price;
	}

	public int getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}

	public String getProduct_description() {
		return product_description;
	}

	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", product_price="
				+ product_price + ", product_quantity=" + product_quantity + ", product_description="
				+ product_description + ", cust_inserted_qty=" + cust_inserted_qty + "]";
	}

}