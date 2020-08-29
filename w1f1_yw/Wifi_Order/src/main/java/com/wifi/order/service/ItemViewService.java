package com.wifi.order.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wifi.order.dao.ItemDao;
import com.wifi.order.model.Item;

@Service
public class ItemViewService {
	
	private ItemDao dao;
	
	@Autowired
	private SqlSessionTemplate sTemplate;
	
	public Item getItem(int iidx) {
		
		dao = sTemplate.getMapper(ItemDao.class);
		
		Item item = dao.selectByIidx(iidx);
		
		dao.increaseViewCount(iidx);
		
		return item;
	}

	public List<Item> getItemList(String searchType, String keyword) {

		dao = sTemplate.getMapper(ItemDao.class);
		
		return dao.selectListByKeyword(searchType, keyword);
	}

	public int getMidx(int iIdx) {

		dao = sTemplate.getMapper(ItemDao.class);
		
		
		return dao.selectMidx(iIdx);
	}

}
