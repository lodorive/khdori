package jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import jdbc.dto.ProductDto;

public class ProductMapper implements RowMapper<ProductDto> {

	@Override
	public ProductDto mapRow(ResultSet rs, int idx) throws SQLException {
		ProductDto dto = new ProductDto();
		dto.setNo(rs.getInt("no"));
		dto.setName(rs.getString("name"));
		dto.setType(rs.getString("type"));
		dto.setPrice(rs.getInt("price"));
		dto.setMade(rs.getDate("made"));
		dto.setExpire(rs.getDate("expire"));
		return dto;
	}

}
