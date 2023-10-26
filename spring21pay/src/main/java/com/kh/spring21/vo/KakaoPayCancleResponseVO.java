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
public class KakaoPayCancleResponseVO {

	private String aid, tid, cid, status; //고유번호/결제고유/가맹점코드/결제상태
	private String partnerOrderId, partnerUserId; //주문번호/회원ID
	private String paymentMethodType; //결제수단
	private KakaoPayAmountVO amount; //결제금액
	private KakaoPayAmountVO canceledAmount, cancelAvailableAmount; //누계취소금액/남은취소가능금액
	private String itemName, itemCode; //상품이름/상품코드
	private int quantity; //수량
	private Date createdAt, approvedAt, canceledAt; //결제준비요청시각/승인시각/취소시각
	private String payload; //취소요청시전달한값
	
}
