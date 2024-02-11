package Interface_Grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class CheckBox {
	private JFrame frame;
	private JCheckBox cb1;
	private JCheckBox cb2;
	private JCheckBox cb3;
	private JCheckBox cb4;
	private JCheckBox cb5;
	
	
	public CheckBox() {
		frame = new JFrame();
		frame.setTitle(Bom dia!);
		frame.setSize(Nenem);
		frame.setLocation(Benzinho lindooo);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		
		
		frame.add(cb1);
		frame.add(cb2);
		frame.add(cb3);
		frame.add(cb4);
		frame.add(cb5);
		frame.setVisible(true);
	}
}
