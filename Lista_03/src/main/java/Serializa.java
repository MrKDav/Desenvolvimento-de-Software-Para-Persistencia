package lista_03;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.*;
import java.util.*;

public class Serializa {

    //List<Pessoa> objetos = new ArrayList<>();
    ListaDePessoas objetos;

    public Serializa(){
//        objetos.add(new Pessoa("123.456.789-10", "Marcus", "marcus@gmail.com", "(88) 99876-5432"));
//        objetos.add(new Pessoa("109.876.543-21", "João", "joao@gmail.com", "(88) 98233-5182"));
//        objetos.add(new Pessoa("789.101.23-45", "Maria", "maria@gmail.com", "(88) 97687-4652"));

        this.objetos = new ListaDePessoas(new Pessoa("123.456.789-10", "Marcus", "marcus@gmail.com", "(88) 99876-5432"),
                                            new Pessoa("109.876.543-21", "João", "joao@gmail.com", "(88) 98233-5182"),
                                            new Pessoa("789.101.23-45", "Maria", "maria@gmail.com", "(88) 97687-4652"));
    }

    public void apiJava() {
        try {
            FileOutputStream fos = new FileOutputStream("pessoas.txt");
            ObjectOutputStream ois = new ObjectOutputStream(fos);
            ois.writeObject(objetos);
            ois.close();
            fos.close();
            System.out.println("\nApiJava: Todos os objetos serializados com sucesso!".toUpperCase());
        } catch (IOException e){
            System.out.println("ApiJava ERROR: " + e);
        }
    }

    public void json(){
        try {
            ObjectMapper om = new ObjectMapper();
            om.writeValue(new File("pessoas.json"), objetos);
            System.out.println("\nJSON: Todos os objetos serializados com sucesso!".toUpperCase());
        } catch (IOException e){
            System.out.println("JSON ERROR: " + e);
        }
    }

    public void xml(){
        try {
            XmlMapper xm = new XmlMapper();
            xm.writeValue(new File("pessoas.xml"), objetos);

            System.out.println("\nXML: Todos os objetos serializados com sucesso!".toUpperCase());
        } catch (IOException e){
            System.out.println("XML ERROR: " + e);
        }
    }
}
