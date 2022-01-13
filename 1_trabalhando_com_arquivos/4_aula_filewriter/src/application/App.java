package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.cert.CertPath;

public class App {
    public static void main(String[] args) throws Exception {

        String[] lines = new String[] { "Good morning", "Good afternoon", "Good Night" };

        String path = "C:\\workspace\\out.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {

            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
