package mechanism;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class QuestStart {
	public void start(ArrayList<Screen> quest) {
		String choice;

		Boolean flag = true;
		
		Scanner in = new Scanner(System.in);
		
		if (quest.size() > 0) {
			Screen screen = quest.get(0);
			while (flag) {
				flag = false;

				System.out.println(screen.getText());
				
				if (screen.getOptions().isEmpty()) break;
				
				LinkedList<Option> options = screen.getOptions();
				
				for (Option o : options) {
					System.out.println(o.getText());
				}
				
			    choice = in.next();
			    
			    for (Option o : options) {
			    	if (o.getName().equals(choice)) {
			    		for (Screen s : quest) {
			    			if (s.getName().equals(o.getNext())) {
			    				screen = s;
			    				flag = true;
			    			}
			    		}
			    	}
			    }
			}
			in.close();
		}        
	}
}