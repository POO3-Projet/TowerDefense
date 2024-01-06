package scenes;

import static main.GameStates.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import main.Game;
import managers.Difficulty;
import ui.MyButton;
import ui.ActionBar;
import scenes.Playing;

public class Victory extends GameScene implements SceneMethods {

	private MyButton bReplay, bMenu;
    ActionBar actionBar;
    Playing playing;

	public Victory(Game game, ActionBar actionBar, Playing playing) {
		super(game);
        this.actionBar = actionBar;
        this.playing = playing;
		initButtons();
	}

	private void initButtons() {

		int w = 150;
		int h = w / 3;
		int x = 640 / 2 - w / 2;
		int y = 300;
		int yOffset = 100;

		bMenu = new MyButton("Menu", x, y, w, h);
		bReplay = new MyButton("Replay", x, y + yOffset, w, h);

	}

	@Override
	public void render(Graphics g) {
		// won text + stats
		g.setFont(new Font("LucidaSans", Font.BOLD, 30));
		g.setColor(Color.GREEN);
		g.drawString("Vous avez gagné le mode waves!", 70, 80);
        g.drawString("avec " + actionBar.getGold() + " gold et " + playing.getEnnemyKil() + " ennemies tués", 80,140);
		// buttons
		g.setFont(new Font("LucidaSans", Font.BOLD, 20));
		bMenu.draw(g);
		bReplay.draw(g);
	}

	private void replayGame() {
		// reset everything
		resetAll();

		// change state to playing
		SetGameState(PLAYING);

	}

	private void resetAll() {
		game.getPlaying().reset(game.getSettings().getDifficulty());
	}

	@Override
	public void mouseClicked(int x, int y) {
		if (bMenu.getBounds().contains(x, y)) {
			SetGameState(MENU);
			resetAll();
		} else if (bReplay.getBounds().contains(x, y))
			replayGame();
	}

	@Override
	public void mouseMoved(int x, int y) {
		bMenu.setMouseOver(false);
		bReplay.setMouseOver(false);

		if (bMenu.getBounds().contains(x, y))
			bMenu.setMouseOver(true);
		else if (bReplay.getBounds().contains(x, y))
			bReplay.setMouseOver(true);
	}

	@Override
	public void mousePressed(int x, int y) {
		if (bMenu.getBounds().contains(x, y))
			bMenu.setMousePressed(true);
		else if (bReplay.getBounds().contains(x, y))
			bReplay.setMousePressed(true);

	}

	@Override
	public void mouseReleased(int x, int y) {
		bMenu.resetBooleans();
		bReplay.resetBooleans();

	}

	@Override
	public void mouseDragged(int x, int y) {
		// TODO Auto-generated method stub

	}

}