package spring.mvc.spring_pj_ict05.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.spring_pj_ict05.service.CustomerServiceImpl;

@Controller
public class CustomerController {
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerServiceImpl service;
	
	//첫페이지
	@RequestMapping("/main.do")
	public String main() {
		logger.info("<<< url ==> /main.do >>>");
		
		return "common/main";
	}
	
	//[회원가입]
	//회원가입 페이지로 이동
	@RequestMapping("/join.do")
	public String join() {
		logger.info("<<< url ==> /join.do >>>");
		
		return "customer/join/join";
	}
	
	//id 중복확인 버튼 클릭 시
	@RequestMapping("/idConfirmAction.do")
	public String idConfirmAction(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException {
		logger.info("<<< url ==> /idConfirmAction.do >>>");
		
		service.idConfirmAction(request, response, model);
		return "customer/join/idConfirmAction";
	}
	
	//회원가입 버튼 클릭 시
}
