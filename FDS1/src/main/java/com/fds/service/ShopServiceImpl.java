package com.fds.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.fds.bo.AddressBO;
import com.fds.bo.ShopBO;
import com.fds.dao.ShopDAO;
import com.fds.dto.AddressDTO;
import com.fds.dto.ShopDTO;

public class ShopServiceImpl implements ShopServices {
	private ShopDAO dao;
	

	public ShopDAO getDao() {
		return dao;
	}


	public void setDao(ShopDAO dao) {
		this.dao = dao;
	}


	public String registerService(List list) {
		ShopBO shopBO = new ShopBO();
		AddressBO addBo=new AddressBO();
		//List list=new ArrayList();
		String msg = "Shop Registration Fail Due To Internal Eroor";
		BeanUtils.copyProperties((ShopDTO)list.get(0), shopBO);
		BeanUtils.copyProperties((AddressDTO)list.get(1), addBo);
		list.clear();
		list.add(shopBO);
		list.add(addBo);
       int count=dao.insertShop(list);
       if(count==1)
       {
    	   return "Shop Registered Sucessfull";
       }
		return msg;
	}



}
