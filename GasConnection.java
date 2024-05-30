package Customers;

import java.text.SimpleDateFormat;
import java.util.*;


public class GasConnection extends Customer {
   public int numberOfCylinders;
    String date;
    static int connectionNumber = 100;

    {
        connectionNumber += 1;
    }

    public Date lastDate = null;
    public SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public GasConnection(String street, String name, String area, String pincode, String phNumber, int numberOfCylinders) {
        super(street, name, area, pincode, phNumber);
        this.numberOfCylinders = numberOfCylinders;
    }

    public void getlastDate() {
        System.out.println("Enter the Last Date");
        date = new Scanner(System.in).nextLine();
        try {
            lastDate = dateFormat.parse(date);
        } catch (Exception e) {
            System.out.println("error to getDate" + e);
        }
    }


}
