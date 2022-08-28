package airplane.display;


import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class Player extends Plane {
	
	public Image img_forward;
	public Image img_rightward;
	public Image img_lefttward;
	
	public Player() {
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/player.png"));		
		Image img = icon.getImage();
		
		img_forward = new BufferedImage(64, 80, BufferedImage.TYPE_INT_ARGB);
		img_lefttward = new BufferedImage(64, 80, BufferedImage.TYPE_INT_ARGB);
		img_rightward = new BufferedImage(64, 80, BufferedImage.TYPE_INT_ARGB);
	
		img_forward.getGraphics().drawImage(img, 0, 0, 64, 80, 0, 0, 64, 80, null);
		img_lefttward.getGraphics().drawImage(img, 0, 0, 64, 80, 64, 0, 128, 80, null);
		img_rightward.getGraphics().drawImage(img, 0, 0, 64, 80, 128, 0, 196, 80, null);
		
		
		this.setImage(img_forward);
	}
	
	public void forward() {		
		this.setY(this.getY() - 2);
	}
	
	public void backward() {		
		this.setY(this.getY() + 2);
	}
	
	public void rightward() {		
		this.setX(this.getX() + 2);
	}
	
	public void leftward() {		
		this.setX(this.getX() - 2);
	}
	
}
