package com.encore.auction.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileReadWriter {
	public Object[] fromFile() throws Exception { //open file
		ObjectInputStream ois = null;
		Object ob[] = new Object[3];
		try {
			ois = new ObjectInputStream(new FileInputStream(("conf/auction.ser")));
			ob[0] = ois.readObject();
			ob[1] = ois.readObject();
			ob[2] = ois.readObject();
		} finally {
			if(ois != null) ois.close();
		}
		return ob;
	}
	
	public void toFile(boolean autoLogin_flag, String id, String pw) throws Exception { //save file
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(("conf/auction.ser")));
		oos.writeObject(new Boolean(autoLogin_flag));
		oos.writeObject(id);
		oos.writeObject(pw);
		oos.close();
	}
}