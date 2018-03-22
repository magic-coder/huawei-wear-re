package com.huawei.hwbtsdk.p399a;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.RemoteException;
import android.provider.Settings.Secure;
import android.support.v4.media.TransportMediator;
import android.text.TextUtils;
import android.text.format.DateFormat;
import cn.com.fmsh.communication.core.MessageHead;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.huawei.ae.C3988a;
import com.huawei.crowdtestsdk.report.ReportInfoUtils;
import com.huawei.hwbtsdk.p057b.p400b.C4624a;
import com.huawei.hwbtsdk.p057b.p400b.C4625b;
import com.huawei.hwbtsdk.p057b.p400b.C4627d;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.C4752s;
import com.huawei.hwcommonmodel.datatypes.C4753t;
import com.huawei.hwcommonmodel.datatypes.C4754u;
import com.huawei.hwcommonmodel.datatypes.C4756w;
import com.huawei.hwcommonmodel.datatypes.DeviceCapability;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.p063b.C4714b;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.PluginPayAdapter;
import com.huawei.p190v.C2538c;

import java.nio.ByteBuffer;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BTHandshakeManager */
public class C4610m {
    private static long f16861a = 0;
    private static int f16862b = 0;
    private static C3988a f16863c = null;
    private static List<Integer> f16864d = new ArrayList();

    public static List<Integer> m21969a() {
        return f16864d;
    }

    public static C4625b m21962a(int i) {
        Object[] objArr;
        C4625b c4625b = new C4625b();
        String a = a.a(1);
        String a2 = a.a(15);
        String str = a.a(1) + a.a(0);
        String str2 = Build.SERIAL;
        String str3 = a.a(3) + a.a(6) + a.e(str2.substring(str2.length() - 6, str2.length()));
        String str4 = a.a(4) + a.a(1) + a.a(2);
        String str5 = a.a(5) + a.a(0);
        str2 = "";
        str2 = "";
        String str6 = "FF:FF:FF:FF:FF:CC";
        C2538c.a("01", 1, "BTHandshakeManager", new Object[]{"Start to get phone mac address."});
        if (C4610m.m21996g()) {
            if (C4610m.m21998h()) {
                C2538c.a("01", 1, "BTHandshakeManager", new Object[]{"iconnect action exist."});
                if (f16863c != null) {
                    try {
                        str2 = f16863c.mo4333a();
                        C2538c.a("01", 1, "BTHandshakeManager", new Object[]{"btMacAddress = " + C4600d.m21899a().m21950d(str2)});
                    } catch (RemoteException e) {
                        objArr = new Object[1];
                        objArr[0] = "RemoteException = " + e.getMessage();
                        C2538c.b("01", 1, "BTHandshakeManager", objArr);
                        C2538c.a("01", 1, "BTHandshakeManager", new Object[]{"btMacAddress = " + C4600d.m21899a().m21950d(str2)});
                    } catch (SecurityException e2) {
                        objArr = new Object[1];
                        objArr[0] = "SecurityException = " + e2.getMessage();
                        C2538c.b("01", 1, "BTHandshakeManager", objArr);
                        C2538c.a("01", 1, "BTHandshakeManager", new Object[]{"btMacAddress = " + C4600d.m21899a().m21950d(str2)});
                    } catch (Exception e3) {
                        objArr = new Object[1];
                        objArr[0] = "Exception = " + e3.getMessage();
                        C2538c.b("01", 1, "BTHandshakeManager", objArr);
                        C2538c.a("01", 1, "BTHandshakeManager", new Object[]{"btMacAddress = " + C4600d.m21899a().m21950d(str2)});
                    } catch (Throwable th) {
                        C2538c.a("01", 1, "BTHandshakeManager", new Object[]{"btMacAddress = " + C4600d.m21899a().m21950d(str2)});
                    }
                } else {
                    C2538c.a("01", 1, "BTHandshakeManager", new Object[]{"mIConnectService is null."});
                }
            } else {
                C2538c.a("01", 1, "BTHandshakeManager", new Object[]{"iconnect action do not exist so start to get by settings."});
                str2 = Secure.getString(BaseApplication.b().getContentResolver(), "bluetooth_address");
            }
        }
        if (str2 == null) {
            C2538c.b("01", 1, "BTHandshakeManager", new Object[]{"btMacAddress is null."});
            str2 = str6;
        } else if (str2.length() != 0) {
            C2538c.a("01", 1, "BTHandshakeManager", new Object[]{"Phone Mac Address is : " + C4600d.m21899a().m21950d(str2)});
        } else {
            C2538c.b("01", 1, "BTHandshakeManager", new Object[]{"btMacAddress len = 0."});
            str2 = str6;
        }
        str6 = a.a(7) + a.a(str2.length()) + a.e(str2);
        str2 = "";
        if (2 == i) {
            str2 = a.a(9) + a.a(0);
        }
        byte[] b = a.b(a + a2 + str + str3 + str4 + str5 + str6 + str2);
        c4625b.m22108a(b.length);
        c4625b.m22111a(b);
        c4625b.m22113b(1);
        c4625b.m22110a(true);
        c4625b.m22119e(1);
        c4625b.m22122f(15);
        return c4625b;
    }

    public static C4624a m21961a(Context context, byte[] bArr) {
        if (bArr == null || context == null) {
            C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"resolveBindStatusResponse with parameter is not correct."});
            return null;
        }
        C4624a c4624a = new C4624a();
        f16861a = 0;
        String a = a.a(bArr);
        try {
            List list = new C4756w().m22743a(a.substring(4, a.length())).f17337a;
            Object obj = null;
            for (int i = 0; i < list.size(); i++) {
                switch (Integer.parseInt(((C4752s) list.get(i)).m22732a(), 16)) {
                    case 1:
                        c4624a.m22100a(Integer.parseInt(((C4752s) list.get(i)).m22733b(), 16));
                        break;
                    case 2:
                        c4624a.m22102b(Integer.parseInt(((C4752s) list.get(i)).m22733b(), 16));
                        break;
                    case 4:
                        c4624a.m22104c(Integer.parseInt(((C4752s) list.get(i)).m22733b(), 16));
                        break;
                    case 5:
                        c4624a.m22106d(Integer.parseInt(((C4752s) list.get(i)).m22733b(), 16));
                        break;
                    case 9:
                        f16861a = Long.parseLong(((C4752s) list.get(i)).m22733b(), 16);
                        C2538c.a("01", 1, "BTHandshakeManager", new Object[]{"solve base counter = " + f16861a});
                        break;
                    case 127:
                        C2538c.b("01", 1, "BTHandshakeManager", new Object[]{"device tell error code for resolveBTDeviceBondStatus."});
                        obj = 1;
                        break;
                    default:
                        break;
                }
            }
            return obj != null ? null : c4624a;
        } catch (C4753t e) {
            C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"resolveBTDeviceBondStatus tlv resolve exception."});
            return null;
        }
    }

    public static C4625b m21965a(Context context, BluetoothDevice bluetoothDevice, DeviceInfo deviceInfo) {
        C4625b c4625b = new C4625b();
        String a = a.a(1);
        String a2 = a.a(14);
        String str = a.a(1) + a.a(0);
        String str2 = a.a(3) + a.a(1) + a.a(0);
        String str3 = Build.SERIAL;
        String str4 = a.a(5) + a.a(6) + a.e(str3.substring(str3.length() - 6, str3.length()));
        str3 = bluetoothDevice == null ? "" : bluetoothDevice.getAddress();
        String str5 = "";
        String str6 = "";
        str5 = "";
        if (deviceInfo == null) {
            C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"btDeviceInfo is null."});
            str3 = C4612o.m22004a(context).m22010a(str3, context, null);
            str3 = a.a(6) + a.a(str3.length() / 2) + str3;
        } else if (2 == deviceInfo.getDeviceProtocol()) {
            String str7;
            byte[] i = C4610m.m21999i();
            if (i != null) {
                str3 = C4612o.m22004a(context).m22010a(str3, context, i);
                C2538c.c("01", 0, "BTHandshakeManager", new Object[]{"Encrypt Key info = " + str3});
                if (str3 == null || str3.length() <= 64) {
                    C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"key = null."});
                    str3 = str5;
                    str5 = str6;
                } else {
                    C2538c.a("01", 1, "BTHandshakeManager", new Object[]{"Start to construct key info."});
                    str5 = str3.substring(32, str3.length());
                    str5 = a.a(6) + a.a(str5.length() / 2) + str5;
                    C2538c.a("01", 1, "BTHandshakeManager", new Object[]{"Start to construct iv info."});
                    str3 = str3.substring(0, 32);
                    str3 = a.a(7) + a.a(str3.length() / 2) + str3;
                }
            } else {
                C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"Do not get randIV."});
                str3 = C4612o.m22004a(context).m22010a(str3, context, null);
                str7 = str5;
                str5 = a.a(6) + a.a(str3.length() / 2) + str3;
                str3 = str7;
            }
            str7 = str3;
            str3 = str5;
            str5 = str7;
        } else {
            C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"Protocol is not V2."});
            str3 = C4612o.m22004a(context).m22010a(str3, context, null);
            str3 = a.a(6) + a.a(str3.length() / 2) + str3;
        }
        byte[] b = a.b(a + a2 + str + str2 + str4 + str3 + str5);
        c4625b.m22108a(b.length);
        c4625b.m22111a(b);
        c4625b.m22113b(1);
        c4625b.m22110a(true);
        c4625b.m22119e(1);
        c4625b.m22122f(14);
        return c4625b;
    }

    public static int m21979b(Context context, byte[] bArr) {
        String a = a.a(bArr);
        try {
            List list = new C4756w().m22743a(a.substring(4, a.length())).f17337a;
            if (list.size() > 0) {
                return Integer.parseInt(((C4752s) list.get(0)).m22733b(), 16);
            }
            return 0;
        } catch (C4753t e) {
            C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"resolveBTDeviceLinkParameter tlv resolve exception."});
            return 0;
        }
    }

    public static C4625b m21981b(int i) {
        C2538c.a("01", 1, "BTHandshakeManager", new Object[]{"Enter getBTDeviceLinkParameter with btType = " + i});
        C4625b c4625b = new C4625b();
        byte[] bArr;
        if (i == 0) {
            bArr = new byte[]{(byte) 1, (byte) 1, (byte) 1, (byte) 0, (byte) 2, (byte) 0, (byte) 3, (byte) 0, (byte) 4, (byte) 0, (byte) 6, (byte) 0};
            c4625b.m22108a(12);
            c4625b.m22111a(bArr);
        } else {
            bArr = new byte[]{(byte) 1, (byte) 1, (byte) 1, (byte) 0, (byte) 2, (byte) 0, (byte) 3, (byte) 0, (byte) 4, (byte) 0};
            c4625b.m22108a(10);
            c4625b.m22111a(bArr);
        }
        c4625b.m22113b(1);
        c4625b.m22110a(true);
        c4625b.m22119e(1);
        c4625b.m22122f(1);
        return c4625b;
    }

    public static C4627d m21988c(Context context, byte[] bArr) {
        if (bArr == null || context == null) {
            C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"resolveBTDeviceLinkParameter with parameter is not correct."});
            return null;
        }
        C4627d c4627d = new C4627d();
        String a = a.a(bArr);
        try {
            List list = new C4756w().m22743a(a.substring(4, a.length())).f17337a;
            Object obj = null;
            for (int i = 0; i < list.size(); i++) {
                switch (Integer.parseInt(((C4752s) list.get(i)).m22732a(), 16)) {
                    case 1:
                        c4627d.m22128a(Integer.parseInt(((C4752s) list.get(i)).m22733b(), 16));
                        break;
                    case 2:
                        c4627d.m22131b(Integer.parseInt(((C4752s) list.get(i)).m22733b(), 16));
                        break;
                    case 3:
                        c4627d.m22133c(Integer.parseInt(((C4752s) list.get(i)).m22733b(), 16));
                        break;
                    case 4:
                        c4627d.m22135d(Integer.parseInt(((C4752s) list.get(i)).m22733b(), 16));
                        break;
                    case 5:
                        a = ((C4752s) list.get(i)).m22733b();
                        String str = "";
                        str = "";
                        if (36 != a.length()) {
                            C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"resolveBTDeviceLinkParameter error with handshake parameter is incorrect."});
                            break;
                        }
                        C2538c.a("01", 1, "BTHandshakeManager", new Object[]{"resolveBTDeviceLinkParameter Authentic version : " + a.substring(0, 4)});
                        c4627d.m22137e(Integer.parseInt(r6, 16));
                        C2538c.a("01", 0, "BTHandshakeManager", new Object[]{"resolveBTDeviceLinkParameter Authentic randA info : " + a.substring(4, 36)});
                        c4627d.m22129a(a);
                        break;
                    case 6:
                        c4627d.m22139f(Integer.parseInt(((C4752s) list.get(i)).m22733b(), 16));
                        break;
                    case 127:
                        C2538c.b("01", 1, "BTHandshakeManager", new Object[]{"device tell error code for resolveBTDeviceLinkParameter."});
                        obj = 1;
                        break;
                    default:
                        break;
                }
            }
            return obj != null ? null : c4627d;
        } catch (C4753t e) {
            C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"resolveBTDeviceLinkParameter tlv resolve exception."});
            return null;
        }
    }

    public static C4625b m21987c(int i) {
        C4625b c4625b = new C4625b();
        f16862b = i;
        byte[] bArr;
        if (i == 0) {
            C2538c.a("01", 1, "BTHandshakeManager", new Object[]{"in the AW!!!"});
            bArr = new byte[]{(byte) 1, (byte) 7, (byte) 2, (byte) 0, (byte) 3, (byte) 0, (byte) 7, (byte) 0, (byte) 9, (byte) 0, TagName.IDENTIFYING_CODE, (byte) 0};
            c4625b.m22108a(bArr.length);
            c4625b.m22111a(bArr);
        } else {
            C2538c.a("01", 1, "BTHandshakeManager", new Object[]{"in the normal case!!!"});
            bArr = new byte[]{(byte) 1, (byte) 7, (byte) 2, (byte) 0};
            c4625b.m22108a(bArr.length);
            c4625b.m22111a(bArr);
        }
        c4625b.m22113b(1);
        c4625b.m22110a(true);
        c4625b.m22119e(1);
        c4625b.m22122f(7);
        return c4625b;
    }

    public static C4625b m21980b() {
        C4625b c4625b = new C4625b();
        String a = a.a(1);
        String a2 = a.a(5);
        TimeZone timeZone = TimeZone.getDefault();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        String str = a.a(1) + a.a(4) + a.a(currentTimeMillis >> 24) + a.a((currentTimeMillis >> 16) & 255) + a.a((currentTimeMillis >> 8) & 255) + a.a(currentTimeMillis & 255);
        currentTimeMillis = (timeZone.getRawOffset() / 3600) / 1000;
        if (timeZone.inDaylightTime(new Date())) {
            currentTimeMillis += (timeZone.getDSTSavings() / 3600) / 1000;
        }
        int abs = (Math.abs((timeZone.getRawOffset() / 3600) % 1000) * 60) / 1000;
        if (currentTimeMillis < 0) {
            currentTimeMillis = (Math.abs(currentTimeMillis) + 128) << 8;
        } else {
            currentTimeMillis <<= 8;
        }
        currentTimeMillis += abs;
        byte[] b = a.b(a + a2 + str + (a.a(2) + a.a(2) + a.a(currentTimeMillis >> 8) + a.a(currentTimeMillis & 255)));
        c4625b.m22108a(b.length);
        c4625b.m22111a(b);
        c4625b.m22113b(1);
        c4625b.m22110a(true);
        c4625b.m22119e(1);
        c4625b.m22122f(5);
        return c4625b;
    }

    public static boolean m21990d(Context context, byte[] bArr) {
        if (bArr == null || context == null) {
            C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"resolveBTDeviceGATTTime with parameter is not correct."});
            return false;
        }
        String a = a.a(bArr);
        try {
            List list = new C4756w().m22743a(a.substring(4, a.length())).f17337a;
            if (list.size() <= 0) {
                return false;
            }
            if (100000 == Integer.parseInt(((C4752s) list.get(0)).m22733b(), 16)) {
                return true;
            }
            return false;
        } catch (C4753t e) {
            C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"resolveBTDeviceLinkParameter tlv resolve exception."});
            return false;
        }
    }

    public static C4625b m21964a(Context context, int i, String str, String str2) {
        C4625b c4625b = new C4625b();
        String a = a.a(1);
        String a2 = a.a(19);
        String str3 = a.a(1) + a.a(str.length() / 2) + str;
        byte[] b = a.b(a + a2 + str3 + (a.a(2) + a.a((str2.length() / 2) + 2) + a.b(i) + str2));
        c4625b.m22108a(b.length);
        c4625b.m22111a(b);
        c4625b.m22113b(1);
        c4625b.m22110a(true);
        c4625b.m22119e(1);
        c4625b.m22122f(19);
        return c4625b;
    }

    public static String m21968a(byte[] bArr) {
        if (bArr == null) {
            C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"resolveAuthenticBTDevice with parameter is not correct."});
            return "";
        }
        String a = a.a(bArr);
        try {
            List list = new C4756w().m22743a(a.substring(4, a.length())).f17337a;
            a = "";
            int i = 0;
            while (i < list.size()) {
                String b;
                switch (Integer.parseInt(((C4752s) list.get(i)).m22732a(), 16)) {
                    case 1:
                        b = ((C4752s) list.get(i)).m22733b();
                        break;
                    default:
                        b = a;
                        break;
                }
                i++;
                a = b;
            }
            return a;
        } catch (C4753t e) {
            C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"resolveAuthenticBTDevice tlv resolve exception."});
            return "";
        }
    }

    public static C4625b m21963a(Context context) {
        int i;
        C4625b c4625b = new C4625b();
        byte[] bArr = new byte[13];
        bArr[0] = (byte) 1;
        bArr[1] = (byte) 5;
        Date date = new Date(System.currentTimeMillis());
        String[] split = new SimpleDateFormat("yy MM dd HH mm ss", Locale.US).format(date).split(HwAccountConstants.BLANK);
        bArr[2] = (byte) 10;
        bArr[3] = (byte) 9;
        for (i = 0; i < 6; i++) {
            bArr[i + 4] = (byte) Integer.valueOf(split[i], 16).intValue();
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        i = instance.get(7);
        bArr[10] = (byte) (i == 1 ? 6 : i - 2);
        if (DateFormat.is24HourFormat(context)) {
            byte b = (byte) 2;
        } else {
            boolean z = true;
        }
        if ((byte) 1 == b) {
            bArr[11] = (byte) 2;
        } else {
            bArr[11] = (byte) 1;
        }
        char[] dateFormatOrder = DateFormat.getDateFormatOrder(context);
        if (dateFormatOrder == null || dateFormatOrder.length != 3) {
            i = 3;
        } else if (dateFormatOrder[0] == 'd' && dateFormatOrder[1] == 'M' && dateFormatOrder[2] == 'y') {
            i = 2;
        } else if (dateFormatOrder[0] == 'M' && dateFormatOrder[1] == 'd' && dateFormatOrder[2] == 'y') {
            i = 1;
        } else {
            i = 3;
        }
        bArr[12] = (byte) i;
        c4625b.m22108a(bArr.length);
        c4625b.m22111a(bArr);
        c4625b.m22113b(1);
        c4625b.m22110a(true);
        c4625b.m22119e(1);
        c4625b.m22122f(5);
        return c4625b;
    }

    public static boolean m21992e(Context context, byte[] bArr) {
        if (bArr == null || context == null) {
            C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"resolveBTDeviceGATTTime with parameter is not correct."});
            return false;
        } else if (11 != bArr.length) {
            return false;
        } else {
            return true;
        }
    }

    private static byte[] m21978a(Context context, byte[] bArr, String str, byte[] bArr2) {
        C2538c.a("01", 0, "BTHandshakeManager", new Object[]{"encryptTLVs before encrypt temp =" + C0973a.a(bArr)});
        String a = C4612o.m22004a(context).m22008a(str, context);
        if (a == null) {
            C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"encryptTLVs null == key"});
            return null;
        }
        Object a2;
        if (bArr2 != null) {
            C2538c.a("01", 1, "BTHandshakeManager", new Object[]{"randIV is not null"});
            if (a.length() > 64) {
                String substring = a.substring(0, 32);
                a2 = C4612o.m22004a(context).m22009a(a.substring(32, a.length()), context, str, a.b(substring));
            } else {
                C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"key info is incorrect."});
                return null;
            }
        }
        C2538c.a("01", 1, "BTHandshakeManager", new Object[]{"randIV is null"});
        a2 = C4612o.m22004a(context).m22009a(a, context, str, null);
        bArr2 = C4612o.m22004a(context).m22012a();
        C2538c.a("01", 0, "BTHandshakeManager", new Object[]{"encryptTLVs before encrypt mDevice =" + C4600d.m21899a().m21950d(str)});
        C2538c.c("01", 0, "BTHandshakeManager", new Object[]{"encryptTLVs before encrypt key =" + a2});
        C2538c.c("01", 0, "BTHandshakeManager", new Object[]{"encryptTLVs before encrypt iv  =" + a.a(bArr2)});
        if (!TextUtils.isEmpty(a2)) {
            bArr = C4618u.m22032a(1, bArr, a.b(a2), bArr2);
        }
        C2538c.a("01", 0, "BTHandshakeManager", new Object[]{"encryptTLVs After encrypt result =" + a.a(bArr)});
        return bArr;
    }

    public static byte[] m21976a(Context context, byte[] bArr, String str) {
        r0 = new byte[3];
        byte[] bArr2 = new byte[(bArr.length - 3)];
        C2538c.a("01", 0, "BTHandshakeManager", new Object[]{"encryptTLVsV1 before encrypt sCmd =" + C0973a.a(bArr)});
        System.arraycopy(bArr, 0, r0, 0, 3);
        System.arraycopy(bArr, 3, bArr2, 0, bArr.length - 3);
        C2538c.a("01", 0, "BTHandshakeManager", new Object[]{"encryptTLVsV1 After encrypt result =" + (C0973a.a(r0) + C0973a.a(C4610m.m21978a(context, bArr2, str, null)))});
        return C0973a.b(C0973a.a(r0) + C0973a.a(C4610m.m21978a(context, bArr2, str, null)));
    }

    private static byte[] m21999i() {
        try {
            byte[] a = C4618u.m22031a(16);
            if (a != null) {
                return a;
            }
            C2538c.a("01", 1, "BTHandshakeManager", new Object[]{"generateRandomBytes fail."});
            return null;
        } catch (NoSuchAlgorithmException e) {
            C2538c.a("01", 1, "BTHandshakeManager", new Object[]{"generateRandomBytes exception with info = " + e.getMessage()});
            return null;
        }
    }

    public static byte[] m21977a(Context context, byte[] bArr, String str, boolean z) {
        Object obj = new byte[2];
        byte[] bArr2 = new byte[(bArr.length - 2)];
        C2538c.a("01", 0, "BTHandshakeManager", new Object[]{"encryptTLVsV2 before encrypt sCmd =" + C0973a.a(bArr)});
        System.arraycopy(bArr, 0, obj, 0, 2);
        System.arraycopy(bArr, 2, bArr2, 0, bArr.length - 2);
        byte[] i = C4610m.m21999i();
        if (i == null) {
            C2538c.a("01", 1, "BTHandshakeManager", new Object[]{"randIV is null so use old iv."});
            i = C4612o.m22004a(context).m22012a();
            if (i == null) {
                C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"Old iv is null too."});
                return null;
            }
        }
        if (0 != f16861a) {
            C2538c.a("01", 1, "BTHandshakeManager", new Object[]{"m_bt_encrypt_base_counter = " + f16861a});
            C2538c.a("01", 0, "BTHandshakeManager", new Object[]{"max_id_number = 4294967295"});
            if (MessageHead.SERIAL_MAK == f16861a) {
                f16861a = 1;
            } else if (z) {
                f16861a++;
            } else {
                C2538c.a("01", 1, "BTHandshakeManager", new Object[]{"encryptTLVsV2 send result :" + z});
            }
            byte[] b = C0973a.b(C0973a.a(f16861a));
            if (b != null && 4 == ((long) b.length) && 16 == i.length) {
                i[12] = b[0];
                i[13] = b[1];
                i[14] = b[2];
                i[15] = b[3];
            }
        }
        bArr2 = C4610m.m21978a(context, bArr2, str, i);
        if (bArr2 == null) {
            C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"Do not get encrypt content."});
            return null;
        }
        String str2 = C0973a.a(ReportInfoUtils.FEEDBACK_FAILED) + C0973a.a(1) + C0973a.a(1);
        String a = a.a(i);
        a = a.a(125) + a.a(a.length() / 2) + a;
        String a2 = a.a(bArr2);
        C2538c.a("01", 0, "BTHandshakeManager", new Object[]{"encryptTLVsV2 After encrypt result =" + (a.a(obj) + str2 + a + (a.a(TransportMediator.KEYCODE_MEDIA_PLAY) + a.e(a2.length() / 2) + a2))});
        return a.b(a.a(obj) + str2 + a + (a.a(TransportMediator.KEYCODE_MEDIA_PLAY) + a.e(a2.length() / 2) + a2));
    }

    public static String m21967a(Context context, int i, int i2, int i3, int i4, int i5) {
        String str = C0973a.a(127) + C0973a.a(4) + C0973a.a(100009);
        String str2 = "";
        if (2 != i3 && 1 != i3 && i3 != 0) {
            C2538c.b("01", 1, "BTHandshakeManager", new Object[]{"The link layer version is not match."});
            return str2;
        } else if (2 == i3) {
            return C0973a.a(i) + C0973a.a(i2) + str;
        } else {
            if (1 != i3) {
                return str;
            }
            str2 = C0973a.a(i4);
            String a = a.a(i5);
            return str2 + a + a.a(5) + str;
        }
    }

    public static boolean m21973a(Context context, int i, byte[] bArr) {
        if (bArr == null || context == null) {
            C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"checkTimeOutInfo with parameter is not correct."});
            return true;
        } else if (1 == i || 2 == i) {
            r0 = C0973a.a(bArr);
            try {
                List list = new C4756w().m22743a(r0.substring(4, r0.length())).f17337a;
                if (list.size() <= 0 || 127 != Integer.parseInt(((C4752s) list.get(0)).m22732a(), 16) || 100000 == Integer.parseInt(((C4752s) list.get(0)).m22733b(), 16)) {
                    return false;
                }
                C2538c.b("01", 1, "BTHandshakeManager", new Object[]{"error code = " + Integer.parseInt(((C4752s) list.get(0)).m22733b(), 16)});
                return true;
            } catch (C4753t e) {
                C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"checkTimeOutInfo tlv resolve exception."});
                return true;
            }
        } else if (i != 0) {
            return false;
        } else {
            if (8 == bArr.length && TagName.ELECTRONIC_PUBLISH_START_TIME == bArr[2]) {
                r0 = C0973a.a(bArr);
                if (100009 == Integer.parseInt(r0.substring(r0.length() - 8, r0.length()), 16)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static JSONObject m21994f(Context context, byte[] bArr) {
        C2538c.a("01", 1, "BTHandshakeManager", new Object[]{"Enter resolveDeviceProductType()."});
        JSONObject jSONObject = new JSONObject();
        int i = 5;
        try {
            if (f16862b == 0) {
                i = 15;
            }
            if (bArr == null || context == null) {
                C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"parameter is incorrect."});
                return jSONObject.put("type", -1);
            }
            if (i != bArr.length) {
                C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"command length is incorrect." + bArr.length});
            }
            String a = a.a(bArr);
            try {
                List list = new C4756w().m22743a(a.substring(4, a.length())).f17337a;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    C2538c.a("01", 0, "BTHandshakeManager", new Object[]{"the case is " + Integer.parseInt(((C4752s) list.get(i2)).m22732a(), 16)});
                    switch (Integer.parseInt(((C4752s) list.get(i2)).m22732a(), 16)) {
                        case 2:
                            C2538c.a("01", 0, "BTHandshakeManager", new Object[]{"has DEVICE_PRODUCT_TYPE_VALUE"});
                            jSONObject.put("type", Integer.parseInt(((C4752s) list.get(i2)).m22733b(), 16));
                            break;
                        case 3:
                            C2538c.a("01", 0, "BTHandshakeManager", new Object[]{"has DEVICE_VERSION=" + ((C4752s) list.get(i2)).m22733b()});
                            jSONObject.put("device_version", ((C4752s) list.get(i2)).m22733b());
                            break;
                        case 7:
                            C2538c.a("01", 0, "BTHandshakeManager", new Object[]{"has DEVICE_SOFT_VERSION=" + ((C4752s) list.get(i2)).m22733b()});
                            jSONObject.put(PluginPayAdapter.KEY_DEVICE_INFO_SOFT_VERSION, ((C4752s) list.get(i2)).m22733b());
                            break;
                        case 9:
                            C2538c.a("01", 0, "BTHandshakeManager", new Object[]{"has DEVICE_SN_VALUE"});
                            C2538c.a("01", 0, "BTHandshakeManager", new Object[]{"the sn is " + ((C4752s) list.get(i2)).m22733b()});
                            jSONObject.put("UUID", ((C4752s) list.get(i2)).m22733b());
                            break;
                        case 12:
                            C2538c.a("01", 0, "BTHandshakeManager", new Object[]{"has DEVICE_MODEL=" + ((C4752s) list.get(i2)).m22733b()});
                            C2538c.a("01", 0, "BTHandshakeManager", new Object[]{"has DEVICE_MODEL=" + a.c(((C4752s) list.get(i2)).m22733b())});
                            jSONObject.put(PluginPayAdapter.KEY_DEVICE_INFO_MODEL, a.c(((C4752s) list.get(i2)).m22733b()));
                            break;
                        default:
                            break;
                    }
                }
                return jSONObject;
            } catch (C4753t e) {
                C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"tlv resolve exception."});
                return jSONObject.put("type", -1);
            }
        } catch (JSONException e2) {
            C2538c.a("0xA0200008", "01", 0, "BTHandshakeManager", new Object[]{e2.getMessage()});
        }
    }

    public static C4625b m21982b(Context context) {
        C2538c.a("01", 1, "BTHandshakeManager", new Object[]{"Enter requestBTDeviceServiceCapability()."});
        C4625b c4625b = new C4625b();
        String a = a.a(1);
        String a2 = a.a(2);
        String str = "";
        StringBuffer stringBuffer = new StringBuffer();
        List a3 = C4714b.m22568a();
        for (int i = 1; i < a3.size(); i++) {
            stringBuffer.append(a.a(((Integer) a3.get(i)).intValue()));
        }
        str = stringBuffer.toString();
        byte[] b = a.b(a + a2 + (a.a(1) + a.a(str.length() / 2) + str));
        c4625b.m22108a(b.length);
        c4625b.m22111a(b);
        c4625b.m22113b(1);
        c4625b.m22110a(true);
        c4625b.m22119e(1);
        c4625b.m22122f(2);
        return c4625b;
    }

    public static List<Integer> m21995g(Context context, byte[] bArr) {
        int i = 0;
        if (bArr == null || context == null) {
            C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"resolveBTDeviceServiceCapability with parameter is not correct."});
        }
        String a = a.a(bArr);
        if (a == null || a.length() == 0) {
            C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"dataStrInfo is incorrect."});
            return null;
        }
        C4754u a2;
        try {
            a2 = new C4756w().m22743a(a.substring(4, a.length()));
        } catch (C4753t e) {
            C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"resolveBTDeviceLinkParameter tlv resolve exception."});
            a2 = null;
        }
        if (a2 != null) {
            a = "";
            List list = a2.f17337a;
            if (list.size() > 0) {
                a = ((C4752s) list.get(0)).m22733b();
            } else {
                C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"TLV info is incorrect."});
            }
            if (a.length() <= 0) {
                return null;
            }
            List<Integer> arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(1));
            f16864d.clear();
            while (i < a.length() / 2) {
                if (1 == Integer.parseInt(a.substring(i * 2, (i * 2) + 2), 16)) {
                    arrayList.add(Integer.valueOf(i + 2));
                } else {
                    f16864d.add(Integer.valueOf(i + 2));
                }
                i++;
            }
            return arrayList;
        }
        C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"tlvFather is null."});
        return null;
    }

    public static C4625b m21966a(Context context, List<Integer> list) {
        C2538c.a("01", 1, "BTHandshakeManager", new Object[]{"Enter requestBTDeviceCommandCapability()."});
        if (list == null) {
            C2538c.b("01", 1, "BTHandshakeManager", new Object[]{"serviceIDList is null."});
            return null;
        }
        C4625b c4625b = new C4625b();
        String a = a.a(1);
        String a2 = a.a(3);
        String str = "";
        str = "";
        str = "";
        Map b = C4714b.m22569b();
        Integer.valueOf(0);
        Integer.valueOf(0);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            Integer num = (Integer) list.get(i);
            List list2 = (List) b.get(num);
            if (list2 != null && list2.size() > 0) {
                String str2 = a.a(2) + a.a(1) + a.a(num.intValue());
                String str3 = a.a(3) + a.a(list2.size());
                StringBuffer stringBuffer2 = new StringBuffer();
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    stringBuffer2.append(a.a(((Integer) list2.get(i2)).intValue()));
                }
                str = str3 + stringBuffer2.toString();
                stringBuffer.append(str2);
                stringBuffer.append(str);
            }
        }
        str = stringBuffer.toString();
        byte[] b2 = a.b(a + a2 + (a.a(129) + a.e(str.length() / 2) + str));
        c4625b.m22108a(b2.length);
        c4625b.m22111a(b2);
        c4625b.m22113b(1);
        c4625b.m22110a(true);
        c4625b.m22119e(1);
        c4625b.m22122f(3);
        return c4625b;
    }

    public static C4625b m21986c() {
        C4625b c4625b = new C4625b();
        c4625b.m22119e(1);
        c4625b.m22122f(18);
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.put((byte) 1);
        allocate.put(TagName.THIRD_PAY_NUMBER);
        allocate.put(TagName.ACTIVITY);
        allocate.put((byte) 0);
        c4625b.m22108a(allocate.array().length);
        c4625b.m22111a(allocate.array());
        c4625b.m22113b(1);
        c4625b.m22110a(true);
        return c4625b;
    }

    public static C4625b m21989d() {
        C4625b c4625b = new C4625b();
        c4625b.m22119e(2);
        c4625b.m22122f(5);
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.put((byte) 2);
        allocate.put((byte) 5);
        allocate.put((byte) 1);
        allocate.put((byte) 0);
        c4625b.m22108a(allocate.array().length);
        c4625b.m22111a(allocate.array());
        c4625b.m22113b(1);
        c4625b.m22110a(true);
        return c4625b;
    }

    private static void m21970a(Context context, int i, String str, DeviceCapability deviceCapability) {
        if (context == null || i == 0 || deviceCapability == null) {
            C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"parseCommandIDInfo with parameter is not correct."});
            return;
        }
        List list = (List) C4714b.m22569b().get(Integer.valueOf(i));
        if (list != null && list.size() > 0) {
            int i2 = 0;
            while (i2 < str.length()) {
                boolean z;
                if (Integer.parseInt(str.substring(i2, i2 + 2), 16) == 1) {
                    z = true;
                } else {
                    z = false;
                }
                int i3 = i2 / 2;
                if (i3 < list.size()) {
                    C4619w.m22046a(i, ((Integer) list.get(i3)).intValue(), z, deviceCapability);
                    i2 += 2;
                } else {
                    return;
                }
            }
        }
    }

    public static boolean m21974a(Context context, byte[] bArr, DeviceCapability deviceCapability) {
        boolean z = false;
        if (bArr == null || context == null || deviceCapability == null) {
            C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"resolveBTDeviceCommandCapability with parameter is not correct."});
        }
        String a = a.a(bArr);
        if (a == null || a.length() == 0) {
            C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"dataStrInfo is incorrect for resolveBTDeviceCommandCapability."});
            return false;
        }
        String substring = a.substring(4, a.length());
        C4754u c4754u = null;
        try {
            c4754u = new C4756w().m22743a(substring);
        } catch (C4753t e) {
            C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"resolveBTDeviceCommandCapability tlv resolve exception."});
        }
        if (c4754u != null) {
            substring = "";
            for (C4754u c4754u2 : c4754u.f17338b) {
                for (C4752s c4752s : c4754u2.f17337a) {
                    boolean parseInt;
                    switch (Integer.parseInt(c4752s.m22732a(), 16)) {
                        case 2:
                            parseInt = Integer.parseInt(c4752s.m22733b(), 16);
                            break;
                        case 4:
                            C4610m.m21970a(context, (int) z, c4752s.m22733b(), deviceCapability);
                            parseInt = z;
                            break;
                        default:
                            parseInt = z;
                            break;
                    }
                    z = parseInt;
                }
            }
            return true;
        }
        C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"tlvFather is null."});
        return false;
    }

    public static boolean m21975a(byte[] bArr, DeviceCapability deviceCapability) {
        if (bArr == null || deviceCapability == null) {
            C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"resolveBTDeviceSupportedActivityType with parameter is not correct."});
            return false;
        }
        String a = a.a(bArr);
        if (a == null || a.length() == 0) {
            C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"dataStrInfo is incorrect."});
            return false;
        }
        String substring = a.substring(4, a.length());
        C4754u c4754u = null;
        try {
            c4754u = new C4756w().m22743a(substring);
        } catch (C4753t e) {
            C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"resolveBTDeviceSupportedActivityType tlv resolve exception."});
        }
        if (c4754u != null) {
            for (C4754u c4754u2 : c4754u.f17338b) {
                for (C4752s c4752s : c4754u2.f17337a) {
                    switch (Integer.parseInt(c4752s.m22732a(), 16)) {
                        case 2:
                            C4619w.m22052b(Integer.parseInt(c4752s.m22733b(), 16), deviceCapability);
                            break;
                        case 3:
                            C4619w.m22056c(Integer.parseInt(c4752s.m22733b(), 16), deviceCapability);
                            break;
                        default:
                            break;
                    }
                }
            }
            return true;
        }
        C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"tlvFather is null."});
        return false;
    }

    public static boolean m21984b(byte[] bArr, DeviceCapability deviceCapability) {
        if (bArr == null || deviceCapability == null) {
            C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"resolveBTDeviceSupportedNotificationType() with parameter is not correct."});
            return false;
        }
        String a = a.a(bArr);
        if (a == null || a.length() == 0) {
            C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"resolveBTDeviceSupportedNotificationType() dataStrInfo is incorrect."});
            return false;
        }
        String substring = a.substring(4, a.length());
        C4754u c4754u = null;
        try {
            c4754u = new C4756w().m22743a(substring);
        } catch (C4753t e) {
            C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"resolveBTDeviceSupportedNotificationType tlv resolve exception."});
        }
        if (c4754u != null) {
            for (C4752s c4752s : c4754u.f17337a) {
                switch (Integer.parseInt(c4752s.m22732a(), 16)) {
                    case 1:
                        C4619w.m22060d(Integer.parseInt(c4752s.m22733b(), 16), deviceCapability);
                        break;
                    default:
                        break;
                }
            }
            return true;
        }
        C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"resolveBTDeviceSupportedNotificationType() tlvFather is null."});
        return false;
    }

    public static boolean m21972a(int i, int i2, byte[] bArr) {
        String a = a.a(bArr);
        if (a == null || a.length() == 0) {
            C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"isSupportedCommand() dataStrInfo is incorrect."});
            return false;
        }
        C4754u a2;
        C2538c.a("01", 0, "BTHandshakeManager", new Object[]{"isSupportedCommand() tlvStrInfo = " + a.substring(4, a.length())});
        C4754u c4754u = null;
        try {
            a2 = new C4756w().m22743a(a.substring(4, a.length()));
        } catch (C4753t e) {
            C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"isSupportedCommand() tlv resolve exception."});
            a2 = c4754u;
        }
        if (a2 != null) {
            boolean z = false;
            int i3 = 0;
            for (C4754u c4754u2 : a2.f17338b) {
                for (C4752s c4752s : c4754u2.f17337a) {
                    switch (Integer.parseInt(c4752s.m22732a(), 16)) {
                        case 2:
                            if (i != Integer.parseInt(c4752s.m22733b(), 16)) {
                                break;
                            }
                            i3 = i;
                            break;
                        case 4:
                            if (i3 == 0) {
                                break;
                            }
                            String b = c4752s.m22733b();
                            C2538c.a("01", 0, "BTHandshakeManager", new Object[]{"isSupportedCommand() strCommandIDValueInfo = " + b});
                            List list = (List) C4714b.m22569b().get(Integer.valueOf(i3));
                            if (list != null && list.size() > 0) {
                                boolean z2 = z;
                                int i4 = i3;
                                for (int i5 = 0; i5 < b.length(); i5 += 2) {
                                    boolean z3;
                                    C2538c.a("01", 0, "BTHandshakeManager", new Object[]{"isSupportedCommand() index = " + i5});
                                    if (Integer.parseInt(b.substring(i5, i5 + 2), 16) == 1) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    if (i2 == ((Integer) list.get(i5 / 2)).intValue()) {
                                        C2538c.a("01", 1, "BTHandshakeManager", new Object[]{"isSupportedCommand() flag = " + z3});
                                        i4 = 0;
                                        z2 = z3;
                                    }
                                }
                                i3 = i4;
                                z = z2;
                                break;
                            }
                        default:
                            break;
                    }
                }
            }
            return z;
        }
        C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"isSupportedCommand() tlvFather is null."});
        return false;
    }

    public static byte[] m21985b(Context context, byte[] bArr, String str) {
        C2538c.a("01", 1, "BTHandshakeManager", new Object[]{"Enter checkEncryptCommand()."});
        if (bArr == null) {
            C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"dataContent is null."});
            return null;
        }
        String a = a.a(bArr);
        try {
            List list = new C4756w().m22743a(a.substring(4, a.length())).f17337a;
            int i = 0;
            String str2 = "";
            String str3 = "";
            int i2 = 0;
            while (i2 < list.size()) {
                int parseInt;
                switch (Integer.parseInt(((C4752s) list.get(i2)).m22732a(), 16)) {
                    case ReportInfoUtils.FEEDBACK_FAILED /*124*/:
                        String str4 = str3;
                        str3 = str2;
                        parseInt = Integer.parseInt(((C4752s) list.get(i2)).m22733b(), 16);
                        a = str4;
                        break;
                    case 125:
                        parseInt = i;
                        a = str3;
                        str3 = ((C4752s) list.get(i2)).m22733b();
                        break;
                    case TransportMediator.KEYCODE_MEDIA_PLAY /*126*/:
                        a = ((C4752s) list.get(i2)).m22733b();
                        str3 = str2;
                        parseInt = i;
                        break;
                    default:
                        a = str3;
                        str3 = str2;
                        parseInt = i;
                        break;
                }
                i2++;
                i = parseInt;
                str2 = str3;
                str3 = a;
            }
            if (1 == i) {
                C2538c.a("01", 1, "BTHandshakeManager", new Object[]{"Need to desEncrypt."});
                if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                    C2538c.b("01", 1, "BTHandshakeManager", new Object[]{"Encrypt data is incorrect."});
                    return null;
                }
                a = C4612o.m22004a(context).m22008a(str, context);
                if (a == null) {
                    C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"encryptTLVs key is null."});
                    return null;
                }
                C2538c.c("01", 0, "BTHandshakeManager", new Object[]{"Encrypt Key = " + a});
                if (a.length() > 64) {
                    String substring = a.substring(0, 32);
                    a = C4612o.m22004a(context).m22009a(a.substring(32, a.length()), context, str, a.b(substring));
                    if (TextUtils.isEmpty(a)) {
                        C2538c.a("01", 1, "BTHandshakeManager", new Object[]{"key is not incorrect."});
                        return null;
                    }
                    C2538c.a("01", 1, "BTHandshakeManager", new Object[]{"Start to desEncrypt data."});
                    C2538c.c("01", 0, "BTHandshakeManager", new Object[]{"Source Key = " + a});
                    C2538c.c("01", 0, "BTHandshakeManager", new Object[]{"encryptData = " + str3});
                    C2538c.c("01", 0, "BTHandshakeManager", new Object[]{"encryptIV = " + str2});
                    Object b = C4618u.m22035b(1, a.b(str3), a.b(a), a.b(str2));
                    if (b == null) {
                        return null;
                    }
                    Object obj = new byte[(b.length + 2)];
                    obj[0] = bArr[0];
                    obj[1] = bArr[1];
                    System.arraycopy(b, 0, obj, 2, b.length);
                    return obj;
                }
                C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"key info is incorrect."});
                return null;
            }
            C2538c.a("01", 1, "BTHandshakeManager", new Object[]{"Do not need desEncrypt."});
            return bArr;
        } catch (C4753t e) {
            C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"checkDesEncryptCommand tlv resolve exception."});
            return null;
        } catch (NumberFormatException e2) {
            C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"checkDesEncryptCommand tlv resolve NumberFormatException."});
            return null;
        }
    }

    public static C4625b m21991e() {
        C4625b c4625b = new C4625b();
        byte[] bArr = new byte[]{(byte) 1, TagName.ORDER_TRADE_NO, (byte) 1, (byte) 0};
        c4625b.m22108a(bArr.length);
        c4625b.m22111a(bArr);
        c4625b.m22113b(1);
        c4625b.m22110a(true);
        c4625b.m22119e(1);
        c4625b.m22122f(22);
        return c4625b;
    }

    public static int m21997h(Context context, byte[] bArr) {
        if (bArr == null || context == null) {
            C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"getBTDeviceAvailableStatusParameter with parameter is not correct."});
            return -1;
        }
        String a = a.a(bArr);
        try {
            List list = new C4756w().m22743a(a.substring(4, a.length())).f17337a;
            int i = -1;
            for (int i2 = 0; i2 < list.size(); i2++) {
                switch (Integer.parseInt(((C4752s) list.get(i2)).m22732a(), 16)) {
                    case 0:
                        C2538c.b("01", 1, "BTHandshakeManager", new Object[]{" Not support dual phone connection."});
                        i = Integer.parseInt(((C4752s) list.get(i2)).m22733b(), 16);
                        break;
                    case 1:
                        C2538c.b("01", 1, "BTHandshakeManager", new Object[]{"current connected."});
                        i = Integer.parseInt(((C4752s) list.get(i2)).m22733b(), 16);
                        break;
                    case 2:
                        C2538c.b("01", 1, "BTHandshakeManager", new Object[]{"Has been connected."});
                        i = Integer.parseInt(((C4752s) list.get(i2)).m22733b(), 16);
                        break;
                    default:
                        break;
                }
            }
            return i;
        } catch (C4753t e) {
            C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"getBTDeviceAvailableStatusParameter tlv resolve exception."});
            return -1;
        }
    }

    public static C4625b m21993f() {
        C4625b c4625b = new C4625b();
        c4625b.m22119e(1);
        c4625b.m22122f(20);
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.put((byte) 1);
        allocate.put(TagName.ORDER_TIME);
        allocate.put((byte) 1);
        allocate.put((byte) 0);
        c4625b.m22108a(allocate.array().length);
        c4625b.m22111a(allocate.array());
        c4625b.m22113b(1);
        c4625b.m22110a(true);
        return c4625b;
    }

    public static boolean m21983b(byte[] bArr) {
        if (bArr == null) {
            C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"resolveGoldCard with parameter is not correct."});
            return false;
        }
        String a = a.a(bArr);
        try {
            List list = new C4756w().m22743a(a.substring(4, a.length())).f17337a;
            if (list.size() <= 0) {
                return false;
            }
            C2538c.a("01", 0, "BTHandshakeManager", new Object[]{"resolveGoldCard result :" + Integer.parseInt(((C4752s) list.get(0)).m22733b(), 16)});
            a = Integer.toBinaryString(r4);
            int length = a.length();
            if (8 > length) {
                int i = 0;
                while (i < 8 - length) {
                    i++;
                    a = "0" + a;
                }
            }
            C2538c.a("01", 0, "BTHandshakeManager", new Object[]{"resolveGoldCard result :" + r4 + "info" + a});
            return a.substring(4, 5).equals("1");
        } catch (C4753t e) {
            C2538c.a("0xA0200008", "01", 1, "BTHandshakeManager", new Object[]{"resolveGoldCard tlv resolve exception."});
            return false;
        }
    }

    public static void m21971a(C3988a c3988a) {
        C2538c.b("01", 1, "BTHandshakeManager", new Object[]{"Enter setIConnectService."});
        if (c3988a == null) {
            C2538c.b("01", 1, "BTHandshakeManager", new Object[]{"setIConnectService with mIConnectService is null."});
        }
        f16863c = c3988a;
    }

    public static boolean m21996g() {
        try {
            BaseApplication.b().getPackageManager().getApplicationInfo("com.huawei.iconnect", 0);
            C2538c.a("01", 1, "BTHandshakeManager", new Object[]{"iconnect pkg exist."});
            return true;
        } catch (NameNotFoundException e) {
            C2538c.a("01", 1, "BTHandshakeManager", new Object[]{"iconnect pkg do not exist."});
            return false;
        }
    }

    public static boolean m21998h() {
        PackageManager packageManager = BaseApplication.b().getPackageManager();
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(new Intent("com.huawei.iconnect.action.WEAR_CONNECT_SERVICE"), 0);
        if (queryIntentServices == null || queryIntentServices.size() == 0) {
            C2538c.b("01", 1, "BTHandshakeManager", new Object[]{"getIConnectServiceAction: listInfo is empty."});
            return false;
        }
        ApplicationInfo applicationInfo = null;
        for (ResolveInfo resolveInfo : queryIntentServices) {
            ApplicationInfo applicationInfo2;
            C2538c.a("01", 0, "BTHandshakeManager", new Object[]{"pkgName = " + resolveInfo.serviceInfo.packageName + ", service = " + ((ResolveInfo) r5.next()).serviceInfo.name});
            try {
                applicationInfo2 = packageManager.getApplicationInfo(((ResolveInfo) r5.next()).serviceInfo.packageName, 0);
            } catch (NameNotFoundException e) {
                C2538c.b("01", 1, "BTHandshakeManager", new Object[]{"e = " + e.getMessage()});
                applicationInfo2 = applicationInfo;
            }
            if (applicationInfo2 == null) {
                C2538c.b("01", 1, "BTHandshakeManager", new Object[]{"getIConnectServiceAction: null == applicationInfo"});
                applicationInfo = applicationInfo2;
            } else {
                C2538c.a("01", 1, "BTHandshakeManager", new Object[]{"getIConnectServiceAction: isSystemApp = " + ((applicationInfo2.flags & 1) != 0)});
                if ((applicationInfo2.flags & 1) != 0) {
                    return true;
                }
                C2538c.b("01", 1, "BTHandshakeManager", new Object[]{"getIConnectServiceAction: not system app"});
                applicationInfo = applicationInfo2;
            }
        }
        return false;
    }
}
