
public abstract class RankTile extends Tile{
	
	protected int rank;
	
	public RankTile(int rank) {
		this.rank = rank;
	}
	
	public boolean matches(Tile other) {
		RankTile otherObject = (RankTile) other;
		return super.matches(otherObject) && rank == otherObject.rank;
	}
}