import Customers.*;
import gasBooking.*;
import gasSupplier.*;

import java.text.SimpleDateFormat;
import java.util.*;

import static gasSupplier.gasAgency.*;

public class Main {
    static int count;
    static int bcount=0,ccount=0,dcount=0,pcount=0;
    static String dlname;
    static  String[] months=new String[]{"january","February","March","April","may",
            "June","July","August","September","October","November","December"  };
    public static void cyclinderCount(Delivery[] obj){

        for(Delivery delivery:obj){
            count=0;
            System.out.println("In the Month of "+(months[delivery.dt_2.getMonth()])+":");
            System.out.println(" * In "+delivery.area);

            if(delivery.Status.equals("D")){
                count += delivery.numberOfCylinders;
            }
            System.out.println("-"+count+"Cylinders Delivered");
        }
        System.out.println("\n");
    }
    public static void checklateDel(Delivery[] obj){
        int[] month=new int[12];
        for(Delivery delivery:obj){
            if(delivery.Status.equals("D") && delivery.amount==783.75){
                month[delivery.dt_2.getMonth()]+=1;
            }
        }
        System.out.println("---------------Late Delivery----------------");
        for(int i=0;i<12;i++) {
            if (month[i] != 0) {
                System.out.println("* In" + month[i] + "There are" + month[i]);
            }
        }
        System.out.println("\n");
    }
    public static void numOfSingleCylinders(Delivery[] obj){
        System.out.println("---------------Single Cylinder Holders--------------");
        for(int i=0;i<obj.length;i++){
            if(obj[i].numberOfCylinders==1){
                System.out.println("* Customer Name: "+obj[i].Name);
                System.out.println("* Mobile no: "+obj[i].phNumber);
                System.out.println("* Gas Connection  No: "+(i+101));
            }
        }
        System.out.println("\n");
    }
    public static void DeliveryDetails(Delivery[] obj){
        System.out.println("-----------Delivery Details-------------");
        System.out.println("enter the name of the delivery person");
         dlname = new Scanner(System.in).next();
        for(Delivery delivery:obj){
            if(delivery.Status.equals("D") && delivery.delpersonName.equals(dlname)){
                System.out.println("* Customer Name: "+delivery.Name);
                System.out.println("-"+delivery.street+", "+delivery.area+", "+delivery.pincode);
            }
        }
        System.out.println("\n");
    }
    public static void printReport(Delivery[] obj){
        System.out.println("------------Delivery Report----------");
        for(int i=0;i<obj.length;i++) {
            if (obj[i].Status.equals("D")) {
                dcount++;
            } else if (obj[i].Status.equals("C")) {
                ccount++;
            } else if (obj[i].Status.equals("P")) {
                pcount++;
            } else {
                System.out.println("Status Invalid");
            }
        }
        System.out.println("Booked");
        System.out.println("-"+bcount+"booked");
        System.out.println("Delivered");
        System.out.println("-"+dcount+"delivered");
        System.out.println("Cancelled");
        System.out.println("-"+ccount+"Cancelled");
        System.out.println("Pending");
        System.out.println("-"+pcount+"Pending");
        System.out.println("\n");
    }
    public static void printInvoice(Delivery[] obj){
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        String invoiceDate=sdf.format(d);
        for(int i=0;i<obj.length;i++){
            if(obj[i].Status.equals("D")){
                System.out.println("----------------------------------------------------------------------------------------");
                System.out.println("                                      Invoice                                           ");
                System.out.println("----------------------------------------------------------------------------------------");
                System.out.println("Gas Agency Code :"+agencyCode+"\t\t\t"+"Date of Invoice "+invoiceDate);
                System.out.println("Gas Agency Name :"+agencyName+"\t\t\t"+"Agency Phone Number "+agencyPhNumber);
                System.out.println("Gas Connection No. :"+(i+101)+"\t\t\t"+"Customer Name "+obj[i].Name);
                System.out.println("Booking Date :"+sdf.format(obj[i].dt_1)+"\t\t\t"+"Customer Mobile Number "+obj[i].phNumber);
                System.out.println("----------------------------------------------------------------------------------------");
                System.out.println("Amount"+obj[i].amount);
                System.out.println("Refund"+obj[i].refund);
                System.out.println("Total Amount"+(obj[i]. amount - obj[i].refund));
                System.out.println("----------------------------------------------------------------------------------------");
                System.out.println("Delivery Person Name :"+obj[i].delpersonName+"\t\t\t"+"Delivery Person Phone Number "+obj[i].delPhNumber);
                System.out.println("Delivery Date"+sdf.format(obj[i].dt_2));
                System.out.println("----------------------------------------------------------------------------------------");
                System.out.println("\n\n");
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("---------------------------------------------------");
        System.out.println("               BHARAT GAS AGENCY                   ");
        System.out.println("---------------------------------------------------");
        Delivery[] deliveryObject=new Delivery[5];
        deliveryObject[0]=new Delivery("pancharulroad", "Dibyendu", "Pancharul", "711225", "7584666666", 1);
        deliveryObject[1]=new Delivery("Udaynarayanpurroad", "Rahul", "udaynarayanpur", "711226", "7584566666", 2);
        deliveryObject[2]=new Delivery("Amtaroad", "suvo", "amta", "711401", "7584556666", 2);
        deliveryObject[3]=new Delivery("khilaaroad", "riyan", "khila", "711205", "7584666665", 1);
        deliveryObject[4]=new Delivery("howrahroad", "arko", "howrah", "700011", "7584666655", 1);

        for(Delivery delivery:deliveryObject){
          delivery.delpersondetails();
          delivery.getlastDate();
          delivery.getDates();
          delivery.validate();
          delivery.amountCalc();
          delivery.verifyOtp();
        }
        System.out.println();
        cyclinderCount(deliveryObject);
        checklateDel(deliveryObject);
        numOfSingleCylinders(deliveryObject);
        DeliveryDetails(deliveryObject);
        printReport(deliveryObject);
        printInvoice(deliveryObject);
    }
}
