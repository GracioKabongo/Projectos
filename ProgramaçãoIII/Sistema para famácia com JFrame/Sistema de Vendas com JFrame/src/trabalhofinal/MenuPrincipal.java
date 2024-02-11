package trabalhofinal;

import Armazem.TelaArmazem;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Fornecedores.TelaFornecedores;
import Produtos.TelaListar;
import Clientes.TelaListarClientes;
import Filtro.TelaFiltro;
import Vendas.TelaVendas;
import Login.Login;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class MenuPrincipal implements ActionListener, MouseListener {

    private JFrame frame;
    private JButton btnClientes, btnArmazem, btnProdutos, btnFornecedores, btnFiltro, btnSair, btnVendas;
    private JPanel panel1;
    private JLabel lblHome, lblImagem, lbltempo, lblperfil, lbUsuario;
    private Calendar calendario;
    private SimpleDateFormat tempoFormatado;
    private String tempo;
    private JSeparator sp;
    private static final int width = 300;
    Boolean stop;

    public MenuPrincipal() {

        //inicializador de variaveis
        frame = new JFrame();
        panel1 = new JPanel();

        lblHome = new JLabel("Menu Principal");
        lblperfil = new JLabel();
        lblHome.setFont(new Font("Arial", Font.BOLD, 18));
        lblHome.setHorizontalAlignment(JLabel.CENTER);
        lblHome.setForeground(Color.black);
        lbUsuario=new JLabel(Login.txUser.getText());
        lbUsuario.setForeground(Color.black);
        ImageIcon img = new ImageIcon("BackgroundPrincipal.png");
        ImageIcon perfil = new ImageIcon("person_64px.png");
        lblImagem = new JLabel();
        lblImagem.setHorizontalAlignment(JLabel.CENTER);
        lblImagem.setIcon(img);
        lblperfil.setBounds(410, 0, 64, 64);
        lbUsuario.setBounds(470, 20, 50, 30);
        lbUsuario.setFont(new Font("Arial", Font.BOLD, 13));

        lblperfil.setIcon(perfil);

        ImageIcon cli = new ImageIcon("user_16px.png");
        ImageIcon arm = new ImageIcon("warehouse_24px.png");
        ImageIcon prod = new ImageIcon("bread_24px.png");
        ImageIcon sell = new ImageIcon("sell_24px.png");
        ImageIcon prov = new ImageIcon("truck_24px.png");
        ImageIcon fil = new ImageIcon("filter_24px.png");
        ImageIcon sair = new ImageIcon("exit_sign_24px.png");

        btnClientes = JButton("Cliente", cli);
        btnArmazem = JButton("Armazem", arm);
        btnProdutos = JButton("Produtos", prod);
        btnFornecedores = JButton("Fornecedores", prov);
        btnFiltro = JButton("Filtro", fil);
        btnSair = JButton("Sair", sair);
        btnVendas = JButton("Vendas", sell);
        btnSair.setOpaque(true);
        //frame do menu principal
        frame.setTitle("Sistema de Gestao de farmácia");
        frame.setSize(550, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setBackground(Color.white);
        frame.setResizable(false);

        //adicionar ao panel1;
        panel1.setLayout(new GridLayout(8, 1, 7, 7));
        panel1.add(lblHome);
        panel1.add(btnClientes);
        panel1.add(btnArmazem);
        panel1.add(btnProdutos);
        panel1.add(btnFornecedores);
        panel1.add(btnVendas);
        panel1.add(btnFiltro);
        panel1.add(btnSair);
        panel1.setBounds(170, 30, 200, 300);
        panel1.setBackground(new Color(0, 0, 0, 0));

        //relogio
        tempoFormatado = new SimpleDateFormat("kk:mm:ss");
        lbltempo = new JLabel();
        lbltempo.setBounds(245, 305, 200, 100);
        lbltempo.setForeground(Color.white);

        //Separador
        sp = new JSeparator();
        sp.setBounds(195, 340, 150, 2);

        //adicionar ao frame
        frame.add(sp);
        frame.add(lbltempo);
        frame.add(panel1);
        frame.add(lblperfil);
        frame.add(lbUsuario);
        frame.add(lblImagem);

        lblImagem.setBounds(0, 0, 550, 550);

        //actionListener
        btnArmazem.addActionListener(this);
        btnProdutos.addActionListener(this);
        btnFornecedores.addActionListener(this);
        btnSair.addActionListener(this);
        btnClientes.addActionListener(this);
        btnFiltro.addActionListener(this);
        btnVendas.addActionListener(this);

        //mouseListener
        lbUsuario.addMouseListener(this);

        frame.setVisible(true);
        stop = true;
        setTime();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        stop = false;
        if (ae.getSource() == btnProdutos) {
            frame.setVisible(false);
            new TelaListar();
        }
        if (ae.getSource() == btnFornecedores) {
            frame.setVisible(false);
            new TelaFornecedores();
        }

        if (ae.getSource() == btnArmazem) {
            frame.setVisible(false);
            new TelaArmazem();
        }
        if (ae.getSource() == btnSair) {
            System.exit(0);
        }
        if (ae.getSource() == btnClientes) {
            frame.setVisible(false);
            new TelaListarClientes();

        }
        if (ae.getSource() == btnFiltro) {
            frame.setVisible(false);
            new TelaFiltro();
        }
        if (ae.getSource() == btnVendas) {
            frame.setVisible(false);
            new TelaVendas();
        }
    }

    private JButton JButton(String p_strButtonText, Icon p_jIcon) {
        int nButtonHeight = 60;
        int nGap = 40;

        JButton jButton = new JButton();
        jButton.setIcon(p_jIcon);
        jButton.setIconTextGap(nGap);

        jButton.setHorizontalAlignment(SwingConstants.LEFT);
        jButton.setHorizontalTextPosition(SwingConstants.RIGHT);
        jButton.setText(p_strButtonText);

        Dimension jSize = new Dimension(width, nButtonHeight);
        jButton.setPreferredSize(jSize);
        jButton.setMaximumSize(jSize);
        jButton.setMinimumSize(jSize);
        return jButton;
    }

    private void setTime() {

        /**
         * while(stop){
         *
         * tempo = tempoFormatado.format(Calendar.getInstance().getTime());
         * lbltempo.setText(tempo); try { Thread.sleep(1000); } catch
         * (InterruptedException ex) {
         * Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE,
         * null, ex); } System.out.println("ee"); if(stop == false){
         * System.out.println("e"); break; }
         *
         * }*
         */
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
        new Timer().scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {

                lbltempo.setText(LocalTime.now().format(formatter));
            }
        }, 0, 1000);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == lbUsuario) {
            int input = JOptionPane.showConfirmDialog(null, "Deseja Mudar de Usario?", "", JOptionPane.YES_NO_OPTION);
            if (input == JOptionPane.YES_OPTION) {
                new Login();
                frame.setVisible(false);
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == lbUsuario) {
            lbUsuario.setFont(new Font("Arial", Font.BOLD, 13));
            lbUsuario.setForeground(Color.black);
        }

    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource() == lbUsuario) {
            lbUsuario.setFont(new Font("Arial", Font.BOLD, 13));
            lbUsuario.setForeground(Color.white);
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }
}
