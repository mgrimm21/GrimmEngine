package com.mgrimm21.ge;

import java.awt.Graphics;

public abstract class GameObject{
	protected int x, y;
	public int velX, velY;
	
	public GameObject(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	public void tick() {
		x += velX;
		y += velY;
	}
	
	public abstract void render(Graphics g);

}
