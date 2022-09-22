package main;

import java.io.FileNotFoundException;

import javax.swing.JFrame;

import scenes.Menu;
import scenes.Playing;
import scenes.Settings;

public class Game extends JFrame implements Runnable {
	
	private GameScreen gameScreen;
	private Thread gameThread;
	
	private int updates;
	private long lastTimeUPS;
	
	private final double FPS_SET = 120.0;
	private final double UPS_SET = 60.0;
	
	
	
	//Classes
	private Render render;
	private Menu menu;
	private Playing playing;
	private Settings settings;
	
	
	public Game() throws FileNotFoundException {
		initClasses();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		add(gameScreen);
		pack();
		setVisible(true);
		
	}
	private void initClasses() throws FileNotFoundException {
		render = new Render(this);
		gameScreen = new GameScreen(this);
		menu = new Menu(this);
		playing = new Playing(this);
		settings = new Settings(this);
	}
	
	


	
	private void start() {
		gameThread = new Thread(this) {};
		
		gameThread.start();
	}
	


	private void updateGame() {
		//updates++;
		
		//System.out.println("Game Updated!");
		
	}

	public static void main(String[] args) throws FileNotFoundException {
		Game game = new Game();
		game.gameScreen.initInputs();
		game.start();
		//game.loopGame();
		
		
	}

	
	public void run() {
		double timePerFrame = 1000000000.0 / FPS_SET;
		double timePerUpdate = 1000000000.0 / UPS_SET;
		
		long lastFrame = System.nanoTime();
		long lastUpdate = System.nanoTime();
		long lastTimeCheck = System.currentTimeMillis();
		
		int frames = 0;
		int updates = 0;
		
		long now;
		
		// Render
		while (true) {
			
			now = System.nanoTime();
			//Render
			if (now - lastFrame >= timePerFrame) {
				repaint();
				lastFrame = now;
				frames++;
			}
			// Update
			if (now - lastUpdate >= timePerUpdate) {
				updateGame();
				lastUpdate = now;
				updates++;
			}

			if(System.currentTimeMillis() - lastTimeCheck >= 1000) {
				System.out.println("FPS " + frames + "/ UPS: " + updates);
				frames = 0;
				updates = 0;
				lastTimeCheck = System.currentTimeMillis();
				
			}
		}

		

		// Checking FPS and UPS

	}
	
	//Getters and Setters
	public Render getRender() {
		return render;
	}
	public Menu getMenu() {
		return menu;
	}
	
	public Playing getPlaying() {
		return playing;
	}
	
	public Settings getSettings() {
		return settings;
	}
	
	

}
