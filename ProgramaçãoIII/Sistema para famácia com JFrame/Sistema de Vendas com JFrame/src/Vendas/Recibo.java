package Vendas;

import Clientes.TelaClientes;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EmptyBorder;
import Produtos.TelaProdutos;
import static Vendas.TelaVendas.IVA;
import static Vendas.TelaVendas.valor;
import static Vendas.TelaVendas.cliente;
import static Vendas.TelaVendas.totalValor;
import javax.swing.ImageIcon;

public class Recibo implements ActionListener {

    private JFrame frame;
    private JButton cancelar, confirmar;
    private JLabel lblRecibo, lblNome, lblSaldo, lblValor, lblTotal, lblIva, lbl1, lbl2;
    private JSeparator sp;
    private JPanel panelbt, panellb, panellb2;
    private JTable tabelaCarrinho;
    private JScrollPane scroll;
    private DefaultTableModel model;

    public Recibo() {

        frame = new JFrame();
        frame.setTitle("Sistema de Gestao");
        frame.setSize(300, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        sp = new JSeparator();
        sp.setBounds(10, 40, 275, 5);

        lblRecibo = new JLabel("Recibo");
        lblRecibo.setFont(new Font("Arial", Font.BOLD, 16));
        lblRecibo.setHorizontalAlignment(JLabel.CENTER);
        lblRecibo.setBounds(90, 0, 100, 50);
        
        lblNome = new JLabel("Cliente: " +  TelaClientes.v.get(cliente()).getNome());
        lblSaldo = new JLabel("Saldo: " +  TelaClientes.v.get(cliente()).getSaldo() +" Mzn");
        
        lblValor = new JLabel("Valor sem iva: " + valor() +" Mzn");
        lblIva = new JLabel("IVA: " + IVA() +" Mzn");
        lblTotal = new JLabel("Valor Total: " + totalValor()+" Mzn");
        lblValor.setHorizontalAlignment(JLabel.RIGHT);
        lblIva.setHorizontalAlignment(JLabel.RIGHT);
        lblTotal.setHorizontalAlignment(JLabel.RIGHT);

        lbl1 = new JLabel();
        lbl1.setBounds(5, 110, 275, 15);
        lbl1.setFont(new Font("Calibri", Font.PLAIN, 21));
        for (int i = 0; i < 25; i++) {
            lbl1.setText(lbl1.getText() + " -");
        }
        lbl2 = new JLabel();
        lbl2.setBounds(5, 260, 275, 15);
        lbl2.setFont(new Font("Calibri", Font.PLAIN, 21));
        for (int i = 0; i < 25; i++) {
            lbl2.setText(lbl2.getText() + " -");
        }
        
        ImageIcon cancel = new ImageIcon("cancel_16px.png");
        ImageIcon confirm = new ImageIcon("checked_16px.png"); 
        
        cancelar = new JButton("Cancelar", cancel);
        confirmar = new JButton("Confirmar", confirm);

        tabelaCarrinho = new JTable();
        tabelaCarrinho.setModel(new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        model = (DefaultTableModel) tabelaCarrinho.getModel();
        model.addColumn("Qtd");
        model.addColumn("Descricao");
        model.addColumn("Preco");
        tabelaCarrinho.setShowVerticalLines(false);
        tabelaCarrinho.setShowHorizontalLines(false);

        tabelaCarrinho.getColumnModel().getColumn(0).setPreferredWidth(1);
        tabelaCarrinho.getColumnModel().getColumn(1).setPreferredWidth(150);
        tabelaCarrinho.getColumnModel().getColumn(2).setPreferredWidth(20);
        tabelaCarrinho.getTableHeader().setOpaque(false);
        tabelaCarrinho.setOpaque(false);
        scroll = new JScrollPane(tabelaCarrinho);
        scroll.setBorder(new EmptyBorder(5, 5, 5, 5));
        scroll.setBounds(10, 120, 270, 130);

        panelbt = new JPanel();
        panelbt.setLayout(new GridLayout(1, 1, 4, 7));
        panelbt.add(cancelar);
        panelbt.add(confirmar);
        panelbt.setBounds(42, 335, 210, 25);

        panellb = new JPanel();
        panellb.setLayout(new GridLayout(2, 1));
        panellb.add(lblNome);
        panellb.add(lblSaldo);
        panellb.setBounds(12, 43, 120, 70);

        panellb2 = new JPanel();
        panellb2.setLayout(new GridLayout(3, 1));
        panellb2.add(lblValor);
        panellb2.add(lblIva);
        panellb2.add(lblTotal);
        panellb2.setBounds(10, 270, 272, 60);

        frame.add(panelbt);
        frame.add(lblRecibo);
        frame.add(sp);
        frame.add(lbl1);
        frame.add(lbl2);
        frame.add(panellb);
        frame.add(scroll);
        frame.add(panellb2);
        TabelaCarrinho();

        confirmar.addActionListener(this);
        cancelar.addActionListener(this);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == confirmar) {
            frame.setVisible(false);
            
            finalizarVenda();
            
            new TelaVendas();

            DefaultTableModel model = (DefaultTableModel) TelaVendas.tabela.getModel();
            model.getDataVector().removeAllElements();
            TelaVendas.txtTabela();

            TelaVendas.carrinho.removeAllElements();
            DefaultTableModel model2 = (DefaultTableModel) TelaVendas.tabelaCarrinho.getModel();
            model2.getDataVector().removeAllElements();
            TelaVendas.TabelaCarrinhoAtual();
            TelaVendas.totalPreco=0;

        }
        if (ae.getSource() == cancelar) {
            frame.setVisible(false);
            TelaVendas.carrinho.removeAllElements();
            TelaVendas.totalPreco=0;
            new TelaVendas();
        }
    }

    public void TabelaCarrinho() {
        DefaultTableModel model = (DefaultTableModel) tabelaCarrinho.getModel();

        Object rowData[] = new Object[3];
        for (int c = 0; c < TelaVendas.carrinho.size(); c++) {
            rowData[1] = TelaVendas.carrinho.elementAt(c).getProduto();
            rowData[2] = TelaVendas.carrinho.elementAt(c).getPreco();
            rowData[0] = TelaVendas.carrinho.elementAt(c).getQtd();
            model.addRow(rowData);
        }

    }

    public static void finalizarVenda() {
        for (int c = 0; c < TelaVendas.carrinho.size(); c++) {
            for (int i = 0; TelaProdutos.v.size() > i; i++) {
                if (TelaVendas.carrinho.get(c).getProduto().equals(TelaProdutos.v.get(i).getNome())) {
                    TelaProdutos.v.get(i).setQuantidade(TelaProdutos.v.get(i).getQuantidade() - TelaVendas.carrinho.get(c).getQtd());
                }
            }
        }
        TelaVendas.tratarSaldo();
        TelaProdutos.gravar();
    }

}
