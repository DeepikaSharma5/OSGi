package consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import foodservice.Food_Interface;
import vehicleservice.Vehicle_Interface;

public class SubMethod {

	public static  List<Object> stringlist=new ArrayList<Object>();
	public static  List<Object> TotalInvoicelist=new ArrayList<Object>();
	public static float TotalPrice=0;

	//method to select service - All the methods will come here (Vehicle , Food , Hotel)
	public static int find() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Select the type of service\n1. Vehicle Service\n2. Food Service"); 
		System.out.printf("Enter the number :");
		int details = sc.nextInt();
		   //1.vehicle
		   if(details == 1) {
			  return 1;
		   }
		   //2.food - yo can delete this
		   else if(details == 2) {
			   return 2;
		   }
		   else
		   return 0;
	}
	
	//Implementation for vehicle calculation - Copy past this or do them implementations like this
	public static void vehicleService(Vehicle_Interface vehicle) {
		System.out.println("*********************************************");
		System.out.println("       Welcomme to the vehicle service       ");
		System.out.println(" You can rent vehicle from 1 days to 20 days ");
		System.out.println("*********************************************");
		
		Scanner veh = new Scanner(System.in);
		consumer c1 = new consumer();
		
	    System.out.println("\nSelect the type of vehicle");
	    vehicle.ListVehicle();
	    System.out.printf("Enter the number : ");
	    String vehicleType = veh.nextLine();  
	      
		//enter the days for using vehicle
		Scanner scan=new Scanner(System.in);
	
		System.out.println("\n\nPrice list of vehicles accoding to the rent days");
		vehicle.ListPrice();
		System.out.printf("\nSelect the travel range : ");
		int option = scan.nextInt();
		
		String user_option="yes";
		int total=0;
		
		do {
			Scanner s = new Scanner(System.in);
			System.out.printf("Enter the days you need the vehicle : ");
			int day=s.nextInt();
			
			//Calculate the amount by days
			if(day >0 && day <5) {
				System.out.println("Your selection for " + day +" day(s) is success ");		
				total=vehicle.Payment(option)*day;
				TotalPrice=total;
			}
			else if(day <=10 && day>=5) {	
				System.out.println("Your selection for " + day +" day(s) is success ");		
				total=vehicle.Payment(option)*day;
				TotalPrice=total;
			}
			else if(day>10 && day<20) {
				System.out.println("Your selection for " + day +" day(s) is success ");		
				total=vehicle.Payment(option)*day;
				TotalPrice=total;
			}
			else 
				System.out.println("Unexpected error! Please try to input valid days");
			   
				c1.setPayment(total);
				stringlist.add(c1.getPayment());			
				total=0;	
				
				System.out.println("\nIf you want to continue with the same range type 'yes'");
				System.out.println("Or if you want to select another range or new service type no");
				user_option = s.next();
			}
		while(user_option.equals("yes")); 
		
		//printing the bill for gas
				System.out.println("*******************************************************");
				System.out.println("                 VEHICLE SERVICE BILL                  ");
				System.out.println("*******************************************************");
				

				System.out.println("-------------------------------------------------------");   
				System.out.println("                 Total bill: " +TotalPrice);
				System.out.println("*******************************************************");
				System.out.println("              Thank you & Have nice day..!             ");
	 
				stringlist.clear();
				
				c1.setPayment(TotalPrice);

				TotalInvoicelist.add(c1.getPayment());
				TotalPrice=0;
	}
	
	public static void foodService(Food_Interface food) {
		System.out.println("*********************************************");
		System.out.println("        Welcomme to the Food service         ");
		System.out.println("  You can get food for 3, 2 or 1 time a day  ");
		System.out.println("*********************************************");
		
		Scanner veh = new Scanner(System.in);
		consumer c1 = new consumer();
		
	    System.out.println("\nSelect the type of food");
	    food.ListFood();
	    System.out.printf("Enter the number : ");
	    String foodType = veh.nextLine();  
	      
		//enter the days for using vehicle
		Scanner scan=new Scanner(System.in);
	
		System.out.println("\n\nPrice list of food");
		food.ListPrice();
		System.out.printf("\nSelect the food days : ");
		int option = scan.nextInt();
		
		String user_option="yes";
		int total=0;
		
		do {

			Scanner s = new Scanner(System.in);
			System.out.printf("Enter the time you need food : ");
			int dis=s.nextInt();
			
			if(dis == 3) {
				System.out.println("Your selection for " + dis +" day(s) is success ");		
				total=food.Payment(option)*dis;
				TotalPrice=total;
			}
			else if(dis == 2) {	
				System.out.println("Your selection for " + dis +" day(s) is success ");		
				total=food.Payment(option)*dis;
				TotalPrice=total;
			}
			else if(dis == 1) {
				System.out.println("Your selection for " + dis +" day(s) is success ");		
				total=food.Payment(option)*dis;
				TotalPrice=total;
			}
			else 
				System.out.println("Unexpected error! Please try to input valid days");
			   
				c1.setPayment(total);
				stringlist.add(c1.getPayment());			
				total=0;	
				
				System.out.println("Want to continue -yes or no");
				user_option = s.next();	
			}
		while(user_option.equals("yes")); 
		
		//printing the bill for gas
				System.out.println("*******************************************************");
				System.out.println("                 FOOD SERVICE BILL                     ");
				System.out.println("*******************************************************");
				

				System.out.println("-------------------------------------------------------");   
				System.out.println("   	Total bill: " +TotalPrice);
				System.out.println("*******************************************************");
				System.out.println("        Thank you & Have nice day..!                   ");
				
				stringlist.clear();
				
				c1.setPayment(TotalPrice);

				TotalInvoicelist.add(c1.getPayment());
				TotalPrice=0;
	}
	
	//method to access print bill
		public static void PrintBill() {
			
			System.out.println("*******************************************************");
			System.out.println("                 TOTAL INVOICE                         ");
			System.out.println("*******************************************************");
			System.out.println("	 			 Items 	Price                          ");
			
			for(Object obj:TotalInvoicelist) {
				if(obj.getClass()==Integer.class) {
					 System.out.print(" "+obj+" \t");
				}
				if(obj.getClass()==String.class) {

					 System.out.print(" "+obj+" \t ");

				}
				if(obj.getClass()==Float.class) {

					 System.out.print(" "+obj+"\n ");
					 TotalPrice+=(Float)obj;
				}
				
		      }
			
			//printing the bill for total cost
			System.out.println("-------------------------------------------------------");   
			System.out.println("   	         Total bill: " +TotalPrice                  );
			System.out.println("*******************************************************");
			System.out.println("            Thank you & Have nice day..!               ");
			TotalInvoicelist.clear();
			TotalPrice=0;
		}

}




