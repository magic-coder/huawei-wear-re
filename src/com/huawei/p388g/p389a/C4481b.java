package com.huawei.p388g.p389a;

import android.os.Handler;
import android.text.TextUtils;
import com.huawei.datatype.DataDeviceInfo;
import com.huawei.datatype.PayAPDUInfo;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceCapability;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.j.a;
import com.huawei.n.c;
import com.huawei.nfc.PluginPayAdapter;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.p190v.C2538c;
import com.huawei.p390z.C4480d;
import com.huawei.p390z.C6184a;
import com.huawei.p481p.C5719a;
import com.huawei.p481p.p482a.C5718a;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import com.snowballtech.business.constant.RequestKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: PluginPayAdapterImpl */
public class C4481b implements PluginPayAdapter, C4480d {
    private static final Object f16610A = new Object();
    private static final Object f16611B = new Object();
    private static final Object f16612C = new Object();
    private static final Object f16613D = new Object();
    private static final Object f16614E = new Object();
    private static final Object f16615F = new Object();
    private static final Object f16616G = new Object();
    private static final Object f16617H = new Object();
    private static final Object f16618I = new Object();
    private static final Object f16619J = new Object();
    private static final byte[] f16620N = new byte[0];
    private static C4481b f16621b;
    private static C6184a f16622c;
    private static c f16623d;
    private static a f16624e;
    private static int f16625f = 0;
    private static final Object f16626w = new Object();
    private static final Object f16627x = new Object();
    private static final Object f16628y = new Object();
    private static final Object f16629z = new Object();
    private C5719a f16630K;
    private final Object f16631L = new Object();
    private final Object f16632M = new Object();
    private Handler f16633O = new Handler();
    private boolean f16634P = false;
    private Runnable f16635Q = new C4493n(this);
    private IBaseResponseCallback f16636R = new C4495p(this);
    int f16637a = 2;
    private Map<Integer, Object> f16638g = new HashMap();
    private boolean f16639h;
    private boolean f16640i;
    private boolean f16641j;
    private boolean f16642k;
    private boolean f16643l;
    private boolean f16644m;
    private int f16645n = -1;
    private List<String> f16646o;
    private int f16647p = -1;
    private String f16648q;
    private String f16649r;
    private String f16650s;
    private String f16651t;
    private Map<String, String> f16652u = new HashMap();
    private DataDeviceInfo f16653v;

    private C4481b() {
        C2538c.b("PluginPayAdapterImpl", new Object[]{"PluginPayAdapterImpl init"});
        f16622c = C6184a.m28626a();
        f16622c.m28642a((C4480d) this);
        f16623d = c.a(BaseApplication.b());
        this.f16630K = C5719a.m26363a();
        f16624e = a.a();
    }

    public static C4481b m21479a() {
        C4481b c4481b;
        synchronized (f16620N) {
            if (f16621b == null) {
                f16621b = new C4481b();
            }
            C2538c.b("PluginPayAdapterImpl", new Object[]{"PluginPayAdapterImpl getInstance : " + f16621b});
            c4481b = f16621b;
        }
        return c4481b;
    }

    private int m21522r() {
        if (f16625f == Integer.MAX_VALUE) {
            f16625f = 1;
        }
        int i = f16625f;
        f16625f = i + 1;
        return i;
    }

    public byte[] openChannelSNB(byte[] bArr, int i) {
        C2538c.b("PluginPayAdapterImpl", new Object[]{"openChannelSNB,instance_id=" + C0973a.a(bArr)});
        C2538c.b("PluginPayAdapterImpl", new Object[]{"openChannelSNB,channelType=" + i});
        Map openChannel = openChannel(C0973a.a(bArr), i);
        if (openChannel == null) {
            return null;
        }
        C2538c.b("PluginPayAdapterImpl", new Object[]{"openChannelSNB,rApdu=" + ((String) openChannel.get("apdu"))});
        return C0973a.b((String) openChannel.get("apdu"));
    }

    public byte[] transmitSNB(byte[] bArr) {
        C2538c.b("PluginPayAdapterImpl", new Object[]{"transmitSNB,apdu=" + C0973a.a(bArr)});
        return C0973a.b(sendApdu("00", C0973a.a(bArr)));
    }

    public void closeChannelSNB() {
        synchronized (this.f16632M) {
            C2538c.b("PluginPayAdapterImpl", new Object[]{"closeChannelSNB"});
            closeChannel();
        }
    }

    public String getCplc() {
        C2538c.b("PluginPayAdapterImpl", new Object[]{"PluginPayAdapterImpl getCplc enter"});
        if (!TextUtils.isEmpty(this.f16648q)) {
            C2538c.b("PluginPayAdapterImpl", new Object[]{"cplc is not null,return cplc = " + this.f16648q});
            return this.f16648q;
        } else if (f16622c == null || !m21523s()) {
            C2538c.b("PluginPayAdapterImpl", new Object[]{"PluginPayAdapterImpl getCplc payManager is null"});
            return this.f16648q;
        } else {
            f16622c.m28647b(new C4482c(this));
            if (TextUtils.isEmpty(this.f16648q)) {
                m21491b(RequestKey.KEY_GET_CPLC, f16618I);
            }
            C2538c.e("PluginPayAdapterImpl", new Object[]{"PluginPayAdapterImpl getCplc return,cplc = " + this.f16648q});
            return this.f16648q;
        }
    }

    public Map<String, String> getDeviceInfo() {
        Map<String, String> hashMap = new HashMap();
        if (f16623d == null || !m21523s()) {
            C2538c.b("PluginPayAdapterImpl", new Object[]{"PluginPayAdapterImpl getDeviceInfo deviceManager is null"});
        } else {
            f16623d.a(new C4492m(this, hashMap));
            if (this.f16653v == null) {
                m21491b("getDeviceInfo", f16613D);
            } else {
                hashMap.put(PluginPayAdapter.KEY_DEVICE_INFO_SN, this.f16653v.getDevice_sn());
                hashMap.put(PluginPayAdapter.KEY_DEVICE_INFO_MODEL, this.f16653v.getDevice_model());
                hashMap.put(PluginPayAdapter.KEY_DEVICE_INFO_SOFT_VERSION, this.f16653v.getDevice_soft_version());
                hashMap.put(PluginPayAdapter.KEY_DEVICE_INFO_BT_VERSION, this.f16653v.getBT_version());
            }
        }
        return hashMap;
    }

    public String sendApdu(String str, String str2) {
        C2538c.b("PluginPayAdapterImpl", new Object[]{" enter sendApdu channelid :" + str + " ,reqApdu : " + str2});
        this.f16650s = null;
        if (str2 == null) {
            return null;
        }
        if (f16622c == null || !m21523s()) {
            C2538c.b("PluginPayAdapterImpl", new Object[]{"PluginPayAdapterImpl sendApdu payManager is null,return null,isConnected" + m21523s()});
            return null;
        }
        Integer valueOf = Integer.valueOf(m21522r());
        this.f16638g.put(valueOf, new Object());
        PayAPDUInfo payAPDUInfo = new PayAPDUInfo();
        payAPDUInfo.setApdu(str2);
        payAPDUInfo.setReqid(valueOf.intValue());
        payAPDUInfo.setChannelID(Integer.parseInt(str));
        f16622c.m28640a(payAPDUInfo, this.f16636R);
        C2538c.b("PluginPayAdapterImpl", new Object[]{"lock,reqID=" + valueOf + ",lockObject=" + this.f16638g.get(valueOf) + ",map.size=" + this.f16638g.size()});
        if (this.f16634P) {
            this.f16633O.removeCallbacks(this.f16635Q);
            this.f16633O.postDelayed(this.f16635Q, 15000);
        }
        m21491b("sendApdu", this.f16638g.get(valueOf));
        return this.f16650s;
    }

    public Map<String, String> openChannel(String str, int i) {
        Map<String, String> map;
        synchronized (this.f16631L) {
            this.f16652u = new HashMap();
            C2538c.b("PluginPayAdapterImpl", new Object[]{"openChannel=" + i});
            if (f16622c == null || !m21523s()) {
                C2538c.b("PluginPayAdapterImpl", new Object[]{"PluginPayAdapterImpl openChannel payManager is null"});
                map = this.f16652u;
            } else {
                f16622c.m28643a(str, i, new C4496q(this));
                m21491b("openChannel", f16611B);
                map = this.f16652u;
            }
        }
        return map;
    }

    public void closeChannel() {
        synchronized (this.f16632M) {
            C2538c.b("PluginPayAdapterImpl", new Object[]{"closeChannel enter"});
            if (f16622c == null || !m21523s()) {
                C2538c.b("PluginPayAdapterImpl", new Object[]{"PluginPayAdapterImpl closeChannel payManager is null"});
                return;
            }
            f16622c.m28641a(new C4497r(this));
        }
    }

    private void m21484a(String str, Object obj) {
        if (obj != null) {
            synchronized (obj) {
                obj.notifyAll();
                C2538c.b("PluginPayAdapterImpl", new Object[]{"method: " + str + " , unlock= " + obj});
            }
        }
    }

    private void m21491b(String str, Object obj) {
        m21485a(str, obj, 40000);
    }

    private void m21485a(String str, Object obj, long j) {
        synchronized (obj) {
            try {
                C2538c.b("PluginPayAdapterImpl", new Object[]{"method: " + str + " , lock= " + obj});
                obj.wait(j);
            } catch (InterruptedException e) {
                C2538c.e("PluginPayAdapterImpl", new Object[]{"InterruptedException,e=" + e.getMessage()});
            }
        }
    }

    public String getBTCInfoResponse() {
        this.f16649r = "";
        if (f16622c == null || !m21523s()) {
            C2538c.b("PluginPayAdapterImpl", new Object[]{"PluginPayAdapterImpl getBTCInfoResponse payManager is null"});
            return this.f16649r;
        }
        f16622c.m28650c(new C4498s(this));
        if ("".equals(this.f16649r)) {
            m21491b("getBTCInfoResponse", f16612C);
        }
        C2538c.c("PluginPayAdapterImpl", new Object[]{"getBTCInfoResponse,btcInfo= " + this.f16649r});
        return this.f16649r;
    }

    public int getDeviceConnectState() {
        int deviceConnectState;
        if (f16623d != null) {
            DeviceInfo c = f16623d.c();
            if (c != null) {
                deviceConnectState = c.getDeviceConnectState();
            } else {
                C2538c.e("PluginPayAdapterImpl", new Object[]{"getDeviceConnectState error,deviceInfo is null!"});
                deviceConnectState = 0;
            }
        } else {
            C2538c.e("PluginPayAdapterImpl", new Object[]{"getDeviceConnectState error,HWDeviceConfigManager is null!"});
            deviceConnectState = 0;
        }
        C2538c.c("PluginPayAdapterImpl", new Object[]{"getDeviceConnectState,state= " + deviceConnectState});
        return deviceConnectState;
    }

    private boolean m21523s() {
        return 2 == this.f16637a;
    }

    public boolean addBusCard(String str, String str2, String str3) {
        C2538c.b("PluginPayAdapterImpl", new Object[]{"addBusCard enter"});
        if (f16622c == null || !m21523s()) {
            C2538c.b("PluginPayAdapterImpl", new Object[]{"PluginPayAdapterImpl addBusCard payManager is null"});
            return false;
        }
        f16622c.m28645a(str, str2, str3, new C4499t(this));
        m21491b("addBusCard", f16626w);
        return this.f16643l;
    }

    public String getUserID() {
        com.huawei.login.ui.login.a a = com.huawei.login.ui.login.a.a(BaseApplication.b());
        if (a == null) {
            return "";
        }
        return a.c();
    }

    public boolean notifyAfterTransferFile(List<Map<String, Object>> list) {
        C2538c.b("PluginPayAdapterImpl", new Object[]{"notifyAfterTransferFile enter"});
        C2538c.b("PluginPayAdapterImpl", new Object[]{" == PluginPayAdapterImpl notifyAfterTransferFile instance : " + f16621b});
        if (f16622c == null || !m21523s()) {
            C2538c.b("PluginPayAdapterImpl", new Object[]{"PluginPayAdapterImpl notifyAfterTransferFile payManager is null"});
            return false;
        }
        List arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            C5718a c5718a = new C5718a();
            String str = (String) ((Map) list.get(i)).get("FILE_NAME");
            int intValue = ((Integer) ((Map) list.get(i)).get("FILE_TYPE")).intValue();
            if (StringUtil.isEmpty(str, true)) {
                return false;
            }
            c5718a.m26361a(str);
            c5718a.m26360a(intValue);
            arrayList.add(c5718a);
        }
        f16622c.m28646a(arrayList, new C4500u(this));
        m21491b("notifyAfterTransferFile", f16627x);
        String str2 = "PluginPayAdapterImpl";
        Object[] objArr = new Object[1];
        objArr[0] = "notifyAfterTransferFile end , result is " + (this.f16639h ? LightCloudConstants.RESPONSE_RESULT_SUCCESS : "failed");
        C2538c.b(str2, objArr);
        return this.f16639h;
    }

    public boolean addCard2Watch(String str) {
        C2538c.b("PluginPayAdapterImpl", new Object[]{"addCard2Watch enter"});
        if (f16622c == null || !m21523s()) {
            C2538c.b("PluginPayAdapterImpl", new Object[]{"PluginPayAdapterImpl addCard2Watch payManager is null"});
            return false;
        }
        f16622c.m28644a(str, new C4483d(this));
        m21491b("addCard2Watch", f16628y);
        String str2 = "PluginPayAdapterImpl";
        Object[] objArr = new Object[1];
        objArr[0] = "addCard2Watch end , result is " + (this.f16640i ? LightCloudConstants.RESPONSE_RESULT_SUCCESS : "failed");
        C2538c.b(str2, objArr);
        return this.f16640i;
    }

    public boolean updateCardInfo(String str) {
        C2538c.b("PluginPayAdapterImpl", new Object[]{"updateCardInfo enter"});
        this.f16641j = false;
        if (f16622c == null || !m21523s()) {
            C2538c.b("PluginPayAdapterImpl", new Object[]{"PluginPayAdapterImpl updateCardInfo payManager is null"});
            return false;
        }
        f16622c.m28649b(str, new C4484e(this));
        m21485a("updateCardInfo", f16629z, 6000);
        String str2 = "PluginPayAdapterImpl";
        Object[] objArr = new Object[1];
        objArr[0] = "updateCardInfo end , result is " + (this.f16641j ? LightCloudConstants.RESPONSE_RESULT_SUCCESS : "failed");
        C2538c.b(str2, objArr);
        return this.f16641j;
    }

    public List<String> obtainCardList() {
        C2538c.b("PluginPayAdapterImpl", new Object[]{"obtainCardList enter"});
        if (f16622c == null || !m21523s()) {
            C2538c.b("PluginPayAdapterImpl", new Object[]{"PluginPayAdapterImpl obtainCardList payManager is null"});
            return null;
        }
        f16622c.m28652d(new C4485f(this));
        m21491b("obtainCardList", f16610A);
        if (this.f16646o == null || this.f16646o.size() == 0) {
            this.f16646o = new ArrayList();
        }
        C2538c.b("PluginPayAdapterImpl", new Object[]{"obtainCardList end , result cardlist' size is " + this.f16646o.size()});
        return this.f16646o;
    }

    public boolean deleteCard(String str) {
        C2538c.b("PluginPayAdapterImpl", new Object[]{"deleteCard enter"});
        if (f16622c == null || !m21523s()) {
            C2538c.b("PluginPayAdapterImpl", new Object[]{"PluginPayAdapterImpl deleteCard payManager is null"});
            return false;
        }
        f16622c.m28651c(str, new C4486g(this));
        m21491b("deleteCard", f16614E);
        String str2 = "PluginPayAdapterImpl";
        Object[] objArr = new Object[1];
        objArr[0] = "deleteCard end , result is " + (this.f16642k ? LightCloudConstants.RESPONSE_RESULT_SUCCESS : "failed");
        C2538c.b(str2, objArr);
        return this.f16642k;
    }

    public String getWalletAbility() {
        C2538c.b("PluginPayAdapterImpl", new Object[]{"getWalletAbility enter"});
        if (f16622c == null || !m21523s()) {
            C2538c.b("PluginPayAdapterImpl", new Object[]{"PluginPayAdapterImpl getWalletAbility payManager is null"});
            return "";
        } else if (TextUtils.isEmpty(this.f16651t)) {
            f16622c.m28653e(new C4487h(this));
            m21491b("getWalletAbility", f16615F);
            C2538c.b("PluginPayAdapterImpl", new Object[]{"getWalletAbility end,result is " + this.f16651t});
            return this.f16651t;
        } else {
            C2538c.b("PluginPayAdapterImpl", new Object[]{"mWalletSupportCapacity is not null,return mWalletSupportCapacity = " + this.f16651t});
            return this.f16651t;
        }
    }

    public int getLockscreenStatus() {
        C2538c.b("PluginPayAdapterImpl", new Object[]{"getLockscreenStatus enter"});
        if (f16623d == null) {
            C2538c.b("PluginPayAdapterImpl", new Object[]{"PluginPayAdapterImpl getLockscreenStatus deviceManager is null"});
            return this.f16647p;
        }
        f16623d.g(new C4488i(this));
        m21491b("getLockscreenStatus", f16616G);
        C2538c.b("PluginPayAdapterImpl", new Object[]{"getLockscreenStatus end,result is " + this.f16647p});
        return this.f16647p;
    }

    public void sendFile(String str) {
        C2538c.b("PluginPayAdapterImpl", new Object[]{"sendFile enter"});
        if (this.f16630K == null) {
            C2538c.b("PluginPayAdapterImpl", new Object[]{"PluginPayAdapterImpl sendFile fileManager is null"});
            return;
        }
        this.f16630K.m26365a(str);
    }

    public boolean notificationOpenPageOfBand(String str) {
        C2538c.b("PluginPayAdapterImpl", new Object[]{"notificationOpenPageOfBand enter"});
        if (f16623d == null) {
            C2538c.b("PluginPayAdapterImpl", new Object[]{"PluginPayAdapterImpl notificationOpenPageOfBand deviceManager is null"});
            return this.f16644m;
        }
        f16623d.a(str, new C4489j(this));
        m21491b("notificationOpenPageOfBand", f16617H);
        C2538c.b("PluginPayAdapterImpl", new Object[]{"notificationOpenPageOfBand end,result is " + this.f16644m});
        return this.f16644m;
    }

    public int sendAccount(String str) {
        C2538c.b("PluginPayAdapterImpl", new Object[]{"sendAccount enter"});
        DeviceCapability a = C0973a.a.a();
        C2538c.c("PluginPayAdapterImpl", new Object[]{"sendAccount ability : " + a});
        if (a == null) {
            C2538c.c("PluginPayAdapterImpl", new Object[]{"ability is null , Do not sendAccount "});
            return -2;
        } else if (!a.isSupportAccount()) {
            C2538c.c("PluginPayAdapterImpl", new Object[]{" bot SupportAccount , Do not sendAccount "});
            return -2;
        } else if (f16624e == null) {
            C2538c.b("PluginPayAdapterImpl", new Object[]{"PluginPayAdapterImpl sendAccount hwWearableManager is null"});
            return this.f16645n;
        } else {
            f16624e.a(str, new C4490k(this));
            m21491b("sendAccount", f16619J);
            C2538c.b("PluginPayAdapterImpl", new Object[]{"sendAccount end,result is " + this.f16645n});
            return this.f16645n;
        }
    }

    public void cardEvent(String str, int i) {
        C2538c.b("PluginPayAdapterImpl", new Object[]{"cardEvent enter"});
        if (f16622c == null || !m21523s()) {
            C2538c.b("PluginPayAdapterImpl", new Object[]{"PluginPayAdapterImpl cardEvent payManager is null"});
            return;
        }
        f16622c.m28648b(str, i, new C4491l(this));
    }

    public static void m21490b() {
        C2538c.b("PluginPayAdapterImpl", new Object[]{"destroy "});
        f16625f = 0;
        f16622c = null;
        f16623d = null;
        f16624e = null;
        f16621b = null;
    }

    public int getDeviceProtocol() {
        int i = -1;
        if (f16623d != null) {
            DeviceInfo c = f16623d.c();
            if (c != null) {
                i = c.getProductType();
            } else {
                C2538c.e("PluginPayAdapterImpl", new Object[]{"getDeviceProtocol error,deviceInfo is null!"});
            }
        } else {
            C2538c.e("PluginPayAdapterImpl", new Object[]{"getDeviceProtocol error,HWDeviceConfigManager is null!"});
        }
        C2538c.c("PluginPayAdapterImpl", new Object[]{"getDeviceProtocol,deviceType= " + i});
        return i;
    }

    public int getDeviceBTType() {
        int i = -1;
        if (f16623d != null) {
            DeviceInfo c = f16623d.c();
            if (c != null) {
                i = c.getDeviceBTType();
            } else {
                C2538c.e("PluginPayAdapterImpl", new Object[]{"getDeviceBTType error,deviceInfo is null!"});
            }
        } else {
            C2538c.e("PluginPayAdapterImpl", new Object[]{"getDeviceBTType error,HWDeviceConfigManager is null!"});
        }
        C2538c.c("PluginPayAdapterImpl", new Object[]{"getDeviceBTType,state= " + i});
        return i;
    }

    public void mo4466a(int i) {
        C2538c.b("PluginPayAdapterImpl", new Object[]{"onConnectStateChange"});
        this.f16637a = i;
        if (2 == i) {
            C2538c.b("PluginPayAdapterImpl", new Object[]{"DEVICE_CONNECTED"});
            return;
        }
        this.f16648q = null;
        this.f16649r = null;
        this.f16650s = null;
        this.f16651t = null;
        this.f16653v = null;
    }
}
