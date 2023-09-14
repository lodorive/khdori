package com.kh.springhome.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data //@Setter&@Getter&@ToString&@EqualsAndHashCode
//@Setter @Getter @NoArgsConstructor @ToString
public class PocketmonDto {
	private int no;
	private String name;
	private String type;	
	private boolean image;
}
