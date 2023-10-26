package com.kh.spring21.vo;

import com.kh.spring21.dto.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//구매 확인을 위해 정보를 한 번 더 출력하는 용도 
@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class PurchaseConfirmVO {
	private PurchaseVO purchaseVO;
	private ProductDto productDto;
	
	public int getTotal() {
		return purchaseVO.getQty() * productDto.getProductPrice();
	}
}
