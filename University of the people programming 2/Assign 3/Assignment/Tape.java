package Assignment;

public class Tape {
	
	private Cell currentCell;
	
	public Tape() {
		Cell cell = new Cell();
		cell.content = ' ';
		cell.prev = null;
		cell.next = null;
		currentCell = cell;
	}
	

	public Cell getCurrentCell() {
		return currentCell;
	}

	public char getContent() {
		return currentCell.content;
	}

	public void setContent(char ch) {
		currentCell.content = ch;
	}
	
	public void moveLeft() {
		if (currentCell.prev == null) {
			Cell newCell = new Cell();
			newCell.content = ' ';
			newCell.prev = null;
			currentCell.prev = newCell;
			newCell.next = currentCell;
			currentCell = newCell;
		} else {
			currentCell = currentCell.prev;
		}
	}
	
	public void moveRight() {
		if (currentCell.next == null) {
			Cell newCell = new Cell();
			newCell.content = ' ';
			newCell.next = null;
			currentCell.next = newCell;
			newCell.prev = currentCell;
			currentCell = newCell;
		} else {
			currentCell = currentCell.next;
		}
	}
	
	public String getTapeContents() {
		
		Cell runner;
		runner = currentCell;
		while(runner.prev != null) {
			runner = runner.prev;
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(runner != null) {
			sb.append(runner.content);
			runner = runner.next;
		}
		
		return sb.toString().trim();
	}
	
}
