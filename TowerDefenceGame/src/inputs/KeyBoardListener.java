package inputs;

import java.awt.event.KeyEvent;

import static main.GameStates.*;
import java.awt.event.KeyListener;

import main.GameStates;

public class KeyBoardListener implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_A)
			GameStates.gameState = MENU;
		if(e.getKeyCode() == KeyEvent.VK_S)
			GameStates.gameState = PLAYING;
		if(e.getKeyCode() == KeyEvent.VK_D)
			GameStates.gameState = SETTINGS;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
