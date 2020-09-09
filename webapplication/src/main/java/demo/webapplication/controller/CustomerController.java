package demo.webapplication.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import demo.webapplication.dao.CustomerService;
import demo.webapplication.dto.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/profile")
	public String profile() {
		return "profile";
	}

	@GetMapping("/editprofile")
	public String editProfile(HttpSession session, Model model) {
		model.addAttribute("customer", session.getAttribute("customer"));
		return "editprofile";
	}

	@PostMapping("/update")
	public String updateProfile(@Valid @ModelAttribute("customer") Customer customer, BindingResult result,
			HttpSession session, Model model) {
		
		System.out.println(customer);

		if (result.hasErrors()) {
			model.addAttribute("customer", customer);
			return "editprofile";
		}

		if (customerService.update(customer)) {
			session.setAttribute("customer", customer);
			return "redirect:/customer/profile";
		} else {
			model.addAttribute("customer", customer);
			model.addAttribute("errorMsg", "Update failed. Try Again");
			return "editprofile";
		}
	}

}
