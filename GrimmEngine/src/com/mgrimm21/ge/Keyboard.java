package com.mgrimm21.ge;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{
	
	
	private static boolean[] keys = new boolean[200];
	private static boolean[] keysFirst = new boolean[200];
	
	public static boolean isKeyDown(int key) {
		return keys[key];
	}
	
	public static boolean isNewKeyDown(int key) {
		if (keysFirst[key]) {
			keysFirst[key] = false;
			return true;
		}else return false;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		keysFirst[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		keysFirst[e.getKeyCode()] = false;
	}

}
