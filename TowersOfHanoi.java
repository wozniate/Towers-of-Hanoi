import java.awt.Graphics;
import java.awt.event.MouseEvent;


public class TowersOfHanoi extends MyWorld {

	//Game fields (characteristics)
	private Peg left, middle, right;
	private Disk selectedDisk;
	
	//Game constructor
	public TowersOfHanoi() {
		left = new Peg(70);//need to add 

		;//missing code for instantiating middle Peg

		;//missing code for instantiating right Peg
	}

	//Game behavior methods
	public void draw(Graphics g) {
		g.setColor(GRAY);
		g.fillRect(0, 250, 500, 250);
		
		if( left != null ) left.draw(g);
		if( middle != null ) middle.draw(g);
		if( right != null ) right.draw(g);	
	}

	public void mousePressed(MouseEvent mouse) {
		repaint();
	}
	public void mouseDragged(MouseEvent mouse) {
		repaint();
	}
	public void mouseReleased(MouseEvent mouse) {
		repaint();
	}
	public static void main(String[] args) {
		new TowersOfHanoi();
	}
}
