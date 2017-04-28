import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
@SuppressWarnings("serial")
public class MahJong extends JFrame {

	MahJongModel model = new MahJongModel();
	Random rand;
	private long seed;
	private int scoreCount;
	private Fireworks reward;
	private ImageIcon dragonImg = new ImageIcon(getClass().getResource("dragon_bg.png"));
	private Image dragon_bg = dragonImg.getImage();
	//private Image dragon_bg = Toolkit.getDefaultToolkit().getImage("images/dragon_bg.png");
	private Tile first = null;
	private Tile second = null;
	private Border selected = BorderFactory.createLineBorder(Color.YELLOW, 5);
	private PlayClip clip = new PlayClip("audio/stone-scraping.wav", true);
	private JLabel gameNumber = new JLabel();
	public ArrayList<Tile> deck = new ArrayList<Tile>();
	public ArrayList<Tile> gameTiles = new ArrayList<Tile>();
	public ArrayList<Tile> removedList = new ArrayList<Tile>();

	public MahJong() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});

		setTitle("MahJong Game");

		add(new MahJongBoard());

		setSize(1300, 700);
		setVisible(true);
	}

	private void exit() {
		if (JOptionPane.showConfirmDialog(this, "Exit Program?", "Confirm Exit", JOptionPane.YES_NO_OPTION) 
				== JOptionPane.YES_OPTION)
				System.exit(0);
	}

	public class MahJongBoard extends JPanel implements MouseListener {

		public MahJongBoard() {
			rand = new Random();
			setLayout(null);
			makeMenu();

		}

		private void makeMenu() {
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			JMenu gameMenu = new JMenu("Game");
			menuBar.add(gameMenu);

			JMenu soundMenu = new JMenu("Sound");
			menuBar.add(soundMenu);

			JMenu removedMenu = new JMenu("Removed Tiles");
			menuBar.add(removedMenu);
			
			JMenu hintMenu = new JMenu("Hint");
			menuBar.add(hintMenu);

			JMenu helpMenu = new JMenu("Help");
			menuBar.add(helpMenu);

			Action playAction = new AbstractAction("New Game") {

				public void actionPerformed(ActionEvent e) {
					newGame();
				}
			};

			Action restartAction = new AbstractAction("Restart") {

				public void actionPerformed(ActionEvent e) {
					restartGame();
				}
			};

			Action numberedAction = new AbstractAction("Play (Game Number)") {

				public void actionPerformed(ActionEvent e) {
					numberGame();
				}
			};

			Action onAction = new AbstractAction("On") {

				public void actionPerformed(ActionEvent e) {
					soundOn();
				}
			};

			Action offAction = new AbstractAction("Off") {
				public void actionPerformed(ActionEvent e) {
					soundOff();
				}
			};

			Action operationAction = new AbstractAction("Operations") {

				public void actionPerformed(ActionEvent e) {
					Help h = new Help("help/operations.html");
					h.display();
				}
			};

			Action rulesAction = new AbstractAction("Rules") {

				public void actionPerformed(ActionEvent e) {
					Help h = new Help("help/rules.html");
					h.display();
				}
			};

			Action removeAction = new AbstractAction("Removed") {

				public void actionPerformed(ActionEvent e) {
					removedTiles();
				}
			};
			
			Action hintAction = new AbstractAction("Hint") {

				public void actionPerformed(ActionEvent e) {
					//showHint();
				}
			};

			JMenuItem newGame = new JMenuItem(playAction);
			JMenuItem restartGame = new JMenuItem(restartAction);
			JMenuItem numberGame = new JMenuItem(numberedAction);
			JMenuItem soundOn = new JMenuItem(onAction);
			JMenuItem soundOff = new JMenuItem(offAction);
			JMenuItem operation = new JMenuItem(operationAction);
			JMenuItem rules = new JMenuItem(rulesAction);
			JMenuItem remove = new JMenuItem(removeAction);
			JMenuItem hint = new JMenuItem(hintAction);
			
			gameMenu.add(newGame);
			gameMenu.addSeparator();
			gameMenu.add(restartGame);
			gameMenu.addSeparator();
			gameMenu.add(numberGame);
			gameMenu.addSeparator();

			soundMenu.add(soundOn);
			soundMenu.addSeparator();
			soundMenu.add(soundOff);

			helpMenu.add(operation);
			helpMenu.add(rules);

			removedMenu.add(remove);
			hintMenu.add(hint);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.setColor(Tile.Gold);
			g.fillRect(0, 0, 1300, 700);
			g.drawImage(dragon_bg, (this.getWidth() - dragon_bg.getWidth(this)) / 2,
					(this.getHeight() - dragon_bg.getHeight(this)) / 2, this);

		}

		private void removedTiles() {
			JPanel panel = new JPanel();
			panel.setLayout(new FlowLayout(FlowLayout.LEFT));

			for (Tile t : gameTiles) {
				for (Tile r : removedList) {
					if (!removedList.contains(t)) {
						panel.add(r, 0);
					}
				}
			}
			panel.setPreferredSize(new Dimension(400, 4000));

			JScrollPane scroll = new JScrollPane(panel);
			scroll.setLayout(new ScrollPaneLayout());
			scroll.setPreferredSize(new Dimension(400, 510));
			scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

			JDialog popUpContainer = new JDialog();
			popUpContainer.setTitle("Removed Tiles");
			popUpContainer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			popUpContainer.setBounds(1290, 0, 400, 700);
			popUpContainer.setLayout(new BorderLayout());

			popUpContainer.add(scroll);

			popUpContainer.setVisible(true);
		}

		public void newGame() {
			if (JOptionPane.showConfirmDialog(this, "Are you sure you want to start a new game?", "Confirm",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				for (Tile t : gameTiles) {
					if (t.tileRemoved == true) {
						t.tileRemoved = false;
						remove(t);
					} else {
						remove(t);
					}
				}
				scoreCount = 0;
				seed = System.currentTimeMillis() % 100000;
				showNumber(seed);

				tileDeck();
				// seed = System.currentTimeMillis();
				rand.setSeed(seed);
				Collections.shuffle(deck, rand);
				dealTiles();
				revalidate();
				repaint();
			}

		}

		public void restartGame() {
			if (JOptionPane.showConfirmDialog(this, "Are you sure you want to restart game?", "Confirm",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				for (Tile t : gameTiles) {
					if (t.tileRemoved == true) {
						t.tileRemoved = false;
						remove(t);
					} else {
						remove(t);
					}
				}
				scoreCount = 0;
				tileDeck();
				rand.setSeed(seed);
				Collections.shuffle(deck, rand);
				dealTiles();
				repaint();
				revalidate();
			}
		}

		public void numberGame() {
			scoreCount = 0;
			
			String[] buttons = { "New Game", "Numbered" };
			int returnValue = JOptionPane.showOptionDialog(null, "Options", "Numbered Game", JOptionPane.PLAIN_MESSAGE,
					0, null, buttons, buttons[0]);
			System.out.println(returnValue);
			if (returnValue == JOptionPane.YES_OPTION) {

				for (Tile t : gameTiles) {
					if (t.tileRemoved == true) {
						t.tileRemoved = false;
						remove(t);
					} else {
						remove(t);
					}
				}
				seed = System.currentTimeMillis() % 100000;
				showNumber(seed);
				tileDeck();
				rand.setSeed(seed);
				Collections.shuffle(deck, rand);
				dealTiles();
				revalidate();
				repaint();
			} else if (returnValue == JOptionPane.NO_OPTION) {
				String input = JOptionPane.showInputDialog("Enter game number:");
				System.out.println(input);
				seed = Long.parseLong(input);
				for (Tile t : gameTiles) {
					if (t.tileRemoved == true) {
						t.tileRemoved = false;
						remove(t);
					} else {
						remove(t);
					}
				}
				showNumber(seed);
				tileDeck();
				rand.setSeed(seed);
				Collections.shuffle(deck, rand);
				dealTiles();
				revalidate();
				repaint();
			}
		}

		public void soundOn() {

		}

		public void soundOff() {

		}

		public void dealTiles() {

			// ----------------------Layer 4------------------------//
			Tile top = deck.remove(deck.size() - 1);
			model.positionTile(top, 7, 5, 4);
			top.setLocation((top.x * 70 + top.z * 20) - 40, (top.y * 70 - top.z * 20) - 30);
			top.addMouseListener(this);
			add(top);
			gameTiles.add(top);

			// ----------------------Layer 3------------------------//
			Row row1 = new Row(6, 5);
			row1.addTiles(deck, 2);
			for (Tile t : row1) {
				model.positionTile(t, row1.x, row1.y, 3);
				t.setLocation((row1.x * 70 + t.z * 20), (row1.y * 70 - t.z * 20));
				t.addMouseListener(this);
				add(t);
				gameTiles.add(t);
				row1.x += 1;
			}

			Row row2 = new Row(6, 4);
			row2.addTiles(deck, 2);
			for (Tile t : row2) {
				model.positionTile(t, row2.x, row2.y, 3);
				t.setLocation((row2.x * 70 + t.z * 20), (row2.y * 70 - t.z * 20));
				t.addMouseListener(this);
				add(t);
				gameTiles.add(t);
				row2.x += 1;
			}

			// ----------------------Layer 2------------------------//
			Row row3 = new Row(5, 6);
			row3.addTiles(deck, 4);
			for (Tile t : row3) {
				model.positionTile(t, row3.x, row3.y, 2);
				t.setLocation((row3.x * 70 + t.z * 20), (row3.y * 70 - t.z * 20));
				t.addMouseListener(this);
				add(t);
				gameTiles.add(t);
				row3.x += 1;
			}

			Row row4 = new Row(5, 5);
			row4.addTiles(deck, 4);
			for (Tile t : row4) {
				model.positionTile(t, row4.x, row4.y, 2);
				t.setLocation((row4.x * 70 + t.z * 20), (row4.y * 70 - t.z * 20));
				t.addMouseListener(this);
				add(t);
				gameTiles.add(t);
				row4.x += 1;
			}

			Row row5 = new Row(5, 4);
			row5.addTiles(deck, 4);
			for (Tile t : row5) {
				model.positionTile(t, row5.x, row5.y, 2);
				t.setLocation((row5.x * 70 + t.z * 20), (row5.y * 70 - t.z * 20));
				t.addMouseListener(this);
				add(t);
				gameTiles.add(t);
				row5.x += 1;
			}

			Row row6 = new Row(5, 3);
			row6.addTiles(deck, 4);
			for (Tile t : row6) {
				model.positionTile(t, row6.x, row6.y, 2);
				t.setLocation((row6.x * 70 + t.z * 20), (row6.y * 70 - t.z * 20));
				t.addMouseListener(this);
				add(t);
				gameTiles.add(t);
				row6.x += 1;
			}

			// ----------------------Special Cases------------------------//
			Tile spec = deck.remove(deck.size() - 1);
			model.positionTile(spec, 0, 5, 1);
			spec.setLocation((spec.x * 70 + spec.z * 20) - 20, (spec.y * 70 - spec.z * 20) - 20);
			spec.addMouseListener(this);
			add(spec);
			gameTiles.add(spec);

			// ----------------------Layer 1------------------------//
			Row row7 = new Row(4, 7);
			row7.addTiles(deck, 6);
			for (Tile t : row7) {
				model.positionTile(t, row7.x, row7.y, 1);
				t.setLocation((row7.x * 70 + t.z * 20), (row7.y * 70 - t.z * 20));
				t.addMouseListener(this);
				add(t);
				gameTiles.add(t);
				row7.x += 1;
			}

			Row row8 = new Row(4, 6);
			row8.addTiles(deck, 6);
			for (Tile t : row8) {
				model.positionTile(t, row8.x, row8.y, 1);
				t.setLocation((row8.x * 70 + t.z * 20), (row8.y * 70 - t.z * 20));
				t.addMouseListener(this);
				add(t);
				gameTiles.add(t);
				row8.x += 1;
			}

			Row row9 = new Row(4, 5);
			row9.addTiles(deck, 6);
			for (Tile t : row9) {
				model.positionTile(t, row9.x, row9.y, 1);
				t.setLocation((row9.x * 70 + t.z * 20), (row9.y * 70 - t.z * 20));
				t.addMouseListener(this);
				add(t);
				gameTiles.add(t);
				row9.x += 1;
			}

			Row row10 = new Row(4, 4);
			row10.addTiles(deck, 6);
			for (Tile t : row10) {
				model.positionTile(t, row10.x, row10.y, 1);
				t.setLocation((row10.x * 70 + t.z * 20), (row10.y * 70 - t.z * 20));
				t.addMouseListener(this);
				add(t);
				gameTiles.add(t);
				row10.x += 1;
			}

			Row row11 = new Row(4, 3);
			row11.addTiles(deck, 6);
			for (Tile t : row11) {
				model.positionTile(t, row11.x, row11.y, 1);
				t.setLocation((row11.x * 70 + t.z * 20), (row11.y * 70 - t.z * 20));
				t.addMouseListener(this);
				add(t);
				gameTiles.add(t);
				row11.x += 1;
			}

			Row row12 = new Row(4, 2);
			row12.addTiles(deck, 6);
			for (Tile t : row12) {
				model.positionTile(t, row12.x, row12.y, 1);
				t.setLocation((row12.x * 70 + t.z * 20), (row12.y * 70 - t.z * 20));
				t.addMouseListener(this);
				add(t);
				gameTiles.add(t);
				row12.x += 1;
			}

			// ----------------------Layer 0------------------------//
			Layer layer0 = new Layer(deck);
			for (Row r : layer0) {
				for (Tile t : r) {
					t.addMouseListener(this);
					add(t);
					gameTiles.add(t);
				}
			}

		}

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
			Tile t = (Tile) e.getSource();

			if (model.isTileOpen(t, gameTiles)) {
				if (first == null) {
					first = t;
					first.setBorder(selected);
					return;
				} else if (t == first) {
					first.setBorder(null);
					first = null;
					return;
				}

				second = t;

				if (first.matches(second)) {
					clip.play(); // play sound
					scoreCount += 2;
					removedList.add(first);
					first.tileRemoved = true;
					second.tileRemoved = true;
					first.setBorder(null);
					remove(first);
					remove(second);
					first = second = null;
					repaint();
				}

				first.setBorder(null);
				first = second;
				first.setBorder(selected);

			}

		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
		
		public void startReward() {
			if (scoreCount < 144) {
				return;
			}
			reward = new Fireworks(this);
			//reward.setSound(sound);
			reward.fire();
		}

		public void showNumber(long seed) {
			gameNumber.setText("Game Number: " + seed);
			gameNumber.setLocation(500, -50);
			gameNumber.setSize(new Dimension(200, 200));
			add(gameNumber);
		}

		// public void showHint() {
		// for (Tile t: gameTiles) {
		// for (Tile r: gameTiles) {
		// if (model.isTileOpen(t, gameTiles)) {
		// if (model.isTileOpen(r, gameTiles)) {
		// if (model.getTile(t.x, t.y, t.z, gameTiles).matches(r));
		// model.getTile(t.x, t.y, t.z, gameTiles).setBorder(selected);
		// r.setBorder(selected);
		// return;
		// }
		// }
		// }
		// }
		// }
	}

	public void tileDeck() {

		for (int i = 0; i < 4; i++) {
			deck.add(new CharacterTile('1'));
			deck.add(new CharacterTile('2'));
			deck.add(new CharacterTile('3'));
			deck.add(new CharacterTile('4'));
			deck.add(new CharacterTile('5'));
			deck.add(new CharacterTile('6'));
			deck.add(new CharacterTile('7'));
			deck.add(new CharacterTile('8'));
			deck.add(new CharacterTile('9'));
			deck.add(new CharacterTile('N'));
			deck.add(new CharacterTile('E'));
			deck.add(new CharacterTile('W'));
			deck.add(new CharacterTile('S'));
			deck.add(new CharacterTile('C'));
			deck.add(new CharacterTile('F'));

			deck.add(new CircleTile(1));
			deck.add(new CircleTile(2));
			deck.add(new CircleTile(3));
			deck.add(new CircleTile(4));
			deck.add(new CircleTile(5));
			deck.add(new CircleTile(6));
			deck.add(new CircleTile(7));
			deck.add(new CircleTile(8));
			deck.add(new CircleTile(9));

			deck.add(new BambooTile(2));
			deck.add(new BambooTile(3));
			deck.add(new BambooTile(4));
			deck.add(new BambooTile(5));
			deck.add(new BambooTile(6));
			deck.add(new BambooTile(7));
			deck.add(new BambooTile(8));
			deck.add(new BambooTile(9));
			deck.add(new Bamboo1Tile());
			deck.add(new WhiteDragonTile());
		}
		deck.add(new FlowerTile("Chrysanthemum"));
		deck.add(new FlowerTile("Orchid"));
		deck.add(new FlowerTile("Plum"));
		deck.add(new FlowerTile("Sparrow"));
		deck.add(new SeasonTile("Spring"));
		deck.add(new SeasonTile("Summer"));
		deck.add(new SeasonTile("Fall"));
		deck.add(new SeasonTile("Winter"));
	}

	public static void main(String[] args) {
		new MahJong();
	}

}