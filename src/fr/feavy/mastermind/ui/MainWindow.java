package fr.feavy.mastermind.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import fr.feavy.mastermind.Game;

public class MainWindow extends JPanel{

	public static MainWindow instance;
	private LinesPanel linesPanel;
	
	public static void main(String[] args) {
		Game.initialize();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JFrame window = new JFrame("Mastermind");
		window.setSize(400, 700);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setContentPane(new MainWindow());
		window.setVisible(true);
	}

	public MainWindow() {
		instance = this;
		setBackground(new java.awt.Color(200, 200, 200));
		setLayout(null);
		
		linesPanel = new LinesPanel();
		linesPanel.setBounds((400-300)/2, 50, 300, 500);
		add(linesPanel);
		
		UserSelectionPanel usp = new UserSelectionPanel();
		usp.setBounds(0, 600, 400, 100);
		add(usp);
		
	}
	
	public LinesPanel getLinesPanel() {
		return linesPanel;
	}
	
}
