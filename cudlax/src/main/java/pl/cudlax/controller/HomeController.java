package pl.cudlax.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.cudlax.model.TestModel;
import pl.cudlax.repository.TestRepository;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	private TestRepository testRepository;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("HomeController");

		model.addAttribute("list", "LSIT");

		return "home";
	}

	@RequestMapping(value = "getForm", method = RequestMethod.GET)
	public String getForm(Model model) {
		model.addAttribute("testModel", new TestModel());
		return "form";
	}

	@RequestMapping(value = "getForm", method = RequestMethod.POST)
	public String processTestModel(Model model,
			@ModelAttribute TestModel testModel) {
		return "redirect:/";
	}

}
