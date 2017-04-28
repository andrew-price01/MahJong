import java.awt.*;
import javax.swing.*;
@SuppressWarnings("serial")
public class BambooTile extends RankTile{
	
	final Bamboo[] bamboo = new Bamboo[9];
	
	public BambooTile(int rank) {
		super(rank);
		setToolTipText(toString());
		
		switch (rank) {
		case 2:
			bamboo[0] = new Bamboo(50, 17, Tile.Navy);
			bamboo[1] = new Bamboo(50, 39, Tile.Green);
			break;
		case 3:
			bamboo[0] = new Bamboo(50, 17, Tile.Navy);
			bamboo[1] = new Bamboo(38, 39, Tile.Green);
			bamboo[2] = new Bamboo(60, 39, Tile.Green);
			break;
		case 4:
			bamboo[0] = new Bamboo(38, 17, Tile.Navy);
			bamboo[1] = new Bamboo(60, 17, Tile.Green);
			bamboo[2] = new Bamboo(38, 39, Tile.Green);
			bamboo[3] = new Bamboo(60, 39, Tile.Navy);
			break;
		case 5:
			bamboo[0] = new Bamboo(30, 17, Tile.Green);
			bamboo[1] = new Bamboo(66, 17, Tile.Navy);
			bamboo[2] = new Bamboo(30, 40, Tile.Navy);
			bamboo[3] = new Bamboo(66, 40, Tile.Green);
			bamboo[4] = new Bamboo(48, 29, Tile.Crimson);
			break;
		case 6: 
			bamboo[0] = new Bamboo(32, 17, Tile.Green);
			bamboo[1] = new Bamboo(50, 17, Tile.Green);
			bamboo[2] = new Bamboo(68, 17, Tile.Green);
			bamboo[3] = new Bamboo(32, 40, Tile.Navy);
			bamboo[4] = new Bamboo(50, 40, Tile.Navy);
			bamboo[5] = new Bamboo(68, 40, Tile.Navy);
			break;
		case 7:
			bamboo[0] = new Bamboo(30, 24, Tile.Green);
			bamboo[1] = new Bamboo(48, 24, Tile.Navy);
			bamboo[2] = new Bamboo(66, 24, Tile.Green);
			bamboo[3] = new Bamboo(30, 47, Tile.Green);
			bamboo[4] = new Bamboo(48, 47, Tile.Navy);
			bamboo[5] = new Bamboo(66, 47, Tile.Green);
			bamboo[6] = new Bamboo(48, 2, Tile.Crimson);
			break;
		case 8:
			bamboo[0] = new Bamboo(30, 2, Tile.Green);
			bamboo[1] = new Bamboo(48, 2, Tile.Green);
			bamboo[2] = new Bamboo(66, 2, Tile.Green);
			bamboo[3] = new Bamboo(30, 48, Tile.Navy);
			bamboo[4] = new Bamboo(48, 48, Tile.Navy);
			bamboo[5] = new Bamboo(66, 48, Tile.Navy);
			bamboo[6] = new Bamboo(37, 26, Tile.Crimson);
			bamboo[7] = new Bamboo(59, 26, Tile.Crimson);
			break;
		case 9:
			bamboo[0] = new Bamboo(30, 2, Tile.Crimson);
			bamboo[1] = new Bamboo(48, 2, Tile.Navy);
			bamboo[2] = new Bamboo(66, 2, Tile.Green);
			bamboo[3] = new Bamboo(30, 25, Tile.Crimson);
			bamboo[4] = new Bamboo(48, 25, Tile.Navy);
			bamboo[5] = new Bamboo(66, 25, Tile.Green);
			bamboo[6] = new Bamboo(30, 48, Tile.Crimson);
			bamboo[7] = new Bamboo(48, 48, Tile.Navy);
			bamboo[8] = new Bamboo(66, 48, Tile.Green);
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