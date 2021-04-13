package vehicleservice;

public interface Vehicle_Interface {
	public int Payment(int vehicle);
	public void ListVehicle();
	public void ListPrice();
	
	public String good = "Less then 5 days";
	public String better = "With in 10 days";
	public String best = "10 to 20 days";
	
	public int five = 7000;
	public int ten = 6000;
	public int twenty = 5000;
}
