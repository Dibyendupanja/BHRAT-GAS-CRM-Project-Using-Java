package gasBooking;
import Customers.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class Booking extends GasConnection {
    public double otp = 567890, amount = 825.00, refund = 0;
    public String dt, deldate, Status;
    public Date dt_1;
    public Date dt_2;

    public Booking(String street, String name, String area, String pincode, String phNumber, int numberOfCylinders) {
        super(street, name, area, pincode, phNumber, numberOfCylinders);
    }

    public void getDates() {
        System.out.println("Enter the Booking Date");
        dt = new Scanner(System.in).next();
        dt_1 = null;
        try {
            dt_1 = dateFormat.parse(dt);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        } catch (Exception exp) {
            System.out.println("error to getDate function" + exp);
        }
        //delivery date
        System.out.println("Enter delivery date");
        deldate = new Scanner(System.in).nextLine();
        try {
            dt_2 = dateFormat.parse(deldate);
        } catch (Exception e) {
            System.out.println("error parsing second date" + e);
        }
        //try to find difference beetween two days
        try {
            long difference = dt_2.getTime() - dt_1.getTime();
            //difference in days
            long newDifference = TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
            if (newDifference > 7) {
                Status = "p";
            }
        } catch (Exception e) {
            System.out.println("error while finding difference" + e);
        }

    }

    public void validate() {
        //get difference between two days
        long elapsedms = dt_1.getTime() - lastDate.getTime();
        long diff = TimeUnit.DAYS.convert(elapsedms, TimeUnit.MILLISECONDS);
        System.out.println("difference between two dates is :" + diff);
        if (numberOfCylinders == 1) {
            if (diff < 30) {
                System.out.println("Booking cannot be Done");
                Status = "C";
            } else {
                // System.out.println("Booked");
                Status = "B";
                lastDate = dt_1;
            }
        } else if (numberOfCylinders == 2) {
            if (diff < 50) {
                System.out.println("Booking cannot be done");
                Status = "C";

            } else {
                //System.out.println("Booked");
                Status = "B";
                lastDate = dt_1;
            }

        }
    }
}

