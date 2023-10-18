package com.kh.spring13;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test05 {

	@Autowired
	private JavaMailSender sender;
	
	@Test
	public void test() throws MessagingException, IOException {
		//목표 : 외부에 만들어놓은 파일에 있는 HTML을 불러와서 전송(/templates/email.html)
		MimeMessage message = sender.createMimeMessage(); //메시지 템플릿을 불러옴
		MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");
		
		helper.setTo("s_s0309@naver.com");
		helper.setSubject("이메일 템플릿 전송 예제");
//		helper.setText(?, true);
		
		// classpath에 있는 templates 폴더의 emial.html을 불러오는 코드
		ClassPathResource resource = new ClassPathResource("templates/email.html"); //classpath 자원 선택
		File target = resource.getFile(); //파일 추출
		Scanner sc = new Scanner(target); //읽을 수 있는 도구 연결
		StringBuffer buffer = new StringBuffer(); //저장할 수 있는 버퍼 생성
		while(sc.hasNextLine()) { //더 읽을 줄이 있다면
			buffer.append(sc.nextLine()); //읽어서 버퍼에 추가
		}
		sc.close();
		
		helper.setText(buffer.toString(), true); //읽은 내용을 이메일 본문으로 설정
		
		sender.send(message);
	}
}
