package service;

import dao.CreateDao;

public class CreateService {

	/** 新規ユーザーを作成するメソッド */
	public void createUser(String userId, String hashPassword, String nickname, String mailAddress) {

		CreateDao.createUser(userId, hashPassword, mailAddress, nickname);

	}

	/** ユーザーIDの重複チェックメソッド */
	public boolean checkUserId(String userId) {

		return CreateDao.checkUser(userId);

	}

}
