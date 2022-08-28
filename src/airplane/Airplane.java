package airplane;

import javax.swing.JFrame;

public class Airplane extends JFrame {
	
	public Airplane(){
		add(new Board());
		
		setTitle("Airplane Demo");
		setSize(360, 480);
		setVisible(true);
		
	}

	public static void main(String[] args) {		
		new Airplane();
	}
}
