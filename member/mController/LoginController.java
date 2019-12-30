package mController;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.memberDAO;
import vo.memberVO;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Form에서 전송된 값을 처리 
		// -> request.get..... => vo에 담기
		memberVO vo = new memberVO();
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		vo.setId(id);
		vo.setPassword(password);
		
		// DAO의 memberLogin 호출
		memberDAO mdao = new memberDAO();
		//vo = mdao.loginCheck(vo);
		vo = mdao.loginCheck(vo);
		if(vo!=null) {
			// 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("loginID", vo.getId());
			request.getRequestDispatcher("/login/loginSuccess.jsp").forward(request, response);
		} else {
			// 로그인 실패
			request.getRequestDispatcher("/login/loginFail.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
