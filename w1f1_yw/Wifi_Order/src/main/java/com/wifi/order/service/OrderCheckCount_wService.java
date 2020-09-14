package com.wifi.order.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wifi.order.dao.OrderDao;

@Service
public class OrderCheckCount_wService {

	private OrderDao dao;
	
	@Autowired
	private SqlSessionTemplate sTemplate;
	
	public int selectCount_w(int iidx) {
		
		int result=0;
		
		dao = sTemplate.getMapper(OrderDao.class);
		
		result = dao.selectCount_w(iidx);
		
		
		return result;
	}
	
	
}
