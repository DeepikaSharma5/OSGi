package foodservice;

public class Food_Implementation implements Food_Interface{

	@Override
	public int Payment(int food) {
		// TODO Auto-generated method stub
		if(food == 1) {
			System.out.println("Full-Meals");
			return Food_Interface.five;
		}else if(food == 2){
			System.out.println("One-Time per day");
			return Food_Interface.ten;
		}	
		else if(food == 3){
			System.out.println("Two-times per day");
			return Food_Interface.twenty;
		}				
		else {
			System.out.println("Invalid input");
			return 0;
		}
	}

	@Override
	public void ListFood() {
		// TODO Auto-generated method stub
		System.out.println("1 : Local");
		System.out.println("2 : Chineese");
		System.out.println("3 : Itallion");
		System.out.println("4 : French");
		
	}

	@Override
	public void ListPrice() {
		// TODO Auto-generated method stub
		System.out.println("1 : Ful-Meals " +Food_Interface.five+".00 lkr");
		System.out.println("2 : One time a day " +Food_Interface.ten+".00 lkr");
		System.out.println("1 : Two time a day " +Food_Interface.twenty+".00 lkr");
		
	}

	
}
