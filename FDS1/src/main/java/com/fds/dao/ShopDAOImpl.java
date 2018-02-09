package com.fds.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.fds.dto.AddressDTO;

public class ShopDAOImpl implements ShopDAO {
	
    private JdbcTemplate jt;
    public JdbcTemplate getJt() {
		return jt;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	private static final String REGISTER_SHOP="INSERT INTO SHOP (REG_NO,NAME,ADD_ID) VALUES(?,?,?)";
	
    public int insertShop(List list) {
    	
    	int result=0;
    	if(insertAddress((AddressDTO) list.get(1)))
		//result=jt.update(REGISTER_SHOP,shop.getRegNo(),shop.getName(),shop.getAdd_id());
		return result;
	} 
    private boolean insertAddress(AddressDTO dto)
    {
    	
    	return false;
    }

	

}
