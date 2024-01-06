package scenes;

import static main.GameStates.MENU;
import static main.GameStates.SetGameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import main.Game;
import ui.MyButton;

public class HowTPlay extends GameScene implements SceneMethods{

    private MyButton bMenu;

    public HowTPlay(Game game) {
        super(game);
        initButtons();
    }

    private void initButtons() {
        bMenu = new MyButton("Menu", 2, 2, 100, 30);
    }

    @Override
    public void render(Graphics g) {
        drawButtons(g);
        g.setColor(Color.BLACK);
        g.setFont(new Font("LucidaSans", Font.BOLD, 35));
        g.drawString("Instructions", 230, 80);
        g.setFont(new Font("LucidaSans", Font.BOLD, 20));
        g.drawString("Selection des modes et difficultés dans settings", 70, 110);
        g.drawString("Editer la carte à sa volonté dans edit", 70, 140);
        g.drawString("Posez des tours et les ameliorer en cliquant sur elles", 70, 170);
    }

    private void drawButtons(Graphics g) {
        bMenu.draw(g);
    }

    @Override
    public void mouseClicked(int x, int y) {
        if (bMenu.getBounds().contains(x, y)) {
            SetGameState(MENU);
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        bMenu.setMouseOver(false);
        if (bMenu.getBounds().contains(x, y)) {
            bMenu.setMouseOver(true);
        }
    }

    @Override
    public void mousePressed(int x, int y) {
        if (bMenu.getBounds().contains(x, y)) {
            bMenu.setMousePressed(true);
        }        
    }

    @Override
    public void mouseReleased(int x, int y) {
        resetButtons();
    }

    private void resetButtons() {
        bMenu.resetBooleans();
    }

    @Override
    public void mouseDragged(int x, int y) {
    }
    
}
