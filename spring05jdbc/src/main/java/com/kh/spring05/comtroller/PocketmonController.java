package com.kh.spring05.comtroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring05.dao.PocketmonDao;
import com.kh.spring05.dto.PocketmonDto;

@RestController//등록하고
public class PocketmonController {

	@Autowired//필요한거 주세요
	private PocketmonDao dao;
	
	//@ModelAttribute는 필드에 값을 채우는 명령
	@RequestMapping("/insert")
	public String insert(
			@ModelAttribute PocketmonDto dto) {
		dao.insert(dto);
		return "포켓몬 등록 완료!";
	}
	
	@RequestMapping("/update")
	public String update(@ModelAttribute PocketmonDto dto) {
		boolean result = dao.update(dto);
		if(result) {
			return "포켓몬스터 정보 변경 완료";
		}
		else {
			return "해당 번호는 존재하지 않습니다";
		}
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam int no) {
		boolean result = dao.delete(no);
		
		if(result) {
			return "포켓몬스터 삭제 완료";
		}
		else {
			return "존재하지 않는 몬스터 번호";
		}
	}
	@RequestMapping("/list")
	public String list() {
		List<PocketmonDto> list = dao.selectList();
		StringBuffer buffer = new StringBuffer();
		for(PocketmonDto dto : list) {
			buffer.append(dto);
			buffer.append("\n");
		}
		return buffer.toString();
	}
	
	@RequestMapping("/detail")
	public String datail(@RequestParam int no) {
		PocketmonDto dto = dao.selectOne(no);
		if(dto == null) {
			return "존재하지 않는 포켓몬스터";
		}
		else {
			return dto.toString();
		}
	}
}


