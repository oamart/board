package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.board.BbsController;
import model.UserDAO;
import model.UserDTO;

public class UserInfo implements BbsController {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 수정할 회원번호 수집
		int uno = Integer.parseInt(request.getParameter("uno"));
		
		UserDAO dao = new UserDAO();
		UserDTO dto = dao.userInfo(uno);
		
		System.out.println(dto);
		request.setAttribute("dto", dto);
		return "/WEB-INF/member/userInfo.jsp";
	}

}
