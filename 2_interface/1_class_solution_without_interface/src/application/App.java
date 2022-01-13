package application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.CarRental;
import entities.Vehicle;
import services.BrazilTaxService;
import services.RentalServices;

public class App {
    public static void main(String[] args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        

        System.out.println("Enter rental data: ");
        System.out.print("Car model: ");
        String model = sc.nextLine();

        System.out.print("Pickup (dd/MM/yyyy hh:mm): ");
        Date pickup = sdf.parse(sc.nextLine());

        System.out.print("Return (dd/MM/yyyy hh:mm): ");
        Date finish = sdf.parse(sc.nextLine());

        CarRental carRental = new CarRental(pickup, finish, new Vehicle(model));

        System.out.print("Enter price per hour: ");
        double pricePerHour = sc.nextDouble();

        System.out.print("Enter price per Day: ");
        double pricePerDay = sc.nextDouble();

        RentalServices services = new RentalServices(pricePerHour, pricePerDay, new BrazilTaxService());

        services.processInvoice(carRental);

        System.out.println("INVOICE: ");

        System.out.println("Basic payment: " + String.format("%.2f", carRental.getInvoice().getBasicPayment()));
        System.out.println("Tax: " + String.format("%.2f", carRental.getInvoice().getTax()));
        System.out.println("Total payment: " + String.format("%.2f", carRental.getInvoice().totalPayment()));

        sc.close();
    }
}
