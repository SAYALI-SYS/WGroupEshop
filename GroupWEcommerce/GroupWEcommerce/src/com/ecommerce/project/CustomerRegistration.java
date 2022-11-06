package com.ecommerce.project;

public class CustomerRegistration {
	String cust_fullName;
	String cust_address;
	String cust_emailId;
	long cust_mobile_no;
	String cust_password;
	String cust_re_enter_password;

	public String getCust_fullName() {
		return cust_fullName;
	}

	public void setCust_fullName(String cust_fullName) {
		this.cust_fullName = cust_fullName;
	}

	public String getCust_address() {
		return cust_address;
	}

	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}

	public String getCust_emailId() {
		return cust_emailId;
	}

	public void setCust_emailId(String cust_emailId) {
		this.cust_emailId = cust_emailId;
	}

	public long getCust_mobile_no() {
		return cust_mobile_no;
	}

	public void setCust_mobile_no(long cust_mobile_no) {
		this.cust_mobile_no = cust_mobile_no;
	}

	public String getCust_password() {
		return cust_password;
	}

	public void setCust_password(String cust_password) {
		this.cust_password = cust_password;
	}

	public String getCust_re_enter_password() {
		return cust_re_enter_password;
	}

	public void setCust_re_enter_password(String cust_re_enter_password) {
		this.cust_re_enter_password = cust_re_enter_password;
	}

	@Override
	public String toString() {
		return "UserRegistration [cust_fullName=" + cust_fullName + ", cust_address=" + cust_address + ", cust_emailId="
				+ cust_emailId + ", cust_mobile_no=" + cust_mobile_no + ", cust_password=" + cust_password
				+ ", cust_re_enter_password=" + cust_re_enter_password + "]";
	}

}
