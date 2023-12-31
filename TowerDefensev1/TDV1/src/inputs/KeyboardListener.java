package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static code.GameStates.*;

import code.Game;
import code.GameStates;

public class KeyboardListener implements KeyListener {
	private Game game;

	public KeyboardListener(Game game) {
		this.game = game;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (GameStates.gameState == EDIT)
			game.getEditor().keyPressed(e);

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
