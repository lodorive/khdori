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
public class KakaoPayDetailResponseVO {
	private String tid, cid, status; //결제 고유번호/가맹점 코드/결제상태
	private String partnerOrderId, partnerUserId; //주문번호/회원ID
	private String paymentMethodType; //결제수단(card or money)
	private KakaoPayAmountVO amount, canceledAmount, cancelAvailableAmount; //결제금액/취소된금액/취소가능금액
	private String itemName, itemCode; //상품 이름/상품코드
	private int quantity; //수량
	private Date createdAt, approvedAt, canceledAt; //결제준비요청시각/승인시각/취소시각
	private KakaoPaySelectedCardInfoVO selectedCardInfo; //결제카드정보
	private KakaoPaymentActionDetailsVO paymentActionDetails; //결제or취소 상세
}
