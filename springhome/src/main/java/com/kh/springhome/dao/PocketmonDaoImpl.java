package com.kh.springhome.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.springhome.dto.PocketmonDto;
import com.kh.springhome.mapper.PocketmonMapper;

@Repository
public class PocketmonDaoImpl implements PocketmonDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private PocketmonMapper pocketmonMapper;

	@Override
	public int sequence() {
		String sql = "select pocketmon_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}

	@Override
	public void insert(PocketmonDto pocketmonDto) {
		String sql = "insert into pocketmon(no, name, type) values(?, ?, ?)";
		Object[] data = {pocketmonDto.getNo(), pocketmonDto.getName(), 
				pocketmonDto.getType()};
		jdbcTemplate.update(sql, data);
	}

	@Override
	public void connect(int pocketmonNo, int attachNo) {
		String sql = "insert into pocketmon_image values(?, ?)";
		Object[] data = {pocketmonNo, attachNo};
		jdbcTemplate.update(sql, data);
	}
}
