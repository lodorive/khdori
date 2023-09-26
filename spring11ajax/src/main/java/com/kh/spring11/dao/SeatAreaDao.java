package com.kh.spring11.dao;


import java.util.List;

import com.kh.spring11.dto.SeatAreaDto;

public interface SeatAreaDao {
	int sequenceSeatArea();
	void insert(SeatAreaDto seatAreaDto);
	SeatAreaDto selectOne(int seatAreaNo);
	List<SeatAreaDto> selectList();
	boolean update(SeatAreaDto seatAreaDto);
	boolean delete(int seatAreaNo);
//	
//	List<FindStadiumNameDto> selectStadiumName();
//	
	

}
