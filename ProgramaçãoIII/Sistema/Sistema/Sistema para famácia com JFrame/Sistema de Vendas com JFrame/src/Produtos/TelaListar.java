package Produtos;

import Armazem.TelaArmazem;
import Armazem.txPesquisar;
import Clientes.TelaListarClientes;
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

public class TelaListar implements ActionListener, MouseListener, KeyListener {

    private JFrame frame;
    private JSeparator sp;
    public static JTable tabela, tabelaFiltro;
    private JScrollPane scroll, scroll2;
    private DefaultTableModel model;
    private JMenu menu, Mprodutos;
    private JMenuItem miArmazem, miClientes, miFornecedores, miFiltro, miSair, miAdicionar, miVendas;
    private JMenuBar menuBar;
    private JButton atualizar, voltar, apagar, pesquisar, filtro;
    private JPanel panelbt, panelPesquisa, panelbt2;
    private JLabel lblBackground;
    private JTextField txPesquisar;
    public static boolean update;
    private boolean confirmarFilro;
    private TableRowSorter<TableModel> rowSorter;

    private JLabel lblProdutos;

    public TelaListar() 
    {
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

        lblProdutos = new JLabel("Produtos");
        lblProdutos.setHorizontalAlignment(JLabel.CENTER);
        lblProdutos.setBounds(220, 0, 100, 50);
        lblProdutos.setFont(new Font("Arial", Font.BOLD, 22));

        //Separador
        sp = new JSeparator();
        sp.setBounds(10, 40, 525, 5);

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
        miAdicionar = new JMenuItem("Listar");
        miAdicionar = new JMenuItem("Adicionar");
        menuBar.add(Mprodutos);
        Mprodutos.add(miAdicionar);

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
        tabela.setShowVerticalLines(false);
        tabela.setModel(new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        model = (DefaultTableModel) tabela.getModel();
        model.addColumn("Numero");
        model.addColumn("Armazem");
        model.addColumn("Stock Minimo");
        model.addColumn("Qtd");
        model.addColumn("Nome");
        model.addColumn("Preco");
        model.addColumn("Fornecedor");
        model.addColumn("Prazo");
        scroll = new JScrollPane(tabela);
        scroll.setBounds(10, 85, 525, 218);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(20);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(30);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(45);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(15);
        tabela.getColumnModel().getColumn(5).setPreferredWidth(10);
        tabela.getColumnModel().getColumn(6).setPreferredWidth(45);
        tabela.getColumnModel().getColumn(7).setPreferredWidth(35);
        
        String[] coluna = {"Filtro"};
        Object[][] data = {{"Numero"}, {"Nome"}};
        tabelaFiltro = new JTable(data, coluna);
        tabelaFiltro.setRowSelectionInterval(1, 1);
        tabelaFiltro.setTableHeader(null);
        tabelaFiltro.setShowHorizontalLines(false);
        tabelaFiltro.setShowVerticalLines(false);
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
        frame.add(panelbt);
        frame.add(voltar);
        frame.add(panelPesquisa);
        frame.add(panelbt2);

        frame.setVisible(true);
        txtTabela();

        //Action
        miClientes.addActionListener(this);
        miFornecedores.addActionListener(this);
        miFiltro.addActionListener(this);
        miArmazem.addActionListener(this);
        voltar.addActionListener(this);
        miSair.addActionListener(this);
        miAdicionar.addActionListener(this);
        atualizar.addActionListener(this);
        apagar.addActionListener(this);
        pesquisar.addActionListener(this);
        filtro.addActionListener(this);
        miVendas.addActionListener(this);

        tabelaFiltro.addMouseListener(this);
        
        txPesquisar.addKeyListener(this);

        //Shortcuts
        menu.setMnemonic(KeyEvent.VK_M);
        miArmazem.setMnemonic(KeyEvent.VK_A);
        miClientes.setMnemonic(KeyEvent.VK_C);
        miFornecedores.setMnemonic(KeyEvent.VK_F);
        miFiltro.setMnemonic(KeyEvent.VK_L);
        miSair.setMnemonic(KeyEvent.VK_S);
        Mprodutos.setMnemonic(KeyEvent.VK_P);
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
        if (ae.getSource() == miAdicionar) {
            frame.dispose();
            new TelaProdutos();
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
            new TelaListarClientes();
        }
        if (ae.getSource() == filtro) {
            scroll2.setVisible(true);
        }
        if (ae.getSource() == atualizar) {
            int produtoSelecionado = tabela.getSelectedRow();
            if (produtoSelecionado != -1) {
                new TelaProdutos();
                TelaProdutos.preecher();
                TelaProdutos.codigo();
                frame.setVisible(false);
                update = true;
            } else {
                JOptionPane.showMessageDialog(null, "Selecione o produto que deseja atualizar");
            }

        }
        if (ae.getSource() == apagar) {
            DefaultTableModel model = (DefaultTableModel) tabela.getModel();
            int itemRemovido = tabela.getSelectedRow();

            int produtoSelecionado = tabela.getSelectedRow();
            if (produtoSelecionado != -1) {
                if (itemRemovido != -1) {
                    int input = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o produto?", "", JOptionPane.YES_NO_OPTION);
                    if (input == JOptionPane.YES_OPTION) {
                        model.removeRow(itemRemovido);
                        TelaProdutos.v.removeElementAt(itemRemovido);
                        TelaProdutos.gravar();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione o produto que deseja remover");
            }
        }
        if (ae.getSource() == pesquisar) {
            DefaultTableModel model = (DefaultTableModel) tabela.getModel();
            
            tabela.setRowSorter(rowSorter);
            if(confirmarFilro == true){
            	rowSorter.setRowFilter(RowFilter.regexFilter(txPesquisar.getText().trim(), 0));
            }
            if(confirmarFilro == false ){
            	rowSorter.setRowFilter(RowFilter.regexFilter(txPesquisar.getText().trim(), 4));
            } 
        }

    }
    
    

    public static void addRow() {
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();

        Object rowData[] = new Object[8];
        for (int c = 0; c < TelaProdutos.v.size(); c++) {
            rowData[0] = TelaProdutos.v.get(c).getNumero();
            rowData[1] = TelaProdutos.v.get(c).getArmazem();
            rowData[2] = TelaProdutos.v.get(c).getStock();
            rowData[3] = TelaProdutos.v.get(c).getQuantidade();
            rowData[4] = TelaProdutos.v.get(c).getNome();
            rowData[5] = TelaProdutos.v.get(c).getPreco();
            rowData[6] = TelaProdutos.v.get(c).getFornecedor();
            rowData[7] =TelaProdutos.v.get(c).getDia() +"/"+ TelaProdutos.v.get(c).getMes()+"/"+
                    TelaProdutos.v.get(c).getAno();
        }
        model.addRow(rowData);
    }

    public static void txtTabela() {
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();

        Object rowData[] = new Object[8];
        for (int c = 0; c < TelaProdutos.v.size(); c++) {
            rowData[0] = TelaProdutos.v.get(c).getNumero();
            rowData[1] = TelaProdutos.v.get(c).getArmazem();
            rowData[2] = TelaProdutos.v.get(c).getStock();
            rowData[3] = TelaProdutos.v.get(c).getQuantidade();
            rowData[4] = TelaProdutos.v.get(c).getNome();
            rowData[5] = TelaProdutos.v.get(c).getPreco();
            rowData[6] = TelaProdutos.v.get(c).getFornecedor();
            rowData[7] = TelaProdutos.v.get(c).getDia() +"/"+ TelaProdutos.v.get(c).getMes() +"/"+
                    TelaProdutos.v.get(c).getAno();
            model.addRow(rowData);
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        scroll2.setVisible(false);
        if(tabelaFiltro.getSelectedRow() == 0){
                confirmarFilro = true;
            }
            if(tabelaFiltro.getSelectedRow() == 1){
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
