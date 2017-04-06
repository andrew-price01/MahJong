import java.awt.*;
import javax.swing.*;

public class BambooTile extends RankTile{
	
	final Bamboo[] bamboo = new Bamboo[9];
	
	public BambooTile(int rank) {
		super(rank);
		setToolTipText(toString());
		
		switch (rank) {
		case 2:
			bamboo[0] = new Bamboo(58, 23, Tile.Navy);
			bamboo[1] = new Bamboo(58, 46, Tile.Green);
			break;
		case 3:
			bamboo[0] = new Bamboo(58, 23, Tile.Navy);
			bamboo[1] = new Bamboo(46, 46, Tile.Green);
			bamboo[2] = new Bamboo(70, 46, Tile.Green);
			break;
		case 4:
			bamboo[0] = new Bamboo(46, 23, Tile.Navy);
			bamboo[1] = new Bamboo(70, 23, Tile.Green);
			bamboo[2] = new Bamboo(46, 46, Tile.Green);
			bamboo[3] = new Bamboo(70, 46, Tile.Navy);
			break;
		case 5:
			bamboo[0] = new Bamboo(40, 23, Tile.Green);
			bamboo[1] = new Bamboo(76, 23, Tile.Navy);
			bamboo[2] = new Bamboo(40, 46, Tile.Navy);
			bamboo[3] = new Bamboo(76, 46, Tile.Green);
			bamboo[4] = new Bamboo(58, 35, Tile.Crimson);
			break;
		case 6: 
			bamboo[0] = new Bamboo(40, 23, Tile.Green);
			bamboo[1] = new Bamboo(58, 23, Tile.Green);
			bamboo[2] = new Bamboo(76, 23, Tile.Green);
			bamboo[3] = new Bamboo(40, 46, Tile.Navy);
			bamboo[4] = new Bamboo(58, 46, Tile.Navy);
			bamboo[5] = new Bamboo(76, 46, Tile.Navy);
			break;
		case 7:
			bamboo[0] = new Bamboo(40, 34, Tile.Green);
			bamboo[1] = new Bamboo(58, 34, Tile.Navy);
			bamboo[2] = new Bamboo(76, 34, Tile.Green);
			bamboo[3] = new Bamboo(40, 57, Tile.Green);
			bamboo[4] = new Bamboo(58, 57, Tile.Navy);
			bamboo[5] = new Bamboo(76, 57, Tile.Green);
			bamboo[6] = new Bamboo(58, 11, Tile.Crimson);
			break;
		case 8:
			bamboo[0] = new Bamboo(40, 11, Tile.Green);
			bamboo[1] = new Bamboo(58, 11, Tile.Green);
			bamboo[2] = new Bamboo(76, 11, Tile.Green);
			bamboo[3] = new Bamboo(40, 57, Tile.Navy);
			bamboo[4] = new Bamboo(58, 57, Tile.Navy);
			bamboo[5] = new Bamboo(76, 57, Tile.Navy);
			bamboo[6] = new Bamboo(47, 35, Tile.Crimson);
			bamboo[7] = new Bamboo(69, 35, Tile.Crimson);
			break;
		case 9:
			bamboo[0] = new Bamboo(40, 11, Tile.Crimson);
			bamboo[1] = new Bamboo(58, 11, Tile.Navy);
			bamboo[2] = new Bamboo(76, 11, Tile.Green);
			bamboo[3] = new Bamboo(40, 34, Tile.Crimson);
			bamboo[4] = new Bamboo(58, 34, Tile.Navy);
			bamboo[5] = new Bamboo(76, 34, Tile.Green);
			bamboo[6] = new Bamboo(40, 57, Tile.Crimson);
			bamboo[7] = new Bamboo(58, 57, Tile.Navy);
			bamboo[8] = new Bamboo(76, 57, Tile.Green);
			break;
		}
	}
	
	public String toString() {
		return "Bamboo " + rank;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		for (Bamboo b : bamboo)
			if (b != null)
				b.draw(g);
	}
	
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Bamboo Tiles");

		frame.add(new BambooTile(2));
		frame.add(new BambooTile(3));
		frame.add(new BambooTile(4));
		frame.add(new BambooTile(5));
		frame.add(new BambooTile(6));
		frame.add(new BambooTile(7));
		frame.add(new BambooTile(8));
		frame.add(new BambooTile(9));

		frame.pack();
		frame.setVisible(true);
	}
}