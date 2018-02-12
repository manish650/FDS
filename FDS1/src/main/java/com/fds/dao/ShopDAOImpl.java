package com.fds.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.fds.bo.AddressBO;
import com.fds.bo.ShopBO;
import com.fds.dto.AddressDTO;

public class ShopDAOImpl implements ShopDAO {
	
    private JdbcTemplate jt;
    public JdbcTemplate getJt() {
		return jt;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	private static final String REGISTER_SHOP="INSERT INTO SHOP (REG_NO,NAME,ADD_ID,USERNAME,PASSWORD,SHOPTYPE,PHONE) VALUES(?,?,?,?,?,?,?)";
	private static final String INSERT_SHOP_ADDRESS="INSERT INTO ADDRESS (HOUSE_NO,STREET_NO,VILLAGE,LANDMARK,CITY,STATE,COUNTRY) VALUES(?,?,?,?,?,?,?)"; 
    public int insertShop(List list) {
    	
    	int result=0;
    	ShopBO shop=(ShopBO)list.get(0);
    	System.out.println(shop);
    	if(insertAddress((AddressBO) list.get(1))==1)
		result=jt.update(REGISTER_SHOP,shop.getRegNo(),shop.getName(),shop.getAdd_id(),shop.getUserName(),shop.getPassword(),shop.getShopType(),shop.getPhone());
		return result;
	} 
    private int insertAddress(AddressBO add)
    {
        int result=0;
        System.out.println(add);
        result=jt.update(INSERT_SHOP_ADDRESS, add.getHouseNo(),add.getStreetNo(),add.getVillage(),add.getLandmark(),add.getCity(),add.getState(),add.getCountry());
        return result;
    }

	

}
