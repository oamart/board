package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;

/**
 * Servlet implementation class WriteController
 */
@WebServlet("/write.do")
public class WriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 1. 파라미터(글제목, 저자, 내용) 수집
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		System.out.println(writer + " " + title + " " + content);
		
		// 2. 수집된 내용을 처리하기 위한 모델(dao) 선택
		BoardDAO dao = new BoardDAO();
		dao.write(writer, title, content);
		
		// 3. 응답할 뷰를 선택
		response.sendRedirect("list.do");
	}

}
