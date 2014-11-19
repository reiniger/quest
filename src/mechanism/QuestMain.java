package mechanism;

import java.util.ArrayList;

public class QuestMain {
	public static void main(String args[]) {
	    QuestParser read = new QuestParser();
	    ArrayList<Screen> quest = read.readQuest("D:/java/workspace/Quest/src/Quest.xml");
	    new QuestStart().start(quest);
	    //System.out.println("hi");
	}
}