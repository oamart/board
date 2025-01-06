package controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;

public class Write implements BbsController {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1. 파라미터(글제목, 저자, 내용) 수집
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		System.out.println(writer + " " + title + " " + content);
		
		// 2. 수집된 내용을 처리하기 위한 모델(dao) 선택
		BoardDAO dao = new BoardDAO();
		dao.write(writer, title, content);
		/*
		for (int i = 0; i <= 120; i++) {
			dao.write(writer + i, title + ".........#" + i, content);
		}
		*/
		return "list.do";
	}

}
