package com.mgrimm21.ge.test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import com.mgrimm21.ge.GameObject;
import com.mgrimm21.ge.Util;

public class ResourcePatch extends GameObject{
	Polygon shape ;

	public ResourcePatch(int x, int y) {
		super(x, y);
		shape = Util.createRandomPolygon(8, x, y, 32,32);
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.drawRect(x-32, y-32, 64, 64);
		g.setColor(Color.red);
		g.fillPolygon(shape);
	}

}
