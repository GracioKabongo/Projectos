package Clientes;

import Produtos.*;
import Armazem.TelaArmazem;
import Armazem.txPesquisar;
import Filtro.TelaFiltro;
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

public class TelaListarClientes implements ActionListener, MouseListener, KeyListener {

    private JFrame frame;
    private JSeparator sp;
    public static JTable tabela, tabelaFiltro;
    private JScrollPane scroll, scroll2;
    private DefaultTableModel model;
    private JMenu menu, MCliente;
    private JMenuItem miArmazem, miProdutos, miFornecedores, miFiltro, miSair, miAdicionar, miVendas;
    private JMenuBar menuBar;
    private JButton atualizar, voltar, apagar, pesquisar, filtro;
    private JPanel panelbt, panelPesquisa, panelbt2;
    private JLabel lblBackground;
    private JTextField txPesquisar;
    private JLabel lblProdutos;
    public static boolean update;
    private boolean confirmarFilro;
    private TableRowSorter<TableModel> rowSorter;

    public TelaListarClientes() {
        frame = new JFrame();
        frame.setTitle("Sistema de Gestao");
        frame.setSize(550, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);

        //imagem
        ImageIcon Ibackground = new ImageIcon("backArmazem.png");
        lblBackground = new JLabel();
        lblBackground.setIcon(Ibackground);
        lblBackground.setBounds(0, 0, 550, 550);
        lblBackground.setHorizontalAlignment(JLabel.CENTER);

        lblProdutos = new JLabel("Clientes");
        lblProdutos.setHorizontalAlignment(JLabel.CENTER);
        lblProdutos.setBounds(220, 0, 100, 50);
        lblProdutos.setFont(new Font("Arial", Font.BOLD, 22));
        //lblProdutos.setForeground(Color.white);

        //Separador
        sp = new JSeparator();
        sp.setBounds(10, 40, 525, 5);

        //Menubar
        miArmazem = new JMenuItem("Armazem");
        miProdutos = new JMenuItem("Produtos");
        miFornecedores = new JMenuItem("Fornecedores");
        miVendas = new JMenuItem("Vendas");
        miFiltro = new JMenuItem("Filtro");
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
        miAdicionar = new JMenuItem("Listar");
        miAdicionar = new JMenuItem("Adicionar");
        menuBar.add(MCliente);
        MCliente.add(miAdicionar);

        //Barra de pesquisa
        panelPesquisa = new JPanel();
        panelbt2 = new JPanel();
        txPesquisar = new txPesquisar();
        ImageIcon Ifiltro = new ImageIcon("slider_16px.png");
        ImageIcon Ipesquisa = new ImageIcon("search_16px.png");

        filtro = new JButton("", Ifiltro);
        pesquisar = new JButton("", Ipesquisa);

        panelPesquisa.setLayout(new GridLayout(1, 1));
        panelPesquisa.add(txPesquisar);
        panelPesquisa.setBounds(10, 51, 199, 25);
        panelPesquisa.setBackground(new Color(0, 0, 0, 0));

        panelbt2.setLayout(new GridLayout(1, 2));
        panelbt2.add(filtro);
        panelbt2.add(pesquisar);
        panelbt2.setBounds(210, 50, 60, 27);
        panelbt2.setBackground(new Color(0, 0, 0, 0));

        //Tabela
        tabela = new JTable();
        tabela.setShowVerticalLines(false);
        tabela.setModel(new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        model = (DefaultTableModel) tabela.getModel();
        model.addColumn("ID");
        model.addColumn("Nome");
        model.addColumn("Contacto");
        model.addColumn("Morada");
        model.addColumn("Sexo");
        model.addColumn("Saldo");
        scroll = new JScrollPane(tabela);
        scroll.setBounds(10, 85, 525, 218);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(70);
        tabela.getColumnModel().getColumn(4).setPreferredWidth(40);

        String[] coluna = {"Filtro"};
        Object[][] data = {{"Numero"}, {"Nome"}};
        tabelaFiltro = new JTable(data, coluna);

        tabelaFiltro.setTableHeader(null);
        tabelaFiltro.setShowHorizontalLines(false);
        tabelaFiltro.setShowVerticalLines(false);
        tabelaFiltro.setRowSelectionInterval(1, 1);
        scroll2 = new JScrollPane(tabelaFiltro);
        scroll2.setBounds(210, 78, 45, 35);
        scroll2.setVisible(false);

        rowSorter = new TableRowSorter<>(tabela.getModel());

        ImageIcon imj = new ImageIcon("atualizar_16px.png");
        ImageIcon Iapagar = new ImageIcon("delete_16px.png");

        //Botoes
        voltar = new JButton("Voltar");
        voltar.setBounds(10, 313, 80, 25);
        atualizar = new JButton("Atualizar", imj);
        apagar = new JButton("Apagar", Iapagar);

        //panel
        panelbt = new JPanel();
        panelbt.setLayout(new FlowLayout());
        panelbt.add(atualizar);
        panelbt.add(apagar);
        panelbt.setBounds(313, 308, 200, 30);
        panelbt.setBackground(new Color(0, 0, 0, 0));

        frame.add(scroll2);
        frame.add(scroll);

        frame.add(lblProdutos);
        frame.add(sp);
        frame.add(voltar);
        frame.add(panelbt);
        frame.add(panelPesquisa);
        frame.add(panelbt2);
        frame.setVisible(true);
        txtTabela();

        miProdutos.addActionListener(this);
        miFornecedores.addActionListener(this);
        miFiltro.addActionListener(this);
        miArmazem.addActionListener(this);
        voltar.addActionListener(this);
        miSair.addActionListener(this);
        miAdicionar.addActionListener(this);
        filtro.addActionListener(this);
        atualizar.addActionListener(this);
        apagar.addActionListener(this);
        pesquisar.addActionListener(this);
        tabelaFiltro.addMouseListener(this);
        miVendas.addActionListener(this);

        txPesquisar.addKeyListener(this);

        //Shortcuts
        menu.setMnemonic(KeyEvent.VK_M);
        miArmazem.setMnemonic(KeyEvent.VK_A);
        miProdutos.setMnemonic(KeyEvent.VK_P);
        miFornecedores.setMnemonic(KeyEvent.VK_F);
        miFiltro.setMnemonic(KeyEvent.VK_L);
        miSair.setMnemonic(KeyEvent.VK_S);
        MCliente.setMnemonic(KeyEvent.VK_C);
        miAdicionar.setMnemonic(KeyEvent.VK_D);
        miVendas.setMnemonic(KeyEvent.VK_V);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == voltar) {
            frame.setVisible(false);
            new MenuPrincipal();
        }
        if (ae.getSource() == miVendas) {
            frame.setVisible(false);
            new TelaVendas();
        }
        if (ae.getSource() == miSair) {
            System.exit(0);
        }
        if (ae.getSource() == miFornecedores) {
            frame.setVisible(false);
            new TelaListarClientes();
        }
        if (ae.getSource() == miFiltro) {
            frame.setVisible(false);
            new TelaFiltro();
        }

        if (ae.getSource() == miArmazem) {
            frame.setVisible(false);
            new TelaArmazem();
        }
        if (ae.getSource() == miProdutos) {
            frame.setVisible(false);
            new TelaProdutos();
        }
        if (ae.getSource() == miAdicionar) {
            frame.setVisible(false);
            new TelaClientes();
        }
        if (ae.getSource() == filtro) {
            scroll2.setVisible(true);
        }
        if (ae.getSource() == atualizar) {
            int clienteSelecionado = tabela.getSelectedRow();
            if (clienteSelecionado != -1) {
                new TelaClientes();
                TelaClientes.preecher();
                frame.setVisible(false);
                update = true;
            } else {
                JOptionPane.showMessageDialog(null, "Selecione o cliente que deseja atualizar");
            }

        }
        if (ae.getSource() == apagar) {
            DefaultTableModel model = (DefaultTableModel) tabela.getModel();
            int itemRemovido = tabela.getSelectedRow();

            int cliSelecionado = tabela.getSelectedRow();
            if (cliSelecionado != -1) {
                if (itemRemovido != -1) {
                    int input = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o cliente?", "", JOptionPane.YES_NO_OPTION);
                    if (input == JOptionPane.YES_OPTION) {
                        model.removeRow(itemRemovido);
                        TelaClientes.v.removeElementAt(itemRemovido);
                        TelaClientes.gravar();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione o cliente que deseja remover");
            }
        }
        if (ae.getSource() == pesquisar) {
            DefaultTableModel model = (DefaultTableModel) TelaListarClientes.tabela.getModel();
            TelaListarClientes.tabela.setRowSorter(rowSorter);
            if (confirmarFilro == true) {
                rowSorter.setRowFilter(RowFilter.regexFilter(txPesquisar.getText().trim(), 0));
            }
            if (confirmarFilro == false) {
                rowSorter.setRowFilter(RowFilter.regexFilter(txPesquisar.getText().trim(), 1));
            }
        }
    }

    public static void addRow() {
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();

        Object rowData[] = new Object[6];
        for (int c = 0; c < TelaClientes.v.size(); c++) {
            rowData[0] = TelaClientes.v.get(c).getNome();
            rowData[1] = TelaClientes.v.get(c).getMorada();
            rowData[2] = TelaClientes.v.get(c).getSexo();
            rowData[3] = TelaClientes.v.get(c).getId();
            rowData[4] = TelaClientes.v.get(c).getContacto();
            rowData[5] = TelaClientes.v.get(c).getSaldo();

        }
        model.addRow(rowData);
    }

    public static void txtTabela() {
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();

        Object rowData[] = new Object[6];
        for (int c = 0; c < TelaClientes.v.size(); c++) {
            rowData[0] = TelaClientes.v.get(c).getId();
            rowData[1] = TelaClientes.v.get(c).getNome();
            rowData[3] = TelaClientes.v.get(c).getMorada();
            rowData[4] = TelaClientes.v.get(c).getSexo();
            rowData[2] = TelaClientes.v.get(c).getContacto();
            rowData[5] = TelaClientes.v.get(c).getSaldo();
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
