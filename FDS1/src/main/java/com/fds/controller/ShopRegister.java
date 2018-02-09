package com.fds.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.fds.dto.AddressDTO;
import com.fds.dto.ShopDTO;
import com.fds.service.ShopServices;

public class ShopRegister implements Controller {
	private ShopServices service;

	public ShopServices getService() {
		return service;
	}

	public void setService(ShopServices service) {
		this.service = service;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String targetViewName = "/WEB-INF/pages/home.jsp";
		ModelAndView resp = null;
        List list=gatherInput(request);
		String msg1 = service.registerService(list);
		resp = new ModelAndView(targetViewName, "msg", msg1);
		return resp;
	}

	private List gatherInput(HttpServletRequest request) {
		List list = new ArrayList();
		ShopDTO shop = new ShopDTO();
		AddressDTO add = new AddressDTO();

		shop.setRegNo(request.getParameter("regNo"));
		shop.setName(request.getParameter("name"));
		shop.setAdd_id(request.getParameter("addId"));
		list.add(shop);

		add.setHouseNo(request.getParameter("houseNo"));
		add.setStreetNo(request.getParameter("name"));
		add.setVillage(request.getParameter("village"));
		add.setLandmark(request.getParameter("landmark"));
		add.setCity(request.getParameter("city"));
		add.setState(request.getParameter("state"));
		add.setCountry(request.getParameter("country"));

		list.add(add);

		return list;
	}

}
