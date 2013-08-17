/**
 * Created by Apache CXF WadlToJava code generator
**/
package application;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/calculator")
public class Resource {

    @POST
    @Consumes("application/xml")
    @Produces("application/xml")
    public Response evaluate() {
        //TODO: implement
        return null;
    }

}