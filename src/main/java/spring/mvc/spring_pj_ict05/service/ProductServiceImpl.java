package spring.mvc.spring_pj_ict05.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import spring.mvc.spring_pj_ict05.dao.ProductDAO;
import spring.mvc.spring_pj_ict05.dto.ProductDTO;
import spring.mvc.spring_pj_ict05.page.Paging;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDAO dao;

	// 상품등록 - MultipartHttpServletRequest request
	@Override
	public void productAddAction(MultipartHttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println("ProductServiceImpl - productAddAction");

		MultipartFile file = request.getFile("pdImg");
		System.out.println("file : " + file);

		// input 경로 - 폴더먼저 생성후
		String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload/");
		System.out.println("saveDir : " + saveDir);

		// upload 폴더 우크릭 > properties > location 정보 복사해서 붙여넣기, 맨뒤 "\\" 추가
		String realDir = "D:\\DEV05\\workspace_spring_ict05\\spring_pj_ict05\\src\\main\\webapp\\resources\\upload\\";
		System.out.println("realDir : " + realDir);

		FileInputStream fis = null;
		FileOutputStream fos = null;
		// 4단계. 싱글톤 방식으로 DAO 객체 생성, 다형성 적용 => @Autowired로 대체
		try {
			file.transferTo(new File(saveDir + file.getOriginalFilename())); // import java.io.File
			fis = new FileInputStream(saveDir + file.getOriginalFilename());
			fos = new FileOutputStream(realDir + file.getOriginalFilename());

			int data = 0;
			while ((data = fis.read()) != -1) {
				fos.write(data);
			}

			// 3단계. 화면에서 입력받은 값 가져와서 dto에 setter로 담는다.
			ProductDTO dto = new ProductDTO();
			dto.setPdName((String) request.getParameter("pdName"));
			dto.setPdBrand((String) request.getParameter("pdBrand"));
			String p_img1 = "/spring_pj_ict05/resources/upload/" + file.getOriginalFilename();
			
			System.out.println("p_img1 : " + p_img1);

			dto.setPdImg(p_img1);
			dto.setPdCategory((String) request.getParameter("pdCategory"));
			dto.setPdContent((String) request.getParameter("pdContent"));
			dto.setPdPrice(Integer.parseInt(request.getParameter("pdPrice")));
			dto.setPdQuantity(Integer.parseInt(request.getParameter("pdQuantity")));
			dto.setPdStatus((String) request.getParameter("pdStatus"));
			System.out.println(dto);
			// 5단계. 상품등록
			int insertCnt = dao.productInsert(dto);
			// 6단계. jsp로 처리결과 전달
			model.addAttribute("insertCnt", insertCnt);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null)
				fis.close();
			if (fos != null)
				fos.close();
		}
	}

	// 상품목록
	@Override
	public void productListAction(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		// 3단계. 화면에서 입력받은 값 가져와서 dto에 setter로 담는다.
		String pageNum = request.getParameter("pageNum");
		// 4단계. 싱글톤 방식으로 DAO 객체 생성, 다형성 적용 => @Autowired로 대체

		// 5-1단계. 상품갯수
		int total = dao.productCnt();
		System.out.println("total : "+total);
		
		// 5-2단계. 상품목록
		Paging paging = new Paging(pageNum);
		paging.setTotalCount(total);
		
		int start = paging.getStartRow();
		int end = paging.getEndRow();
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("start", start);
		map.put("end", end);
		List<ProductDTO> list = dao.productList(map);
		
		// 6단계. jsp로 처리결과 전달
		model.addAttribute("paging", paging);
		model.addAttribute("list", list);
	}

	// 상품상세페이지
	@Override
	public void productDetailAction(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {

	}

	// 상품수정
	@Override
	public void productUpdateAction(MultipartHttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {

	}

	// 상품삭제
	@Override
	public void productDeleteAction(MultipartHttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {

	}
}
