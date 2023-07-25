package jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.MemberDto;
import jdbc.mapper.MemberMapper;
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
	
	//비밀번호 변경 기능
	//1 기존 비밀번호와 신규 비밀번호를 입력받아 검사 후 변경(권장하진 않음)
	//2 임시 비밀번호 변경하는 기능
	//3 아이디에 맞는 계정의 비밀번호를 변경하는 기능
	//public boolean updatePassword(memberDto dto, String newPw) //1번의 경우
	//public boolean updatePassword(String memberId) //2번의 경우
	//public boolean updatePassword(String memberId, String memberPw) //3번의 경우
	public boolean updatePassword(MemberDto dto) {
		String sql = "update member set member_pw=? where member_id=?";
		Object[] data = {dto.getMemberPw(), dto.getMemberId()};
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	//회원정보 변경
	public boolean updateMemberInfo(MemberDto dto) {
		String sql = "update member set member_nickname=?, member_birth=?, "
				+ "member_email=?, member_contact=? where member_id=?";
		Object[] data = {dto.getMemberNickname(), dto.getMemberBirth(), 
				dto.getMemberEmail(), dto.getMemberContact(), dto.getMemberId()};
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		jdbcTemplate.update(sql, data);
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	//삭제 기능 
	public boolean delete(String memberId) {
		String sql = "delete member where member_id=?";
		Object[] data = {memberId};
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		return jdbcTemplate.update(sql, data) > 0;						
	}
	
	//Mapper 생성
	private MemberMapper mapper = new MemberMapper();
	
	//회원 전체 목록
	public List<MemberDto> selectList(){
		String sql = "select * from member";
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		return jdbcTemplate.query(sql, mapper);
	} 
	
	//회원 목록(+pagination)
	public List<MemberDto> selectListByPage(int page, int size){
		int end = page * size;
		int begin = end - (size-1);
		
		String sql = "select * from ("
					+ "	select rownum rn, TMP.* from ("
					+ "	select * from member"
					+ "	)TMP"
					+ "	) where rn between ? and ?";
		Object[] data = {begin, end};
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		return jdbcTemplate.query(sql, mapper, data);
	}
}

