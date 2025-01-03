package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardDTO;

public class List implements BbsController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		// ----------------- 페이징 처리 ------------------------
		// 전체 게시글 수 구하기
		int totalCnt = dao.getListCount();
		System.out.println("totalCnt : " + totalCnt);
		int curBlock = 0;
		int currentPage = 1;
		int blockSize = 5;
		int limitPerPage = 10;
		
		// 전체 페이지 수
		int totalPage = (int)Math.ceil((double)totalCnt/limitPerPage);
		if(request.getParameter("currentPage") !=null) {
            currentPage = Integer.parseInt(request.getParameter("currentPage"));
            curBlock = (currentPage - 1)/blockSize;
        }
//		ArrayList<BoardDTO> lst = dao.list();
		ArrayList<BoardDTO> lst = dao.list(currentPage, limitPerPage);
		
		// block start number
		int blockStart = curBlock * blockSize + 1;
		// block end number
		int blockEnd = blockStart + (blockSize - 1);
		// blockEnd는 전체페이지수 보다 클 수 없다.
		if (blockEnd > totalPage) blockEnd = totalPage;
		// 이전
		int prevPage = blockStart - 1;
		// 다음
		int nextPage = blockEnd + 1;
		
		request.setAttribute("list", lst);
		request.setAttribute("blockStart", blockStart);
		request.setAttribute("blockEnd", blockEnd);
		request.setAttribute("prevPage", prevPage);
		request.setAttribute("nextPage", nextPage);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalPage", totalPage);
	}

}
