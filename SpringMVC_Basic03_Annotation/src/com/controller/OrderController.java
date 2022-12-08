package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.OrderCommand;
/*
하나의 요청 주소로 두개의 업무처리가 가능하다
/order/order.do
GET > 화면
POST > 처리
*/
@Controller
@RequestMapping("/order/order.do")
public class OrderController {
	
	@GetMapping
	public String Form() {
		return "order/OrderForm";
	}
	@PostMapping
	public String submit(OrderCommand ordercommand) {
		/*
		 	- 생략 된 것 -
			1. OrderCommand ordercommand = new OrderCommand();
			1.1 자동 매핑 >> member filed >> private List<OrderItem> orderItem 자동 주입
			
			2. List(OrderItem item =new ArrayList<>();
					>>> orderItem[0].itemid   > 1
					>>> orderItem[0].number> 10
					>>> orderItem[0].remark  > 주의하세요
					. . .
					item.add(new OrderItem(1,10,"주의하세요")
					. . .
			3. ordercommand.setItem(item);
			4. ModelAndView.addObject("OrderCommand",ordercommand);
				원리 : key(value)값 >> OrderCommand >> orderCommand
		*/
		return "order/OrderCommitted";
	}
}
