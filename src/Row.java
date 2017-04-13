import java.util.*;
import java.awt.*;

public class Row extends ArrayList<Tile> {
	
	ArrayList<Tile> deck;
	public int x;
	public int y;
	
	public Row(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void addTiles(ArrayList<Tile> deck, int count) {
		for (int i = 0; i < count; i++) {
			Tile t = deck.remove(deck.size() - 1);
			this.add(t);
		}
	}
}
