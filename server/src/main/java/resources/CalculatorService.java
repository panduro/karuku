package resources;

import org.karuku.expression.CompositeExpression;
import org.karuku.expression.EvaluatorImpl;
import org.karuku.expression.PrimitiveExpression;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created with IntelliJ IDEA.
 * User: panduro
 * Date: 8/9/13
 * Time: 1:44 PM
 */
@Path("/calculator")
public class CalculatorService {
    @POST
//    @Path("evaluate")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public PrimitiveExpression evaluate(CompositeExpression expression) {
         return expression.acceptEvaluator(new EvaluatorImpl());
    }
}
