import java.awt.*;
import javax.swing.*;

public class FlowerTile extends PictureTile {
	
	private Image chrysanthemum = Toolkit.getDefaultToolkit().getImage("images/Chrysanthemum.png");
	private Image orchid = Toolkit.getDefaultToolkit().getImage("images/Orchid.png");
	private Image plum = Toolkit.getDefaultToolkit().getImage("images/Plum.png");
	private Image sparrow = Toolkit.getDefaultToolkit().getImage("images/Sparrow.png");
	
	public FlowerTile(String name) {
		super(name);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		switch (name) {
			case "Chrysanthemum":
				g.drawImage(chrysanthemum, 25, 10, this);
				break;
			case "Orchid":
				g.drawImage(orchid, 25, 5, this);
				break;
			case "Plum":
				g.drawImage(plum, 25, 5, this);
				break;
			case "Sparrow":
				g.drawImage(sparrow, 25, 10, this);
				break;
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Flower Tiles");

		frame.add(new FlowerTile("Chrysanthemum"));
		frame.add(new FlowerTile("Orchid"));
		frame.add(new FlowerTile("Plum"));
		frame.add(new FlowerTile("Sparrow"));

		frame.pack();
		frame.setVisible(true);
	}
}