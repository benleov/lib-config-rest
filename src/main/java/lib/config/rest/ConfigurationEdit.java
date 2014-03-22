package lib.config.rest;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class ConfigurationEdit extends ServerResource {

	@Get
	public String toString() {

		// Print the requested URI path
		return "Resource URI  : " + getReference() + '\n' + "Root URI      : "
				+ getRootRef() + '\n' + "Routed part   : "
				+ getReference().getBaseRef() + '\n' + "Remaining part: "
				+ getReference().getRemainingPart();
	}
}
