import java.awt.*;
import javax.swing.*;

public class WhiteDragonTile extends Tile {
	
	public WhiteDragonTile() {
		setToolTipText(toString());
	}
	public String toString() {
		return "White Dragon";
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		g.setColor(Color.BLACK);
		g.drawRect(25, 5, 60, 60);
		g.drawRect(33, 13, 45, 45);
		
		g2.setStroke(new BasicStroke(6.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL, 1, new float[] {3, 0}, 10f));
		g2.setColor(Color.WHITE);
		g2.drawRect(30, 10, 52, 52);
		
		g2.setStroke(new BasicStroke(6.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL, 1, new float[] {6.2f, 15.3f}, 2.8f));
		g2.setColor(Color.BLUE);
		g2.drawRect(30, 10, 52, 52);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("White Dragon Tile");

		frame.add(new WhiteDragonTile());

		frame.pack();
		frame.setVisible(true);
	}
}