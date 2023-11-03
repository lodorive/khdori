package com.kh.spring22.configuration;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
		info = @Info(
				title = "테스트용 REST API 서비스",
				description = "KH정보교육원 백엔드 수업자료",
				version = "v1",
				contact = @Contact(
						name = "루이바오",
						email = "bao@kh.com",
						url = "https://github.com/bao"
				)
		)
)

@Configuration
public class RestApiConfiguration {

}
