package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
			String view = "/WEB-INF/view/login.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			request.setAttribute("inputCheckFlg", true);
			request.setAttribute("userCheckFlg", true);
			dispatcher.forward(request, response);
		} else{
			String view = "Main";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String form_userId = request.getParameter("userId");
		String form_password = request.getParameter("password");
		String get_userId = null;
        String get_password = null;
        boolean userCheckFlg = true;
        boolean inputCheckFlg = true;

		if(form_userId.equals("") || form_password.equals("")) {

			inputCheckFlg = false;

		}

		if(inputCheckFlg) {

			String select_userInfo = "SELECT user_id, password FROM user_system WHERE user_id=\"" + form_userId + "\" AND password=\"" + form_password +"\"";

			//db処理
			Connection con = null;
			Statement smt = null;

			String url = "jdbc:mysql://localhost:3306/redogs_db?serverTimezone=JST";
			String user = "kono";
			String pass = "wwma6324";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, user, pass);
				smt = con.createStatement();

				ResultSet result = smt.executeQuery(select_userInfo);

				while (result.next()) {
					get_userId = result.getString("user_id");
					get_password = result.getString("password");
				}

			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if(get_userId == null || get_password == null) {

				userCheckFlg = false;

			}
		}

		if(!userCheckFlg || !inputCheckFlg) {

			String view = "/WEB-INF/view/login.jsp";
			request.setAttribute("inputCheckFlg", inputCheckFlg);
			request.setAttribute("userCheckFlg", userCheckFlg);
			request.setAttribute("form_userId", form_userId);
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);

			dispatcher.forward(request, response);

		}else {

			String view = "Main";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			HttpSession session = request.getSession(true);
			session.setAttribute("sessionId", get_userId);

			dispatcher.forward(request, response);

		}
	}
}
