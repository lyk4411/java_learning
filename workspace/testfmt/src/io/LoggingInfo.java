package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class LoggingInfo implements java.io.Serializable {
	private Date loggingDate = new Date();
	private String uid;
	private transient String pwd;

	LoggingInfo(String user, String password) {
		uid = user;
		pwd = password;
	}

	public String toString() {
		String password = null;
		if (pwd == null) {
			password = "NOT SET";
		} else {
			password = pwd;
		}
		return "logon info: \n   " + "user: " + uid + "\n   logging date : "
				+ loggingDate.toString() + "\n   password: " + password;
	}

	static LoggingInfo logInfo = new LoggingInfo("MIKE", "MECHANICS");

	public static void main(String[] s) throws Exception {
		System.out.println(logInfo.toString());
		try {
			ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(
					"logInfo.out"));
			o.writeObject(logInfo);
			o.close();
		} catch (Exception e) {// deal with exception}
		}
		// To read the object back, we can write

		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					"logInfo.out"));
			LoggingInfo logInfo = (LoggingInfo) in.readObject();
			System.out.println(logInfo.toString());
		} catch (Exception e1) {
		}
	}
}
