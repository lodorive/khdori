package com.kh.spring11.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.spring11.dto.SeatDto;

@Component
public class SeatMapper implements RowMapper<SeatDto>{
	
	@Override
	public SeatDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		SeatDto seatDto = new SeatDto();
		seatDto.setSeatNo(rs.getInt("seat_no"));
		seatDto.setSeatAreaNo(rs.getInt("seat_area_no"));
		seatDto.setSeatRow(rs.getInt("seat_row"));
		seatDto.setSeatCol(rs.getInt("seat_col"));
		seatDto.setSeatStatus(rs.getString("seat_status"));
		return seatDto;
	}
}
