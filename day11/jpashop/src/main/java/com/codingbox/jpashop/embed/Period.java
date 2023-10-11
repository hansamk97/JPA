package com.codingbox.jpashop.embed;

import java.time.LocalDateTime;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Embeddable
public class Period {
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	
	// 테스트를 위해 파라미터가 있는 생성자
	public Period(LocalDateTime startDate, LocalDateTime endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Period() { }
	
}















