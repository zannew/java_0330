package com.wifi.sell.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wifi.sell.dao.ItemDao;
import com.wifi.sell.model.Item;
@Service
public class ItemViewService {
	
	private ItemDao dao;
	
	@Autowired
	private SqlSessionTemplate sTemplate;
	
	public Item getItem(int iIdx) {
		
		dao = sTemplate.getMapper(ItemDao.class);
		
		return dao.selectByIidx(iIdx);
	}

	public List<Item> getItemList(String searchType, String keyword) {

		dao = sTemplate.getMapper(ItemDao.class);
		
		return dao.selectListByKeyword(searchType, keyword);
	}

}
