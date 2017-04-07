import java.util.*;
import java.awt.*;

public class Row extends ArrayList<Tile> {
	
	private Tile t;
	private int x;
	private int y;
	
	public Row(Tile t, int x, int y) {
		this.t = t;
		this.x = x;
		this.y = y;
	}
	
	void positionTile() {
		
	}
	
	public boolean isTileOpen(Tile t) {
		return true;
	}
	
	Tile getTile(int x, int y, int z) {
		return null;
	}
}
