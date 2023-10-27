package com.kh.spring21.vo;

import java.util.List;

import com.kh.spring21.dto.PaymentDetailDto;
import com.kh.spring21.dto.PaymentDto;

import lombok.Data;

@Data
public class PaymentListVO {
	//1개의 대표정보와 여러 개의 상세정보가 묶여있음
	private PaymentDto paymentDto;
	private List<PaymentDetailDto> paymentDetailList;
}
