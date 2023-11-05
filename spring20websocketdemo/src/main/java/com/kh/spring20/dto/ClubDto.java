package com.kh.spring20.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ClubDto {
	
	private int clubNo;
	private String clubOrner;
	private int minorCategoryNo;
	private String clubName, clubRegion, clubExplain, clubPersonnel;

}
