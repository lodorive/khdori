package jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.MemberDto;
import jdbc.util.JdbcUtils;

public class MemberDao {
	
	public void insert(MemberDto dto) {
		//String sql = "insert into member(MEMBER_ID, MEMBER_PW, MEMBER_NICKNAME, MEMBER_BIRTH,"
		//				+ "MEMBER_EMAIL, MEMBER_CONTACT, MEMBER_LEVEL, MEMBER_POINT, MEMBER_JOIN)"
		//				+ "values(?,?,?,?,?,?,'일반',0,sysdate)";
		
		String sql = "insert into member(MEMBER_ID, MEMBER_PW, MEMBER_NICKNAME, MEMBER_BIRTH,"
				+ "MEMBER_EMAIL, MEMBER_CONTACT, MEMBER_LEVEL, MEMBER_POINT, MEMBER_JOIN)"
				+ "values(?,?,?,?,?,?)";
		
		Object[] data = {
				dto.getMemberId(), dto.getMemberPw(), dto.getMemberNickname(),
				dto.getMemberBirth(), dto.getMemberEmail(), dto.getMemberContact()
			};
		
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		jdbcTemplate.update(sql, data);
	}
}
