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

import model.AdminManage;

@Path("/Admin")
public class AdminManageService {
	AdminManage rp_obj=new AdminManage();
	
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
			@FormParam("Fname") String name,
			@FormParam("Ffield") String field,
			@FormParam("Frange") String range) {
		String output= rp_obj.createPost(name, field, range); 
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
		
		String ID = postObj.get("Fid").getAsString();
		String name = postObj.get("Fname").getAsString();
		String field = postObj.get("Ffield").getAsString();
		String range = postObj.get("Frange").getAsString();

		
		
		String output=rp_obj.updatePost(ID, name, field,range);
		
		return output;
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteItem(String itemData)
	{
		Document doc= Jsoup.parse(itemData,"",Parser.xmlParser());
		
		String ID=doc.select("id").text();
		
		String output=rp_obj.deletePost(ID);
		return output;
	}
}
