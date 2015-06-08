import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;


class Visuals extends JPanel{
	
	GBoard b1, b2;
	
	/**
	 * Initializes a Visual intended for use in BGraphics
	 * @param b1
	 * @param b2
	 */
	public Visuals(GBoard b1, GBoard b2){
		this.b1 = b1; this.b2 = b2;
	}
	
	/**
	 * The function to do the drawing whenever the window is updated
	 * @param g the graphics object to draw on
	 */
	private void doDrawing(Graphics g){
		int r = BGraphics.RECT_W;
		Graphics2D g2d = (Graphics2D) g;
		int bigRectW = BGraphics.RECT_W * b1.getLength();
		int eD = b1.getLength() * (BGraphics.RECT_W + 1) + r; // enemyDisplacement
		
		g2d.drawRect(r, r, bigRectW, bigRectW);
		g2d.drawRect(eD + r, r, bigRectW, bigRectW);
		
		for(int i = 0; i < b1.getLength(); i++){
			//Draw the upper numbers for player then enemy
			g2d.drawString(i + "", r + 20 + r*i, 20);
			g2d.drawString(i + "", r + 20 + eD + r*i, 20);
			
			//Draw the left numbers for player then enemy
			g2d.drawString(i + "", 20, r + r*i + 20);
			g2d.drawString(i + "", 20 + eD, r + r*i + 20);
			
			//Draw the vertical number lines for player then enemy
			g2d.drawLine(i*r + r, r, i*r + r, bigRectW + r);
			g2d.drawLine(i*r + r + eD, r, i*r + r + eD, bigRectW + r);
			
			//Draw the horizontal number lines for player then enemy
			g2d.drawLine(r, i*r + r, r + bigRectW, i*r + r );
			g2d.drawLine(r + eD, i*r + r, r + bigRectW + eD, i*r + r );
		}
		
		for(int i = 0; i < b1.getLength(); i++){
			for(int j = 0; j < b1.getLength(); j++){
				// Do the player's drawing
				if(b1.isHit(i,j) && b1.isShip(i,j)){
					g2d.fillOval(i*r+4 + r, j*r+4 + r, r-8, r-8);
				}else if(b1.isHit(i,j)){
					g2d.drawOval(i*r+4 + r, j*r+4 + r, r-8, r-8);
				}else if(b1.isShip(i,j)){
					g2d.fillRect(i*r + r, j*r + r, r, r);
				}
				// Do the enemy's drawing
				if(b2.isHit(i,j) && b2.isShip(i,j)){
					g2d.fillRect(i*r+eD + r, j*r + r, r, r);
				}else if(b2.isHit(i,j)){
					g2d.drawOval(i*r+4+eD + r, j*r+4 + r, r-8, r-8);
				}
			}
		}
	}
	
	/**
	 * The function that is called when graphics need an update
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		doDrawing(g);
	}
}

public class BGraphics extends JFrame{

	public static final int RECT_W = 40;
	private GBoard b1,b2;
	
	/**
	 * Initializes a Graphical representation of two battleship boards
	 * @param b1 the board of the player
	 * @param b2 the board of the enemy
	 */
	public BGraphics(GBoard b1, GBoard b2){
		this.b1 = b1;
		this.b2 = b2;
		
		initUI();
	}
	
	/**
	 * Initializes the User Interface
	 */
	private void initUI(){
		
		this.add(new Visuals(b1, b2));
		
		setSize((RECT_W + 2) * 22, (RECT_W + 3) * 11);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
}
