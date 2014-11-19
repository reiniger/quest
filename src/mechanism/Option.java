package mechanism;

public class Option {
	private String text;
	private String name;
	private String next;
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setNext(String next) {
		this.next = next;
	}
	
	public String getNext() {
		return next;
	}
}