package com.model;
/*
	주문서 클래스
	하나의 주문은 여러개의 상품을 가질 수 있다.
*/

import java.util.List;

public class OrderCommand {
	private List<OrderItem> orderItem;
	
	public List<OrderItem> getOrderItem(){
		return this.orderItem;
	}
	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}
}
