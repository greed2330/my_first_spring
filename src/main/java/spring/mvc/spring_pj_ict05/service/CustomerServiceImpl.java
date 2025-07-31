package spring.mvc.spring_pj_ict05.service;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring.mvc.spring_pj_ict05.dao.CustomerDAO;
import spring.mvc.spring_pj_ict05.dao.CustomerDAOImpl;
import spring.mvc.spring_pj_ict05.dto.CustomerDTO;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDAO dao;
	
	// ID 중복확인 처리
	@Override
	public void idConfirmAction(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println("CustomerServiceImpl - idConfirmAction()");
		
		//3단계. 화면에서 입력받은 값을 가져오기.
		String strId = request.getParameter("user_id");
		
		//4단계. 싱글톤 방식으로 DAO 객체 생성, 다형성 적용
		//CustomerDAO dao = CustomerDAOImpl.getInstance();
		
		//5단계. 아이디 중복확인 처리
		int selectCnt = dao.useridCheck(strId);
		
		//6단계. jsp로 처리결과 전달
		model.addAttribute("strId", strId);
		model.addAttribute("selectCnt", selectCnt);
	}

//	// 회원가입 처리
//	@Override
//	public void signInAction(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		System.out.println("CustomerServiceImpl - signInAction()");
//		//3단계. 화면에서 입력받은 값을 dto의 setter로 전달
//		
//		//DTO 생성 -> setter -> 멤버변수로 값 전달
//		CustomerDTO dto = new CustomerDTO();
//		
//		dto.setUser_id(request.getParameter("user_id"));
//		dto.setUser_password(request.getParameter("user_password"));
//		dto.setUser_name(request.getParameter("user_name"));
//		dto.setUser_birthday(Date.valueOf(request.getParameter("user_birthday")));
//		dto.setUser_address(request.getParameter("user_address"));
//		
//		//hp는 필수가 아니므로 null값이 들어올 수 있으므로, 값이 존재할때는 받아온다.(01012345678)
//		//전화번호
//		String hp = "";
//		String hp1 = request.getParameter("user_hp1");
//		String hp2 = request.getParameter("user_hp2");
//		String hp3 = request.getParameter("user_hp3");
//		
//		if(!hp1.equals("") && !hp2.equals("") && !hp3.equals("")) {
//			hp = hp1 + "-" + hp2 + "-" + hp3;
//		}
//		dto.setUser_hp(hp);
//		
//		//이메일
//		String email1 = request.getParameter("user_email1");
//		String email2 = request.getParameter("user_email2");
//		String email = email1 + "@" + email2;
//		dto.setUser_email(email);
//		
//		//등록일	.. 아래문장 생략 시 sysdate가 사용됨.
//		dto.setUser_regdate(new Timestamp(System.currentTimeMillis()));
//		
//		
//		//4단계. 싱글톤 방식으로 DAO 객체 생성, 다형성 적용
//		//CustomerDAO dao = CustomerDAOImpl.getInstance();
//		CustomerDAO dao = CustomerDAOImpl.getInstance();
//		
//		int insertCnt = dao.insertCustomer(dto);
//		
//		//6단계. jsp로 처리결과 넘겨주기
//		request.setAttribute("insertCnt", insertCnt);
//	}
//
//	// 로그인 처리 / 회원정보 인증(수정, 탈퇴)
//	@Override
//	public void loginAction(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		System.out.println("CustomerServiceImpl - loginAction()");
//		
//		
//		//3단계. 화면에서 입력받은 값을 가져온다.
//		String strId = request.getParameter("user_id");
//		String strPassword = request.getParameter("user_password");
//		
//		//4단계. 싱글톤 방식으로 DAO 객체 생성, 다형성 적용
//		CustomerDAO dao = CustomerDAOImpl.getInstance();
//		
//		//5단계 로그인 처리
//		int selectCnt = dao.idPasswordChk(strId, strPassword);
//		
//		//로그인 성공 시 세션ID를 설정(중요)
//		if(selectCnt == 1) {
////			HttpSession session = request.getSession();
////			session.setAttribute("sessionID", strId);
//			
//			request.getSession().setAttribute("sessionID", strId);
//			
//		}
//		
//		//6단계. jsp로 처리결과 전달
//	}
//	
//	// 회원 정보 인증처리 및 탈퇴처리
//	@Override
//	public void deleteCustomerAction(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		System.out.println("CustomerServiceImpl - deleteCustomerAction()");
//		
//		//3단계. 화면에서 입력받은 값을 가져온다 - 비밀번호 / 세션(ㅑㅇ)
//		String sessionID = (String)request.getSession().getAttribute("sessionID");
//		String strPassword = request.getParameter("user_password");
//		
//		//4단계. 싱글톤 방식으로 DAO 객체 생성.
//		CustomerDAO dao = CustomerDAOImpl.getInstance();
//		
//		//5-1단계. 회원정보 인증처리
//		int selectCnt = dao.idPasswordChk(sessionID, strPassword);
//		
//		int deleteCnt = 0;
//		//인증 성공 시
//		
//		if(selectCnt == 1) {
//			// 5-2단계. 탈퇴처리
//			deleteCnt = dao.deleteCustomer(sessionID);
//			if(deleteCnt == 1) {
//				// 세션 삭제 => 주의
//				request.getSession().invalidate();
//			}
//		}
//		
//		//6단계. jsp로 처리결과 전달
//		request.setAttribute("selectCnt", selectCnt);
//		request.setAttribute("deleteCnt", deleteCnt);
//	}
//
//	// 회원 정보 인증 처리 및 상세페이지 조회
//	@Override
//	public void modifyDetailAction(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		System.out.println("CustomerServiceImpl - modifyDetailAction()");
//		
//		//3단계. 화면에서 입력받은 값을 가져온다 - 비밀번호 / 세션(ㅑㅇ)
//		String sessionID = (String)request.getSession().getAttribute("sessionID");
//		String strPassword = request.getParameter("user_password");
//		
//		//4단계. 싱글톤 방식으로 DAO 객체 생성.
//		CustomerDAO dao = CustomerDAOImpl.getInstance();
//		
//		//5-1단계. 회원정보 인증처리
//		int selectCnt = dao.idPasswordChk(sessionID, strPassword);
//		CustomerDTO dto = null;
//		//인증 성공 시
//		if(selectCnt == 1) {
//			// 5-2단계. 상세페이지 조회
//			dto = dao.getCustomerDetail(sessionID);
//		}
//		
//		//6단계. jsp로 처리결과 전달
//		request.setAttribute("selectCnt", selectCnt);
//		request.setAttribute("dto", dto);
//	}
//	
//	
//	// 회원정보 수정 처리
//	@Override
//	public void modifyCustomerAction(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		System.out.println("CustomerServiceImpl - modifyCustomerAction()");
//		CustomerDAO dao = CustomerDAOImpl.getInstance();
//		CustomerDTO dto = new CustomerDTO();
//		
//		String hp1 = request.getParameter("user_hp1");	//input 박스에서 입력받지 않고 세션ID사용
//		String hp2 = request.getParameter("user_hp2");
//		String hp3 = request.getParameter("user_hp3");
//		String hp ="";
//		if(!hp1.equals("") && !hp2.equals("") && !hp3.equals("")) {
//			hp = hp1 + "-" + hp2 + "-" + hp3;
//		}
//		
//		String email1 = request.getParameter("user_email1");
//		String email2 = request.getParameter("user_email2");
//		String email = email1 + "@" + email2;
//		
//		dto.setUser_id((String)request.getSession().getAttribute("sessionID"));
//		dto.setUser_password(request.getParameter("user_password"));
//		dto.setUser_name(request.getParameter("user_name"));
//		dto.setUser_birthday(Date.valueOf(request.getParameter("user_birthday")));
//		dto.setUser_address(request.getParameter("user_address"));
//		dto.setUser_hp(hp);
//		dto.setUser_email(email);
//		dto.setUser_regdate(new Timestamp(System.currentTimeMillis()));
//		
//		int updateCnt = dao.updateCustomer(dto);
//		request.setAttribute("updateCnt", updateCnt);
//	}
}
