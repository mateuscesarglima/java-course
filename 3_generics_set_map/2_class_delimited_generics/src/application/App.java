package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Product;
import services.CalculationServices;

public class App {
    public static void main(String[] args) throws IOException {

        List<Product> list = new ArrayList<>();

        String path = "C:\\workspace\\java-course\\3_generics_set_map\\1_class_introduction_generics\\2_class_delimited_generics\\in.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                list.add(new Product(fields[0], Double.parseDouble(fields[1])));
                line = br.readLine();
            }

            Product x = CalculationServices.max(list);
            System.out.println("MAX: ");
            System.out.println(x);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
