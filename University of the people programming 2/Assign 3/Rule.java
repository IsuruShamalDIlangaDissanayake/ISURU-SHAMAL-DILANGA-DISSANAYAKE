package Assignment;

public class Rule {
	
	public int currentState;
	public char currentContent;
	public int newState;
	public char newContent;
	public boolean moveLeft;
	
	public Rule() {
	}
	
	public Rule(int currentState, char currentContent, int newState, char newContent, boolean moveLeft) {
		this.currentState = currentState;
		this.currentContent = currentContent;
		this.newState = newState;
		this.newContent = newContent;
		this.moveLeft = moveLeft;
	}
}
