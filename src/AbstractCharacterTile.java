import javax.swing.*;
import java.awt.*;

public abstract class AbstractCharacterTile extends Tile{
	
	protected char symbol;
	
	public AbstractCharacterTile(char symbol) {
		this.symbol = symbol;
	}
	
	public boolean matches(Tile other) {
		AbstractCharacterTile otherObject = (AbstractCharacterTile) other;
		return super.matches(otherObject) && symbol == otherObject.symbol;
	}
	
	public String toString() {
		if (symbol >= '1' && symbol <= '9') {
			return "Character " + symbol;
		}
		else if (symbol == 'N') {
			return "North Wind";
		}
		else if (symbol == 'E') {
			return "East Wind";
		}
		else if (symbol == 'W') {
			return "West Wind";
		}
		else if (symbol == 'S') {
			return "South Wind";
		}
		else if (symbol == 'C') {
			return "Red Dragon";
		}
		else if (symbol == 'F') {
			return "Green Dragon";
		}
		else {
			return "Error, Invalid Character";
		}
	}
	
}