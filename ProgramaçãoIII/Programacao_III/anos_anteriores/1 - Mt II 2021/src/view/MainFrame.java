package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel topPanel;
	private JPanel bottomPanel;
	private JLabel lblBanner;

	public MainFrame() {
		super("Exercicio 1");
		this.setLayout(new GridLayout(2,1));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(800, 400);
		
		// configurando toppanel
		topPanel = new JPanel(new GridLayout(3,1));
		topPanel.setBackground(Color.blue);
		lblBanner = new JLabel("  BANNER");
		lblBanner.setFont(new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, 40));
		lblBanner.setForeground(Color.WHITE);
		
		topPanel.add(new JLabel());
		topPanel.add(lblBanner);
		
		
		// configutrando bottompanel
		bottomPanel = new BottomPanel();
		
		this.add(topPanel);
		this.add(bottomPanel);
		this.setVisible(true);
		
	}
}
