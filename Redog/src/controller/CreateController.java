package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CommonService;
import service.CreateService;

/**
 * Servlet implementation class CreateController
 */
@WebServlet("/Create")
public class CreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "/WEB-INF/view/create.jsp";
		request.setAttribute("dupFlg", false);
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		String mailAddress = request.getParameter("mailAddress");
		String hashPassword = null;
		CommonService commonService = new CommonService();
		CreateService createService = new CreateService();

		Boolean dupFlg = createService.checkUserId(userId);
		// ユーザIDの重複チェック
		if (dupFlg) {
			String view = "/WEB-INF/view/create.jsp";
			request.setAttribute("userId", userId);
			request.setAttribute("nickname", nickname);
			request.setAttribute("mailAddress", mailAddress);
			request.setAttribute("dupFlg", dupFlg);

			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}else {
			// パスワードをハッシュ化
			hashPassword = commonService.hashPassword(userId, password);

			// ユーザー作成
			createService.createUser(userId, hashPassword, nickname, mailAddress);

			HttpSession session = request.getSession(true);
			session.setAttribute("LoginId",userId);
			response.sendRedirect("Main");
		}



	}
}
