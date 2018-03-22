package com.huawei.android.pushagent.p020b.p021a.p324a.p326b;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.amap.api.maps.model.WeightedLatLng;
import com.huawei.android.pushagent.PushService;
import com.huawei.android.pushagent.a.e;
import com.huawei.android.pushagent.b.a.a;
import com.huawei.android.pushagent.b.b.c;
import com.huawei.android.pushagent.c.a.h;
import com.huawei.android.pushagent.p017a.C4036b;
import com.huawei.android.pushagent.p017a.p322b.C4051j;
import com.huawei.android.pushagent.p018c.p019a.C4103b;
import com.huawei.android.pushagent.p020b.p021a.a$a;
import com.huawei.android.pushagent.p020b.p021a.p324a.C4067b;
import com.huawei.hwid.core.constants.HwAccountConstants;
import java.net.Socket;
import java.util.Set;
import org.apache.log4j.helpers.FileWatchdog;

public class C4073b extends C4067b {
    public long f15425e = 7200000;
    private boolean f15426f = false;
    private long f15427g = this.f15425e;
    private long f15428h = this.f15425e;
    private int f15429i = 0;
    private String f15430j = "";
    private String f15431k = "";
    private String f15432l = null;

    public C4073b(Context context) {
        super(context);
    }

    private void m19985a(e eVar, String str) {
        Object obj = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                Object obj2;
                Set<String> keySet = eVar.S().keySet();
                if (keySet.size() > 0) {
                    for (String str2 : keySet) {
                        if (str2.contains(str)) {
                            String str3 = (String) eVar.S().get(str2);
                            com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "apnName is:" + str2 + ",apnHeartBeat is:" + str3);
                            String[] split = str3.split(HwAccountConstants.SPLIIT_UNDERLINE);
                            this.f15427g = Long.parseLong(split[0]) * 1000;
                            this.f15428h = Long.parseLong(split[1]) * 1000;
                            obj2 = 1;
                            break;
                        }
                    }
                }
                obj2 = null;
                obj = obj2;
            } catch (Throwable e) {
                com.huawei.android.pushagent.c.a.e.c("PushLogAC2712", e.toString(), e);
            }
        }
        if (obj == null) {
            this.f15427g = eVar.i() * 1000;
            this.f15428h = eVar.j() * 1000;
        }
        com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "after all, minHeartBeat is :" + this.f15427g + ",maxHeartBeat is:" + this.f15428h);
    }

    private String m19986j() {
        String str = "";
        try {
            if (a.e() != null) {
                Socket c = a.e().m19947c();
                if (c != null) {
                    str = c.getLocalAddress().getHostAddress();
                }
            }
        } catch (Exception e) {
            com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", e.toString());
        }
        return str == null ? "" : str;
    }

    private Long m19987k() {
        String a = c.a(this.c, "cloudpush_fixHeatBeat", "");
        try {
            long parseLong = 1000 * Long.parseLong(a.trim());
            com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "get heart beat from config, value:" + parseLong + " so neednot ajust");
            return Long.valueOf(parseLong);
        } catch (NumberFormatException e) {
            if ((2 == this.d && 5 != this.d) || 1 != C4103b.m20122a(this.c)) {
                return null;
            }
            com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "in wifi and in charging, cannot ajust heartBeat");
            return Long.valueOf(FileWatchdog.DEFAULT_DELAY);
        } catch (Throwable e2) {
            com.huawei.android.pushagent.c.a.e.c("PushLogAC2712", "get cloudpush_fixHeatBeat:" + a + " cause:" + e2.toString(), e2);
            if (2 == this.d) {
            }
            com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "in wifi and in charging, cannot ajust heartBeat");
            return Long.valueOf(FileWatchdog.DEFAULT_DELAY);
        }
    }

    private boolean m19988l() {
        int a = C4103b.m20122a(this.c);
        String h = com.huawei.android.pushagent.c.a.h(this.c);
        String j = com.huawei.android.pushagent.c.a.j(this.c);
        if (1 == a) {
            j = "wifi";
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("HasFindHeartBeat_" + h + HwAccountConstants.SPLIIT_UNDERLINE + a + HwAccountConstants.SPLIIT_UNDERLINE + j, Boolean.valueOf(this.f15426f));
        contentValues.put("HearBeatInterval_" + h + HwAccountConstants.SPLIIT_UNDERLINE + a + HwAccountConstants.SPLIIT_UNDERLINE + j, Long.valueOf(this.f15425e));
        contentValues.put("ClientIP_" + h + HwAccountConstants.SPLIIT_UNDERLINE + a, this.f15432l);
        if (this.f15426f) {
            j = com.huawei.android.pushagent.c.a.a(System.currentTimeMillis() + com.huawei.android.pushagent.b.b.a.a(this.c).ad(), "yyyy-MM-dd HH:mm:ss SSS");
            com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "when find best heart beat,save the valid end time " + j + " to xml.");
            contentValues.put("HeartBeatValid", j);
        }
        return new h(this.c, mo4363c()).a(contentValues);
    }

    public long mo4361b(boolean z) {
        if (-1 == C4103b.m20122a(this.c)) {
            com.huawei.android.pushagent.c.a.e.b("PushLogAC2712", "no network, use no network heartbeat");
            return com.huawei.android.pushagent.b.b.a.a(this.c).p() * 1000;
        }
        Long k = m19987k();
        if (k != null) {
            return k.longValue();
        }
        if (m19995h()) {
            m19996i();
        }
        long j = this.f15425e;
        if (this.f15426f) {
            return j;
        }
        j = z ? this.f15425e : this.f15425e + StatisticConfig.MIN_UPLOAD_INTERVAL;
        return j <= this.f15427g ? this.f15427g : j >= this.f15428h ? this.f15428h : j;
    }

    public boolean mo4362b(long j) {
        return true;
    }

    public String mo4363c() {
        return "PushHearBeat";
    }

    public void mo4364c(boolean z) {
        com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "enter adjustHeartBeat:(findHeartBeat:" + this.f15426f + " RspTimeOut:" + z + " beatInterval:" + this.f15425e + " range:[" + this.f15427g + "," + this.f15428h + "]," + "isHearBeatTimeReq:" + this.b + " batteryStatus:" + this.d + ")");
        if (m19987k() != null || this.f15426f) {
            return;
        }
        if (this.b) {
            m19958a(false);
            this.f15425e = mo4361b(z);
            if (z || this.f15425e <= this.f15427g || this.f15425e >= this.f15428h) {
                this.f15426f = true;
                com.huawei.android.pushagent.c.a.e.b("PushLogAC2712", "after all the best heartBeat Interval:" + this.f15425e + "ms");
            } else {
                com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "set current heartBeatInterval " + this.f15425e + "ms");
            }
            m19988l();
            return;
        }
        com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "It is not hearBeatTimeReq");
    }

    public /* synthetic */ C4067b mo4365f() {
        return m19996i();
    }

    public void mo4366g() {
        try {
            com.huawei.android.pushagent.c.a.a.b(PushService.a().getContext(), new Intent("com.huawei.android.push.intent.HEARTBEAT_RSP_TIMEOUT").putExtra("timer_reason", "timeOutWaitPushSrvRsp").putExtra("connect_mode", a$a.ConnectEntity_Push.ordinal()).setPackage(this.c.getPackageName()), com.huawei.android.pushagent.b.b.a.a(this.c).Q());
            m19957a(System.currentTimeMillis());
            C4036b c4051j = new C4051j();
            c4051j.m19903a((byte) ((int) Math.ceil((((double) mo4361b(false)) * WeightedLatLng.DEFAULT_INTENSITY) / 60000.0d)));
            a.e().m19944a(c4051j);
        } catch (Throwable e) {
            com.huawei.android.pushagent.c.a.e.c("PushLogAC2712", "call pushChannel.send cause Exception:" + e.toString(), e);
        }
    }

    protected boolean m19995h() {
        int a = C4103b.m20122a(this.c);
        String h = com.huawei.android.pushagent.c.a.h(this.c);
        switch (a) {
            case 0:
                return (a == this.f15429i && h.equals(this.f15430j) && com.huawei.android.pushagent.c.a.j(this.c).equals(this.f15431k)) ? false : true;
            case 1:
                return (a == this.f15429i && h.equals(this.f15430j) && m19986j().equals(this.f15432l)) ? false : true;
            default:
                com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "isEnvChange:netType:" + a + false);
                return false;
        }
    }

    public C4073b m19996i() {
        try {
            if (a.e() == null) {
                com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "system is in start, wait net for heartBeat");
                return null;
            }
            String asString;
            this.f15432l = m19986j();
            ContentValues a = new h(this.c, mo4363c()).a();
            if (a != null) {
                asString = a.getAsString("HeartBeatValid");
                com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "hear beat valid from xml is " + asString);
                if (!TextUtils.isEmpty(asString) && (System.currentTimeMillis() >= com.huawei.android.pushagent.c.a.a(asString) || System.currentTimeMillis() + com.huawei.android.pushagent.b.b.a.a(this.c).ad() < com.huawei.android.pushagent.c.a.a(asString))) {
                    PushService.a(new Intent("com.huawei.android.push.intent.HEARTBEAT_VALID_ARRIVED"));
                }
            } else {
                com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "PushHearBeat preferences is null");
            }
            this.f15429i = C4103b.m20122a(this.c);
            this.f15430j = com.huawei.android.pushagent.c.a.h(this.c);
            e a2 = com.huawei.android.pushagent.b.b.a.a(this.c);
            this.f15427g = a2.i() * 1000;
            this.f15428h = a2.j() * 1000;
            this.f15426f = false;
            com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "in loadHeartBeat netType:" + this.f15429i + " mccMnc:" + this.f15430j);
            ContentValues a3 = new h(this.c, mo4363c()).a();
            switch (this.f15429i) {
                case -1:
                    this.f15425e = a2.p() * 1000;
                    return this;
                case 0:
                    this.f15431k = com.huawei.android.pushagent.c.a.j(this.c);
                    com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "in loadHeartBeat apnName:" + this.f15431k);
                    m19985a(a2, this.f15431k);
                    break;
                case 1:
                    this.f15427g = a2.g() * 1000;
                    this.f15428h = a2.h() * 1000;
                    this.f15431k = "wifi";
                    this.f15425e = this.f15427g;
                    if (a3 != null) {
                        asString = a3.getAsString("ClientIP_" + this.f15430j + HwAccountConstants.SPLIIT_UNDERLINE + this.f15429i);
                        if (this.f15432l == null || !this.f15432l.equals(asString)) {
                            com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "curIP:" + this.f15432l + " oldIP:" + asString + ", there are diff, so need find heartBeat again");
                            return this;
                        }
                    }
                    break;
                default:
                    com.huawei.android.pushagent.c.a.e.d("PushLogAC2712", "unKnow net type");
                    return this;
            }
            this.f15425e = this.f15427g;
            if (a3 == null) {
                return this;
            }
            if (a3.containsKey("HasFindHeartBeat_" + this.f15430j + HwAccountConstants.SPLIIT_UNDERLINE + this.f15429i + HwAccountConstants.SPLIIT_UNDERLINE + this.f15431k) && a3.containsKey("HearBeatInterval_" + this.f15430j + HwAccountConstants.SPLIIT_UNDERLINE + this.f15429i + HwAccountConstants.SPLIIT_UNDERLINE + this.f15431k)) {
                this.f15426f = a3.getAsBoolean("HasFindHeartBeat_" + this.f15430j + HwAccountConstants.SPLIIT_UNDERLINE + this.f15429i + HwAccountConstants.SPLIIT_UNDERLINE + this.f15431k).booleanValue();
                Integer asInteger = a3.getAsInteger("HearBeatInterval_" + this.f15430j + HwAccountConstants.SPLIIT_UNDERLINE + this.f15429i + HwAccountConstants.SPLIIT_UNDERLINE + this.f15431k);
                int intValue = asInteger != null ? asInteger.intValue() : 0;
                if (((long) intValue) < 180000) {
                    return this;
                }
                this.f15425e = (long) intValue;
                return this;
            }
            com.huawei.android.pushagent.c.a.e.a("PushLogAC2712", "have no this heartbeat config, use default");
            return this;
        } catch (Throwable e) {
            com.huawei.android.pushagent.c.a.e.c("PushLogAC2712", "call loadHeartBeat cause:" + e.toString(), e);
            return this;
        }
    }

    public String toString() {
        String str = "=";
        String str2 = HwAccountConstants.BLANK;
        return new StringBuffer().append("HasFindHeartBeat").append(str).append(this.f15426f).append(str2).append("HearBeatInterval").append(str).append(this.f15425e).append(str2).append("minHeartBeat").append(str).append(this.f15427g).append(str2).append("maxHeartBeat").append(str).append(this.f15428h).toString();
    }
}
