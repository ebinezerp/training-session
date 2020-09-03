package demo.webapplication.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import demo.webapplication.dao.CustomerService;
import demo.webapplication.dto.Customer;

@Controller
public class HomeController {

	@Autowired
	private CustomerService customerService;

	// fun: to handle request and generate response
	// by having request handling methods

	/*
	 * multiple ways to resolve the view 1. Using ModelAndView -> instance 2. String
	 * as return type
	 * 
	 * 
	 */

	/* @RequestMapping(value = "/", method = RequestMethod.GET) */

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}

	/* @RequestMapping(value = "/contact", method = RequestMethod.GET) */
	@GetMapping("/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("contact");
		mv.addObject("myname", "ebinezer");
		return mv;
	}

	/* @RequestMapping(value = "/aboutus", method = RequestMethod.GET) */
	@GetMapping("/aboutus")
	public String aboutus(Model model) {
		model.addAttribute("myname", "ebinezer");
		return "aboutus";
	}

	/* @RequestMapping(value = "/register", method = RequestMethod.GET) */
	@GetMapping("/register")
	public String registerpage(Model model) {
		model.addAttribute("customer", new Customer());
		return "register";
	}

	/* @RequestMapping(value = "/registerprocess", method = RequestMethod.POST) */
	/* @PostMapping("/registerprocess") */
	@PostMapping("/register")
	public String registerprocess(@Valid @ModelAttribute("customer") Customer customer, BindingResult result,
			Model model) {

		model.addAttribute("customer", customer);
		if (result.hasErrors()) {
			return "register";
		}

		if (customerService.save(customer)) {
			return "redirect:/login";
		} else {
			model.addAttribute("errorMsg", "Internal error occured try again");
			return "register";
		}

	}

	/* @RequestMapping(value = "/login", method = RequestMethod.GET) */
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

}
