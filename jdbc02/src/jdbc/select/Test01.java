package jdbc.select;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.PocketmonDto;
import jdbc.mapper.PocketmonMapper;
import jdbc.util.JdbcUtils;

public class Test01 {
	public static void main(String[] args) {
		//JDBC 조회(select)
		//- 두 가지 준비물이 필요하다
		//- 첫번째는 조회 결과 중 한 줄을 담을 객체(DTO)
		//- 두번째는 조회 결과를 DTO에 옮겨담는 방법을 가진 객체(Mapper)
		
		String sql = "select * from pocketmon order by no asc";
		//Object[] data = {}
		
		PocketmonMapper mapper = new PocketmonMapper();
		
		JdbcTemplate jdbctemplate = JdbcUtils.getJdbcTemplate();
		
		List<PocketmonDto> list = jdbctemplate.query(sql, mapper);
		
		System.out.println("조회 결과 : "+list.size());
		for(PocketmonDto dto : list) {
			System.out.println(dto);
		}
	}
}
