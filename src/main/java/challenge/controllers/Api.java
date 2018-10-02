package challenge.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import challenge.entity.URL;
import challenge.repository.URLRepository;

@Controller
public class Api {

	
	@Autowired
	URLRepository crud ;
	
	
	@RequestMapping(value = { "/url" }, method = { RequestMethod.POST }, produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody String createShortURL (@RequestBody String body, HttpServletResponse response){	
		System.out.println(body);
		JsonParser jsonParser = new JsonParser();
		JsonObject json = jsonParser.parse(body).getAsJsonObject();
		String urlJson = json.get("url").getAsString();
		URL url = new URL(urlJson, crud.count());
		Gson gson = new Gson();
		crud.save(url);
		return gson.toJson(url);
		
		
	}
	
	
	
	@RequestMapping(value = { "/url/**" }, method = { RequestMethod.PUT }, produces = "application/json")
	public @ResponseBody String updateURL (@RequestBody String body, HttpServletResponse response){
		JsonParser jsonParser = new JsonParser();
		JsonObject json = jsonParser.parse(body).getAsJsonObject();
		System.out.println(json);
		int idJson = json.get("id").getAsInt();
		String urlJson = json.get("url").getAsString();
		URL urlObject = crud.findById(idJson);
		urlObject.setUrl(urlJson);
		crud.save(urlObject);
		Gson gson = new Gson();
		return gson.toJson(urlObject);	
	}
	
	
	

	@RequestMapping(value = { "/url/**" }, method = { RequestMethod.DELETE })
	public @ResponseBody String delete (HttpServletRequest reqeust, HttpServletResponse response){
		String requestedURL = reqeust.getRequestURL().toString();
		try {
			int id  = Integer.parseInt(requestedURL.substring(requestedURL.lastIndexOf("/") +1));
			System.out.println(id);
			 if(crud.existsById(id)) {
				 crud.deleteById(id);
				 response.setStatus(202);
				return "202 Accepted";
			 }
		}
		catch(NumberFormatException e) {
			response.setStatus(500);
			return "please enter a number";
		}
	
		return "error";
	}
	
	
	
	
	@RequestMapping(value = { "/url/**" }, method = { RequestMethod.GET }, produces = "application/json")
	public @ResponseBody String findURLById (HttpServletRequest reqeust, HttpServletResponse response){	
		String requestedURL = reqeust.getRequestURL().toString();
		try {
			int id  = Integer.parseInt(requestedURL.substring(requestedURL.lastIndexOf("/") +1));
			System.out.println(id);
			Gson gson = new Gson();
			URL urlObject = crud.findById(id);
			response.setStatus(200);
			return gson.toJson(urlObject);
		}
		catch(NumberFormatException e) {
			response.setStatus(500);
			return "please enter a number";
		}
	
	}
	
	
	
	
}
