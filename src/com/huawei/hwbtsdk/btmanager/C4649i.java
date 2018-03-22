package com.huawei.hwbtsdk.btmanager;

import android.os.Message;
import android.text.TextUtils;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.huawei.hwbtsdk.p057b.p058a.C0958f;
import com.huawei.hwbtsdk.p057b.p400b.C4625b;
import com.huawei.hwbtsdk.p057b.p400b.C4628e;
import com.huawei.hwbtsdk.p399a.C4610m;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.p190v.C2538c;

import java.util.List;
import org.apache.log4j.helpers.FileWatchdog;

/* compiled from: BTDeviceSendCommandUtil */
class C4649i implements C0958f {
    final /* synthetic */ C4648h f17044a;

    C4649i(C4648h c4648h) {
        this.f17044a = c4648h;
    }

    public void m22381a(DeviceInfo deviceInfo, int i) {
        C2538c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"device state changed, btState:" + i});
        if (this.f17044a.f17025h == null || deviceInfo == null) {
            C2538c.a("0xA0200008", "01", 1, "BTDeviceSendCommandUtil", new Object[]{"Parameter is incorrect."});
            return;
        }
        C2538c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Device Mac Address = " + this.f17044a.f17003H.m21950d(deviceInfo.getDeviceIdentify())});
        C2538c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Device Protocol = " + deviceInfo.getDeviceProtocol()});
        if (1 == i) {
            Message message = new Message();
            message.what = 2;
            C2538c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Start to create connect timeout info msg."});
            this.f17044a.f17010O.sendMessageDelayed(message, FileWatchdog.DEFAULT_DELAY);
        } else {
            C2538c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Start to remove connect timeout message."});
            this.f17044a.f17010O.removeMessages(2);
        }
        if (2 != i) {
            this.f17044a.f17005J = false;
            if (3 == i) {
                if (!(this.f17044a.f17039v == null || this.f17044a.f17039v.size() == 0)) {
                    C2538c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Start to clear command list for disconnect."});
                    synchronized (C4648h.f16993X) {
                        this.f17044a.f17039v.clear();
                    }
                }
                this.f17044a.f17010O.removeMessages(1);
                this.f17044a.f17012Q = this.f17044a.f17011P;
                if (deviceInfo.getDeviceBTType() == 0 && 1 == this.f17044a.f17026i) {
                    C2538c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Need reset reSendCounter and unLockAW."});
                    this.f17044a.f17018W.execute(new C4650j(this));
                } else {
                    C2538c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Need reset reSendCounter and unlockBT."});
                    this.f17044a.f17018W.execute(new C4651k(this));
                }
            }
            if (2 == this.f17044a.f17026i) {
                C2538c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Reset V2 package info."});
                this.f17044a.f17035r.mo4544a();
            }
            if (this.f17044a.f17022e == 0) {
                this.f17044a.f17016U = false;
                if (this.f17044a.f17024g != null) {
                    this.f17044a.f17024g.f();
                }
            }
            deviceInfo.setDeviceProtocol(this.f17044a.f17026i);
            this.f17044a.f17038u = i;
            this.f17044a.f17025h.a(deviceInfo, i);
        } else if (2 == this.f17044a.f17038u) {
            C2538c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Already finish handshake and repeat report connected."});
        } else if (this.f17044a.f17005J) {
            C2538c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Already Start handshake."});
        } else {
            this.f17044a.f17005J = true;
            if (this.f17044a.f17022e == 0) {
                deviceInfo.setDeviceProtocol(2);
                this.f17044a.f17026i = 2;
                C2538c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Set init AW Device Protocol = " + this.f17044a.f17026i});
            }
            if (2 == this.f17044a.f17026i) {
                C4625b b = C4610m.m21981b(this.f17044a.f17022e);
                C2538c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Start to get link parameter."});
                this.f17044a.m22360a(b);
            } else if (1 != this.f17044a.f17026i) {
                deviceInfo.setProductType(0);
                deviceInfo.setDeviceProtocol(this.f17044a.f17026i);
                this.f17044a.f17038u = i;
                this.f17044a.f17005J = false;
                this.f17044a.f17025h.a(deviceInfo, i);
            } else if (2 == this.f17044a.f17022e) {
                C2538c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Start to get bond status info."});
                deviceInfo.setProductType(5);
                this.f17044a.m22360a(C4610m.m21962a(1));
            } else {
                this.f17044a.f17038u = i;
                deviceInfo.setDeviceProtocol(this.f17044a.f17026i);
                this.f17044a.f17005J = false;
                this.f17044a.f17025h.a(deviceInfo, i);
            }
        }
    }

    public void m22382a(DeviceInfo deviceInfo, int i, byte[] bArr) {
        if (bArr != null && this.f17044a.f17025h != null) {
            if (this.f17044a.f17022e != 0 && this.f17044a.f17035r == null) {
                return;
            }
            String c;
            C4628e c4628e;
            if (2 == this.f17044a.f17026i) {
                if (this.f17044a.f17022e != 0 || 6 != bArr.length || (byte) 1 != bArr[1] || TagName.USER_LOGIN_FAIL_COUNT != bArr[3]) {
                    c = this.f17044a.f17035r.mo4546c(i, bArr);
                    if (c.length() != 0) {
                        byte[] b = C0973a.b(c);
                        List b2 = this.f17044a.f17035r.mo4543b(b.length, b);
                        if (b2 != null) {
                            for (int i2 = 0; i2 < b2.size(); i2++) {
                                c4628e = (C4628e) b2.get(i2);
                                c.a("01", 0, "BTDeviceSendCommandUtil", new Object[]{"slice info = " + c4628e.f16906a + ". success info = " + c4628e.f16909d + ". receivedAll info = " + c4628e.f16910e});
                                if (c4628e.f16906a || !c4628e.f16909d) {
                                    if (this.f17044a.f17036s.f16907b != 0) {
                                        Object obj = new byte[(this.f17044a.f17036s.f16908c.length + c4628e.f16908c.length)];
                                        System.arraycopy(this.f17044a.f17036s.f16908c, 0, obj, 0, this.f17044a.f17036s.f16908c.length);
                                        System.arraycopy(c4628e.f16908c, 0, obj, this.f17044a.f17036s.f16908c.length, c4628e.f16908c.length);
                                        this.f17044a.f17036s.f16908c = obj;
                                    } else {
                                        this.f17044a.f17036s.f16908c = c4628e.f16908c;
                                    }
                                    C4628e p = this.f17044a.f17036s;
                                    p.f16907b += c4628e.f16907b;
                                    this.f17044a.f17036s.f16909d = c4628e.f16909d;
                                    this.f17044a.f17036s.f16910e = c4628e.f16910e;
                                    if (this.f17044a.f17036s.f16910e) {
                                        this.f17044a.m22307b(deviceInfo, this.f17044a.f17036s.f16907b, this.f17044a.f17036s.f16908c);
                                        this.f17044a.f17036s.f16910e = false;
                                        this.f17044a.f17036s.f16907b = 0;
                                        this.f17044a.f17036s.f16908c = null;
                                        this.f17044a.f17036s.f16906a = false;
                                    }
                                } else {
                                    this.f17044a.m22307b(deviceInfo, c4628e.f16907b, c4628e.f16908c);
                                }
                            }
                            return;
                        }
                        return;
                    }
                    c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"BLE package and length less than MTU threshold."});
                } else if (this.f17044a.f17016U) {
                    c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"receive v1 check command but has checked aw version."});
                } else {
                    c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"receive v1 check command and has not checked aw version."});
                    deviceInfo.setProductType(3);
                    deviceInfo.setDeviceName("HUAWEI WATCH");
                    this.f17044a.f17012Q = 0;
                    this.f17044a.m22339q();
                    this.f17044a.f17016U = true;
                    this.f17044a.f17026i = 1;
                    deviceInfo.setDeviceProtocol(1);
                    this.f17044a.f17038u = 2;
                    this.f17044a.f17005J = false;
                    this.f17044a.f17025h.a(deviceInfo, 2);
                }
            } else if (1 == this.f17044a.f17026i) {
                c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Current is V1 Protocol."});
                if (this.f17044a.f17022e == 0) {
                    this.f17044a.m22307b(deviceInfo, bArr.length, bArr);
                    this.f17044a.m22338p();
                    return;
                }
                c = C0973a.a(bArr);
                if (c.contains("AA0100496C")) {
                    Object replace = c.replace("AA0100496C", "");
                    if (!TextUtils.isEmpty(replace)) {
                        c.b("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Receive ACK info and Response at the same time."});
                        bArr = C0973a.b(replace);
                    }
                }
                c = C0973a.a(bArr);
                if (c.equals("AA0100496C") || c.equals("AA01000049") || c.equals("AA0C010000")) {
                    c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Receive ACK info, mIsLastCommandPackage = " + this.f17044a.f17002G});
                    if (this.f17044a.f17002G) {
                        c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"The last CommandPackage, do unLockBT() need wait response in reportReceivedData()"});
                        return;
                    }
                    this.f17044a.m22339q();
                } else if (c.equals("AA0102692E")) {
                    c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"device tell sdk receive a incorrect command."});
                } else if (C0973a.a(bArr).startsWith("cc") || C0973a.a(bArr).startsWith("CC")) {
                    this.f17044a.m22307b(deviceInfo, bArr.length, bArr);
                } else {
                    r0 = this.f17044a.f17035r.mo4543b(bArr.length, bArr);
                    if (r0 == null || r0.size() == 0) {
                        c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Parse response packet fail."});
                        return;
                    }
                    c4628e = (C4628e) r0.get(0);
                    if (c4628e.f16906a) {
                        if (this.f17044a.f17036s.f16907b == 0) {
                            this.f17044a.f17036s.f16908c = c4628e.f16908c;
                        } else if (this.f17044a.f17036s.f16908c == null || c4628e.f16908c == null) {
                            c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"data array is null."});
                        } else {
                            r1 = new byte[(this.f17044a.f17036s.f16908c.length + c4628e.f16908c.length)];
                            System.arraycopy(this.f17044a.f17036s.f16908c, 0, r1, 0, this.f17044a.f17036s.f16908c.length);
                            System.arraycopy(c4628e.f16908c, 0, r1, this.f17044a.f17036s.f16908c.length, c4628e.f16908c.length);
                            this.f17044a.f17036s.f16908c = r1;
                        }
                        r1 = this.f17044a.f17036s;
                        r1.f16907b += c4628e.f16907b;
                        this.f17044a.f17036s.f16909d = c4628e.f16909d;
                        this.f17044a.f17036s.f16910e = c4628e.f16910e;
                        if (this.f17044a.f17024g != null) {
                            this.f17044a.f17024g.a(C0973a.b("AA0101594D"));
                        }
                        if (c4628e.f16910e) {
                            c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Report V1 sliced data."});
                            this.f17044a.m22307b(deviceInfo, this.f17044a.f17036s.f16907b, this.f17044a.f17036s.f16908c);
                            this.f17044a.f17036s.f16910e = false;
                            this.f17044a.f17036s.f16907b = 0;
                            this.f17044a.f17036s.f16908c = null;
                            this.f17044a.f17036s.f16906a = false;
                            return;
                        }
                        return;
                    }
                    if (this.f17044a.f17024g != null) {
                        this.f17044a.f17024g.a(C0973a.b("AA0101594D"));
                    }
                    c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Report V1 not sliced data."});
                    this.f17044a.m22307b(deviceInfo, c4628e.f16907b, c4628e.f16908c);
                }
            } else if (this.f17044a.f17026i == 0) {
                c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Current is V0 Protocol."});
                r0 = this.f17044a.f17035r.mo4543b(i, bArr);
                if (r0 == null || r0.size() == 0) {
                    c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Parse response packet fail."});
                    return;
                }
                c4628e = (C4628e) r0.get(0);
                if (!c4628e.f16906a) {
                    this.f17044a.m22307b(deviceInfo, c4628e.f16907b, c4628e.f16908c);
                } else if (c4628e.f16909d) {
                    if (this.f17044a.f17024g != null) {
                        this.f17044a.f17024g.a(bArr);
                    }
                    if (this.f17044a.f17036s.f16907b != 0) {
                        r1 = new byte[(this.f17044a.f17036s.f16908c.length + c4628e.f16908c.length)];
                        System.arraycopy(this.f17044a.f17036s.f16908c, 0, r1, 0, this.f17044a.f17036s.f16908c.length);
                        System.arraycopy(c4628e.f16908c, 0, r1, this.f17044a.f17036s.f16908c.length, c4628e.f16908c.length);
                        this.f17044a.f17036s.f16908c = r1;
                    } else {
                        this.f17044a.f17036s.f16908c = c4628e.f16908c;
                    }
                    r1 = this.f17044a.f17036s;
                    r1.f16907b += c4628e.f16908c.length;
                    this.f17044a.f17036s.f16909d = c4628e.f16909d;
                    this.f17044a.f17036s.f16910e = c4628e.f16910e;
                    if (c4628e.f16910e) {
                        this.f17044a.m22307b(deviceInfo, this.f17044a.f17036s.f16907b, this.f17044a.f17036s.f16908c);
                        this.f17044a.f17036s.f16910e = false;
                        this.f17044a.f17036s.f16907b = 0;
                        this.f17044a.f17036s.f16908c = null;
                        this.f17044a.f17036s.f16906a = false;
                    }
                } else {
                    c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Receive incorrect data from device."});
                }
            } else {
                c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Do not support this link protocol."});
            }
        }
    }
}
