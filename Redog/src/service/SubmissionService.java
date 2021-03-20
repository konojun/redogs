package service;

import javax.servlet.http.Part;

import dao.SubmissionDao;
import dao.SubmissionFileDao;

public class SubmissionService {

	/** 投稿内容を保存メソッド */
	public void fileUpload(String userId, String title, String article, Part part) {
		Integer submissionId = null;

		// 投稿内容を保存
		SubmissionDao.saveSubmission(userId, title, article);

		submissionId = SubmissionDao.getSubmissionId(userId);

		// 画像を保存
		String fileName = getFileName(part);
		SubmissionFileDao.fileUpdate(userId, submissionId, fileName, part);

	}

	private String getFileName(Part part) {
        String name = null;
        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
            if (dispotion.trim().startsWith("filename")) {
                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
                name = name.substring(name.lastIndexOf("\\") + 1);
                break;
            }
        }
        return name;
    }
}
