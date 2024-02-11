package Clientes;

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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import trabalhofinal.MenuPrincipal;
import Filtro.TelaFiltro;
import Fornecedores.TelaFornecedores;
import Produtos.TelaListar;
import Vendas.TelaVendas;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.util.Random;

public class TelaClientes implements ActionListener, Serializable {

    private JFrame frame;
    private JLabel lblId, lblNumero, lblNome, lblMorada, lblSexo, lblSaldo, lblClientes;
    private JButton gravar, voltar;
    private JPanel panellb, paneltx, panelbt;
    private static JTextField txId, txNome, txSaldo, txContacto, txMorada;
    private static JComboBox cbSexo;
    private JSeparator sp;
    private JMenu menu, MCliente;
    private JMenuItem miArmazem, miProdutos, miFornecedores, miFiltro, miSair, miVerCli, miVendas;
    private JMenuBar menuBar;
    public static Vector<DadosCliente> v = new Vector<DadosCliente>();
    public static Random rand = new Random();
    private int idp;
    private Vector vazio = new Vector();

    public TelaClientes() {
        //frame
        frame = new JFrame();
        frame.setTitle("Sistema de Gestao");
        frame.setSize(550, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);

        sp = new JSeparator();
        sp.setBounds(10, 40, 520, 5);

        frame = new JFrame();
        frame.setTitle("Sistema de Gestao");
        frame.setLocation(300, 300);
        frame.setSize(550, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        sp = new JSeparator();

        //imagem
        ImageIcon Ibackground = new ImageIcon("backArmazem.png");
        ImageIcon imj2 = new ImageIcon("save_16px.png");

        //labels
        lblClientes = new JLabel("Clientes");
        lblId = new JLabel("ID:");
        lblNome = new JLabel("Nome:");
        lblNumero = new JLabel("Contacto:");
        lblMorada = new JLabel("Morada:");
        lblSexo = new JLabel("Sexo:");
        lblSaldo = new JLabel("Saldo:");

        lblClientes.setHorizontalAlignment(JLabel.CENTER);
        lblClientes.setBounds(220, 0, 100, 50);
        lblClientes.setFont(new Font("Arial", Font.BOLD, 18));
        lblNome.setHorizontalAlignment(JLabel.RIGHT);
        lblNumero.setHorizontalAlignment(JLabel.RIGHT);
        lblId.setHorizontalAlignment(JLabel.RIGHT);
        lblSexo.setHorizontalAlignment(JLabel.RIGHT);
        lblSaldo.setHorizontalAlignment(JLabel.RIGHT);
        lblMorada.setHorizontalAlignment(JLabel.RIGHT);

        //buttons
        gravar = new JButton("Gravar", imj2);
        voltar = new JButton("Voltar");
        voltar.setBounds(10, 313, 80, 25);

        //text fields
        txId = new JTextField();
        txNome = new JTextField();
        txContacto = new JTextField();
        txMorada = new JTextField();
        txSaldo = new JTextField();

        //comboBox
        String[] escolha = {"Masculino", "Feminino"};
        cbSexo = new JComboBox(escolha);
        cbSexo.setSelectedIndex(-1);

        //menuItem
        miArmazem = new JMenuItem("Armazem");
        miProdutos = new JMenuItem("Produtos");
        miFornecedores = new JMenuItem("Fornecedores");
        miFiltro = new JMenuItem("Filtro");
        miProdutos = new JMenuItem("Produtos");
        miVendas = new JMenuItem("Vendas");
        miSair = new JMenuItem("Sair");
        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        frame.setJMenuBar(menuBar);
        menuBar.add(menu);
        menu.add(miArmazem);
        menu.add(miProdutos);
        menu.add(miFornecedores);
        menu.add(miVendas);
        menu.add(miFiltro);
        menu.addSeparator();
        menu.add(miSair);

        MCliente = new JMenu("Clientes");
        miVerCli = new JMenuItem("Listar");
        menuBar.add(MCliente);
        MCliente.add(miVerCli);

        //panels
        panellb = new JPanel();
        paneltx = new JPanel();
        panelbt = new JPanel();

        panellb.setLayout(new GridLayout(5, 1, 10, 10));
        panellb.add(lblNome);
        panellb.add(lblNumero);
        panellb.add(lblMorada);
        panellb.add(lblSexo);
        panellb.add(lblSaldo);
        panellb.setBounds(60, 50, 100, 160);
        sp.setBounds(10, 40, 525, 5);

        paneltx.setLayout(new GridLayout(5, 1, 10, 10));
        paneltx.add(txNome);
        paneltx.add(txContacto);
        paneltx.add(txMorada);
        paneltx.add(cbSexo);
        paneltx.add(txSaldo);
        paneltx.setBounds(170, 50, 200, 160);

        panelbt.setLayout(new FlowLayout());
        panelbt.add(gravar);
        panelbt.setBounds(112, 210, 200, 50);

        frame.add(lblClientes);
        frame.add(panellb);
        frame.add(paneltx);
        frame.add(panelbt);
        frame.add(voltar);
        frame.add(sp);

        //ActiomListener
        miArmazem.addActionListener(this);
        miProdutos.addActionListener(this);
        miFornecedores.addActionListener(this);
        miFiltro.addActionListener(this);
        voltar.addActionListener(this);
        miSair.addActionListener(this);
        miVerCli.addActionListener(this);
        gravar.addActionListener(this);
        miVendas.addActionListener(this);

        frame.setVisible(true);

        //Shortcuts
        menu.setMnemonic(KeyEvent.VK_M);
        miArmazem.setMnemonic(KeyEvent.VK_A);
        miProdutos.setMnemonic(KeyEvent.VK_P);
        miFornecedores.setMnemonic(KeyEvent.VK_F);
        miFiltro.setMnemonic(KeyEvent.VK_L);
        miSair.setMnemonic(KeyEvent.VK_S);
        MCliente.setMnemonic(KeyEvent.VK_C);
        miVerCli.setMnemonic(KeyEvent.VK_L);
        miVendas.setMnemonic(KeyEvent.VK_V);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == voltar) {
            if (TelaVendas.update == false) {
                frame.setVisible(false);
                new TelaListarClientes();
            } else {
                frame.setVisible(false);
                new TelaVendas();
            }
            TelaVendas.update = false;
        }
        if (ae.getSource() == miSair) {
            System.exit(0);
        }
        if (ae.getSource() == miVendas) {
            frame.setVisible(false);
            new TelaVendas();
        }
        if (ae.getSource() == miProdutos) {
            frame.setVisible(false);
            new TelaListar();
        }
        if (ae.getSource() == miFornecedores) {
            frame.setVisible(false);
            new TelaFornecedores();
        }

        if (ae.getSource() == miFiltro) {
            frame.setVisible(false);
            new TelaFiltro();
        }
        if (ae.getSource() == miArmazem) {
            frame.setVisible(false);
            new TelaArmazem();
        }
        if (ae.getSource() == miVerCli) {
            frame.setVisible(false);
            new TelaListarClientes();
        }
        if (ae.getSource() == gravar) {
            idp = rand.nextInt(8999) + 1000;
            if (idInexistente()) {
                if (TelaListarClientes.update == false) {
                    vazio();

                    if (vazio.isEmpty()) {

                        if (tratarErro() == true) {

                            DadosCliente dc = new DadosCliente(txNome.getText(), txMorada.getText(), (String) cbSexo.getSelectedItem(), idp, Integer.parseInt(txContacto.getText()), Float.parseFloat(txSaldo.getText()));
                            v.add(dc);
                            TelaListarClientes.addRow();
                            gravar();
                            JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso");
                            
                            if (TelaVendas.update == false) {
                                frame.setVisible(false);
                                new TelaListarClientes();
                            } else {
                                frame.setVisible(false);
                                new TelaVendas();
                            }
                        }
                    }
                } else {
                    DefaultTableModel model = (DefaultTableModel) TelaListarClientes.tabela.getModel();
                    int itemSelecionado = TelaListarClientes.tabela.getSelectedRow();
                    vazio.removeAllElements();
                    vazio();

                    if (vazio.isEmpty()) {
                        float saldo;

                        if (tratarErro() == true) {
                            int input = JOptionPane.showConfirmDialog(null, "Confirmar alterações?", "", JOptionPane.YES_NO_OPTION);
                            if (input == JOptionPane.YES_OPTION) {
                                atualizar(itemSelecionado);

                                model.getDataVector().removeAllElements();
                                TelaListarClientes.txtTabela();
                                TelaListarClientes.tabela.setRowSelectionInterval(itemSelecionado, itemSelecionado);

                                gravar();

                                frame.setVisible(false);
                                new TelaListarClientes();

                            }
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "O processo falhou");
            }
        }
    }

    public static void preecher() {
        txNome.setText(v.elementAt(TelaListarClientes.tabela.getSelectedRow()).getNome());
        txContacto.setText(Integer.toString(v.elementAt(TelaListarClientes.tabela.getSelectedRow()).getContacto()));
        txSaldo.setText(Float.toString(v.elementAt(TelaListarClientes.tabela.getSelectedRow()).getSaldo()));
        txMorada.setText(v.elementAt(TelaListarClientes.tabela.getSelectedRow()).getMorada());
        cbSexo.setSelectedItem(v.elementAt(TelaListarClientes.tabela.getSelectedRow()).getSexo());
    }

   
    
    public boolean tratarErro() {
        float saldo = 0;
        int contacto = 0;
        String s = "";

        try {
            contacto = Integer.parseInt(txContacto.getText());
        } catch (NumberFormatException e) {
        }

        try {
            saldo = Float.parseFloat(txSaldo.getText());
        } catch (NumberFormatException e) {
        }

        Vector vazio = new Vector();
        if (contacto == 0) {
            vazio.add("o contacto");
        }
        if (saldo == 0) {
            vazio.add("o saldo");
        }
        int cont = 0;
        for (int c = 0; c < vazio.size(); c++) {
            cont++;
        }
        if (cont == 1) {
            s += vazio.elementAt(0).toString();
        }
        if (cont == 2) {
            for (int c = 0; c < vazio.size() - 1; c++) {
                if (cont == 2) {
                    s += vazio.elementAt(c).toString() + " ";
                }
            }
            for (int c = vazio.size() - 1; c >= 0; c--) {
                s += "e " + vazio.elementAt(c).toString();
                break;
            }
        }

        if (saldo != 0 && contacto != 0) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Insira " + s + " corretamente");
        }
        vazio.removeAllElements();

        return false;
    }

    public void vazio() {
        if (("").equals(txNome.getText())) {
            vazio.add("nome");
            lblNome.setForeground(Color.red);
        } else {
            lblNome.setForeground(Color.black);
        }
        if (("").equals(txSaldo.getText())) {
            vazio.add("saldo");
            lblSaldo.setForeground(Color.red);
        } else {
            lblSaldo.setForeground(Color.black);
        }
        if (("").equals(txContacto.getText())) {
            vazio.add("contacto");
            lblNumero.setForeground(Color.red);
        } else {
            lblNumero.setForeground(Color.black);
        }
        if (("").equals(txMorada.getText())) {
            vazio.add("morada");
            lblMorada.setForeground(Color.red);
        } else {
            lblMorada.setForeground(Color.black);
        }
        if (cbSexo.getSelectedIndex() == -1) {
            vazio.add("sex");
            lblSexo.setForeground(Color.red);
        } else {
            lblSexo.setForeground(Color.black);
        }
    }

    public static void atualizar(int itemSelecionado) {
        v.elementAt(itemSelecionado).setNome(txNome.getText());
        v.elementAt(itemSelecionado).setContacto(Integer.parseInt(txContacto.getText()));
        v.elementAt(itemSelecionado).setSaldo(Float.parseFloat(txSaldo.getText()));
        v.elementAt(itemSelecionado).setSexo((String) cbSexo.getSelectedItem());
        v.elementAt(itemSelecionado).setMorada(txMorada.getText());
    }

    public static void gravar() {
        txtDados.gravar(v, "Object\\Clientes.dat");
    }

    private boolean idInexistente() {
        for (int c = 0; c < v.size(); c++) {
            if (v.elementAt(c).getId() == idp) {
                return false;
            }
        }
        return true;
    }
}
