package lib.config.rest.views;

import lib.config.base.configuration.Configuration;

import org.restlet.ext.json.JsonRepresentation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;

public interface ConfigurationResource {
	@Get("json")
	public JsonRepresentation retrieve();

	@Post
	public void store(Configuration contact);

	@Delete
	public void remove();
}
