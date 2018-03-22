package com.huawei.hwservicesmgr.p076a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.huawei.al.e;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.datatypes.C0979f;
import com.huawei.hwcommonmodel.datatypes.DataPromptData;
import com.huawei.hwcommonmodel.datatypes.DeviceCapability;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.datatypes.MsgImage;
import com.huawei.hwcommonmodel.datatypes.MsgText;
import com.huawei.hwcommonmodel.datatypes.s;
import com.huawei.hwcommonmodel.datatypes.u;
import com.huawei.hwcommonmodel.datatypes.w;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import com.huawei.hwdevicemgr.p073a.C1023c;
import com.huawei.hwservicesmgr.a.d;
import com.huawei.hwservicesmgr.a.f;
import com.huawei.hwservicesmgr.a.g;
import com.huawei.p190v.C2538c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: NotifySendData */
public class C1043e {
    private static int f2036b = 0;
    private static Context f2037c = null;
    private static C1043e f2038d = null;
    private static final Object f2039s = new Object();
    e f2040a;
    private C1023c f2041e;
    private DeviceCommand f2042f;
    private ArrayList<byte[]> f2043g;
    private int f2044h;
    private int f2045i;
    private boolean f2046j;
    private boolean f2047k;
    private int f2048l;
    private int f2049m;
    private boolean f2050n;
    private boolean f2051o;
    private int f2052p;
    private int f2053q;
    private BroadcastReceiver f2054r;

    private C1043e() {
        this.f2042f = null;
        this.f2040a = null;
        this.f2043g = null;
        this.f2044h = 0;
        this.f2045i = 240;
        this.f2046j = true;
        this.f2047k = true;
        this.f2048l = 30;
        this.f2049m = 30;
        this.f2050n = false;
        this.f2051o = false;
        this.f2052p = 2;
        this.f2053q = 2;
        this.f2054r = new f(this);
        this.f2041e = C1023c.m3920a(f2037c);
        this.f2040a = new e(f2037c);
        f2037c.registerReceiver(this.f2054r, new IntentFilter("com.huawei.bone.action.CONNECTION_STATE_CHANGED"), C0976c.f1642a, null);
    }

    public static C1043e m4358a(Context context) {
        if (f2038d == null && context != null) {
            f2037c = context;
            C2538c.m12677c("NotifySendData", "getInstance() context = " + context);
            f2038d = new C1043e();
        }
        return f2038d;
    }

    private void m4366f() {
        DeviceCapability b = this.f2041e.m3993b();
        if (b != null) {
            C2538c.m12677c("NotifySendData", "pushPromptToDevice isPromptPush = " + b.isPromptPush());
            if (-1 == b.isPromptPush() && 2 == m4380c()) {
                DeviceCommand deviceCommand = new DeviceCommand();
                deviceCommand.setServiceID(2);
                deviceCommand.setCommandID(5);
                String str = C0973a.m3506a(1) + C0973a.m3506a(0);
                deviceCommand.setDataContent(C0973a.m3512b(str));
                deviceCommand.setDataLen(C0973a.m3512b(str).length);
                deviceCommand.setNeedAck(true);
                this.f2041e.m3995b(deviceCommand);
                C2538c.m12677c("NotifySendData", "sendCapabilityCmd() 5.2.5");
            }
        }
    }

    public void m4377a(byte[] bArr) {
        if (bArr.length < 5) {
            C2538c.m12679d("NotifySendData", "handleCapability ,length < 5, return");
        } else if ((byte) 5 == bArr[1]) {
            r0 = bArr[4] & 1;
            C2538c.m12677c("NotifySendData", "handleCapability ,mIsSupportMessage value = " + r0);
            C2538c.m12677c("NotifySendData", "handleCapability ,mIsSupportPrompt value = " + ((bArr[4] >> 1) & 1));
            if (((bArr[4] >> 1) & 1) == 0) {
                this.f2046j = false;
            } else {
                this.f2046j = true;
            }
        } else if ((byte) 2 == bArr[1]) {
            C2538c.m12677c("NotifySendData", "handleCapability ,COMMAND_ID_MESSAGE_CONSTRAINT data = " + C0973a.m3509a(bArr));
            try {
                C2538c.m12677c("NotifySendData", "handleCapability ,getContentLength = " + m4362b(bArr).a());
                r0 = (r0 / 6) * 6;
                if (r0 > 0) {
                    this.f2045i = r0;
                }
                C2538c.m12677c("NotifySendData", "handleCapability ,mContentLength = " + this.f2045i);
                m4365c(bArr);
            } catch (Exception e) {
                C2538c.m12679d("NotifySendData", "handleCapability ,Exception = " + e.getMessage());
            }
        }
    }

    private d m4362b(byte[] bArr) throws Exception {
        C2538c.m12677c("NotifySendData", "unGetOtaParametersV2 enter... data = " + C0973a.m3509a(bArr));
        w wVar = new w();
        byte[] bArr2 = new byte[9];
        int i = 0;
        while (i < bArr.length) {
            try {
                if (TagName.THIRD_PAY_NUMBER == bArr[i] && (byte) 1 == bArr[i + 2]) {
                    System.arraycopy(bArr, i, bArr2, 0, bArr2.length);
                }
                i++;
            } catch (Exception e) {
                C2538c.m12679d("NotifySendData", "unNotificationConstraint ,Exception = " + e.getMessage());
            }
        }
        C2538c.m12677c("NotifySendData", "unGetOtaParametersV2 enter... tlvsString = " + C0973a.m3509a(bArr2));
        return m4357a(wVar.a(C0973a.m3509a(bArr2)));
    }

    private d m4357a(u uVar) {
        C2538c.m12677c("NotifySendData", "unDeviceApply enter.. ");
        d dVar = new d();
        List<s> list = uVar.a;
        if (list != null && list.size() > 0) {
            for (s sVar : list) {
                int parseInt = Integer.parseInt(sVar.a(), 16);
                String b = sVar.b();
                switch (parseInt) {
                    case 20:
                        dVar.a(Integer.parseInt(b, 16));
                        C2538c.m12677c("NotifySendData", "constraint.setContentLength:" + Long.parseLong(b, 16));
                        break;
                    default:
                        break;
                }
            }
        }
        return dVar;
    }

    private void m4367g() {
        DeviceCapability b = this.f2041e.m3993b();
        m4368h();
        if (b != null) {
            C2538c.m12677c("NotifySendData", "sendNotificationConstraint isMessage_alert = " + b.isMessage_alert());
            if (b.isMessage_alert()) {
                this.f2045i = 240;
                if (2 == m4380c()) {
                    DeviceCommand deviceCommand = new DeviceCommand();
                    deviceCommand.setServiceID(2);
                    deviceCommand.setCommandID(2);
                    String str = C0973a.m3506a(1) + C0973a.m3506a(0);
                    deviceCommand.setDataContent(C0973a.m3512b(str));
                    deviceCommand.setDataLen(C0973a.m3512b(str).length);
                    deviceCommand.setNeedAck(true);
                    this.f2041e.m3995b(deviceCommand);
                    C2538c.m12677c("NotifySendData", "sendCapabilityCmd() 5.2.2");
                }
            }
        }
    }

    private void m4368h() {
        C2538c.m12677c("NotifySendData", " resetAbility() ");
        this.f2048l = 30;
        this.f2049m = 30;
        this.f2050n = false;
        this.f2051o = false;
        this.f2052p = 2;
        this.f2053q = 2;
    }

    public void m4374a() {
        try {
            f2037c.unregisterReceiver(this.f2054r);
        } catch (RuntimeException e) {
            C2538c.m12677c("NotifySendData", "RuntimeException:" + e.getMessage());
        } catch (Exception e2) {
            C2538c.m12677c("NotifySendData", "Exception:" + e2.getMessage());
        }
    }

    private void m4369i() {
        f2036b++;
        if (f2036b == 256) {
            f2036b = 0;
        }
    }

    private String m4363b(int i) {
        if (i <= 127) {
            return C0973a.m3506a(i);
        }
        return C0973a.m3506a((i >> 7) + 128) + C0973a.m3506a(i & 127);
    }

    public DeviceCommand m4372a(int i, boolean z, List<MsgImage> list, List<MsgText> list2) {
        com.huawei.hwcommonmodel.datatypes.d a = g.a(i, z, list, list2, this.f2052p, this.f2053q);
        StringBuilder stringBuilder = new StringBuilder("");
        StringBuilder stringBuilder2 = new StringBuilder();
        m4369i();
        int c = a.c();
        int a2 = a.a();
        String str = "";
        C2538c.m12677c("NotifySendData", "notificationMsgToTLVS, messageIdTlv---------" + (C0973a.m3506a(1) + C0973a.m3506a(2) + C0973a.m3510b(f2036b)));
        C2538c.m12677c("NotifySendData", "notificationMsgToTLVS, messageTypeTlvHex---------" + (C0973a.m3506a(2) + C0973a.m3506a(1) + C0973a.m3506a(c)));
        C2538c.m12677c("NotifySendData", "notificationMsgToTLVS, motor_enableTlvHex---------" + (C0973a.m3506a(3) + C0973a.m3506a(1) + C0973a.m3506a(a2)));
        String str2 = "";
        str2 = "";
        ArrayList b = a.b();
        C2538c.m12677c("NotifySendData", "notificationMsgToTLVS, IsSupportYellow : " + this.f2050n + " ; YellowPagesLength : " + this.f2048l + " ; YellowPagesFomat : " + this.f2052p + " ; IsSupportSign : " + this.f2051o + " ; ContentSignLength : " + this.f2049m + " ; ContentSignFomat : " + this.f2053q);
        g.a(this.f2050n, this.f2051o, this.f2045i, this.f2048l, this.f2049m);
        str = g.a(stringBuilder2, "", "", "", b);
        String b2 = m4363b((str2 + stringBuilder + str + stringBuilder2).length() / 2);
        if (b2.length() > 0) {
            b2 = C0973a.m3506a(132) + b2;
        } else {
            b2 = C0973a.m3506a(4) + C0973a.m3506a(0);
        }
        C2538c.m12677c("NotifySendData", "notificationMsgToTLVS, message_content_structTlvHex---------" + b2);
        b2 = r5 + r3 + r4 + b2 + str2 + stringBuilder + str + stringBuilder2;
        C2538c.m12677c("NotifySendData", "notificationMsgToTLVS sCmd---------------" + b2);
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(2);
        deviceCommand.setCommandID(1);
        if (m4370j()) {
            deviceCommand.setNeedEncrypt(true);
        } else {
            deviceCommand.setNeedEncrypt(false);
        }
        deviceCommand.setDataContent(C0973a.m3512b(b2));
        deviceCommand.setDataLen(C0973a.m3512b(b2).length);
        return deviceCommand;
    }

    public DeviceCommand m4373a(DataPromptData dataPromptData, C0979f c0979f) {
        String a = g.a(c0979f, dataPromptData);
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(2);
        deviceCommand.setCommandID(1);
        deviceCommand.setNeedEncrypt(false);
        deviceCommand.setDataContent(C0973a.m3512b(a));
        deviceCommand.setDataLen(C0973a.m3512b(a).length);
        return deviceCommand;
    }

    public void m4375a(DeviceCommand deviceCommand, int i) {
        if (this.f2041e.m3997c() != 3) {
            C2538c.m12680e("NotifySendData", "sendNotificationCmd error, BTSwitchState is OFF");
            return;
        }
        DeviceInfo b = m4378b();
        if (b == null) {
            C2538c.m12680e("NotifySendData", "sendNotificationCmd error, getCurrentDeviceInfo() is null");
            return;
        }
        C2538c.m12677c("NotifySendData", "sendNotificationCmd DeviceConnectState =" + b.getDeviceConnectState());
        if (2 == b.getDeviceConnectState() || 1 == b.getDeviceConnectState() || 5 == b.getDeviceConnectState()) {
            this.f2044h = i;
            C2538c.m12677c("NotifySendData", "sendNotificationCmd mMessageType = " + this.f2044h);
            if (1 == this.f2044h) {
                DeviceCapability b2 = this.f2041e.m3993b();
                C2538c.m12677c("NotifySendData", "pushPromptToDevice isPromptPush = " + b2.isPromptPush());
                if (-1 == b2.isPromptPush()) {
                    if (!this.f2046j) {
                        C2538c.m12679d("NotifySendData", "pushPromptToDevice, mIsSupportPrompt is false,device not support prompt");
                        return;
                    }
                } else if (((b2.isPromptPush() >> 1) & 1) != 1) {
                    C2538c.m12679d("NotifySendData", "pushPromptToDevice, deviceCapability.isPromptPush() is false,device not support prompt");
                    return;
                }
            }
            this.f2041e.m3995b(deviceCommand);
            return;
        }
        if (this.f2042f == null) {
            this.f2042f = deviceCommand;
            C2538c.m12677c("NotifySendData", "mDeviceCommand data = " + C0973a.m3509a(this.f2042f.getDataContent()));
        }
        C2538c.m12677c("NotifySendData", "sendNotificationCmd mIsForceConnect = " + this.f2047k);
        if (this.f2047k) {
            this.f2041e.m3992a(false);
            this.f2047k = false;
        }
        this.f2044h = i;
    }

    private boolean m4370j() {
        DeviceInfo b = m4378b();
        if (b != null) {
            C2538c.m12677c("NotifySendData", "isNeedEncrypt Encrypt type =" + b.getEncryptType());
            if (1 == b.getEncryptType()) {
                return true;
            }
        }
        C2538c.m12680e("NotifySendData", "encryptTLVs getCurrentDeviceInfo() = null");
        return false;
    }

    public DeviceInfo m4378b() {
        synchronized (f2039s) {
            try {
                C2538c.m12677c("NotifySendData", "getCurrentDeviceInfo() enter...");
                List a = this.f2041e.m3984a();
                for (int i = 0; i < a.size(); i++) {
                    DeviceInfo deviceInfo = (DeviceInfo) a.get(i);
                    if (1 == deviceInfo.getDeviceActiveState()) {
                        return deviceInfo;
                    }
                }
                return null;
            } catch (Exception e) {
                C2538c.m12680e("NotifySendData", "getCurrentDeviceInfo() error = " + e.getMessage());
                return null;
            }
        }
    }

    public int m4380c() {
        if (m4378b() != null) {
            return m4378b().getDeviceProtocol();
        }
        return -1;
    }

    public void m4376a(String str) {
        C2538c.m12677c("NotifySendData", "Enter setV0EventAlarmMessageCount.");
        this.f2043g = this.f2040a.a(str);
        if (this.f2043g == null || this.f2043g.size() == 0) {
            C2538c.m12680e("NotifySendData", "Can not get HZK data.");
            return;
        }
        int size = this.f2043g.size();
        byte[] bArr = new byte[]{TagName.BUSINESS_ORDER_LIST, (byte) 3, (byte) 1, (byte) 0, (byte) 0};
        bArr[3] = (byte) (size >> 8);
        bArr[4] = (byte) (size & 255);
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(2);
        deviceCommand.setCommandID(1);
        deviceCommand.setDataLen(bArr.length);
        deviceCommand.setDataContent(bArr);
        this.f2041e.m3995b(deviceCommand);
    }

    public void m4381d() {
        C2538c.m12677c("NotifySendData", "Enter setV0CallingMessageContent.");
        if (this.f2043g == null || this.f2043g.size() <= 0) {
            C2538c.m12680e("NotifySendData", "V0 Calling Message is incorrect.");
            return;
        }
        C2538c.m12677c("NotifySendData", "V0 Calling Message Byte List Size = " + this.f2043g.size());
        byte[] bArr = (byte[]) this.f2043g.get(0);
        this.f2043g.remove(0);
        bArr = Arrays.copyOfRange(bArr, 1, bArr.length - 1);
        C2538c.m12677c("NotifySendData", "V0 Calling Message = " + C0973a.m3509a(bArr));
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(2);
        deviceCommand.setCommandID(1);
        deviceCommand.setDataLen(bArr.length);
        deviceCommand.setDataContent(bArr);
        this.f2041e.m3995b(deviceCommand);
    }

    public void m4379b(String str) {
        C2538c.m12677c("NotifySendData", "Enter send3RDCallingOnMessage.");
        if (TextUtils.isEmpty(str)) {
            C2538c.m12680e("NotifySendData", "phoneNumber is invalid.");
            return;
        }
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(2);
        deviceCommand.setCommandID(1);
        byte[] b = C0973a.m3512b(str);
        if (b != null) {
            deviceCommand.setDataLen(b.length);
            deviceCommand.setDataContent(b);
        }
        this.f2041e.m3995b(deviceCommand);
    }

    public void m4382e() {
        C2538c.m12677c("NotifySendData", "Enter send3RDCallingOffMessage.");
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(2);
        deviceCommand.setCommandID(1);
        deviceCommand.setDataLen(0);
        deviceCommand.setDataContent(null);
        this.f2041e.m3995b(deviceCommand);
    }

    private void m4360a(byte[] bArr, int i) {
        try {
            String b;
            C2538c.m12677c("NotifySendData", "unNotificationContent enter... tlvsString = " + C0973a.m3509a(bArr));
            List<s> list = new w().a(b).a;
            if (list != null && list.size() > 0) {
                for (s sVar : list) {
                    int parseInt = Integer.parseInt(sVar.a(), 16);
                    b = sVar.b();
                    int parseInt2;
                    switch (parseInt) {
                        case 19:
                            if (i != 5) {
                                if (i != 6) {
                                    break;
                                }
                                parseInt2 = Integer.parseInt(b, 16);
                                if (parseInt2 == 3) {
                                    this.f2053q = 2;
                                } else {
                                    this.f2053q = parseInt2;
                                }
                                C2538c.m12677c("NotifySendData", "==unNotificationContent mContentSignFomat = " + this.f2053q);
                                break;
                            }
                            parseInt2 = Integer.parseInt(b, 16);
                            if (parseInt2 == 3) {
                                this.f2052p = 2;
                            } else {
                                this.f2052p = parseInt2;
                            }
                            C2538c.m12677c("NotifySendData", "==unNotificationContent mYellowPagesFomat = " + this.f2052p);
                            break;
                        case 20:
                            parseInt2 = (Integer.parseInt(b, 16) / 6) * 6;
                            if (parseInt2 > 0) {
                                if (i != 5) {
                                    if (i != 6) {
                                        break;
                                    }
                                    this.f2049m = parseInt2;
                                    C2538c.m12677c("NotifySendData", "unNotificationContent mContentSignLength = " + this.f2049m);
                                    break;
                                }
                                this.f2048l = parseInt2;
                                C2538c.m12677c("NotifySendData", "==unNotificationContent mYellowPagesLength = " + this.f2048l);
                                break;
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
        } catch (Exception e) {
            C2538c.m12679d("NotifySendData", "==unNotificationContent ,Exception = " + e.getMessage());
        }
    }

    private void m4365c(byte[] bArr) {
        C2538c.m12677c("NotifySendData", "==unNotificationContent enter... data = " + C0973a.m3509a(bArr));
        int i = 0;
        while (i < bArr.length) {
            try {
                if (TagName.THIRD_PAY_NUMBER == bArr[i]) {
                    byte[] bArr2;
                    if ((byte) 5 == bArr[i + 2]) {
                        bArr2 = new byte[9];
                        System.arraycopy(bArr, i, bArr2, 0, bArr2.length);
                        this.f2050n = true;
                        C2538c.m12677c("NotifySendData", "==unNotificationContent mIsSupportYellow = " + this.f2050n);
                        m4360a(bArr2, 5);
                    } else if ((byte) 6 == bArr[i + 2]) {
                        bArr2 = new byte[9];
                        System.arraycopy(bArr, i, bArr2, 0, bArr2.length);
                        this.f2051o = true;
                        C2538c.m12677c("NotifySendData", "==unNotificationContent mIsSupportSign = " + this.f2051o);
                        m4360a(bArr2, 6);
                    }
                }
                i++;
            } catch (Exception e) {
                C2538c.m12679d("NotifySendData", "==unNotificationContent ,Exception = " + e.getMessage());
                return;
            }
        }
    }

    public DeviceCommand m4371a(int i) {
        String a = C0973a.m3506a(i);
        a = C0973a.m3506a(1) + C0973a.m3506a(a.length() / 2) + a;
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(2);
        deviceCommand.setCommandID(6);
        deviceCommand.setNeedEncrypt(false);
        deviceCommand.setDataContent(C0973a.m3512b(a));
        C2538c.m12677c("NotifySendData", "deleteMsgToTLVS  command: " + a);
        deviceCommand.setDataLen(C0973a.m3512b(a).length);
        return deviceCommand;
    }
}
