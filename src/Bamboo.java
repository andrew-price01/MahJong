import java.awt.*;

public class Bamboo {
	private int x;
	private int y;
	private Color color;
	
	public Bamboo(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, 10, 5);
		
		g.fillOval(x, y + 17, 10, 5);
		g.fillRect(x + 4, y + 2, 4, 21);
		
		g.setColor(Color.WHITE);
		g.drawLine(x + 5, y + 3, x + 6, y + 18);
		
		g.setColor(color);
		g.fillOval(x, y + 8, 10, 5);
	}
}