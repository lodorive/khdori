package com.kh.spring21.service;

import java.net.URISyntaxException;

import com.kh.spring21.vo.KakaoPayApproveRequestVO;
import com.kh.spring21.vo.KakaoPayApproveResponseVO;
import com.kh.spring21.vo.KakaoPayCancleRequestVO;
import com.kh.spring21.vo.KakaoPayCancleResponseVO;
import com.kh.spring21.vo.KakaoPayDetailRequestVO;
import com.kh.spring21.vo.KakaoPayDetailResponseVO;
import com.kh.spring21.vo.KakaoPayReadyRequestVO;
import com.kh.spring21.vo.KakaoPayReadyResponseVO;
import com.kh.spring21.vo.PurchaseListVO;

public interface KakaoPayService {
	//통신
	KakaoPayReadyResponseVO ready(KakaoPayReadyRequestVO request) throws URISyntaxException;
	KakaoPayApproveResponseVO approve(KakaoPayApproveRequestVO request) throws URISyntaxException;
	KakaoPayDetailResponseVO detail(KakaoPayDetailRequestVO request) throws URISyntaxException;
	KakaoPayCancleResponseVO cancle(KakaoPayCancleRequestVO request) throws URISyntaxException;
	
	KakaoPayReadyRequestVO convert(PurchaseListVO listVO);
}
