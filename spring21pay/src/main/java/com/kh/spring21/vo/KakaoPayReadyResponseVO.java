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
//@JsonIgnoreProperties({"tms_result"}) //특정 항목만 무시하도록 지정
@JsonIgnoreProperties(ignoreUnknown = true) //모르는 항목은 무시하도록 지정
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class KakaoPayReadyResponseVO {
	private String tid; //결제 고유 번호
//	private String next_redirect_app_url; //모바일 앱용 결제 페이지 주소
	private String nextRedirectAppUrl;
//	private String next_redirect_mobile_url; //모바일 웹용 결제 페이지 주소
	private String nextRedirectMobileUrl;
//	private String next_redirect_pc_url; //PC 웹용 결제 페이지 주소
	private String nextRedirectPcUrl;
//	private String android_app_scheme; //카카오페이 결제를 위한 안드로이드 스킴
	private String androidAppScheme;
//	private String ios_app_scheme; //카카오페이 결제를 위한 아이폰 스킴
	private String iosAppScheme;
//	private Date created_at; //결제 준비 요청 시간
	private Date createdAt;
}
