package mechanism;

import java.util.LinkedList;

public class Screen {
	private String name;
	private String text;
	private LinkedList<Option> options;
	
	Screen() {
		options = new LinkedList<Option>(); 
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	public void addOption(Option option) {
		options.add(option);
	}
	
	public LinkedList<Option> getOptions() {
		return options;
	}
}