package com.wifi.order.dao;

import com.wifi.order.model.Order;

public interface OrderDao {

	int selectCount_w(int iidx);

	int insertOrder(Order order);

	
	
}
