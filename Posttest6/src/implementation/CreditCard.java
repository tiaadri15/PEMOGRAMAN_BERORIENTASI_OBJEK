package implementation;

import Interface.Payment;

public class CreditCard implements Payment {
    private String cardNumber;

    public CreditCard(String cardNumber) throws IllegalArgumentException {
        if (!isValidCreditCardNumber(cardNumber)) {
            throw new IllegalArgumentException("Invalid credit card number!");
        }
        this.cardNumber = cardNumber;
    }

    public CreditCard(){}

    @Override
    public void makePayment() {
        System.out.println("Processing payment using credit card ending with " + getLastFourDigits());
    }

    @Override
    public void setPaymentMethod(String method) {
    
    }

    @Override
    public String getPaymentMethod(){
        return "Credit Card";
    }

    private String getLastFourDigits() {
        return cardNumber.substring(cardNumber.length() - 4);
    }

    private boolean isValidCreditCardNumber(String cardNumber) {
        return cardNumber.matches("^\\d{16}$");
    }
}
