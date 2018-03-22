package com.huawei.pluginkidwatch.plugin.p152a;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.lib.p146a.C1464a;
import com.huawei.pluginkidwatch.common.lib.utils.C1489i;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1620b;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1685c;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1686d;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p157a.C1681a;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: KWBtDevice */
public final class C1723d {
    private Runnable f4636A = new C1736q(this);
    private Runnable f4637B = new C1737r(this);
    private Runnable f4638C = new C1742w(this);
    C1686d f4639a = new C1724e(this);
    C1685c f4640b = new C1732m(this);
    private final Context f4641c;
    private BluetoothDevice f4642d;
    private String f4643e;
    private int f4644f;
    private long f4645g = 0;
    private String f4646h;
    private int f4647i = 0;
    private int f4648j = 9;
    private boolean f4649k = false;
    private int f4650l = 11;
    private C1681a f4651m = null;
    private C1743x f4652n;
    private List<C1647c> f4653o;
    private int f4654p = 10;
    private String f4655q = null;
    private byte[] f4656r = null;
    private String f4657s = null;
    private boolean f4658t = false;
    private int f4659u = 0;
    private int f4660v = 0;
    private boolean f4661w = false;
    private boolean f4662x = false;
    private int f4663y = 0;
    private Handler f4664z = new Handler();

    static /* synthetic */ int m8267o(C1723d c1723d) {
        int i = c1723d.f4660v + 1;
        c1723d.f4660v = i;
        return i;
    }

    public C1723d(Context context, String str) {
        this.f4641c = context;
        this.f4642d = null;
        this.f4646h = str.toUpperCase();
        this.f4651m = C1681a.m7837a(context);
        if (this.f4651m != null) {
            this.f4651m.m7842a(5);
        }
        this.f4652n = C1743x.m8322a(context);
        this.f4653o = new ArrayList();
        this.f4659u = 0;
        this.f4660v = 0;
        this.f4649k = false;
        this.f4662x = false;
        C2538c.m12674b("KWBtDevice", "Device macAddr: " + str);
    }

    public void m8285a(String str) {
        this.f4657s = "0000000000" + str;
        C2538c.m12674b("KWBtDevice", "Device deviceEncryKey: " + this.f4657s);
    }

    public String m8281a() {
        return this.f4646h;
    }

    public void m8290b(String str) {
        if (this.f4643e == null) {
            this.f4643e = str;
        } else if (!this.f4643e.equals(str)) {
            if (!TextUtils.isEmpty(str)) {
                this.f4643e = str;
            } else if (this.f4642d != null) {
                this.f4643e = this.f4642d.getAddress();
            }
        }
    }

    public void m8284a(C1647c c1647c) {
        C2538c.m12674b("KWBtDevice", "callback = " + c1647c);
        C2538c.m12674b("KWBtDevice", "listBtChangeStateCallback.contains(callback) = " + this.f4653o.contains(c1647c));
        if (!this.f4653o.contains(c1647c)) {
            this.f4653o.add(c1647c);
        }
    }

    public void m8287b() {
        this.f4653o.clear();
    }

    public void m8289b(C1647c c1647c) {
        C2538c.m12674b("KWBtDevice", "removeBleStateChangeCallBack callback = " + c1647c + "listBtChangeStateCallback.contains(callback) = " + this.f4653o.contains(c1647c));
        if (this.f4653o.contains(c1647c)) {
            this.f4653o.remove(c1647c);
        }
    }

    public void m8282a(int i) {
        this.f4650l = i;
    }

    public int m8291c() {
        return this.f4650l;
    }

    private String m8264m() {
        return m8255g(16);
    }

    private String m8255g(int i) {
        SecureRandom secureRandom = new SecureRandom();
        char[] toCharArray = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < cArr.length; i2++) {
            cArr[i2] = toCharArray[secureRandom.nextInt(36)];
        }
        return new String(cArr);
    }

    private void m8265n() {
        m8268o();
        C2538c.m12674b("KWBtDevice", "startSearchDeviceTimeoutException ++++++++++++++1");
        if (this.f4664z != null && this.f4636A != null) {
            this.f4664z.postDelayed(this.f4636A, 20000);
        }
    }

    private void m8268o() {
        C2538c.m12674b("KWBtDevice", "cancelSearchDeviceTimeoutException ------------1");
        if (this.f4664z != null && this.f4636A != null) {
            this.f4664z.removeCallbacks(this.f4636A);
        }
    }

    private void m8269p() {
        C2538c.m12674b("KWBtDevice", "startConnectDeviceTimeoutException ++++++++++++++++2");
        if (this.f4664z != null && this.f4637B != null) {
            this.f4664z.postDelayed(this.f4637B, 35000);
        }
    }

    private void m8271q() {
        C2538c.m12674b("KWBtDevice", "startConnectDeviceTimeoutException ---------------2");
        if (this.f4664z != null && this.f4637B != null) {
            this.f4664z.removeCallbacks(this.f4637B);
        }
    }

    private void m8273r() {
        if (this.f4651m != null) {
            this.f4651m.m7845a(5, this.f4640b);
        }
    }

    private void m8276s() {
        if (this.f4651m != null) {
            this.f4651m.m7850b(5, this.f4640b);
        }
    }

    public void m8294d() {
        C2538c.m12674b("KWBtDevice", "searchBluetoothDevice current Device macAddr: " + this.f4646h + "  trySearchNum = " + this.f4660v);
        if (this.f4651m != null) {
            m8296e();
            m8280w();
            this.f4663y = 4;
            m8258h(4);
            m8265n();
            if (this.f4664z != null) {
                this.f4664z.postDelayed(new C1738s(this), 1000);
            } else {
                m8258h(0);
            }
        }
    }

    public void m8296e() {
        if (this.f4651m != null) {
            this.f4658t = false;
            this.f4651m.m7841a();
        }
    }

    public void m8298f() {
        m8294d();
    }

    private void m8238a(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice != null) {
            this.f4642d = bluetoothDevice;
            m8280w();
            this.f4649k = false;
            C2538c.m12674b("KWBtDevice", "cwbtDevice connecting current kidwatch macAddr = " + this.f4646h);
            m8273r();
            if (this.f4651m != null) {
                this.f4659u++;
                this.f4651m.m7843a(5, bluetoothDevice);
            }
        }
    }

    public void m8293c(C1647c c1647c) {
        C2538c.m12674b("KWBtDevice", "public connect 2");
        if (!this.f4653o.contains(c1647c)) {
            this.f4653o.add(c1647c);
        }
        this.f4659u = 0;
        this.f4660v = 0;
        this.f4649k = false;
        m8298f();
    }

    public void m8300g() {
        m8277t();
    }

    private void m8277t() {
        String m = m8264m();
        this.f4655q = m;
        C2538c.m12674b("KWBtDevice", "writeRandomOnCharacteristic srcAuthRandom = " + this.f4655q);
        try {
            this.f4651m.m7846a(1, m.getBytes(GameManager.DEFAULT_CHARSET), new C1739t(this));
        } catch (UnsupportedEncodingException e) {
            C2538c.m12674b("KWBtDevice", "UnsupportedEncodingException e" + e.getMessage());
        }
    }

    private void m8241a(byte[] bArr) {
        this.f4656r = bArr;
        C2538c.m12674b("KWBtDevice", "Enter authenticationSuccessProcess !");
        if (this.f4664z == null) {
            C2538c.m12674b("KWBtDevice", "authenticationSuccessProcess null == handler return !");
            return;
        }
        this.f4664z.postDelayed(new C1740u(this), 800);
    }

    private void m8240a(String str, Exception exception) {
        if (exception != null) {
            C2538c.m12674b("KWBtDevice", str + exception.getMessage());
        } else {
            C2538c.m12674b("KWBtDevice", str);
        }
        if (this.f4651m != null) {
            this.f4651m.m7849b(5);
        }
        m8279v();
    }

    private void m8278u() {
        try {
            C2538c.m12674b("KWBtDevice", "writeEncryRandomOnCharacteristic.. byteDeviceAuthRandom !");
            byte[] a = C1464a.m6767a(this.f4656r, this.f4656r.length, this.f4657s.getBytes(GameManager.DEFAULT_CHARSET), this.f4657s.getBytes(GameManager.DEFAULT_CHARSET).length);
            if (a == null) {
                m8240a("writeEncryRandomOnCharacteristic AES128_ECB.encode encryRandByte:  null", null);
                return;
            }
            C2538c.m12674b("KWBtDevice", "writeEncryRandomOnCharacteristic AES128_ECB.encrypt finish !!!");
            this.f4651m.m7846a(2, a, new C1741v(this));
        } catch (Exception e) {
            m8240a("writeEncryRandomOnCharacteristic Exception e message:  ", e);
        } catch (Exception e2) {
            m8240a("writeEncryRandomOnCharacteristic Exception e message:  ", e2);
        } catch (Exception e22) {
            m8240a("writeEncryRandomOnCharacteristic Exception e message:  ", e22);
        } catch (Exception e222) {
            m8240a("writeEncryRandomOnCharacteristic Exception e message:  ", e222);
        } catch (Exception e2222) {
            m8240a("writeEncryRandomOnCharacteristic Exception e message:  ", e2222);
        } catch (Exception e22222) {
            m8240a("writeEncryRandomOnCharacteristic AES128_ECB.decode Exception e message = ", e22222);
        }
    }

    private void m8248b(byte[] bArr) {
        String str = "";
        try {
            byte[] b = C1464a.m6769b(bArr, bArr.length, this.f4657s.getBytes(GameManager.DEFAULT_CHARSET), this.f4657s.getBytes(GameManager.DEFAULT_CHARSET).length);
            if (b != null) {
                str = new String(b, GameManager.DEFAULT_CHARSET);
            }
            C2538c.m12674b("KWBtDevice", "writeEncryRandomOnCharacteristic srcEncryRandomstr = " + str + "  srcAuthRandom = " + this.f4655q);
            if (str.equals(this.f4655q)) {
                C2538c.m12674b("KWBtDevice", "writeEncryRandomOnCharacteristic sucess  ConnectionState.DEVICE_CONNECTED #########");
                this.f4662x = false;
                m8258h(2);
                return;
            }
            m8240a("writeEncryRandomOnCharacteristic equals failed!!!!!!!!!", null);
        } catch (Exception e) {
            m8240a("writeEncryRandomOnCharacteristic AES128_ECB.decode Exception e message = ", e);
        } catch (Exception e2) {
            m8240a("writeEncryRandomOnCharacteristic AES128_ECB.decode Exception e message = ", e2);
        } catch (Exception e22) {
            m8240a("writeEncryRandomOnCharacteristic AES128_ECB.decode Exception e message = ", e22);
        } catch (Exception e222) {
            m8240a("writeEncryRandomOnCharacteristic AES128_ECB.decode Exception e message = ", e222);
        } catch (Exception e2222) {
            m8240a("writeEncryRandomOnCharacteristic AES128_ECB.decode Exception e message = ", e2222);
        } catch (Exception e22222) {
            m8240a("writeEncryRandomOnCharacteristic AES128_ECB.decode Exception e message = ", e22222);
        }
    }

    private void m8279v() {
        this.f4662x = true;
        if (this.f4664z != null && this.f4638C != null) {
            this.f4664z.postDelayed(this.f4638C, 45000);
        }
    }

    private void m8280w() {
        this.f4662x = false;
        if (this.f4664z != null && this.f4638C != null) {
            this.f4664z.removeCallbacks(this.f4638C);
        }
    }

    private void m8258h(int i) {
        m8288b(i);
        C2538c.m12674b("KWBtDevice", "updateKidDeviceBtStatus getImmediateRefreshState() = " + m8291c() + "updateKidDeviceBtStatus antilossState = " + m8303j() + "updateKidDeviceBtStatus status = " + i);
        if (2 == i) {
            m8283a(1, new C1726g(this));
        } else {
            for (int i2 = 0; i2 < this.f4653o.size(); i2++) {
                C2538c.m12674b("KWBtDevice", "updateKidDeviceBtStatus callback = " + this.f4653o.get(i2));
                ((C1647c) this.f4653o.get(i2)).mo2560a(i);
            }
        }
        if (10 == m8291c()) {
            if (2 == i) {
                m8304k();
            } else if (!(1 == i || 4 == i)) {
                m8282a(11);
            }
        }
        if (i == 0 || 3 == i) {
            m8276s();
        }
    }

    public void m8301h() {
        this.f4661w = false;
        this.f4649k = true;
        this.f4647i = 0;
        this.f4648j = 9;
        m8296e();
        if (this.f4651m != null) {
            this.f4651m.m7849b(5);
        }
    }

    public void m8288b(int i) {
        this.f4647i = ((Integer) C1489i.m6887a(Integer.valueOf(i))).intValue();
    }

    public int m8302i() {
        return ((Integer) C1489i.m6887a(Integer.valueOf(this.f4647i))).intValue();
    }

    public void m8292c(int i) {
        this.f4648j = ((Integer) C1489i.m6887a(Integer.valueOf(i))).intValue();
    }

    public int m8303j() {
        return ((Integer) C1489i.m6887a(Integer.valueOf(this.f4648j))).intValue();
    }

    public void m8295d(int i) {
        C2538c.m12674b("KWBtDevice", "turnOnLostAlert alertType = " + i);
        if (this.f4651m != null && this.f4664z != null) {
            this.f4664z.postDelayed(new C1727h(this, i), 800);
        }
    }

    public void m8297e(int i) {
        int i2 = 2;
        if (7 == i) {
            this.f4648j = 7;
            i2 = 1;
        } else if (8 == i) {
            this.f4648j = 8;
        }
        C2538c.m12674b("KWBtDevice", "setRangeOutOrIn... rangeValue = " + i + "alertType = " + i2 + "antilossState = " + this.f4648j);
        m8295d(i2);
    }

    public void m8304k() {
        C2538c.m12674b("KWBtDevice", "notificationKidWatchImmediateRefresh getImmediateRefreshState() = " + m8291c());
        C2538c.m12674b("KWBtDevice", "notificationKidWatchImmediateRefresh antilossState = " + m8303j());
        m8295d(3);
        if (10 == m8291c() && 9 != m8303j()) {
            m8282a(11);
            C2538c.m12674b("KWBtDevice", "notificationKidWatchImmediateRefresh getImmediateRefreshState() = " + m8291c());
        }
    }

    public void m8299f(int i) {
        C2538c.m12674b("KWBtDevice", "setDeviceLinkLoss... linkLossType = " + i);
        if (this.f4651m != null && this.f4664z != null) {
            this.f4664z.postDelayed(new C1729j(this, i), 800);
        }
    }

    public void m8283a(int i, C1620b c1620b) {
        C2538c.m12674b("KWBtDevice", "=====setDeviceLinkLoss... linkLossType = " + i);
        if (this.f4651m == null || this.f4664z == null) {
            C2538c.m12674b("KWBtDevice", "=====hwBluetoothApi is null");
            c1620b.mo2554a(-1, "=====hwBluetoothApi is null");
            return;
        }
        this.f4664z.postDelayed(new C1731l(this, i, c1620b), 800);
    }

    public void m8286a(boolean z) {
        this.f4661w = ((Boolean) C1489i.m6887a(Boolean.valueOf(z))).booleanValue();
    }

    public boolean m8305l() {
        return ((Boolean) C1489i.m6887a(Boolean.valueOf(this.f4661w))).booleanValue();
    }

    public String toString() {
        return "KWBtDevice{context=" + this.f4641c + ", device=" + this.f4642d + ", strName='" + this.f4643e + '\'' + ", intRssi=" + this.f4644f + ", strMacAddress='" + this.f4646h + '\'' + ", connectedState=" + this.f4647i + ", antilossState=" + this.f4648j + ", immediateRefreshState=" + this.f4650l + ", hwBluetoothApi=" + this.f4651m + ", kidWatchManager=" + this.f4652n + ", listBtChangeStateCallback=" + this.f4653o + ", intAntilossDistance=" + this.f4654p + ", srcAuthRandom='" + this.f4655q + '\'' + ", byteDeviceAuthRandom=" + Arrays.toString(this.f4656r) + ", deviceEncryKey='" + this.f4657s + '\'' + ", deviceSearchState=" + this.f4658t + ", handler=" + this.f4664z + ", deviceDiscoveryCallback=" + this.f4639a + ", connectStatusCallBack=" + this.f4640b + '}';
    }
}
