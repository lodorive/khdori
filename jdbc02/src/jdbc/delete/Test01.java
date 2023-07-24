package jdbc.delete;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcUtils;

public class Test01 {
	public static void main(String[] args) {
		//포켓몬스터 정보 삭제 프로그램
		//delete pocketmon where no = ?
		
		
		//데이터
		int no = 43;
		
		//DB처리
		String sql = "delete pocketmon where no = ?";
		Object[] data = {no};
		
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		
		int result = jdbcTemplate.update(sql, data);
		
		System.out.println("result = " + result);
	}
}