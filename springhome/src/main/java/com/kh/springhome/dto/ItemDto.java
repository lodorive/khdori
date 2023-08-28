package com.kh.springhome.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class ItemDto {
	private int itemNo;
	private String itemName;
	private int itemPrice;
	private Date itemRegist;
}
