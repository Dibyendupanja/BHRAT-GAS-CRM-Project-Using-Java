package Customers;
import gasSupplier.gasAgency;
public class Customer implements gasAgency {

    public String Name;
    public String street;
    public String area;
    public String pincode;
    public String phNumber;


    public Customer(String street, String name, String area, String pincode, String phNumber) {
        this.street = street;
        this.Name = name;
        this.area = area;
        this.pincode = pincode;
        this.phNumber = phNumber;
    }
}
