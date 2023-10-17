package com.kh.spring18.service;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.el.lang.ELArithmetic;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmailServiceImpl implements EmailService{
	@Autowired
	private JavaMailSender sender;
	
	@Override
	public void sendCelebration(String email) throws MessagingException, IOException {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");
		helper.setTo(email);
		helper.setSubject("[dori-house] 가입을 축하합니다!");
		
		ClassPathResource resource = new ClassPathResource("templates/celebration.html");
		Document doc = Jsoup.parse(resource.getFile(), "UTF-8"); //리소스의 파일을 꺼내서 Jsoup으로 읽어라
		
		//수신자 표시
		Element target = doc.getElementById("target");
		target.text(email);
		
		helper.setText(doc.toString(), true);
		
		sender.send(message);		
	}
}
