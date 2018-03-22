package com.huawei.p461i;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.huawei.af.C3991a;
import com.huawei.al.C4032e;
import com.huawei.datatype.DBAlarmObject;
import com.huawei.datatype.EventAlarmInfo;
import com.huawei.datatype.SmartAlarmInfo;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwbasemgr.a;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwdataaccessmodel.db.C4763a;
import com.huawei.hwdatamigrate.C4794a;
import com.huawei.hwdatamigrate.p407a.C4771d;
import com.huawei.hwdatamigrate.p407a.ad;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import com.huawei.n.c;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: HWAlarmManager */
public class C5393a extends a {
    static String f19184b = "";
    private static C5393a f19185c;
    private static List<IBaseResponseCallback> f19186f = new ArrayList();
    private static List<IBaseResponseCallback> f19187g = new ArrayList();
    private static int f19188h = 5;
    private static int f19189i = 1;
    private static final Object f19190o = new Object();
    private static final Object f19191p = new Object();
    IBaseResponseCallback f19192a = new C5402j(this);
    private Context f19193d;
    private c f19194e;
    private int f19195j = -1;
    private List<String> f19196k = new ArrayList();
    private ArrayList<byte[]> f19197l = null;
    private HandlerThread f19198m = null;
    private Handler f19199n;
    private int f19200q = 0;
    private C3991a f19201r;
    private IBaseResponseCallback f19202s = new C5396d(this);
    private BroadcastReceiver f19203t = new C5399g(this);

    public static C5393a m25948a(Context context) {
        if (f19185c == null && context != null) {
            C2538c.c("HWAlarmManager", new Object[]{"getInstance() context = " + context});
            f19185c = new C5393a(BaseApplication.b());
        }
        return f19185c;
    }

    private C5393a(Context context) {
        super(context);
        this.f19193d = context;
        this.f19194e = c.a(this.f19193d);
        if (this.f19194e != null) {
            this.f19193d.registerReceiver(this.f19203t, new IntentFilter("com.huawei.bone.action.CONNECTION_STATE_CHANGED"), com.huawei.hwcommonmodel.b.c.a, null);
            this.f19194e.a(8, this.f19202s);
        } else {
            C2538c.e("HWAlarmManager", new Object[]{"HWAlarmManager() hwDeviceConfigManager is null"});
        }
        this.f19201r = C3991a.m19745a(this.f19193d);
        if (this.f19201r == null) {
            C2538c.e("HWAlarmManager", new Object[]{"mHwCombineMigrateMgr is null"});
        }
        this.f19198m = new HandlerThread("HWAlarmManager");
        this.f19198m.start();
        this.f19199n = new C5403k(this, this.f19198m.getLooper());
        m25975n();
        m25976o();
    }

    protected Integer getModuleId() {
        return Integer.valueOf(8);
    }

    public void m25982a(List<EventAlarmInfo> list, IBaseResponseCallback iBaseResponseCallback, boolean z) {
        C2538c.a("03", 1, "HWAlarmManager", new Object[]{"setEventAlarm() mDeviceConnect = " + this.f19200q});
        if (2 != this.f19200q) {
            this.f19194e.a("");
        }
        synchronized (f19190o) {
            m25980a(new C5394b(this, list, z, iBaseResponseCallback));
        }
    }

    public void m25987b(List<SmartAlarmInfo> list, IBaseResponseCallback iBaseResponseCallback, boolean z) {
        C2538c.a("03", 1, "HWAlarmManager", new Object[]{"setSmartAlarm()"});
        synchronized (f19191p) {
            m25985b(new C5395c(this, list, z, iBaseResponseCallback));
        }
    }

    private void m25955a(byte[] bArr) {
        switch (bArr[1]) {
            case (byte) 1:
                String a = C0973a.a(bArr);
                if (6 == a.length()) {
                    int i;
                    if (bArr.length <= 3 || TagName.ELECTRONIC_PUBLISH_START_TIME != bArr[2]) {
                        i = 100000;
                    } else {
                        i = 100009;
                    }
                    synchronized (C5393a.m25973l()) {
                        if (f19186f.size() != 0) {
                            ((IBaseResponseCallback) f19186f.get(0)).onResponse(0, Integer.valueOf(i));
                            f19186f.remove(0);
                        }
                    }
                    if (100000 == i) {
                        this.f19195j = 0;
                        C2538c.c("HWAlarmManager", new Object[]{"set V0 Event Alarm Title frame count with index = " + this.f19195j});
                        if (this.f19195j < this.f19196k.size()) {
                            C2538c.c("HWAlarmManager", new Object[]{"start to set V0 Event Alarm Title."});
                            m25950a(this.f19195j);
                            return;
                        }
                        return;
                    }
                    return;
                } else if (10 == a.length()) {
                    C2538c.c("HWAlarmManager", new Object[]{"set V0 Event Alarm Title info."});
                    m25978q();
                    return;
                } else if (8 != a.length()) {
                    return;
                } else {
                    if (this.f19197l != null && this.f19197l.size() > 0) {
                        m25978q();
                        return;
                    } else if (this.f19195j < this.f19196k.size() - 1) {
                        this.f19195j++;
                        C2538c.c("HWAlarmManager", new Object[]{"set V0 Event Alarm Title frame count with index = " + this.f19195j});
                        m25950a(this.f19195j);
                        return;
                    } else {
                        return;
                    }
                }
            default:
                return;
        }
    }

    private void m25961b(byte[] bArr) {
        int i;
        int c = m25962c(bArr);
        if (100000 == c) {
            i = 0;
        } else {
            i = -1;
        }
        switch (bArr[1]) {
            case (byte) 1:
                synchronized (C5393a.m25973l()) {
                    if (f19186f.size() != 0) {
                        ((IBaseResponseCallback) f19186f.get(0)).onResponse(i, Integer.valueOf(c));
                        f19186f.remove(0);
                    }
                }
                break;
            case (byte) 2:
                synchronized (C5393a.m25974m()) {
                    if (f19187g.size() != 0) {
                        ((IBaseResponseCallback) f19187g.get(0)).onResponse(i, Integer.valueOf(c));
                        f19187g.remove(0);
                    }
                }
                break;
        }
        if (i != 0) {
            this.f19194e.a("");
            C2538c.c("HWAlarmManager", new Object[]{"bluetooth send error, clear mac"});
        }
    }

    private int m25962c(byte[] bArr) {
        String a = C0973a.a(bArr);
        return Integer.parseInt(a.substring(8, a.length()), 16);
    }

    private static synchronized Object m25973l() {
        List list;
        synchronized (C5393a.class) {
            list = f19186f;
        }
        return list;
    }

    private static synchronized Object m25974m() {
        List list;
        synchronized (C5393a.class) {
            list = f19187g;
        }
        return list;
    }

    private void m25975n() {
        if (this.f19199n != null) {
            this.f19199n.post(new C5397e(this));
        }
    }

    private void m25954a(List<EventAlarmInfo> list, IBaseResponseCallback iBaseResponseCallback) {
        DBAlarmObject dBAlarmObject = new DBAlarmObject();
        dBAlarmObject.setiBaseResponseCallback(iBaseResponseCallback);
        dBAlarmObject.setObject(list);
        Message obtainMessage = this.f19199n.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = dBAlarmObject;
        this.f19199n.sendMessage(obtainMessage);
        if (this.f19201r != null) {
            this.f19201r.m19765c((List) list, false);
        }
    }

    private void m25963c(List<EventAlarmInfo> list) {
        Message obtainMessage = this.f19199n.obtainMessage();
        obtainMessage.what = 2;
        obtainMessage.obj = list;
        this.f19199n.sendMessage(obtainMessage);
        if (this.f19201r != null) {
            this.f19201r.m19765c((List) list, false);
        }
    }

    public void m25980a(IBaseResponseCallback iBaseResponseCallback) {
        synchronized (f19190o) {
            Message obtainMessage = this.f19199n.obtainMessage();
            obtainMessage.what = 3;
            obtainMessage.obj = iBaseResponseCallback;
            this.f19199n.sendMessage(obtainMessage);
        }
    }

    private void m25960b(List<SmartAlarmInfo> list, IBaseResponseCallback iBaseResponseCallback) {
        DBAlarmObject dBAlarmObject = new DBAlarmObject();
        dBAlarmObject.setiBaseResponseCallback(iBaseResponseCallback);
        dBAlarmObject.setObject(list);
        Message obtainMessage = this.f19199n.obtainMessage();
        obtainMessage.what = 4;
        obtainMessage.obj = dBAlarmObject;
        this.f19199n.sendMessage(obtainMessage);
        if (this.f19201r != null) {
            this.f19201r.m19763b((List) list, false);
        }
    }

    private void m25965d(List<SmartAlarmInfo> list) {
        Message obtainMessage = this.f19199n.obtainMessage();
        obtainMessage.what = 5;
        obtainMessage.obj = list;
        this.f19199n.sendMessage(obtainMessage);
        if (this.f19201r != null) {
            this.f19201r.m19763b((List) list, false);
        }
    }

    public void m25985b(IBaseResponseCallback iBaseResponseCallback) {
        synchronized (f19191p) {
            Message obtainMessage = this.f19199n.obtainMessage();
            obtainMessage.what = 6;
            obtainMessage.obj = iBaseResponseCallback;
            this.f19199n.sendMessage(obtainMessage);
        }
    }

    public List<SmartAlarmInfo> m25979a() {
        List arrayList;
        synchronized (f19191p) {
            arrayList = new ArrayList();
            Cursor queryStorageData = queryStorageData("smart_alarm", 1, "User_ID='" + C5393a.m25964d() + "'");
            if (queryStorageData == null) {
                C2538c.c("HWAlarmManager", new Object[]{"getSmartAlarmNoCallback cursor is null"});
            } else {
                while (queryStorageData.moveToNext()) {
                    SmartAlarmInfo smartAlarmInfo = new SmartAlarmInfo();
                    smartAlarmInfo.setSmartAlarmIndex(queryStorageData.getInt(queryStorageData.getColumnIndex("smart_alarm_index")));
                    smartAlarmInfo.setSmartAlarmEnable(queryStorageData.getInt(queryStorageData.getColumnIndex("smart_alarm_enable")));
                    String string = queryStorageData.getString(queryStorageData.getColumnIndex("smart_alarm_time"));
                    int parseInt = Integer.parseInt(string) / 100;
                    int parseInt2 = Integer.parseInt(string) % 100;
                    smartAlarmInfo.setSmartAlarmStartTime_hour(parseInt);
                    smartAlarmInfo.setSmartAlarmStartTime_mins(parseInt2);
                    smartAlarmInfo.setSmartAlarmRepeat(queryStorageData.getInt(queryStorageData.getColumnIndex("smart_alarm_cycle")));
                    smartAlarmInfo.setSmartAlarmAheadTime(queryStorageData.getInt(queryStorageData.getColumnIndex("smart_alarm_ahead_time")));
                    arrayList.add(smartAlarmInfo);
                }
                queryStorageData.close();
            }
        }
        return arrayList;
    }

    public List<EventAlarmInfo> m25984b() {
        List arrayList;
        synchronized (f19190o) {
            arrayList = new ArrayList();
            Cursor queryStorageData = queryStorageData("event_alarm", 1, "User_ID='" + C5393a.m25964d() + "'");
            if (queryStorageData == null) {
                C2538c.c("HWAlarmManager", new Object[]{"getEventAlarmNoCallback cursor is null"});
            } else {
                while (queryStorageData.moveToNext()) {
                    EventAlarmInfo eventAlarmInfo = new EventAlarmInfo();
                    eventAlarmInfo.setEventAlarmIndex(queryStorageData.getInt(queryStorageData.getColumnIndex("event_alarm_index")));
                    eventAlarmInfo.setEventAlarmEnable(queryStorageData.getInt(queryStorageData.getColumnIndex("event_alarm_enable")));
                    String string = queryStorageData.getString(queryStorageData.getColumnIndex("event_alarm_time"));
                    int parseInt = Integer.parseInt(string) / 100;
                    int parseInt2 = Integer.parseInt(string) % 100;
                    eventAlarmInfo.setEventAlarmStartTime_hour(parseInt);
                    eventAlarmInfo.setEventAlarmStartTime_mins(parseInt2);
                    eventAlarmInfo.setEventAlarmRepeat(queryStorageData.getInt(queryStorageData.getColumnIndex("event_alarm_cycle")));
                    eventAlarmInfo.setEventAlarmName(queryStorageData.getString(queryStorageData.getColumnIndex("event_alarm_name")));
                    arrayList.add(eventAlarmInfo);
                }
                queryStorageData.close();
            }
        }
        return arrayList;
    }

    private void m25976o() {
        C2538c.c("HWAlarmManager", new Object[]{"autoSendCommend() enter."});
        if (2 != this.f19200q) {
            C2538c.c("HWAlarmManager", new Object[]{"autoSendCommend--device is not connected, return"});
            return;
        }
        boolean isEvent_alarm;
        boolean isSmart_alarm;
        if (C0973a.a.a() != null) {
            isEvent_alarm = C0973a.a.a().isEvent_alarm();
            isSmart_alarm = C0973a.a.a().isSmart_alarm();
        } else {
            C2538c.d("HWAlarmManager", new Object[]{"autoSendCommend---CapabilityUtils.getDeviceCapability() is null!!"});
            isSmart_alarm = true;
            isEvent_alarm = true;
        }
        C2538c.c("HWAlarmManager", new Object[]{"autoSendCommend() bIsSupportEventAlarm = " + isEvent_alarm + ", bIsSupportSmartAlarm = " + isSmart_alarm});
        if (isEvent_alarm) {
            m25980a(new C5400h(this));
        }
        if (isSmart_alarm) {
            m25985b(new C5401i(this));
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        try {
            C5393a.m25977p();
            this.f19193d.unregisterReceiver(this.f19203t);
        } catch (IllegalArgumentException e) {
            C2538c.e("HWAlarmManager", new Object[]{"mConnectStateChangedReceiver is not registered"});
        }
        if (this.f19198m != null) {
            this.f19198m.quit();
            this.f19198m = null;
        }
        C2538c.c("HWAlarmManager", new Object[]{"onDestroy()"});
    }

    private static void m25977p() {
        f19185c = null;
        synchronized (C5393a.m25973l()) {
            f19186f.clear();
        }
        synchronized (C5393a.m25974m()) {
            f19187g.clear();
        }
    }

    public byte[] m25983a(int i, int i2, int i3, int i4, boolean z, List<SmartAlarmInfo> list) {
        int i5;
        byte[] bArr = new byte[15];
        int parseInt = Integer.parseInt(String.valueOf(i2 / 256), 16);
        int parseInt2 = Integer.parseInt(String.valueOf(i3 / 256), 16);
        if (z) {
            i5 = 127;
        } else {
            i5 = 0;
        }
        SmartAlarmInfo smartAlarmInfo = (SmartAlarmInfo) list.get(0);
        int parseInt3 = Integer.parseInt(String.valueOf(smartAlarmInfo.getSmartAlarmStartTime_hour()), 16);
        int parseInt4 = Integer.parseInt(String.valueOf(smartAlarmInfo.getSmartAlarmStartTime_mins()), 16);
        int smartAlarmAheadTime = smartAlarmInfo.getSmartAlarmAheadTime();
        int smartAlarmRepeat = smartAlarmInfo.getSmartAlarmRepeat();
        int i6 = smartAlarmAheadTime != 0 ? 127 : 0;
        int i7 = smartAlarmInfo.getSmartAlarmEnable() == 0 ? 0 : 127;
        bArr[0] = (byte) 6;
        bArr[1] = TagName.PAY_CHANNEL;
        bArr[2] = (byte) parseInt;
        bArr[3] = (byte) parseInt2;
        bArr[4] = (byte) i;
        bArr[5] = (byte) i4;
        bArr[6] = (byte) i5;
        bArr[7] = (byte) parseInt3;
        bArr[8] = (byte) parseInt4;
        bArr[9] = (byte) smartAlarmAheadTime;
        bArr[10] = (byte) smartAlarmRepeat;
        bArr[11] = (byte) i6;
        bArr[12] = (byte) i7;
        bArr[13] = (byte) 0;
        bArr[14] = (byte) 0;
        return bArr;
    }

    public void m25981a(List<SmartAlarmInfo> list) {
        boolean z = true;
        C2538c.c("HWAlarmManager", new Object[]{"setV0SmartAlarm enter."});
        if (list == null || list.size() == 0) {
            C2538c.e("HWAlarmManager", new Object[]{"Parameter is incorrect."});
            return;
        }
        Cursor c = C4763a.m22770c(this.f19193d, "7", "FitnessActivityReminderTable", 1, "User_Id='" + C5393a.m25964d() + "'");
        if (c == null) {
            C2538c.e("HWAlarmManager", new Object[]{"cursor is null."});
            return;
        }
        int i;
        boolean z2;
        int i2 = 2048;
        int i3 = 4382;
        int i4 = 127;
        if (c.moveToFirst()) {
            int i5 = c.getInt(c.getColumnIndex("Interval"));
            i2 = c.getInt(c.getColumnIndex("Start_Time"));
            i3 = c.getInt(c.getColumnIndex("End_Time"));
            i4 = c.getInt(c.getColumnIndex("Cycle"));
            if (1 != c.getInt(c.getColumnIndex("Enable"))) {
                z = false;
            }
            i = i5;
            z2 = z;
        } else {
            C2538c.e("HWAlarmManager", new Object[]{"Can not get cursor."});
            i = 60;
            z2 = false;
        }
        c.close();
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(8);
        deviceCommand.setCommandID(2);
        byte[] a = m25983a(i, i2, i3, i4, z2, list);
        deviceCommand.setDataLen(a.length);
        deviceCommand.setDataContent(a);
        this.f19194e.a(deviceCommand);
    }

    public void m25986b(List<EventAlarmInfo> list) {
        if (list == null) {
            C2538c.e("HWAlarmManager", new Object[]{"setV0EventAlarm with eventAlarmList is null."});
            return;
        }
        C2538c.e("HWAlarmManager", new Object[]{"Clear V0 event alarm list."});
        this.f19196k.clear();
        List arrayList = new ArrayList();
        arrayList.add(Byte.valueOf(TagName.ACTIVITY_CODE_LIST));
        arrayList.add(Byte.valueOf((byte) ((list.size() * 4) + 1)));
        arrayList.add(Byte.valueOf((byte) list.size()));
        for (EventAlarmInfo eventAlarmInfo : list) {
            arrayList.add(Byte.valueOf((byte) Integer.parseInt(String.valueOf(eventAlarmInfo.getEventAlarmStartTime_hour()), 16)));
            arrayList.add(Byte.valueOf((byte) Integer.parseInt(String.valueOf(eventAlarmInfo.getEventAlarmStartTime_mins()), 16)));
            int eventAlarmRepeat = eventAlarmInfo.getEventAlarmRepeat();
            if (1 == eventAlarmInfo.getEventAlarmEnable()) {
                eventAlarmRepeat += 128;
            }
            arrayList.add(Byte.valueOf((byte) eventAlarmRepeat));
            arrayList.add(Byte.valueOf((byte) eventAlarmInfo.getEventAlarmName().length()));
            this.f19196k.add(eventAlarmInfo.getEventAlarmName());
        }
        byte[] bArr = new byte[arrayList.size()];
        for (eventAlarmRepeat = 0; eventAlarmRepeat < arrayList.size(); eventAlarmRepeat++) {
            bArr[eventAlarmRepeat] = ((Byte) arrayList.get(eventAlarmRepeat)).byteValue();
        }
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(8);
        deviceCommand.setCommandID(1);
        deviceCommand.setDataLen(bArr.length);
        deviceCommand.setDataContent(bArr);
        this.f19194e.a(deviceCommand);
    }

    private void m25950a(int i) {
        byte[] bArr = new byte[]{TagName.BUSINESS_ORDER_LIST, (byte) 3, TagName.ORDER_BRIEF_INFO_LIST, (byte) 0, (byte) 0};
        this.f19197l = new C4032e(this.f19193d).m19842a((String) this.f19196k.get(i));
        if (this.f19197l == null) {
            C2538c.e("HWAlarmManager", new Object[]{"get HZK Data fail."});
            return;
        }
        bArr[2] = (byte) (bArr[2] + ((byte) i));
        int size = this.f19197l.size();
        bArr[3] = (byte) (size >> 8);
        bArr[4] = (byte) (size & 255);
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(8);
        deviceCommand.setCommandID(1);
        deviceCommand.setDataLen(bArr.length);
        deviceCommand.setDataContent(bArr);
        this.f19194e.a(deviceCommand);
    }

    private void m25978q() {
        if (this.f19197l == null || this.f19197l.size() <= 0) {
            C2538c.e("HWAlarmManager", new Object[]{"V0 alarm Name is incorrect."});
            return;
        }
        C2538c.c("HWAlarmManager", new Object[]{"V0 alarm Name Byte List Size = " + this.f19197l.size()});
        byte[] bArr = (byte[]) this.f19197l.get(0);
        this.f19197l.remove(0);
        bArr = Arrays.copyOfRange(bArr, 1, bArr.length - 1);
        C2538c.c("HWAlarmManager", new Object[]{"V0 alarm Name = " + C0973a.a(bArr)});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(8);
        deviceCommand.setCommandID(1);
        deviceCommand.setDataLen(bArr.length);
        deviceCommand.setDataContent(bArr);
        this.f19194e.a(deviceCommand);
    }

    public int m25988c() {
        if (this.f19194e == null) {
            return -1;
        }
        DeviceInfo c = this.f19194e.c();
        if (c != null) {
            return c.getDeviceProtocol();
        }
        return -1;
    }

    public static String m25964d() {
        C2538c.b("HWAlarmManager", new Object[]{"getUserID"});
        f19184b = com.huawei.login.ui.login.a.a(BaseApplication.b()).c();
        if (f19184b == null) {
            f19184b = "";
        }
        return f19184b;
    }

    public boolean onDataMigrate() {
        C4794a a = C4794a.m22935a(this.f19193d);
        C4771d d = a.m22942d(this.f19193d);
        if (d != null) {
            C2538c.b("HWAlarmManager", new Object[]{"null == alarmClockTable"});
            C2538c.b("HWAlarmManager", new Object[]{"AlarmClockTable = " + d.toString()});
            ContentValues contentValues = new ContentValues();
            contentValues.put("User_ID", C5393a.m25964d());
            contentValues.put("smart_alarm_index", Integer.valueOf(1));
            if (d.m22855d()) {
                contentValues.put("smart_alarm_enable", Integer.valueOf(1));
            } else {
                contentValues.put("smart_alarm_enable", Integer.valueOf(0));
            }
            contentValues.put("smart_alarm_time", String.valueOf(d.m22854c()));
            contentValues.put("smart_alarm_cycle", Integer.valueOf(d.m22853b()));
            contentValues.put("smart_alarm_ahead_time", Integer.valueOf(d.m22852a()));
            deleteStorageData("smart_alarm", 1, "User_ID='" + C5393a.m25964d() + "' AND smart_alarm_index='" + 1 + "'");
            insertStorageData("smart_alarm", 1, contentValues);
        }
        List e = a.m22943e(this.f19193d);
        if (e == null) {
            C2538c.b("HWAlarmManager", new Object[]{"null == list"});
        } else {
            C2538c.b("HWAlarmManager", new Object[]{"MultAlarmClockTable " + e.toString()});
            int i = 0;
            for (int i2 = 0; i2 < e.size(); i2++) {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("User_ID", C5393a.m25964d());
                contentValues2.put("event_alarm_index", Integer.valueOf(i + 1));
                contentValues2.put("event_alarm_enable", Boolean.valueOf(((ad) e.get(i2)).m22788d()));
                contentValues2.put("event_alarm_time", String.valueOf(((ad) e.get(i2)).m22785a()));
                contentValues2.put("event_alarm_cycle", Integer.valueOf(((ad) e.get(i2)).m22786b()));
                contentValues2.put("event_alarm_name", ((ad) e.get(i2)).m22787c());
                insertStorageData("event_alarm", 1, contentValues2);
                i++;
            }
        }
        return true;
    }
}
