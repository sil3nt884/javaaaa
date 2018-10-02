package challenge.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import challenge.entity.URL;
import challenge.repository.URLRepository;

@Controller
public class RedirectController {

	@Autowired
	URLRepository crud;
	
	@RequestMapping(value = { "/redirect/**" }, method = { RequestMethod.GET })
	@ResponseStatus(HttpStatus.PERMANENT_REDIRECT)
	public void redirect(HttpServletRequest reqeust, HttpServletResponse response)  {
		String requestedURL = reqeust.getRequestURL().toString();
		String shortCode = requestedURL.substring(requestedURL.lastIndexOf("/") + 1);
		List<URL> redirects = crud.findAll();
		String redirectURL = null;
		for (int i = 0; i < redirects.size(); i++) {
			if (shortCode.equals(redirects.get(i).getShortCode())) {
				redirectURL = redirects.get(i).getUrl();
			}
		}
		try {
			response.sendRedirect(redirectURL);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
