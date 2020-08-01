package com.aia.mvc.order.model;

public class OrderItem {

	private String itemId;
	private String number;
	private String remark;

	
	//beans형태로 사용하려면 반드시 default생성자 필요 (Container가 바인딩)
	public OrderItem() {
		super();
	}


	public String getItemId() {
		return itemId;
	}


	public void setItemId(String itemId) {
		this.itemId = itemId;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	@Override
	public String toString() {
		return "OrderItem [itemId=" + itemId + ", number=" + number + ", remark=" + remark + "]";
	}
	
	
	
	
	
}