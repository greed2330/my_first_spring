package spring.mvc.spring_pj_ict05.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.spring_pj_ict05.HomeController;

@Controller
public class CustomerController {
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	//첫페이지
	@RequestMapping("/main.do")
	public String main() {
		logger.info("<<< url ==> /main.do >>>");
		
		return "common/main";
	}
	
}
