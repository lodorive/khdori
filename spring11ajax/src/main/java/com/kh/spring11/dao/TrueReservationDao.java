package com.kh.spring11.dao;

import com.kh.spring11.dto.TrueReservationDto;

public interface TrueReservationDao {
	
	int sequence();
	void insert(TrueReservationDto trueReservationDto);
	
}
