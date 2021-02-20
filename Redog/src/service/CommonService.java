package service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CommonService {

	/** パスワードをハッシュ化するメソッド */
	public String hashPassword(String userId, String password) {
		// パスワードハッシュ化 SHA-512
		String hashPass = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.update(userId.getBytes(StandardCharsets.UTF_8));
			byte[] bytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			hashPass = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return hashPass;
	}

}
