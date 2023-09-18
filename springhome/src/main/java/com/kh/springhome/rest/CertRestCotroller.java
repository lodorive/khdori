package com.kh.springhome.rest;

import java.text.DecimalFormat;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.springhome.dao.CertDao;
import com.kh.springhome.dto.CertDto;

@CrossOrigin
@RestController
@RequestMapping("/rest/cert")
public class CertRestCotroller {
	
	@Autowired
	private CertDao certDao;
	
	@Autowired
	private JavaMailSender sender;
	
	@PostMapping("/send")
	public void send(@RequestParam String certEmail) {
		//[1] 인증번호 생성
		Random r = new Random();
		int number = r.nextInt(1000000);
		DecimalFormat fm = new DecimalFormat("000000"); //6자리가 안되면 앞에 0이 붙어서 나옴
		String certNumber = fm.format(number);
		
		//[2] 이메일 발송
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(certEmail);
		message.setSubject("[KH정보교육원] 인증번호코드");
		message.setText("인증번호코드 [" +certNumber+"]");
		sender.send(message);
		
		//[3] DB에 저장(기존 데이터 삭제)
		certDao.delete(certEmail);
		CertDto certDto = new CertDto();
		certDto.setCertEmail(certEmail);
		certDto.setCertNumber(certNumber);
		certDao.insert(certDto);
	}
	
//	@PostMapping("/check")
	
}
