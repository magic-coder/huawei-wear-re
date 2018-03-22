package org.apache.log4j.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.xml.DOMConfigurator;

public class JMSSink implements MessageListener {
    static Class class$org$apache$log4j$net$JMSSink;
    static Logger logger;

    static {
        Class class$;
        if (class$org$apache$log4j$net$JMSSink == null) {
            class$ = class$("org.apache.log4j.net.JMSSink");
            class$org$apache$log4j$net$JMSSink = class$;
        } else {
            class$ = class$org$apache$log4j$net$JMSSink;
        }
        logger = Logger.getLogger(class$);
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static void main(String[] strArr) throws Exception {
        if (strArr.length != 5) {
            usage("Wrong number of arguments.");
        }
        String str = strArr[0];
        String str2 = strArr[1];
        String str3 = strArr[2];
        String str4 = strArr[3];
        String str5 = strArr[4];
        if (str5.endsWith(".xml")) {
            DOMConfigurator.configure(str5);
        } else {
            PropertyConfigurator.configure(str5);
        }
        JMSSink jMSSink = new JMSSink(str, str2, str3, str4);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Type \"exit\" to quit JMSSink.");
        do {
        } while (!bufferedReader.readLine().equalsIgnoreCase("exit"));
        System.out.println("Exiting. Kill the application if it does not exit due to daemon threads.");
    }

    public JMSSink(String str, String str2, String str3, String str4) {
        try {
            InitialContext initialContext = new InitialContext();
            TopicConnection createTopicConnection = ((TopicConnectionFactory) lookup(initialContext, str)).createTopicConnection(str3, str4);
            createTopicConnection.start();
            createTopicConnection.createTopicSession(false, 1).createSubscriber((Topic) initialContext.lookup(str2)).setMessageListener(this);
        } catch (JMSException e) {
            logger.error("Could not read JMS message.", e);
        } catch (NamingException e2) {
            logger.error("Could not read JMS message.", e2);
        } catch (Throwable e3) {
            logger.error("Could not read JMS message.", e3);
        }
    }

    public void onMessage(Message message) {
        try {
            if (message instanceof ObjectMessage) {
                LoggingEvent loggingEvent = (LoggingEvent) ((ObjectMessage) message).getObject();
                Logger.getLogger(loggingEvent.getLoggerName()).callAppenders(loggingEvent);
                return;
            }
            logger.warn(new StringBuffer().append("Received message is of type ").append(message.getJMSType()).append(", was expecting ObjectMessage.").toString());
        } catch (JMSException e) {
            logger.error("Exception thrown while processing incoming message.", e);
        }
    }

    protected static Object lookup(Context context, String str) throws NamingException {
        try {
            return context.lookup(str);
        } catch (NameNotFoundException e) {
            logger.error(new StringBuffer().append("Could not find name [").append(str).append("].").toString());
            throw e;
        }
    }

    static void usage(String str) {
        Class class$;
        System.err.println(str);
        PrintStream printStream = System.err;
        StringBuffer append = new StringBuffer().append("Usage: java ");
        if (class$org$apache$log4j$net$JMSSink == null) {
            class$ = class$("org.apache.log4j.net.JMSSink");
            class$org$apache$log4j$net$JMSSink = class$;
        } else {
            class$ = class$org$apache$log4j$net$JMSSink;
        }
        printStream.println(append.append(class$.getName()).append(" TopicConnectionFactoryBindingName TopicBindingName username password configFile").toString());
        System.exit(1);
    }
}
