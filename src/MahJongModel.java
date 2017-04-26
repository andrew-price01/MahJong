
public class MahJongModel {
	
	Tile tile = new Tile();
	
	void positionTile(Tile t, int x, int y, int z) {
		t.x = x;
		t.y = y;
		t.z = z;
	}
	
	Tile getTile(Tile t,int x, int y, int z) {
		if (x == t.x && y == t.y && z == t.z) {
			System.out.println(t + " " + t.x + " " + t.y + " " + t.z);
			return t;
		}
		return null;
	}
	
	boolean isTileOpen(Tile t) {
		if (getTile(t, t.x - 1, t.y, t.z) != null) {
			return true;
		}
		return false;
	}
	
}