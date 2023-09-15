package com.kh.spring12.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring12.dao.AttachDao;
import com.kh.spring12.dto.AttachDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/file")
public class FileController {
	
	@Autowired
	private AttachDao attachDao;

	@PostMapping("/upload")
	public String upload(@RequestParam MultipartFile attach) throws IllegalStateException, IOException {
		log.info("name = {}", attach.getName()); //전송된 이름(파일명x)
		log.info("origin = {}", attach.getOriginalFilename()); //파일명
		log.info("size = {}", attach.getSize()); //파일크기(byte)
		log.info("contentType = {}", attach.getContentType()); //파일유형
		
		//절대규칙 - 파일은 하드디스크에, 정보는 DB에!
		
		//[1] 시퀀스 번호를 생성한다
		int attachNo = attachDao.sequence();
		
		//[2] 시퀀스 번호를 파일명으로 하여 실제 파일을저장한다
		//- 같은 이름에 대한 충돌을 방지하지 위해
		String home = System.getProperty("user.home");
		File dir = new File(home, "upload"); //저장할디렉터리
		dir.mkdirs(); //디렉터리 생성
		
		File target = new File(dir, String.valueOf(attachNo)); //저장할파일(파일 이름 중복 가능성 있음)
		attach.transferTo(target); //지금 받은 첨부파일에 실제 파일 정보 합쳐서 가져다 넣어라 
		
		//[3] DB에 저장한 파일의 정보를 모아서 INSERT
		AttachDto attachDto = new AttachDto();
		attachDto.setAttachNo(attachNo); //실제 저장된 이름
		attachDto.setAttachName(attach.getOriginalFilename()); //사용자가 업로드한 이름
		attachDto.setAttachSize(attach.getSize());
		
		attachDto.setAttachType(attach.getContentType());
		attachDao.insert(attachDto);
		
		return "페이지정보";
	}
	
}
