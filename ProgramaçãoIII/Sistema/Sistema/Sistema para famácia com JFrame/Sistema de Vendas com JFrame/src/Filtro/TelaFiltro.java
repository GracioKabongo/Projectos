package Filtro;

import Armazem.TelaArmazem;
import Clientes.TelaListarClientes;
import Fornecedores.TelaFornecedores;
import Produtos.TelaListar;
import Produtos.TelaProdutos;
import Vendas.TelaVendas;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import trabalhofinal.MenuPrincipal;

public class TelaFiltro implements ActionListener {

    private JFrame frame;
    private static JButton voltar, listar;
    private JLabel lblFiltro;
    private JSeparator sp;
    private JMenu menu;
    private JMenuItem miArmazem, miProdutos, miFornecedores, miClientes, miSair, miVendas;
    private JMenuBar menuBar;
    private static JTable tabela, tabelaPrazo;
    private JScrollPane scroll, scroll2;
    private DefaultTableModel model, model1;
    private JPanel panelbt;
    public static boolean addRow = false;

    public TelaFiltro() {
        frame = new JFrame();
        frame.setTitle("Sistema de Gestao");
        frame.setSize(550, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        sp = new JSeparator();
        sp.setBounds(10, 40, 520, 5);
        panelbt = new JPanel();
        //label
        lblFiltro = new JLabel("Filtro");
        lblFiltro.setBounds(200, 0, 150, 50);
        lblFiltro.setFont(new Font("Arial", Font.BOLD, 18));
        lblFiltro.setHorizontalAlignment(JLabel.CENTER);

        //Button
        voltar = new JButton("Voltar");
        voltar.setBounds(10, 313, 80, 25);
        ImageIcon Ipesquisa = new ImageIcon("search_16px.png");
        listar = new JButton("Listar Agora", Ipesquisa);

        //menu
        miArmazem = new JMenuItem("Armazem");
        miProdutos = new JMenuItem("Produtos");
        miFornecedores = new JMenuItem("Fornecedores");
        miClientes = new JMenuItem("Clientes");
        miProdutos = new JMenuItem("Produtos");
        miVendas = new JMenuItem("Vendas");
        miSair = new JMenuItem("Sair");
        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        frame.setJMenuBar(menuBar);
        menuBar.add(menu);
        menu.add(miClientes);
        menu.add(miArmazem);
        menu.add(miProdutos);
        menu.add(miFornecedores);
        menu.add(miVendas);
        menu.addSeparator();
        menu.add(miSair);

        //Table
        tabela = new JTable();
        tabela.setModel(new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        tabela.setShowVerticalLines(false);
        model = (DefaultTableModel) tabela.getModel();
        model.addColumn("Numero");
        model.addColumn("Stock minimo");
        model.addColumn("Quantidade");
        model.addColumn("Armazem");
        model.addColumn("Nome");
        tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(25);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(25);
        tabela.getColumnModel().getColumn(4).setPreferredWidth(150);
        scroll = new JScrollPane(tabela);
        scroll.setBounds(10, 82, 520, 100);
        scroll.setToolTipText("Esta tabela filtra todos os produtos que estao abaixo do stock minimo");
        
        tabelaPrazo = new JTable();
        
        tabelaPrazo.setModel(new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        
        tabelaPrazo.setShowVerticalLines(false);
        model1 = (DefaultTableModel) tabelaPrazo.getModel();
        model1.addColumn("Numero");
        model1.addColumn("Stock minimo");
        model1.addColumn("Quantidade");
        model1.addColumn("Armazem");
        model1.addColumn("Nome");
        tabelaPrazo.getColumnModel().getColumn(0).setPreferredWidth(10);
        tabelaPrazo.getColumnModel().getColumn(1).setPreferredWidth(25);
        tabelaPrazo.getColumnModel().getColumn(2).setPreferredWidth(25);
        tabelaPrazo.getColumnModel().getColumn(4).setPreferredWidth(150);
        tabelaPrazo.setTableHeader(null);
        scroll2 = new JScrollPane(tabelaPrazo);
        scroll2.setBounds(10, 200, 520, 100);
        scroll2.setToolTipText("Esta tabela filtra todos os produtos que estao proximo ao prazo de validade");

        panelbt.setLayout(new GridLayout());
        panelbt.add(listar);
        panelbt.setBounds(10, 49, 120, 25);

        frame.add(lblFiltro);
        frame.add(sp);
        frame.add(panelbt);
        frame.add(voltar);
        frame.add(scroll);
        frame.add(scroll2);
        frame.setVisible(true);
        

        miClientes.addActionListener(this);
        miProdutos.addActionListener(this);
        miFornecedores.addActionListener(this);
        miArmazem.addActionListener(this);
        voltar.addActionListener(this);
        miSair.addActionListener(this);
        listar.addActionListener(this);
        miVendas.addActionListener(this);

        //Shortcuts
        menu.setMnemonic(KeyEvent.VK_M);
        miProdutos.setMnemonic(KeyEvent.VK_P);
        miArmazem.setMnemonic(KeyEvent.VK_A);
        miClientes.setMnemonic(KeyEvent.VK_C);
        miFornecedores.setMnemonic(KeyEvent.VK_F);
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
        if (ae.getSource() == miProdutos) {
            frame.setVisible(false);
            new TelaListar();
        }
        if (ae.getSource() == miFornecedores) {
            frame.setVisible(false);
            new TelaFornecedores();
        }

        if (ae.getSource() == miArmazem) {
            frame.setVisible(false);
            new TelaArmazem();
        }
        if (ae.getSource() == miClientes) {
            frame.setVisible(false);
            new TelaListarClientes();
        }
        if (ae.getSource() == listar) {
            model.getDataVector().removeAllElements();
            model1.getDataVector().removeAllElements();
            addRow();
            addRowPrazo();
        }

    }
    
    
    static int a = 0;
    public static void addRow() {
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();

        Object rowData[] = new Object[7];
        for (int c = 0; c < TelaProdutos.v.size(); c++) {
            if(TelaProdutos.v.elementAt(c).getQuantidade() < TelaProdutos.v.elementAt(c).getStock()){
                rowData[0] = TelaProdutos.v.get(c).getNumero();
                rowData[3] = TelaProdutos.v.get(c).getArmazem();
                rowData[1] = TelaProdutos.v.get(c).getStock();
                rowData[2] = TelaProdutos.v.get(c).getQuantidade();
                rowData[4] = TelaProdutos.v.get(c).getNome();
                model.addRow(rowData);
            }
            
        }

    }
    
    public static void addRowPrazo() {
        DefaultTableModel model = (DefaultTableModel) tabelaPrazo.getModel();
        Date dt = new Date();
        int mes = dt.getMonth() + 1;
        int ano = dt.getYear() + 1900;
        System.out.println(ano);
        Object rowData[] = new Object[7];
        
        for (int c = 0; c < TelaProdutos.v.size(); c++) {
            if(TelaProdutos.v.elementAt(c).getMes() == mes && 
                    TelaProdutos.v.elementAt(c).getAno().equals(String.valueOf(ano))){
                rowData[0] = TelaProdutos.v.get(c).getNumero();
                rowData[3] = TelaProdutos.v.get(c).getArmazem();
                rowData[1] = TelaProdutos.v.get(c).getStock();
                rowData[2] = TelaProdutos.v.get(c).getQuantidade();
                rowData[4] = TelaProdutos.v.get(c).getNome();
                model.addRow(rowData);
            }
            
        }

    }

}
