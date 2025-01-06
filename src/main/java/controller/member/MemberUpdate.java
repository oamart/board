package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.board.BbsController;
import model.UserDAO;
import model.UserDTO;

public class MemberUpdate implements BbsController {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 수정할 회원번호 수집
		int uno = Integer.parseInt(request.getParameter("uno"));
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		
		// dto로 묶기
		UserDTO dto = new UserDTO();
		dto.setUno(uno);
		dto.setAge(age);
		dto.setEmail(email);
		dto.setTel(tel);
				
		UserDAO dao = new UserDAO();
		int n = dao.userUpdate(dto);
		
		if(n>0) {
			System.out.println("수정 완료!!");
		}else {
			System.out.println("수정 실패!!");
		}
		return "/memberList.do";
	}

}
