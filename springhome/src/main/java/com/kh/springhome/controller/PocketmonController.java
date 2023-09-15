package com.kh.springhome.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
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
		
		return "redirect:detail?no=" +pocketmonDto.getNo();
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
//				.header("Content-Encoding", "UTF-8")
				.header(HttpHeaders.CONTENT_ENCODING, StandardCharsets.UTF_8.name())
//				.header("Content-Length", String.valueOf(attachDto.getAttachSize()))
				.contentLength(attachDto.getAttachSize())
//				.header("Content-Type", attachDto.getAttachType()) //저장된 유형
				.header(HttpHeaders.CONTENT_TYPE, attachDto.getAttachType())
//				.header("Content-Type", "application/octet-stream") //무조건 다운로드
//				.contentType(MediaType.APPLICATION_OCTET_STREAM)
//				.header("Content-Disposition", "attachment; filename="+attachDto.getAttachName())
				.header(HttpHeaders.CONTENT_DISPOSITION, 
						ContentDisposition.attachment().
						filename(attachDto.getAttachName(), StandardCharsets.UTF_8)
						.build().toString()
						)
//				.header("Content-Disposition", ContentDisposition.attachment()
//										.filename(attachDto.getAttachName(), StandardCharsets.UTF_8)
//									.build().toString())
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
		
		//삭제
		//- [1] 포켓몬 삭제 [2] 파일 정보 삭제 [3] 실제파일 삭제
		@RequestMapping("/delete")
		public String delete(@RequestParam int no) {
			AttachDto attachDto = pocketmonDao.findImage(no);
			pocketmonDao.delete(no); //포켓몬+이미지연결정보 삭제
			
			if(attachDto != null) {
				String home = System.getProperty("user.home");
				File dir = new File(home, "upload");
				File target = new File(dir, String.valueOf(attachDto.getAttachNo()));
				target.delete(); //실제파일 삭제		
				
				attachDao.delete(attachDto.getAttachNo()); //파일정보 삭제
			}
			return "redirect:list";
		}
		
		//수정
		@GetMapping("/edit")
		public String edit(@RequestParam int no, Model model) {
			PocketmonDto pocketmonDto = pocketmonDao.selectOne(no);
			model.addAttribute("pocketmonDto",pocketmonDto);
			return "/WEB-INF/views/pocketmon/edit.jsp";
		}
		
		//수정 처리를 할 때 첨부파일 유무에 따라 다른 처리를 해야 한다
		//- 첨부파일이 없으면 기존 첨부파일을 유지(아무것도 안하면 됨)
		//- 첨부파일이 있으면 기존 첨부파일을 변경(변경 대신 삭제+등록)
		@PostMapping("/edit")
		public String edit(@ModelAttribute PocketmonDto pocketmonDto, 
								@RequestParam MultipartFile attach) throws IllegalStateException, IOException {
			//포켓몬스터 정보 변경
			pocketmonDao.update(pocketmonDto);
			
			if(!attach.isEmpty()) {//파일이 있으면
				//파일 삭제 - 기존 파일이 있을 경우에만 처리
				AttachDto attachDto = pocketmonDao.findImage(pocketmonDto.getNo());
				
				String home = System.getProperty("user.home");
				File dir = new File(home, "upload");
				
				if(attachDto != null) {
					attachDao.delete(attachDto.getAttachNo());
					
					File target = new File(dir, String.valueOf(attachDto.getAttachNo()));
					target.delete(); //실제 파일 삭제
				}
				
				//파일 추가 및 연결
				//파일번호 생성
				int attachNo = attachDao.sequence();
				
				//신규파일 저장
				File insertTarget = new File(dir, String.valueOf(attachNo));
				attach.transferTo(insertTarget);
				
				//신규파일 정보 저장
				AttachDto insertDto = new AttachDto();
				insertDto.setAttachNo(attachNo);
				insertDto.setAttachName(attach.getOriginalFilename());
				insertDto.setAttachSize(attach.getSize());
				insertDto.setAttachType(attach.getContentType());
				attachDao.insert(insertDto);
				
				//포켓몬 + 파일 연결
				pocketmonDao.connect(pocketmonDto.getNo(), attachNo);
			}
			return "redirect:detail?no=" +pocketmonDto.getNo();
		}
}
