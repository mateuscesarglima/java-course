package services;

import entities.CarRental;
import entities.Invoice;

public class RentalServices{

    private Double pricePerHour;

    private Double pricePerDay;

    private TaxService taxService;

    public RentalServices() {
    }

    public RentalServices(Double pricePerHour, Double pricePerDay, TaxService taxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }

    public Double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public void processInvoice(CarRental carRental) {
        // Por padrão pega-se o tempo em milisegundos
        long t1 = carRental.getStart().getTime();
        long t2 = carRental.getFinish().getTime();
        double hours = (double) (t2 - t1) / 1000 / 60 / 60;

        double basicPayment;

        if (hours < 12.0) {
            basicPayment = pricePerHour * Math.ceil(hours);
        } else {
            basicPayment = pricePerDay * Math.ceil(hours / 24);
        }

        double tax = taxService.Tax(basicPayment);

        carRental.setInvoice(new Invoice(basicPayment, tax));
    }
}
