package com.kh.spring17.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class MemberComplexSearchVO {
	private String memberId;
	private String memberNickname;
	private String memberEmail;
	private String memberContact;
	private String memberBirth;
	private List<String> memberLevelList;
	private Integer memberPointMin, memberPointMax;
	private String memberJoinBegin, memberJoinEnd; //날짜도 검색할 때는 문자열로 입력
	private String memberLoginBegin, memberLoginEnd; 
	
	private List<String> orderList;
}