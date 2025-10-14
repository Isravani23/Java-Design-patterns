public class LiskovSubstitutionPrinciple {
    //Subtypes must be substitutable for their base types—no surprises!

    abstract class Payment {
        public abstract void processPayment(double amount);
    }

    class CreditCardPayment extends Payment {
        public void processPayment(double amount) {
            System.out.println("Processing credit card payment of $" + amount);
        }
    }

    class PayPalPayment extends Payment {
        public void processPayment(double amount) {
            System.out.println("Processing PayPal payment of $" + amount);
        }
    }
/*
    // Usage:
    Payment payment = new CreditCardPayment();
    payment.processPayment(100.0); // Works!
    payment = new PayPalPayment();
    payment.processPayment(200.0); // Also works!*/
}
