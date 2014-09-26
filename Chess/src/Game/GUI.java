package Game;
import Game.Pieces.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
/**
 * The graphical user interface for the game. Is responsible for displaying
 * the board and pieces, as well as facilitating all of the interactions
 * between the user (player) and the game, board, pieces, etc.
 * 
 * @author Priten Vora
 *
 */
public class GUI implements ActionListener {

	private Board board;

	public GUI(Board b) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) {
			// Ignore for now
		}
		JFrame window = new JFrame("Chess");
		window.setSize(640, 640);
		JPanel panel = initializePanel();
		setUpMenu(window);
		window.setContentPane(panel);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		board = b;
	}

	private JPanel initializePanel() {
		JPanel myPanel = new JPanel();
		myPanel.setPreferredSize(new Dimension(500,500));
		myPanel.setLayout(new BorderLayout());
		return myPanel;
	}

	private void setUpMenu(JFrame window) {
		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenuItem newGame = new JMenuItem("New Game");
		newGame.addActionListener(this);
		file.add(newGame);
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(this);
		file.add(exit);
		menubar.add(file);
		window.setJMenuBar(menubar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Exit") {
			System.exit(0);
		}
		if(e.getActionCommand() == "New Game") {
			board = new Board(8, 8);
		}
	}

}