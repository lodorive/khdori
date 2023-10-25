package com.kh.spring21.vo;

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
public class KakaoPaymentActionDetailsVO {
	
	private String aid, approvedAt; //고유번호/거래시간
	private int amount, pointAmount, discountAmount, greenDeposit; //결제or취소금액/결제or취소포인트/할인금액/컵보증금
	private String paymentActionType, payload; //결제타입/request로 전달한값

}
