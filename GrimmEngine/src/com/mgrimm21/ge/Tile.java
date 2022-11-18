package com.mgrimm21.ge;

import java.awt.Graphics;

public class Tile {
	
	private int x, y;
	
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		int rx = x+Game.instance.getCamera().getX();
		int ry = y+Game.instance.getCamera().getY();
		if (rx -32> Settings.windowSize.width || ry -32> Settings.windowSize.height|| rx < -32 || ry < -32) return;
		g.drawRect(rx, ry , 32, 32);
	}

}
