package com.Webapplication.service;

import java.util.ArrayList;

import com.javaWebApplication.bean.Address;
import com.javaWebApplication.bean.User;


public interface SerInt {
	
	public void doGet(User user);
	public String login(User user);
	public ArrayList<User> RetriveData();
	public User fetch(int id);
	public User getEmployeeById(int id);
	public void update(User user);
	public int id(User user);
	public ArrayList<Address> RetriveAddress();
	public ArrayList<Address> fetchAddress(Address address);
	public ArrayList<Address> showAdd(User user);
	public void deleteAddress(String removeId);
	public void addNewAddress(User addNewAddress);
	public void updateAddress(User user);
	public User forgetPassword(User user);
}
