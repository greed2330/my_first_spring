package spring.mvc.spring_pj_ict05.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.spring_pj_ict05.dto.ProductDTO;

@Repository
public class ProductDAOImpl implements ProductDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	//상품등록
	@Override
	public int productInsert(ProductDTO dto) {
		return 0;
	}
	
	//상품갯수
	@Override
	public int productCnt() {
		return 0;
	}
	
	//상품목록
	@Override
	public List<ProductDTO> productList(Map<String, Object> map) {
		return null;
	}
	
	//상품상세페이지
	@Override
	public ProductDTO productDetail(int pdNo) {
		return null;
	}
	
	//상품수정
	@Override
	public int productUpdate(ProductDTO dto) {
		return 0;
	}
	
	//상품삭제
	@Override
	public int productDelete(int pdNo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
