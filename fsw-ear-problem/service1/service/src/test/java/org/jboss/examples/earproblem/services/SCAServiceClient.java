package org.jboss.examples.earproblem.services;

import javax.xml.namespace.QName;

import org.switchyard.remote.RemoteInvoker;
import org.switchyard.remote.RemoteMessage;
import org.switchyard.remote.http.HttpInvoker;

public final class SCAServiceClient {

    private static final QName SERVICE = new QName( "urn:org.jboss.examples.earproblem:service1:1.0", "SampleLogicPortType");
    private static final String URL = "http://localhost:8080/switchyard-remote";

    private static final String TEST_MESSAGE = "message to log\n";

    private SCAServiceClient() {
    }

    public static void main(final String[] ignored) throws Exception {
        // Create a new remote client invoker
        RemoteInvoker invoker = new HttpInvoker(URL);

        // Create the request message
        RemoteMessage message = new RemoteMessage();
        message.setService(SERVICE).setOperation("doLogic").setContent(TEST_MESSAGE);

        // Invoke the service
        invoker.invoke(message);
    }
}
