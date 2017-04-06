import java.awt.*;
import javax.swing.*;

public class Pancake extends Circle {
	
	public Pancake(int x, int y, Color color) {
		super(x,y,color);
	}
	
	public void draw(Graphics g) {
		
		Graphics2D g2 = (Graphics2D)g;
		
		g.setColor(Tile.Green);
		g.fillOval(35, 15, 60, 60);
		super.draw(g);
		g.setColor(Color.WHITE);
		g.drawOval(58, 40, 14, 14);
		
		g.setColor(Color.BLACK);
		g.drawOval(35, 15, 60, 60);
		
		g2.setColor(Color.WHITE);
		
		g2.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0F, new float[] {1.0f, 8.0f}, 12.0f));
		g2.drawOval(40, 20, 50, 50);
	}
}