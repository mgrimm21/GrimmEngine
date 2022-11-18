package com.mgrimm21.ge.test;

import com.mgrimm21.ge.Game;
import com.mgrimm21.ge.TileMap;
import com.mgrimm21.ge.scene.Scene;
import com.mgrimm21.ge.scene.SceneManager;

public class Main {

	public static void main(String[] args) {
		Game game = Game.createGame("From Nothing");
		game.createWindow();
		game.start();
		Scene scene = new Scene();
		TileMap map = new TileMap(32, 32);
		scene.addTileMap(map);
		SceneManager.setActiveScen(scene);
	}

}
