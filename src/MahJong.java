import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.*;

public class MahJong extends JFrame {

	public MahJong() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new MahJongBoard());
		setSize(500,500);
		setVisible(true);
	}
	
	public class MahJongBoard extends JPanel {
		
		public MahJongBoard() {
			setLayout(null);
			
			
//			A test to display tiles on top of each other
//
//			Tile t;
//			t = new SeasonTile("Spring");
//			t.setLocation(200,100);
//			add(t);
//			
//			t = new SeasonTile("Summer");
//			t.setLocation(179,121);
//			add(t);
//			
//			t = new SeasonTile("Winter");
//			t.setLocation(158,142);
//			add(t);
		}
		
		public void RandomTileDeck(int gameNumber) {
			
			Random rand = new Random(gameNumber);
			
			ArrayList<Tile> deck = new ArrayList<Tile>();
			
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
			
			Collections.shuffle(deck,rand);
		}
	}
	
	public static void main (String[] args) {
		new MahJong();
	}
}