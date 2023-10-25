package com.kh.spring21.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class KakaoPayApproveRequestVO {
	private String tid, partnerOrderId, partnerUserId, pgToken;
}
