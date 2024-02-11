package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Server extends JFrame {

    private JButton turnOn, turnOff;
    private JLabel serverStatus;

    public Server(){

    }


    public void initComponents() {
        this.setTitle("Servidor de Chat");
        this.setSize(200, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        


        turnOn = new JButton("Ligar");
        turnOff = new JButton("Desligar");
        serverStatus = new JLabel();
    }
}
