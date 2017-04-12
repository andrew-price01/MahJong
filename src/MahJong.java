import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.*;

public class MahJong extends JFrame {

	public ArrayList<Tile> deck = new ArrayList<Tile>();
	ArrayList<ArrayList<Tile>> layer0 = new ArrayList();
	ArrayList<ArrayList<Tile>> layer1 = new ArrayList();
	ArrayList<ArrayList<Tile>> layer2 = new ArrayList();
	ArrayList<ArrayList<Tile>> layer3 = new ArrayList();
	ArrayList<ArrayList<Tile>> layer4 = new ArrayList();

	Random rand = new Random();

	public MahJong() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new MahJongBoard());
		setSize(1300, 1000);
		setVisible(true);
	}

	public class MahJongBoard extends JPanel {

		public MahJongBoard() {
			setLayout(null);
			tileDeck();
			Collections.shuffle(deck, rand);

			// Layer 4
			Row row20 = new Row(560, 280);
			row20.addTiles(deck, 1);
			for (Tile t: row20) {
				row20.positionTile(t);
				add(t);
			}
			
			// Layer 3
			Row row18 = new Row(510, 330);
			row18.addTiles(deck, 2);
			
			Row row19 = new Row(510, 260);
			row19.addTiles(deck, 2);
			
			layer3.add(row18);
			layer3.add(row19);
			
			for (ArrayList<Tile> l : layer3) {
				for (Tile t: l) {
					row19.positionTile(t);
					add(t);
				}
			}
			
			// Layer 2
			Row row17 = new Row(420, 210);
			row17.addTiles(deck, 4);
			
			Row row16 = new Row(420, 280);
			row16.addTiles(deck, 4);
			
			Row row15 = new Row(420, 350);
			row15.addTiles(deck, 4);
			
			Row row14 = new Row(420, 420);
			row14.addTiles(deck, 4);
			
			layer2.add(row14);
			layer2.add(row15);
			layer2.add(row16);
			layer2.add(row17);
			
			for (ArrayList<Tile> l : layer2) {
				for (Tile t: l) {
					row17.positionTile(t);
					add(t);
				}
			}
			
			// Layer 1
			Row row13 = new Row(330, 160);
			row13.addTiles(deck, 6);
			
			Row row12 = new Row(330, 230);
			row12.addTiles(deck, 6);
			
			Row row11 = new Row(330, 300);
			row11.addTiles(deck, 6);
			
			Row row10 = new Row(330, 370);
			row10.addTiles(deck, 6);
			
			Row row9 = new Row(330, 440);
			row9.addTiles(deck, 6);
			
			Row row8 = new Row(330, 510);
			row8.addTiles(deck, 6);
			
			layer1.add(row8);
			layer1.add(row9);
			layer1.add(row10);
			layer1.add(row11);
			layer1.add(row12);
			layer1.add(row13);
			
			for (ArrayList<Tile> l : layer1) {
				for (Tile t : l) {
					row13.positionTile(t);
					add(t);
				}
			}
			
			// Layer 0
			Row row7 = new Row(100, 600);
			row7.addTiles(deck, 12);

			Row row6 = new Row(240, 530);
			row6.addTiles(deck, 8);

			Row row5 = new Row(170, 460);
			row5.addTiles(deck, 10);

			Row row4 = new Row(100, 390);
			row4.addTiles(deck, 12);

			Row row3 = new Row(100, 320);
			row3.addTiles(deck, 12);

			Row row2 = new Row(170, 250);
			row2.addTiles(deck, 10);

			Row row1 = new Row(240, 180);
			row1.addTiles(deck, 8);

			Row row0 = new Row(100, 110);
			row0.addTiles(deck, 12);

			layer0.add(row7);
			layer0.add(row6);
			layer0.add(row5);
			layer0.add(row4);
			layer0.add(row3);
			layer0.add(row2);
			layer0.add(row1);
			layer0.add(row0);

			for (ArrayList<Tile> r : layer0) {
				for (Tile t : r) {
					if (t != null) {
						row0.positionTile(t);
						add(t);
					}
				}
			}

		}

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