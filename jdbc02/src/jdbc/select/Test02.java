package jdbc.select;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.ProductDto;
import jdbc.mapper.ProductMapper;
import jdbc.util.JdbcUtils;

public class Test02 {
	public static void main(String[] args) {
		//JDBC 조회(select)
		
		String sql = "select * from product order by no asc";
		//Object[] data = {}
		
		ProductMapper mapper = new ProductMapper();	
		JdbcTemplate jdbctemplate = JdbcUtils.getJdbcTemplate();	
		List<ProductDto> list = jdbctemplate.query(sql, mapper);

		for(ProductDto dto:list) {
			System.out.println(dto);
		}
		
	}
}
