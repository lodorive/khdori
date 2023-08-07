package com.kh.spring10.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring10.dto.ShirtSizeDto;
import com.kh.spring10.mapper.ShirtSizeMapper;

@Repository
public class ShirtSizeDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ShirtSizeMapper mapper;
	
	//등록
	public void insert(ShirtSizeDto dto) {
		String sql = "insert into shirt_size(shirt_no, shirt_size_name) values(?, ?)";
		Object[] data = {dto.getShirtNo(), dto.getShirtSizeName()};
		jdbcTemplate.update(sql, data);
	}
	
	//상세조회
	public List<ShirtSizeDto> selectList(int shirtNo){
		String sql = "select * from shirt_size where shirt_no=?";
		Object[] data = {shirtNo};
		return jdbcTemplate.query(sql, mapper, data);
	}
	
	//삭제
	public boolean delete(int shirtNo) {
		String sql = "delete shirt_size where shirt_no=?";
		Object[] data = {shirtNo};
		return jdbcTemplate.update(sql, data) >0;
	}
}
