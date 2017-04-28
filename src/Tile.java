import java.awt.*;
import javax.swing.*;

public class Tile extends JPanel {

	public int x;
	public int y;
	public int z;
	
	public boolean tileRemoved = false;
	
	// Colors
	public final static Color DarkGreen = new Color(0, 100, 0);
	public final static Color LightGreen = new Color(0, 255, 0);
	public final static Color Green = new Color(0, 205, 0);
	public final static Color Wheat = new Color(255, 231, 186);
	public final static Color Navy = new Color(0,0,205);
	public final static Color Crimson = new Color(220, 20, 60);
	public final static Color Gold = new Color(255, 215, 0);

	// Polygon Points
	private static int[] xMidEdge = { 10, 10, 20, 20 };
	private static int[] yMidEdge = { 80, 10, 0, 70 };
	private static int[] xOutEdge = { 0, 0, 10, 10 };
	private static int[] yOutEdge = { 90, 20, 10, 80 };
	private static int[] xMidBottom = { 10, 20, 90, 80 };
	private static int[] yMidBottom = { 80, 70, 70, 80 };
	private static int[] xOutBottom = { 0, 10, 80, 70 };
	private static int[] yOutBottom = { 90, 80, 80, 90 };
	
	public Tile() {
		setSize(92, 92);
		setOpaque(false);
		setPreferredSize(new Dimension(110, 110));
	}
	
	public boolean matches(Tile other) {
		Tile otherObject = (Tile) other;

		return this.getClass() == otherObject.getClass();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		GradientPaint sideEdge = new GradientPaint(30, 10, DarkGreen, 20, 90, LightGreen);
		g2.setPaint(sideEdge);
		g.fillPolygon(xOutEdge, yOutEdge, 4);

		GradientPaint bottomEdge = new GradientPaint(100, 80, DarkGreen, 20, 90, LightGreen);
		g2.setPaint(bottomEdge);
		g.fillPolygon(xOutBottom, yOutBottom, 4);
		
		GradientPaint face = new GradientPaint(70, 10, Wheat, 10, 60, Color.WHITE);
		g2.setPaint(face);
		g.fillRect(20, 0, 70, 70);
		g.fillPolygon(xMidBottom, yMidBottom, 4);
		g.fillPolygon(xMidEdge, yMidEdge, 4);
		
		
		g2.setPaint(Color.BLACK);
		g.drawRect(20, 0, 70, 70);

		g.drawPolygon(xMidBottom, yMidBottom, 4);
		g.drawPolygon(xOutBottom, yOutBottom, 4);
		g.drawPolygon(xMidEdge, yMidEdge, 4);
		g.drawPolygon(xMidEdge, yMidEdge, 4);

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tile");

		frame.add(new Tile());

		frame.pack();
		frame.setVisible(true);
	}
}