package Vendas;

import Armazem.TelaArmazem;
import Clientes.TelaListarClientes;
import Clientes.TelaClientes;
import static Clientes.TelaClientes.v;
import static Clientes.TelaListarClientes.tabela;
import Clientes.txtDados;
import Filtro.TelaFiltro;
import Fornecedores.TelaFornecedores;
import Produtos.TelaListar;
import static Produtos.TelaListar.tabela;
import Produtos.TelaProdutos;
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
import javax.swing.BorderFactory;
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
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import trabalhofinal.MenuPrincipal;

public class TelaVendas implements ActionListener, MouseListener {

    private JFrame frame;
    private JLabel lblCarrinho, lblVendas, lblQuantidade;
    private JButton finalizar, voltar, adicionarCarrinho, maisQuantidade, menosQuantidade, removerCarrinho, novoCliente;
    private static JTextField txQuantidade, txPesquisar;
    public static JTable tabela, tabelaCarrinho, tabelaCliente;
    private JPanel panelBorder, panelCarrinho, panelbt, panelCliente;
    private JSeparator sp;
    private JMenu menu;
    private JMenuItem miArmazem, miClientes, miFornecedores, miFiltro, miSair, miProdutos;
    private JMenuBar menuBar;
    private DefaultTableModel model;
    private JScrollPane scroll, scroll2, scroll3;
    private TableRowSorter<TableModel> rowSorter;
    public static Vector<DadosVenda> vendas = new Vector<DadosVenda>();
    public static Vector<DadosCarrinho> carrinho = new Vector<DadosCarrinho>();
    private int au, cont;
    public static float totalPreco = 0, iva, totalValor;
    private static Recibo rb;
    private boolean qtdRestante = true;
    public static boolean update;

    public TelaVendas() {
        frame = new JFrame();
        frame.setTitle("Sistema de Gestao");
        frame.setSize(650, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        sp = new JSeparator();
        sp.setBounds(10, 40, 620, 5);

        //Labels
        lblVendas = new JLabel("Vendas");
        lblVendas.setBounds(0, 0, 650, 50);
        lblVendas.setHorizontalAlignment(JLabel.CENTER);
        lblVendas.setFont(new Font("Arial", Font.BOLD, 22));
        lblQuantidade = new JLabel("Quantidade");
        lblQuantidade.setBounds(250, 40, 140, 60);
        lblQuantidade.setFont(new Font("Arial", Font.BOLD, 12));
        lblCarrinho = new JLabel("Carrinho");
        lblCarrinho.setFont(new Font("Arial", Font.BOLD, 14));
        lblCarrinho.setBounds(360, 30, 150, 50);
        lblCarrinho.setHorizontalAlignment(JLabel.CENTER);
        
        ImageIcon cart = new ImageIcon("cart_16px.png");
        ImageIcon cliente = new ImageIcon("add_user16px.png"); 
        
        //Button
        finalizar = new JButton("Finalizar venda", cart);
        finalizar.setBounds(470, 310, 150, 27);
        voltar = new JButton("Voltar");
        voltar.setBounds(10, 310, 100, 27);
        adicionarCarrinho = new JButton(">");
        removerCarrinho = new JButton("<");
        adicionarCarrinho.setEnabled(false);
        removerCarrinho.setEnabled(false);
        maisQuantidade = new JButton("+");
        menosQuantidade = new JButton("-");
        novoCliente = new JButton("Novo Cliente", cliente);
        novoCliente.setBounds(10, 180, 170, 27);

        //menuBar
        miArmazem = new JMenuItem("Armazem");
        miClientes = new JMenuItem("Clientes");
        miProdutos = new JMenuItem("Produtos");
        miFornecedores = new JMenuItem("Fornecedores");
        miFiltro = new JMenuItem("Filtro");
        miSair = new JMenuItem("Sair");
        menuBar = new JMenuBar();
        menu = new JMenu("Menu");

        frame.setJMenuBar(menuBar);
        menuBar.add(menu);
        menu.add(miClientes);
        menu.add(miProdutos);
        menu.add(miArmazem);
        menu.add(miFornecedores);
        menu.add(miFiltro);
        menu.addSeparator();
        menu.add(miSair);

        //TextField
        txQuantidade = new JTextField();
        txQuantidade.setText("1");
        txPesquisar = new txPesquisar();

        //tabela
        tabela = new JTable();
        tabela.setModel(new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        model = (DefaultTableModel) tabela.getModel();
        model.addColumn("Produto");
        model.addColumn("Qtd");
        model.addColumn("Preço");
        tabela.setShowVerticalLines(false);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(70);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(15);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(5);
        scroll = new JScrollPane(tabela);
        scroll.setBounds(210, 50, 200, 240);

        tabelaCarrinho = new JTable();
        tabelaCarrinho.setModel(new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        model = (DefaultTableModel) tabelaCarrinho.getModel();
        model.addColumn("Produto");
        model.addColumn("Preço");
        model.addColumn("Qtd");
        tabelaCarrinho.setShowVerticalLines(false);
        tabelaCarrinho.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabelaCarrinho.getColumnModel().getColumn(1).setPreferredWidth(5);
        tabelaCarrinho.getColumnModel().getColumn(2).setPreferredWidth(15);
        scroll2 = new JScrollPane(tabelaCarrinho);

        tabelaCliente = new JTable();
        setupTabela();
        scroll3 = new JScrollPane(tabelaCliente);
        scroll3.setBounds(7, 55, 156, 60);
        tabelaCliente.setShowHorizontalLines(false);
        tabelaCliente.setShowVerticalLines(false);
        scroll3.setVisible(false);
        rowSorter = new TableRowSorter<>(tabelaCliente.getModel());
        TestTableSortFilter();

        //panel
        panelbt = new JPanel();
        panelbt.setLayout(new GridLayout(1, 1, 3, 3));
        panelbt.add(maisQuantidade);
        panelbt.add(txQuantidade);
        panelbt.add(menosQuantidade);
        panelbt.setBounds(457, 245, 140, 50);
        panelbt.setBorder(BorderFactory.createTitledBorder("Quantidade"));

        panelCarrinho = new JPanel();
        panelCarrinho.setLayout(new GridLayout(2, 1, 3, 3));

        panelCarrinho.add(adicionarCarrinho);
        panelCarrinho.add(removerCarrinho);
        panelCarrinho.setBounds(416, 120, 40, 60);

        panelBorder = new JPanel();
        panelBorder.setLayout(new GridLayout(1, 1));
        panelBorder.add(scroll2);
        panelBorder.setBounds(457, 50, 170, 190);
        panelBorder.setBorder(BorderFactory.createTitledBorder("Carrinho"));

        //pesquisar Clientes
        panelCliente = new JPanel();
        panelCliente.setLayout(null);
        txPesquisar.setBounds(7, 20, 156, 30);
        panelCliente.add(txPesquisar);
        panelCliente.add(scroll3);
        panelCliente.setBorder(BorderFactory.createTitledBorder("Cliente"));
        panelCliente.setBounds(10, 50, 170, 130);

        //frame control
        frame.add(lblVendas);
        frame.add(scroll);
        frame.add(sp);
        frame.add(panelbt);
        frame.add(voltar);
        frame.add(panelBorder);
        frame.add(panelCarrinho);
        frame.add(panelCliente);
        frame.add(finalizar);
        frame.add(novoCliente);
        frame.setVisible(true);
        txtTabela();

        //ActiomListener
        miArmazem.addActionListener(this);
        miProdutos.addActionListener(this);
        miFornecedores.addActionListener(this);
        miFiltro.addActionListener(this);
        voltar.addActionListener(this);
        miSair.addActionListener(this);
        miClientes.addActionListener(this);
        novoCliente.addActionListener(this);
        maisQuantidade.addActionListener(this);
        menosQuantidade.addActionListener(this);
        adicionarCarrinho.addActionListener(this);
        removerCarrinho.addActionListener(this);
        finalizar.addActionListener(this);

        tabelaCliente.addMouseListener(this);
        tabelaCarrinho.addMouseListener(this);
        tabela.addMouseListener(this);


        //Shortcuts
        menu.setMnemonic(KeyEvent.VK_M);
        miArmazem.setMnemonic(KeyEvent.VK_A);
        miProdutos.setMnemonic(KeyEvent.VK_P);
        miFornecedores.setMnemonic(KeyEvent.VK_F);
        miFiltro.setMnemonic(KeyEvent.VK_L);
        miSair.setMnemonic(KeyEvent.VK_S);
        miClientes.setMnemonic(KeyEvent.VK_C);

        carrinho.removeAllElements();
    }

    public void setupTabela() {
        tabelaCliente.setModel(new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        model = (DefaultTableModel) tabelaCliente.getModel();
        model.addColumn("Cliente");
        Object rowData[] = new Object[1];
        for (int c = 0; c < TelaClientes.v.size(); c++) {
            rowData[0] = TelaClientes.v.get(c).getNome();
            model.addRow(rowData);
        }

        tabelaCliente.setTableHeader(null);
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
        if (ae.getSource() == miFornecedores) {
            frame.setVisible(false);
            new TelaFornecedores();
        }
        if (ae.getSource() == miClientes) {
            frame.setVisible(false);
            new TelaListarClientes();
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
        if (ae.getSource() == novoCliente) {
            frame.setVisible(false);
            new TelaClientes();
            update = true;
            
        }
        if (ae.getSource() == maisQuantidade) {
            au = 0;
            try {
                au = Integer.parseInt(txQuantidade.getText());
            } catch (NumberFormatException e) {

            }
            if (au != 0) {
                au += 1;
                txQuantidade.setText(String.valueOf(au));
                cont = Integer.parseInt(txQuantidade.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Insira a quantidade corretamente");
                txQuantidade.setText("1");
            }

        }
        if (ae.getSource() == menosQuantidade) {
            au = 0;
            try {
                au = Integer.parseInt(txQuantidade.getText());
            } catch (NumberFormatException e) {

            }
            if (au != 0) {
                if (au > 1) {
                    au -= 1;
                    txQuantidade.setText(String.valueOf(au));
                    cont = Integer.parseInt(txQuantidade.getText());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Insira a quantidade corretamente");
                txQuantidade.setText("1");
            }

        }

        if (ae.getSource() == adicionarCarrinho) {
            int produtoSelecionado = tabela.getSelectedRow();

            if (tabela.isRowSelected(produtoSelecionado)) {
                addVector(produtoSelecionado);
                for (int c = 0; c < carrinho.size(); c++) {
                    if (carrinho.elementAt(c).getProduto().equals(TelaProdutos.v.get(produtoSelecionado).getNome())) {
                        totalPreco = totalPreco + (carrinho.elementAt(c).getPreco() * Integer.parseInt(txQuantidade.getText()));
                    }
                }

                tabela.clearSelection();
                removerCarrinho.setEnabled(true);
            }

        }
        if (ae.getSource() == finalizar) {
            if (!carrinho.isEmpty()) {
                tratarVenda();
            } else {
                JOptionPane.showMessageDialog(null, "Adicione produtos no carrinho primeiro!");
            }

        }
        if (ae.getSource() == removerCarrinho) {
            int itemRemovido = tabelaCarrinho.getSelectedRow();
            if (tabelaCarrinho.isRowSelected(itemRemovido)) {
                DefaultTableModel model = (DefaultTableModel) tabelaCarrinho.getModel();
                model.removeRow(itemRemovido);
                totalPreco = totalPreco - carrinho.get(itemRemovido).getPreco();
                carrinho.removeElementAt(itemRemovido);
               

                tabelaCarrinho.clearSelection();
            }
        }
    }

    public void tratarVenda() {
        boolean situacao = false;
        for (int c = 0; c < TelaVendas.carrinho.size(); c++) {
            for (int i = 0; TelaProdutos.v.size() > i; i++) {
                if (TelaVendas.carrinho.get(c).getProduto().equals(TelaProdutos.v.get(i).getNome())) {
                    if (TelaProdutos.v.get(i).getQuantidade() >= TelaVendas.carrinho.get(c).getQtd()) {
                        situacao = true;
                    }
                }
            }
        }
        if (situacao) {
            iva = (totalPreco * 17) / 100;
            totalValor = totalPreco + iva;
            if (carrinho.isEmpty() == false) {

                if (TelaClientes.v.get(cliente()).getSaldo() >= totalValor) {
                    frame.setVisible(false);
                    new Recibo();
                } else {
                    JOptionPane.showMessageDialog(null, "O saldo do cliente é insuficiente");
                }
            }
            TelaProdutos.gravar();
        }
    }

    public static void txtTabela() {
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();

        Object rowData[] = new Object[3];
        for (int c = 0; c < TelaProdutos.v.size(); c++) {
            rowData[0] = TelaProdutos.v.get(c).getNome();
            rowData[1] = TelaProdutos.v.get(c).getQuantidade();
            rowData[2] = TelaProdutos.v.get(c).getPreco();

            model.addRow(rowData);
        }
    }

    public void TabelaCarrinho() {
        DefaultTableModel model = (DefaultTableModel) tabelaCarrinho.getModel();

        Object rowData[] = new Object[3];
        for (int c = 0; c < carrinho.size(); c++) {
            rowData[0] = carrinho.elementAt(c).getProduto();
            rowData[2] = carrinho.elementAt(c).getQtd();
            rowData[1] = carrinho.elementAt(c).getPreco();
        }
        model.addRow(rowData);
    }

    public static void TabelaCarrinhoAtual() {
        DefaultTableModel model = (DefaultTableModel) tabelaCarrinho.getModel();

        Object rowData[] = new Object[3];
        for (int c = 0; c < carrinho.size(); c++) {
            rowData[0] = carrinho.elementAt(c).getProduto();
            rowData[2] = carrinho.elementAt(c).getQtd();
            rowData[1] = carrinho.elementAt(c).getPreco();
            model.addRow(rowData);
        }

    }

    public void addVector(int produtoSelecionado) {
        boolean existe = false;
        DefaultTableModel model = (DefaultTableModel) tabelaCarrinho.getModel();
        for (int c = 0; c < carrinho.size(); c++) {
            if (carrinho.elementAt(c).getProduto().equals(TelaProdutos.v.get(produtoSelecionado).getNome())) {
                carrinho.elementAt(c).setPreco(TelaProdutos.v.get(produtoSelecionado).getPreco());

                cont += carrinho.elementAt(c).getQtd();
                if (cont > TelaProdutos.v.get(produtoSelecionado).getQuantidade()) {
                    qtdRestante = false;
                } else if (carrinho.elementAt(c).getQtd() <= TelaProdutos.v.get(produtoSelecionado).getQuantidade()) {
                    qtdRestante = true;
                }
                if (qtdRestante) {
                    au = 0;
                    try {
                        au = Integer.parseInt(txQuantidade.getText());
                    } catch (NumberFormatException e) {

                    }

                    if (au != 0) {
                        carrinho.elementAt(c).setQtd(carrinho.elementAt(c).getQtd() + Integer.parseInt(txQuantidade.getText()));
                    } else {
                        JOptionPane.showMessageDialog(null, "Insira a quantidade corretamente");
                        txQuantidade.setText("1");
                    }

                }
                if (qtdRestante == false) {
                    JOptionPane.showMessageDialog(null, "Quantidade insuficiente para adicionar no carrinho");
                }
                cont = Integer.parseInt(txQuantidade.getText());
                existe = true;
            }
        }
        if (existe == false) {
            au = 0;
            try {
                au = Integer.parseInt(txQuantidade.getText());
            } catch (NumberFormatException e) {

            }

            if (au != 0) {
                cont = Integer.parseInt(txQuantidade.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Insira a quantidade corretamente");
                txQuantidade.setText("1");
            }
            

            if (cont <= TelaProdutos.v.get(produtoSelecionado).getQuantidade()) {
                DadosCarrinho dc = new DadosCarrinho(TelaProdutos.v.get(produtoSelecionado).getNome(),
                        Integer.parseInt(txQuantidade.getText()),
                        TelaProdutos.v.get(produtoSelecionado).getPreco());
                carrinho.add(dc);
                TabelaCarrinho();
            }
            if (cont > TelaProdutos.v.get(produtoSelecionado).getQuantidade()) {
                JOptionPane.showMessageDialog(null, "Quantidade maior que o produto");
            }
        }
        if (existe == true) {
            model.getDataVector().removeAllElements();
            TabelaCarrinhoAtual();
        }

    }

    public static void tratarSaldo() {
        totalValor = totalPreco + iva;
        TelaClientes.v.get(cliente()).setSaldo(TelaClientes.v.get(cliente()).getSaldo() - totalValor);
        JOptionPane.showMessageDialog(null, "Venda Realizada com Sucesso");
        TelaClientes.gravar();
    }

    public static float valor() {
        return totalPreco;
    }

    
    public static float totalValor() {
        return totalValor;
    }

    public static float IVA() {
        return iva;
    }
    

    public static int cliente() {
        int cliente = 0;
        int itemSelecionado = tabelaCliente.getSelectedRow();
        String clie = tabelaCliente.getValueAt(itemSelecionado, 0).toString();
        for (int c = 0; TelaClientes.v.size() > c; c++) {
            if (TelaClientes.v.get(c).getNome().equals(clie)) {
                cliente = c;
            }
        }

        return cliente;
    }

    public void TestTableSortFilter() {
        tabelaCliente.setRowSorter(rowSorter);

        txPesquisar.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = txPesquisar.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
                scroll3.setVisible(true);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = txPesquisar.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
                if (txPesquisar.getText().equals("")) {
                    scroll3.setVisible(false);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }

        });
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == tabelaCliente) {
            int input = JOptionPane.showConfirmDialog(null, "Confirma a escolha do cliente?", "", JOptionPane.YES_NO_OPTION);
            if (input == JOptionPane.YES_OPTION) {
                int itemSelecionado = tabelaCliente.getSelectedRow();
                txPesquisar.setText((String) tabelaCliente.getValueAt(itemSelecionado, 0));
                txPesquisar.setEditable(false);
                novoCliente.setEnabled(false);
                scroll3.setVisible(false);
            }
        }
        if (me.getSource() == tabela) {
            int itemSelecionado = tabela.getSelectedRow();
            if (novoCliente.isEnabled() == false) {

                if (TelaProdutos.v.get(itemSelecionado).getQuantidade() == 0) {
                    adicionarCarrinho.setEnabled(false);
                } else {
                    adicionarCarrinho.setEnabled(true);
                }
            }
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

}
