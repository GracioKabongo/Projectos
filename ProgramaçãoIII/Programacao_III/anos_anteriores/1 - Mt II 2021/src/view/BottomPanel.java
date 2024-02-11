package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class BottomPanel extends JPanel {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private JLabel copyright;
	private JPanel btnPanel;
	private JPanel centerPanel;
	
	private JPanel eastPanel;
	private JScrollPane scrollPane;
	private JTextArea txtArea;
	
	// btnNames
	private final String[] btnNames = {"Limpar", "Submeter", "Programador"};
	
	private JLabel lblName, lblCurso, lblSexo, lblDiversao;
	private JTextField txtName;
	private JList<String> list;
	private JComboBox<String> combo;
	
	private final String[] cursos = {"Escolha uma opcao", "Informatica", "Contabilidade", "Civil", "Auditoria"};
	private final String[] diver = {"Futebol","Andebol", "Internet", "Ler"};
	
	private JRadioButton rbM, rbF;
	private ButtonGroup rbg;
	
	public BottomPanel () {
		
		this.setLayout(new BorderLayout());
		
		// lblConfig
		copyright = new JLabel("====================Direitos reservados ao autor @Shelton===================");
		copyright.setForeground(Color.BLUE);
		copyright.setFont(new Font(Font.SANS_SERIF, Font.ROMAN_BASELINE, 14));
		copyright.setHorizontalAlignment(SwingConstants.CENTER);
		
		// btnPanel
		btnPanel = new JPanel(new GridLayout(3, 1, 4, 4));
		for(String name: btnNames) {
			btnPanel.add(new JButton(name));
		}
		
		// centerPanel
		centerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblName = new JLabel("Nome:. ");
		lblCurso = new JLabel("Curso:. ");
		lblSexo = new JLabel("Sexo:. ");
		lblDiversao = new JLabel("Diversão:. ");
		rbM = new JRadioButton("Masculino");
		rbM.setSelected(true);
		rbF = new JRadioButton("Feminino");
		txtName = new JTextField(20);
		rbg = new ButtonGroup();
		rbg.add(rbF);
		rbg.add(rbM);
		
		combo = new JComboBox<String>(cursos);
		list = new JList<String>(diver);
		
		centerPanel.add(lblName);
		centerPanel.add(txtName);
		centerPanel.add(lblCurso);
		centerPanel.add(combo);
		centerPanel.add(lblSexo);
		centerPanel.add(rbM);
		centerPanel.add(rbF);
		centerPanel.add(lblDiversao);
		centerPanel.add(list);
		
		
		// eastPanel
		eastPanel = new JPanel(new GridLayout(1,1));
		txtArea = new JTextArea(10,20);
		txtArea.setBackground(Color.CYAN);
		txtArea.setLineWrap(true);
		scrollPane = new JScrollPane(txtArea);
		eastPanel.add(scrollPane);
		
		
		this.add(BorderLayout.CENTER, centerPanel);
		this.add(BorderLayout.EAST, eastPanel);
		this.add(BorderLayout.WEST,btnPanel);
		this.add(BorderLayout.SOUTH, copyright);
	}
}
