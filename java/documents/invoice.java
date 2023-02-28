package java.documents;

public class invoice {
    
    private String costumer;
    private boolean finalConsumer;
    private int cuitCuilDocument;
    private int phoneNumber;
    private String emailAddress;
    private double money;


    public void setCuitCuilDocument(int cuitCuilDocument) {
        this.cuitCuilDocument = cuitCuilDocument;
    }
    
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setCostumer(String costumer) {
        this.costumer = costumer;
    }

    public void setFinalConsumer(boolean finalConsumer) {
        this.finalConsumer = finalConsumer;
    }
    
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int getCuitCuilDocument() {
        return cuitCuilDocument;
    }

    public boolean isFinalConsumer() {
        return finalConsumer;
    }

    public double getMoney() {
        return money;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    
    public String getCostumer() {
        return costumer;
    }

    
/*---------------------------------------------------------------------------*/    
    


}
