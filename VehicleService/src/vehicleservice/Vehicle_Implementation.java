package vehicleservice;

public class Vehicle_Implementation implements Vehicle_Interface {

	@Override
	public int Payment(int vehicle) {
		// TODO Auto-generated method stub
		if(vehicle == 1) {
			System.out.println("Less than 5 days");
			return Vehicle_Interface.five;
		}else if(vehicle == 2){
			System.out.println("With in 10 days");
			return Vehicle_Interface.ten;
		}	
		else if(vehicle == 3){
			System.out.println("10 to 20 days");
			return Vehicle_Interface.twenty;
		}				
		else {
			System.out.println("Invalid input");
			return 0;
		}
	}

	@Override
	public void ListVehicle() {
		// TODO Auto-generated method stub
		System.out.println("1 : Car");
		System.out.println("2 : Jeep");
		System.out.println("3 : Van");
		System.out.println("4 : Bus");
	}

	@Override
	public void ListPrice() {
		// TODO Auto-generated method stub
		System.out.println("1 : Less than 5 days " +Vehicle_Interface.five+".00 lkr per day");
		System.out.println("2 : With in 10 days " +Vehicle_Interface.ten+".00 lkr per day");
		System.out.println("3 : More than 10 days " +Vehicle_Interface.twenty+".00 lkr per day");
		
	}

}
