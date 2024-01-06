package main;

public enum GameStates {

	PLAYING, MENU, SETTINGS, HOWTPLAY, EDIT, VICTORY, GAME_OVER;

	public static GameStates gameState = MENU;

	public static void SetGameState(GameStates state) {
		gameState = state;
	}

}
