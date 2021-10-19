package java;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Desserializa {
    List<Pessoa> objetos = new ArrayList<>();

    public void desserializa(){
        try {
            FileInputStream fis = new FileInputStream("pessoas.txt");
            ObjectInputStream oin = new ObjectInputStream(fis);
            ListaDePessoas lp = (ListaDePessoas) oin.readObject();
            oin.close();
            fis.close();
            for (Pessoa p:lp.getPessoas()) {
                System.out.println(p);
            }
            System.out.println("\nTODOS OS ARQUIVOS DESSERIALIZADOS COM SUCESSO!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
