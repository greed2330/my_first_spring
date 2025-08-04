package spring.mvc.spring_pj_ict05.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.spring_pj_ict05.dto.BoardCommentDTO;
import spring.mvc.spring_pj_ict05.dto.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	@Autowired
	private SqlSession sqlSession;
	
	//게시글 목록
	@Override
    public List<BoardDTO> boardList(Map<String, Object> map) {
        System.out.println("BoardDAOImpl - boardList()");
        
        List<BoardDTO> list = sqlSession.selectList("spring.mvc.spring_pj_ict05.dao.BoardDAO.boardList", map);
        System.out.println("list : " + list);
        return list;
    }

	//게시글 갯수 구하기
	@Override
	public int boardCnt() {
		System.out.println("BoardDAOImpl - boardCnt()");
		int total = sqlSession.selectOne("spring.mvc.spring_pj_ict05.dao.BoardDAO.boardCnt");
		System.out.println(total);
		return total;
	}

	//조회수 증가
	@Override
	public void plusReadCnt(int board_num) {
		System.out.println("BoardDAOImpl - plusReadCnt()"); 
		
		sqlSession.update("spring.mvc.spring_pj_ict05.dao.BoardDAO.plusReadCnt", board_num);
	}

	//게시글 상세 처리
	@Override
	public BoardDTO getBoardDetail(int board_num) {
		System.out.println("BoardDAOImpl - getBoardDetail()");
		BoardDTO dto = sqlSession.selectOne("spring.mvc.spring_pj_ict05.dao.BoardDAO.getBoardDetail", board_num);
		System.out.println(dto);
		return dto;
	}

	
	//게시글 수정삭제 버튼 클릭 시 - 비밀번호 인증처리
	@Override
	public int password_chk(Map<String, Object> map) {
		System.out.println("BoardDAOImpl - password_chk()");
		int selectCnt = sqlSession.selectOne("spring.mvc.spring_pj_ict05.dao.BoardDAO.password_chk", map);
		//1.
		System.out.println("selectCnt : "+selectCnt);
		return selectCnt;
	}

	//게시글 수정 처리
	@Override
	public void updateBoard(BoardDTO dto) {
		System.out.println("BoardDAOImpl - updateBoard()");
		sqlSession.update("spring.mvc.spring_pj_ict05.dao.BoardDAO.updateBoard", dto);
	}

	//게시글 삭제 처리
	@Override
	public void deleteBoard(int board_num) {
		System.out.println("BoardDAOImpl - deleteBoard()");
		sqlSession.update("spring.mvc.spring_pj_ict05.dao.BoardDAO.deleteBoard", board_num);
	}

	//게시글 작성 처리
	@Override
	public void insertBoard(BoardDTO dto) {
		System.out.println("BoardDAOImpl - insertBoard()");
		sqlSession.insert("spring.mvc.spring_pj_ict05.dao.BoardDAO.insertBoard", dto);
	}
	
	
	//댓글 작성 처리
	@Override
	public void insertComment(BoardCommentDTO dto) {
		System.out.println("BoardDAOImpl - insertComment()");

	    // 1. 댓글 테이블에 데이터 삽입
	    sqlSession.insert("spring.mvc.spring_pj_ict05.dao.BoardDAO.insertComment", dto);
	    System.out.println(dto);
	    
	    // 2. 게시글의 댓글 수 업데이트
	    //sqlSession.update("spring.mvc.spring_pj_ict05.dao.BoardDAO.updateCommentCount");
	}
	
	//댓글 목록
	@Override
	public List<BoardCommentDTO> commentList(int board_num) {
		System.out.println("BoardDAOImpl - boardList()");
		
		//1. list 생성
		List<BoardCommentDTO> list = sqlSession.selectList("spring.mvc.spring_pj_ict05.dao.BoardDAO.commentList", board_num);
		return list;
	}
}
