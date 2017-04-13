import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.*;

public class MahJong extends JFrame {

	MahJongModel model = new MahJongModel();
	
	private Image dragon_bg = Toolkit.getDefaultToolkit().getImage("images/dragon_bg.png");

	public ArrayList<Tile> deck = new ArrayList<Tile>();

	Random rand = new Random();

	public MahJong() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("MahJong Game");
		add(new MahJongBoard());
		setSize(1200, 650);
		setVisible(true);
	}

	public class MahJongBoard extends JPanel implements MouseListener {

		public MahJongBoard() {
			setLayout(null);
			
			tileDeck();
			Collections.shuffle(deck, rand);
			dealTiles();
			
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.setColor(Tile.Gold);
			g.fillRect(0, 0, 1200, 650);
			g.drawImage(dragon_bg, (this.getWidth() - dragon_bg.getWidth(this)) / 2, (this.getHeight() - dragon_bg.getHeight(this)) / 2, this);

		}

		public void dealTiles() {		
			
	//----------------------Layer 4------------------------//
			Tile top = deck.remove(deck.size() - 1);
			model.positionTile(top, 7, 4, 4);
			top.setLocation((top.x * 70 + top.z * 20) - 40, (top.y * 70 - top.z * 20) - 30);
			add(top);
			
	//----------------------Layer 3------------------------//
			Row row1 = new Row(6,4);
			row1.addTiles(deck, 2);
			for (Tile t: row1) {
				model.positionTile(t, row1.x, row1.y, 3);
				t.setLocation((row1.x * 70 + t.z * 20), (row1.y * 70 - t.z * 20));
				add(t);
				row1.x += 1;
			}
			
			Row row2 = new Row(6,3);
			row2.addTiles(deck, 2);
			for (Tile t: row2) {
				model.positionTile(t, row2.x, row2.y, 3);
				t.setLocation((row2.x * 70 + t.z * 20), (row2.y * 70 - t.z * 20));
				add(t);
				row2.x += 1;
			}
			
	//----------------------Layer 2------------------------//
			Row row3 = new Row(5,5);
			row3.addTiles(deck, 4);
			for (Tile t: row3) {
				model.positionTile(t, row3.x, row3.y, 2);
				t.setLocation((row3.x * 70 + t.z * 20), (row3.y * 70 - t.z * 20));
				add(t);
				row3.x += 1;
			}
			
			Row row4 = new Row(5,4);
			row4.addTiles(deck, 4);
			for (Tile t: row4) {
				model.positionTile(t, row4.x, row4.y, 2);
				t.setLocation((row4.x * 70 + t.z * 20), (row4.y * 70 - t.z * 20));
				add(t);
				row4.x += 1;
			}
			
			Row row5 = new Row(5,3);
			row5.addTiles(deck, 4);
			for (Tile t: row5) {
				model.positionTile(t, row5.x, row5.y, 2);
				t.setLocation((row5.x * 70 + t.z * 20), (row5.y * 70 - t.z * 20));
				add(t);
				row5.x += 1;
			}
			
			Row row6 = new Row(5,2);
			row6.addTiles(deck, 4);
			for (Tile t: row6) {
				model.positionTile(t, row6.x, row6.y, 2);
				t.setLocation((row6.x * 70 + t.z * 20), (row6.y * 70 - t.z * 20));
				add(t);
				row6.x += 1;
			}
			
	//----------------------Special Cases------------------------//	
			Tile spec = deck.remove(deck.size() - 1);
			model.positionTile(spec, 0, 4, 1);
			spec.setLocation((spec.x * 70 + spec.z * 20) - 20, (spec.y * 70 - spec.z * 20) - 20);
			add(spec);
			
			
	//----------------------Layer 1------------------------//
			Row row7 = new Row(4,6);
			row7.addTiles(deck, 6);
			for (Tile t: row7) {
				model.positionTile(t, row7.x, row7.y, 1);
				t.setLocation((row7.x * 70 + t.z * 20), (row7.y * 70 - t.z * 20));
				add(t);
				row7.x += 1;
			}
			
			Row row8 = new Row(4,5);
			row8.addTiles(deck, 6);
			for (Tile t: row8) {
				model.positionTile(t, row8.x, row8.y, 1);
				t.setLocation((row8.x * 70 + t.z * 20), (row8.y * 70 - t.z * 20));
				add(t);
				row8.x += 1;
			}
			
			Row row9 = new Row(4,4);
			row9.addTiles(deck, 6);
			for (Tile t: row9) {
				model.positionTile(t, row9.x, row9.y, 1);
				t.setLocation((row9.x * 70 + t.z * 20), (row9.y * 70 - t.z * 20));
				add(t);
				row9.x += 1;
			}
			
			Row row10 = new Row(4,3);
			row10.addTiles(deck, 6);
			for (Tile t: row10) {
				model.positionTile(t, row10.x, row10.y, 1);
				t.setLocation((row10.x * 70 + t.z * 20), (row10.y * 70 - t.z * 20));
				add(t);
				row10.x += 1;
			}
			
			Row row11 = new Row(4,2);
			row11.addTiles(deck, 6);
			for (Tile t: row11) {
				model.positionTile(t, row11.x, row11.y, 1);
				t.setLocation((row11.x * 70 + t.z * 20), (row11.y * 70 - t.z * 20));
				add(t);
				row11.x += 1;
			}
			
			Row row12 = new Row(4,1);
			row12.addTiles(deck, 6);
			for (Tile t: row12) {
				model.positionTile(t, row12.x, row12.y, 1);
				t.setLocation((row12.x * 70 + t.z * 20), (row12.y * 70 - t.z * 20));
				add(t);
				row12.x += 1;
			}
			
			
	//----------------------Layer 0------------------------//
			Layer layer0 = new Layer(deck);
			for (Row r : layer0) {
				for (Tile t: r) {
					add(t);
				}
			}
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {
			Tile t = (Tile)e.getSource();
			
			if (e.getButton() == MouseEvent.BUTTON3) {
				remove(t);
			}

		}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}

	}

	public void tileDeck() {

		for (int i = 0; i < 4; i++) {
			deck.add(new CharacterTile('1'));
			deck.add(new CharacterTile('2'));
			deck.add(new CharacterTile('3'));
			deck.add(new CharacterTile('4'));
			deck.add(new CharacterTile('5'));
			deck.add(new CharacterTile('6'));
			deck.add(new CharacterTile('7'));
			deck.add(new CharacterTile('8'));
			deck.add(new CharacterTile('9'));
			deck.add(new CharacterTile('N'));
			deck.add(new CharacterTile('E'));
			deck.add(new CharacterTile('W'));
			deck.add(new CharacterTile('S'));
			deck.add(new CharacterTile('C'));
			deck.add(new CharacterTile('F'));

			deck.add(new CircleTile(1));
			deck.add(new CircleTile(2));
			deck.add(new CircleTile(3));
			deck.add(new CircleTile(4));
			deck.add(new CircleTile(5));
			deck.add(new CircleTile(6));
			deck.add(new CircleTile(7));
			deck.add(new CircleTile(8));
			deck.add(new CircleTile(9));

			deck.add(new BambooTile(2));
			deck.add(new BambooTile(3));
			deck.add(new BambooTile(4));
			deck.add(new BambooTile(5));
			deck.add(new BambooTile(6));
			deck.add(new BambooTile(7));
			deck.add(new BambooTile(8));
			deck.add(new BambooTile(9));
			deck.add(new Bamboo1Tile());
			deck.add(new WhiteDragonTile());
		}
		deck.add(new FlowerTile("Chrysanthemum"));
		deck.add(new FlowerTile("Orchid"));
		deck.add(new FlowerTile("Plum"));
		deck.add(new FlowerTile("Sparrow"));
		deck.add(new SeasonTile("Spring"));
		deck.add(new SeasonTile("Summer"));
		deck.add(new SeasonTile("Fall"));
		deck.add(new SeasonTile("Winter"));
	}

	public static void main(String[] args) {
		new MahJong();
	}
}