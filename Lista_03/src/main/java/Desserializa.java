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
            for (int i = 0; i < 3; i++){
                objetos.add((Pessoa) oin.readObject());
                System.out.println(objetos.get(i).toString());
            }
            oin.close();
            System.out.println("\nTODOS OS ARQUIVOS DESSERIALIZADOS COM SUCESSO!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
