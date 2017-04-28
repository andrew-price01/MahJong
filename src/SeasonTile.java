import java.awt.*;
import javax.swing.*;
@SuppressWarnings("serial")
public class SeasonTile extends PictureTile {
	
	private ImageIcon springIcon = new ImageIcon(getClass().getResource("Spring.png"));
	private Image spring = springIcon.getImage();
	//private Image spring = Toolkit.getDefaultToolkit().getImage("images/Spring.png");
	
	private ImageIcon summerIcon = new ImageIcon(getClass().getResource("Summer.png"));
	private Image summer = summerIcon.getImage();
	//private Image summer = Toolkit.getDefaultToolkit().getImage("images/Summer.png");
	
	private ImageIcon fallIcon = new ImageIcon(getClass().getResource("Fall.png"));
	private Image fall = fallIcon.getImage();
	//private Image fall = Toolkit.getDefaultToolkit().getImage("images/Fall.png");
	
	private ImageIcon winterIcon = new ImageIcon(getClass().getResource("Winter.png"));
	private Image winter = winterIcon.getImage();
	//private Image winter = Toolkit.getDefaultToolkit().getImage("images/Winter.png");
	
	public SeasonTile(String name) {
		super(name);
		setToolTipText(toString());
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		switch (name) {
			case "Spring":
				g.drawImage(spring, 25, 15, this);
				break;
			case "Summer":
				g.drawImage(summer, 25, 5, this);
				break;
			case "Fall":
				g.drawImage(fall, 25, 5, this);
				break;
			case "Winter":
				g.drawImage(winter, 25, 5, this);
				break;
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Season Tiles");

		frame.add(new SeasonTile("Spring"));
		frame.add(new SeasonTile("Summer"));
		frame.add(new SeasonTile("Fall"));
		frame.add(new SeasonTile("Winter"));

		frame.pack();
		frame.setVisible(true);
	}
}