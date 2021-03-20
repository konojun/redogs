package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import service.SubmissionService;

/**
 * Servlet implementation class SubmissionController
 */
@WebServlet("/Submission")
@MultipartConfig(location="/org", maxFileSize=1048576)
public class SubmissionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmissionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Object loginSession = session.getAttribute("LoginId");

		// ログイン判定
		if (loginSession != null) {
			String view = "/WEB-INF/view/submission.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		} else{
			String view = "/WEB-INF/view/login.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			request.setAttribute("userCheckFlg", true);
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String sessionId = session.getAttribute("LoginId").toString();

		if(sessionId == null) {
			response.sendRedirect("Login");
		}
		String title = request.getParameter("title");
		String article = request.getParameter("article");
		Part part = request.getPart("file");
		SubmissionService submissionService = new SubmissionService();


		// 投稿
		submissionService.fileUpload(sessionId, title, article, part);

		response.sendRedirect("SubmissionDetail");
	}

}
