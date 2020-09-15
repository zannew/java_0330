package com.wifi.order.item.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wifi.order.dao.ItemDao;
import com.wifi.order.model.Item;
import com.wifi.order.model.ItemDTO;

@Service
public class ItemlistService {

	private ItemDao dao;

	@Autowired
	private SqlSessionTemplate template;


	// 추천 공구 리스트 : 최신순 정렬
	public List<ItemDTO> getRecomItemlist() {

		dao = template.getMapper(ItemDao.class);
		System.out.println("추천 공구 리스트 최신순정렬  service");

		
		return dao.getRecomItemlist();
		
	};
	
	
	// 일반 공구 리스트 : 최신순 정렬
	public List<ItemDTO> getItemlist() {

		dao = template.getMapper(ItemDao.class);
		System.out.println("일반 공구 리스트 최신순정렬  service");

		return dao.getItemlist();
	}



};
