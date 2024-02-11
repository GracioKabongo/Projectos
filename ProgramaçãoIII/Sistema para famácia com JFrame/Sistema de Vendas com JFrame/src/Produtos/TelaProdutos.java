package Produtos;

import Armazem.TelaArmazem;
import Clientes.TelaClientes;
import Filtro.TelaFiltro;
import Fornecedores.TelaFornecedores;
import Vendas.TelaVendas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import trabalhofinal.MenuPrincipal;

public class TelaProdutos implements ActionListener {

    private JFrame frame;
    private JLabel lblProdutos, lblNumero, lblNome, lblArmazem, lblQuantidade, lblStock, lblFornecedor, lblPreco, lblPrazo;
    private JButton gravar, voltar;
    private static JTextField txNumero, txNome, txQuantidade, txStock, txPreco;
    private static JComboBox cbFornecedores, cbArmazem, cbDia, cbMes, cbAno;
    private JTable tabela;
    private JPanel panellb, paneltx, panelbt, panelpz;
    private JSeparator sp;
    private JMenu menu, Mprodutos;
    private JMenuItem miArmazem, miClientes, miFornecedores, miFiltro, miSair, miVerPro, miVendas;
    private JMenuBar menuBar;
    public static Vector<DadosProdutos> v = new Vector<DadosProdutos>();
    private Vector vazio = new Vector();

    public TelaProdutos() {
        frame = new JFrame();
        frame.setTitle("Sistema de Gestao");
        frame.setSize(550, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        sp = new JSeparator();

        //imagem
        ImageIcon Ibackground = new ImageIcon("backArmazem.png");
        ImageIcon imj2 = new ImageIcon("save_16px.png");

        //labels
        lblProdutos = new JLabel("Produtos");
        lblNumero = new JLabel("Codigo:");
        lblNome = new JLabel("Nome:");
        lblArmazem = new JLabel("Armazem:");
        lblQuantidade = new JLabel("Quantidade:");
        lblStock = new JLabel("Stock Minimo:");
        lblFornecedor = new JLabel("Fornecedor:");
        lblPreco = new JLabel("Preco:");
        lblPrazo = new JLabel("Prazo de validade:");

        lblProdutos.setHorizontalAlignment(JLabel.CENTER);
        lblProdutos.setBounds(220, 0, 100, 50);
        lblProdutos.setFont(new Font("Arial", Font.BOLD, 18));
        lblNome.setHorizontalAlignment(JLabel.RIGHT);
        lblNumero.setHorizontalAlignment(JLabel.RIGHT);
        lblArmazem.setHorizontalAlignment(JLabel.RIGHT);
        lblQuantidade.setHorizontalAlignment(JLabel.RIGHT);
        lblStock.setHorizontalAlignment(JLabel.RIGHT);
        lblFornecedor.setHorizontalAlignment(JLabel.RIGHT);
        lblPreco.setHorizontalAlignment(JLabel.RIGHT);
        lblPrazo.setHorizontalAlignment(JLabel.RIGHT);

        //buttons
        gravar = new JButton("Gravar", imj2);
        voltar = new JButton("Voltar");
        gravar.setBounds(95, 313, 85, 25);
        voltar.setBounds(10, 313, 80, 25);

        //text fields
        txNumero = new JTextField();
        txNome = new JTextField();
        txQuantidade = new JTextField();
        txStock = new JTextField("5");
        txPreco = new JTextField();

        //comboBox
        Vector cb = new Vector();
        for (int c = 0; c < TelaFornecedores.v.size(); c++) {
            cb.add(TelaFornecedores.v.elementAt(c).getNome());
        }
        cbFornecedores = new JComboBox(cb);
        cbFornecedores.setSelectedIndex(-1);

        Vector cbA = new Vector();
        for (int c = 0; c < TelaArmazem.v.size(); c++) {
            cbA.add(TelaArmazem.v.elementAt(c).getNumero());
        }
        cbArmazem = new JComboBox(cbA);
        cbArmazem.setSelectedIndex(-1);

        Vector dia = new Vector();
        for (int c = 0; c < 31; c++) {
            dia.add(c + 1);
        }
        Vector mes = new Vector();
        for (int c = 0; c < 12; c++) {
            mes.add(c + 1);
        }

        String[] ano = {"2021", "2022", "2023", "2024", "2025", "2026", "2027",
            "2028", "2029", "2030"};

        cbDia = new JComboBox(dia);
        cbMes = new JComboBox(mes);
        cbAno = new JComboBox(ano);

        cbDia.setBounds(0, 0, 45, 20);
        cbMes.setBounds(50, 0, 45, 20);
        cbAno.setBounds(100, 0, 70, 20);

        cbDia.setSelectedIndex(-1);
        cbMes.setSelectedIndex(-1);
        cbAno.setSelectedIndex(-1);

        //Menubar
        miArmazem = new JMenuItem("Armazem");
        miClientes = new JMenuItem("Clientes");
        miFornecedores = new JMenuItem("Fornecedores");
        miVendas = new JMenuItem("Vendas");
        miFiltro = new JMenuItem("Filtro");
        miSair = new JMenuItem("Sair");
        menuBar = new JMenuBar();
        menu = new JMenu("Menu");

        frame.setJMenuBar(menuBar);
        menuBar.add(menu);
        menu.add(miClientes);
        menu.add(miArmazem);
        menu.add(miFornecedores);
        menu.add(miVendas);
        menu.add(miFiltro);
        menu.addSeparator();
        menu.add(miSair);

        Mprodutos = new JMenu("Produtos");
        miVerPro = new JMenuItem("Listar");
        menuBar.add(Mprodutos);
        Mprodutos.add(miVerPro);

        //panels
        panellb = new JPanel();
        paneltx = new JPanel();
        panelbt = new JPanel();
        panelpz = new JPanel();

        panellb.setLayout(new GridLayout(8, 1, 10, 10));
        panellb.add(lblNome);
        panellb.add(lblNumero);
        panellb.add(lblArmazem);
        panellb.add(lblQuantidade);
        panellb.add(lblStock);
        panellb.add(lblPreco);
        panellb.add(lblFornecedor);
        panellb.add(lblPrazo);
        panellb.setBounds(60, 50, 100, 250);
        sp.setBounds(10, 40, 525, 5);

        panelpz.setLayout(null);

        panelpz.add(cbDia);
        panelpz.add(cbMes);
        panelpz.add(cbAno);

        paneltx.setLayout(new GridLayout(8, 1, 10, 10));
        paneltx.add(txNome);
        paneltx.add(txNumero);
        paneltx.add(cbArmazem);
        paneltx.add(txQuantidade);
        paneltx.add(txStock);
        paneltx.add(txPreco);
        paneltx.add(cbFornecedores);
        paneltx.add(panelpz);
        paneltx.setBounds(170, 50, 200, 250);

        frame.add(lblProdutos);
        frame.add(panellb);
        frame.add(paneltx);
        frame.add(panelbt);
        frame.add(gravar);
        frame.add(voltar);
        frame.add(sp);

        //action listener
        miClientes.addActionListener(this);
        miFornecedores.addActionListener(this);
        miFiltro.addActionListener(this);
        miArmazem.addActionListener(this);
        voltar.addActionListener(this);
        miSair.addActionListener(this);
        miVerPro.addActionListener(this);
        gravar.addActionListener(this);
        miVendas.addActionListener(this);

        frame.setVisible(true);

        //Shortcuts
        menu.setMnemonic(KeyEvent.VK_M);
        miArmazem.setMnemonic(KeyEvent.VK_A);
        miClientes.setMnemonic(KeyEvent.VK_C);
        miFornecedores.setMnemonic(KeyEvent.VK_F);
        miFiltro.setMnemonic(KeyEvent.VK_L);
        miSair.setMnemonic(KeyEvent.VK_S);
        Mprodutos.setMnemonic(KeyEvent.VK_P);
        miVendas.setMnemonic(KeyEvent.VK_V);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == voltar) {
            frame.setVisible(false);
            new TelaListar();
        }
        if (ae.getSource() == miVendas) {
            frame.setVisible(false);
            new TelaVendas();
        }
        if (ae.getSource() == miSair) {
            System.exit(0);
        }
        if (ae.getSource() == miVerPro) {
            frame.dispose();
            new TelaListar();
        }
        if (ae.getSource() == miFornecedores) {
            frame.setVisible(false);
            new TelaListar();
        }
        if (ae.getSource() == miFiltro) {
            frame.setVisible(false);
            new TelaFiltro();
            TelaFiltro.addRow();
        }

        if (ae.getSource() == miArmazem) {
            frame.setVisible(false);
            new TelaArmazem();
        }
        if (ae.getSource() == miClientes) {
            frame.setVisible(false);
            new TelaClientes();
        }
        if (ae.getSource() == gravar) {

            if (TelaListar.update == false) {
                vazio();

                if (vazio.isEmpty()) {
                    if (verificarCodigo() == false) {
                        if (tratarErro() == true) {

                            DadosProdutos dc = new DadosProdutos(txNome.getText(), (String) cbFornecedores.getSelectedItem(),
                                    Integer.parseInt(txNumero.getText()), (int) cbArmazem.getSelectedItem(),
                                    Integer.parseInt(txQuantidade.getText()), Integer.parseInt(txStock.getText()),
                                    Float.parseFloat(txPreco.getText()), (int) cbDia.getSelectedItem(),
                                    (int) cbMes.getSelectedItem(), (String) cbAno.getSelectedItem());
                            v.add(dc);
                            TelaListar.addRow();
                            gravar();
                            JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso");
                            frame.setVisible(false);
                            new TelaListar();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Insira um Codigo diferente.");
                    }
                }
            } else {
                DefaultTableModel model = (DefaultTableModel) TelaListar.tabela.getModel();

                int itemSelecionado = TelaListar.tabela.getSelectedRow();
                vazio.removeAllElements();
                vazio();

                if (vazio.isEmpty()) {
                    if (verificarCodigo() == false) {
                        if (tratarErro() == true) {
                            int input = JOptionPane.showConfirmDialog(null, "Confirmar alterações?", "", JOptionPane.YES_NO_OPTION);
                            if (input == JOptionPane.YES_OPTION) {
                                atualizar(itemSelecionado);

                                model.getDataVector().removeAllElements();
                                TelaListar.txtTabela();
                                TelaListar.tabela.setRowSelectionInterval(itemSelecionado, itemSelecionado);

                                gravar();

                                frame.setVisible(false);
                                new TelaListar();

                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Insira um Codigo diferente.");
                    }
                }
            }

        }
    }

    public static void codigo() {
        v.elementAt(TelaListar.tabela.getSelectedRow()).setNumero(0);
    }

    public static void preecher() {
        txNome.setText(v.elementAt(TelaListar.tabela.getSelectedRow()).getNome());
        cbFornecedores.setSelectedItem(v.elementAt(TelaListar.tabela.getSelectedRow()).getFornecedor());
        txNumero.setText(Integer.toString(v.elementAt(TelaListar.tabela.getSelectedRow()).getNumero()));
        cbArmazem.setSelectedItem(v.elementAt(TelaListar.tabela.getSelectedRow()).getArmazem());
        txQuantidade.setText(Integer.toString(v.elementAt(TelaListar.tabela.getSelectedRow()).getQuantidade()));
        txStock.setText(Integer.toString(v.elementAt(TelaListar.tabela.getSelectedRow()).getStock()));
        txPreco.setText(Float.toString(v.elementAt(TelaListar.tabela.getSelectedRow()).getPreco()));
        cbDia.setSelectedItem(v.elementAt(TelaListar.tabela.getSelectedRow()).getDia());
        cbMes.setSelectedItem(v.elementAt(TelaListar.tabela.getSelectedRow()).getMes());
        cbAno.setSelectedItem(v.elementAt(TelaListar.tabela.getSelectedRow()).getAno());

    }

    public boolean tratarErro() {
        float preco = 0;
        int stock = 0, numero = 0, qtd = 0;
        String s = "";

        try {
            numero = Integer.parseInt(txNumero.getText());
        } catch (NumberFormatException e) {
        }

        try {
            qtd = Integer.parseInt(txQuantidade.getText());
        } catch (NumberFormatException e) {
        }
        try {
            stock = Integer.parseInt(txStock.getText());
        } catch (NumberFormatException e) {
        }
        try {
            preco = Float.parseFloat(txPreco.getText());
        } catch (NumberFormatException e) {
        }

        Vector vazio = new Vector();
        if (numero == 0) {
            vazio.add("o numero");
        }
        if (qtd == 0) {
            vazio.add("a quantidade");
        }
        if (stock == 0) {
            vazio.add("o stock");
        }

        if (preco == 0) {
            vazio.add("o preco");
        }
        int cont = 0, ct = 0;

        for (int c = 0; c < vazio.size(); c++) {
            ct++;
        }
        if (ct == 1) {
            s += vazio.elementAt(0).toString();
        } else {
            for (int c = 0; c < vazio.size() - 1; c++) {
                cont++;
                s += vazio.elementAt(c).toString();
                if (cont < vazio.size() - 1) {
                    s += ", ";
                }
            }
            for (int c = vazio.size() - 1; c >= 0; c--) {
                s += " e " + vazio.elementAt(c).toString();
                break;
            }
        }

        if (preco != 0 && numero != 0 && stock != 0 && qtd != 0) {
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
        if (("").equals(txNumero.getText())) {
            vazio.add("numero");
            lblNumero.setForeground(Color.red);
        } else {
            lblNumero.setForeground(Color.black);
        }
        if (cbArmazem.getSelectedIndex() == -1) {
            vazio.add("armazem");
            lblArmazem.setForeground(Color.red);
        } else {
            lblArmazem.setForeground(Color.black);
        }
        if (("").equals(txQuantidade.getText())) {
            vazio.add("quantidade");
            lblQuantidade.setForeground(Color.red);
        } else {
            lblQuantidade.setForeground(Color.black);
        }
        if (("").equals(txStock.getText())) {
            vazio.add("stock");
            lblStock.setForeground(Color.red);
        } else {
            lblStock.setForeground(Color.black);
        }
        if (("").equals(txPreco.getText())) {
            vazio.add("preco");
            lblPreco.setForeground(Color.red);
        } else {
            lblPreco.setForeground(Color.black);
        }
        if (cbFornecedores.getSelectedIndex() == -1) {
            vazio.add("fornecedores");
            lblFornecedor.setForeground(Color.red);
        } else {
            lblFornecedor.setForeground(Color.black);
        }

        if (cbDia.getSelectedIndex() == -1) {
            vazio.add("dia");
            lblPrazo.setForeground(Color.red);
        } else {
            lblPrazo.setForeground(Color.black);
        }

        if (cbMes.getSelectedIndex() == -1) {
            vazio.add("mes");
            lblPrazo.setForeground(Color.red);
        } else {
            lblPrazo.setForeground(Color.black);
        }

        if (cbAno.getSelectedIndex() == -1) {
            vazio.add("ano");
            lblPrazo.setForeground(Color.red);
        } else {
            lblPrazo.setForeground(Color.black);
        }

    }

    public static void gravar() {
        txtDadosProdutos.gravar(v, "Object\\DadosProdutos.dat");
    }

    public static void atualizar(int itemSelecionado) {
        v.elementAt(itemSelecionado).setNome(txNome.getText());
        v.elementAt(itemSelecionado).setFornecedor((String) cbFornecedores.getSelectedItem());
        v.elementAt(itemSelecionado).setNumero(Integer.parseInt(txNumero.getText()));
        v.elementAt(itemSelecionado).setArmazem((int) cbArmazem.getSelectedItem());
        v.elementAt(itemSelecionado).setQuantidade(Integer.parseInt(txQuantidade.getText()));
        v.elementAt(itemSelecionado).setStock(Integer.parseInt(txStock.getText()));
        v.elementAt(itemSelecionado).setPreco(Float.parseFloat(txPreco.getText()));
        v.elementAt(itemSelecionado).setDia((int) cbDia.getSelectedItem());
        v.elementAt(itemSelecionado).setMes((int) cbMes.getSelectedItem());
        v.elementAt(itemSelecionado).setAno((String) cbAno.getSelectedItem());
    }

    public boolean verificarCodigo() {
        for (int i = 0; v.size() > i; i++) {
            if (v.elementAt(i).getNumero() == Integer.parseInt(txNumero.getText())) {

                return true;
            }

        }
        return false;

    }

}
