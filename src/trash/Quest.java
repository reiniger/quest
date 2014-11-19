package trash;

import java.util.ArrayList;

import mechanism.Screen;

public class Quest {
	private ArrayList<Screen> quest;
	
	public void addScreen(Screen screen) {
		quest.add(screen);
	}
	
	public ArrayList<Screen> getQuest() {
		return quest;
	}
}