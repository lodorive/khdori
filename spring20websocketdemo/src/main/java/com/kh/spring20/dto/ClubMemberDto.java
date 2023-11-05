package com.kh.spring20.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ClubMemberDto {
	
	private int clubMemberNo;
	private String memberId;
	private int clubNo;
	private String clubMemberRank;

}
