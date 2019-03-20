import java.awt.Color;
import java.awt.Graphics;

public class Disk {

	// Disk fields (characteristics)
	int x, y;
	int width;
	Color color;

	// Disk constructor
	public Disk(int theWidth, Color theColor) {

		this.width = theWidth;
		this.color = theColor;
	}

	// Disk behavior methods
	public void setX(int theNewX) {
		this.x = theNewX;
	}

	public void setY(int theNewY) {
		this.y = theNewY;
	}

	public int getWidth() {
		return width;
	}

	public void move(int theNewX, int theNewY) {
		x = theNewX;
		y = theNewY;
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x - width / 2, y, width, 10);
	}
}
