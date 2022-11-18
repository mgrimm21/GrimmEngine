package com.mgrimm21.ge.scene;

import java.awt.Graphics;

public class SceneManager {
	
	private static Scene activeScene = null;

	
	public static synchronized void tick() {
		activeScene.tick();
	}
	
	public static synchronized void render(Graphics g) {
		activeScene.render(g);
	}
	
	public static void setActiveScen(Scene scene) {
		activeScene = scene;
	}

	public static Scene getActiveScene() {
		return activeScene;
	}

}
