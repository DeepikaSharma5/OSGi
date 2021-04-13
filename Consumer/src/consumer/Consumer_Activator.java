package consumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import foodservice.Food_Interface;
import vehicleservice.Vehicle_Interface;

public class Consumer_Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Consumer_Activator.context = bundleContext;
		System.out.println("Consumer bundule started.");
		this.MainMethod();
		System.out.println("Consumer service started.");
	}
	
	private void MainMethod() {
		Scanner sc=new Scanner(System.in);
		String user_option="no";
		
		do {
			int serviceType = SubMethod.find();
			
			if(serviceType == 1) {
				ServiceReference service_1 = context.getServiceReference(Vehicle_Interface.class.getName());
				Vehicle_Interface Vehicle_Int =(Vehicle_Interface) context.getService(service_1);
				SubMethod.vehicleService(Vehicle_Int);
				context.ungetService(service_1);
			}
			else if(serviceType == 2) {
				
				ServiceReference service_2 = context.getServiceReference(Food_Interface.class.getName());
				Food_Interface Food_Int =(Food_Interface)context.getService(service_2);
				SubMethod.foodService(Food_Int);
				context.ungetService(service_2);
			}
			else {
				System.out.println("");
			}
			System.out.println("Do you want to exit? \n 'yes' for YES \n 'no' for NO");
			user_option = sc.next();
			
		}while(user_option.equals("no"));	
		SubMethod.PrintBill();
		
	}
	
	public void stop(BundleContext bundleContext) throws Exception {
		Consumer_Activator.context = null;
		System.out.println("Consumer service stopped.");
	}
	
	
}
