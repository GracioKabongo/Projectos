package chat;

public class MainCliente {
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Cliente().setVisible(true);
            }
        });
    }
}
