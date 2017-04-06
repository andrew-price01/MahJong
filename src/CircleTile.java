import java.awt.*;
import javax.swing.*;

public class CircleTile extends RankTile {
	
	final Circle circles[] = new Circle[9];
	
	public CircleTile(int rank) {
		super(rank);
		setToolTipText(toString());
		
		switch (rank) {
			case 1:
				circles[0] = new Pancake(58, 40, Color.RED);
				break;
			case 2:
				circles[0] = new Circle(60, 27, Tile.Green);
				circles[1] = new Circle(60, 54, Color.RED);
				break;
			case 3:
				circles[0] = new Circle(38, 15, Color.BLUE);
				circles[1] = new Circle(58, 40, Color.RED);
				circles[2] = new Circle(83, 62, Tile.Green);
				break;
			case 4:
				circles[0] = new Circle(45, 27, Color.BLUE);
				circles[1] = new Circle(75, 27, Tile.Green);
				circles[2] = new Circle(45, 54,Tile.Green);
				circles[3] = new Circle(75, 54, Color.BLUE);
				break;
			case 5:
				circles[0] = new Circle(58, 40, Color.RED);
				circles[1] = new Circle(38, 15, Color.BLUE);
				circles[2] = new Circle(80, 62, Color.BLUE);
				circles[3] = new Circle(80, 15, Tile.Green);
				circles[4] = new Circle(38, 62, Tile.Green);
				break;
			case 6:
				circles[0] = new Circle(45, 15, Tile.Green);
				circles[1] = new Circle(75, 15, Tile.Green);
				circles[2] = new Circle(45, 39, Color.RED);
				circles[3] = new Circle(75, 39, Color.RED);
				circles[4] = new Circle(45, 62, Color.RED);
				circles[5] = new Circle(75, 62, Color.RED);
				break;
			case 7:
				circles[0] = new Circle(40, 15, Tile.Green);
				circles[1] = new Circle(60, 23, Tile.Green);
				circles[2] = new Circle(80, 31, Tile.Green);
				circles[3] = new Circle(45, 46, Color.RED);
				circles[4] = new Circle(45, 63, Color.RED);
				circles[5] = new Circle(75, 46, Color.RED);
				circles[6] = new Circle(75, 63, Color.RED);
				break;
			case 8:
				circles[0] = new Circle(45, 12, Color.BLUE);
				circles[1] = new Circle(45, 29, Color.BLUE);
				circles[2] = new Circle(45, 47, Color.BLUE);
				circles[3] = new Circle(45, 65, Color.BLUE);
				circles[4] = new Circle(75, 12, Color.BLUE);
				circles[5] = new Circle(75, 29, Color.BLUE);
				circles[6] = new Circle(75, 47, Color.BLUE);
				circles[7] = new Circle(75, 65, Color.BLUE);
				break;
			case 9:
				circles[0] = new Circle(40, 15, Tile.Green);
				circles[1] = new Circle(58, 15, Tile.Green);
				circles[2] = new Circle(80, 15, Tile.Green);
				circles[3] = new Circle(40, 40, Color.RED);
				circles[4] = new Circle(58, 40, Color.RED);
				circles[5] = new Circle(80, 40, Color.RED);
				circles[6] = new Circle(40, 62, Color.BLUE);
				circles[7] = new Circle(58, 62, Color.BLUE);
				circles[8] = new Circle(80, 62, Color.BLUE);
				break;
		}
		
	}
	
	
	public String toString() {
		return "Circle " + rank;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		for (Circle c : circles)
			if (c != null)
				c.draw(g);
	}
	
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Circle Tiles");

		frame.add(new CircleTile(1));
		frame.add(new CircleTile(2));
		frame.add(new CircleTile(3));
		frame.add(new CircleTile(4));
		frame.add(new CircleTile(5));
		frame.add(new CircleTile(6));
		frame.add(new CircleTile(7));
		frame.add(new CircleTile(8));
		frame.add(new CircleTile(9));

		frame.pack();
		frame.setVisible(true);
	}
}