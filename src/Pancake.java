import java.awt.*;

public class Pancake extends Circle {
	
	public Pancake(int x, int y, Color color) {
		super(x,y,color);
	}
	
	public void draw(Graphics g) {
		
		Graphics2D g2 = (Graphics2D)g;
		
		g.setColor(Tile.Green);
		g.fillOval(25, 5, 60, 60);
		super.draw(g);
		g.setColor(Color.WHITE);
		g.drawOval(50, 30, 14, 14);
		
		g.setColor(Color.BLACK);
		g.drawOval(25, 5, 60, 60);
		
		g2.setColor(Color.WHITE);
		
		g2.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0F, new float[] {1.0f, 8.0f}, 12.0f));
		g2.drawOval(30, 10, 50, 50);
	}
}