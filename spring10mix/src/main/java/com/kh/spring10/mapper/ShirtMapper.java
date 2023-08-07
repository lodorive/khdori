package com.kh.spring10.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.spring10.dto.ShirtDto;

@Component
public class ShirtMapper implements RowMapper<ShirtDto> {

	@Override
	public ShirtDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ShirtDto dto = new ShirtDto();
		dto.setShirtNo(rs.getInt("shirt_no"));
		dto.setShirtName(rs.getString("shirt_name"));
		dto.setShirtColor(rs.getString("shirt_color"));
		dto.setShirtPrice(rs.getInt("shirt_price"));
		dto.setShirtKind(rs.getString("shirt_kind"));
		dto.setShirtType(rs.getString("shirt_type"));
		dto.setShirtMaterial(rs.getString("shirt_material"));
		dto.setShirtStock(rs.getInt("shirt_stock"));
		return dto;
	}

}
