package com.kh.springhome.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.springhome.dto.MemberBlockDto;
import com.kh.springhome.dto.MemberDto;
import com.kh.springhome.dto.MemberListDto;
import com.kh.springhome.dto.StatDto;
import com.kh.springhome.mapper.MemberBlockMapper;
import com.kh.springhome.mapper.MemberListMapper;
import com.kh.springhome.mapper.MemberMapper;
import com.kh.springhome.mapper.StatMapper;
import com.kh.springhome.vo.PaginationVO;

@Repository
public class MemberDaoImpl implements MemberDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private MemberListMapper memberListMapper;


	@Override
	public void insert(MemberDto memberDto) {
		String sql = "insert into member("
								+ "member_id,"
								+ "member_pw,"
								+ "member_nickname,"
								+ "member_email,"
								+ "member_contact,"
								+ "member_birth,"
								+ "member_post,"
								+ "member_addr1,"
								+ "member_addr2) values(?,?,?,?,?,?,?,?,?)";
		Object[] data = {memberDto.getMemberId(), 
								memberDto.getMemberPw(), 
								memberDto.getMemberNickname(),
								memberDto.getMemberEmail(), 
								memberDto.getMemberContact(), 
								memberDto.getMemberBirth(),
								memberDto.getMemberPost(), 
								memberDto.getMemberAddr1(), 
								memberDto.getMemberAddr2()
				};
		jdbcTemplate.update(sql, data);
	}

	@Override
	public MemberDto selectOne(String memberId) {
		String sql = "select * from member where member_id=?";
		Object[] data = {memberId};
		List<MemberDto> list = jdbcTemplate.query(sql, memberMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public boolean updateMemberLogin(String memberId) {
		String sql = "update member set member_login=sysdate where member_id=?";
		Object[] data = {memberId};
		return jdbcTemplate.update(sql, data) >0;
	}

	@Override
	public boolean updateMemberPw(String memberId, String changePw) {
		String sql = "update member set member_pw=?, member_change=sysdate "
				+ "where member_id=?";
		Object[] data = {changePw, memberId};
		return jdbcTemplate.update(sql, data) >0; 
	}

	@Override
	public boolean updateMemberInfo(MemberDto memberDto) {
		String sql = "update member set "
				+ "member_nickname=?, member_email=?, member_contact=?, member_birth=?, "
				+ "member_post=?, member_addr1=?, member_addr2=? where member_id=?";
		Object[] data = {memberDto.getMemberNickname(), memberDto.getMemberEmail(),
				memberDto.getMemberContact(), memberDto.getMemberBirth(), memberDto.getMemberPost(),
				memberDto.getMemberAddr1(), memberDto.getMemberAddr2(), memberDto.getMemberId()};
		return jdbcTemplate.update(sql, data) >0; 
	}

	@Override
	public boolean deleteMember(String memberId) {
		String sql ="delete member where member_id=?";
		Object[] data = {memberId};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	//포인트 부여
	@Override
	public boolean increaseMemberPoint(String memberId, int point) {
		String sql = "update member set member_point = member_point + ? "
						+ "where member_id=?";
		Object[] data = {point, memberId};
		return jdbcTemplate.update(sql, data) >0;
	}
	
//	//페이징 추가된 목록
//	@Override
//	public List<MemberDto> selectListByPage(int page) {
//		
//		int begin = page * 10 - 9;
//		int end = page * 10 ;
//
//		String sql = "select * from ("
//							+ "select rownum rn, TMP.* from ( "
//								+ "select member_id, member_nickname, member_contact, "
//								+ "member_email, member_birth, member_level from member" 
//							+ ")TMP"
//						+ ") where rn between ? and ?";
//		
//		Object[] data = {begin, end};
//		return jdbcTemplate.query(sql, memberListMapper, data);
//	}
//	
//	//페이징 추가된 검색+목록
//	@Override
//	public List<MemberDto> selectListByPage(String type, String keyword, int page) {
//		
//		int begin = page * 10 - 9;
//		int end = page * 10 ;
//		
//		String sql = "select * from ("
//							+ "select rownum rn, TMP.* from ( "
//								+ "select member_id, member_nickname, member_contact, member_email, "
//								+ "member_birth, member_level "
//								+ "from member "
//								+ "where instr("+type+", ?) >0 "
//							+ ")TMP"
//						+ ") where rn between ? and ?";
//		Object[] data = {keyword, begin, end};
//		return jdbcTemplate.query(sql, memberListMapper, data);
//	}
	

	//목록+검색 처리
	@Override
	public int countList(PaginationVO vo) {
		if(vo.isSearch()) {//검색에 따른 카운트 결과
			String sql = "select count(*) from member where instr("+vo.getType()+",?)>0";
			Object[] data = {vo.getKeyword()};
			return jdbcTemplate.queryForObject(sql, int.class, data);
		}
		else {//목록에 따른 카운트 결과
			String sql = "select count(*) from member";
		return jdbcTemplate.queryForObject(sql, int.class);
		}
	}

	
	@Override
	public List<MemberDto> selectListByPage(PaginationVO vo) {
		if(vo.isSearch()) {
			String sql = "select * from ("
								+ "select rownum rn, TMP.* from ("
									+ "select * from member "
									+ "where instr("+vo.getType()+", ?) > 0 "
									+ "and member_level != '관리자' "
//									+ "order by member_id asc";
									+ "order by "+vo.getType()+" asc"
								+ ")TMP"
							+ ") where rn between ? and ?";
			Object[] data = {vo.getKeyword(), vo.getStartRow(), vo.getFinishRow()};
			return jdbcTemplate.query(sql, memberMapper, data);
		}
		else {
			String sql = "select * from ("
								+ "select rownum rn, TMP.* from ("
									+ "select * from member "
									+ "where member_level != '관리자' "
									+ "order by member_id asc"
								+ ")TMP"
							+ ") where rn between ? and ?";
			Object[] data = {vo.getStartRow(), vo.getFinishRow()};
			return jdbcTemplate.query(sql, memberMapper, data);
		}
	}
	
	@Override
	public boolean updateMemberInfoByAdmin(MemberDto memberDto) {
		String sql = "update member set "
				+ "member_nickname=?, "
				+ "member_email=?, "
				+ "member_contact=?, "
				+ "member_birth=?, "
				+ "member_post=?, "
				+ "member_addr1=?, "
				+ "member_addr2=?, "
				+ "member_level=?, "
				+ "member_point=? "
				+ "where member_id=?";
		Object[] data = {memberDto.getMemberNickname(), 
				memberDto.getMemberEmail(),
				memberDto.getMemberContact(), 
				memberDto.getMemberBirth(), 
				memberDto.getMemberPost(),
				memberDto.getMemberAddr1(), 
				memberDto.getMemberAddr2(), 
				memberDto.getMemberLevel(),
				memberDto.getMemberPoint(), 
				memberDto.getMemberId()};
		return jdbcTemplate.update(sql, data) >0; 
	}
	
	//차단+해제 기능
	@Override
	public void insertBlock(String memberId) {
		String sql = "insert into member_block(member_id) values(?)";
		Object[] data = {memberId};
		jdbcTemplate.update(sql, data);
	}
	
	@Override
	public boolean deleteBlock(String memberId) {
		String sql = "delete member_block where member_id=?";
		Object[] data = {memberId};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	public List<MemberListDto> selectListByPage2(PaginationVO vo) {
		if(vo.isSearch()) {
			String sql = "select * from ("
								+ "select rownum rn, TMP.* from ("
									+ "select * from member_list "
									+ "where instr("+vo.getType()+", ?) > 0 "
									+ "and member_level != '관리자' "
//									+ "order by member_id asc";
									+ "order by "+vo.getType()+" asc"
								+ ")TMP"
							+ ") where rn between ? and ?";
			Object[] data = {vo.getKeyword(), vo.getStartRow(), vo.getFinishRow()};
			return jdbcTemplate.query(sql, memberListMapper, data);
		}
		else {
			String sql = "select * from ("
								+ "select rownum rn, TMP.* from ("
									+ "select * from member_list "
									+ "where member_level != '관리자' "
									+ "order by member_id asc"
								+ ")TMP"
							+ ") where rn between ? and ?";
			Object[] data = {vo.getStartRow(), vo.getFinishRow()};
			return jdbcTemplate.query(sql, memberListMapper, data);
		}
	}
	
	@Autowired
	private MemberBlockMapper memberBlockMapper;
	
	@Override
	public List<MemberBlockDto> selectBlockList() {
		String sql = "select * from member_block order by block_time asc";
		return jdbcTemplate.query(sql, memberBlockMapper);
	}
	
	@Override
	public MemberBlockDto selectBlockOne(String memberId) {
		String sql = "select * from member_block where member_id=?";
		Object[] data = {memberId};
		List<MemberBlockDto> list = jdbcTemplate.query(sql, memberBlockMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}
	
	//닉네임 중복검사
		public MemberDto selectOneByMemberNickname(String memberNickname) {
			String sql = "select * from member where member_nickname=?";
			Object[] data = {memberNickname};
			List<MemberDto> list = jdbcTemplate.query(sql, memberMapper, data);
			return list.isEmpty() ? null : list.get(0);
		}
		
		@Autowired
		private StatMapper statMapper;
		
		@Override
		public List<StatDto> selectGroupByMemberLevel() {
			String sql = "select member_level name, count(*) cnt "
					+ "from member "
					+ "group by member_level "
					+ "order by cnt desc";
			return jdbcTemplate.query(sql, statMapper);
		}
		
		//프로필 사진 생성, 삭제
		@Override
		public void insertProfile(String memberId, int attachNo) {
			String sql = "insert into member_profile values(?,?)";
			Object[] data = {memberId, attachNo};
			jdbcTemplate.update(sql, data);
		}
		
		@Override
		public boolean deleteProfile(String memberId) {
			String sql = "delete member_profile where member_id=?";
			Object[] data = {memberId};
			return jdbcTemplate.update(sql, data) > 0;
		}
		
		@Override
		public Integer findProfile(String memberId) {
			String sql = "select attach_no from member_profile where member_id=?";
			Object[] data = {memberId};
			try {
				return  jdbcTemplate.queryForObject(sql, Integer.class, data);
			}
			catch(Exception e) {
				return null;
			}
		}
	}
