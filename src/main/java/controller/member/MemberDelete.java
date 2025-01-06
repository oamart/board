package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.board.BbsController;
import model.UserDAO;

public class MemberDelete implements BbsController {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 삭제할 회원의 uno
		int uno = Integer.parseInt(request.getParameter("uno"));
		
		UserDAO dao = new UserDAO();
		int n = dao.deleteUser(uno);
		
		if(n > 0) {
			System.out.println("삭제완료!!");
		}else {
			System.out.println("삭제실패!!");
		}
		return "/memberList.do";
	}

}
