package com.cognixia.jump.model;

import com.cognixia.jump.dao.CustomerDaoSQL;

public class Customer {
	
	private CustomerDaoSQL customerDaoSQL = new CustomerDaoSQL();
	
	private String name;
	private String address;
	private String number;
	private String id;
	private String password;
	private float initialDeposit;
	
	public Customer(String name, String address, String number, String id, String password, float initialDeposit) {
		super();
		this.name = name;
		this.address = address;
		this.number = number;
		this.id = id;
		this.password = password;
		this.initialDeposit = initialDeposit;
		
		customerDaoSQL.addCustomer(this);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public float getInitialDeposit() {
		return initialDeposit;
	}
	public void setInitialDeposit(float initialDeposit) {
		this.initialDeposit = initialDeposit;
	}
	
	@Override
	public String toString() {
		return "Customer Information:\nName: " + name + "\nAddress: " + address + "\nNumber: " + number + "\nid: " + id + "\nPassword: "
				+ password + "\nInitialDeposit: " + initialDeposit;
	}
	
}



