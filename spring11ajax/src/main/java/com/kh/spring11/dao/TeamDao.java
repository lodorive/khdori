package com.kh.spring11.dao;

import java.util.List;

import com.kh.spring11.dto.TeamDto;



public interface TeamDao {
	int sequenceTeam();
	void insert(TeamDto teamDto);
	TeamDto selectOne(int teamNo);
	List<TeamDto> selectList();
	boolean update(TeamDto teamDto);
	boolean delete(int teamNo);
	void connect(int teamNo, int attachNo);
	
	TeamDto selectTeamOne();
	boolean updateWin(String teamName);
	boolean updateLose(String teamName);
	boolean updateDraw(String teamName);
	boolean updateWinRate(String teamName);
	boolean updateGameGap();

}
