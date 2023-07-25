package jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.ProductDto;
import jdbc.util.JdbcUtils;

public class ProductDao {
	
	public void insert(ProductDto dto) {
		String sql = "insert into product(no, name, type, price, made, expire)"
				+ "values(product_seq.nextval,?,?,?,?,?)"; //DTO가 date인 경우
		//to_date(?,'yyyy-mm-dd') DTO가 문자열이면
		
		Object[] data = {dto.getName(), dto.getType(), dto.getPrice(), dto.getMade(), dto.getExpire()};
		
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		jdbcTemplate.update(sql, data);
	}
	
	//삭제 기능
	
	public boolean delete(int no) {
		String sql = "delete product where no=?";
		Object[] data = {no};
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		return jdbcTemplate.update(sql, data) > 0;						
	}
}
