package com.kh.spring22.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring22.dao.BookDao;
import com.kh.spring22.dto.BookDto;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin
@RestController
@RequestMapping("/book")
public class BookRestController {

	@Autowired
	private BookDao bookDao;
	
	@GetMapping("/")
	public List<BookDto> list() {
		return bookDao.selectList();
	}
	
	@PostMapping("/")
	public void insert(@RequestBody BookDto bookDto) {
		bookDao.insert(bookDto);
	}
	
	@DeleteMapping("/{bookId}")
	public ResponseEntity<String> delete(@PathVariable int bookId){
		boolean result = bookDao.delete(bookId);
		if(result) {
			return ResponseEntity.status(200).build();
		}
		else {
			return ResponseEntity.status(404).build();
		}
	}
	
	@GetMapping("/{bookId}")
	public ResponseEntity<BookDto> find(@PathVariable int bookId){
		BookDto bookDto = bookDao.selectOne(bookId);
		if(bookDto != null) { //dto가 null이 아닐 때 
			return ResponseEntity.ok(bookDto); //pocketmonDto를 반환하고
			
		}
		else { //null이라면
			return ResponseEntity.notFound().build(); //404가 뜨게 해라
		}
	}
}
