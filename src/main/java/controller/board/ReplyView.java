package controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardDTO;

public class ReplyView implements BbsController {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bid = request.getParameter("bid");
		BoardDTO dto = new BoardDAO().replyView(bid);
		request.setAttribute("dto", dto);
		return "/WEB-INF/board/reply_form.jsp";
	}

}
