package org.apache.log4j.pattern;

import com.huawei.nfc.carrera.logic.appletcardinfo.model.HciConfigInfo;
import org.apache.log4j.spi.LoggingEvent;

public class RelativeTimePatternConverter extends LoggingEventPatternConverter {
    private CachedTimestamp lastTimestamp = new CachedTimestamp(0, "");

    final class CachedTimestamp {
        private final String formatted;
        private final long timestamp;

        public CachedTimestamp(long j, String str) {
            this.timestamp = j;
            this.formatted = str;
        }

        public boolean format(long j, StringBuffer stringBuffer) {
            if (j != this.timestamp) {
                return false;
            }
            stringBuffer.append(this.formatted);
            return true;
        }
    }

    public RelativeTimePatternConverter() {
        super("Time", HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME);
    }

    public static RelativeTimePatternConverter newInstance(String[] strArr) {
        return new RelativeTimePatternConverter();
    }

    public void format(LoggingEvent loggingEvent, StringBuffer stringBuffer) {
        long j = loggingEvent.timeStamp;
        if (!this.lastTimestamp.format(j, stringBuffer)) {
            String l = Long.toString(j - LoggingEvent.getStartTime());
            stringBuffer.append(l);
            this.lastTimestamp = new CachedTimestamp(j, l);
        }
    }
}
