package scenes;

import static main.GameStates.EDIT;
import static main.GameStates.PLAYING;
import static main.GameStates.SETTINGS;
import static main.GameStates.SetGameState;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import main.Game;
import ui.MyButton;

public class Menu extends GameScene implements SceneMethods {
	
	private BufferedImage img =null; // new BufferedImage(100, 100, 1);
	private ArrayList<BufferedImage> sprites = new ArrayList<>();
	
	private MyButton bPlaying, bEdit, bSettings, bQuit;

	public Menu(Game game) throws FileNotFoundException {
		super(game);
		//importImg();
		//loadSprites();
		initButtons();
		
	}

	private void initButtons() {
		
		int w = 150;
		int h = w /3;
		int x = 640 / 2 - w / 2;
		int y = 150;
		int yOffset = 100;
		
		bPlaying = new MyButton("Play", x, y, w, h);
		bEdit = new MyButton("Edit", x, y + yOffset, w, h);
		bSettings = new MyButton("Settings", x, y + yOffset* 2, w, h);
		bQuit = new MyButton("Quit", x, y + yOffset * 3, w, h);
		
	}

	@Override
	public void render(Graphics g) {
		
		drawButtons(g);
		
	}
	
	
	
private void drawButtons(Graphics g) {
		bPlaying.draw(g);
		bEdit.draw(g);
		bSettings.draw(g);
		bQuit.draw(g);
		
	}

//private void importImg() throws FileNotFoundException {
//	
//	InputStream is = new FileInputStream("C:/Users/Conor/git/TowerDefenceGame2/TowerDefenceGame/res/spriteatlas.png");
//	try {
//		img = ImageIO.read(is);
//		
//	} catch(Exception e) {
//		
//	}
//	
//}
	
	
//	private void loadSprites() {
//
//		for (int y = 0; y < 10; y++) {
//			for (int x = 0; x < 10; x++) {
//				sprites.add(img.getSubimage(x * 32, y * 32, 32, 32));
//
//			}
//		}
//
//	}

	@Override
	public void mouseClicked(int x, int y) {
		if (bPlaying.getBounds().contains(x, y))
			SetGameState(PLAYING);
		else if (bEdit.getBounds().contains(x, y))
			SetGameState(EDIT);
		else if (bSettings.getBounds().contains(x, y))
			SetGameState(SETTINGS);
		else if (bQuit.getBounds().contains(x, y))
			System.exit(0);
		
	}

	@Override
	public void mouseMoved(int x, int y) {
		bPlaying.setMouseOver(false);
		bEdit.setMouseOver(false);
		bSettings.setMouseOver(false);
		bQuit.setMouseOver(false);

		if (bPlaying.getBounds().contains(x, y))
			bPlaying.setMouseOver(true);
		else if (bEdit.getBounds().contains(x, y))
			bEdit.setMouseOver(true);
		else if (bSettings.getBounds().contains(x, y))
			bSettings.setMouseOver(true);
		else if (bQuit.getBounds().contains(x, y))
			bQuit.setMouseOver(true);
		
	}

	@Override
	public void mousePressed(int x, int y) {
		if (bPlaying.getBounds().contains(x, y))
			bPlaying.setMousePressed(true);
		else if (bEdit.getBounds().contains(x, y))
			bEdit.setMousePressed(true);
		else if (bSettings.getBounds().contains(x, y))
			bSettings.setMousePressed(true);
		else if (bQuit.getBounds().contains(x, y))
			bQuit.setMousePressed(true);
	}

	@Override
	public void mouseReleased(int x, int y) {
		resetButtons();
		
	}

	private void resetButtons() {
		bPlaying.resetBooleans();
		bEdit.resetBooleans();
		bSettings.resetBooleans();
		bQuit.resetBooleans();
		
	}

	@Override
	public void mouseDragged(int x, int y) {
		// TODO Auto-generated method stub
		
	}



}
