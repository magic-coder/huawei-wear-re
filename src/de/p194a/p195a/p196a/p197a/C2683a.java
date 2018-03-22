package de.p194a.p195a.p196a.p197a;

import android.util.Log;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Layout;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.Priority;
import org.apache.log4j.spi.LoggingEvent;

/* compiled from: LogCatAppender */
public class C2683a extends AppenderSkeleton {
    protected Layout f9094a;

    public C2683a(Layout layout, Layout layout2) {
        this.f9094a = layout2;
        setLayout(layout);
    }

    public C2683a(Layout layout) {
        this(layout, new PatternLayout("%c"));
    }

    public C2683a() {
        this(new PatternLayout("%m%n"));
    }

    protected void append(LoggingEvent loggingEvent) {
        switch (loggingEvent.getLevel().toInt()) {
            case 5000:
                if (loggingEvent.getThrowableInformation() != null) {
                    Log.v(m12806a().format(loggingEvent), getLayout().format(loggingEvent), loggingEvent.getThrowableInformation().getThrowable());
                    return;
                } else {
                    Log.v(m12806a().format(loggingEvent), getLayout().format(loggingEvent));
                    return;
                }
            case 10000:
                if (loggingEvent.getThrowableInformation() != null) {
                    Log.d(m12806a().format(loggingEvent), getLayout().format(loggingEvent), loggingEvent.getThrowableInformation().getThrowable());
                    return;
                } else {
                    Log.d(m12806a().format(loggingEvent), getLayout().format(loggingEvent));
                    return;
                }
            case 20000:
                if (loggingEvent.getThrowableInformation() != null) {
                    Log.i(m12806a().format(loggingEvent), getLayout().format(loggingEvent), loggingEvent.getThrowableInformation().getThrowable());
                    return;
                } else {
                    Log.i(m12806a().format(loggingEvent), getLayout().format(loggingEvent));
                    return;
                }
            case 30000:
                if (loggingEvent.getThrowableInformation() != null) {
                    Log.w(m12806a().format(loggingEvent), getLayout().format(loggingEvent), loggingEvent.getThrowableInformation().getThrowable());
                    return;
                } else {
                    Log.w(m12806a().format(loggingEvent), getLayout().format(loggingEvent));
                    return;
                }
            case Priority.ERROR_INT /*40000*/:
                if (loggingEvent.getThrowableInformation() != null) {
                    Log.e(m12806a().format(loggingEvent), getLayout().format(loggingEvent), loggingEvent.getThrowableInformation().getThrowable());
                    return;
                } else {
                    Log.e(m12806a().format(loggingEvent), getLayout().format(loggingEvent));
                    return;
                }
            case 50000:
                if (loggingEvent.getThrowableInformation() != null) {
                    Log.wtf(m12806a().format(loggingEvent), getLayout().format(loggingEvent), loggingEvent.getThrowableInformation().getThrowable());
                    return;
                } else {
                    Log.wtf(m12806a().format(loggingEvent), getLayout().format(loggingEvent));
                    return;
                }
            default:
                return;
        }
    }

    public void close() {
    }

    public boolean requiresLayout() {
        return true;
    }

    public Layout m12806a() {
        return this.f9094a;
    }
}
