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
	
	//회원가입 버튼 클릭시
	@RequestMapping("/joinAction.do")
	public String joinAction(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException{
		logger.info("<<< url ==> /idConfirmAction.do >>>");
		
		service.signInAction(request, response, model);
		return "customer/join/joinAction";
	}
	
	//로그인 페이지로 이동
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException{
		logger.info("<<< url ==> /login.do >>>");
		
		return "customer/login/login";
	}
	
	//로그인 버튼을 누르면
	@RequestMapping("/loginAction.do")
	public String loginAction(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException{
		logger.info("<<< url ==> /loginAction.do >>>");
		if((String)request.getSession().getAttribute("sessionID") == null){
			service.loginAction(request, response, model);
		}
		return "customer/login/loginAction";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException{
		logger.info("<<< url ==> /logout.do >>>");
		
		//세션삭제
		request.getSession().invalidate();
		return "common/main";
	}
	
	// 회원탈퇴 -------------------------
	//회원탈퇴 - 인증화면
	@RequestMapping("/deleteCustomer.do")
	public String deleteCustomer(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException{
		logger.info("<<< url ==> /deleteCustomer.do >>>");
		
		return "customer/mypage/customerinfo/deleteCustomer";
	}
	
	
	// 회원탈퇴 처리
	@RequestMapping("/deleteCustomerAction.do")
	public String deleteCustomerAction(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException{
		logger.info("<<< url ==> /deleteCustomerAction.do >>>");
		
		service.deleteCustomerAction(request, response, model);
		
		return "customer/mypage/customerinfo/deleteCustomerAction";
	}
	
	//[회원수정]------------------------------
	// 회원수정- 인증화면
	@RequestMapping("/modifyCustomer.do")
	public String modifyCustomer(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException{
		logger.info("<<< url ==> /modifyCustomer.do >>>");
		
		return "customer/mypage/customerinfo/modifyCustomer";
	}
	//회원정보 - 상세페이지
	@RequestMapping("/modifyDetailAction.do")
	public String modifyDetailAction(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException{
		logger.info("<<< url ==> /modifyDetailAction.do >>>");
		
		service.modifyDetailAction(request, response, model);
		
		return "customer/mypage/customerinfo/modifyDetailAction";
	}
	
	//modifyCustomerAction
	//회원수정 처리
	@RequestMapping("/modifyCustomerAction.do")
	public String modifyCustomerAction(HttpServletRequest request, HttpServletResponse response, Model model) 
			throws ServletException, IOException{
		logger.info("<<< url ==> /modifyCustomerAction.do");
		
		service.modifyCustomerAction(request, response, model);
		
		return "/customer/mypage/customerinfo/modifyCustomerAction";
	}
}
