package services;

public class PaypalService implements OnlinePaymentService {

    private static final double PAYMENT_FEE = 0.02;
    private static final double MONTHLY_INTEREST = 0.01;

    public Double paymentFee(Double amount) {
        return amount * PAYMENT_FEE;
    }

    public Double interest(Double amount, Integer months) {

        return amount * months * MONTHLY_INTEREST;
        
    }

}
