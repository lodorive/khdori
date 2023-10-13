package com.kh.spring17.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class MemberComplexSearchVO {
	private String memberId;
	private String memberNickname;
	private String memberEmail;
	private Integer memberBithBegin, memberBithEnd;
	private Integer memberContact;
	private String memberLevel;
	private Integer memberJoinBegin, memberJoinEnd;
}