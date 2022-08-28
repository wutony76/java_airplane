package airplane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import airplane.display.Plane;
import airplane.display.Player;

public class Board extends JPanel implements ActionListener {
	
	private final int DELAY = 100;
	private Timer timer;
	public Player player;
	public Background bg;
	public ArrayList<Plane> enemies;
	private EnemyQueue1 enemyQueue;
	
	public Board() {
		this.setBackground(Color.black);
		this.setFocusable(true);
		
		addKeyListener(new BoardKeyAdapter());
		
		initGame();
	}
	
	public void initGame() {
		
		player = new Player();
		player.setX(148);
		player.setY(360);
		
		bg = new Map1();
		
		enemies = new ArrayList<Plane>();
		enemyQueue = new EnemyQueue1(this);
		
		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	public void update() {
		bg.update();
		for(Plane plane: enemies) {
			plane.update();
		}
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(bg.getImage(), 0, 0, null);
		
		for(Plane plane: enemies) {
			g2d.drawImage(plane.getImage(), plane.getX(), plane.getY(), null);
		}
		
		g2d.drawImage(player.getImage(), player.getX(), player.getY(), null);
		
		g.dispose();
	}		

	public void actionPerformed(ActionEvent arg0) {
		update();
		enemyQueue.pop();
		this.repaint();		
	}
	
	private class BoardKeyAdapter extends KeyAdapter {
		
		public void keyTyped(KeyEvent e) {
		}
		
		public void keyPressed(KeyEvent e) {
			
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				if(player.getY() > -10) {
					player.forward();
				}
			} else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				if(player.getY() < 380) {
					player.backward();		
				}
			}
			
			if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				if(player.getX() < 328) {
					player.rightward();
					player.setImage(player.img_rightward);
				}
				
			} else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				if(player.getX() > -32) {
					player.leftward();	
					player.setImage(player.img_lefttward);
				}
			}	
		
		}
		
		public void keyReleased(KeyEvent e) {
			player.setImage(player.img_forward);
		}
		
	}
	
}
