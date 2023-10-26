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
public class KakaoPayCardInfoVO {
	private String purchaseCorp, purchaseCorpCode; //카드사 이름/카드사 코드
	private String issuerCorp, issuerCorpCode; //카드 발급사 이름/발급사 코드
	private String kakaopayPurchaseCorp, kakaopayPurchaseCorpCode; //매입사 이름/매입사 코드
	private String kakaopayIssuerCorp, kakaopayIssuerCorpCode; //발급사 이름/발급사 코드
	private String bin; //카드 BIN
	private String cardType; //카드 타입
	private String installMonth; //할부 개월 수
	private String approvedId; //카드사 승인번호
	private String cardMid; //가맹점 번호
	private String interestFreeInstall; //무이자할부 여부(Y/N)
	private String cardItemCode; //카드 상품 코드
}
