package jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import jdbc.dto.MemberDto;

public class MemberMapper implements RowMapper<MemberDto>{

	@Override
	public MemberDto mapRow(ResultSet rs, int idx) throws SQLException {

		MemberDto dto = new MemberDto();
		dto.setMemberId(rs.getString("MEMBER_ID"));
		dto.setMemberPw(rs.getString("MEMBER_PW"));
		dto.setMemberNickname(rs.getString("MEMBER_NICKNAME"));
		dto.setMemberBirth(rs.getString("MEMBER_BIRTH"));
		dto.setMemberEmail(rs.getString("MEMBER_EMAIL"));
		dto.setMemberContact(rs.getString("MEMBER_CONTACT"));
		dto.setMemberLevel(rs.getString("MEMBER_LEVEL"));
		dto.setMemberPoint(rs.getInt("MEMBER_POINT"));
		dto.setMemberJoin(rs.getDate("MEMBER_JOIN"));		
		return dto;
	}
}
