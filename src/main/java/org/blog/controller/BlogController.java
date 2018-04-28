package org.blog.controller;

import org.blog.model.ContactFormBean;
import org.blog.model.Dataset;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = { "/views/blog" })
public class BlogController {
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list() {
/*
		ContactFormBean contactForm = new ContactFormBean();

		contactForm.setContacts(Dataset.getContacts());
*/
		return new ModelAndView("/blog/list", "message", "teste");
	}

	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		
		return "/blog/addEdit";
	}

}
