package com.kh.spring22.dto;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "포켓몬스터")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class PocketmonDto {
	
	@Schema(description = "몬스터 번호(등록 시에는 필요 없음)")
	private int no;
	
	@Pattern(regexp = "[가-힣]+")
	@Schema(description = "몬스터 이름", nullable = false, example = "피카츄")
	private String name; 
	
	@Schema(description = "몬스터 속성", allowableValues = {"풀", "불", "전기", "무속성"},
			nullable = false, example = "전기")
	private String type;
	
	@JsonIgnore // JSON 생성 시 이 항목은 제외시켜라
	@Schema(hidden = true)
	public boolean isEmpty() {
		return no == 0 && name == null && type == null;
	}
}
