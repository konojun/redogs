package service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;

import dao.SubmissionDetailDao;
import dto.SubmissionDetail;

public class SubmissionDetailService {

	/** 投稿データを取得するメソッド
	 * @throws SQLException
	 * @throws IOException */
	public List<SubmissionDetail> submissionData(String userId) throws SQLException, IOException {

		// 投稿データを取得
		List<SubmissionDetail> submissionDetailList = SubmissionDetailDao.submissionData(userId);

		for (SubmissionDetail submissionDetail : submissionDetailList) {
			submissionDetail.setFileData64(toBase64(submissionDetail.getFileData()));
		}

		return submissionDetailList;
	}

	public static String toBase64(final InputStream is) throws IOException {
		final int kb = 1024;
		final int factor = 4;

		ByteArrayOutputStream output = null;
		try {
		output = new ByteArrayOutputStream();
		byte[] buffer = new byte[kb * factor];
		int count = 0;
		int n = 0;

		while (-1 != (n = is.read(buffer))) {
		output.write(buffer, 0, n);
		count += n;
		}

		return Base64.encodeBase64String(output.toByteArray());

		} finally {

		if (is != null) {
			is.close();
		}

		}
		}
}


