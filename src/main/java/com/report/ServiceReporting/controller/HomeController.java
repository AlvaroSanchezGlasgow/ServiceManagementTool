package com.report.ServiceReporting.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller used to redirect the http call to the initial index view
 * @author jabilbao
 *
 */
@Controller
public class HomeController {

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/home")
	public ModelAndView index() {
		
		
		return new ModelAndView("index");
	}
	
	/**
	 * 
	 * @return
	 */

	@RequestMapping(value = "/admin")
	@Secured("ROLE_ADMIN")
	@PreAuthorize("hasRole('ADMIN')")
	public ModelAndView admin() {
		
		
		return new ModelAndView("admin");
	}
	
	
	
	
}
