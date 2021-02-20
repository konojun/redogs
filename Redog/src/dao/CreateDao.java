package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateDao {

	/** 新規ユーザーを作成するメソッド */
	public static void createUser(String userId, String hashPassword, String nickname, String mailAddress) {
		// 作成日時取得
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String createDate = format.format(date);

		// 新規作成SQL文
		String createAccount = "INSERT INTO user_system VALUES (null,\"" + userId + "\",\"" + hashPassword + "\",\""
				+ nickname + "\",\"" + mailAddress + "\",\"" + createDate + "\",\"" + createDate + "\")";

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
			smt.executeUpdate(createAccount);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/** ユーザIDからユーザ情報を取得するメソッド */
	public static boolean checkUser(String userId) {
		Boolean idCheck = false;
		String existUser = null;
		// 新規作成SQL文
		String userInfoByUserId = "SELECT user_id from user_system WHERE user_id =\"" + userId +"\"";

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

			ResultSet result = smt.executeQuery(userInfoByUserId);

			while (result.next()) {
				existUser = result.getString("user_id");
			}
			if(existUser == null) {
				idCheck = false;
			}else {
				idCheck = true;
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
		return idCheck;
	}
}
