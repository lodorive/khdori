package com.kh.spring10.dto;

import lombok.Data;

@Data
public class BookDto {
	private int bookId;
	private String bookTitle;
	private String bookAuthor;
	private String bookPublicationDate;
	private float bookPrice;
	private String bookPublisher;
	private int bookPageCount;
	private String bookGenre;
}
