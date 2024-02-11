package view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;

// Shelton Francisco

public class Parcelas extends JFrame {

    private JPanel topPanel, bottomPanel;
    private JLabel lblNewCar, lblOldCar, lblAmount, lblParcela;
    private JTextField newCar, oldCar, amount, parcela;
    private JButton calc, novo, fechar;
    private JRadioButton unica, doze, vinte;
    private ButtonGroup group;


    private final double UNICA = 0.03;
    private final double DOZE = 0.15;
    private final double VINTE = 0.25;

    private GridBagConstraints c;

    public Parcelas() {
        super("Login");
        this.setSize(600, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(2, 1, 4, 4));
        initComponents();


        // eventos

        calc.addActionListener(e -> {
            try{
                Double parcelaVlr;
                Double total;
                double novoValor = Double.parseDouble(newCar.getText());
                double velhoValor;
                if(oldCar.getText().isBlank()){
                    velhoValor = 0;
                } else {
                    velhoValor = Double.parseDouble(oldCar.getText());
                }


                if(unica.isSelected()){
                    total = (novoValor - velhoValor) + (novoValor * UNICA);
                    parcela.setText(total.toString());

                } else if (doze.isSelected()) {
                    total = (novoValor - velhoValor) + (novoValor * DOZE);
                    parcelaVlr = total/12;
                    parcela.setText(parcelaVlr.toString());

                } else {
                    total = (novoValor - velhoValor) + (novoValor * VINTE);
                    parcelaVlr = total/24;
                    parcela.setText(parcelaVlr.toString());
                }

                amount.setText(total.toString());

            } catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(this,"Insira valores Validos", "Erro", JOptionPane.ERROR_MESSAGE);
            }

        });

        novo.addActionListener(e -> {
            newCar.setText("");
            oldCar.setText("");
            amount.setText("");
            parcela.setText("");
        });


        fechar.addActionListener(e -> {
            this.dispose();
        });


        c.insets = new Insets(5,5,5,5);

        c.anchor = GridBagConstraints.WEST;
        addToTopPanel(lblNewCar, 0,0 ,1, 1);
        addToTopPanel(lblOldCar, 1,0,1,1);
        addToTopPanel(lblAmount, 2,0,1,1);

        addToTopPanel(newCar,0,1,1,1);
        addToTopPanel(oldCar, 1,1,1,1);
        addToTopPanel(amount,2,1,1,1);

        c.anchor = GridBagConstraints.CENTER;
        addToTopPanel(calc, 3,0,1,1);
        addToTopPanel(novo, 3,1,1,1);
        addToTopPanel(fechar, 3,2,1,1);

        // bottomPanel

        c.anchor = GridBagConstraints.WEST;
        addToBottompPanel(unica, 0,0 ,1,1);
        addToBottompPanel(doze, 1,0,1,1);
        addToBottompPanel(vinte,2,0,1,1);
        addToBottompPanel(lblParcela, 0, 1,1,1);
        addToBottompPanel(parcela, 1,1,1,1);


        this.add(topPanel);
        this.add(bottomPanel);
        this.setVisible(true);
    }

    public void initComponents() {
        topPanel = new JPanel(new GridBagLayout());
        topPanel.setBorder(new BasicBorders.MenuBarBorder(Color.BLACK, Color.black));

        bottomPanel = new JPanel(new GridBagLayout());
        bottomPanel.setBorder(new TitledBorder("Parcelas"));

        c = new GridBagConstraints();

        lblAmount = new JLabel("Valor a pagar..............:");
        lblNewCar = new JLabel("Valor do Carro Novo.....:");
        lblOldCar = new JLabel("Valor do Carro Usado....:");
        lblParcela = new JLabel("Valor da parcela");

        oldCar = new JTextField(15);
        newCar = new JTextField(15);
        amount = new JTextField(15);
        amount.setEditable(false);
        parcela = new JTextField(15);
        parcela.setEditable(false);

        calc = new JButton("Calcular");
        novo = new JButton("Novo Calculo");
        fechar = new JButton("Fechar");

        unica = new JRadioButton("Parcela Unica");
        unica.setSelected(true);
        doze = new JRadioButton("12 x");
        vinte = new JRadioButton("24 x");

        group = new ButtonGroup();
        group.add(unica);
        group.add(doze);
        group.add(vinte);
    }

    public void addToTopPanel(Component component, int row, int column, int width, int height) {
        c.gridy = row;
        c.gridx = column;
        c.gridwidth = width;
        c.gridheight = height;
        topPanel.add(component, c);
    }

    public void addToBottompPanel(Component component, int row, int column, int width, int height) {
        c.gridy = row;
        c.gridx = column;
        c.gridwidth = width;
        c.gridheight = height;
        bottomPanel.add(component, c);
    }
}
