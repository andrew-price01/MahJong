import java.awt.*;
import java.util.HashMap;
import javax.swing.*;
@SuppressWarnings("serial")
public class CharacterTile extends AbstractCharacterTile {
	
	protected static HashMap<String, String> chineseCharacters = new HashMap<String, String>();
	private String character;
	
	static {
		chineseCharacters.put("1", "\u4E00");
		chineseCharacters.put("2", "\u4E8C");
		chineseCharacters.put("3", "\u4E09");
		chineseCharacters.put("4", "\u56DB");
		chineseCharacters.put("5", "\u4E94");
		chineseCharacters.put("6", "\u516D");
		chineseCharacters.put("7", "\u4E03");
		chineseCharacters.put("8", "\u516B");
		chineseCharacters.put("9", "\u4E5D");
		chineseCharacters.put("N", "\u5317");
		chineseCharacters.put("E", "\u6771");
		chineseCharacters.put("W", "\u897F");
		chineseCharacters.put("S", "\u5357");
		chineseCharacters.put("C", "\u4E2D");
		chineseCharacters.put("F", "\u767C");
		chineseCharacters.put("wan", "\u842C");
		
	}
	
	public CharacterTile(char symbol) {
		super(symbol);
		setToolTipText(toString());
		character = chineseCharacters.get(Character.toString(symbol));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
	
		//FontMetrics fontMetrics = g.getFontMetrics();
		//int width = fontMetrics.stringWidth(character);
		
		// Labels Top Right Corner
		g.setColor(Color.RED);
		g.drawString(Character.toString(symbol), 75, 15);
		
		
		// Symbols 1 - 9
		if (symbol >= '1' && symbol <= '9') {
			g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
			g.drawString(chineseCharacters.get("wan"), 45, 60);
			
			g.setColor(Color.BLACK);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 27));
			//g.drawString(character, (getWidth() - width) / 2, (getHeight() / 2) - 15);
			g.drawString(character, 45, 35);
		}
		
		// Symbol C
		else if (symbol == 'C') {
			g.setColor(Color.RED);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
			//g.drawString(character, (getWidth() - width - 20) / 2, (getHeight() / 2) + 12);
			g.drawString(character, 30, 55);
		}
		
		// Symbol F
		else if (symbol == 'F') {
			g.setColor(Tile.LightGreen);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
			//g.drawString(character, (getWidth() - width - 20) / 2, (getHeight() / 2) + 12);
			g.drawString(character, 30, 55);
		}
		
		// Symbols North, East, South, West
		else {
			g.setColor(Color.BLACK);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
			//g.drawString(character, (getWidth() - width - 20) / 2, (getHeight() / 2) + 12);
			g.drawString(character, 30, 55);
		}
		
		
	}
	
	public static void main(String[] args)
	{
		JFrame		frame = new JFrame();
		JPanel		tiles = new JPanel();
		JScrollPane	scroller = new JScrollPane(tiles);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Character Tiles");
		frame.add(scroller);

		// Try something like this if your tiles don't fit on the screen.
		// Replace "tile width" and "tile height" with your values.
		//scroller.setPreferredSize(new Dimension(8 * 100, 40 + 100));

		tiles.add(new CharacterTile('1'));
		tiles.add(new CharacterTile('2'));
		tiles.add(new CharacterTile('3'));
		tiles.add(new CharacterTile('4'));
		tiles.add(new CharacterTile('5'));
		tiles.add(new CharacterTile('6'));
		tiles.add(new CharacterTile('7'));
		tiles.add(new CharacterTile('8'));
		tiles.add(new CharacterTile('9'));
		tiles.add(new CharacterTile('N'));
		tiles.add(new CharacterTile('E'));
		tiles.add(new CharacterTile('W'));
		tiles.add(new CharacterTile('S'));
		tiles.add(new CharacterTile('C'));
		tiles.add(new CharacterTile('F'));

		frame.pack();
		frame.setVisible(true);
	}
}