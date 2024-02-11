package trabalhofinal;

import Armazem.txtDadosArmazem;
import Login.Login;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import Clientes.txtDados;
import Fornecedores.txtDadosFornecedores;
import Produtos.txtDadosProdutos;
public class TrabalhoFinal {
    
    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }
        lerDados();
        
        new Login();
       
    }
    public static void lerDados(){
    	txtDados.ler("Object\\Clientes.dat");
    	txtDadosArmazem.ler("Object\\DadosArmazem.dat");
        txtDadosFornecedores.ler("Object\\DadosFornecedores.dat");
        txtDadosProdutos.ler("Object\\DadosProdutos.dat");
    }
}
