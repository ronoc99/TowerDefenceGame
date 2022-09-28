package main;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import inputs.KeyBoardListener;
import inputs.MyMouseListener;

public class GameScreen extends JPanel {

	
	private Game game;
	private Dimension size;
	
	private MyMouseListener myMouseListener;
	private KeyBoardListener keyboardListener; 
	

	public GameScreen(Game game) {
		this.game = game;
		
		
		
		setPanelSize();	

	}
	
	public void initInputs() {
		myMouseListener = new MyMouseListener(game); 
		keyboardListener = new KeyBoardListener(game);
		
		addMouseListener(myMouseListener);
		addMouseMotionListener(myMouseListener);
		addKeyListener(keyboardListener);
		
		requestFocus();
	}

	private void setPanelSize() {
		size = new Dimension(640,740);
		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
		
	}

	

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		game.getRender().render(g);

		// g.drawImage(sprites.get(25), 0, 0, null);

		// g.drawImage(img.getSubimage(32*9, 32, 32, 32), 0, 0, null);

		
		
	}
		
		
		

	

	

}
