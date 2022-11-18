package com.mgrimm21.ge;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class SaveManager {
	
	private static String directory = "C:/Users/" + System.getProperty("user.name") + "/Documents/" + Game.instance.getGameName();
	private static Map<String, DataType> saveMap = new HashMap<String, DataType>();
	private SaveManager() {}
	
	public void setupSaveConfiguration(String[] identifiers, DataType[] dataTypes){
		if (identifiers.length!=dataTypes.length) {
			System.err.println("Identifier length not equal to dataType length in SaveManager");
			return;
		}
		for (int i = 0; i < identifiers.length; i++) {
			saveMap.put(identifiers[i], dataTypes[i]);
		}
	}
	
	public static void save(String fileName, Object[] objects) {
		try {
			File f = new File(directory);
			if (!f.exists()) f.mkdir();
			FileOutputStream fos = new FileOutputStream(directory + "/" + fileName);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			for (Object o: objects) oos.writeObject(o);
			oos.close();
			bos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void setDirectory(String dir) {
		directory = dir;
	}
	
}
