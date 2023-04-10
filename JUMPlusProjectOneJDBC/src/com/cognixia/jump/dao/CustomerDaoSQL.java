package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.model.Customer;

public class CustomerDaoSQL implements CustomerDao {
	
	private Connection conn = ConnectionManager.getConnection();

	@Override
	public Customer getCustomerByID(String accountID) {
		
		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM customer WHERE id = ?");
			pstmt.setString(1, accountID);
			
			ResultSet rs = pstmt.executeQuery();
			
			System.out.println(rs.first());
			
			String name = rs.getString("name");
			String address = rs.getString("address");
			String number = rs.getString("number");
			String id = rs.getString("id");
			String password = rs.getString("password");
			float initialDeposit = rs.getFloat("initialDeposit");
			
			Customer customer = new Customer(name, address, number, id, password, initialDeposit);
			
			return customer;
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Customer with id = " + accountID + " not found.");
		}
		
		return null;
	}

	@Override
	public boolean addCustomer(Customer customer) {
		try {
		PreparedStatement pstmt = conn.prepareStatement("INSERT into customer(name, address, number, id, password, initialDeposit) values(?, ?, ?, ?, ?, ?)");
		pstmt.setString(1, customer.getName()); // TODO: test!!!
		pstmt.setString(2, customer.getAddress());
		pstmt.setString(3, customer.getNumber());
		pstmt.setString(4, customer.getId());
		pstmt.setString(5, customer.getPassword());
		pstmt.setFloat(6, customer.getInitialDeposit());
		
		int i = pstmt.executeUpdate();
		
		if(i > 0) {
			return true;
		}	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
		return false;
	}
}
