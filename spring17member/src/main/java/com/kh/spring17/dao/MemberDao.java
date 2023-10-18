package com.kh.spring17.dao;

import java.util.List;

import com.kh.spring17.dto.MemberDto;
import com.kh.spring17.vo.MemberComplexSearchVO;

public interface MemberDao {

	List<MemberDto> complexSearch(MemberComplexSearchVO vo);
}
