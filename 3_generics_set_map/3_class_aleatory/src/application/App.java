package application;

import java.util.Scanner;

import services.PrintService;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        PrintService<Integer> ps = new PrintService<>();
        PrintService<String> ps = new PrintService<>();

        ps.addValue(1);

        System.out.println("How many values? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value: ");
            Integer value = sc.nextInt();
            ps.addValue(value);
        }

        ps.print();
        System.out.println("First: " + ps.first());
        System.out.println("Second: " + ps.second());
        

        sc.close();

    }
}
