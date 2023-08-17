package com.kh.springhome.controller;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.springhome.dao.BoardDao;
import com.kh.springhome.dao.MemberDao;
import com.kh.springhome.dto.BoardDto;
import com.kh.springhome.error.AuthorityException;
import com.kh.springhome.error.NoTargetException;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private MemberDao memberDao;
	
	//등록
	@GetMapping("/write")
	public String write() {
		return "/WEB-INF/views/board/write.jsp";
	}
		
	@PostMapping("/write")
   public String write(@ModelAttribute BoardDto boardDto, HttpSession session) {
	     int boardNo = boardDao.sequence();
	     boardDto.setBoardNo(boardNo);
	     
	     String memberId = (String) session.getAttribute("name");
	     boardDto.setBoardWriter(memberId);
	     
	     //이 사용자의 마지막 글번호를 조회
	     Integer lastNo = boardDao.selectMax(memberId);
	     
	     //글을 등록하고
	     boardDao.insert(boardDto); 
	     
	     //포인트 계산 작업
	     //- lastNo가 null이라는 것은 처음 글을 작성했다는 의미
	     //- lastNo가 null이 아니면 조회한 다음 시간차를 비교
	     if(lastNo == null) {//처음이라면
	    	 memberDao.increaseMemberPoint(memberId, 10); //포인트 10점 부여	    	 
	     }
	     else{//처음이 아니라면 시간 차이를 계산
	    	 BoardDto lastDto = boardDao.selectOne(lastNo);
	    	 Timestamp stamp = new Timestamp(lastDto.getBoardCtime().getTime());
	    	 LocalDateTime lastTime = stamp.toLocalDateTime();
	    	 LocalDateTime currentTime = LocalDateTime.now();
	    	 
	    	 Duration duration = Duration.between(lastTime, currentTime);
	    	 long seconds = duration.getSeconds(); //지금 작성시간과 마지막 작성시간의 차이
	    	 if(seconds > 300) { //5분이 넘어가면(시간차가 300초보다 크다면)
	    		 memberDao.increaseMemberPoint(memberId, 10); //포인트 10점 부여
	    	 }
	     }
	     
	     return "redirect:detail?boardNo=" + boardNo;
	   }
	
	//상세
	@RequestMapping("/detail")
	public String detail(@RequestParam int boardNo, Model model) {
		
//		if(조회수를 올릴만한 상황이면) {
		boardDao.updateBoardReadcount(boardNo); //조회수 증가
//		}
		BoardDto boardDto = boardDao.selectOne(boardNo); //조회수
		model.addAttribute("boardDto", boardDto);
		return "/WEB-INF/views/board/detail.jsp";				
	}
	
	//목록+검색
	//- 검색일 경우에는 type과 keyword라는 파라미터가 존재
	//- 목록일 경우에는 type과 keyword라는 파라미터가 없음
	//- 만약 불완전한 상태(type이나 keyword만 있는 경우)라면 목록으로 처리
	@RequestMapping("/list")
	public String list(Model model, 
			@RequestParam(required=false) String type,
			@RequestParam(required=false) String keyword) {
		boolean isSearch = type != null && keyword != null;
		
		if(isSearch) {//검색일경우
			List<BoardDto> list = boardDao.selectList(type, keyword);
			model.addAttribute("list", list);
			model.addAttribute("isSearch", true);
		}
		else {//목록일 경우
			List<BoardDto> list = boardDao.selectList();
			model.addAttribute("list", list);
			model.addAttribute("isSearch", false);
//			model.addAttribute("list", boardDao.selectList());			
		}
		return "/WEB-INF/views/board/list.jsp";	
	}
//	
//	//수정(접근 권한을 컨트롤러로)
//	@GetMapping("/edit")
//	public String edit(@RequestParam int boardNo, Model model, HttpSession session) {
//		String memberId = (String) session.getAttribute("name");
//		BoardDto boardDto = boardDao.selectOne(boardNo);
//		
//		if(boardDto.getBoardWriter().equals(memberId)) {
//			model.addAttribute("boardDto",boardDto);
//			return "/WEB-INF/views/board/edit.jsp";			
//		}
//		else {
//			return "redirect:edit?error";
//		}
//	}

//	//(접근 권한을 컨트롤러로)
//	@PostMapping("/edit")
//	public String edit(@ModelAttribute BoardDto inputDto, Model model, HttpSession session, 
//			@RequestParam int boardNo) {
//		
//		String memberId = (String) session.getAttribute("name");
//		BoardDto findDto = boardDao.selectOne(boardNo);
//	    
//		if(findDto.getBoardWriter().equals(memberId)) {
//			boolean updateDto = boardDao.updateBoardUtime(inputDto.getBoardNo()); //수정시각
//			boolean result = boardDao.updateBoard(inputDto); //게시글 수정
//			model.addAttribute("inputDto",inputDto);
//			return "redirect:detail?boardNo="+findDto.getBoardNo();
//		}
//		else {
//				return "redirect:에러페이지";
//		}
//	}
	
	//수정
	@GetMapping("/edit")
	public String edit(@RequestParam int boardNo, Model model) {
		BoardDto boardDto = boardDao.selectOne(boardNo);
		model.addAttribute("boardDto", boardDto);
		return "/WEB-INF/views/board/edit.jsp";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute BoardDto boardDto) {
		boolean result = boardDao.updateBoard(boardDto);
		if(result) {
			return "redirect:detail?boardNo="+boardDto.getBoardNo();
		}
		else {
			throw new NoTargetException("존재하지 않는 게시글 번호");
		}
	}

	//삭제
	//-만약 소유자 검사를 추가한다면 
	//-현재 로그인 한 사용자와 게시글 작성자가 같다면 소유자로 판정
	@RequestMapping("/delete")
	public String delete(@RequestParam int boardNo, HttpSession session) {
		BoardDto boardDto = boardDao.selectOne(boardNo);
		String boardWriter = boardDto.getBoardWriter();
		
		String memberId = (String) session.getAttribute("name");
		
		if(memberId.equals(boardWriter)) {//소유자라면
			boardDao.deleteBoard(boardNo);			
			return "redirect:list";
		}
		else {
			throw new AuthorityException("글 작성자가 아닙니다");
		}
	}
}
		
//	@RequestMapping("/delete")
//	public String delete(@RequestParam int boardNo) {
//		boolean result = boardDao.deleteBoard(boardNo);
//		if(result) {
//			return "redirect:list";
//		}
//		else {
//			throw new NoTargetException("없는 게시글 번호");
//		}
//	}
	
