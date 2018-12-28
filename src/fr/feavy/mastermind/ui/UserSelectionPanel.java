package fr.feavy.mastermind.ui;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import fr.feavy.mastermind.Color;
import fr.feavy.mastermind.Game;

public class UserSelectionPanel extends JPanel{
	
	private Pawn pawns[] = new Pawn[4];
	
	public UserSelectionPanel() {
		setBackground(java.awt.Color.WHITE);
		setLayout(null);
		for(int i = 0; i < 4; i++) {
			Pawn p = new Pawn(Color.YELLOW, true);
			p.setPawnSize(50, 50);
			p.setLocation(i*65+10, 13);
			p.setCursor(new Cursor(Cursor.HAND_CURSOR));
			p.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					short colorID = (short) (p.getColor().id()+1);
					if(colorID == 7)
						colorID = 1;
					p.setColor(Color.fromID(colorID));
				}
			});
			add(p);
			pawns[i] = p;
		}
		
		JButton button = new JButton();
		button.setBounds(4*65+20, 13, 100, 50);
		button.setBackground(java.awt.Color.WHITE);
		//button.setFocusPainted(false);
		
		try {
			Image img = ImageIO.read(getClass().getResource("/button.png")).getScaledInstance(50, 50, Image.SCALE_SMOOTH);
			button.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Game.terminated)
					return;
				
				Color[] colors = new Color[4];
				for(int i = 0; i < 4; i++) 
					colors[i] = pawns[i].getColor();
				MainWindow.instance.getLinesPanel().setLine(Game.currentLine++, colors);
				
			}
		});
		
		add(button);
	}
	
}
