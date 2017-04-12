import java.util.*;
import java.awt.*;

public class Row extends ArrayList<Tile> {
	
	ArrayList<Tile> deck;
	private int x = 0;
	private int y = 0;
	Tile tile = new Tile();
	
	public Row(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	void positionTile(Tile t) {
		t.setLocation(t.x, t.y);
	}
	
	public void addTiles(ArrayList<Tile> deck, int count) {
		for (int i = 0; i < count; i++) {
			Tile t = deck.remove(deck.size() - 1);
			t.x = x;
			t.y = y;
			this.add(t);
			x += 70;
		}
	}
}
