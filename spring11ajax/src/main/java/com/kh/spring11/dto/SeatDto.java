package com.kh.spring11.dto;

import lombok.Data;

@Data
public class SeatDto {
	int seatNo, seatAreaNo, seatRow, seatCol;
	String seatStatus;
}
