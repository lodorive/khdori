package jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcUtils;

//DAO 클래스
//= Data Access Object. DB 담당 처리반
//= 해당 테이블에 필요한 기능들을 '메소드'로 구현
//= 기본적으로 C(등록), R(목록), R(상세), U(수정), D(삭제)가 필요
public class PocketmonDao {

	//C(등록) 메소드
	public void insert(int no, String name, String type) {
		String sql = "insert into Pocketmon(no, name, type) "
				+ "values(?,?,?)";
		Object[] data = {no, name, type};
		
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		jdbcTemplate.update(sql, data);
	}
	
}
