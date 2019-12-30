package mController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.memberDAO;
import vo.memberVO;


@WebServlet("/mlist")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// DAO의 memberList 호출
		memberDAO mdao = new memberDAO();
		ArrayList<memberVO> list = mdao.memberList();
		request.setAttribute("banana",list);
		// 출력문 작성 -> 웹브라우저 : jsp가 처리
		request.getRequestDispatcher("/member/memberList.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}






