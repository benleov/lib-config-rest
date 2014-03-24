package lib.config.rest;

import java.io.File;

import lib.config.base.configuration.ConfigurationException;
import lib.config.base.configuration.ConfigurationList;
import lib.config.base.configuration.factory.ConfigurationFactory;
import lib.config.base.configuration.impl.BasicConfiguration;
import lib.config.base.configuration.persist.AbstractPersister;
import lib.config.base.configuration.persist.impl.IniPersister;
import lib.config.rest.views.ConfigurationServerResource;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigApp extends Application {
	private static final Logger logger = LoggerFactory
			.getLogger(ConfigApp.class);
	
	private AbstractPersister<?> persister;

	@Override
	public Restlet createInboundRoot() {

		Router router = new Router(getContext());
 		router.attach("/", ConfigurationServerResource.class);
		return router;
	}

	public ConfigApp(AbstractPersister<?> persister) throws Exception {

		this.persister = persister;


		// // ConfigurationView view = new ConfigurationView();
		// ConfigurationEdit edit = new ConfigurationEdit();
		// ConfigurationDelete delete = new ConfigurationDelete();
		// ConfigurationNew newConfig = new ConfigurationNew();

		// Then attach it to the local host

		// component.getDefaultHost().attach(ConfigurationView.class);
		// component.getDefaultHost().attach("/config/edit", edit);
		// component.getDefaultHost().attach("/config/delete", delete);
		// component.getDefaultHost().attach("/config/new", newConfig;

		// Now, let's start the component!
		// Note that the HTTP server connector is also automatically started

	}

	public static void main(String[] args) throws ConfigurationException {
		
//		Engine.getInstance().getRegisteredConverters().add(new JsonConverter());
//		Engine.getInstance().getRegisteredConverters().add(new XmlConverter());
		
		logger.info("Starting");
		
		File temp = new File("test.ini");

		IniPersister<BasicConfiguration> persister = new IniPersister<BasicConfiguration>(
				new ConfigurationFactory<BasicConfiguration>() {

					@Override
					public BasicConfiguration buildConfiguration(String id) {
						return new BasicConfiguration(id);
					}
				}, temp);	

		
		ConfigurationList<?> list = persister.read();
		System.out.println("LIST SIZE: " + list.size());
		
		ConfigurationServerResource.setPersister(persister);
		
		try {

			ConfigApp app = new ConfigApp(persister);
			
			Component component = new Component();
			component.getServers().add(Protocol.HTTP, 8080);
			component.getDefaultHost().attach(app);
			component.start();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
