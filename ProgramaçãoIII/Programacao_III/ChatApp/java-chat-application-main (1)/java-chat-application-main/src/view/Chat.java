package view;

import clientside.ChatClient;
import serverside.ChatServer;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Chat extends JFrame implements ActionListener {

    private JButton enviarBtn, limparBtn, sairBtn, conectarBtn;
    private JTextArea chatArea, writeArea;
    private JTextField clientName;

    public static String username;

    GridBagLayout layout;
    GridBagConstraints constraints;
    private final String[] n = {"Joao", "Jose"};
    private JPanel onlinePanel, centerPanel;
    private JList onlineClients;
    private ImageIcon img;


    private ChatClient client;


    public Chat() {
        initComponent();
    }

    public void initComponent(){
        this.setSize(530, 600);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        constraints.insets = new Insets(4,4,4,4);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.BOTH;

        img = new ImageIcon("C:\\Users\\CFPE4\\Pictures\\cliente.png");
        this.setIconImage(img.getImage());
        enviarBtn = new JButton("Enviar");
        limparBtn = new JButton("Limpar");
        sairBtn = new JButton("Sair");
        conectarBtn = new JButton("Conectar");
        clientName = new JTextField(15);
        clientName.setText("localhost");
        chatArea = new JTextArea(15, 30);
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        writeArea = new JTextArea(6, 30);
        writeArea.setLineWrap(true);
        JScrollPane pane1 = new JScrollPane(chatArea);
        JScrollPane pane2 = new JScrollPane(writeArea);

       chatArea.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));



        // eventos
        enviarBtn.addActionListener(this);
        limparBtn.addActionListener(e -> limparAreaEscrita());
        conectarBtn.addActionListener(this);
        sairBtn.addActionListener( e ->{
            if (!client.isClosed()){
                client.closeConection();
                conectarBtn.setEnabled(true);
            } else {
                System.exit(1);
            }
        });


        addComponent(clientName, 0,0,1,1);
        addComponent(conectarBtn, 0,1,1,1);
        addComponent(sairBtn, 0,2,1,1);
        addComponent(pane1, 1,0,3,1);
        addComponent(pane2, 2,0,3,1);
        addComponent(limparBtn, 3,1,1,1);
        addComponent(enviarBtn,3,2,1,1);

    }

    // Comunicacao

    private boolean startClient(String host) {
        client = new ChatClient(this, host);

        try {
            client.start();
            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,e.getMessage());
        }

        return false;
    }

    public void showMsg(String msg){
        this.chatArea.setText(chatArea.getText().concat("\n".concat(msg)));
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == enviarBtn){
            if(client != null){
                String msg;
                if((msg = writeArea.getText()).equals("")) return;

                client.sendMsg(msg);
                this.chatArea.setText(chatArea.getText().concat("\n".concat("Tu: " + msg )));
                limparAreaEscrita();

            } else {
                JOptionPane.showMessageDialog(this, "Cliente não conectado!");
            }

        }

        if(e.getSource() == conectarBtn){
            if((username = clientName.getText()).isBlank()) return;

            new Thread(() -> {
                if(startClient(clientName.getText())){
                    conectarBtn.setEnabled(false);
                    clientName.setEditable(false);
                    sairBtn.setEnabled(true);
                    JOptionPane.showMessageDialog(this, "Conexão estabelecida com sucesso!");
                }
            }).start();
        }
    }

    public void limparAreaEscrita() {
        writeArea.setText("");
    }
    // configuracoes da tela
    private void addComponent(Component component, int row, int column, int width, int height){
        constraints.gridx = column;
        constraints.gridy = row;
        constraints.gridwidth = width;
        constraints.gridheight = height;
        this.add(component, constraints);
    }


 // main
    public static void main(String[] args) {
        new Chat().setVisible(true);
    }
}
    