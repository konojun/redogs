package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Part;

public class SubmissionFileDao {

	/** 画像情報を保存メソッド */
	public static void fileUpdate(String userId, Integer submissionId, String fileName, Part file) {
			InputStream transFile = null;
			// 作成日時取得
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String createDate = format.format(date);

			// 画像をInputStreamに変換
			try {
				transFile = file.getInputStream();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			// 新規作成SQL文
			String createFile = "INSERT INTO submission_file VALUES (null,\"" + userId + "\",\"" + submissionId + "\",\"" + fileName + "\",\"" + transFile + "\",\"" + createDate + "\",\""
					+ createDate + "\")";

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
				smt.executeUpdate(createFile);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
	}

	/** 最新の画像IDを取得するメソッド */
	public static Integer getFileId(String userId) {
		Integer fileId = null;
		String selectFileInfo = "SELECT MAX(id) FROM submission_file WHERE user_id=\"" + userId + "\"";

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

			ResultSet result = smt.executeQuery(selectFileInfo);

			while (result.next()) {
				fileId = result.getInt("MAX(id)");
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

		return fileId;
	}
}
