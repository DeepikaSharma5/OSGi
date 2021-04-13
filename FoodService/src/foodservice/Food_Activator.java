package foodservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Food_Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Food_Activator.context = bundleContext;
		System.out.println("Food bundule started.");
		this.VehicleService();
		System.out.println("Food service started.");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Food_Activator.context = null;
		System.out.println("Food service stopped.");
	}
		
	private void VehicleService(){
		Food_Interface Travel_service = new Food_Implementation();
		context.registerService(Food_Interface.class, Travel_service,null);
	}


}
