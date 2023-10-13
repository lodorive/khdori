package com.kh.spring17.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class MemberDto {
	private String memberId;
	private String memberPw;
	private String memberNickname;
	private String memberEmail;
	private String memberBirth;
	private int memberPost;
	private String memberAddr1, memberAddr2;
	private String memberContact;
	private String memberLevel;
	private int memberPoint;
	private Date memberJoin;
}
