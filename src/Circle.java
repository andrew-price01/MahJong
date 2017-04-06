import java.awt.*;

public class Circle {
	
	private int x;
	private int y;
	private Color color;
	
	
	public Circle(int x, int y, Color color) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, 14, 14);
		g.setColor(Color.WHITE);
		g.drawLine(x + 5, y + 5, x + 9, y + 9);
		g.drawLine(x + 9, y + 5, x + 5, y + 9);
	}

}