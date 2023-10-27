package com.kh.spring21.dao;

import java.util.List;

import com.kh.spring21.dto.PaymentDetailDto;
import com.kh.spring21.dto.PaymentDto;
import com.kh.spring21.vo.PaymentListVO;

public interface PaymentDao {
	int sequence();
	void insert(PaymentDto paymentDto);
	List<PaymentDto> selectList();
	PaymentDto selectOne(int paymentNo);
	
	void insertDetail(PaymentDetailDto paymentDetailDto);
	
	List<PaymentListVO> selectTotalList();
	List<PaymentListVO> selectTotalListByMember(String paymentMember);
	
	PaymentDetailDto selectDetail(int paymentDetailNo);
	void cancelDetail(int paymentDetailNo);
	void cancel(PaymentDto paymentDto);
	void cancelDetailGroup(int paymentDetailOrigin);
}
