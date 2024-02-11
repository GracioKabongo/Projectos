package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.panels.bottom.BottomPanel;
import view.panels.top.TopPanel;

public class MainFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel topPanel;
	private JPanel bottomPanel;

	public MainFrame() {
		super("Design Preview");
		this.setLayout(new GridLayout(2,1));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(680, 400);
		this.setBackground(Color.blue);
		
		topPanel = new TopPanel();
		bottomPanel = new BottomPanel();
		
		
		this.add(topPanel);
		this.add(bottomPanel);
		this.setVisible(true);
	}
}
