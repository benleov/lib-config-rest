package lib.config.rest;

import org.restlet.Component;
import org.restlet.data.Protocol;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class ListConfigurations extends ServerResource {

	public static void main(String[] args) {
		try {
		    Component component = new Component();  
		    component.getServers().add(Protocol.HTTP, 8080);  
		  
		    // Then attach it to the local host  
		    component.getDefaultHost().attach("/", ListConfigurations.class);  
		    component.getDefaultHost().attach("/config", ConfigurationView.class); 
		    component.getDefaultHost().attach("/config/edit", ConfigurationEdit.class); 
		    component.getDefaultHost().attach("/config/delete", ConfigurationDelete.class);
		    component.getDefaultHost().attach("/config/new", ConfigurationNew.class);
		    
		    // Now, let's start the component!  
		    // Note that the HTTP server connector is also automatically started
		    
		    component.start();
		    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Get
	public String toString() {
		return "Here we list all configurations";
	}
}
