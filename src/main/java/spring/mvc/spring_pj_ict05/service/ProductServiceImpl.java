package spring.mvc.spring_pj_ict05.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import spring.mvc.spring_pj_ict05.dao.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDAO dao;
	
	//상품등록
	@Override
	public void productAddAction(MultipartHttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		
	}
	
	//상품목록
	@Override
	public void productListAction(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		
	}
	
	//상품상세페이지
	@Override
	public void productDetailAction(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		
	}
	
	//상품수정
	@Override
	public void productUpdateAction(MultipartHttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		
	}
	
	//상품삭제
	@Override
	public void productDeleteAction(MultipartHttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		
	}
}
