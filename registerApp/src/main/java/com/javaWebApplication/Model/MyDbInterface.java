package com.javaWebApplication.Model;


import java.util.ArrayList;

import com.javaWebApplication.bean.Address;
import com.javaWebApplication.bean.User;

public interface MyDbInterface
{
	void WriteData( User user);
	String readData(User user);
	ArrayList<User>  RetriveData();
	User getEmployeeById(int id);
	void update(User user);
	int delete(int id);
	User fetch(int id);
//	void UploadImage(User user);
	int id(User user);
	ArrayList<Address> RetriveAddress();
	ArrayList<Address> fetchAddress(Address address);
	ArrayList<Address> showAdd(User user);
	void deleteAddress(String removeId);
	void addNewAddress(User addNewAddress);
	void updateAddress(User user);
	User forgetPassword(User user);
}
