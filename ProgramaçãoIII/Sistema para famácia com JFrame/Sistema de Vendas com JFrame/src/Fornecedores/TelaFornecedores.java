package Fornecedores;

import Armazem.TelaArmazem;
import Armazem.txPesquisar;
import Clientes.TelaClientes;
import Clientes.TelaListarClientes;
import Filtro.TelaFiltro;
import Produtos.TelaListar;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import trabalhofinal.MenuPrincipal;

public class TelaFornecedores implements ActionListener {

    private JFrame frame;
    private JButton atualizar, gravar, btTabela, voltar, apagar;
    private JLabel lblCodigo, lblNome, lblNuit, lblFornecedor, background;
    private JTextField txCodigo, txNome, txNuit;
    private JPanel panellb, paneltx, panelbt;
    private JSeparator sp;
    private JMenu menu;
    private JMenuItem miArmazem, miProdutos, miClientes, miFiltro, miSair;
    private JMenuBar menuBar;
    private ImageIcon img;
    private JTable tabela;
    private JScrollPane scroll;
    private DefaultTableModel model;
    public static Vector<DadosFornecedores> v = new Vector<DadosFornecedores>();
    private Vector vazio = new Vector();
    private boolean update;

    public TelaFornecedores() {
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

        ImageIcon imj = new ImageIcon("atualizar_16px.png");
        ImageIcon imj2 = new ImageIcon("save_16px.png");
        ImageIcon Iapagar = new ImageIcon("delete_16px.png");

        //buttons
        atualizar = new JButton("Atualizar", imj);
        gravar = new JButton("Gravar", imj2);
        apagar = new JButton("Apagar", Iapagar);
        voltar = new JButton("Voltar");
        voltar.setBounds(10, 313, 80, 25);
        gravar.setBounds(68, 145, 90, 25);

        //labels
        lblFornecedor = new JLabel("Fornecedores");
        lblNome = new JLabel("Nome:");
        lblCodigo = new JLabel("Codigo:");
        lblNuit = new JLabel("NUIT:");
        lblFornecedor.setBounds(200, 0, 150, 50);
        lblFornecedor.setFont(new Font("Arial", Font.BOLD, 18));
        lblFornecedor.setHorizontalAlignment(JLabel.CENTER);

        lblNome.setHorizontalAlignment(JLabel.RIGHT);

        lblCodigo.setHorizontalAlignment(JLabel.RIGHT);

        lblNuit.setHorizontalAlignment(JLabel.RIGHT);

        img = new ImageIcon("backArmazem.png");
        background = new JLabel();
        background.setIcon(img);
        background.setBounds(0, 0, 550, 550);

        //textfields
        txNome = new JTextField();
        txCodigo = new JTextField();
        txNuit = new JTextField();

        //panels
        panellb = new JPanel();
        paneltx = new JPanel();
        panelbt = new JPanel();

        panellb.setLayout(new GridLayout(3, 1, 10, 10));
        panellb.add(lblNome);
        panellb.add(lblNuit);
        panellb.add(lblCodigo);
        panellb.setBounds(0, 50, 60, 90);

        paneltx.setLayout(new GridLayout(3, 1, 10, 10));
        paneltx.add(txNome);
        paneltx.add(txNuit);
        paneltx.add(txCodigo);
        paneltx.setBounds(70, 50, 200, 90);

        panelbt.setLayout(new FlowLayout());
        panelbt.add(atualizar);
        panelbt.add(apagar);
        panelbt.setBounds(313, 308, 200, 30);

        //menu
        miArmazem = new JMenuItem("Armazem");
        miProdutos = new JMenuItem("Produtos");
        miClientes = new JMenuItem("Clientes");
        miFiltro = new JMenuItem("Filtro");
        miProdutos = new JMenuItem("Produtos");
        miSair = new JMenuItem("Sair");
        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        frame.setJMenuBar(menuBar);
        menuBar.add(menu);
        menu.add(miClientes);
        menu.add(miArmazem);
        menu.add(miProdutos);
        menu.add(miFiltro);
        menu.addSeparator();
        menu.add(miSair);

        //Table
        tabela = new JTable();
        tabela.setShowVerticalLines(false);
        tabela.setModel(new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        model = (DefaultTableModel) tabela.getModel();
        model.addColumn("Nome");
        model.addColumn("Nuit");
        model.addColumn("Codigo");
        scroll = new JScrollPane(tabela);
        scroll.setBounds(300, 50, 220, 250);

        //frame control
        frame.add(lblFornecedor);
        frame.add(panellb);
        frame.add(paneltx);
        frame.add(panelbt);
        frame.add(sp);
        frame.add(gravar);
        frame.add(voltar);
        frame.add(scroll);
        frame.setVisible(true);
        txtTabela();

        //actionListener
        miClientes.addActionListener(this);
        miProdutos.addActionListener(this);
        miFiltro.addActionListener(this);
        miArmazem.addActionListener(this);
        voltar.addActionListener(this);
        miSair.addActionListener(this);
        gravar.addActionListener(this);
        atualizar.addActionListener(this);
        apagar.addActionListener(this);

        //Shortcuts
        menu.setMnemonic(KeyEvent.VK_M);
        miClientes.setMnemonic(KeyEvent.VK_C);
        miProdutos.setMnemonic(KeyEvent.VK_P);
        miArmazem.setMnemonic(KeyEvent.VK_A);
        miFiltro.setMnemonic(KeyEvent.VK_L);
        miSair.setMnemonic(KeyEvent.VK_S);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == voltar) {
            frame.setVisible(false);
            new MenuPrincipal();
        }
        if (ae.getSource() == miSair) {
            System.exit(0);
        }
        if (ae.getSource() == miProdutos) {
            frame.setVisible(false);
            new TelaListar();
        }
        if (ae.getSource() == miFiltro) {
            frame.setVisible(false);
            new TelaFiltro();
        }

        if (ae.getSource() == miArmazem) {
            frame.setVisible(false);
            new TelaArmazem();
        }
        if (ae.getSource() == miClientes) {
            frame.setVisible(false);
            new TelaListarClientes();
        }
        if (ae.getSource() == gravar) {

            if (update == false) {
                vazio();
                if (vazio.isEmpty()) {
                    if (verificarNuit() == false) {

                        if (tratarErro() == true) {
                            DadosFornecedores df = new DadosFornecedores(Integer.parseInt(txCodigo.getText()), Integer.parseInt(txNuit.getText()), txNome.getText());
                            v.add(df);
                            addRow();
                            gravar();
                            JOptionPane.showMessageDialog(null, "Fornecedor adicionado com sucesso");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Insira um NUIT diferente.");
                        txNuit.setText("");
                    }
                }
            } else {
                DefaultTableModel model = (DefaultTableModel) tabela.getModel();
                int itemSelecionado = tabela.getSelectedRow();
                vazio.removeAllElements();
                vazio();

                if (vazio.isEmpty()) {
                    if (verificarNuit() == false) {
                        if (tratarErro() == true) {
                            int input = JOptionPane.showConfirmDialog(null, "Confirmar alterações?", "", JOptionPane.YES_NO_OPTION);
                            if (input == JOptionPane.YES_OPTION) {
                                atualizar(itemSelecionado);

                                model.getDataVector().removeAllElements();
                                txtTabela();
                                tabela.setRowSelectionInterval(itemSelecionado, itemSelecionado);

                                gravar();
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Insira um NUIT diferente.");
                        txNuit.setText("");
                    }
                }

                txNome.setText("");
                txCodigo.setText("");
                txNuit.setText("");

            }

        }
        if (ae.getSource() == atualizar) {
            int ArmazemSelecionado = tabela.getSelectedRow();
            if (ArmazemSelecionado != -1) {
                preecher();
                gravar();
                update = true;
            } else {
                JOptionPane.showMessageDialog(null, "Selecione o fornecedor que deseja atualizar");
            }
        }
        if (ae.getSource() == apagar) {
            DefaultTableModel model = (DefaultTableModel) tabela.getModel();
            int itemRemovido = tabela.getSelectedRow();

            int FornecedorSelecionado = tabela.getSelectedRow();
            if (FornecedorSelecionado != -1) {

                if (itemRemovido != -1) {
                    int input = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o fornecedor?", "", JOptionPane.YES_NO_OPTION);
                    if (input == JOptionPane.YES_OPTION) {
                        model.removeRow(itemRemovido);
                        v.removeElementAt(itemRemovido);
                        gravar();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione o fornecedor que deseja remover");
            }
        }

    }

    public void preecher() {
        txNome.setText(v.elementAt(tabela.getSelectedRow()).getNome());
        txCodigo.setText(Integer.toString(v.elementAt(tabela.getSelectedRow()).getCodigo()));
        txNuit.setText(Integer.toString(v.elementAt(tabela.getSelectedRow()).getNuit()));
    }

    public boolean tratarErro() {
        int codigo = 0, nuit = 0;
        String s = "";

        try {
            codigo = Integer.parseInt(txCodigo.getText());
        } catch (NumberFormatException e) {
        }
        try {
            nuit = Integer.parseInt(txNuit.getText());
        } catch (NumberFormatException e) {
        }

        Vector vazio = new Vector();
        if (codigo == 0) {
            vazio.add("o contacto");
        }
        if (nuit == 0) {
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

        if (codigo != 0 && nuit != 0) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Insira o numero do fornecedor corretamente");
        }
        return false;
    }

    public void vazio() {
        if (("").equals(txCodigo.getText())) {
            vazio.add("codigo");
            lblCodigo.setForeground(Color.red);
        } else {
            lblCodigo.setForeground(Color.black);
        }
        if (("").equals(txNuit.getText())) {
            vazio.add("nuit");
            lblNuit.setForeground(Color.red);
        } else {
            lblNuit.setForeground(Color.black);
        }
        if (("").equals(txNome.getText())) {
            vazio.add("nome");
            lblNome.setForeground(Color.red);
        } else {
            lblNome.setForeground(Color.black);
        }
    }

    public void atualizar(int itemSelecionado) {
        v.elementAt(itemSelecionado).setCodigo(Integer.parseInt(txCodigo.getText()));
        v.elementAt(itemSelecionado).setNuit(Integer.parseInt(txNuit.getText()));
        v.elementAt(itemSelecionado).setNome(txNome.getText());
    }

    public void gravar() {
        txtDadosFornecedores.gravar(v, "Object\\DadosFornecedores.dat");
    }

    public void addRow() {
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();

        Object rowData[] = new Object[3];
        for (int c = 0; c < v.size(); c++) {
            rowData[2] = v.get(c).getCodigo();
            rowData[1] = v.get(c).getNuit();
            rowData[0] = v.get(c).getNome();
        }
        model.addRow(rowData);
    }

    public void txtTabela() {
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();

        Object rowData[] = new Object[3];
        for (int c = 0; c < v.size(); c++) {
            rowData[2] = v.get(c).getCodigo();
            rowData[1] = v.get(c).getNuit();
            rowData[0] = v.get(c).getNome();
            model.addRow(rowData);
        }
    }

    public boolean verificarNuit() {
        for (int i = 0; v.size() > i; i++) {
            if (v.elementAt(i).getNuit() == Integer.parseInt(txNuit.getText())) {

                return true;
            }

        }
        return false;

    }
}
