package spring.mvc.spring_pj_ict05.dao;

import java.util.List;
import java.util.Map;

import spring.mvc.spring_pj_ict05.dto.BoardCommentDTO;
import spring.mvc.spring_pj_ict05.dto.BoardDTO;


public interface BoardDAO {
	//게시글 목록
	public List<BoardDTO> boardList(Map<String, Object> map);
	
	//게시글 갯수 구하기
	public int boardCnt();
	
	//조회수 증가
	public void plusReadCnt(int board_num);
	
	//게시글 상세 처리
	public BoardDTO getBoardDetail(int board_num);
	
	//게시글 수정삭제 버튼 클릭 시 - 비밀번호 인증처리
	public int password_chk(Map<String, Object> map);
	
	//게시글 수정 처리
	public void updateBoard(BoardDTO dto);
	
	//게시글 삭제 처리
	public void deleteBoard(int board_num);
	
	//게시글 작성 처리
	public void insertBoard(BoardDTO dto);
	
	//댓글 작성 처리
	public void insertComment(BoardCommentDTO dto);
	
	//댓글 갯수 업데이트
	public void updateCommentCount();
	
	//댓글 목록
	public List<BoardCommentDTO> commentList(int board_num);

}
