package java.documents;
import java.util.*;
import java.util.stream.Stream;
import java.documents.invoice;

public class order {
    
    private String[] product;
    private int amountOfProducts;
    private invoice ticket;

    public void setProduct(String[] product) {
        this.product = product;
    }
    public void setAmountOfProducts(int amountOfProducts) {
        this.amountOfProducts = amountOfProducts;
    }
    public void setTicket(invoice ticket) {
        this.ticket = ticket;
    }

    public String[] getProduct() {
        return product;
    }
    public int getAmountOfProducts() {
        return amountOfProducts;
    }
    public invoice getTicket() {
        return ticket;
    }

    public void addProducts (String newProduct){
        
    }

    

}
