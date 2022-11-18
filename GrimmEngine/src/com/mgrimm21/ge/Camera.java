package com.mgrimm21.ge;

public class Camera {
	
	private int x, y;
	
	public Camera(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void moveX(int x) {
		this.x += x;
	}
	
	public void moveY(int y) {
		this.y += y;
	}
	
	public void move(int x, int y) {
		this.x +=x;
		this.y +=y;
	}

}
