package Armazem;

import Clientes.TelaListarClientes;
import Filtro.TelaFiltro;
import Fornecedores.TelaFornecedores;
import Produtos.TelaListar;
import Vendas.TelaVendas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import trabalhofinal.MenuPrincipal;

public class TelaArmazem implements ActionListener, MouseListener, KeyListener {

    private JFrame frame;
    private JSeparator sp, sp2;
    private JLabel lblNumero, lblNome, lblArmazem, lblBackground;
    private JTextField txNumero, txNome, txPesquisar;
    private JButton atualizar, gravar, voltar, apagar, pesquisar, filtro;
    private JPanel panellb, paneltx, panelbt, panelPesquisa, panelbt2;
    private JMenu menu;
    private JMenuItem miProdutos, miFornecedores, miFiltro, miSair, miClientes, miVendas;
    private JMenuBar menuBar;
    private JTable tabela, tabelaFiltro;
    private JScrollPane scroll, scroll2;
    private DefaultTableModel model;
    public static Vector<DadosArmazem> v = new Vector<DadosArmazem>();
    private Vector vazio = new Vector();
    private boolean update;
    private boolean confirmarFilro;
    private TableRowSorter<TableModel> rowSorter;

    public TelaArmazem() {
        frame = new JFrame();
        frame.setTitle("Sistema de Gestao");
        frame.setSize(550, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);

        //labels
        lblArmazem = new JLabel("Armazem");
        lblNumero = new JLabel("Numero:");
        lblNome = new JLabel("Nome:");

        lblArmazem.setHorizontalAlignment(JLabel.CENTER);
        lblNome.setHorizontalAlignment(JLabel.RIGHT);
        lblNumero.setHorizontalAlignment(JLabel.RIGHT);

        lblArmazem.setBounds(220, 0, 100, 50);
        lblArmazem.setFont(new Font("Arial", Font.BOLD, 22));
        //lblArmazem.setForeground(Color.white);

        ImageIcon imj = new ImageIcon("atualizar_16px.png");
        ImageIcon imj2 = new ImageIcon("save_16px.png");
        ImageIcon Iapagar = new ImageIcon("delete_16px.png");
        ImageIcon Ifiltro = new ImageIcon("slider_16px.png");
        ImageIcon Ipesquisa = new ImageIcon("search_16px.png");
        ImageIcon Ibackground = new ImageIcon("backArmazem.png");
        lblBackground = new JLabel(Ibackground);
        lblBackground.setBounds(0, 0, 550, 550);
        lblBackground.setHorizontalAlignment(JLabel.CENTER);

        //Separadores
        sp = new JSeparator();
        sp2 = new JSeparator();
        sp.setBounds(10, 40, 520, 5);
        sp2.setBounds(10, 190, 260, 5);

        //buttons
        atualizar = new JButton("Atualizar", imj);
        gravar = new JButton("Gravar", imj2);
        apagar = new JButton("Apagar", Iapagar);
        filtro = new JButton("", Ifiltro);
        pesquisar = new JButton("", Ipesquisa);
        voltar = new JButton("Voltar");
        voltar.setBounds(10, 313, 80, 25);
        gravar.setBounds(68, 110, 90, 25);

        //text fields
        txNumero = new JTextField();
        txNome = new JTextField();
        txPesquisar = new txPesquisar();

        //Menubar
        miClientes = new JMenuItem("Clientes");
        miProdutos = new JMenuItem("Produtos");
        miFornecedores = new JMenuItem("Fornecedores");
        miVendas = new JMenuItem("Vendas");
        miFiltro = new JMenuItem("Filtro");
        miProdutos = new JMenuItem("Produtos");
        miSair = new JMenuItem("Sair");
        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        frame.setJMenuBar(menuBar);
        menuBar.add(menu);
        menu.add(miClientes);
        menu.add(miProdutos);
        menu.add(miFornecedores);
        menu.add(miVendas);
        menu.add(miFiltro);
        menu.addSeparator();
        menu.add(miSair);

        //panels
        panellb = new JPanel();
        paneltx = new JPanel();
        panelbt = new JPanel();
        panelPesquisa = new JPanel();
        panelbt2 = new JPanel();

        panellb.setLayout(new GridLayout(2, 1, 10, 10));
        panellb.add(lblNumero);
        panellb.add(lblNome);
        panellb.setBounds(0, 50, 60, 55);

        paneltx.setLayout(new GridLayout(2, 1, 10, 10));
        paneltx.add(txNumero);
        paneltx.add(txNome);
        paneltx.setBounds(70, 50, 200, 55);

        panelbt.setLayout(new FlowLayout());
        panelbt.add(atualizar);
        panelbt.add(apagar);
        panelbt.setBounds(313, 308, 200, 30);

        panelPesquisa.setLayout(new GridLayout(1, 1));
        panelPesquisa.add(txPesquisar);
        panelPesquisa.setBounds(10, 200, 199, 25);

        panelbt2.setLayout(new GridLayout(1, 2));
        panelbt2.add(filtro);
        panelbt2.add(pesquisar);
        panelbt2.setBounds(210, 199, 60, 27);
        panelbt2.setBackground(new Color(0, 0, 0, 0));

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
        model.addColumn("Numero");
        model.addColumn("Nome");
        scroll = new JScrollPane(tabela);
        scroll.setBounds(300, 50, 220, 250);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(2);

        String[] coluna = {"Filtro"};
        Object[][] data = {{"Numero"}, {"Nome"}};
        tabelaFiltro = new JTable(data, coluna);
        tabelaFiltro.setRowSelectionInterval(1, 1);
        rowSorter = new TableRowSorter<>(tabela.getModel());

        tabelaFiltro.setTableHeader(null);
        tabelaFiltro.setShowHorizontalLines(false);
        tabelaFiltro.setShowVerticalLines(false);
        scroll2 = new JScrollPane(tabelaFiltro);
        scroll2.setBounds(210, 227, 45, 35);
        scroll2.setVisible(false);

        frame.add(lblArmazem);
        frame.add(panellb);
        frame.add(paneltx);
        frame.add(panelbt);
        frame.add(gravar);
        frame.add(voltar);
        frame.add(sp);
        frame.add(sp2);
        frame.add(panelPesquisa);
        frame.add(panelbt2);
        frame.add(scroll);
        frame.add(scroll2);

        //Action
        miClientes.addActionListener(this);
        miProdutos.addActionListener(this);
        miFornecedores.addActionListener(this);
        miFiltro.addActionListener(this);
        voltar.addActionListener(this);
        miSair.addActionListener(this);
        filtro.addActionListener(this);
        tabelaFiltro.addMouseListener(this);
        gravar.addActionListener(this);
        atualizar.addActionListener(this);
        apagar.addActionListener(this);
        pesquisar.addActionListener(this);
        miVendas.addActionListener(this);

        txPesquisar.addKeyListener(this);

        frame.setVisible(true);
        txtTabela();

        //Shortcuts
        menu.setMnemonic(KeyEvent.VK_M);
        miClientes.setMnemonic(KeyEvent.VK_C);
        miProdutos.setMnemonic(KeyEvent.VK_P);
        miFornecedores.setMnemonic(KeyEvent.VK_F);
        miFiltro.setMnemonic(KeyEvent.VK_L);
        miSair.setMnemonic(KeyEvent.VK_S);
        miVendas.setMnemonic(KeyEvent.VK_V);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == miVendas) {
            frame.setVisible(false);
            new TelaVendas();
        }
        if (ae.getSource() == voltar) {
            frame.setVisible(false);
            new MenuPrincipal();
        }
        if (ae.getSource() == miSair) {
            System.exit(0);
        }
        if (ae.getSource() == filtro) {
            scroll2.setVisible(true);
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
        if (ae.getSource() == miClientes) {
            frame.setVisible(false);
            new TelaListarClientes();
        }
        if (ae.getSource() == gravar) {
            if (update == false) {
                vazio();
                if (vazio.isEmpty()) {
                    if (tratarErro() == true) {
                        DadosArmazem da = new DadosArmazem(Integer.parseInt(txNumero.getText()), txNome.getText());
                        v.add(da);
                        addRow();
                        gravar();
                        JOptionPane.showMessageDialog(null, "Armazem adicionado com sucesso");
                    }
                }
            } else {
                DefaultTableModel model = (DefaultTableModel) tabela.getModel();
                int itemSelecionado = tabela.getSelectedRow();
                vazio.removeAllElements();
                vazio();

                if (vazio.isEmpty()) {
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
                }
            }
        }
        if (ae.getSource() == atualizar) {
            int ArmazemSelecionado = tabela.getSelectedRow();
            if (ArmazemSelecionado != -1) {
                preecher();
                gravar();
                update = true;
            } else {
                JOptionPane.showMessageDialog(null, "Selecione o armazem que deseja atualizar");
            }
        }
        if (ae.getSource() == apagar) {
            DefaultTableModel model = (DefaultTableModel) tabela.getModel();
            int itemRemovido = tabela.getSelectedRow();

            int armSelecionado = tabela.getSelectedRow();
            if (armSelecionado != -1) {
                if (itemRemovido != -1) {
                    int input = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o armazem?", "", JOptionPane.YES_NO_OPTION);
                    if (input == JOptionPane.YES_OPTION) {
                        model.removeRow(itemRemovido);
                        v.removeElementAt(itemRemovido);
                        gravar();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione o armazem que deseja remover");
            }
        }
        if (ae.getSource() == pesquisar) {
            DefaultTableModel model = (DefaultTableModel) tabela.getModel();
            tabela.setRowSorter(rowSorter);
            rowSorter.setRowFilter(RowFilter.regexFilter(txPesquisar.getText().trim()));
            if (confirmarFilro == true) {
                rowSorter.setRowFilter(RowFilter.regexFilter(txPesquisar.getText().trim(), 0));
            }
            if (confirmarFilro == false) {
                rowSorter.setRowFilter(RowFilter.regexFilter(txPesquisar.getText().trim(), 1));
            }
        }

    }

    public void preecher() {
        txNome.setText(v.elementAt(tabela.getSelectedRow()).getNome());
        txNumero.setText(Integer.toString(v.elementAt(tabela.getSelectedRow()).getNumero()));

    }

    public boolean tratarErro() {
        int codigo = 0;

        try {
            codigo = Integer.parseInt(txNumero.getText());
        } catch (NumberFormatException e) {
        }

        if (codigo != 0) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Insira o numero do armazem corretamente");
        }
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
    }

    public void atualizar(int itemSelecionado) {
        v.elementAt(itemSelecionado).setNumero(Integer.parseInt(txNumero.getText()));
        v.elementAt(itemSelecionado).setNome(txNome.getText());
    }

    public void gravar() {
        txtDadosArmazem.gravar(v, "Object\\DadosArmazem.dat");
    }

    public void addRow() {
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();

        Object rowData[] = new Object[2];
        for (int c = 0; c < TelaArmazem.v.size(); c++) {
            rowData[0] = TelaArmazem.v.get(c).getNumero();
            rowData[1] = TelaArmazem.v.get(c).getNome();
        }
        model.addRow(rowData);
    }

    public void txtTabela() {
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();

        Object rowData[] = new Object[2];
        for (int c = 0; c < TelaArmazem.v.size(); c++) {
            rowData[0] = TelaArmazem.v.get(c).getNumero();
            rowData[1] = TelaArmazem.v.get(c).getNome();
            model.addRow(rowData);
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {

        scroll2.setVisible(false);
        if (tabelaFiltro.getSelectedRow() == 0) {
            confirmarFilro = true;
        }
        if (tabelaFiltro.getSelectedRow() == 1) {
            confirmarFilro = false;
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if (txPesquisar.getText().trim().length() == 0) {
            rowSorter.setRowFilter(null);
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

}
