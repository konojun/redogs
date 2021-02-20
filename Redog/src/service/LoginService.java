package service;

import dao.LoginDao;

public class LoginService {

	/** userIdとhashpasswordに一致するユーザーが存在するか判定を行うメソッド */
	public Boolean userAuthentication(String userId, String hashPassword) {

		Boolean userCheckFlg = false;

		String resultId = LoginDao.findUser(userId, hashPassword);

		if (resultId != null) {
			userCheckFlg = true;
		} else {
			userCheckFlg = false;
		}

		return userCheckFlg;

	}

}
