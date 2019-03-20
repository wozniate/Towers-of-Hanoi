
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public abstract class MyWorld extends JFrame implements ActionListener,
		MouseListener, MouseMotionListener, KeyListener, Runnable {
	protected DrawPanel window;

	protected Container world;

	protected Thread timer;

	protected boolean showGrid;

	protected final String NORTH = BorderLayout.NORTH;
	protected final String WEST = BorderLayout.WEST;
	protected final String CENTER = BorderLayout.CENTER;
	protected final String EAST = BorderLayout.EAST;
	protected final String SOUTH = BorderLayout.SOUTH;

	protected final Color RED = Color.red;
	protected final Color PINK = Color.pink;
	protected final Color ORANGE = Color.orange;
	protected final Color YELLOW = Color.yellow;
	protected final Color GREEN = Color.green;
	protected final Color BLUE = Color.blue;
	protected final Color CYAN = Color.cyan;
	protected final Color INDIGO = new Color(75, 0, 130);
	protected final Color MAGENTA = Color.magenta;
	protected final Color BLACK = Color.black;
	protected final Color GRAY = Color.gray;
	protected final Color LIGHTGRAY = Color.lightGray;
	protected final Color DARKGRAY = Color.darkGray;
	protected final Color WHITE = Color.white;

	public static int WIDTH;
	public static int HEIGHT;

	public MyWorld() {

		super();

		WIDTH = 500;
		HEIGHT = 520;

		showGrid = false;

		init();

		showChanges();
	}

	public MyWorld(int width, int height) {
		super();

		WIDTH = width;
		HEIGHT = height;

		showGrid = false;

		init();

		showChanges();
	}

	public MyWorld(boolean showGrid) {
		super();

		WIDTH = 500;
		HEIGHT = 520;

		this.showGrid = showGrid;

		init();

		showChanges();
	}

	public void init() {
		window = new DrawPanel();
		// timer = new Thread(this);

		world = this.getContentPane();
		world.setLayout(new BorderLayout());

		world.add(window, CENTER);

		window.addMouseListener(this);
		window.addMouseMotionListener(this);
		window.addKeyListener(this);
	}

	protected void showChanges() {
		this.setSize(WIDTH, HEIGHT);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	protected void start() {
		if (timer == null) {
			timer = new Thread(this);
			timer.start();
		}
	}
	
	public boolean started(){
		return timer != null;
	}

	protected void stop() {
		timer = null;
	}

	protected void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

	protected String getInput(String message) {
		return JOptionPane.showInputDialog(this, message);
	}

	public void showPosition(MouseEvent mouse) {
		String title = "X = " + mouse.getX() + " , Y = " + mouse.getY();
		this.setTitle(title);
	}

	class DrawPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			super.setBackground(Color.white);
			if (showGrid)
				showGrid(g,25);
			draw(g);
			this.requestFocus();
		}

		public Dimension getPreferredSize() {
			return new Dimension(500, 500);
		}

	}

	public void showGrid(Graphics g, int diff) {
		g.setColor(GRAY);
		for (int x = diff; x < WIDTH; x += diff) {
			g.drawLine(x, 0, x, HEIGHT);
			g.drawLine(0, x, WIDTH, x);

		}
	}

	public void draw() {
		Graphics g = window.getGraphics();

		draw(g);
	}

	// subclasses of WozWorld must have a draw method
	public abstract void draw(Graphics g);

	// for each overridden method: do nothing
	// leave implementation up to subclasses
	// but do not force subclasses to implement
	public void actionPerformed(ActionEvent ae) {
	}

	public void mouseClicked(MouseEvent me) {
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}

	public void mouseDragged(MouseEvent arg0) {
	}

	public void mouseMoved(MouseEvent arg0) {
	}

	public void keyPressed(KeyEvent arg0) {
	}

	public void keyReleased(KeyEvent arg0) {
	}

	public void keyTyped(KeyEvent arg0) {
	}

	public void run() {
	}
}