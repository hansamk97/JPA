package com.codingbox.jpashop.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

//@Entity
@Getter @Setter
public class Member {
	
	@Id
	@GeneratedValue		// 전략 생략하면 AUTO 이다
	@Column(name = "MEMBER_ID")
	private Long id;
	private String name;
	private String city;
	private String street;
	private String zipcode;
	
	@OneToMany(mappedBy = "member")
	private List<Order> orders
		= new ArrayList<>();
	
	public void addOrder(Order order) {
		order.setMember(this);
		this.orders.add(order);
	}
	
}











