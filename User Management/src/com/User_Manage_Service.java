package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.User_Manage;

@Path("/User")
public class User_Manage_Service {
	User_Manage rp_obj = new User_Manage();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readPosts()
	{
		return rp_obj.read_Post();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String createPost(
			@FormParam("Uname") String name,
			@FormParam("Upassword") String password) {
		String output= rp_obj.createPost(name, password); 
				return output;
	}
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateItem(String postData)
	{
		//Convert the input string to a JSON object
		JsonObject postObj = new JsonParser().parse(postData).getAsJsonObject();
		
		String ID = postObj.get("Uid").getAsString();
		String name = postObj.get("Uname").getAsString();
		String password = postObj.get("Upassword").getAsString();


		
		
		String output=rp_obj.updatePost(ID, name, password);
		
		return output;
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteItem(String itemData)
	{
		Document doc= Jsoup.parse(itemData,"",Parser.xmlParser());
		
		String ID=doc.select("iduser").text();
		
		String output=rp_obj.deletePost(ID);
		return output;
	}
}
