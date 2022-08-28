package airplane;

import airplane.display.EnemyPlane;

public class EnemyQueue1 {

	public Board board;
	private int count = 0;
	
	public EnemyQueue1(Board board) {
		this.board = board;		
		
	}
	
	public void pop() {
		count++;
		
		EnemyPlane plane;
		
		if(count == 50) {
			plane = new EnemyPlane();
			plane.setStyle(0);
			plane.setY(-32);
			plane.setX(64);
			board.enemies.add(plane);
			System.out.println("add enemy");
		}
		
		
		
		
	}
	
	
}
