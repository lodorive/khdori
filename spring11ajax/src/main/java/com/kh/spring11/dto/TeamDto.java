package com.kh.spring11.dto;

import lombok.Data;

@Data
public class TeamDto {
	private int teamNo;
	private String teamName; 
	private String teamRegion;
	private int teamWin, teamLose, teamDraw, teamMatch;
	private float teamWinRate, teamGameGap;
}
