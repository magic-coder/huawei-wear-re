package org.apache.log4j.chainsaw;

import cn.com.fmsh.communication.message.constants.Constants.XMLNode.XMLMessage;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.swing.table.AbstractTableModel;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

class MyTableModel extends AbstractTableModel {
    private static final String[] COL_NAMES = new String[]{"Time", "Priority", "Trace", "Category", "NDC", XMLMessage.MESSAGE};
    private static final DateFormat DATE_FORMATTER = DateFormat.getDateTimeInstance(3, 2);
    private static final EventDetails[] EMPTY_LIST = new EventDetails[0];
    private static final Logger LOG;
    private static final Comparator MY_COMP = new C27751();
    static Class class$java$lang$Boolean;
    static Class class$java$lang$Object;
    static Class class$org$apache$log4j$chainsaw$MyTableModel;
    private final SortedSet mAllEvents = new TreeSet(MY_COMP);
    private String mCategoryFilter = "";
    private EventDetails[] mFilteredEvents = EMPTY_LIST;
    private final Object mLock = new Object();
    private String mMessageFilter = "";
    private String mNDCFilter = "";
    private boolean mPaused = false;
    private final List mPendingEvents = new ArrayList();
    private Priority mPriorityFilter = Priority.DEBUG;
    private String mThreadFilter = "";

    final class C27751 implements Comparator {
        C27751() {
        }

        public int compare(Object obj, Object obj2) {
            if (obj == null && obj2 == null) {
                return 0;
            }
            if (obj == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            if (((EventDetails) obj).getTimeStamp() < ((EventDetails) obj2).getTimeStamp()) {
                return 1;
            }
            return -1;
        }
    }

    class Processor implements Runnable {
        private final MyTableModel this$0;

        private Processor(MyTableModel myTableModel) {
            this.this$0 = myTableModel;
        }

        Processor(MyTableModel myTableModel, C27751 c27751) {
            this(myTableModel);
        }

        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                synchronized (MyTableModel.access$000(this.this$0)) {
                    if (MyTableModel.access$100(this.this$0)) {
                    } else {
                        Object obj = null;
                        boolean z = true;
                        for (EventDetails eventDetails : MyTableModel.access$200(this.this$0)) {
                            Object obj2;
                            MyTableModel.access$300(this.this$0).add(eventDetails);
                            if (z && eventDetails == MyTableModel.access$300(this.this$0).first()) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (obj != null || MyTableModel.access$400(this.this$0, eventDetails)) {
                                obj2 = 1;
                            } else {
                                obj2 = null;
                            }
                            obj = obj2;
                        }
                        MyTableModel.access$200(this.this$0).clear();
                        if (obj != null) {
                            MyTableModel.access$500(this.this$0, z);
                        }
                    }
                }
            }
        }
    }

    static Object access$000(MyTableModel myTableModel) {
        return myTableModel.mLock;
    }

    static boolean access$100(MyTableModel myTableModel) {
        return myTableModel.mPaused;
    }

    static List access$200(MyTableModel myTableModel) {
        return myTableModel.mPendingEvents;
    }

    static SortedSet access$300(MyTableModel myTableModel) {
        return myTableModel.mAllEvents;
    }

    static boolean access$400(MyTableModel myTableModel, EventDetails eventDetails) {
        return myTableModel.matchFilter(eventDetails);
    }

    static void access$500(MyTableModel myTableModel, boolean z) {
        myTableModel.updateFilteredEvents(z);
    }

    static {
        Class class$;
        if (class$org$apache$log4j$chainsaw$MyTableModel == null) {
            class$ = class$("org.apache.log4j.chainsaw.MyTableModel");
            class$org$apache$log4j$chainsaw$MyTableModel = class$;
        } else {
            class$ = class$org$apache$log4j$chainsaw$MyTableModel;
        }
        LOG = Logger.getLogger(class$);
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    MyTableModel() {
        Thread thread = new Thread(new Processor(this, null));
        thread.setDaemon(true);
        thread.start();
    }

    public int getRowCount() {
        int length;
        synchronized (this.mLock) {
            length = this.mFilteredEvents.length;
        }
        return length;
    }

    public int getColumnCount() {
        return COL_NAMES.length;
    }

    public String getColumnName(int i) {
        return COL_NAMES[i];
    }

    public Class getColumnClass(int i) {
        Class class$;
        if (i == 2) {
            if (class$java$lang$Boolean != null) {
                return class$java$lang$Boolean;
            }
            class$ = class$("java.lang.Boolean");
            class$java$lang$Boolean = class$;
            return class$;
        } else if (class$java$lang$Object != null) {
            return class$java$lang$Object;
        } else {
            class$ = class$("java.lang.Object");
            class$java$lang$Object = class$;
            return class$;
        }
    }

    public Object getValueAt(int i, int i2) {
        Object format;
        synchronized (this.mLock) {
            EventDetails eventDetails = this.mFilteredEvents[i];
            if (i2 == 0) {
                format = DATE_FORMATTER.format(new Date(eventDetails.getTimeStamp()));
            } else if (i2 == 1) {
                format = eventDetails.getPriority();
            } else if (i2 == 2) {
                format = eventDetails.getThrowableStrRep() == null ? Boolean.FALSE : Boolean.TRUE;
            } else if (i2 == 3) {
                format = eventDetails.getCategoryName();
            } else if (i2 == 4) {
                format = eventDetails.getNDC();
            } else {
                format = eventDetails.getMessage();
            }
        }
        return format;
    }

    public void setPriorityFilter(Priority priority) {
        synchronized (this.mLock) {
            this.mPriorityFilter = priority;
            updateFilteredEvents(false);
        }
    }

    public void setThreadFilter(String str) {
        synchronized (this.mLock) {
            this.mThreadFilter = str.trim();
            updateFilteredEvents(false);
        }
    }

    public void setMessageFilter(String str) {
        synchronized (this.mLock) {
            this.mMessageFilter = str.trim();
            updateFilteredEvents(false);
        }
    }

    public void setNDCFilter(String str) {
        synchronized (this.mLock) {
            this.mNDCFilter = str.trim();
            updateFilteredEvents(false);
        }
    }

    public void setCategoryFilter(String str) {
        synchronized (this.mLock) {
            this.mCategoryFilter = str.trim();
            updateFilteredEvents(false);
        }
    }

    public void addEvent(EventDetails eventDetails) {
        synchronized (this.mLock) {
            this.mPendingEvents.add(eventDetails);
        }
    }

    public void clear() {
        synchronized (this.mLock) {
            this.mAllEvents.clear();
            this.mFilteredEvents = new EventDetails[0];
            this.mPendingEvents.clear();
            fireTableDataChanged();
        }
    }

    public void toggle() {
        synchronized (this.mLock) {
            this.mPaused = !this.mPaused;
        }
    }

    public boolean isPaused() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mPaused;
        }
        return z;
    }

    public EventDetails getEventDetails(int i) {
        EventDetails eventDetails;
        synchronized (this.mLock) {
            eventDetails = this.mFilteredEvents[i];
        }
        return eventDetails;
    }

    private void updateFilteredEvents(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        List arrayList = new ArrayList();
        int size = this.mAllEvents.size();
        for (EventDetails eventDetails : this.mAllEvents) {
            if (matchFilter(eventDetails)) {
                arrayList.add(eventDetails);
            }
        }
        if (this.mFilteredEvents.length == 0) {
            Object obj = null;
        } else {
            EventDetails eventDetails2 = this.mFilteredEvents[0];
        }
        this.mFilteredEvents = (EventDetails[]) arrayList.toArray(EMPTY_LIST);
        if (!z || obj == null) {
            fireTableDataChanged();
        } else {
            int indexOf = arrayList.indexOf(obj);
            if (indexOf < 1) {
                LOG.warn("In strange state");
                fireTableDataChanged();
            } else {
                fireTableRowsInserted(0, indexOf - 1);
            }
        }
        LOG.debug(new StringBuffer().append("Total time [ms]: ").append(System.currentTimeMillis() - currentTimeMillis).append(" in update, size: ").append(size).toString());
    }

    private boolean matchFilter(EventDetails eventDetails) {
        if (!eventDetails.getPriority().isGreaterOrEqual(this.mPriorityFilter) || eventDetails.getThreadName().indexOf(this.mThreadFilter) < 0 || eventDetails.getCategoryName().indexOf(this.mCategoryFilter) < 0 || (this.mNDCFilter.length() != 0 && (eventDetails.getNDC() == null || eventDetails.getNDC().indexOf(this.mNDCFilter) < 0))) {
            return false;
        }
        String message = eventDetails.getMessage();
        if (message == null) {
            if (this.mMessageFilter.length() == 0) {
                return true;
            }
            return false;
        } else if (message.indexOf(this.mMessageFilter) < 0) {
            return false;
        } else {
            return true;
        }
    }
}
