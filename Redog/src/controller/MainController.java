package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/Main")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Object sessionId = session.getAttribute("sessionId");
		if (sessionId == null){
			String view = "Login";
			 RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			 dispatcher.forward(request, response);
		}else {
			String view = "/WEB-INF/view/main.jsp";
			 RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			 dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Object sessionId = session.getAttribute("sessionId");
		String view = null;

		if(sessionId == null) {
			view = "/WEB-INF/view/login.jsp";
			request.setAttribute("inputCheckFlg", true);
			request.setAttribute("userCheckFlg", true);
		}else {
			view = "/WEB-INF/view/main.jsp";
			request.setAttribute("sessionId", sessionId);
		}


		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);

	}

}
