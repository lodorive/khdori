package com.kh.spring16.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class CustomerDto {
	
	private int customerNo;
	private String customerId;
	private String customerContact;
	private String customerJoin;
	private String customerPurchase;
	private int customerMileage;
	private String customerLevel;
	

}
