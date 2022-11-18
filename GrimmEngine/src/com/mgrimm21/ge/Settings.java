package com.mgrimm21.ge;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Settings {
	
	public static Dimension windowSize = new Dimension(640, 480);
	public static boolean windowFullscreen=false;

	static {
		//loadSettings();
	}
	public static boolean loadSettings() {
		File folders = new File("C:/Users/" + System.getProperty("user.name") + "/Documents/Grimm/FromNothing");
		
		if (!folders.exists()) {
			folders.mkdirs();
		}
		
		File settingsFile = new File("C:/Users/" + System.getProperty("user.name") + "/Documents/Grimm/FromNothing/settings.txt");
		
		if (!settingsFile.exists()) {
			try {
				settingsFile.createNewFile();
				FileWriter writer = new FileWriter(settingsFile);
				writer.write("Width: 640\nHeight: 480\nFullscreen: False");
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			try {
				Scanner reader = new Scanner(settingsFile);
			      while (reader.hasNextLine()) {
			        try {
			        	int width = Integer.parseInt(reader.nextLine().split(":")[1].trim());
			        	int height = Integer.parseInt(reader.nextLine().split(":")[1].trim());
			        	windowFullscreen = Boolean.parseBoolean(reader.nextLine().split(":")[1].trim());
			        	if (!windowFullscreen) {
			        		windowSize = new Dimension(width, height);
			        	}else {
			        		windowSize = Toolkit.getDefaultToolkit().getScreenSize();
			        	}
			        }catch(Exception e) {
			        	System.err.println("Invalid setting file!");
			        	System.exit(-1);
			        }
			      }
			      reader.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		
		return true;
	}
}
