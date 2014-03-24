package lib.config.rest.views;

import lib.config.base.configuration.Configuration;
import lib.config.base.configuration.ConfigurationException;
import lib.config.base.configuration.ConfigurationList;
import lib.config.base.configuration.persist.AbstractPersister;
import lib.config.model.DisplayConfigurationList;

import org.restlet.ext.json.JsonRepresentation;
import org.restlet.resource.ServerResource;

public class ConfigurationServerResource extends ServerResource implements
		ConfigurationResource {

	private static AbstractPersister<?> persister;

	public static void setPersister(AbstractPersister<?> persister) {
		ConfigurationServerResource.persister = persister;
	}

	@Override
	public JsonRepresentation retrieve() {
		
		try {
			ConfigurationList<?>  list = persister.read();
			return new JsonRepresentation(new DisplayConfigurationList(list));
		} catch (ConfigurationException e) {
			return new JsonRepresentation(e);
		}
	}

	@Override
	public void store(Configuration config) {
		// TODO
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doInit() {

	}

}
