package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.board.BbsController;
import model.UserDAO;
import model.UserDTO;

public class MemberInsert implements BbsController {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청 파라미터 수집
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		System.out.println("MemberInsert name : " + name);
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		
		UserDTO user= new UserDTO(id, pw, name, age, email, tel);
		System.out.println(user);
		
		//2. DAO를 이용해서 비즈니스 로직 수행
		UserDAO dao = new UserDAO();
		int n = dao.userInsert(user);
		
		if(n > 0) {
			System.out.println("가입 성공!!");
		}else {
			System.out.println("가입 실패!!");
		}
		return "/memberList.do";
	}

}
