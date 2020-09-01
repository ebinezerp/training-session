package demo.webapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	// fun: to handle request and generate response
	// by having request handling methods

	@RequestMapping("/index")
	public String index() {
		return "i am ebinezer";
	}
	
	

}
