package org.karuku.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import generated.*;

import javax.ws.rs.core.MediaType;

/**
 * Created with IntelliJ IDEA.
 * User: panduro
 * Date: 8/16/13
 * Time: 10:54 AM
 */
public class CalculatorClient {
    private static CalculatorClient instance;

    private final Client client = Client.create();

    private WebResource webResource;

    public static CalculatorClient getInstance() {
        if (instance == null)
            throw new IllegalStateException("Client not created. Use one of CalculatorClient.createInstance methods.");

        return instance;
    }

    public static CalculatorClient createInstance(String host, String port) {
        if (instance != null)
            throw new IllegalStateException("Client already created. Use CalculatorClient.getInstance().");

        return instance = new CalculatorClient(host, port);
    }

    public static CalculatorClient createInstance() {
        return createInstance("localhost", "9998");
    }

    private CalculatorClient(String host, String port) {
        webResource = client.resource("http://"+host+":"+port+"/calculator");
    }

    private CalculatorClient() {
    }

    public PrimitiveExpression evaluate(CompositeExpression expressionToEvaluate) {
        ClientResponse response = webResource
//                .path("evaluate")
                .type(MediaType.APPLICATION_XML)
                .post(ClientResponse.class, expressionToEvaluate);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed: HTTP status: "
                    + response.getStatus() + "(expected 200).");
        }

        return response.getEntity(PrimitiveExpression.class);
    }
}
