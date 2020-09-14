package com.wifi.order.service;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wifi.order.dao.OrderDao;
import com.wifi.order.model.Order;
import com.wifi.order.model.OrderRegRequest;

@Service
public class OrderRegService {
	
	private OrderDao dao;
	
	@Autowired
	private SqlSessionTemplate sTemplate;

	public int insertOrder(OrderRegRequest regRequest, HttpServletRequest request) {
		
		int result=0;
		
		dao = sTemplate.getMapper(OrderDao.class);
		
		Order order = regRequest.toOrder();
		
		
		result = dao.insertOrder(order);
		
		
		return result;
	}

}
