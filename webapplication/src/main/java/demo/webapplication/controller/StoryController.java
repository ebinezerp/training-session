package demo.webapplication.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import demo.webapplication.dao.StoryService;
import demo.webapplication.dto.Customer;
import demo.webapplication.dto.Story;

@Controller
@RequestMapping("/customer")
public class StoryController {

	@Autowired
	private StoryService storyService;

	@GetMapping("/addstory")
	public String addStoryPage(Model model) {
		model.addAttribute("story", new Story());
		return "addstory";

	}

	@PostMapping("/addstory")
	public String saveStory(@Valid @ModelAttribute("story") Story story, BindingResult result, Model model,
			HttpSession session) {
		if (result.hasErrors()) {
			model.addAttribute("story", story);
			return "addstory";
		}

		Customer customer = (Customer) session.getAttribute("customer");
		story.setCustomer(customer);

		if (storyService.save(story)) {
			return "redirect:/customer/mystories";
		} else {
			model.addAttribute("errorMsg", "Internal Server Error Occured. Try again");
			return "addstory";
		}

	}

	@GetMapping("/mystories")
	public String customerStories(HttpSession session, Model model) {
		Customer customer = (Customer) session.getAttribute("customer");
		List<Story> stories = storyService.getStories(customer.getId());
		model.addAttribute("stories", stories);
		return "mystories";
	}

	@GetMapping("/allstories")
	public String allStories(Model model) {
		List<Story> stories = storyService.getStories();
		model.addAttribute("stories", stories);
		return "allstories";
	}

	@GetMapping("/story/{id}")
	public String getStory(@PathVariable("id") Integer storyId, Model model) {
		Story story = storyService.getStory(storyId);
		model.addAttribute("story", story);
		return "story";
	}

}
