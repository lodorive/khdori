package com.kh.spring08.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring08.dto.MemberDto;
import com.kh.spring08.mapper.MemberMapper;

@Repository
public class MemberDao {
	@Autowired
	private JdbcTemplate jdbctemplate;
	@Autowired
	private MemberMapper mapper;
	
	//등록
	public void insert(MemberDto dto) {
		String sql = "insert into member(member_id, member_pw, member_nickname, "
				+ "member_birth, member_email, member_contact, member_level, "
				+ "member_point, member_join) "
				+ "values(?,?,?,?,?,?,'일반',0,sysdate)";
		Object[] data = {
				dto.getMemberId(), dto.getMemberPw(), dto.getMemberNickname(),
				dto.getMemberBirth(), dto.getMemberEmail(), dto.getMemberContact()
		};
		jdbctemplate.update(sql, data);
	}
	
	//목록
	public List<MemberDto> selectList(){
		String sql = "select * from member order by member_id asc";
		return jdbctemplate.query(sql, mapper);
	}
	
	//상세
	public MemberDto selectOne(String memberId) {
		String sql = "select * from member where member_id=?";
		Object[] data= {memberId};
		List<MemberDto> list = jdbctemplate.query(sql, mapper, data);
		return list.isEmpty() ? null : list.get(0);
	}
	
	//변경(비밀번호)
	public boolean updateMemberPw(MemberDto dto) {
		String sql = "update member set member_pw=? where member_id=?";
		Object[] data = {dto.getMemberPw(), dto.getMemberId()
	};
		return jdbctemplate.update(sql, data) > 0;		
	}
	
	//변경(개인정보)
	public boolean update(MemberDto dto) {
		String sql = "update member set member_nickname=?, "
				+ "member_birth=?, member_email=?, member_contact=? "
				+ "where member_id=?";
		Object[] data = {
				dto.getMemberNickname(), dto.getMemberBirth(), 
				dto.getMemberEmail(), dto.getMemberContact(), 
				dto.getMemberId()
		};
		return jdbctemplate.update(sql, data) >0;
	}
	//삭제
	public boolean delete(String memberId) {
		String sql = "delete member where member_id=?";
		Object[] data = {memberId};
		return jdbctemplate.update(sql, data) >0;
	}
}
