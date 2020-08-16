package com.wifi.sell.service;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wifi.sell.dao.ItemDao;
import com.wifi.sell.model.Item;
import com.wifi.sell.model.ItemDeleteRequest;

@Service
public class ItemDeleteService {

	private ItemDao dao;
	@Autowired
	private SqlSessionTemplate sTemplate;
	
	public int deleteItem(int iIdx) {

		dao = sTemplate.getMapper(ItemDao.class);
		
//		int result = 0;
//
//		Item item = deleteRequest.toItem();
//
//		int state = deleteRequest.getState();
//
//		int newState = 0;
//		
//		System.out.println("새로 저장될 state값 : " + newState);
//
//		// 데이터베이스에 저장할  item 객체의 데이터를 완성한다.
//		item.setState(newState);
//
//		// 데이터베이스 : update(=delete)
//		result = dao.deleteItem(item);
//
//		System.out.println("삭제 result 값(in deleteService) : "+result);
		
		return dao.deleteItem(iIdx);
	}

}
