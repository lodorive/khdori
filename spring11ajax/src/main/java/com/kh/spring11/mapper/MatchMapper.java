package com.kh.spring11.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.spring11.dto.MatchDto;

@Component
public class MatchMapper implements RowMapper<MatchDto>{

	@Override
	public MatchDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		MatchDto matchDto = new MatchDto();
		matchDto.setMatchNo(rs.getInt("match_no"));
		matchDto.setHomeTeam(rs.getString("home_team"));
		matchDto.setAwayTeam(rs.getString("away_team"));
		matchDto.setStadiumName(rs.getString("stadium_name"));
		matchDto.setMatchDate(rs.getTimestamp("match_date"));
		matchDto.setMatchHomeScore(rs.getInt("match_home_score"));
		matchDto.setMatchAwayScore(rs.getInt("match_away_score"));
		return matchDto;
	}

}
