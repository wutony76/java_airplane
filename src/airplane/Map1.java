package airplane;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class Map1 extends Background {
	
	private Image asset;

	public int y = 0;
	public int dy = 0;
	
	public int[][] map = {
			{-1, -1, -1, -1, -1, -1, -1, -1},
			{-1, -1, -1, -1, -1, -1, -1, -1},
			{-1, -1, -1, -1, -1, -1, -1, -1},
			{-1, 6, 6, 6, 6, 6, 6, -1},
			{-1, 6, 6, 6, 6, 6, 6, -1},
			{-1, 7, 6, 5, 6, 7, 8, -1},
			{1, 1, 1, 1, 1, 1, 1, 1},
			{2, 2, 2, 2, 2, 2, 2, 2},
			{2, 2, 2, 2, 2, 2, 2, 2},
			{0, 0, 0, 0, 0, 0, 0, 0},	
			{0, 0, 0, 0, 0, 0, 0, 0},	
			{0, 0, 0, 0, 0, 0, 0, 0},	
			{0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0},
			{2, 2, 2, 2, 2, 2, 2, 2},
			{2, 2, 2, 3, 2, 2, 3, 2},
			{2, 2, 2, 3, 2, 2, 3, 2},
			{4, 5, 4, 6, 5, 6, 4, 4},

	};
	
	public Map1() {
		ImageIcon assetIcon = new ImageIcon(this.getClass().getResource("/images/map.png"));
		System.out.println(assetIcon);
		asset = assetIcon.getImage();
		
		Image img = new BufferedImage(360, 480, BufferedImage.TYPE_INT_ARGB);
		this.setImage(img);
		y = map.length - 10;
		
		if(y < 0) {
			y = 0;
		}
	}
	
	
	public void update() {
		Image img = this.getImage();
		Graphics2D g = (Graphics2D)img.getGraphics();
		//g.setBackground(new Color(33, 66, 99));
		
		if( y > 0) {
			dy = (dy + 1) % 48;
			if(dy == 0) {
				y--;
			}
		
		} else {
			return;
		}		
		
		g.clearRect(0, 0, img.getWidth(null), img.getHeight(null));
		
		for(int i=0; i < 11; i++) {
			
			int mY = y + i;
			if(mY >= map.length) {
				mY = map.length - 1;
			}
			
			for(int j=0; j < map[mY].length; j++) {					
				
				int mIndex = map[mY][j];
				
				int x1 = j * 48;
				int y1 = i * 48 + dy - 48;
				
				int sy = mIndex * 48;
				
				if(mIndex != -1) {				
					g.drawImage(asset, x1, y1, x1+48, y1+48, 0, sy, 48, sy + 48, null);
				} else {
					g.setColor(Color.black);
					g.fillRect(x1, y1, x1+48, y1+48);
				}
			}
		}
	}
	
}
