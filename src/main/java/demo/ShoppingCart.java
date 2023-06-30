package demo;


import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;

@Component
public class ShoppingCart {

    //Logging
    //Authentication & Authorization
    //Sanitize the Data
    public void checkout() {
        System.out.println("Checkout Method from ShoppingCart Called.");
    }

    public void checkout(String param) {
        System.out.println("Checkout Method from ShoppingCart Called with param : " + param);
    }

    public int quantity() {
        return 2;
    }

    public void printThrowException(){
        System.out.println("Exception raised");
        throw new IllegalArgumentException();
    }
}
