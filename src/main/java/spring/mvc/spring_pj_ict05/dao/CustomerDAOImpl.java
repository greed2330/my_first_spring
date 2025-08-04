package spring.mvc.spring_pj_ict05.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.spring_pj_ict05.dto.CustomerDTO;

@Repository
public class CustomerDAOImpl implements CustomerDAO{
	
	//2. SqlSession은 인터페이스 다형성으로 SqlSessionTemplate을 받아온다
	//private SqlSession sqlSession
	@Autowired
	private SqlSession sqlSession;
	
	// ID 중복확인 처리
	@Override
	public int useridCheck(String strId) {
		System.out.println("CustomerDAOImpl - useridCheck()");
		int selectCnt = sqlSession.selectOne("spring.mvc.spring_pj_ict05.dao.CustomerDAO.useridCheck", strId);
		
		return selectCnt;
	}

	// 회원가입 처리
	@Override
	public int insertCustomer(CustomerDTO dto) {
		System.out.println("CustomerDAOImpl - insertCustomer()");
		
		int insertCnt = sqlSession.insert("spring.mvc.spring_pj_ict05.dao.CustomerDAO.insertCustomer", dto);
		
		return insertCnt;
	}

	// 로그인 처리 / 회원정보 인증(수정, 탈퇴)
	@Override
	public int idPasswordChk(Map<String, Object> map) {
		System.out.println("CustomerDAOImpl - idPasswordChk()");
		int selectCnt = sqlSession.selectOne("spring.mvc.spring_pj_ict05.dao.CustomerDAO.idPasswordChk", map);
		System.out.println(selectCnt);
		return selectCnt;
	}

	// 회원 정보 인증처리 및 탈퇴처리
	@Override
	public int deleteCustomer(String strId) {
		System.out.println("CustomerDAOImpl - deleteCustomer()");
		int deleteCnt = sqlSession.delete("spring.mvc.spring_pj_ict05.dao.CustomerDAO.deleteCustomer", strId);
		return deleteCnt;
	}

	// 회원 정보 인증 처리 및 상세페이지 조회
	@Override
	public CustomerDTO getCustomerDetail(String strId) {
		System.out.println("CustomerDAOImpl - getCustomerDetail()");
		
		CustomerDTO dto = sqlSession.selectOne("spring.mvc.spring_pj_ict05.dao.CustomerDAO.getCustomerDetail", strId); 
		return dto;
	}
	
	// 회원정보 수정 처리
	@Override
	public int updateCustomer(CustomerDTO dto) {
		System.out.println("CustomerDAOImpl - updateCustomer()");
		
		int updateCnt = sqlSession.update("spring.mvc.spring_pj_ict05.dao.CustomerDAO.updateCustomer", dto);
		return updateCnt;
	}
}
