package model;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class AdminManage {

	
	private Connection connect()
	{
		Connection con=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			//Provide Correct Database Details
			con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3310/test?useTimezone=true&serverTimezone=UTC", "root", "");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}
	
	public String createPost(String name,String field,String range) {
		String output="";
		
		try {
			Connection con=connect();
			
			if(con==null)
			{
				return "Error";
			}
			//Date date=new Date();
			//java.sql.Date sqldate=new java.sql.Date(date.getDate());
			//java.sql.Date sqltime=new java.sql.Date(date.getTime());
			
			LocalDate date= LocalDate.now();
			LocalTime time= LocalTime.now();
			
			
			String  query= "Insert into funding_bodies(name,field,ranges,published_date,published_time) values(?,?,?,?,?) ";
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setString(1,name);
			ps.setString(2,field);
			ps.setString(3,range);
			ps.setString(4,date.toString());
			ps.setString(5,time.toString());
			ps.execute();
			con.close();
			
			output="Insert Success";
		}
		catch (Exception e) {
			// TODO: handle exception
			output="Error while inserting the Item";
			System.err.println(e.getMessage());
		}
		
		return output;
	}
	public String read_Post() {
		String output="";
		
		try {
			Connection con=connect();
			
			if(con==null)
			{
				return "Error";
			}
			output="<table><tr><th>Funding Body ID</th><th>name</th><th>field</th><th>range</th><th>Published Date</th><th>Published Time</th><th>Update</th><th>Remove</th></tr>";
			String query="select * from funding_bodies";
			Statement st= con.createStatement();
			ResultSet rs= st.executeQuery(query);
			
			while(rs.next())
			{
				String id= Integer.toString(rs.getInt("id"));
				String name= rs.getString("name");
				String field = rs.getString("field");
				String range = rs.getString("ranges");
				String date = rs.getString("published_date");// How to Get Date as A String - Doubt - Solved 2021/04/11
				String time = rs.getString("published_time");// How to Get Date as A String - Doubt - Solved 2021/04/11
				
				output +="<tr><td>"+id+"</td>";
				output +="<td>"+name+"</td>";
				output +="<td>"+field+"</td>";
				output +="<td>"+range+"</td>";
				output +="<td>"+date+"</td>";
				output +="<td>"+time+"</td>";
				
				output +="<td><input name=\\\"btnUpdate\\\" type=\\\"button\\\" \r\n" + 
						" value=\\\"Update\\\" class=\\\"btn btn-secondary\\\"></td>\"\r\n" + 
						" + \"<td><form method=\\\"post\\\" action=\\\"posts.jsp\\\">\"\r\n" + 
						" + \"<input name=\\\"btnRemove\\\" type=\\\"submit\\\" value=\\\"Remove\\\" \r\n" + 
						" class=\\\"btn btn-danger\\\">\"\r\n" + 
						" + \"<input name=\\\"ID\\\" type=\\\"hidden\\\" value=\\\"\" + id\r\n" + 
						" + \"\\\">\" + \"</form></td></tr>";
				
			}
			con.close();
			output+="</tabel>";
		} catch (Exception e) {
			// TODO: handle exception
			output="Error while reading the Posts";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	
	public String updatePost(String ID,String name,String field, String range) 
	 { 
	 String output = ""; 
	 try
	 { 
	 Connection con = connect(); 
	 if (con == null) 
	 {return "Error while connecting to the database for updating."; } 
	 // create a prepared statement
	 
	 //	Calendar cal=Calendar.getInstance();
	 //	cal.add(field, amount);
	 //	Date date=new Date();
	 //	java.sql.Date sqldate=new java.sql.Date(date.getDate());
	 //	java.sql.Date sqltime=new java.sql.Date(date.getTime());
	 
		LocalDate date= LocalDate.now();
		LocalTime time= LocalTime.now();
	 
	 String query = "UPDATE funding_bodies SET name=?,field=?,ranges=?,published_date=?,published_time=? WHERE id=?"; 
	 PreparedStatement preparedStmt = con.prepareStatement(query); 
	 // binding values
	 preparedStmt.setString(1, name); 
	 preparedStmt.setString(2, field);
	 preparedStmt.setString(3, range);
	 preparedStmt.setString(4, date.toString()); 
	 preparedStmt.setString(5, time.toString()); 
	 preparedStmt.setInt(6, Integer.parseInt(ID)); 
	 // execute the statement
	 preparedStmt.execute(); 
	 con.close(); 
	 output = "Updated successfully"; 
	 } 
	 catch (Exception e) 
	 { 
	 output = "Error while updating the item."; 
	 System.err.println(e.getMessage()); 
	 } 
	 return output; 
	 } 
	
	
	
	public String deletePost(String ID) 
	 { 
	 String output = ""; 
	 try
	 { 
	 Connection con = connect(); 
	 if (con == null) 
	 {return "Error while connecting to the database for deleting."; } 
	 // create a prepared statement
	 String query = "delete from funding_bodies where id=?"; 
	 PreparedStatement preparedStmt = con.prepareStatement(query); 
	 // binding values
	 preparedStmt.setInt(1, Integer.parseInt(ID)); 
	 // execute the statement
	 preparedStmt.execute(); 
	 con.close(); 
	 output = "Deleted successfully"; 
	 } 
	 catch (Exception e) 
	 { 
	 output = "Error while deleting the item."; 
	 System.err.println(e.getMessage()); 
	 } 
	 return output; 
	 }
	
}
