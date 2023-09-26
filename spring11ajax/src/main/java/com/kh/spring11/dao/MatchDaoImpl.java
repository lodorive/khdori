package com.kh.spring11.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring11.dto.MatchDto;
import com.kh.spring11.mapper.MatchMapper;

@Repository
public class MatchDaoImpl implements MatchDao{

	
	@Autowired 
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private MatchMapper matchMapper;
	
	@Override
	public int sequence() {
		String sql ="select match_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	
	@Override
	public void insertMatch(MatchDto matchDto) {
		
		String sql = "insert into match"
				+ "(match_no, home_team, "
				+ "away_team, stadium_name, "
				+ "match_date) "
				+ "values(?, ?, ?, ?, ?)";
	    Object[] data = {
				matchDto.getMatchNo(), matchDto.getHomeTeam(),
				matchDto.getAwayTeam(),matchDto.getStadiumName(),
				matchDto.getMatchDate()
			};
		jdbcTemplate.update(sql,data);
	}

	@Override
	public boolean delete(int matchNo) {
		String sql = "delete match where match_no = ?";
		Object[] data = {matchNo} ;
		return jdbcTemplate.update(sql, data)>0;
	}

	@Override
	public boolean update(MatchDto matchDto) {
		String sql ="update match set match_home_score = ?, match_away_score = ? where match_no = ?";
		Object[] data = {matchDto.getMatchHomeScore(), matchDto.getMatchAwayScore(), matchDto.getMatchNo()} ;
		return jdbcTemplate.update(sql,data) > 0;
	}
	
	@Override
	public boolean updateDate(MatchDto matchDto) {
		String sql ="update match set match_date = ? where match_no = ?";
		Object[] data = {matchDto.getMatchDate(), matchDto.getMatchNo()} ;
		return jdbcTemplate.update(sql,data) > 0;
	}

	@Override
	public MatchDto selectOne(int matchNo) {
		String sql = "select * from match where match_no = ?";
		Object[] data = {matchNo} ; 
		List<MatchDto> list = jdbcTemplate.query(sql, matchMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}
	
	

	@Override
	public List<MatchDto> selectList() {
		String sql ="select * from match order by match_date desc";
		return jdbcTemplate.query(sql, matchMapper);
	}

}
