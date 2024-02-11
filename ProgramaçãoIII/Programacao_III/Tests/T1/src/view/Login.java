package view;

import javax.swing.*;
import java.awt.*;

// Shelton Francisco
public class Login extends JFrame {

    private JLabel lblUser, lblPass;
    private JPasswordField passwordField;
    private JTextField userFIeld;
    private JButton btnLogin;
    private JButton btnCancel;

    private final String USERNAME = "admin";
    private final String PASSWORD = "1234";



    private GridBagConstraints c;

    public Login() {
        super("Login");
        this.setSize(350, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridBagLayout());
        c = new GridBagConstraints();
        c.insets = new Insets(8,8,8,8);
        initComponets();

        // adicionando componentes
        addComponent(lblUser, 0,0,1,1);
        addComponent(lblPass, 1,0,1,1);
        addComponent(userFIeld, 0,1,2,1);
        addComponent(passwordField, 1,1,2,1);
        addComponent(btnCancel, 2,0,1,1);
        addComponent(btnLogin, 2,1,1,1);

        //eventos
        btnLogin.addActionListener(e -> {
            var user = userFIeld.getText();
            var pass = passwordField.getText();

            if(user.equals(USERNAME) && pass.equals(PASSWORD)){
                new Home();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this,"Credenciasi invalidas", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnCancel.addActionListener(e -> {
            System.exit(0);
        });


        this.setVisible(true);
    }


    private void initComponets(){
        lblUser = new JLabel("Username: ");
        lblPass = new JLabel("Password: ");

        userFIeld = new JTextField(15);
        passwordField = new JPasswordField(15);

        btnCancel = new JButton("Cancel", new ImageIcon("C:\\Users\\User\\Pictures\\testIcon.jpeg"));
        btnLogin = new JButton("Login", new ImageIcon("C:\\Users\\User\\Pictures\\testIcon.jpeg"));
    }


    private void addComponent(Component component, int row, int column, int width, int height){
        c.gridy = row;
        c.gridx = column;
        c.gridwidth = width;
        c.gridheight = height;
        this.add(component, c);
    }
}
