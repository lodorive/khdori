package com.kh.spring22.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "도서 정보 객체")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BookDto {
	private int bookId;
	private String bookTitle;
	private String bookAuthor;
	private String bookPublicationDate;
	@Builder.Default
	private float bookPrice = -1f;
	private String bookPublisher;
	private int bookPageCount;
	private String bookGenre;
}
