package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.SubmissionDetailDao;
import dto.SubmissionDetail;

public class SubmissionDetailService {

	/** 投稿データを取得するメソッド
	 * @throws SQLException
	 * @throws IOException */
	public List<SubmissionDetail> submissionData(String userId) throws SQLException, IOException {

		// 投稿データを取得
		List<SubmissionDetail> submissionDetailList = SubmissionDetailDao.submissionData(userId);

		return submissionDetailList;
	}
}
