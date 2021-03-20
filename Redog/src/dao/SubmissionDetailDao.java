package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.SubmissionDetail;

public class SubmissionDetailDao {

	/** userIdから投稿情報を取得するメソッド */
	public static List<SubmissionDetail> submissionData(String userId) {
		String submissionInfo = "SELECT sform.user_id, sform.title, sform.article, sform.create_date, sfile.id, sfile.file_name, sfile.file_data FROM submission_form sform INNER JOIN submission_file sfile ON sform.id = sfile.submission_id WHERE sform.user_id=\"" + userId + "\" ORDER BY sform.create_date DESC";

		//db処理
		Connection con = null;
		Statement smt = null;
		List<SubmissionDetail> submissionDetailList = new ArrayList<SubmissionDetail>();

		String url = "jdbc:mysql://localhost:3306/redogs_db?serverTimezone=JST";
		String user = "kono";
		String pass = "wwma6324";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
			smt = con.createStatement();

			ResultSet result = smt.executeQuery(submissionInfo);

			while (result.next()) {
				SubmissionDetail submissionDetail = new SubmissionDetail();
				submissionDetail.setUserId(result.getString("user_id"));
				submissionDetail.setTitle(result.getString("title"));
				submissionDetail.setArticle(result.getString("article"));
				submissionDetail.setFileId(result.getString("id"));
				submissionDetail.setFileName(result.getString("file_name"));
				submissionDetail.setFileData(result.getBinaryStream("file_data"));
				submissionDetail.setCreateDate(result.getDate("create_date").toString());
				submissionDetailList.add(submissionDetail);
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

		return submissionDetailList;
	}

	/** userIdから投稿情報を取得するメソッド */
	public static List<SubmissionDetail> recentSubmissionData() {
		String submissionInfo = "SELECT sform.user_id, us.nickname, sform.title, sform.article, sform.create_date, sfile.id, sfile.file_name FROM submission_form sform INNER JOIN submission_file sfile ON sform.id = sfile.submission_id INNER JOIN user_system us ON sform.user_id = us.user_id ORDER BY sform.create_date DESC LIMIT 10";

		//db処理
		Connection con = null;
		Statement smt = null;
		List<SubmissionDetail> submissionDetailList = new ArrayList<SubmissionDetail>();

		String url = "jdbc:mysql://localhost:3306/redogs_db?serverTimezone=JST";
		String user = "kono";
		String pass = "wwma6324";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
			smt = con.createStatement();

			ResultSet result = smt.executeQuery(submissionInfo);

			while (result.next()) {
				SubmissionDetail submissionDetail = new SubmissionDetail();
				submissionDetail.setUserId(result.getString("user_id"));
				submissionDetail.setNickname(result.getString("nickname"));
				submissionDetail.setTitle(result.getString("title"));
				submissionDetail.setArticle(result.getString("article"));
				submissionDetail.setFileId(result.getString("id"));
				submissionDetail.setFileName(result.getString("file_name"));
				submissionDetail.setCreateDate(result.getDate("create_date").toString());
				submissionDetailList.add(submissionDetail);
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

		return submissionDetailList;
	}
}
