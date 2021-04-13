package vehicleservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Vehicle_Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Vehicle_Activator.context = bundleContext;
		System.out.println("\nVehicle bundule started.");
		this.VehicleService();
		System.out.println("Vehicle service started.\n");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Vehicle_Activator.context = null;
		System.out.println("Vehicle service stopped.");
	}
		
	private void VehicleService(){
		Vehicle_Interface Vehicle_service = new Vehicle_Implementation();
		context.registerService(Vehicle_Interface.class, Vehicle_service,null);
	}

}
