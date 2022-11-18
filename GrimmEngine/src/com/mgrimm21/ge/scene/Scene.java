package com.mgrimm21.ge.scene;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import com.mgrimm21.ge.GameObject;
import com.mgrimm21.ge.TileMap;

public class Scene {

	private List<GameObject> gameObjects = new LinkedList<GameObject>();
	private TileMap map;
	
	public synchronized void tick() {
		if (map != null) map.tick();
		for (GameObject o: gameObjects) o.tick();
	}
	public synchronized void render(Graphics g) {
		if (map != null) map.render(g);
		for (GameObject o: gameObjects) o.render(g);
		
	}
	
	public synchronized void add(GameObject o) {
		gameObjects.add(o);
	}
	
	public synchronized void remove(GameObject o) {
		gameObjects.remove(o);
	}
	
	
	public void addTileMap(TileMap map) {
		this.map = map;
	}
	
	
}
