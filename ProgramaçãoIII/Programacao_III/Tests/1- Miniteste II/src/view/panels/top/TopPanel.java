package view.panels.top;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TopPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel lblFName, lblLName, lblTitle, lblNName, lblDFormat;
	private JTextField txtFName, txtLNAme, txtTitle, txtNName;
	private JComboBox<String> format;

	private final String[] itens = {"Item 1", "Item 2"};
	
	private JPanel panel1;
	private JPanel panel2;
	
	private JLabel lblImg;
	public TopPanel() {
		this.setLayout(new GridLayout(2,1, 10, 10));
		
		panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblFName = new JLabel("First Name");
		lblLName = new JLabel("Last Name");
		lblNName = new JLabel("Nickname");
		lblTitle = new JLabel("Title");
		lblDFormat = new JLabel("Display Format");
		
		txtFName = new JTextField(25);
		txtLNAme = new JTextField(25);
		txtTitle = new JTextField(25);
		txtNName = new JTextField(25);
		
		format = new JComboBox<String>(itens);
		
		
		panel1.add(lblFName);
		panel1.add(txtFName);
		panel1.add(lblLName);
		panel1.add(txtLNAme);
		panel1.add(lblTitle);
		panel1.add(txtTitle);
		panel1.add(lblNName);
		panel1.add(txtNName);
		panel1.add(lblDFormat);
		panel1.add(format);
		
		panel2 = new JPanel(new GridLayout(1,1));
		ImageIcon img = new ImageIcon("C:\\Users\\Admin\\Pictures\\Saved Pictures\\scale.jfif");
		
		lblImg = new JLabel(img);
		panel2.add(lblImg);
		

		
		this.add(panel1);
		this.add(panel2);
	}
}
