package airplane.display;

import java.awt.Image;

public class DisplayObject {
	
	private int x = 0;
	private int y = 0;
	private Image image;
	
	public void setX(int value) {
		x = value;
	}
	
	public int getX() {
		return x;
	}
	
	public void setY(int value) {
		y = value;
	}
	
	public int getY() {
		return y;
	}
	
	public void setImage(Image img) {
		this.image = img;
	}
	
	
	public Image getImage() {
		return this.image;
	}
	
}
