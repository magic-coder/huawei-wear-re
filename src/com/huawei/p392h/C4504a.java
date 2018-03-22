package com.huawei.p392h;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.google.gson.Gson;
import com.huawei.af.C3991a;
import com.huawei.datatype.Contact;
import com.huawei.datatype.PhoneNumber;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwbasemgr.a;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceCapability;
import com.huawei.hwdatamigrate.C4794a;
import com.huawei.hwdatamigrate.p407a.C4786s;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import com.huawei.n.c;
import com.huawei.p190v.C2538c;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: HWAddressBookManager */
public class C4504a extends a {
    static String f16677a = "";
    private static C4504a f16678b;
    private static c f16679d;
    private static List<IBaseResponseCallback> f16680e = new ArrayList();
    private static int f16681f = 10;
    private static final Object f16682h = new Object();
    private Context f16683c;
    private C3991a f16684g;
    private IBaseResponseCallback f16685i = new C4506c(this);
    private BroadcastReceiver f16686j = new C4507d(this);
    private IBaseResponseCallback f16687k = new C4508e(this);

    public static C4504a m21570a(Context context) {
        if (f16678b == null && context != null) {
            f16678b = new C4504a(BaseApplication.b());
        }
        return f16678b;
    }

    private C4504a(Context context) {
        super(context);
        this.f16683c = context;
        f16679d = c.a(this.f16683c);
        if (f16679d != null) {
            this.f16683c.registerReceiver(this.f16686j, new IntentFilter("com.huawei.bone.action.CONNECTION_STATE_CHANGED"), com.huawei.hwcommonmodel.b.c.a, null);
            f16679d.a(3, this.f16685i);
            m21577e();
        } else {
            C2538c.e("HWAddressBookManager", new Object[]{"HWAddressBookManager() hwDeviceConfigManager is null"});
        }
        this.f16684g = C3991a.m19745a(context);
        if (this.f16684g == null) {
            C2538c.e("HWAddressBookManager", new Object[]{"mHWCombineMigrateMgr is null"});
        }
    }

    public void m21581a(List<Contact> list, IBaseResponseCallback iBaseResponseCallback, boolean z) {
        int i;
        String e;
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(3);
        deviceCommand.setCommandID(1);
        List arrayList = new ArrayList();
        C2538c.c("HWAddressBookManager", new Object[]{"setContact() maxContactNum = " + f16681f});
        int i2 = 0;
        for (i = 0; i < f16681f; i++) {
            ByteBuffer allocate;
            if (i >= list.size()) {
                allocate = ByteBuffer.allocate(5);
                allocate.put(TagName.ACTIVITY_NAME);
                allocate.put((byte) 3);
                allocate.put((byte) 3);
                allocate.put((byte) 1);
                allocate.put((byte) (i + 1));
            } else {
                String substring;
                String substring2;
                e = C0973a.e(((Contact) list.get(i)).getName());
                if (60 < e.length()) {
                    substring = e.substring(0, 60);
                } else {
                    substring = e;
                }
                int length = 5 + ((substring.length() / 2) + 2);
                List phoneNumbers = ((Contact) list.get(i)).getPhoneNumbers();
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                for (int i6 = 0; i6 < phoneNumbers.size(); i6++) {
                    String e2 = C0973a.e(((PhoneNumber) phoneNumbers.get(i6)).getPhone_tag());
                    e = C0973a.e(((PhoneNumber) phoneNumbers.get(i6)).getPhone_number().replaceAll("-", ""));
                    if (40 < e.length()) {
                        e = e.substring(0, 40);
                    }
                    i3 += (e2.length() / 2) + 2;
                    i4 += (e.length() / 2) + 2;
                    i5 += 2;
                }
                i3 = i5 + (i3 + i4);
                i5 = length + (i3 + 2);
                e = C0973a.e(((Contact) list.get(i)).getNote());
                if (60 < e.length()) {
                    substring2 = e.substring(0, 60);
                } else {
                    substring2 = e;
                }
                if (substring2.length() != 0) {
                    i5 = ((substring2.length() / 2) + 2) + i5;
                }
                if (!"-1".equals(((Contact) list.get(i)).getIcon_index())) {
                    i5 += 3;
                }
                ByteBuffer allocate2 = ByteBuffer.allocate(i5);
                allocate2.put(TagName.ACTIVITY_NAME);
                allocate2.put(C0973a.b(C0973a.e(i5 - 2)));
                allocate2.put((byte) 3);
                allocate2.put(C0973a.b(C0973a.a(1)));
                allocate2.put(C0973a.b(C0973a.a(i + 1)));
                ((Contact) list.get(i)).setIndex(i + 1);
                allocate2.put((byte) 4);
                allocate2.put(C0973a.b(C0973a.a(substring.length() / 2)));
                allocate2.put(C0973a.b(substring));
                allocate2.put(TagName.ACTIVITY_END);
                allocate2.put(C0973a.b(C0973a.e(i3)));
                for (int i7 = 0; i7 < phoneNumbers.size(); i7++) {
                    String e3 = C0973a.e(((PhoneNumber) phoneNumbers.get(i7)).getPhone_tag());
                    e = C0973a.e(((PhoneNumber) phoneNumbers.get(i7)).getPhone_number().replaceAll("-", ""));
                    if (40 < e.length()) {
                        e = e.substring(0, 40);
                    }
                    allocate2.put(TagName.ACTIVITY_TOTAL);
                    allocate2.put(C0973a.b(C0973a.e(((e3.length() / 2) + 2) + ((e.length() / 2) + 2))));
                    allocate2.put((byte) 7);
                    allocate2.put(C0973a.b(C0973a.a(e3.length() / 2)));
                    allocate2.put(C0973a.b(e3));
                    allocate2.put((byte) 8);
                    allocate2.put(C0973a.b(C0973a.a(e.length() / 2)));
                    allocate2.put(C0973a.b(e));
                }
                if (substring2.length() != 0) {
                    allocate2.put((byte) 9);
                    allocate2.put(C0973a.b(C0973a.a(substring2.length() / 2)));
                    allocate2.put(C0973a.b(substring2));
                }
                if (!"-1".equals(((Contact) list.get(i)).getIcon_index())) {
                    allocate2.put((byte) 10);
                    allocate2.put((byte) 1);
                    allocate2.put((byte) 0);
                }
                allocate = allocate2;
            }
            i2 += allocate.array().length;
            arrayList.add(allocate);
        }
        byte[] b = C0973a.b(C0973a.e(i2));
        ByteBuffer allocate3 = ByteBuffer.allocate((b.length + 1) + i2);
        allocate3.put(TagName.ACTIVITY);
        allocate3.put(b);
        for (i = 0; i < arrayList.size(); i++) {
            allocate3.put(((ByteBuffer) arrayList.get(i)).array());
        }
        deviceCommand.setDataLen(allocate3.array().length);
        deviceCommand.setDataContent(allocate3.array());
        f16679d.a(deviceCommand);
        e = "";
        if (list.size() != 0) {
            Object obj;
            if (f16681f >= list.size()) {
                obj = list;
            } else {
                obj = list.subList(0, f16681f - 1);
            }
            e = new Gson().toJson(obj);
        }
        int a = m21569a(e);
        if (this.f16684g != null) {
            this.f16684g.m19760a((List) list, false);
        }
        if (z) {
            synchronized (C4504a.m21578f()) {
                f16680e.add(iBaseResponseCallback);
            }
        } else if (-1 != a) {
            iBaseResponseCallback.onResponse(0, Integer.valueOf(100000));
        } else {
            iBaseResponseCallback.onResponse(-1, Integer.valueOf(103001));
        }
    }

    public List<Contact> m21580a() {
        List<Contact> arrayList;
        synchronized (f16682h) {
            String sharedPreference = getSharedPreference(C4504a.m21575c());
            C2538c.c("HWAddressBookManager", new Object[]{"getContact() jsonString = " + sharedPreference});
            if (sharedPreference == null || "".equals(sharedPreference)) {
                arrayList = new ArrayList();
            } else {
                arrayList = (List) new Gson().fromJson(sharedPreference, new C4505b(this).getType());
            }
        }
        return arrayList;
    }

    public int m21582b() {
        return f16681f;
    }

    private synchronized int m21569a(String str) {
        C2538c.c("HWAddressBookManager", new Object[]{"saveContact() info = " + str});
        return setSharedPreference(C4504a.m21575c(), str, null);
    }

    private void m21576d() {
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(3);
        deviceCommand.setCommandID(2);
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.put((byte) 1);
        allocate.put((byte) 0);
        allocate.put((byte) 2);
        allocate.put((byte) 0);
        deviceCommand.setDataLen(allocate.array().length);
        deviceCommand.setDataContent(allocate.array());
        f16679d.a(deviceCommand);
    }

    private void m21573a(byte[] bArr) {
        C2538c.c("HWAddressBookManager", new Object[]{"getResult(): " + C0973a.a(bArr)});
        switch (bArr[1]) {
            case (byte) 1:
                int b = m21574b(bArr);
                int i = -1;
                if (100000 == b) {
                    i = 0;
                }
                synchronized (C4504a.m21578f()) {
                    if (f16680e.size() != 0) {
                        ((IBaseResponseCallback) f16680e.get(0)).onResponse(i, Integer.valueOf(b));
                        f16680e.remove(0);
                    }
                }
                return;
            case (byte) 2:
                f16681f = Integer.parseInt(C0973a.a(bArr).substring(8, 10), 16);
                C2538c.c("HWAddressBookManager", new Object[]{"getResult(): maxContactNum = " + f16681f});
                m21581a(m21580a(), this.f16687k, true);
                return;
            default:
                return;
        }
    }

    private int m21574b(byte[] bArr) {
        String a = C0973a.a(bArr);
        return Integer.parseInt(a.substring(8, a.length()), 16);
    }

    private void m21577e() {
        DeviceCapability a = C0973a.a.a();
        if (a != null && a.isContacts()) {
            m21576d();
        }
    }

    private static synchronized Object m21578f() {
        List list;
        synchronized (C4504a.class) {
            list = f16680e;
        }
        return list;
    }

    protected void onDestroy() {
        super.onDestroy();
        try {
            C4504a.m21579g();
            this.f16683c.unregisterReceiver(this.f16686j);
        } catch (IllegalArgumentException e) {
            C2538c.e("HWAddressBookManager", new Object[]{"Receiver is not registered"});
        }
        C2538c.c("HWAddressBookManager", new Object[]{"onDestroy() finish"});
    }

    private static void m21579g() {
        f16678b = null;
        synchronized (C4504a.m21578f()) {
            f16680e.clear();
        }
    }

    protected Integer getModuleId() {
        return Integer.valueOf(3);
    }

    public static String m21575c() {
        f16677a = com.huawei.login.ui.login.a.a(BaseApplication.b()).c();
        if (f16677a == null) {
            f16677a = "";
        }
        return f16677a;
    }

    public boolean onDataMigrate() {
        List c = C4794a.m22935a(this.f16683c).m22941c(this.f16683c);
        if (c == null) {
            C2538c.b("HWAddressBookManager", new Object[]{"null ==geminiContactTable"});
        } else {
            List arrayList = new ArrayList();
            for (int i = 0; i < c.size(); i++) {
                List arrayList2 = new ArrayList();
                PhoneNumber phoneNumber = new PhoneNumber();
                phoneNumber.setPhone_number(((C4786s) c.get(i)).m22908c());
                phoneNumber.setPhone_tag(((C4786s) c.get(i)).m22910d());
                arrayList2.add(phoneNumber);
                Contact contact = new Contact();
                contact.setIcon_index(String.valueOf(((C4786s) c.get(i)).m22906b()));
                contact.setName(((C4786s) c.get(i)).m22903a());
                contact.setPhoneNumbers(arrayList2);
                arrayList.add(contact);
            }
            String str = "";
            if (arrayList.size() != 0) {
                str = new Gson().toJson(arrayList);
            }
            C2538c.b("HWAddressBookManager", new Object[]{"info = " + str});
            m21569a(str);
        }
        return true;
    }
}
