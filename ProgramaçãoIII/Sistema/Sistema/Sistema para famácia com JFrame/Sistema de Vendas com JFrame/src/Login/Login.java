package Login;

import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import trabalhofinal.MenuPrincipal;

public class Login implements ActionListener{
    private JFrame fr;
    private JLabel lbTit, lbUser, lbSenha, lbIcone,lbBackground;
    public static JTextField txUser;
    private JPasswordField txSenha;
    private JButton btEntrar, btCancelar;
    private JPanel jp;
    
    public Login(){
        fr = new JFrame();
        jp = new JPanel();
        fr.setTitle("Entar");
        fr.setSize(350, 300);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLocationRelativeTo(null);
        fr.setLayout(null);
        fr.setResizable(false);
        
        ImageIcon imj = new ImageIcon("cancel_16px.png");
        ImageIcon imj2 = new ImageIcon("login_16px.png");
        ImageIcon header = new ImageIcon("person_64px.png");
        ImageIcon Background= new ImageIcon("loginBack.png");
        
        lbTit = new JLabel("Administrador");
        lbUser = new JLabel("Utilizador");
        lbSenha = new JLabel("Senha");
        lbIcone = new JLabel();
        lbBackground=new JLabel();
        lbTit.setFont(new Font("Calibri", Font.BOLD, 14));
        lbTit.setForeground(Color.white);
        lbTit.setBounds(132, 54, 100, 64);
        lbIcone.setBounds(138, 10, 64, 64);
        lbIcone.setIcon(header);
        lbBackground.setIcon(Background);
        lbBackground.setHorizontalAlignment(JLabel.CENTER);
        lbBackground.setBounds(0, 0, 350, 300);
        
        txUser = new txUser();
        txSenha = new txPass();
        
        btEntrar = new JButton("Entrar", imj2);
        btCancelar = new JButton("Cancelar", imj);
        
        jp.setBounds(80, 110, 180, 100);
        jp.setLayout(new GridLayout(3,1, 10, 12));
        
        jp.add(txUser);
        
        jp.add(txSenha);
        jp.add(btEntrar);
        jp.setBackground(new Color(0,0,0,0));
        
        fr.add(lbIcone);
        fr.add(lbTit);
        fr.add(jp);
        fr.add(lbBackground);
       
        btEntrar.addActionListener(this);
        btCancelar.addActionListener(this);
        btEntrar.setMnemonic(KeyEvent.VK_ENTER);
        fr.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btEntrar) {
            
            if(txUser.getText().equals("Gracio") || txUser.getText().equals("Manuel") || txUser.getText().equals("Harmonico") 
                    || txUser.getText().equals("Winner") || txUser.getText().equals("Shanaya")){
                if(txSenha.getText().equals("1234")){
                    JOptionPane.showMessageDialog(null, "Seja bem vindo vendedor/a ".concat(txUser.getText()).concat("!"));
                    fr.setVisible(false);
                    new MenuPrincipal();
                }else{
                  JOptionPane.showMessageDialog(null, "Password incorrecto, Tente denovo ".concat(txUser.getText()).concat("!"));  
                }
                
                
                
            }else{
                JOptionPane.showMessageDialog(null, "Nome de utilizador ou senha errado");
            }
        }
        if (ae.getSource() == btCancelar) {
            
        }
    }
    
        
    
}
