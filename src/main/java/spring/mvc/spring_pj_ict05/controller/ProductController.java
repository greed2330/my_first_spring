package spring.mvc.spring_pj_ict05.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.spring_pj_ict05.service.ProductServiceImpl;

@Controller
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductServiceImpl service;
	
	//상품등록 화면
	@RequestMapping("/ad_product_add.pd")
	public String ad_product_add(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		logger.info("<<<ProductController => ad_product_add>>");
		
		return "ad_product_add";
	}
	
	
	//상품등록 처리
	
	//상품목록
	
	//상품 상세페이지
	
	//
	
}
