package java;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Serializa {
    List<Pessoa> objetos = new ArrayList<>();

    public Serializa(){
        objetos.add(new Pessoa("123.456.789-10", "Marcus", "marcus@gmail.com", "(88) 99876-5432"));
        objetos.add(new Pessoa("109.876.543-21", "João", "joao@gmail.com", "(88) 98233-5182"));
        objetos.add(new Pessoa("789.101.23-45", "Maria", "maria@gmail.com", "(88) 97687-4652"));
    }

    class SimpleBean {
        private int x = 1;
        private int y = 2;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    public void apiJava() {
        try {
            FileOutputStream fos = new FileOutputStream("pessoas.txt");
            ObjectOutputStream ois = new ObjectOutputStream(fos);
            for(int i = 0; i < objetos.size(); i++){
                ois.writeObject(objetos.get(i));

                System.out.println("ApiJava: Objeto " + i + ", serializado!");
                System.out.println(objetos.get(i).toString());
            }
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
            for(int i = 0; i < objetos.size(); i++){
                om.writeValue(new File("pessoas.json"), objetos.get(i));

                System.out.println("JSON: Objeto " + i + ", serializado!");
                System.out.println(objetos.get(i).toString());
            }
            System.out.println("\nJSON: Todos os objetos serializados com sucesso!".toUpperCase());
        } catch (IOException e){
            System.out.println("JSON ERROR: " + e);
        }
    }

    public void xml(){
        try {
            XmlMapper xm = new XmlMapper();
            PrintWriter pw = new PrintWriter(new FileWriter("pesssoas.xml", true));
            pw.println("<Pessoas>");
            for(int i = 0; i < 3; i++){
                xm.writeValue(new PrintWriter(new FileWriter("pesssoas.xml", true)), objetos.get(i));
                //File file = new File("simple_bean.xml");
                //assertNotNull(file);
                System.out.println("XML: Objeto " + i + ", serializado!");
                System.out.println(objetos.get(i).toString());

            }
            pw.print("\n</Pessoas>");
            System.out.println("\nXML: Todos os objetos serializados com sucesso!".toUpperCase());
        } catch (IOException e){
            System.out.println("XML ERROR: " + e);
        }
    }
}
