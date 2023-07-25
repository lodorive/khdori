package jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.BookDto;
import jdbc.util.JdbcUtils;

public class BookDao {
	
	public void insert(BookDto dto) {
		
		String sql = "insert into book(book_id, book_title, book_author, book_publication_date, book_price, "
				+ "book_publisher, book_page_count, book_genre)"
				+ "values(book_seq.nextval,?,?,?,?,?,?,?)";
		Object[] data = {dto.getBookTitle(), dto.getBookAuthor(), dto.getBookPublication(),
				dto.getBookPrice(), dto.getBookPublisher(), dto.getBookPageCount(), dto.getBookGenre()};
		
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		jdbcTemplate.update(sql, data);
	}
	
	//가격 수정
	public boolean updateBookPrice(BookDto dto) {
			String sql = "update book set book_price=? where book_id=?";
			Object[] data = {dto.getBookPrice(), dto.getBookId()};
			JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
			return jdbcTemplate.update(sql, data) > 0;
	}
	
	//나머지 정보 수정
	public boolean updateBookInfo(BookDto dto) {		
			String sql = "update book set book_title=?, book_author=?, book_publisher=? where book_id=?";
			Object[] data = {dto.getBookTitle(), dto.getBookAuthor(), dto.getBookPublisher(), dto.getBookId()};
			JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
			return jdbcTemplate.update(sql, data) > 0;
	}
}
