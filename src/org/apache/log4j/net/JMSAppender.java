package org.apache.log4j.net;

import java.util.Hashtable;
import java.util.Properties;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.spi.LoggingEvent;

public class JMSAppender extends AppenderSkeleton {
    String initialContextFactoryName;
    boolean locationInfo;
    String password;
    String providerURL;
    String securityCredentials;
    String securityPrincipalName;
    String tcfBindingName;
    String topicBindingName;
    TopicConnection topicConnection;
    TopicPublisher topicPublisher;
    TopicSession topicSession;
    String urlPkgPrefixes;
    String userName;

    public void setTopicConnectionFactoryBindingName(String str) {
        this.tcfBindingName = str;
    }

    public String getTopicConnectionFactoryBindingName() {
        return this.tcfBindingName;
    }

    public void setTopicBindingName(String str) {
        this.topicBindingName = str;
    }

    public String getTopicBindingName() {
        return this.topicBindingName;
    }

    public boolean getLocationInfo() {
        return this.locationInfo;
    }

    public void activateOptions() {
        try {
            Context initialContext;
            LogLog.debug("Getting initial context.");
            if (this.initialContextFactoryName != null) {
                Hashtable properties = new Properties();
                properties.put("java.naming.factory.initial", this.initialContextFactoryName);
                if (this.providerURL != null) {
                    properties.put("java.naming.provider.url", this.providerURL);
                } else {
                    LogLog.warn("You have set InitialContextFactoryName option but not the ProviderURL. This is likely to cause problems.");
                }
                if (this.urlPkgPrefixes != null) {
                    properties.put("java.naming.factory.url.pkgs", this.urlPkgPrefixes);
                }
                if (this.securityPrincipalName != null) {
                    properties.put("java.naming.security.principal", this.securityPrincipalName);
                    if (this.securityCredentials != null) {
                        properties.put("java.naming.security.credentials", this.securityCredentials);
                    } else {
                        LogLog.warn("You have set SecurityPrincipalName option but not the SecurityCredentials. This is likely to cause problems.");
                    }
                }
                initialContext = new InitialContext(properties);
            } else {
                initialContext = new InitialContext();
            }
            LogLog.debug(new StringBuffer().append("Looking up [").append(this.tcfBindingName).append("]").toString());
            TopicConnectionFactory topicConnectionFactory = (TopicConnectionFactory) lookup(initialContext, this.tcfBindingName);
            LogLog.debug("About to create TopicConnection.");
            if (this.userName != null) {
                this.topicConnection = topicConnectionFactory.createTopicConnection(this.userName, this.password);
            } else {
                this.topicConnection = topicConnectionFactory.createTopicConnection();
            }
            LogLog.debug("Creating TopicSession, non-transactional, in AUTO_ACKNOWLEDGE mode.");
            this.topicSession = this.topicConnection.createTopicSession(false, 1);
            LogLog.debug(new StringBuffer().append("Looking up topic name [").append(this.topicBindingName).append("].").toString());
            Topic topic = (Topic) lookup(initialContext, this.topicBindingName);
            LogLog.debug("Creating TopicPublisher.");
            this.topicPublisher = this.topicSession.createPublisher(topic);
            LogLog.debug("Starting TopicConnection.");
            this.topicConnection.start();
            initialContext.close();
        } catch (JMSException e) {
            this.errorHandler.error(new StringBuffer().append("Error while activating options for appender named [").append(this.name).append("].").toString(), e, 0);
        } catch (NamingException e2) {
            this.errorHandler.error(new StringBuffer().append("Error while activating options for appender named [").append(this.name).append("].").toString(), e2, 0);
        } catch (Exception e3) {
            this.errorHandler.error(new StringBuffer().append("Error while activating options for appender named [").append(this.name).append("].").toString(), e3, 0);
        }
    }

    protected Object lookup(Context context, String str) throws NamingException {
        try {
            return context.lookup(str);
        } catch (NameNotFoundException e) {
            LogLog.error(new StringBuffer().append("Could not find name [").append(str).append("].").toString());
            throw e;
        }
    }

    protected boolean checkEntryConditions() {
        String str = null;
        if (this.topicConnection == null) {
            str = "No TopicConnection";
        } else if (this.topicSession == null) {
            str = "No TopicSession";
        } else if (this.topicPublisher == null) {
            str = "No TopicPublisher";
        }
        if (str == null) {
            return true;
        }
        this.errorHandler.error(new StringBuffer().append(str).append(" for JMSAppender named [").append(this.name).append("].").toString());
        return false;
    }

    public synchronized void close() {
        if (!this.closed) {
            LogLog.debug(new StringBuffer().append("Closing appender [").append(this.name).append("].").toString());
            this.closed = true;
            try {
                if (this.topicSession != null) {
                    this.topicSession.close();
                }
                if (this.topicConnection != null) {
                    this.topicConnection.close();
                }
            } catch (JMSException e) {
                LogLog.error(new StringBuffer().append("Error while closing JMSAppender [").append(this.name).append("].").toString(), e);
            } catch (Throwable e2) {
                LogLog.error(new StringBuffer().append("Error while closing JMSAppender [").append(this.name).append("].").toString(), e2);
            }
            this.topicPublisher = null;
            this.topicSession = null;
            this.topicConnection = null;
        }
    }

    public void append(LoggingEvent loggingEvent) {
        if (checkEntryConditions()) {
            try {
                ObjectMessage createObjectMessage = this.topicSession.createObjectMessage();
                if (this.locationInfo) {
                    loggingEvent.getLocationInformation();
                }
                createObjectMessage.setObject(loggingEvent);
                this.topicPublisher.publish(createObjectMessage);
            } catch (JMSException e) {
                this.errorHandler.error(new StringBuffer().append("Could not publish message in JMSAppender [").append(this.name).append("].").toString(), e, 0);
            } catch (Exception e2) {
                this.errorHandler.error(new StringBuffer().append("Could not publish message in JMSAppender [").append(this.name).append("].").toString(), e2, 0);
            }
        }
    }

    public String getInitialContextFactoryName() {
        return this.initialContextFactoryName;
    }

    public void setInitialContextFactoryName(String str) {
        this.initialContextFactoryName = str;
    }

    public String getProviderURL() {
        return this.providerURL;
    }

    public void setProviderURL(String str) {
        this.providerURL = str;
    }

    String getURLPkgPrefixes() {
        return this.urlPkgPrefixes;
    }

    public void setURLPkgPrefixes(String str) {
        this.urlPkgPrefixes = str;
    }

    public String getSecurityCredentials() {
        return this.securityCredentials;
    }

    public void setSecurityCredentials(String str) {
        this.securityCredentials = str;
    }

    public String getSecurityPrincipalName() {
        return this.securityPrincipalName;
    }

    public void setSecurityPrincipalName(String str) {
        this.securityPrincipalName = str;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setLocationInfo(boolean z) {
        this.locationInfo = z;
    }

    protected TopicConnection getTopicConnection() {
        return this.topicConnection;
    }

    protected TopicSession getTopicSession() {
        return this.topicSession;
    }

    protected TopicPublisher getTopicPublisher() {
        return this.topicPublisher;
    }

    public boolean requiresLayout() {
        return false;
    }
}
