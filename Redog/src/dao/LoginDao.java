package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDao {

	/** userIdとhashpasswordに一致するユーザーを取得するメソッド */
	public static String findUser(String userId, String hashPassword) {
		String resultId = null;
		String selectUserInfo = "SELECT user_id FROM user_system WHERE user_id=\"" + userId + "\" AND password=\"" + hashPassword +"\"";

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

			ResultSet result = smt.executeQuery(selectUserInfo);

			while (result.next()) {
				resultId = result.getString("user_id");
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

		return resultId;
	}
}
