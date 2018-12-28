package fr.feavy.mastermind.ui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fr.feavy.mastermind.Color;
import fr.feavy.mastermind.Game;

public class LinesPanel extends JPanel{

	private JComponent lines[][] = new JComponent[10][5];
	
	public LinesPanel() {
		setBackground(new java.awt.Color(0,0,0,0));
		setLayout(new GridLayout(10, 6));
		for(int j = 0; j < 10; j++) {
			for(int i = 0; i < 4; i++) {
				Pawn p = new Pawn(Color.NO_COLOR);
				add(p);
				lines[j][i] = p;
			}
			add(Box.createRigidArea(new Dimension(40, 40)));
			Indicators ind = new Indicators();
			add(ind);
			lines[j][4] = ind;
		}
	}
	
	public void setLine(int line, Color[] colors) {
		for(int i = 0; i < 4; i++)
			((Pawn)lines[line][i]).setColor(colors[i]);
		
		short states[] = new short[] {0,0,0,0};
		
		for(int i = 0; i < 4; i++) {
			if(colors[i].equals(Game.goodCombination[i]))
				states[i] = 2;
		}
		
		// GREEN YELLOW YELLOW GREEN
		
		// Req : YELLOW GREEN GREEN YELLOW
		
		// Expected : {1,1,1,1}
		
		int sum = 0;
		
		boolean treated[] = new boolean[] {false, false, false, false};
		
		for(int i = 0; i < 4; i++) {
			if(states[i] == 2) {
				sum += 2;
				continue;
			}
			Integer[] indexes = Game.getColorIndexes(colors[i]);
			for(int index : indexes) {
				if(states[index] < 2 && !treated[index]) {
					states[i] = 1;
					treated[index] = true;
				}
			}
			sum += states[i];
		}
		
		((Indicators)lines[line][4]).setState(states);
		
		MainWindow.instance.repaint();
		
		if(sum == 8) {
			JOptionPane.showMessageDialog(null, "Félicitations ! Vous avez gagné !", "Mastermind", JOptionPane.INFORMATION_MESSAGE);
			Game.terminated = true;
		}else if(Game.currentLine == 10) {
			JOptionPane.showMessageDialog(null, "Vous avez perdu.", "Mastermind", JOptionPane.WARNING_MESSAGE);
			Game.terminated = true;
		}
	}
	
}
