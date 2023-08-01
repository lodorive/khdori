package com.kh.spring08.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.spring08.dto.MemberDto;

@Component
public class MemberMapper implements RowMapper<MemberDto>{
	@Override
	public MemberDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberDto dto = new MemberDto();
		dto.setMemberId(rs.getString("member_id"));
		dto.setMemberPw(rs.getString("member_pw"));
		dto.setMemberNickname(rs.getString("member_nickname"));
		dto.setMemberBirth(rs.getString("member_birth"));
		dto.setMemberContact(rs.getString("member_contact"));
		dto.setMemberEmail(rs.getString("member_email"));
		dto.setMemberLevel(rs.getString("member_level"));
		dto.setMemberPoint(rs.getInt("member_point"));
		dto.setMemberJoin(rs.getDate("member_join"));
		return dto;
	}
}
