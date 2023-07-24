package jdbc.select;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.MemberDto;
import jdbc.mapper.MemberMapper;
import jdbc.util.JdbcUtils;

public class Test05 {
	public static void main(String[] args) {
		//회원 조회
		String sql = "select * from member order by member_id asc";

		MemberMapper mapper = new MemberMapper();
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		List<MemberDto> list = jdbcTemplate.query(sql, mapper);
		
		if(list.isEmpty()) {
			System.out.println("회원이 존재하지 않습니다");
		}
		else {
			System.out.println("총 "+list.size()+"명의 회원이 있습니다");
			for(MemberDto dto:list) {
				System.out.println(dto.getMemberId());
			}
		}
	}
}
