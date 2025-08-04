package spring.mvc.spring_pj_ict05.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.spring_pj_ict05.dto.ProductDTO;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SqlSession sqlSession;

	// 상품등록
	@Override
	public int productInsert(ProductDTO dto) {
		System.out.println("ProductDAOImpl - productInsert");
		//방법1.
		//int insertCnt = sqlSession.insert("spring.mvc.spring_pj_ict05.dao.ProductDAO.productInsert", dto);
		//return insertCnt;
		
		//방법2.
		ProductDAO dao = sqlSession.getMapper(ProductDAO.class);
		int insertCnt = dao.productInsert(dto);
		return insertCnt;
		
	}

	// 상품갯수
	@Override
	public int productCnt() {
		System.out.println("ProductDAOImpl - productCnt");
		
		int total = sqlSession.selectOne("spring.mvc.spring_pj_ict05.dao.ProductDAO.productCnt");
		
		return total;
	}

	// 상품목록
	@Override
	public List<ProductDTO> productList(Map<String, Object> map) {
		System.out.println("ProductDAOImpl - productList");
		
		List<ProductDTO> list = sqlSession.selectList("spring.mvc.spring_pj_ict05.dao.ProductDAO.productList", map);
		
		return list;
	}

	// 상품상세페이지
	@Override
	public ProductDTO productDetail(int pdNo) {
		return null;
	}

	// 상품수정
	@Override
	public int productUpdate(ProductDTO dto) {
		return 0;
	}

	// 상품삭제
	@Override
	public int productDelete(int pdNo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
