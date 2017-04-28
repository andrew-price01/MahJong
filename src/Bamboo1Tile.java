import java.awt.*;
import javax.swing.*;
@SuppressWarnings("serial")
public class Bamboo1Tile extends PictureTile {

	private Image bamboo1;

	public Bamboo1Tile() {
		super("Bamboo 1");

		ImageIcon bambooIcon = new ImageIcon(getClass().getResource("Bamboo.png"));
		bamboo1 = bambooIcon.getImage();
//		bamboo1 = Toolkit.getDefaultToolkit().getImage("images/Bamboo.png");
	}

	public String toString() {
		return "Bamboo 1";
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bamboo1, 30, 5, this);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Bamboo 1 Tile");

		frame.add(new Bamboo1Tile());

		frame.pack();
		frame.setVisible(true);
	}
}