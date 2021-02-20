package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SubmissionDao {

	/** 投稿内容を保存するメソッド */
	public static void saveSubmission(String userId, String title, String article) {
		// 作成日時取得
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String createDate = format.format(date);

		// 新規作成SQL文
		String createAccount = "INSERT INTO submission_form VALUES (null,\"" + userId + "\",\"" + title + "\",\""
				+ article + "\",\""
				+ createDate + "\",\"" + createDate + "\")";

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

	/** 最新の投稿IDを取得するメソッド */
	public static Integer getSubmissionId(String userId) {
		Integer submissionId = null;
		String selectUserInfo = "SELECT MAX(id) FROM submission_form WHERE user_id=\"" + userId + "\"";

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
				submissionId = result.getInt("MAX(id)");
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return submissionId;
	}
}
