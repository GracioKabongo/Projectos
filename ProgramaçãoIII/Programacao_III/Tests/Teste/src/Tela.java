import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Tela<E> implements ActionListener {
    private static final Component Component = null;
    private JFrame frame;
    private JTextField campo_nome,campo_conta,campo_morada,campo_telemovel;
    private JLabel  nome,numero_conta,morada,telemovel;
    private JButton novo, gravar,remover, actualizar;
    private JRadioButton femenino, masculino,corrrente, prazo;
    private JPanel painel1, painel2, painel3, painel4,painel5,painel6, painel7,painel8,painel9;
    private JList lista;
    private ButtonGroup bg1,bg2;

    Vector DadosCliente=new Vector();




// construtor da classe

    public Tela() {
        // Frame
        frame=new JFrame();
        bg1= new ButtonGroup();
        bg2= new ButtonGroup();

        // JTextefield
        campo_conta=new JTextField(20);
        campo_nome=new JTextField(20);
        campo_morada=new JTextField(20);
        campo_telemovel=new JTextField(20);

        // JLabel
        numero_conta=new JLabel("Numero de conta: ");
        nome=new  JLabel("Nome: ");
        morada=new  JLabel("Morada: ");
        telemovel=new  JLabel("Telemovel: ");


        //JButton

        novo= new JButton("Novo");
        gravar= new JButton("Gravar");
        remover= new JButton("Remover");
        actualizar= new JButton("Actualizar");

        gravar.addActionListener(this);

        // JRadioButton

        femenino=new JRadioButton("Feminino");
        masculino=new JRadioButton("Masculino");
        bg1.add(femenino);
        bg1.add(masculino);
        corrrente=new JRadioButton("Corrente");
        prazo=new JRadioButton("Prazo");
        bg2.add(prazo);
        bg2.add(corrrente);



        // JPanel

        painel1=new JPanel();
        painel2=new JPanel();
        painel3=new JPanel();
        painel4=new JPanel();
        painel5=new JPanel();
        painel6=new JPanel();
        painel7=new JPanel();
        painel8=new JPanel();
        painel9=new JPanel();

        // JList
        lista=new JList(DadosCliente);








        // Atributos da frame

        frame.setSize(550,250);
        frame.setTitle("Registro de clientes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2,1));


        // painel1
        painel1.setLayout(new GridLayout(1,2));
        painel1.add(painel2);
        painel1.add(painel7);

        // painel2

        painel2.setLayout(new GridLayout(2,1));
        painel2.add(painel3);
        painel2.add(painel4);

        // painel3
        painel3.setLayout(new GridLayout(4,2));
        painel3.add(numero_conta);
        painel3.add(campo_conta);
        painel3.add(nome);
        painel3.add(campo_nome);
        painel3.add(morada);
        painel3.add(campo_morada);
        painel3.add(telemovel);
        painel3.add(campo_telemovel);

        // painel4
        painel4.setLayout(new GridLayout(1,2));
        painel4.add(painel5);
        painel4.add(painel6);


        // painel5
        painel5.setLayout(new GridLayout(2,1));
        painel5.setBorder(new TitledBorder("Tipo de conta"));
        painel5.add(corrrente);
        painel5.add(prazo);

        // paine6

        painel6.setLayout(new GridLayout(2,1));
        painel6.setBorder(new TitledBorder("Genero"));
        painel6.add(femenino);
        painel6.add(masculino);


        // painel7
        painel7.setLayout(new GridLayout(4,1));
        painel7.add(novo);
        painel7.add(gravar);
        painel7.add(remover);
        painel7.add(actualizar);


        // painel8
        painel8.setBorder(new TitledBorder("Lista de Clientes"));
        painel8.setLayout(new GridLayout());
        painel8.add(lista);



        // Adicionando elementos a frame2


        frame.add(painel1);
        frame.add(painel8);



        frame.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==gravar) {


            String fieldconta=campo_conta.getText();

            String fieldnome=campo_nome.getText();

            String fieldmorada=campo_morada.getText();


            String fieldtelemovel=campo_telemovel.getText();


            Cliente  cliente= new Cliente(fieldnome,fieldmorada,Integer.parseInt(fieldconta),Integer.parseInt(fieldtelemovel));

            DadosCliente.add(cliente);
            lista.updateUI();


            //System.out.println(DadosCliente);

        }

    }

    public static void main(String[] args) {
        new Tela<>();
    }
}