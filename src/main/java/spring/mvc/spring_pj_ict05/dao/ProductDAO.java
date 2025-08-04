package spring.mvc.spring_pj_ict05.dao;

import java.util.List;
import java.util.Map;

import spring.mvc.spring_pj_ict05.dto.ProductDTO;

public interface ProductDAO {
	//상품등록
	public int productInsert(ProductDTO dto);
	
	//상품갯수
	public int productCnt();
	
	//상품목록
	public List<ProductDTO> productList(Map<String, Object> map);
	
	//상품상세페이지
	public ProductDTO productDetail(int pdNo);
	
	//상품수정
	public int productUpdate(ProductDTO dto);
	
	//상품삭제
	public int productDelete(int pdNo);
}
