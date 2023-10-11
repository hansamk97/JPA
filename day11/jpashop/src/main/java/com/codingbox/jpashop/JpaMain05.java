package com.codingbox.jpashop;

import java.time.LocalDateTime;
import java.util.List;

import com.codingbox.jpashop.embed.Address;
import com.codingbox.jpashop.embed.Member;
import com.codingbox.jpashop.embed.Period;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain05 {

	public static void main(String[] args) {
		EntityManagerFactory emf 
			= Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Address addr = new Address("서울", "강남", "123");
		
		Member member = new Member();
		member.setUsername("user1");
		member.setAddress(addr);
		em.persist(member);
		
		// 기존 addr을 복사해서 새로운 객체를 만들어서 넣어주면 된다
		Address copyAddr 
			= new Address(addr.getCity(), addr.getStreet(), addr.getZipcode());
		
		Member member2 = new Member();
		member2.setUsername("user2");
		member2.setAddress(copyAddr);
		em.persist(member2);
		
		// user1사람의 city값이 newCity로 변경하고 싶다
		//member.getAddress().setCity("newCity");
		
		Address addrNew = new Address("newCity", "강남", "123");
		member.setAddress(addrNew);
		
		tx.commit();
		em.close();
		emf.close();
	}

}











