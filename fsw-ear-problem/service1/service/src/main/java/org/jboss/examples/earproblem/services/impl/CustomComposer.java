package org.jboss.examples.earproblem.services.impl;

import org.jboss.as.naming.context.NamespaceContextSelector;
import org.switchyard.Exchange;
import org.switchyard.Message;
import org.switchyard.component.common.label.EndpointLabel;
import org.switchyard.component.soap.composer.SOAPBindingData;
import org.switchyard.component.soap.composer.SOAPContextMapper;
import org.switchyard.component.soap.composer.SOAPMessageComposer;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class CustomComposer extends SOAPMessageComposer {

    @Override
    public Message compose(SOAPBindingData source, Exchange exchange) throws Exception {
        Boolean pushedContext = false;
        Message message = null;
        try {
            message = super.compose(source, exchange);
            NamespaceContextSelector contextSelector = (NamespaceContextSelector)
                exchange.getConsumer().getDomain().getProperty("contextSelector");
            if (contextSelector != null) {
                pushedContext = true;
                NamespaceContextSelector.pushCurrentSelector(contextSelector);
            }
            //DoLogic logic = message.getContent(DoLogic.class);
            //System.out.println("Message body: " + logic.getMessage());
            try {
                System.out.println("Context .... " + (new javax.naming.InitialContext().lookup("java:comp")));
            } catch (Exception e) {
                System.out.println("Error .... " + e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (pushedContext) {
                NamespaceContextSelector.popCurrentSelector();
            }
        }
        return message;
    }

}
