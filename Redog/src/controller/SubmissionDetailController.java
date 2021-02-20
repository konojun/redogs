package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.SubmissionDetail;
import service.SubmissionDetailService;

/**
 * Servlet implementation class SubmissionController
 */
@WebServlet("/SubmissionDetail")
public class SubmissionDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmissionDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Object loginSession = session.getAttribute("LoginId");
		SubmissionDetailService submissionDetailService = new SubmissionDetailService();

		// ログイン判定
		if (loginSession != null) {
			// 投稿情報取得
			List<SubmissionDetail> submissionData = new ArrayList<SubmissionDetail>();
			try {
				submissionData = submissionDetailService.submissionData((session.getAttribute("LoginId").toString()));
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}

			String view = "/WEB-INF/view/submissionDetail.jsp";
			request.setAttribute("submissionData", submissionData);
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

		response.sendRedirect("SubmissionDetail");
	}

}
