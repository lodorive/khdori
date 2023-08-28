package com.kh.springhome.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class ClientDto {
	private String clientId, clientPassword, clientNickname, clientGrade;
	private Date clientJoin;
	private int clientPoint;
}
