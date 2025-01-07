package frontController;

import java.io.IOException;
import java.lang.ModuleLayer.Controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.User;

import controller.board.BbsController;


/**
 * Servlet implementation class FrontController
 */
@WebServlet(urlPatterns = {"/", "*.do"})
//@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ActionMapping actionMapping;
    
    @Override
    public void init() throws ServletException {
    	actionMapping = new ActionMapping();
    }
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
		
		BbsController ctrl = actionMapping.get(paths[paths.length-1]);
		String targetUri = null;
		if (paths[paths.length-1].indexOf(".do") == -1) return;
		if (ctrl != null) {
			targetUri = ctrl.execute(request, response);
		}
		switch(paths[paths.length-1]) {
		case "wform.do": 
			request.getRequestDispatcher("/WEB-INF/board/write.jsp").forward(request, response);
			break;
		case "user.do":
			request.getRequestDispatcher("/WEB-INF/member/user.jsp").forward(request, response);
			break;
		default:
			request.getRequestDispatcher(targetUri).forward(request, response);
			break;
//		case "write.do":
//			// 3. 응답할 뷰를 선택
//			response.sendRedirect("list.do");
//			break;
//		case "list.do":
//			request.getRequestDispatcher("board/list.jsp").forward(request, response);
//			break;
//		case "view.do":
//			request.getRequestDispatcher("board/view.jsp").forward(request, response);
//			break;
//		case "replyView.do":
//			request.getRequestDispatcher("board/reply_form.jsp").forward(request, response);
//			break;
//		case "update.do":
//			request.getRequestDispatcher("/board/list.do").forward(request, response);
//			break;
//		case "del.do":
//			request.getRequestDispatcher("/board/list.do").forward(request, response);
//			break;
//		case "addReply.do":
//			response.sendRedirect("/board/list.do");
//			break;
//		case "memberList.do":
//			ctrl = new MemberList();
//			ctrl.execute(request, response);
//			request.getRequestDispatcher("/member/userList.jsp").forward(request, response);
//			break;
//		case "memberDelete.do":
//			ctrl = new MemberDelete();
//			ctrl.execute(request, response);
//			// 재요청
//			response.sendRedirect("/board/memberList.do");
//			break;
//		case "memberUpdate.do":
//			ctrl = new MemberUpdate();
//			ctrl.execute(request, response);
//			// 재요청
//			response.sendRedirect("/board/memberList.do");
//			break;
//		case "memberInsert.do":
//			ctrl = new MemberInsert();
//			ctrl.execute(request, response);
//			// 재요청
//			response.sendRedirect("/board/memberList.do");
//			break;
//		case "userInfo.do":
//			ctrl = new UserInfo();
//			ctrl.execute(request, response);
//			request.getRequestDispatcher("/member/userInfo.jsp").forward(request, response);
//			break;
		}
	}

}
