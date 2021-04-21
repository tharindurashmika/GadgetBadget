package model;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Funding_Posts {
	private Connection connect()
	{
		Connection con=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			//Provide Correct Database Details
			con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/test_", "root", "");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}
	
	public String createPost(String title,String content) {
		String output="";
		
		try {
			Connection con=connect();
			
			if(con==null)
			{
				return "Error";
			}
			LocalDate date= LocalDate.now();
			LocalTime time= LocalTime.now();
			String  query= "insert into Funding_Bodies_Post(title,content,published_date,published_time)"
							+
							" values(?,?,?,?) ";
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setString(1, title);
			ps.setString(2, content);
			ps.setString(3, date.toString());
			ps.setString(4, time.toString());
			
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
			output="<table><tr><th>Post ID</th><th>Post Title</th><th>Content</th><th>Published Date</th><th>Published Time</th><th>Update</th><th>Remove</th></tr>";
			String query="select * from Funding_Bodies_Post";
			Statement st= con.createStatement();
			ResultSet rs= st.executeQuery(query);
			
			while(rs.next())
			{
				String Post_id= Integer.toString(rs.getInt("id"));
				String Post_title= rs.getString("title");
				String content = rs.getString("content");
				String date = rs.getString("");// How to Get Date as A String - Doubt
				String time = rs.getString("");// How to Get Date as A String - Doubt
				
				output +="<tr><td>"+Post_id+"</td>";
				output +="<tr><td>"+Post_title+"</td>";
				output +="<tr><td>"+content+"</td>";
				output +="<tr><td>"+date+"</td>";
				output +="<tr><td>"+time+"</td>";
				
				output +="<td><input name=\\\"btnUpdate\\\" type=\\\"button\\\" \r\n" + 
						" value=\\\"Update\\\" class=\\\"btn btn-secondary\\\"></td>\"\r\n" + 
						" + \"<td><form method=\\\"post\\\" action=\\\"posts.jsp\\\">\"\r\n" + 
						" + \"<input name=\\\"btnRemove\\\" type=\\\"submit\\\" value=\\\"Remove\\\" \r\n" + 
						" class=\\\"btn btn-danger\\\">\"\r\n" + 
						" + \"<input name=\\\"id\\\" type=\\\"hidden\\\" value=\\\"\" + id\r\n" + 
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
	
	
	public String updatePost(String ID,String title,String content) 
	 { 
	 String output = ""; 
	 try
	 { 
	 Connection con = connect(); 
	 if (con == null) 
	 {return "Error while connecting to the database for updating."; } 
	 // create a prepared statement
	 LocalDate date= LocalDate.now();
	 LocalTime time= LocalTime.now();
	 String query = "UPDATE Funding_Bodies_Post SET title=?,content=?,published_date=?,published_time=? WHERE id=?"; 
	 PreparedStatement preparedStmt = con.prepareStatement(query); 
	 // binding values
	 preparedStmt.setString(1, title); 
	 preparedStmt.setString(2, content); 
	 preparedStmt.setString(3, date.toString()); 
	 preparedStmt.setString(4, time.toString()); 
	 preparedStmt.setInt(5, Integer.parseInt(ID)); 
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
	 String query = "delete from Funding_Bodies_Post where id=?"; 
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
