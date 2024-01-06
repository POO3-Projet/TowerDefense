package events;

import java.util.ArrayList;

public class Marathon {
	private ArrayList<Integer> enemyList;

	public Marathon(ArrayList<Integer> enemyList) {
		this.enemyList = enemyList;
	}

	public ArrayList<Integer> getEnemyList() {
		return enemyList;
	}

}
