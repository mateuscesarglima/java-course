package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        File file = new File("C:\\workspace\\java-course\\1_trabalhando_com_arquivos\\1_aula\\in.txt");

        Scanner sc = null;

        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        // Boa prática colocar o fechamento do scanner em um bloco finally, pois o
        // recurso vai ser fechado indenpendetemente se deu certo ou não o try catch.
        finally {
            if (sc != null) {
                sc.close();
            }
        }

    }
}
