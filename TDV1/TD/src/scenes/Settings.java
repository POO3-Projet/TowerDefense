package scenes;

import java.awt.Color;
import java.awt.Graphics;
import main.Game;
import managers.Difficulty;
import managers.GameMode;
import ui.MyButton;

import static main.GameStates.*;

public class Settings extends GameScene implements SceneMethods {
    private Difficulty difficulty;
    private GameMode gameMode;
    private boolean isMarathonMode;

    private MyButton bMenu;
    private MyButton bDifficulty;
    private MyButton bGameMode;
    private MyButton bSave;
    private MyButton bLoad;

    public Settings(Game game) {
        super(game);
        difficulty = Difficulty.NORMAL;
        gameMode = GameMode.WAVES;
        isMarathonMode = false;
        initButtons();
    }

    private void initButtons() {
        bMenu = new MyButton("Menu", 2, 2, 100, 30);
        bDifficulty = new MyButton("Difficulty: Normal", 200, 200, 200, 30);
        bGameMode = new MyButton("Game Mode: Waves", 200, 250, 200, 30);
        bSave = new MyButton("Save", 420, 2, 100, 30);
        bLoad = new MyButton("Load", 530, 2, 100, 30);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1000, 1000);

        drawButtons(g);
    }

    private void drawButtons(Graphics g) {
        bMenu.draw(g);
        if (isMarathonMode) {
            bGameMode.draw(g);
            bSave.draw(g);
            bLoad.draw(g);
        }
        else {
            bGameMode.draw(g);
            bDifficulty.draw(g);
            bSave.draw(g);
            bLoad.draw(g);
        }
    }

    @Override
    public void mouseClicked(int x, int y) {
        if (bMenu.getBounds().contains(x, y))
            SetGameState(MENU);
        else if (bDifficulty.getBounds().contains(x, y))
            handleDifficultyClick();
        else if (bGameMode.getBounds().contains(x, y))
            handleGameModeClick();
        else if (bSave.getBounds().contains(x, y))
            handleSaveClick();
        else if (bLoad.getBounds().contains(x, y))
            handleLoadClick();
    }

    @Override
    public void mouseMoved(int x, int y) {
        bMenu.setMouseOver(false);
        bDifficulty.setMouseOver(false);
        bGameMode.setMouseOver(false);
        bSave.setMouseOver(false);
        bLoad.setMouseOver(false);

        if (bMenu.getBounds().contains(x, y))
            bMenu.setMouseOver(true);
        else if (bDifficulty.getBounds().contains(x, y))
            bDifficulty.setMouseOver(true);
        else if (bGameMode.getBounds().contains(x, y))
            bGameMode.setMouseOver(true);
        else if (bSave.getBounds().contains(x, y))
            bSave.setMouseOver(true);
        else if (bLoad.getBounds().contains(x, y))
            bLoad.setMouseOver(true);
    }

    @Override
    public void mousePressed(int x, int y) {
        if (bMenu.getBounds().contains(x, y))
            bMenu.setMousePressed(true);
        else if (bDifficulty.getBounds().contains(x, y))
            bDifficulty.setMousePressed(true);
        else if (bGameMode.getBounds().contains(x, y))
            bGameMode.setMousePressed(true);
        else if (bSave.getBounds().contains(x, y))
            bSave.setMousePressed(true);
        else if (bLoad.getBounds().contains(x, y))
            bLoad.setMousePressed(true);
    }

    @Override
    public void mouseReleased(int x, int y) {
        resetButtons();
    }

    private void resetButtons() {
        bMenu.resetBooleans();
        bDifficulty.resetBooleans();
        bGameMode.resetBooleans();
        bSave.resetBooleans();
        bLoad.resetBooleans();
    }

    @Override
    public void mouseDragged(int x, int y) {
        // TODO Auto-generated method stub
    }

    private void handleDifficultyClick() {
        // Toggle between difficulty levels (easy, normal, hard)
        switch (game.getSettings().getDifficulty()) {
            case EASY:
                game.getSettings().setDifficulty(Difficulty.NORMAL);
                bDifficulty.setText("Difficulty: Easy");
                break;
            case NORMAL:
                game.getSettings().setDifficulty(Difficulty.HARD);
                bDifficulty.setText("Difficulty: Normal");
                break;
            case HARD:
                game.getSettings().setDifficulty(Difficulty.EASY);
                bDifficulty.setText("Difficulty: Hard");
                break;
        }
		game.getPlaying().reset(difficulty);
    }

    private void handleGameModeClick() {
        // Toggle between game modes (waves, marathon)
        switch (game.getSettings().getGameMode()) {
            case WAVES:
                game.getSettings().setGameMode(GameMode.MARATHON);
                game.getPlaying().resetEverything();
                bGameMode.setText("Game Mode: Marathon");
                break;
            case MARATHON:
                game.getSettings().setGameMode(GameMode.WAVES);
                game.getSettings().setDifficulty(Difficulty.NORMAL);;
                bGameMode.setText("Game Mode: Waves");
                break;
        }
    }

    private void handleSaveClick() {
        // Handle save button click
        // Implement save logic here
    }

    private void handleLoadClick() {
        // Handle load button click
        // Implement load logic here
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public void setGameMode(GameMode gameMode) {
        isMarathonMode = (gameMode == GameMode.MARATHON);
        this.gameMode = gameMode;
    }

    public boolean isMarathonMode() {
        return isMarathonMode;
    }
}
