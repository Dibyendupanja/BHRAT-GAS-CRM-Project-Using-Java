package gasBooking;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Delivery extends Booking {
    public String delpersonName,delPhNumber;
    int customerotp;

    public Delivery(String street, String name, String area, String pincode, String phNumber, int numberOfCylinders) {
        super(street, name, area, pincode, phNumber, numberOfCylinders);
    }

    public void amountCalc() {
        long dayDiff = dt_2.getTime() - dt_1.getTime();
        long newDiff = TimeUnit.DAYS.convert(dayDiff, TimeUnit.MILLISECONDS);
        if (newDiff > 7) {
            refund = 41.25;
            amount = amount - refund;
        }
    }

    public void verifyOtp() {
        if (Status.equals("B")) {
            System.out.println("Enter otp :");
            customerotp = new Scanner(System.in).nextInt();
            if (customerotp != otp) {
                Status = "C";
            } else {
                Status = "D";
            }
        }else{
                System.out.println("No Booking Found!!!");
            }
        }
        public void delpersondetails(){
            System.out.println("\n Enter Delivery person name");
            delpersonName=new Scanner(System.in).nextLine();
        }
    }
