package com.javaWebApplication.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.javaWebApplication.bean.Address;
import com.javaWebApplication.bean.User;

public class MyDb implements MyDbInterface {
	public Connection con;

	public Connection genCon() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/signup", "root", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public void WriteData(User user) {
		MyDb db = new MyDb();
		Connection con = db.genCon();
		String users="user";
		ResultSet rs = null;
		String numberofkey = null;
		try {
			Statement stmt = con.createStatement();
			String sql1 = "insert into user(fname,lname,dob,email,password,gender,language,roll) values('"
					+ user.getFname() + "','" + user.getLname() + "','" + user.getDob() + "','" + user.getEmail()
					+ "','" + user.getPassword() + "','" + user.getGender() + "','" + user.getLang() + "','"+users+"')";
			stmt.executeUpdate(sql1,Statement.RETURN_GENERATED_KEYS);
			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				 numberofkey = rs.getString(1);
				System.out.println("Generated Emp Id: " + numberofkey);
			}
			for(Address add : user.getAddress())
			{
				String sql ="insert into address(a_id,addressLine1,addressLine2,city,state,pincode,id)values(?,?,?,?,?,?,?)";
				PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
				ps.setString(1, null);
				ps.setString(2, add.getAddressLine1());
				ps.setString(3, add.getAddressLine2());
				ps.setString(4, add.getCity());
				ps.setString(5, add.getState());
				ps.setString(6, add.getPincode());
				ps.setString(7,numberofkey);
				ps.executeUpdate();
			}
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	public void UploadImage(User user)
//	{
//		MyDb db = new MyDb();
//		Connection con = db.genCon();
//		try {
//			String sql = "INSERT INTO imgage (img) values (?)";
//            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
//            stmt.setBlob(1, user.getImage());
//		
//		} catch (SQLException e) 
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	public void UploadImage(User user) {
//		// TODO Auto-generated method stub
//		MyDb db = new MyDb();
//		Connection con = db.genCon();
//		try {
//			String sql = "INSERT INTO image (img) values (?)";
//            PreparedStatement stmt = con.prepareStatement(sql);
//            stmt.setBlob(1,user.getImage());
//		} catch (SQLException e) 
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public String readData(User user) {
		MyDb db = new MyDb();
		Connection con = db.genCon();
		ResultSet rs = null;		
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery("select email,password,roll from user where email='" + user.getEmail()+ "' and password='" + user.getPassword() + "'");
			while (rs.next()) {
				String rollDb = rs.getString("roll");
				
				if(rollDb.equals("user")) {
					return "user";
				}
				else {
					return "admin";
				}
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "failure";
	}
	public  ArrayList<User>  RetriveData()
	{
		ArrayList<User> dataList = new ArrayList<User>();
		MyDb db = new MyDb();
		Connection con = db.genCon();
		ResultSet rs = null;
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery("select * from user");
			while(rs.next()) 
			{
				User user = new User();
				user.setId(rs.getInt(1));
				user.setFname(rs.getString(2));
				user.setLname(rs.getString(3));
				user.setDob(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setPassword(rs.getString(6));
				user.setGender(rs.getString(7));
				user.setLang(rs.getString(8));
				dataList.add(user);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataList;
	}
	public ArrayList<Address> RetriveAddress(){
		ArrayList<Address> addresslist = new ArrayList<Address>();
		MyDb db = new MyDb();
		Connection con = db.genCon();
		ResultSet rs = null;
		
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery("select * from address");
			while(rs.next()) 
			{
				Address address = new Address();
				address.setAId(rs.getString(1));
				address.setAddressLine1(rs.getString(2));
				address.setAddressLine2(rs.getString(3));
				address.setCity(rs.getString(4));
				address.setState(rs.getString(5));
				address.setPincode(rs.getString(6));
				address.setId(rs.getString(7));
				addresslist.add(address);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return addresslist;
	}
	public User fetch(int id)
	{
		MyDb db = new MyDb();
		Connection con = db.genCon();
		ResultSet rs = null;
		User user = new User();
		try {
			 PreparedStatement stmt = con.prepareStatement("select * from user where id=?");
			 stmt.setLong(1,id);
			 rs = stmt.executeQuery();
			while(rs.next()) 
			{
				user.setId(rs.getInt(1));
				user.setFname(rs.getString(2));
				user.setLname(rs.getString(3));
				user.setDob(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setPassword(rs.getString(6));
				user.setGender(rs.getString(7));
				user.setLang(rs.getString(8));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return user;
	}
	public ArrayList<Address> fetchAddress(Address address){
		MyDb db = new MyDb();
		Connection con = db.genCon();
		ResultSet rs = null;
		ArrayList<Address> useraddress = new ArrayList<Address>();
		try {
			Statement stmt = con.createStatement();
            rs = stmt.executeQuery("select * from address where id='" + address.getId() + "'");
			while(rs.next()) 
			{
				Address address1 = new Address();
				address1.setAId(rs.getString(1));
				address1.setAddressLine1(rs.getString(2));
				address1.setAddressLine2(rs.getString(3));
				address1.setCity(rs.getString(4));
				address1.setState(rs.getString(5));
				address1.setPincode(rs.getString(6));
				address1.setId(rs.getString(7));
				useraddress.add(address1);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return useraddress;
	}
	public User  getEmployeeById(int id) {
		MyDb db = new MyDb();
		Connection con = db.genCon();
		ResultSet rs = null;
		User user = new User();
		try {
			 PreparedStatement stmt = con.prepareStatement("select * from user where id=?");
			 stmt.setInt(1,id);
			 rs = stmt.executeQuery();
			while(rs.next()) 
			{
				user.setId(rs.getInt(1));
				user.setFname(rs.getString(2));
				user.setLname(rs.getString(3));
				user.setDob(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setPassword(rs.getString(6));
				user.setGender(rs.getString(7));
				user.setLang(rs.getString(8));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return user;
	}
	public void update(User user) {
		MyDb db = new MyDb();
		Connection con = db.genCon();
		try {
			 PreparedStatement stmt = con.prepareStatement("update user set fname=?,lname=?,dob=?,password=?,language=?,gender=? where id=?");
			 stmt.setString(1,user.getFname());
			 stmt.setString(2,user.getLname());
			 stmt.setString(3,user.getDob());
			 stmt.setString(4,user.getPassword());
			 stmt.setString(5,user.getLang());	 
			 stmt.setString(6,user.getGender());
			 stmt.setInt(7,user.getId());
			 stmt.executeUpdate();
//			 for(Address add : user.getAddress())
//				{
//				 PreparedStatement ps = con.prepareStatement("update address set  addressLine1=?,addressLine2=?,city=?,state=?,pincode=? where a_id=?");
//					ps.setString(1, add.getAddressLine1());
//					ps.setString(2, add.getAddressLine2());
//					ps.setString(3, add.getCity());
//					ps.setString(4, add.getState());
//					ps.setString(5, add.getPincode());
//					ps.setString(6, add.getAId());
//					ps.executeUpdate();
//				}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public int delete(int id)
	{
		MyDb db = new MyDb();
		Connection con = db.genCon();
		int status=0;
		try {
			 PreparedStatement stmt = con.prepareStatement("delete from user where id=?");
			 stmt.setInt(1,id);
			 status=stmt.executeUpdate();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return status;
	}
	@Override
	public int id(User user) {
		MyDb db = new MyDb();
		Connection con = db.genCon();
		ResultSet rs = null;
		int id=0;
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery("select id from user where email='" + user.getEmail()+ "'");
			while (rs.next()) {
			 id = rs.getInt("id");	
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	@Override
	public ArrayList<Address> showAdd(User user) {
		// TODO Auto-generated method stub
		ArrayList<Address> showList = new ArrayList<Address>();
		MyDb db = new MyDb();
		Connection con = db.genCon();
        ResultSet rs = null;

        try {
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("select * from address where id='" + user.getId() + "'");
            while (rs.next()) {

                Address add1 = new Address();
                add1.setAId(rs.getString(1));
                add1.setAddressLine1(rs.getString(2));
                add1.setAddressLine2(rs.getString(3));
                add1.setCity(rs.getString(4));
                add1.setState(rs.getString(5));
                add1.setPincode(rs.getString(6));
                add1.setId(rs.getString(7));
                showList.add(add1);
                
                System.out.println(showList);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return showList;
	}
	@Override
	public void deleteAddress(String removeId) {
		// TODO Auto-generated method stub
		MyDb db = new MyDb();
		Connection con = db.genCon();
        try {
            Statement stmt = con.createStatement();

            String sql = "delete from  address " + "WHERE a_id ='" + removeId + "' ";

            stmt.executeUpdate(sql);
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	@Override
	public void addNewAddress(User addNewAddress) {
		// TODO Auto-generated method stub
		MyDb db = new MyDb();
		Connection con = db.genCon();
        List<Address> count = addNewAddress.getAddress();
        
        System.out.println(count.size());
	    for(int i=0;i<count.size();i++)
	    {
	      try {
				String sql ="insert into address(a_id,addressLine1,addressLine2,city,state,pincode,id)values(?,?,?,?,?,?,?)";
				PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
				ps.setString(1, null);
				ps.setString(2, count.get(i).getAddressLine1());
				ps.setString(3, count.get(i).getAddressLine2());
				ps.setString(4, count.get(i).getCity());
				ps.setString(5, count.get(i).getState());
				ps.setString(6, count.get(i).getPincode());
				ps.setString(7,	count.get(i).getId());
				ps.executeUpdate();
			}
        catch (SQLException e) 
    		{
                e.printStackTrace();
            }

    	}
	}
	@Override
	public void updateAddress(User user) {
		// TODO Auto-generated method stub
		MyDb db = new MyDb();
		Connection con = db.genCon();
        List<Address> count = user.getAddress();
        
        System.out.println(count.size());
        for (int i = 0; i < count.size(); i++) {
            String sql = "update address set  addressLine1=?,addressLine2=?,city=?,state=?,pincode=? where a_id='"+count.get(i).getAId()+"'";

            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, count.get(i).getAddressLine1());
				ps.setString(2, count.get(i).getAddressLine2());
				ps.setString(3, count.get(i).getCity());
				ps.setString(4, count.get(i).getState());
				ps.setString(5, count.get(i).getPincode());
                ps.executeUpdate();
            } 
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}
	@Override
	public User forgetPassword(User user) {
		// TODO Auto-generated method stub
		
		 	MyDb db = new MyDb();
			Connection con = db.genCon();
	        
			ResultSet rs = null;
	        Statement stmt = null;
	        User forgotpassword = new User();

	        try {
	            stmt = con.createStatement();
	            rs = stmt.executeQuery("select * from user where email='" + user.getEmail() + "'");
	            while (rs.next()) {
	            	
	                forgotpassword.setEmail(rs.getString(5));
	                forgotpassword.setPassword(rs.getString(6));

	            }

	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return forgotpassword;
	}
}