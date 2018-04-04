import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

// entry class, service url will start with '/secure'
@ApplicationPath("secure")
public class wsEntry extends ResourceConfig {
	public wsEntry() {
		packages("ws.wsImp");
	}
}
