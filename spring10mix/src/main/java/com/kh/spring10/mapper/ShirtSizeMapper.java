package com.kh.spring10.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.spring10.dto.ShirtSizeDto;

@Component
public class ShirtSizeMapper implements RowMapper<ShirtSizeDto> {

	@Override
	public ShirtSizeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ShirtSizeDto dto = new ShirtSizeDto();
		dto.setShirtNo(rs.getInt("shirt_no"));
		dto.setShirtSizeName(rs.getString("shirt_size_name"));		
		return dto;
	}
}
