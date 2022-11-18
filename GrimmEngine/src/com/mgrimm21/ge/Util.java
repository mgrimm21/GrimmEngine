package com.mgrimm21.ge;

import java.awt.Polygon;
import java.util.Random;

public class Util {
	
	private static final Random r = new Random();

	public static Polygon createRandomPolygon(int points, int centerX, int centerY, int maxX, int maxY) {
		Polygon p = new Polygon();
		
		for (int i = 0; i < points; i++) {
			int x = centerX + r.nextInt(centerX + maxX) - (centerX - maxX);
			int y = centerY + r.nextInt(centerY + maxY) - (centerY - maxY);
			p.addPoint(x, y);
		}
		return p;
	}
	
}
