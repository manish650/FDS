package com.fds.controller;

import org.springframework.web.servlet.ModelAndView;

import com.fds.service.ShopServices;

public class ShopController {
	private ShopServices service;

	public ShopServices getService() {
		return service;
	}

	public void setService(ShopServices service) {
		this.service = service;
	}

	public ModelAndView showAdminHomePage() {
		String targetViewName = "/WEB-INF/pages/home.jsp";

		return new ModelAndView(targetViewName);
	}
}