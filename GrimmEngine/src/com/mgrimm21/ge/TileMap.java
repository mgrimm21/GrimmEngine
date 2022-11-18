package com.mgrimm21.ge;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class TileMap {

	private int width, height;
	private Tile[][] tiles;
	
	public TileMap(int width, int height) {
		this.width = width;
		this.height = height;
		genMap();
	}
	
	private void genMap() {
		tiles = new Tile[width][height];
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				tiles[x][y] = new Tile(x*32, y*32);
			}
		}
	}
	
	public void tick() {
		if (Keyboard.isKeyDown(KeyEvent.VK_W)) {
			System.out.println("W");
			Game.instance.getCamera().moveY(1);
		}if (Keyboard.isKeyDown(KeyEvent.VK_S)) {
			Game.instance.getCamera().moveY(-1);
		}if (Keyboard.isKeyDown(KeyEvent.VK_A)) {
			Game.instance.getCamera().moveX(1);
		}if (Keyboard.isKeyDown(KeyEvent.VK_D)) {
			Game.instance.getCamera().moveX(-1);
		}
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				tiles[x][y].tick();
			}
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				tiles[x][y].render(g);
			}
		}
	}
}
