package jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import jdbc.dto.BookDto;

public class BookMapper implements RowMapper<BookDto> {

	@Override
	public BookDto mapRow(ResultSet rs, int idx) throws SQLException {
		
		BookDto dto = new BookDto();
		dto.setBookId(rs.getInt("BOOK_ID"));
		dto.setBookTitle(rs.getString("BOOK_TITLE"));
		dto.setBookAuthor(rs.getString("BOOK_AUTHOR"));
		dto.setBookPublication(rs.getString("BOOK_PUBLICATION_DATE"));
		dto.setBookPrice(rs.getFloat("BOOK_PRICE"));
		dto.setBookPublisher(rs.getString("BOOK_PUBLISHER"));
		dto.setBookPageCount(rs.getInt("BOOK_PAGE_COUNT"));
		dto.setBookGenre(rs.getString("BOOK_GENRE"));
		return dto;
	}

}
