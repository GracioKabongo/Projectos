package view.panels.bottom;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class BottomPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel btnPanel;
	private JPanel fieldsPanel;
	private JPanel configPanel;
	private JPanel centerContainer;
	private String[] btnName = {"Add", "Edit","Remove", "As Default"};
	private JLabel lblEmail, lblFormat;
	
	private JRadioButton html, plain, custom;
	private ButtonGroup group;
	
	
	private JPanel east = new JPanel(new GridLayout(2,2,2,2));
	private JPanel btnP2 = new JPanel(new GridLayout(1,2,2,2));
	
	private JPanel listLayout = new JPanel(new GridLayout(1,1));
	private String[] listElements  = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
	private JList<String> list;
	
	private JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JTextField address;
	
	public BottomPanel() {
		this.setLayout(new GridLayout(2,1));
		
		centerContainer = new JPanel(new BorderLayout());
		btnPanel = new JPanel(new GridLayout(4,1, 5, 2));
		
		for(String name: btnName) {
			btnPanel.add(new JButton(name));
		}
		
		
		list = new JList<String>(listElements);
		listLayout.add(list);

		
		lblEmail = new JLabel("E-mail address:.");
		address = new JTextField(44);
		
		northPanel.add(lblEmail);
		northPanel.add(address);
		
		fieldsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		configPanel = new JPanel(new BorderLayout());
		lblFormat = new JLabel("Mail Format:");
		
		
		html = new JRadioButton("HTML");
		plain = new JRadioButton("Plain Texr");
		custom = new JRadioButton("Custom");
		group = new ButtonGroup();
		group.add(custom);
		group.add(html);
		group.add(plain);
		
		btnP2.add(new JButton("OK"));
		btnP2.add(new JButton("Cancel"));
		
		east.add(new JLabel());
		east.add(btnP2);
		
		
		
		fieldsPanel.add(html);
		fieldsPanel.add(plain);
		fieldsPanel.add(custom);
		configPanel.add(BorderLayout.CENTER, fieldsPanel);
		configPanel.add(BorderLayout.NORTH, lblFormat);
		configPanel.add(BorderLayout.EAST, east);
		
		centerContainer.add(BorderLayout.NORTH, northPanel);
		centerContainer.add(BorderLayout.CENTER, listLayout);
		centerContainer.add(BorderLayout.EAST, btnPanel);
		
		
		this.add(centerContainer);
		this.add(configPanel);
		
		
		
	}

}
