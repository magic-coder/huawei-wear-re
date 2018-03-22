package org.apache.log4j.pattern;

import cn.com.fmsh.communication.message.constants.Constants.XMLNode.XMLMessage;
import com.sina.weibo.sdk.constant.WBConstants;
import org.apache.log4j.spi.LoggingEvent;

public final class MessagePatternConverter extends LoggingEventPatternConverter {
    private static final MessagePatternConverter INSTANCE = new MessagePatternConverter();

    private MessagePatternConverter() {
        super(XMLMessage.MESSAGE, WBConstants.ACTION_LOG_TYPE_MESSAGE);
    }

    public static MessagePatternConverter newInstance(String[] strArr) {
        return INSTANCE;
    }

    public void format(LoggingEvent loggingEvent, StringBuffer stringBuffer) {
        stringBuffer.append(loggingEvent.getRenderedMessage());
    }
}
