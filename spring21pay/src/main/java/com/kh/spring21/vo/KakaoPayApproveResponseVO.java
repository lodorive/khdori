package com.kh.spring21.vo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true) //모르는 항목은 무시하도록 지정
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class KakaoPayApproveResponseVO {
	private String aid, tid, cid, sid; //요청/거래/가맹점/정기결제 코드
	private String partnerOrderId, partnerUserId; //가맹점 주문번호/가맹점 회원ID
	private KakaoPayAmountVO amount;
	private KakaoPayCardInfoVO cardInfo;
	private String itemName, itemCode; //상품 이름/상품 코드
	private int quantity; //수량
	private Date createdAt, approvedAt; //준비/승인 시각
	private String payload; //메모
}
