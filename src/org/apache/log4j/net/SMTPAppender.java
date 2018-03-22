package org.apache.log4j.net;

import com.sina.weibo.sdk.component.GameManager;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import org.apache.http.entity.mime.MIME;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Layout;
import org.apache.log4j.helpers.CyclicBuffer;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.OptionConverter;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.OptionHandler;
import org.apache.log4j.spi.TriggeringEventEvaluator;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.xml.UnrecognizedElementHandler;
import org.w3c.dom.Element;

public class SMTPAppender extends AppenderSkeleton implements UnrecognizedElementHandler {
    static Class class$org$apache$log4j$spi$TriggeringEventEvaluator;
    private String bcc;
    private int bufferSize;
    protected CyclicBuffer cb;
    private String cc;
    protected TriggeringEventEvaluator evaluator;
    private String from;
    private boolean locationInfo;
    protected Message msg;
    private String replyTo;
    private boolean sendOnClose;
    private boolean smtpDebug;
    private String smtpHost;
    private String smtpPassword;
    private int smtpPort;
    private String smtpProtocol;
    private String smtpUsername;
    private String subject;
    private String to;

    class C28011 extends Authenticator {
        private final SMTPAppender this$0;

        C28011(SMTPAppender sMTPAppender) {
            this.this$0 = sMTPAppender;
        }

        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(SMTPAppender.access$000(this.this$0), SMTPAppender.access$100(this.this$0));
        }
    }

    static String access$000(SMTPAppender sMTPAppender) {
        return sMTPAppender.smtpUsername;
    }

    static String access$100(SMTPAppender sMTPAppender) {
        return sMTPAppender.smtpPassword;
    }

    public SMTPAppender() {
        this(new DefaultEvaluator());
    }

    public SMTPAppender(TriggeringEventEvaluator triggeringEventEvaluator) {
        this.smtpPort = -1;
        this.smtpDebug = false;
        this.bufferSize = 512;
        this.locationInfo = false;
        this.sendOnClose = false;
        this.cb = new CyclicBuffer(this.bufferSize);
        this.evaluator = triggeringEventEvaluator;
    }

    public void activateOptions() {
        this.msg = new MimeMessage(createSession());
        try {
            addressMessage(this.msg);
            if (this.subject != null) {
                try {
                    this.msg.setSubject(MimeUtility.encodeText(this.subject, GameManager.DEFAULT_CHARSET, null));
                } catch (Throwable e) {
                    LogLog.error("Unable to encode SMTP subject", e);
                }
            }
        } catch (MessagingException e2) {
            LogLog.error("Could not activate SMTPAppender options.", e2);
        }
        if (this.evaluator instanceof OptionHandler) {
            ((OptionHandler) this.evaluator).activateOptions();
        }
    }

    protected void addressMessage(Message message) throws MessagingException {
        if (this.from != null) {
            message.setFrom(getAddress(this.from));
        } else {
            message.setFrom();
        }
        if (this.replyTo != null && this.replyTo.length() > 0) {
            message.setReplyTo(parseAddress(this.replyTo));
        }
        if (this.to != null && this.to.length() > 0) {
            message.setRecipients(RecipientType.TO, parseAddress(this.to));
        }
        if (this.cc != null && this.cc.length() > 0) {
            message.setRecipients(RecipientType.CC, parseAddress(this.cc));
        }
        if (this.bcc != null && this.bcc.length() > 0) {
            message.setRecipients(RecipientType.BCC, parseAddress(this.bcc));
        }
    }

    protected Session createSession() {
        Properties properties;
        Authenticator authenticator;
        try {
            properties = new Properties(System.getProperties());
        } catch (SecurityException e) {
            properties = new Properties();
        }
        String str = "mail.smtp";
        if (this.smtpProtocol != null) {
            properties.put("mail.transport.protocol", this.smtpProtocol);
            str = new StringBuffer().append("mail.").append(this.smtpProtocol).toString();
        }
        if (this.smtpHost != null) {
            properties.put(new StringBuffer().append(str).append(".host").toString(), this.smtpHost);
        }
        if (this.smtpPort > 0) {
            properties.put(new StringBuffer().append(str).append(".port").toString(), String.valueOf(this.smtpPort));
        }
        if (this.smtpPassword == null || this.smtpUsername == null) {
            authenticator = null;
        } else {
            properties.put(new StringBuffer().append(str).append(".auth").toString(), "true");
            authenticator = new C28011(this);
        }
        Session instance = Session.getInstance(properties, authenticator);
        if (this.smtpProtocol != null) {
            instance.setProtocolForAddress("rfc822", this.smtpProtocol);
        }
        if (this.smtpDebug) {
            instance.setDebug(this.smtpDebug);
        }
        return instance;
    }

    public void append(LoggingEvent loggingEvent) {
        if (checkEntryConditions()) {
            loggingEvent.getThreadName();
            loggingEvent.getNDC();
            loggingEvent.getMDCCopy();
            if (this.locationInfo) {
                loggingEvent.getLocationInformation();
            }
            loggingEvent.getRenderedMessage();
            loggingEvent.getThrowableStrRep();
            this.cb.add(loggingEvent);
            if (this.evaluator.isTriggeringEvent(loggingEvent)) {
                sendBuffer();
            }
        }
    }

    protected boolean checkEntryConditions() {
        if (this.msg == null) {
            this.errorHandler.error("Message object not configured.");
            return false;
        } else if (this.evaluator == null) {
            this.errorHandler.error(new StringBuffer().append("No TriggeringEventEvaluator is set for appender [").append(this.name).append("].").toString());
            return false;
        } else if (this.layout != null) {
            return true;
        } else {
            this.errorHandler.error(new StringBuffer().append("No layout set for appender named [").append(this.name).append("].").toString());
            return false;
        }
    }

    public synchronized void close() {
        this.closed = true;
        if (this.sendOnClose && this.cb.length() > 0) {
            sendBuffer();
        }
    }

    InternetAddress getAddress(String str) {
        try {
            return new InternetAddress(str);
        } catch (AddressException e) {
            this.errorHandler.error(new StringBuffer().append("Could not parse address [").append(str).append("].").toString(), e, 6);
            return null;
        }
    }

    InternetAddress[] parseAddress(String str) {
        try {
            return InternetAddress.parse(str, true);
        } catch (AddressException e) {
            this.errorHandler.error(new StringBuffer().append("Could not parse address [").append(str).append("].").toString(), e, 6);
            return null;
        }
    }

    public String getTo() {
        return this.to;
    }

    public boolean requiresLayout() {
        return true;
    }

    protected String formatBody() {
        StringBuffer stringBuffer = new StringBuffer();
        String header = this.layout.getHeader();
        if (header != null) {
            stringBuffer.append(header);
        }
        int length = this.cb.length();
        for (int i = 0; i < length; i++) {
            LoggingEvent loggingEvent = this.cb.get();
            stringBuffer.append(this.layout.format(loggingEvent));
            if (this.layout.ignoresThrowable()) {
                String[] throwableStrRep = loggingEvent.getThrowableStrRep();
                if (throwableStrRep != null) {
                    for (String append : throwableStrRep) {
                        stringBuffer.append(append);
                        stringBuffer.append(Layout.LINE_SEP);
                    }
                }
            }
        }
        header = this.layout.getFooter();
        if (header != null) {
            stringBuffer.append(header);
        }
        return stringBuffer.toString();
    }

    protected void sendBuffer() {
        int i = 0;
        try {
            BodyPart mimeBodyPart;
            String formatBody = formatBody();
            int i2 = 1;
            for (int i3 = 0; i3 < formatBody.length() && i2 != 0; i3++) {
                if (formatBody.charAt(i3) <= '') {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
            }
            if (i2 != 0) {
                mimeBodyPart = new MimeBodyPart();
                mimeBodyPart.setContent(formatBody, this.layout.getContentType());
            } else {
                try {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    Writer outputStreamWriter = new OutputStreamWriter(MimeUtility.encode(byteArrayOutputStream, "quoted-printable"), GameManager.DEFAULT_CHARSET);
                    outputStreamWriter.write(formatBody);
                    outputStreamWriter.close();
                    InternetHeaders internetHeaders = new InternetHeaders();
                    internetHeaders.setHeader("Content-Type", new StringBuffer().append(this.layout.getContentType()).append("; charset=UTF-8").toString());
                    internetHeaders.setHeader(MIME.CONTENT_TRANSFER_ENC, "quoted-printable");
                    mimeBodyPart = new MimeBodyPart(internetHeaders, byteArrayOutputStream.toByteArray());
                } catch (Exception e) {
                    StringBuffer stringBuffer = new StringBuffer(formatBody);
                    while (i < stringBuffer.length()) {
                        if (stringBuffer.charAt(i) >= '') {
                            stringBuffer.setCharAt(i, '?');
                        }
                        i++;
                    }
                    mimeBodyPart = new MimeBodyPart();
                    mimeBodyPart.setContent(stringBuffer.toString(), this.layout.getContentType());
                }
            }
            MimeMultipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(mimeBodyPart);
            this.msg.setContent(mimeMultipart);
            this.msg.setSentDate(new Date());
            Transport.send(this.msg);
        } catch (MessagingException e2) {
            LogLog.error("Error occured while sending e-mail notification.", e2);
        } catch (Throwable e3) {
            LogLog.error("Error occured while sending e-mail notification.", e3);
        }
    }

    public String getEvaluatorClass() {
        return this.evaluator == null ? null : this.evaluator.getClass().getName();
    }

    public String getFrom() {
        return this.from;
    }

    public String getReplyTo() {
        return this.replyTo;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void setReplyTo(String str) {
        this.replyTo = str;
    }

    public void setSubject(String str) {
        this.subject = str;
    }

    public void setBufferSize(int i) {
        this.bufferSize = i;
        this.cb.resize(i);
    }

    public void setSMTPHost(String str) {
        this.smtpHost = str;
    }

    public String getSMTPHost() {
        return this.smtpHost;
    }

    public void setTo(String str) {
        this.to = str;
    }

    public int getBufferSize() {
        return this.bufferSize;
    }

    public void setEvaluatorClass(String str) {
        Class class$;
        if (class$org$apache$log4j$spi$TriggeringEventEvaluator == null) {
            class$ = class$("org.apache.log4j.spi.TriggeringEventEvaluator");
            class$org$apache$log4j$spi$TriggeringEventEvaluator = class$;
        } else {
            class$ = class$org$apache$log4j$spi$TriggeringEventEvaluator;
        }
        this.evaluator = (TriggeringEventEvaluator) OptionConverter.instantiateByClassName(str, class$, this.evaluator);
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public void setLocationInfo(boolean z) {
        this.locationInfo = z;
    }

    public boolean getLocationInfo() {
        return this.locationInfo;
    }

    public void setCc(String str) {
        this.cc = str;
    }

    public String getCc() {
        return this.cc;
    }

    public void setBcc(String str) {
        this.bcc = str;
    }

    public String getBcc() {
        return this.bcc;
    }

    public void setSMTPPassword(String str) {
        this.smtpPassword = str;
    }

    public void setSMTPUsername(String str) {
        this.smtpUsername = str;
    }

    public void setSMTPDebug(boolean z) {
        this.smtpDebug = z;
    }

    public String getSMTPPassword() {
        return this.smtpPassword;
    }

    public String getSMTPUsername() {
        return this.smtpUsername;
    }

    public boolean getSMTPDebug() {
        return this.smtpDebug;
    }

    public final void setEvaluator(TriggeringEventEvaluator triggeringEventEvaluator) {
        if (triggeringEventEvaluator == null) {
            throw new NullPointerException("trigger");
        }
        this.evaluator = triggeringEventEvaluator;
    }

    public final TriggeringEventEvaluator getEvaluator() {
        return this.evaluator;
    }

    public boolean parseUnrecognizedElement(Element element, Properties properties) throws Exception {
        if (!"triggeringPolicy".equals(element.getNodeName())) {
            return false;
        }
        Class class$;
        if (class$org$apache$log4j$spi$TriggeringEventEvaluator == null) {
            class$ = class$("org.apache.log4j.spi.TriggeringEventEvaluator");
            class$org$apache$log4j$spi$TriggeringEventEvaluator = class$;
        } else {
            class$ = class$org$apache$log4j$spi$TriggeringEventEvaluator;
        }
        Object parseElement = DOMConfigurator.parseElement(element, properties, class$);
        if (parseElement instanceof TriggeringEventEvaluator) {
            setEvaluator((TriggeringEventEvaluator) parseElement);
        }
        return true;
    }

    public final String getSMTPProtocol() {
        return this.smtpProtocol;
    }

    public final void setSMTPProtocol(String str) {
        this.smtpProtocol = str;
    }

    public final int getSMTPPort() {
        return this.smtpPort;
    }

    public final void setSMTPPort(int i) {
        this.smtpPort = i;
    }

    public final boolean getSendOnClose() {
        return this.sendOnClose;
    }

    public final void setSendOnClose(boolean z) {
        this.sendOnClose = z;
    }
}
