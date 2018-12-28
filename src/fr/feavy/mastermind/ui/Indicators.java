package fr.feavy.mastermind.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JComponent;

public class Indicators extends JComponent{

	public static short INCORRECT = 0, ALMOST_CORRECT = 1, CORRECT = 2;
	
	private short[] states;
	
	public Indicators() {
		setSize(40, 40);
		states = new short[] {0, 0, 0, 0};
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(40, 40);
	}
	
	public void setState(short[] p) {
		states = p;
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.BLACK);
		g2d.draw(new RoundRectangle2D.Float(0, 0, 39, 39, 10, 10));
		int x = 0, y = 0;
		for(int i = 0; i < 4; i++) {
			if(states[i] != 0) {
				g.setColor(states[i] == 1 ? Color.BLACK : Color.WHITE);
				g.fillOval(3 + 19*x, 2+20*y, 15, 15);
				x++;
				if(x == 2) {
					x = 0;
					y++;
				}
			}
		}
	}
	
}
