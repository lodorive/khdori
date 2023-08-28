package com.kh.springhome.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.springhome.dto.BasketDto;

@Component
public class BasketMapper implements RowMapper<BasketDto>{
	@Override
	public BasketDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		BasketDto basketDto = new BasketDto();
		basketDto.setBasketNo(rs.getInt("basket_no"));
		basketDto.setBasketUser(rs.getString("basket_user"));
		basketDto.setBasketItem(rs.getInt("basket_item"));
		basketDto.setBasketTime(rs.getDate("basket_time"));
		basketDto.setBasketQty(rs.getInt("basket_qty"));
		return basketDto;
	}
}
