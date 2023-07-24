package jdbc.select;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.MemberDto;
import jdbc.mapper.MemberMapper;
import jdbc.util.JdbcUtils;

public class Test06 {
	public static void main(String[] args) {
		//로그인 프로그램
		//= SQL구문 : select * from member where member_id = ? (권장)
		//= SQL구문 : select * from member where member_id=? and member_pw =?
		//= Primary key 로 항목을 조회하는 것을 '단일조회' 라고 한다
		//= 모든 테이블은 단일 조회가 가능해야 한다
		//= 단일 조회는 결과가 없거나 한개이다
		
		//데이터
		String memberId = "testuser1";
		String memberPw = "Testuser1!";
		
		String sql = "select * from member where member_id =?";
		Object[] data = {memberId};
		MemberMapper mapper = new MemberMapper();
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		List<MemberDto> list = jdbcTemplate.query(sql, mapper, data);
		//list.size() == 0 or 1 (pk이기 때문에)
		
		//if(list.isEmpty()) {
		//	dto = null;
		//}
		//else {
		//	dto = list.get(0);
		
		MemberDto dto = list.isEmpty() ? null : list.get(0); //3항 연산자(if문 축소)
		//System.out.println(dto);
		
		//boolean isLogin = dto가 null이면서 dto의 비밀번호와 사용자 비밀번호가 같냐?
		boolean isLogin = dto != null && dto.getMemberPw().equals(memberPw);
		
		System.out.println(isLogin);
		
		}
	}

