package com.mgrimm21.ge;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.mgrimm21.ge.scene.Scene;
import com.mgrimm21.ge.scene.SceneManager;

public class Game implements Runnable{
	
	public static Game instance = null;
	
	private boolean running = false;
	private Thread thread;
	private Canvas canvas = new Canvas();
	private JFrame frame;
	private double runspeed = 60;
	private String gameName;
	private Keyboard keyboard = new Keyboard();
	private Camera camera = new Camera(Settings.windowSize.width*2, Settings.windowSize.height*2);

	private void tick() {
		if (SceneManager.getActiveScene() != null) SceneManager.tick();
	}
	
	private void render() {
		if (canvas.getBufferStrategy() == null) {
			canvas.createBufferStrategy(3);
			return;
		}
		BufferStrategy bs = canvas.getBufferStrategy();
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, Settings.windowSize.width, Settings.windowSize.height);
		if (SceneManager.getActiveScene() != null) SceneManager.render(g);
		bs.show();
		g.dispose();
	}
	
	private Game(String gameName) {
		this.gameName = gameName;
	}
	
	
	public void createWindow() {
		frame = new JFrame();
		frame.setPreferredSize(Settings.windowSize);
		frame.setMinimumSize(Settings.windowSize);
		frame.setMaximumSize(Settings.windowSize);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		if (Settings.windowFullscreen) {
			frame.setExtendedState(Frame.MAXIMIZED_BOTH);
			frame.setUndecorated(true);
		}
		frame.add(canvas);
		canvas.setFocusable(true);
		canvas.addKeyListener(keyboard);
		frame.setVisible(true);
		canvas.requestFocus();
	}
	
	public synchronized void start() {
		if(thread == null) {
			thread = new Thread(this);
		}
		running = true;
		thread.start();
	}
	
	public synchronized void stop() {
		try {
			running = false;
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	 public void run() {
		long lastTime = System.nanoTime();
        ///final double amountOfTicks = 60.0;
        //double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();

        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / (1000000000 / runspeed);
            lastTime = now;
            if(delta >= 1){
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println(updates + " Ticks, Fps " + frames);
                updates = 0;
                frames = 0;
            }

        }
        stop();
	}

	public String getGameName() {
		return gameName;
	}
	
	public void setRunSpeed(double runspeed) {
		this.runspeed = runspeed;
	}
	
	public double getRunSpeed() {
		return runspeed;
	}
	
	public static Game createGame(String gameName) {
		if (instance != null) return null;
		instance = new Game(gameName);
		return instance;
	}
	
	public Camera getCamera() {
		return camera;
	}
}
