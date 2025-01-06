package controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardDTO;

public class List implements BbsController {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		
		//-------- paging 처리 설정 ----------
		
		// 전체 게시글 수 구하기
		int totalCnt = dao.getListCount();
		System.out.println("totalCnt=" + totalCnt);
		
		int curBlock = 0;
		int currentPage = 1;
		int blockSize = 5;
		int limit = 10;
		
		// 전체 페이지수
		int totalPage = (int)Math.ceil((double)totalCnt/limit);
		
		// view에서 넘어오는 currentPage에 따라
		// currentPage, curBlock을 새롭게 셋팅
		if(request.getParameter("currentPage") !=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			curBlock = (currentPage - 1)/blockSize;
		}
		
//		ArrayList<BoardDTO> list = dao.list();
		ArrayList<BoardDTO> list = dao.list(currentPage, limit);
		
		
		// 블럭시작번호 : 1, 6, 11, 16,....
		int blockStart = curBlock*blockSize + 1;
		// 블럭끝번호 : 5, 10, 15, 20,....
		int blockEnd = blockStart + (blockSize - 1);
		// blockEnd는 전체페이지수보다 클수 없음
		if(blockEnd > totalPage) blockEnd = totalPage;
		
		// 이전
		int prevPage = blockStart - 1;
		
		// 다음
		int nextPage = blockEnd + 1;
		
		System.out.println(list);
		// list() 리턴값 list를 뷰에 전달(객체 바인딩)
		request.setAttribute("list", list);
		request.setAttribute("blockStart", blockStart);
		request.setAttribute("blockEnd", blockEnd);
		request.setAttribute("prevPage", prevPage);
		request.setAttribute("nextPage", nextPage);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalPage", totalPage);
		
		return "/WEB-INF/board/list.jsp";
	}

}
