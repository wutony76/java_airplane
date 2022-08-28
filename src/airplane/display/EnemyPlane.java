package airplane.display;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class EnemyPlane extends Plane {	

	public EnemyPlane() {
		
		
	}
	
	public void update() {
		setY(getY() + 8);
	}
	
	public void setStyle(int style) {
		int w = 64;
		int h = 72;
		
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/enemy.png"));		
		Image img = icon.getImage();		
		Image image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);		
		Graphics2D g = (Graphics2D)image.getGraphics();	

		
		int x2 = style*64;
		g.drawImage(img, 0, 0, w, h, x2, 0, x2+w, h, null);
		g.scale(1, -1);
		
		this.setImage(image);
		
	}

	
}