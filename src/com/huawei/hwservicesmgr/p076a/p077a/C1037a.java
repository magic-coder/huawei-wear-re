package com.huawei.hwservicesmgr.p076a.p077a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.s;
import com.huawei.hwcommonmodel.datatypes.t;
import com.huawei.hwcommonmodel.datatypes.u;
import com.huawei.hwcommonmodel.datatypes.w;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.hwdevicemgr.dmsdatatype.a.a;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import com.huawei.hwdevicemgr.p073a.C1023c;
import com.huawei.hwservicesmgr.a.a.b;
import com.huawei.hwservicesmgr.a.a.c;
import com.huawei.hwservicesmgr.a.a.d;
import com.huawei.hwservicesmgr.receiver.NetworkConnectReceiver;
import com.huawei.hwservicesmgr.remote.parser.IParser;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.util.ArrayList;
import java.util.List;

/* compiled from: HWEphemerisManager */
public class C1037a implements IParser {
    private static C1037a f1951b;
    private static long f1952d = StatisticConfig.MIN_UPLOAD_INTERVAL;
    private static long f1953e = 0;
    private static final byte[] f1954k = new byte[0];
    private int f1955a = 0;
    private w f1956c = new w();
    private List<String> f1957f = new ArrayList();
    private int f1958g = 1;
    private Handler f1959h = null;
    private HandlerThread f1960i = null;
    private int f1961j = 0;
    private boolean f1962l = false;
    private boolean f1963m = false;
    private int f1964n = 0;
    private int f1965o = -1;
    private boolean f1966p = false;
    private int f1967q = 0;
    private a f1968r = new b(this);
    private BroadcastReceiver f1969s = new c(this);

    private void m4234c() {
        this.f1962l = false;
        this.f1963m = false;
        this.f1964n = 0;
    }

    private void m4239d() {
        this.f1962l = true;
        this.f1963m = true;
    }

    public static C1037a m4219a() {
        if (f1951b == null) {
            f1951b = new C1037a();
        }
        return f1951b;
    }

    private C1037a() {
        this.f1957f.clear();
        IntentFilter intentFilter = new IntentFilter("com.huawei.bone.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("com.huawei.bone.action.PHONE_SERVICE_BIND_SUCCESS");
        intentFilter.addAction("com.huawei.bone.ephemeris.checkUpdate");
        intentFilter.addAction("com.huawei.bone.ephemeris.currentState.update.sucess");
        intentFilter.addAction("com.huawei.bone.ephemeris.currentState.update.fail");
        BaseApplication.m2632b().registerReceiver(this.f1969s, intentFilter, C0976c.f1642a, null);
        this.f1965o = -1;
        this.f1966p = false;
        this.f1960i = new HandlerThread("HWEphemerisManager");
        this.f1960i.start();
        this.f1959h = new d(this, this.f1960i.getLooper());
        NetworkConnectReceiver.m4471a(this.f1959h);
    }

    public void getResult(byte[] bArr) {
        C2538c.m12677c("HWEphemerisManager", "getResult()  data = " + C0973a.m3509a(bArr));
        String a;
        switch (bArr[1]) {
            case (byte) 1:
                a = C0973a.m3509a(bArr);
                try {
                    for (u uVar : this.f1956c.a(a.substring(4, a.length())).b) {
                        String str = "";
                        int i = 0;
                        for (s sVar : uVar.a) {
                            int parseInt;
                            String str2;
                            switch (Integer.parseInt(sVar.a(), 16)) {
                                case 2:
                                    parseInt = Integer.parseInt(sVar.b(), 16);
                                    C2538c.m12677c("HWEphemerisManager", "操作请求类型 = " + parseInt);
                                    str2 = str;
                                    break;
                                case 3:
                                    C1037a.m4220a(Long.parseLong(sVar.b(), 16) * 1000);
                                    a = sVar.b();
                                    C2538c.m12677c("HWEphemerisManager", "操作请求时间戳 = " + f1953e);
                                    int i2 = i;
                                    str2 = a;
                                    parseInt = i2;
                                    break;
                                default:
                                    parseInt = i;
                                    str2 = str;
                                    break;
                            }
                            str = str2;
                            i = parseInt;
                        }
                        if (1 == i) {
                            this.f1965o = 1;
                            C2538c.m12677c("HWEphemerisManager", "eph getResult 1111 EphemerisConstants.COMMAND_ID_OPERATOR_REQUEST currentUpdateState = " + this.f1965o);
                            m4259a(100000);
                            m4234c();
                            m4240e();
                        } else if (2 == i) {
                            m4224a(str);
                        } else {
                            continue;
                        }
                    }
                    return;
                } catch (t e) {
                    C2538c.m12680e("HWEphemerisManager", "COMMAND_ID_OPERATOR_REQUEST error e = " + e);
                    return;
                }
            case (byte) 2:
                this.f1958g = 1;
                m4248i();
                this.f1957f.clear();
                this.f1965o = 1;
                C2538c.m12677c("HWEphemerisManager", "eph getResult 2222 EphemerisConstants.COMMAND_ID_PARAMETER_CONSULT currentUpdateState = " + this.f1965o);
                a = C0973a.m3509a(bArr);
                try {
                    for (u uVar2 : this.f1956c.a(a.substring(4, a.length())).b) {
                        C2538c.m12677c("HWEphemerisManager", "tlvs = " + uVar2.a.size());
                        for (s sVar2 : r1) {
                            if (4 == Integer.parseInt(sVar2.a(), 16)) {
                                C2538c.m12677c("HWEphemerisManager", "协商超时时间 = " + (Long.parseLong(sVar2.b(), 16) * 1000));
                                if (StatisticConfig.MIN_UPLOAD_INTERVAL > f1952d || 250000 < f1952d) {
                                    m4259a(100007);
                                } else {
                                    C1037a.m4229b(r4);
                                }
                            }
                        }
                        for (u uVar22 : uVar22.b) {
                            C2538c.m12677c("HWEphemerisManager", "tlvss = " + uVar22.a.size());
                            for (s sVar3 : r0) {
                                switch (Integer.parseInt(sVar3.a(), 16)) {
                                    case 3:
                                        C2538c.m12677c("HWEphemerisManager", "协商地址 = " + C0973a.m3514c(sVar3.b()));
                                        this.f1957f.add(a);
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                    }
                    if (this.f1957f.size() == 0) {
                        C2538c.m12677c("HWEphemerisManager", "urls.size() = 0");
                        return;
                    } else if (this.f1959h != null) {
                        this.f1959h.sendEmptyMessageDelayed(1, f1952d);
                        C2538c.m12677c("HWEphemerisManager", "downloadFile()  发送超时定时器 waitTime = " + f1952d);
                        if (this.f1962l) {
                            this.f1958g = 2;
                            return;
                        }
                        this.f1959h.removeMessages(2);
                        this.f1959h.sendEmptyMessage(2);
                        return;
                    } else {
                        C2538c.m12677c("HWEphemerisManager", "myHanlder is null");
                        return;
                    }
                } catch (t e2) {
                    C2538c.m12680e("HWEphemerisManager", "COMMAND_ID_PARAMETER_CONSULT error e = " + e2);
                    return;
                }
            case (byte) 3:
                C2538c.m12677c("HWEphemerisManager", "COMMAND_ID_SEND_FILE_STATUS message = " + C0973a.m3509a(bArr));
                return;
            default:
                return;
        }
    }

    private void m4240e() {
        String str = C0973a.m3506a(129) + C0973a.m3506a(0);
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(31);
        deviceCommand.setCommandID(2);
        deviceCommand.setDataContent(C0973a.m3512b(str));
        deviceCommand.setDataLen(C0973a.m3512b(str).length);
        C2538c.m12677c("HWEphemerisManager", "5.10.2 parameterConsult send");
        C1023c.m3920a(BaseApplication.m2632b()).m3995b(deviceCommand);
    }

    private void m4243f() {
        synchronized (f1954k) {
            this.f1958g = 2;
            this.f1955a = 0;
            C2538c.m12677c("HWEphemerisManager", "downloadFile urls size is:" + this.f1957f.size() + ";index is:" + this.f1961j);
            if (this.f1961j < this.f1957f.size()) {
                try {
                    m4225a((String) this.f1957f.get(this.f1961j), this.f1968r);
                } catch (IndexOutOfBoundsException e) {
                    C2538c.m12680e("HWEphemerisManager", "downloadFile :", e.getMessage());
                }
            }
        }
    }

    private void m4244g() {
        this.f1958g = 4;
        m4247h();
        m4248i();
    }

    private void m4224a(String str) {
        String str2 = C0973a.m3506a(2) + C0973a.m3506a(1) + C0973a.m3506a(2);
        String str3 = C0973a.m3506a(3) + C0973a.m3506a(str.length() / 2) + str;
        String str4 = C0973a.m3506a(4) + C0973a.m3506a(1) + C0973a.m3506a(this.f1958g);
        str2 = C0973a.m3506a(129) + C0973a.m3517e(((str2.length() / 2) + (str3.length() / 2)) + (str4.length() / 2)) + str2 + str3 + str4;
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(31);
        deviceCommand.setCommandID(1);
        deviceCommand.setDataContent(C0973a.m3512b(str2));
        deviceCommand.setDataLen(C0973a.m3512b(str2).length);
        C2538c.m12677c("HWEphemerisManager", "5.31.1,type is ", Integer.valueOf(this.f1958g));
        C1023c.m3920a(BaseApplication.m2632b()).m3995b(deviceCommand);
    }

    private void m4247h() {
        C2538c.m12677c("HWEphemerisManager", "sendFileStatus() type = " + this.f1958g);
        if (this.f1966p) {
            this.f1966p = false;
            if (this.f1959h != null) {
                this.f1959h.removeMessages(4);
            }
            m4230b("com.huawei.bone.ephemeris.currentState.updating");
        }
        String str = C0973a.m3506a(1) + C0973a.m3506a(1) + C0973a.m3506a(this.f1958g);
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(31);
        deviceCommand.setCommandID(3);
        deviceCommand.setDataContent(C0973a.m3512b(str));
        deviceCommand.setDataLen(C0973a.m3512b(str).length);
        C1023c.m3920a(BaseApplication.m2632b()).m3995b(deviceCommand);
    }

    public void m4259a(int i) {
        String str = C0973a.m3506a(127) + C0973a.m3506a(4) + C0973a.m3507a((long) i);
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(31);
        deviceCommand.setCommandID(1);
        deviceCommand.setDataContent(C0973a.m3512b(str));
        deviceCommand.setDataLen(C0973a.m3512b(str).length);
        C1023c.m3920a(BaseApplication.m2632b()).m3995b(deviceCommand);
    }

    private void m4248i() {
        C1037a.m4229b((long) StatisticConfig.MIN_UPLOAD_INTERVAL);
        C1037a.m4220a(0);
        this.f1961j = 0;
        if (this.f1959h != null) {
            this.f1959h.removeMessages(1);
            return;
        }
        C2538c.m12677c("HWEphemerisManager", "myHanlder = null");
    }

    private void m4225a(java.lang.String r14, com.huawei.hwdevicemgr.dmsdatatype.a.a r15) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.huawei.hwservicesmgr.a.a.a.a(java.lang.String, com.huawei.hwdevicemgr.dmsdatatype.a.a):void. bs: [B:23:0x01af, B:50:0x0246]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r13 = this;
        r1 = 0;
        r11 = 1;
        r10 = 0;
        r0 = "";
        r0 = 2;
        r13.f1965o = r0;
        r0 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x03ad, Exception -> 0x03a2 }
        r0.<init>(r14);	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x03ad, Exception -> 0x03a2 }
        r2 = "HWEphemerisManager";	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x03ad, Exception -> 0x03a2 }
        r3 = 1;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x03ad, Exception -> 0x03a2 }
        r3 = new java.lang.Object[r3];	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x03ad, Exception -> 0x03a2 }
        r4 = 0;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x03ad, Exception -> 0x03a2 }
        r5 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x03ad, Exception -> 0x03a2 }
        r5.<init>();	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x03ad, Exception -> 0x03a2 }
        r6 = "requestFile() url = ";	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x03ad, Exception -> 0x03a2 }
        r5 = r5.append(r6);	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x03ad, Exception -> 0x03a2 }
        r5 = r5.append(r0);	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x03ad, Exception -> 0x03a2 }
        r5 = r5.toString();	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x03ad, Exception -> 0x03a2 }
        r3[r4] = r5;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x03ad, Exception -> 0x03a2 }
        com.huawei.p190v.C2538c.m12677c(r2, r3);	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x03ad, Exception -> 0x03a2 }
        r0 = r0.openConnection();	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x03ad, Exception -> 0x03a2 }
        r0 = (javax.net.ssl.HttpsURLConnection) r0;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x03ad, Exception -> 0x03a2 }
        com.huawei.hwcloudmodel.c.d.a(r0);	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r2 = com.huawei.hwcloudmodel.c.d.b;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r0.setHostnameVerifier(r2);	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r2 = "Charset";	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r3 = "UTF-8";	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r0.setRequestProperty(r2, r3);	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r2 = 300000; // 0x493e0 float:4.2039E-40 double:1.482197E-318;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r0.setConnectTimeout(r2);	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r2 = 300000; // 0x493e0 float:4.2039E-40 double:1.482197E-318;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r0.setReadTimeout(r2);	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r2 = "GET";	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r0.setRequestMethod(r2);	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r0.connect();	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r2 = new com.huawei.hwcloudmodel.model.RequestResult;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r2.<init>(r0);	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r3 = r2.getStatusCode();	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        if (r3 != r4) goto L_0x0211;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
    L_0x0061:
        r3 = "HWEphemerisManager";	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r4 = 1;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r4 = new java.lang.Object[r4];	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r5 = 0;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r6 = "requestFile() result";	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r4[r5] = r6;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        com.huawei.p190v.C2538c.m12677c(r3, r4);	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r3 = r2.asByte();	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r4 = "HWEphemerisManager";	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r5 = 1;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r5 = new java.lang.Object[r5];	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r6 = 0;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r7 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r7.<init>();	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r8 = "requestFile() data.length = ";	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r7 = r7.append(r8);	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r8 = r3.length;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r7 = r7.append(r8);	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r7 = r7.toString();	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r5[r6] = r7;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        com.huawei.p190v.C2538c.m12677c(r4, r5);	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r4 = "HWEphemerisManager";	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r5 = 1;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r5 = new java.lang.Object[r5];	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r6 = 0;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r7 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r7.<init>();	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r8 = "requestFile() data = ";	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r7 = r7.append(r8);	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r8 = com.huawei.hwcommonmodel.C0973a.m3509a(r3);	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r7 = r7.append(r8);	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r7 = r7.toString();	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r5[r6] = r7;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        com.huawei.p190v.C2538c.m12677c(r4, r5);	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r4 = "HWEphemerisManager";	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r5 = 1;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r5 = new java.lang.Object[r5];	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r6 = 0;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r7 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r7.<init>();	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r8 = "requestFile() result.Code = ";	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r7 = r7.append(r8);	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r2 = r2.asString();	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r2 = r7.append(r2);	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r2 = r2.toString();	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r5[r6] = r2;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        com.huawei.p190v.C2538c.m12677c(r4, r5);	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r2 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r2.<init>();	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r4 = com.huawei.hwcommonmodel.application.BaseApplication.m2632b();	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r4 = r4.getFilesDir();	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r2 = r2.append(r4);	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r4 = java.io.File.separator;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r2 = r2.append(r4);	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r4 = "gpslocation.dat";	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r2 = r2.append(r4);	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r2 = r2.toString();	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r4 = "HWEphemerisManager";	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r5 = 1;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r5 = new java.lang.Object[r5];	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r6 = 0;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r7 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r7.<init>();	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r8 = "requestFile() path = ";	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r7 = r7.append(r8);	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r7 = r7.append(r2);	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r7 = r7.toString();	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r5[r6] = r7;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        com.huawei.p190v.C2538c.m12677c(r4, r5);	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r4 = new java.io.File;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r4.<init>(r2);	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r2 = r4.exists();	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        if (r2 != 0) goto L_0x01a0;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
    L_0x011f:
        r2 = r4.createNewFile();	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r5 = "HWEphemerisManager";	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r6 = 1;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r6 = new java.lang.Object[r6];	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r7 = 0;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r8 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r8.<init>();	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r9 = "requestFile() 建立文件 flag = ";	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r8 = r8.append(r9);	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r2 = r8.append(r2);	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r2 = r2.toString();	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r6[r7] = r2;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        com.huawei.p190v.C2538c.m12677c(r5, r6);	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
    L_0x0141:
        r2 = new java.io.FileOutputStream;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r2.<init>(r4);	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r1 = 0;
        r4 = r3.length;	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        r2.write(r3, r1, r4);	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        r1 = 3;	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        r13.f1958g = r1;	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        r2.close();	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        r1 = r3.length;	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        r13.f1967q = r1;	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        r1 = 3;	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        r13.f1965o = r1;	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        r1 = "HWEphemerisManager";	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        r3 = 1;	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        r3 = new java.lang.Object[r3];	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        r4 = 0;	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        r5 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        r5.<init>();	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        r6 = "eph requestFile currentUpdateState = ";	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        r5 = r5.append(r6);	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        r6 = r13.f1965o;	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        r5 = r5.append(r6);	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        r6 = "  ephInfoSize = ";	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        r5 = r5.append(r6);	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        r6 = r13.f1967q;	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        r5 = r5.append(r6);	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        r5 = r5.toString();	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        r3[r4] = r5;	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        com.huawei.p190v.C2538c.m12677c(r1, r3);	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        r13.m4247h();	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        r1 = "HWEphemerisManager";	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        r3 = 1;	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        r3 = new java.lang.Object[r3];	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        r4 = 0;	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        r5 = "requestFile() 发送文件状态";	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        r3[r4] = r5;	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        com.huawei.p190v.C2538c.m12677c(r1, r3);	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        if (r15 == 0) goto L_0x0200;	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
    L_0x0195:
        r1 = 0;	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        r15.a(r1);	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
    L_0x0199:
        r1 = r2;
    L_0x019a:
        if (r1 == 0) goto L_0x019f;
    L_0x019c:
        r1.close();	 Catch:{ IOException -> 0x02ea }
    L_0x019f:
        return;
    L_0x01a0:
        r2 = "HWEphemerisManager";	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r5 = 1;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r5 = new java.lang.Object[r5];	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r6 = 0;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r7 = "requestFile() 文件已建立";	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r5[r6] = r7;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        com.huawei.p190v.C2538c.m12677c(r2, r5);	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        goto L_0x0141;
    L_0x01ae:
        r0 = move-exception;
    L_0x01af:
        r2 = "HWEphemerisManager";	 Catch:{ all -> 0x031c }
        r3 = 1;	 Catch:{ all -> 0x031c }
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x031c }
        r4 = 0;	 Catch:{ all -> 0x031c }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x031c }
        r5.<init>();	 Catch:{ all -> 0x031c }
        r6 = "requestFile() MalformedURLException = ";	 Catch:{ all -> 0x031c }
        r5 = r5.append(r6);	 Catch:{ all -> 0x031c }
        r0 = r0.getMessage();	 Catch:{ all -> 0x031c }
        r0 = r5.append(r0);	 Catch:{ all -> 0x031c }
        r0 = r0.toString();	 Catch:{ all -> 0x031c }
        r3[r4] = r0;	 Catch:{ all -> 0x031c }
        com.huawei.p190v.C2538c.m12680e(r2, r3);	 Catch:{ all -> 0x031c }
        if (r15 == 0) goto L_0x030d;	 Catch:{ all -> 0x031c }
    L_0x01d3:
        r0 = 0;	 Catch:{ all -> 0x031c }
        r2 = 0;	 Catch:{ all -> 0x031c }
        r15.a(r0, r2);	 Catch:{ all -> 0x031c }
    L_0x01d8:
        if (r1 == 0) goto L_0x019f;
    L_0x01da:
        r1.close();	 Catch:{ IOException -> 0x01de }
        goto L_0x019f;
    L_0x01de:
        r0 = move-exception;
        r1 = "HWEphemerisManager";
        r2 = new java.lang.Object[r11];
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "IOException = ";
        r3 = r3.append(r4);
        r0 = r0.getMessage();
        r0 = r3.append(r0);
        r0 = r0.toString();
        r2[r10] = r0;
        com.huawei.p190v.C2538c.m12680e(r1, r2);
        goto L_0x019f;
    L_0x0200:
        r1 = "HWEphemerisManager";	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        r3 = 1;	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        r3 = new java.lang.Object[r3];	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        r4 = 0;	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        r5 = "requestFile() fileCallback is null";	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        r3[r4] = r5;	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        com.huawei.p190v.C2538c.m12677c(r1, r3);	 Catch:{ MalformedURLException -> 0x020e, IOException -> 0x03b1, Exception -> 0x03a6, all -> 0x039e }
        goto L_0x0199;
    L_0x020e:
        r0 = move-exception;
        r1 = r2;
        goto L_0x01af;
    L_0x0211:
        if (r15 == 0) goto L_0x027a;
    L_0x0213:
        r2 = 0;
        r3 = 0;
        r15.a(r2, r3);	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        goto L_0x019a;
    L_0x0219:
        r2 = move-exception;
        r12 = r2;
        r2 = r0;
        r0 = r12;
    L_0x021d:
        r3 = "HWEphemerisManager";	 Catch:{ all -> 0x031c }
        r4 = 1;	 Catch:{ all -> 0x031c }
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x031c }
        r5 = 0;	 Catch:{ all -> 0x031c }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x031c }
        r6.<init>();	 Catch:{ all -> 0x031c }
        r7 = "requestFile() IOException = ";	 Catch:{ all -> 0x031c }
        r6 = r6.append(r7);	 Catch:{ all -> 0x031c }
        r7 = r0.getMessage();	 Catch:{ all -> 0x031c }
        r6 = r6.append(r7);	 Catch:{ all -> 0x031c }
        r6 = r6.toString();	 Catch:{ all -> 0x031c }
        r4[r5] = r6;	 Catch:{ all -> 0x031c }
        com.huawei.p190v.C2538c.m12680e(r3, r4);	 Catch:{ all -> 0x031c }
        if (r2 == 0) goto L_0x0244;	 Catch:{ all -> 0x031c }
    L_0x0241:
        r2.disconnect();	 Catch:{ all -> 0x031c }
    L_0x0244:
        if (r1 == 0) goto L_0x0249;
    L_0x0246:
        r1.close();	 Catch:{ IOException -> 0x0323 }
    L_0x0249:
        if (r15 == 0) goto L_0x0348;
    L_0x024b:
        r0 = 0;
        r2 = 0;
        r15.a(r0, r2);	 Catch:{ all -> 0x031c }
    L_0x0250:
        if (r1 == 0) goto L_0x019f;
    L_0x0252:
        r1.close();	 Catch:{ IOException -> 0x0257 }
        goto L_0x019f;
    L_0x0257:
        r0 = move-exception;
        r1 = "HWEphemerisManager";
        r2 = new java.lang.Object[r11];
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "IOException = ";
        r3 = r3.append(r4);
        r0 = r0.getMessage();
        r0 = r3.append(r0);
        r0 = r0.toString();
        r2[r10] = r0;
        com.huawei.p190v.C2538c.m12680e(r1, r2);
        goto L_0x019f;
    L_0x027a:
        r2 = "HWEphemerisManager";	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r3 = 1;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r3 = new java.lang.Object[r3];	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r4 = 0;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r5 = "requestFile() fileCallback is null";	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        r3[r4] = r5;	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        com.huawei.p190v.C2538c.m12677c(r2, r3);	 Catch:{ MalformedURLException -> 0x01ae, IOException -> 0x0219, Exception -> 0x0289 }
        goto L_0x019a;
    L_0x0289:
        r2 = move-exception;
        r12 = r2;
        r2 = r0;
        r0 = r12;
    L_0x028d:
        r3 = "HWEphemerisManager";	 Catch:{ all -> 0x031c }
        r4 = 1;	 Catch:{ all -> 0x031c }
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x031c }
        r5 = 0;	 Catch:{ all -> 0x031c }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x031c }
        r6.<init>();	 Catch:{ all -> 0x031c }
        r7 = "Exception = ";	 Catch:{ all -> 0x031c }
        r6 = r6.append(r7);	 Catch:{ all -> 0x031c }
        r7 = r0.getMessage();	 Catch:{ all -> 0x031c }
        r6 = r6.append(r7);	 Catch:{ all -> 0x031c }
        r6 = r6.toString();	 Catch:{ all -> 0x031c }
        r4[r5] = r6;	 Catch:{ all -> 0x031c }
        com.huawei.p190v.C2538c.m12680e(r3, r4);	 Catch:{ all -> 0x031c }
        if (r2 == 0) goto L_0x02b4;	 Catch:{ all -> 0x031c }
    L_0x02b1:
        r2.disconnect();	 Catch:{ all -> 0x031c }
    L_0x02b4:
        if (r1 == 0) goto L_0x02b9;
    L_0x02b6:
        r1.close();	 Catch:{ IOException -> 0x0357 }
    L_0x02b9:
        if (r15 == 0) goto L_0x02c0;
    L_0x02bb:
        r0 = 0;
        r2 = 0;
        r15.a(r0, r2);	 Catch:{ all -> 0x031c }
    L_0x02c0:
        if (r1 == 0) goto L_0x019f;
    L_0x02c2:
        r1.close();	 Catch:{ IOException -> 0x02c7 }
        goto L_0x019f;
    L_0x02c7:
        r0 = move-exception;
        r1 = "HWEphemerisManager";
        r2 = new java.lang.Object[r11];
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "IOException = ";
        r3 = r3.append(r4);
        r0 = r0.getMessage();
        r0 = r3.append(r0);
        r0 = r0.toString();
        r2[r10] = r0;
        com.huawei.p190v.C2538c.m12680e(r1, r2);
        goto L_0x019f;
    L_0x02ea:
        r0 = move-exception;
        r1 = "HWEphemerisManager";
        r2 = new java.lang.Object[r11];
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "IOException = ";
        r3 = r3.append(r4);
        r0 = r0.getMessage();
        r0 = r3.append(r0);
        r0 = r0.toString();
        r2[r10] = r0;
        com.huawei.p190v.C2538c.m12680e(r1, r2);
        goto L_0x019f;
    L_0x030d:
        r0 = "HWEphemerisManager";	 Catch:{ all -> 0x031c }
        r2 = 1;	 Catch:{ all -> 0x031c }
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x031c }
        r3 = 0;	 Catch:{ all -> 0x031c }
        r4 = "requestFile() fileCallback is null";	 Catch:{ all -> 0x031c }
        r2[r3] = r4;	 Catch:{ all -> 0x031c }
        com.huawei.p190v.C2538c.m12677c(r0, r2);	 Catch:{ all -> 0x031c }
        goto L_0x01d8;
    L_0x031c:
        r0 = move-exception;
    L_0x031d:
        if (r1 == 0) goto L_0x0322;
    L_0x031f:
        r1.close();	 Catch:{ IOException -> 0x037c }
    L_0x0322:
        throw r0;
    L_0x0323:
        r2 = move-exception;
        r2 = "HWEphemerisManager";	 Catch:{ all -> 0x031c }
        r3 = 1;	 Catch:{ all -> 0x031c }
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x031c }
        r4 = 0;	 Catch:{ all -> 0x031c }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x031c }
        r5.<init>();	 Catch:{ all -> 0x031c }
        r6 = "requestFile() IOException = ";	 Catch:{ all -> 0x031c }
        r5 = r5.append(r6);	 Catch:{ all -> 0x031c }
        r0 = r0.getMessage();	 Catch:{ all -> 0x031c }
        r0 = r5.append(r0);	 Catch:{ all -> 0x031c }
        r0 = r0.toString();	 Catch:{ all -> 0x031c }
        r3[r4] = r0;	 Catch:{ all -> 0x031c }
        com.huawei.p190v.C2538c.m12680e(r2, r3);	 Catch:{ all -> 0x031c }
        goto L_0x0249;	 Catch:{ all -> 0x031c }
    L_0x0348:
        r0 = "HWEphemerisManager";	 Catch:{ all -> 0x031c }
        r2 = 1;	 Catch:{ all -> 0x031c }
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x031c }
        r3 = 0;	 Catch:{ all -> 0x031c }
        r4 = "requestFile() fileCallback is null";	 Catch:{ all -> 0x031c }
        r2[r3] = r4;	 Catch:{ all -> 0x031c }
        com.huawei.p190v.C2538c.m12677c(r0, r2);	 Catch:{ all -> 0x031c }
        goto L_0x0250;	 Catch:{ all -> 0x031c }
    L_0x0357:
        r2 = move-exception;	 Catch:{ all -> 0x031c }
        r2 = "HWEphemerisManager";	 Catch:{ all -> 0x031c }
        r3 = 1;	 Catch:{ all -> 0x031c }
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x031c }
        r4 = 0;	 Catch:{ all -> 0x031c }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x031c }
        r5.<init>();	 Catch:{ all -> 0x031c }
        r6 = "IOException = ";	 Catch:{ all -> 0x031c }
        r5 = r5.append(r6);	 Catch:{ all -> 0x031c }
        r0 = r0.getMessage();	 Catch:{ all -> 0x031c }
        r0 = r5.append(r0);	 Catch:{ all -> 0x031c }
        r0 = r0.toString();	 Catch:{ all -> 0x031c }
        r3[r4] = r0;	 Catch:{ all -> 0x031c }
        com.huawei.p190v.C2538c.m12680e(r2, r3);	 Catch:{ all -> 0x031c }
        goto L_0x02b9;
    L_0x037c:
        r1 = move-exception;
        r2 = "HWEphemerisManager";
        r3 = new java.lang.Object[r11];
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "IOException = ";
        r4 = r4.append(r5);
        r1 = r1.getMessage();
        r1 = r4.append(r1);
        r1 = r1.toString();
        r3[r10] = r1;
        com.huawei.p190v.C2538c.m12680e(r2, r3);
        goto L_0x0322;
    L_0x039e:
        r0 = move-exception;
        r1 = r2;
        goto L_0x031d;
    L_0x03a2:
        r0 = move-exception;
        r2 = r1;
        goto L_0x028d;
    L_0x03a6:
        r1 = move-exception;
        r12 = r1;
        r1 = r2;
        r2 = r0;
        r0 = r12;
        goto L_0x028d;
    L_0x03ad:
        r0 = move-exception;
        r2 = r1;
        goto L_0x021d;
    L_0x03b1:
        r1 = move-exception;
        r12 = r1;
        r1 = r2;
        r2 = r0;
        r0 = r12;
        goto L_0x021d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hwservicesmgr.a.a.a.a(java.lang.String, com.huawei.hwdevicemgr.dmsdatatype.a.a):void");
    }

    private void m4230b(String str) {
        C2538c.m12677c("HWEphemerisManager", "eph sendBroadcastUpdateState intentAction = " + str);
        Context b = BaseApplication.m2632b();
        if (b != null) {
            Intent intent = new Intent(str);
            Bundle bundle = new Bundle();
            bundle.putInt("key_eph_info_size", this.f1967q);
            intent.putExtras(bundle);
            b.sendOrderedBroadcast(intent, C0976c.f1642a);
        }
    }

    private static void m4220a(long j) {
        f1953e = j;
    }

    private static void m4229b(long j) {
        f1952d = j;
    }
}
