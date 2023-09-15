package com.kh.springhome.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kh.springhome.dao.AttachDao;
import com.kh.springhome.dao.PocketmonDao;
import com.kh.springhome.dto.AttachDto;
import com.kh.springhome.dto.PocketmonDto;

@Controller
@RequestMapping("/pocketmon")
public class PocketmonController {
	
	@Autowired
	private PocketmonDao pocketmonDao;
	
	@Autowired
	private AttachDao attachDao;
	
	@GetMapping("/insert")
	public String insert() {
		return "/WEB-INF/views/pocketmon/insert.jsp";
	}
	
	@PostMapping("/insert")
	public String insert(
			@ModelAttribute PocketmonDto pocketmonDto, 
			@RequestParam MultipartFile attach) throws IllegalStateException, IOException {//포켓몬정보, 첨부파일
		
		//포켓몬 등록(무조건)
		int no = pocketmonDao.sequence();
		pocketmonDto.setNo(no);
		pocketmonDao.insert(pocketmonDto);
		
		if(!attach.isEmpty()) { //파일이 있으면
			//첨부파일 등록(파일이 있을 때만)
			int attachNo = attachDao.sequence();
			
			String home = System.getProperty("user.home");
			File dir = new File(home, "upload");
			dir.mkdirs();
			File target = new File(dir, String.valueOf(attachNo));
			
			attach.transferTo(target);
			
			AttachDto attachDto = new AttachDto();
			attachDto.setAttachNo(attachNo);
			attachDto.setAttachName(attach.getOriginalFilename());
			attachDto.setAttachSize(attach.getSize());
			attachDto.setAttachType(attach.getContentType());
			attachDao.insert(attachDto);
			
			//연결(파일이 있을 때만)
			pocketmonDao.connect(no, attachNo);						
		}
		
		return "redirect:insert";
	}
	
		//파일 다운로드
		//- 파일번호(attach_no)을 이용하여 정보를 조회
		//- 실물 파일을 불러와서 사용자에게 전송
		//- 화면이 아니라 파일을 전송해야 하므로 RestController처럼 처리
		//- 매핑 위에 @ResponseBody라고 추가하면 가능
		@ResponseBody //화면을 내보내지 않는다는 뜻
		@RequestMapping("/image")
		public ResponseEntity<ByteArrayResource> 
							image(@RequestParam int no) throws IOException {
			//[1] 포켓몬 번호로 파일 번호를 찾아야 한다
			//[2] 파일 번호로 파일 정보를 불러와야 한다
			//[3] 실제 파일을 불러와야 한다
			//[4] 앞에서 불러온 모든 정보로 ResponseEntity를 생성한다
			//[5] 사용자한테 준다
			
			//1,2 
			AttachDto attachDto = pocketmonDao.findImage(no);
			if(attachDto == null) {
//				throw new NoTargetException("파일 없음"); //내가 만든 예외로 통합
				 return ResponseEntity.notFound().build(); //404 반환
			}
			
			//3
			String home = System.getProperty("user.home");
			File dir = new File(home, "upload");
			File target = new File(dir, String.valueOf(attachDto.getAttachNo()));
			
			byte[] data = FileUtils.readFileToByteArray(target); //실제 파일 정보 불러오기
			ByteArrayResource resource= new ByteArrayResource(data);
			
			//4,5 - header(정보), body(내용)
			return ResponseEntity.ok()
				.header("Content-Encoding", "UTF-8")
				.header("Content-Length", String.valueOf(attachDto.getAttachSize()))
				.header("Content-Type", attachDto.getAttachType()) //저장된 유형
//				.header("Content-Type", "application/octet-stream") //무조건 다운로드
				.header("Content-Disposition", "attachment; filename="+attachDto.getAttachName())
				.body(resource);
		}
			
		//상세 페이지
		@RequestMapping("/detail")
		public String detail(@RequestParam int no, Model model) {
			PocketmonDto pocketmonDto = pocketmonDao.selectOne(no);
			model.addAttribute("pocketmonDto",pocketmonDto);
			return "/WEB-INF/views/pocketmon/detail.jsp";
		}
		
		//목록 페이지
		@RequestMapping("/list")
		public String list(Model model) {
			List<PocketmonDto> list = pocketmonDao.selectList();
			model.addAttribute("list", list);
			return "/WEB-INF/views/pocketmon/list.jsp";
		}
		
			
}
