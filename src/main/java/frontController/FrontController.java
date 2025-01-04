package frontController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.board.View;
import controller.board.AddReply;
import controller.board.BbsController;
import controller.board.Delete;
import controller.board.List;
import controller.board.ReplyView;
import controller.board.Update;
import controller.board.Write;
import controller.member.MemberDelete;
import controller.member.MemberInsert;
import controller.member.MemberList;
import controller.member.MemberUpdate;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		System.out.println("uri : " + uri);
		String ctxPath = request.getContextPath();
		System.out.println("ctxPath : " + ctxPath);
		
		String[] paths = uri.split("/");
		System.out.println("paths last : " + paths[paths.length-1]);
		
		BbsController ctrl = null;
		switch(paths[paths.length-1]) {
		case "wform.do": 
			request.getRequestDispatcher("board/write.jsp").forward(request, response);
			break;
		case "write.do":
			ctrl = new Write();
			ctrl.execute(request, response);
			// 3. 응답할 뷰를 선택
			response.sendRedirect("list.do");
			break;
		case "list.do":
			ctrl = new List();
			ctrl.execute(request, response);
			request.getRequestDispatcher("board/list.jsp").forward(request, response);
			break;
		case "view.do":
			ctrl = new View();
			ctrl.execute(request, response);
			request.getRequestDispatcher("board/view.jsp").forward(request, response);
			break;
		case "replyView.do":
			ctrl = new ReplyView();
			ctrl.execute(request, response);
			request.getRequestDispatcher("board/reply_form.jsp").forward(request, response);
			break;
		case "update.do":
			ctrl = new Update();
			ctrl.execute(request, response);
			request.getRequestDispatcher("/board/list.do").forward(request, response);
			break;
		case "del.do":
			ctrl = new Delete();
			ctrl.execute(request, response);
			request.getRequestDispatcher("/board/list.do").forward(request, response);
			break;
		case "addReply.do":
			ctrl = new AddReply();
			ctrl.execute(request, response);
			response.sendRedirect("/board/list.do");
			break;
		case "memberList.do":
			ctrl = new MemberList();
			ctrl.execute(request, response);
			response.sendRedirect("/member/userList.jsp");
			break;
		case "memberDelete.do":
			ctrl = new MemberDelete();
			ctrl.execute(request, response);
			// 재요청
			response.sendRedirect("/member/memberList.do");
			break;
		case "memberUpdate.do":
			ctrl = new MemberUpdate();
			ctrl.execute(request, response);
			// 재요청
			response.sendRedirect("/member/userList.jsp");
			break;
		case "memberInsert.do":
			ctrl = new MemberInsert();
			ctrl.execute(request, response);
			// 재요청
			response.sendRedirect("/member/userList.jsp");
			break;
		}
	}

}
