package fr.feavy.mastermind.ui;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;

import fr.feavy.mastermind.Color;

public class Pawn extends JComponent{

	private Color color;
	private boolean showBorder = false;
	private int w = 40, h = 40;
	
	public Pawn() {
		color = Color.NO_COLOR;
		setSize(w, h);
	}
	
	public Pawn(Color color) {
		this.color = color;
		setSize(w, h);
	}
	
	public Pawn(Color color, boolean showBorder) {
		this.color = color;
		setSize(w, h);
		this.showBorder = showBorder;
	}
	
	public void setColor(Color color) {
		this.color = color;
		repaint();
	}
	
	public Color getColor() {
		return color;
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(w, h);
	}
	
	public void setPawnSize(int w, int h) {
		this.w = w;
		this.h = h;
		setSize(w, h);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
		
		if(!color.equals(Color.NO_COLOR)) {
			g2d.setColor(color.getColor());
			g2d.fillOval(0, 0, w, h);
		}
		
		if(showBorder || color.equals(Color.NO_COLOR)) {
			g2d.setColor(java.awt.Color.BLACK);
			g2d.setStroke(new BasicStroke(1.2f));
			g2d.drawOval(0, 0, w-1, h-1);
		} 

	}
}
