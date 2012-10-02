package com.edwin.login.module;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.edwin.sql.QueryErp;

public class Person {

	private String userName;
	private String passWord;

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
		

	}

	/**
	 * @param pUserName
	 *            the userName to set
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void setUserName(String pUserName) throws ClassNotFoundException,
			SQLException {

		QueryErp qr = new QueryErp();
		ResultSet rs = null;
		rs = qr.rsErp(
				"SELECT ISNULL(MF001,'')  MF001,ISNULL(MF002,'')  MF002 FROM ADMMF WHERE MF001=? ",
				pUserName);
		if (rs.next()) {

			this.userName = rs.getString("MF002");
		} else {

			this.userName = "用户名错误";

		}
	}

	/**
	 * @return the passWord
	 */
	public String getPassWord() {
		return passWord;
	}

	/**
	 * @param pPassWord
	 *            the passWord to set
	 */
	public void setPassWord(String pPassWord) {
		passWord = pPassWord;
	}

	@Override
	public String toString() {
		return "userName: " + getUserName() + "                    "
				+ "passWord:  " + getPassWord();
	}
}
