package java;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class Questao01 {
    public static void main(String args[]) throws Exception{
        Properties prop = new Properties();
        Scanner scan = new Scanner(new FileInputStream(args[0]));

        try {
            prop.load(Questao01.class.getClassLoader().getResourceAsStream("config.properties"));
            int count = 0;
            String line;

            while (scan.hasNextLine()){
                line = scan.nextLine();
                count++;
                if (count > Integer.valueOf(prop.getProperty("linha_final"))) break;

                if(count >= Integer.valueOf(prop.getProperty("linha_inicial"))){
                    System.out.println(line);
                }
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }
        scan.close();
    }
}
