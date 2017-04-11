import java.util.*;
import java.awt.*;

public class Row extends ArrayList<Tile> {
	
	private int x;
	private int y;
	
	public Row(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	void addTile(Tile t) {
		add(t);
	}
}
