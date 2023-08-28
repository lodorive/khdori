package com.kh.springhome.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class BasketDto {
	private int basketNo;
	private String basketUser;
	private int basketItem;
	private Date basketTime;
	private int basketQty;
}
