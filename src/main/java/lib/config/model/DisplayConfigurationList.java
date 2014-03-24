package lib.config.model;

import java.util.HashMap;
import java.util.Map;

import lib.config.base.configuration.Configuration;
import lib.config.base.configuration.ConfigurationList;

/**
 * Decorate the ConfigurationList with additional functionality that allows it
 * to be converted to JSON and other formats.
 * 
 * @author Benjamin Leov
 * @param <E>
 *
 */
public class DisplayConfigurationList {

	private ConfigurationList<?> list;

	public DisplayConfigurationList(ConfigurationList<?> list) {
		this.list = list;
	}

	public Map<String, DisplayConfiguration> getValues() {

		Map<String,  DisplayConfiguration> configs = new HashMap<String, DisplayConfiguration>();

		for (Configuration curr : this.list.getConfigurations()) {

			
			
			Map<String, String> values = new HashMap<String, String>();

			for (String key : curr.getKeys()) {
				System.out.println("HERE");
				values.put(key, curr.getProperty(key));
			}
			DisplayConfiguration display = new DisplayConfiguration(values);
			
			configs.put(curr.getId(), display);

		}

		return configs;
	}

	public int getSize() {
		return list.size();
	}

}
