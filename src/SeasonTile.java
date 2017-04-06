import java.awt.*;
import javax.swing.*;

public class SeasonTile extends PictureTile {
	
	private Image spring = Toolkit.getDefaultToolkit().getImage("images/Spring.png");
	private Image summer = Toolkit.getDefaultToolkit().getImage("images/Summer.png");
	private Image fall = Toolkit.getDefaultToolkit().getImage("images/Fall.png");
	private Image winter = Toolkit.getDefaultToolkit().getImage("images/Winter.png");
	
	public SeasonTile(String name) {
		super(name);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		switch (name) {
			case "Spring":
				g.drawImage(spring, 35, 25, this);
				break;
			case "Summer":
				g.drawImage(summer, 35, 15, this);
				break;
			case "Fall":
				g.drawImage(fall, 35, 15, this);
				break;
			case "Winter":
				g.drawImage(winter, 35, 15, this);
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