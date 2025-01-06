package controller.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.board.BbsController;
import model.BoardDAO;
import model.BoardDTO;
import model.UserDAO;
import model.UserDTO;

public class MemberList implements BbsController{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO dao = new UserDAO();
		ArrayList<UserDTO> list = dao.userList();
		
		System.out.println("MemberList : " + list);
		
		request.setAttribute("list", list);
		return "/WEB-INF/member/userList.jsp";
	}

	

}
