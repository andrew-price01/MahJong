
public class MahJongModel {
	
	Tile tile = new Tile();
	
	void positionTile(Tile t, int x, int y, int z) {
		t.x = x;
		t.y = y;
		t.z = z;
	}

	boolean isTileOpen(Tile t) {
		return false;
	}
	
}