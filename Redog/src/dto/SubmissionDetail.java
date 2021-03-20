package dto;

import java.io.InputStream;

public class SubmissionDetail {

	private String userId;

	private String nickname;

	private String title;

	private String article;

	private String fileId;

	private String fileName;

	private InputStream fileData;

	private String fileData64;

	private String createDate;


	public String getUserId() {
		return userId;
	}

	public void setUserId(String string) {
		this.userId = string;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public InputStream getFileData() {
		return fileData;
	}

	public void setFileData(InputStream fileData) {
		this.fileData = fileData;
	}

	public String getFileData64() {
		return fileData64;
	}

	public void setFileData64(String fileData64) {
		this.fileData64 = fileData64;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

}
