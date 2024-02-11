package MiniTesteII;

//importações
import javax.swing.*;
import java.awt.*;


public class MinhaJanela {
	private JFrame jf;
	private JPanel p_1, p_2, p_3, p_4, p_5;
	private ImageIcon img;
	private JLabel lb_imagem, lb_nome , lb_curso, lb_sexo, lb_frase;
	private JButton bt_limpar,bt_submeter,bt_programador;
	private JScrollPane sp;
	private JTextField tf_texto;

	private JComboBox ob_curso;
	String [] curso = {"Informatica","Contabilidade","Civil","Auditoria"};
	String [] sexo = {"Masculino","Feminino"};
	private JList l_lista;
	
	public MinhaJanela() {
		jf = new JFrame();
		img = new ImageIcon("Imagem.jpg");
		Image image = img.getImage().getScaledInstance(750, 150, Image.SCALE_SMOOTH);
        img = new ImageIcon(image);
		p_1 = new JPanel();
		p_2 = new JPanel();
		p_3 = new JPanel();
		p_4 = new JPanel();
		p_5 = new JPanel();
		lb_imagem = new JLabel(img);
		bt_limpar = new JButton("Limpar");
		bt_submeter = new JButton("submeter");
		bt_programador = new JButton("Programador");
		JTextArea Jta_comentario = new JTextArea(10,20);
		sp = new JScrollPane (Jta_comentario);
		
		JComboBox ob_curso = new JComboBox(curso);
		lb_nome = new JLabel ("Nome");
		tf_texto = new JTextField (" ");
		lb_curso = new JLabel("Curso");
		l_lista = new JList(sexo);
		lb_sexo = new JLabel("Sexo");
		lb_frase = new JLabel("===========Direito Reservado ao Autor===========");
		
		jf.setTitle("Minha Janela");
		jf.setSize(760,370);
		jf.setLocation(50,50);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jf.setLayout(new BorderLayout());
		p_1.setLayout(new FlowLayout(FlowLayout.CENTER));
		p_2.setLayout(new GridLayout(2,4,10,10));
		p_3.setLayout(new FlowLayout(FlowLayout.CENTER));
		p_4.setLayout(new GridLayout(3,1,10,10));
		p_5.setLayout(new FlowLayout(FlowLayout.CENTER));
		lb_imagem.setSize(750,150);
		
		jf.add( "North", p_1);
		jf.add("Center",p_2);
		jf.add(p_3,"East");
		jf.add(p_4, "West");
		jf.add(p_5, "South");
		
		p_1.add(lb_imagem);
		p_4.add(bt_limpar);
		p_4.add(bt_submeter);
		p_4.add(bt_programador);
		p_3.add(sp);
		p_2.add(lb_nome);
		p_2.add(tf_texto);
		p_2.add(lb_curso);
		p_2.add(ob_curso);
		p_2.add(lb_sexo);
		p_2.add(l_lista);
		p_5.add(lb_frase);
		jf.setVisible(true);
	}
	
}
