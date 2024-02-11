package Fornecedores;


import static Fornecedores.TelaFornecedores.v;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class txtDadosFornecedores {

    public static void gravar(Vector v, String arquivo) {
        File ficheiro = new File(arquivo);
        try {
            ficheiro.delete();
            ficheiro.createNewFile();

            ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(ficheiro));
            obj.writeObject(v);
            obj.close();
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static Vector ler(String arquivo) {
        try {
            File ficheiro = new File(arquivo);
            ObjectInputStream obj = new ObjectInputStream(new FileInputStream(ficheiro));
            v = (Vector<DadosFornecedores>) obj.readObject();
            obj.close();

        } catch (IOException e1) {
            System.out.println("Erro: " + e1.getMessage());
        } catch (ClassNotFoundException e2) {
            System.out.println("Erro: " + e2.getMessage());
        }
        return v;
    }
}
