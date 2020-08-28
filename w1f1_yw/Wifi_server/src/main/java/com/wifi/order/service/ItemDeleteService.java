package com.wifi.order.service;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wifi.order.dao.ItemDao;


@Service
public class ItemDeleteService {

	private ItemDao dao;
	@Autowired
	private SqlSessionTemplate sTemplate;
	
	public int deleteItem(int iidx) {

		dao = sTemplate.getMapper(ItemDao.class);

		return dao.deleteItem(iidx);
	}

}
