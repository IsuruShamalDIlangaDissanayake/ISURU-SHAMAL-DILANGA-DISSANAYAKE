package Assignment;

import java.util.ArrayList;

public class TuringMachine {
	
	private ArrayList<Rule> rules = new ArrayList<Rule>();  // This machine's program.
	
	public void addRule(Rule rule) {
		rules.add(rule);
	}
	
	public void addRules(Rule[] rules) {
		for (Rule rule : rules)
			addRule(rule);
	}
	
	public String run(Tape tape) throws IllegalStateException {
		int currentState = 0;
		while (currentState >= 0) {
			char currentContent = tape.getContent();
			Rule applicableRule = null;
			for (Rule rule : rules) {
				if (rule.currentContent == currentContent && rule.currentState == currentState) {
					applicableRule = rule;
					break;
				}
			}
			if (applicableRule == null)
				throw new IllegalStateException("Cannot find an applicable rule; tape contents = " 
						+ tape.getTapeContents());
			currentState = applicableRule.newState;
			tape.setContent(applicableRule.newContent);
			if (applicableRule.moveLeft)
				tape.moveLeft();
			else
				tape.moveRight();
		}
		return tape.getTapeContents();
	}	
}
