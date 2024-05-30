package gasSupplier;

public interface gasAgency {
    public String agencyName="Bharat Gas";
    public int agencyCode=1234;
    public int agencyPhNumber=180001;

    default void agencyDisplay(){
        System.out.println("The Agency Name is "+agencyName);
        System.out.println("The Agency Code is "+agencyCode);
        System.out.println("The Agency Phone Number is "+agencyPhNumber);
    }
}
