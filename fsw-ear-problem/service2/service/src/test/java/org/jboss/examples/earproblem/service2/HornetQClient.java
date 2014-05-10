package org.jboss.examples.earproblem.service2;

import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.switchyard.component.test.mixins.hornetq.HornetQMixIn;

public final class HornetQClient {

    private static final String QUEUE = "MessageLoggerQueue";
    private static final String USER = "guest";
    private static final String PASSWD = "Guestp123!";

    private HornetQClient() {
    }

    public static void main(final String[] args) throws Exception {
        HornetQMixIn hqMixIn = new HornetQMixIn(false)
            .setUser(USER)
            .setPassword(PASSWD);
        if (args.length == 0) {
            System.err.println("ERROR: Use -Dexec.args to pass a name and language value, e.g. -Dexec.args=\"Skippy english\"");
            return;
        }

        hqMixIn.initialize();

        try {
            final Session session = hqMixIn.createJMSSession();
            final MessageProducer producer = session.createProducer(HornetQMixIn.getJMSQueue(QUEUE));
            final TextMessage message = session.createTextMessage();
            message.setText("message to log");
            producer.send(message);

            System.out.println("Sent message [" + message + "]");
            Thread.sleep(2000);
        } finally {
            hqMixIn.uninitialize();
        }
    }
}
