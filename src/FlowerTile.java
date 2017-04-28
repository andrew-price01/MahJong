import java.awt.*;
import javax.swing.*;
@SuppressWarnings("serial")
public class FlowerTile extends PictureTile {
	
	private ImageIcon chrysIcon = new ImageIcon(getClass().getResource("Chrysanthemum.png"));
	private Image chrysanthemum = chrysIcon.getImage();
	//private Image chrysanthemum = Toolkit.getDefaultToolkit().getImage("images/Chrysanthemum.png");
	
	private ImageIcon orchidIcon = new ImageIcon(getClass().getResource("Orchid.png"));
	private Image orchid = orchidIcon.getImage();
	//private Image orchid = Toolkit.getDefaultToolkit().getImage("images/Orchid.png");
	
	private ImageIcon plumIcon = new ImageIcon(getClass().getResource("Plum.png"));
	private Image plum = plumIcon.getImage();
	//private Image plum = Toolkit.getDefaultToolkit().getImage("images/Plum.png");
	
	private ImageIcon sparrowIcon = new ImageIcon(getClass().getResource("Sparrow.png"));
	private Image sparrow = sparrowIcon.getImage();
	//private Image sparrow = Toolkit.getDefaultToolkit().getImage("images/Sparrow.png");
	
	public FlowerTile(String name) {
		super(name);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		switch (name) {
			case "Chrysanthemum":
				g.drawImage(chrysanthemum, 25, 10, this);
				//chrysanthemum.paintIcon(this, g, 25, 10);
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