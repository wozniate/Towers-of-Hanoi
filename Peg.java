import java.awt.Color;
import java.awt.Graphics;

public class Peg {

	// Peg fields (characteristics)
	private Disk[] disks;// the disks on this peg
	private int topDisk;// the index of the top disk in the array
	private int x;// the position of this peg

	// Peg constructor
	public Peg(   ) {//missing parameter

		;//missing code
	}

	// Peg behavior methods
	public void draw(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(x, 150, 20, 100);
	}
}
