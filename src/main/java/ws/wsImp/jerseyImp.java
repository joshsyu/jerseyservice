package ws.wsImp;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class jerseyImp {
	@GET
	public String hello() {
		return "Hello";
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response authenticateUser(Credentials credentials) {

		String username = credentials.getUsername();
		String password = credentials.getPassword();
		// Authenticate the user, issue a token and return a response
		AuthenticationEndPoint auth = new AuthenticationEndPoint();
		if (auth.authenticate(username, password)) {
			return Response.ok(auth.issueToken(username)).build();
		} else {
			return Response.status(Response.Status.FORBIDDEN).build();
		}
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response myUnsecuredMethod(@PathParam("id") Long id) {
		// This method is not annotated with @Secured
		// The authentication filter won't be executed before invoking this
		// method
		return Response.ok("Hi " + id + " no secure").build();
	}

	@POST
	@Secured
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response mySecuredMethod(@PathParam("id") Long id) {
		// This method is annotated with @Secured
		// The authentication filter will be executed before invoking this
		// method
		// The HTTP request must be performed with a valid token
		return Response.ok("Hi " + id + " with secure").build();
	}

}
