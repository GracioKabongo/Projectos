package view;

import javax.swing.*;

// Shelton Francisco
public class Home extends JFrame {

    private JMenuBar bar;
    private JMenu menu;
    private JMenuItem parcelas, programador, sair;

    public Home() {
        super("Home");
        this.setSize(350, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);

        initComponents();

        this.setJMenuBar(bar);
        this.setVisible(true);
    }

    public void initComponents() {
        bar = new JMenuBar();
        menu = new JMenu("Menu");
        parcelas = new JMenuItem("Calculo de Parcenlas", 'C');
        programador = new JMenuItem("Dados do Programdor", 'D');
        sair = new JMenuItem("Sair", 'S');


        // eventos
        parcelas.addActionListener(e -> {
            new Parcelas();
        });

        programador.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Nome: Shelton Francisco" +
                    "\nTurma: LECC 21", "Dados do Programador", JOptionPane.INFORMATION_MESSAGE);
        });

        sair.addActionListener(e -> {
            System.exit(0);
        });

        menu.add(parcelas);
        menu.add(programador);
        menu.addSeparator();
        menu.add(sair);
        bar.add(menu);
    }


}
