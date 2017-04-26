import java.awt.*;
import javax.swing.*;

public class CircleTile extends RankTile {
	
	final Circle circles[] = new Circle[9];
	
	public CircleTile(int rank) {
		super(rank);
		setToolTipText(toString());
		
		switch (rank) {
			case 1:
				circles[0] = new Pancake(50, 30, Color.RED);
				break;
			case 2:
				circles[0] = new Circle(50, 15, Tile.Green);
				circles[1] = new Circle(50, 45, Color.RED);
				break;
			case 3:
				circles[0] = new Circle(25, 2, Color.BLUE);
				circles[1] = new Circle(50, 30, Color.RED);
				circles[2] = new Circle(75, 55, Tile.Green);
				break;
			case 4:
				circles[0] = new Circle(35, 15, Color.BLUE);
				circles[1] = new Circle(65, 15, Tile.Green);
				circles[2] = new Circle(35, 42,Tile.Green);
				circles[3] = new Circle(65, 42, Color.BLUE);
				break;
			case 5:
				circles[0] = new Circle(50, 30, Color.RED);
				circles[1] = new Circle(25, 2, Color.BLUE);
				circles[2] = new Circle(75, 55, Color.BLUE);
				circles[3] = new Circle(75, 2, Tile.Green);
				circles[4] = new Circle(25, 55, Tile.Green);
				break;
			case 6:
				circles[0] = new Circle(35, 5, Tile.Green);
				circles[1] = new Circle(65, 5, Tile.Green);
				circles[2] = new Circle(35, 29, Color.RED);
				circles[3] = new Circle(65, 29, Color.RED);
				circles[4] = new Circle(35, 52, Color.RED);
				circles[5] = new Circle(65, 52, Color.RED);
				break;
			case 7:
				circles[0] = new Circle(30, 5, Tile.Green);
				circles[1] = new Circle(50, 13, Tile.Green);
				circles[2] = new Circle(70, 21, Tile.Green);
				circles[3] = new Circle(35, 36, Color.RED);
				circles[4] = new Circle(35, 53, Color.RED);
				circles[5] = new Circle(65, 36, Color.RED);
				circles[6] = new Circle(65, 53, Color.RED);
				break;
			case 8:
				circles[0] = new Circle(35, 2, Color.BLUE);
				circles[1] = new Circle(35, 19, Color.BLUE);
				circles[2] = new Circle(35, 37, Color.BLUE);
				circles[3] = new Circle(35, 55, Color.BLUE);
				circles[4] = new Circle(65, 2, Color.BLUE);
				circles[5] = new Circle(65, 19, Color.BLUE);
				circles[6] = new Circle(65, 37, Color.BLUE);
				circles[7] = new Circle(65, 55, Color.BLUE);
				break;
			case 9:
				circles[0] = new Circle(25, 5, Tile.Green);
				circles[1] = new Circle(48, 5, Tile.Green);
				circles[2] = new Circle(70, 5, Tile.Green);
				circles[3] = new Circle(25, 27, Color.RED);
				circles[4] = new Circle(48, 27, Color.RED);
				circles[5] = new Circle(70, 27, Color.RED);
				circles[6] = new Circle(25, 50, Color.BLUE);
				circles[7] = new Circle(48, 50, Color.BLUE);
				circles[8] = new Circle(70, 50, Color.BLUE);
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