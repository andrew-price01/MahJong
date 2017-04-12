import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JPanel;

public class MahJongModel {
	
	Tile tile = new Tile();
	
	public Tile positionTile(Tile t, int x, int y, int z) {
		t.x = x;
		t.y = y;
		t.z = z;
		t.setLocation(x,y);
		return t;
	}

	boolean isTileOpen(Tile t) {
		return false;
	}
	
}