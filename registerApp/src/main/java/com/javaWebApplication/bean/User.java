package com.javaWebApplication.bean;

import java.util.List;

public class User {
	private int id;
	private String fname;
	private String lname;
	private String dob;
	private String email;
	private String password;
	private String gender;
	private String lang;
	private String roll;
	/* private BufferedImage image; */
	
	private List<Address> address;
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	public int getId() {
		return id;	
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;	
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getDob()
	{
		return dob;
	}
	public void setDob(String dob) {
		this.dob=dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	
//	public String getAddressLine1() {
//		return addressLine1;
//	}
//	public void setAddressLine1(String addressLine1) {
//		this.addressLine1 = addressLine1;
//	}
//	public String getAddressLine2() {
//		return addressLine2;
//	}
//	public void setAddressLine2(String addressLine2) {
//		this.addressLine2 = addressLine2;
//	}
//	public String getCity() {
//		return city;
//	}
//	public void setCity(String city) {
//		this.city = city;
//	}
//	public String getState() {
//		return state;
//	}
//	public void setState(String state) {
//		this.state = state;
//	}
//	public String getPincode() {
//		return pincode;	
//	}
//	public void setPincode(String pincode) {
//		this.pincode = pincode;
//	}
//	public InputStream getImage() {
//	        return image;
//	}
//    public void setImage(InputStream image) {
//	        this.image = image;
//    }
    @Override
	public String toString() {
		return "User [ fname=" + fname + ", lname=" + lname + ", dob=" + dob + ", email=" + email
				+ ", password=" + password + ", gender=" + gender + ", lang=" + lang + ", roll=" + roll
				+ ",  getId()=" + getId() + ", getFname()="
				+ getFname() + ", getLname()=" + getLname() + ", getDob()=" + getDob() + ", getEmail()=" + getEmail()
				+ ", getPassword()=" + getPassword() + ", getGender()=" + getGender() + ", getLang()=" + getLang()
				+ ", getRoll()=" + getRoll() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	/*
	 * public BufferedImage getImage() { return image; }
	 * 
	 * public void setImage(BufferedImage image) { // TODO Auto-generated method
	 * stub this.image = image;
	 * 
	 * }
	 */
}
