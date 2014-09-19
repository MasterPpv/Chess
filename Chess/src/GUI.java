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

public class GUI implements ActionListener {

	public GUI(Board board) {
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
		JMenuItem open = new JMenuItem("Open");
		open.addActionListener(this);
		file.add(open);
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
	}

}