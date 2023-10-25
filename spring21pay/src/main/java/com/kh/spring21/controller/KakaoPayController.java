package com.kh.spring21.controller;

import java.net.URISyntaxException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring21.dao.ProductDao;
import com.kh.spring21.dto.ProductDto;
import com.kh.spring21.service.KakaoPayService;
import com.kh.spring21.vo.KakaoPayApproveRequestVO;
import com.kh.spring21.vo.KakaoPayApproveResponseVO;
import com.kh.spring21.vo.KakaoPayCancleRequestVO;
import com.kh.spring21.vo.KakaoPayCancleResponseVO;
import com.kh.spring21.vo.KakaoPayDetailRequestVO;
import com.kh.spring21.vo.KakaoPayDetailResponseVO;
import com.kh.spring21.vo.KakaoPayReadyRequestVO;
import com.kh.spring21.vo.KakaoPayReadyResponseVO;

@Controller
@RequestMapping("/pay")
public class KakaoPayController {
	
	@Autowired
	private KakaoPayService kakaoPayService;

	@GetMapping("/test1")
	public String test1() {
		return "pay/test1";
	}

	@PostMapping("/test1")
	public String test1(@ModelAttribute KakaoPayReadyRequestVO request,
			HttpSession session) throws URISyntaxException {
		request.setPartnerOrderId(UUID.randomUUID().toString());
		KakaoPayReadyResponseVO response = kakaoPayService.ready(request);
		
		//session에 flash value를 저장(잠시 쓰고 지우는 데이터)
		//- 사용자를 거치지 않는 범위 내에서 사용해야 안전하게 쓸 수 있다
		
//		session.setAttribute("partnerOrderId", request.getPartnerOrderId());
//		session.setAttribute("partnerUserId", request.getPartnerUserId());
//		session.setAttribute("tid", response.getTid());
		
		//세션은 아무거나 넣는거 가능
		session.setAttribute("approve", KakaoPayApproveRequestVO.builder()
				.partnerOrderId(request.getPartnerOrderId())
				.partnerUserId(request.getPartnerUserId())
				.tid(response.getTid())
				.build()); 
		
		return "redirect:" + response.getNextRedirectPcUrl();
	}
	
	@GetMapping("/test1/success")
	public String test1Success(HttpSession session, @RequestParam String pg_token) throws URISyntaxException {
		//session에 저장되어 있는 flash value를 꺼내에 pg_token을 추가할 뒤 승인 요청
		KakaoPayApproveRequestVO request = 
				(KakaoPayApproveRequestVO) session.getAttribute("approve"); //p.o.id, p.u.id, tid 가져옴
		session.removeAttribute("approve"); //사용 했으니 지워라 
		
		request.setPgToken(pg_token); //토큰 추가
		
		//결제 승인 요청
		KakaoPayApproveResponseVO response = kakaoPayService.approve(request);
		return "redirect:successResult";
	}
	
	@GetMapping("/test1/successResult")
	public String successResult() {
		return "pay/successResult";
	}
	
	@GetMapping("/test1/detail")
	public String detail(Model model, @RequestParam String tid) throws URISyntaxException {
		
		KakaoPayDetailResponseVO response = 
				kakaoPayService.detail(KakaoPayDetailRequestVO.builder()
						.tid(tid)
						.build());
		
		model.addAttribute("vo", response);
		
		return "pay/detail";
	}
	
	@RequestMapping("/test1/cancel")
	public String cancel(@ModelAttribute KakaoPayCancleRequestVO request) throws URISyntaxException {
		KakaoPayCancleResponseVO response = kakaoPayService.cancle(request);
		return "redirect:detail?tid="+request.getTid();
	}
	
	//-----------------------------------------------------
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/test2")
	public String test2(Model model) {
		model.addAttribute("list", productDao.selectList());
		return "pay2/home";
	}
	
	@GetMapping("/test2/purchase")
	public String purchase(HttpSession session, @RequestParam int productNo) throws URISyntaxException {
		//상품정보 조회
		ProductDto productDto = productDao.selectOne(productNo);
		
		//상품정보를 이용하여 결제준비 요청
		KakaoPayReadyRequestVO request = KakaoPayReadyRequestVO.builder()
				.itemName(productDto.getProductName()) //상품명
				.itemPrice(productDto.getProductPrice()) //상품가격
				.partnerOrderId(UUID.randomUUID().toString()) //주문번호
				.partnerUserId("testuser1") //주문자
			.build();
		
		KakaoPayReadyResponseVO response = 
				kakaoPayService.ready(request);
						
		//세션은 아무거나 넣는거 가능
		session.setAttribute("approve", KakaoPayApproveRequestVO.builder()
		.partnerOrderId(request.getPartnerOrderId())
		.partnerUserId(request.getPartnerUserId())
		.tid(response.getTid())
		.build()); 
		
		//결제페이지를 사용자에게 안내
		return "redirect:"+response.getNextRedirectPcUrl();
	}
	
	//결제 성공
	@GetMapping("/test2/purchase/success")
	public String test2Success(HttpSession session, @RequestParam String pg_token) throws URISyntaxException {
		//session에 저장되어 있는 flash value를 꺼내에 pg_token을 추가할 뒤 승인 요청
		KakaoPayApproveRequestVO request = 
				(KakaoPayApproveRequestVO) session.getAttribute("approve"); //p.o.id, p.u.id, tid 가져옴
		session.removeAttribute("approve"); //사용 했으니 지워라 
		
		request.setPgToken(pg_token); //토큰 추가
		
		//결제 승인 요청
		KakaoPayApproveResponseVO response = kakaoPayService.approve(request);
		return "redirect:successResult";
	}
	
	@RequestMapping("/test2/purchase/successResult")
	public String test2SuccessResult() {
		return "pay2/successResult";
	}
}
