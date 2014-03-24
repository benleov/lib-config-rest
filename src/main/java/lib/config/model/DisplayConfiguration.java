package lib.config.model;

import java.util.Map;

public class DisplayConfiguration {

	
	private Map<String,String> values;
	
	public DisplayConfiguration(Map<String,String> values) {
		this.values = values;
	}
	
	
	public Map<String, String> getValues() {
		return values;
	}
}
