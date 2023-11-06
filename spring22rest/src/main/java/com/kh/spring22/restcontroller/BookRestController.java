package com.kh.spring22.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring22.dao.BookDao;
import com.kh.spring22.dto.BookDto;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "도서 관리", description = "도서 정보 관리를 위한 컨트롤러")
@CrossOrigin
@RestController
@RequestMapping("/book")
public class BookRestController {

	@Autowired
	private BookDao bookDao;
	
	@GetMapping("/")
	public List<BookDto> list(){
		return bookDao.selectList();
	}
	
	@GetMapping("/bookId/{bookId}")
	public BookDto find(@PathVariable int bookId) {
		return bookDao.selectOne(bookId);
	}
	
	@GetMapping("/bookTitle/{bookTitle}")
	public List<BookDto> search(@PathVariable String bookTitle) {
		return bookDao.searchList(bookTitle);
	}
	
	@PostMapping("/")
	public void insert(@RequestBody BookDto bookDto) {
		bookDao.insert(bookDto);
	}
	
	@PutMapping("/{bookId}")
	public void update(@RequestBody BookDto bookDto, @PathVariable int bookId) {
		//bookDto에 모든 항목이 있는지 검사해야함
		bookDao.edit(bookId, bookDto);
	}
	@PatchMapping("/{bookId}")
	public void update2(@RequestBody BookDto bookDto, @PathVariable int bookId) {
		//bookDto에 항목이 하나라도 있는지 검사해야함
		bookDao.edit(bookId, bookDto);
	}
	@DeleteMapping("/{bookId}")
	public void delete(@PathVariable int bookId) {
		bookDao.delete(bookId);
	}
}
