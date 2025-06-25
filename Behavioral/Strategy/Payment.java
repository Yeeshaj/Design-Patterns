package Behavioral.Strategy;

public class Payment {
    
    public static void main(String[] args) {
      PaymentStrategy creditcard = new CreditCard("123456789");
      PaymentProcessor paymentProcessor = new PaymentProcessor(creditcard);
      paymentProcessor.processPayment(1000);
        
    }
}

class PaymentProcessor {
    private PaymentStrategy paymentStrategy;
    
    public PaymentProcessor(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    void setPaymentStartegy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    void processPayment(double amount){
        paymentStrategy.pay(amount);
    }

}

interface PaymentStrategy {
    void pay(double amount);

}

class UPI implements PaymentStrategy{
   
    String name;
    UPI(String name) {
        this.name = name;
    }

    @Override
    public void pay(double amount) {
       System.out.println("Paid $"+amount+" using UPI : "+name);
    }
    
}

class CreditCard implements PaymentStrategy{
   
    String name;
    CreditCard(String name) {
        this.name = name;
    }

    @Override
    public void pay(double amount) {
       System.out.println("Paid $"+amount+" using Credit Card : "+name);
    }
    
}

class PayPal implements PaymentStrategy{
   
    String name;
    PayPal(String name) {
        this.name = name;
    }

    @Override
    public void pay(double amount) {
       System.out.println("Paid $"+amount+" using PayPal : "+name);
    }
    
}




