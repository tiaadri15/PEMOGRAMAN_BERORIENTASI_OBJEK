package implementation;
import Interface.Payment;

public class EWallet implements Payment{
        private String eWalletAccount;
        private String eWalletPin;
    
        public EWallet(String eWalletAccount, String eWalletPin) {
            this.eWalletAccount = eWalletAccount;
            this.eWalletPin = eWalletPin;
        }

        public EWallet(){}
    
        public void makePayment() {
            
            if (validatePIN(eWalletPin)) {
                System.out.println("Processing payment using e-Wallet account " + eWalletAccount);
            } else {
                System.out.println("Invalid PIN. Payment failed.");
            }
        }
        
        private boolean validatePIN(String pin) {
            return true; 
        }
    
        @Override
        public void setPaymentMethod(String method) {
            
        }
    
        @Override
        public String getPaymentMethod() {
            return "E-Wallet";
        }
    
    public String getEWalletAccount() {
        return eWalletAccount;
    }

    public void setEWalletAccount(String eWalletAccount) {
        this.eWalletAccount = eWalletAccount;
    }

    public String getEWalletPin() {
        return eWalletPin;
    }

    public void setEWalletPin(String eWalletPin) {
        this.eWalletPin = eWalletPin;
    }

}
