package com.kh.spring13;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class Test07 {

	@Autowired
	private JavaMailSender sender;
	
	@Test
	public void test() throws MessagingException, IOException {
		//목표 : 이메일에 첨부파일 넣고 전송하기
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		
		helper.setTo(new String[] {"s_s0309@naver.com"});
		helper.setSubject("첨부파일 테스트");
		helper.setText("첨부파일 확인해주세요!");
		
		//첨부파일을 찾아서 메일에 추가
		ClassPathResource resource = new ClassPathResource("static/images/man.png");
//		helper.addAttachment("마임맨", resource); //내가 파일명 설정
		helper.addAttachment(resource.getFilename(), resource); //파일명으로 보냄
		
		sender.send(message);
	}
}
