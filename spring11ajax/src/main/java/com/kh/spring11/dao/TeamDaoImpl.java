package com.kh.spring11.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring11.dto.TeamDto;
import com.kh.spring11.mapper.TeamMapper;

@Repository
public class TeamDaoImpl implements TeamDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private TeamMapper teamMapper;


	@Override
	public int sequenceTeam() {
		String sql = "select team_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}

	@Override
	public void insert(TeamDto teamDto) {
		String sql = "insert into team(team_no, team_name, team_region) " + "values(?, ?, ?)";
		Object[] data = { teamDto.getTeamNo(), teamDto.getTeamName(), teamDto.getTeamRegion() };
		jdbcTemplate.update(sql, data);
	}

	@Override
	public TeamDto selectOne(int teamNo) {
		String sql = "select * from team where team_no = ?";
		Object[] data = { teamNo };
		List<TeamDto> list = jdbcTemplate.query(sql, teamMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public List<TeamDto> selectList() {
		String sql = "select * from team order by team_win_rate desc, team_game_gap";
		return jdbcTemplate.query(sql, teamMapper);
	}

	@Override
	public boolean update(TeamDto teamDto) {
		String sql = "update team set " + "team_name = ?, team_region = ? " + "where team_no = ?";
		Object[] data = { teamDto.getTeamName(), teamDto.getTeamRegion(), teamDto.getTeamNo() };
		return jdbcTemplate.update(sql, data) > 0;
	}

	@Override
	public boolean delete(int teamNo) {
		String sql = "delete from team where team_no = ?";
		Object[] data = { teamNo };
		return jdbcTemplate.update(sql, data) > 0;
	}

	// 팀 결과 메서드
	@Override
	public TeamDto selectTeamOne() {
		String sql = "select * from team where rownum = 1 " + "order by team_win_rate desc";
		List<TeamDto> list = jdbcTemplate.query(sql, teamMapper);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public boolean updateWin(String teamName) {
		String sql = "update team set team_win = team_win + 1, team_match = team_match + 1 " + "where team_name = ?";
		Object[] data = { teamName };
		return jdbcTemplate.update(sql, data) > 0;
	}

	@Override
	public boolean updateLose(String teamName) {
		String sql = "update team set team_lose = team_lose + 1, team_match = team_match + 1 " + "where team_name = ?";
		Object[] data = { teamName };
		return jdbcTemplate.update(sql, data) > 0;
	}

	@Override
	public boolean updateDraw(String teamName) {
		String sql = "update team set team_draw = team_draw + 1, team_match = team_match + 1 " + "where team_name = ?";
		Object[] data = { teamName };
		return jdbcTemplate.update(sql, data) > 0;
	}

	@Override
	public boolean updateWinRate(String teamName) {
		String sql = "update team set team_win_rate = " + "case " + "when (team_match - team_draw) = 0 then 0 "
				+ "else round(team_win / (team_match - team_draw), 3) " + "end " + "where team_name = ?";
		Object[] data = { teamName };
		return jdbcTemplate.update(sql, data) > 0;
	}

	@Override
	public boolean updateGameGap() {
		String sql = "update team set team_game_gap = abs((select team_win from ("
				+ "select rownum rn, tmp.* from "
				+ "( "
				+ "select * from team order by team_win_rate desc, team_win desc"
				+ ") tmp"
				+ ") where rn = 1) - team_win) * 0.5 + abs((select team_lose from ( select rownum rn, tmp.* from"
				+ "("
				+ "select * from team order by team_win_rate desc, team_win desc "
				+ ") tmp"
				+ ") where rn = 1) - team_lose) * 0.5";
		return jdbcTemplate.update(sql) > 0;
	}

	@Override
	public void connect(int teamNo, int attachNo) {
		String sql = "insert into team_image values(?, ?)";
		Object[] data = { teamNo, attachNo };
		jdbcTemplate.update(sql, data);
	}

}
