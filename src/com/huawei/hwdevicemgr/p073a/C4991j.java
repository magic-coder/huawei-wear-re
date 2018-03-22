package com.huawei.hwdevicemgr.p073a;

import android.os.HandlerThread;
import android.text.TextUtils;
import com.huawei.al.C4029b;
import com.huawei.p029c.C0669b;
import com.huawei.hwbtsdk.p059c.BTSDKApi;
import com.huawei.hwbtsdk.p057b.p400b.C4625b;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.C4738c;
import com.huawei.hwcommonmodel.datatypes.C4745l;
import com.huawei.hwcommonmodel.datatypes.C4752s;
import com.huawei.hwcommonmodel.datatypes.C4754u;
import com.huawei.hwcommonmodel.datatypes.HWOTAParameter;
import com.huawei.hwcommonmodel.p063b.C4715d;
import com.huawei.hwdevicedfxmanager.constants.HWDeviceDFXConstants;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.C4998a;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.C4999b;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.C5001d;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.C5002e;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.C5005i;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.C5006j;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.C5008l;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DataOtaParametersV2;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import com.huawei.hwdevicemgr.dmsdatatype.p074a.C4992a;
import com.huawei.hwdevicemgr.dmsdatatype.p074a.C4995c;
import com.huawei.p190v.C2538c;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: OTATransferFile */
public class C4991j {
    private static C4991j f18074d = null;
    private int f18075A = 0;
    private int f18076B = 30000;
    private int f18077C = 180000;
    private boolean f18078D = false;
    private double f18079E = 0.0d;
    private boolean f18080F = false;
    private int f18081G = 0;
    private int f18082H = 10;
    private boolean f18083I = false;
    private C4999b f18084J;
    private C4992a f18085K = new C4993k(this);
    private C4992a f18086L = new C4994l(this);
    private BTSDKApi f18087a = null;
    private String f18088b = "";
    private int f18089c = -1;
    private int f18090e = -1;
    private String f18091f;
    private int f18092g = 128;
    private byte[] f18093h;
    private int f18094i;
    private int f18095j = 0;
    private boolean f18096k;
    private List<Integer> f18097l = new ArrayList();
    private int f18098m;
    private File f18099n;
    private int f18100o;
    private int f18101p = 3000;
    private int f18102q = 128;
    private boolean f18103r = false;
    private C0669b f18104s;
    private C5008l f18105t;
    private ArrayList<C4998a> f18106u = new ArrayList();
    private C4995c f18107v;
    private HandlerThread f18108w = null;
    private C4997n f18109x = null;
    private boolean f18110y = false;
    private byte[] f18111z = null;

    C4991j(BTSDKApi aVar, String str, int i) {
        this.f18087a = aVar;
        this.f18088b = str;
        this.f18089c = i;
        this.f18091f = "";
        this.f18084J = C4999b.m24006a(BaseApplication.b());
        C2538c.c("OTATransferFile", new Object[]{"OTATransferFile init"});
    }

    public void m23977a() {
        if (this.f18109x != null) {
            this.f18109x.removeCallbacksAndMessages(null);
            this.f18109x = null;
        }
        if (this.f18108w != null) {
            this.f18108w.getLooper().quit();
            this.f18108w = null;
        }
    }

    public void m23981a(String str, String str2, DataOtaParametersV2 dataOtaParametersV2, int i, C0669b bVar) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || dataOtaParametersV2 == null || bVar == null) {
            C2538c.d("OTATransferFile", new Object[]{"---startTransferOTAFile error, parameter is null---"});
            if (bVar != null) {
                bVar.a(109001, "参数非法");
                return;
            }
            return;
        }
        C2538c.c("OTATransferFile", new Object[]{"startTransferOTAFile, version---------------------" + str2});
        C2538c.c("OTATransferFile", new Object[]{"startTransferOTAFile, updateMode------------------" + i});
        if (this.f18108w == null) {
            this.f18108w = new HandlerThread("OTATransferFile");
            this.f18108w.start();
            this.f18109x = new C4997n(this, this.f18108w.getLooper());
        }
        this.f18104s = bVar;
        m23956c(str);
        int otaUnitSize = dataOtaParametersV2.getOtaUnitSize();
        int appWaitTimeout = dataOtaParametersV2.getAppWaitTimeout();
        int deviceRestartTimeout = dataOtaParametersV2.getDeviceRestartTimeout();
        this.f18078D = dataOtaParametersV2.getAckEnable();
        this.f18075A = otaUnitSize;
        this.f18076B = appWaitTimeout * 1000;
        this.f18077C = deviceRestartTimeout * 1000;
        this.f18081G = 0;
        this.f18083I = false;
        C2538c.c("OTATransferFile", new Object[]{"startTransferOTAFile, mMaxPacket------------------" + this.f18075A});
        C2538c.c("OTATransferFile", new Object[]{"startTransferOTAFile, mWaitTimeout----------------" + this.f18076B});
        C2538c.c("OTATransferFile", new Object[]{"startTransferOTAFile, mRestartTimeout-------------" + this.f18077C});
        C2538c.c("OTATransferFile", new Object[]{"startTransferOTAFile, mAckEnable-------------" + this.f18078D});
        if (this.f18076B != 0) {
            this.f18109x.sendEmptyMessageDelayed(6, (long) this.f18076B);
        }
    }

    private void m23956c(String str) {
        C2538c.c("OTATransferFile", new Object[]{"initOtaV2File, filePath = " + str});
        try {
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str);
                if (m23948a(file, str) && !file.createNewFile()) {
                    C2538c.e("OTATransferFile", new Object[]{"startTransferOTAFile, The file already exists...continue..."});
                }
                String canonicalPath = file.getCanonicalPath();
                if (this.f18111z == null) {
                    this.f18111z = m23962d(canonicalPath);
                }
            }
        } catch (IOException e) {
            C2538c.e("OTATransferFile", new Object[]{"IOException e" + e.getMessage()});
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] m23962d(java.lang.String r12) {
        /*
        r11 = this;
        r2 = 0;
        r10 = 2;
        r9 = 1;
        r8 = 0;
        r0 = new byte[r8];
        r1 = r11.m23983a(r12);
        if (r1 != 0) goto L_0x000d;
    L_0x000c:
        return r0;
    L_0x000d:
        r1 = new java.io.File;	 Catch:{ IOException -> 0x0094, all -> 0x00c4 }
        r1.<init>(r12);	 Catch:{ IOException -> 0x0094, all -> 0x00c4 }
        r3 = r1.exists();	 Catch:{ IOException -> 0x0094, all -> 0x00c4 }
        if (r3 != 0) goto L_0x002b;
    L_0x0018:
        r3 = r1.createNewFile();	 Catch:{ IOException -> 0x0094, all -> 0x00c4 }
        if (r3 != 0) goto L_0x002b;
    L_0x001e:
        r3 = "OTATransferFile";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x0094, all -> 0x00c4 }
        r5 = 0;
        r6 = "getOTAFileByPath, The file already exists...continue...";
        r4[r5] = r6;	 Catch:{ IOException -> 0x0094, all -> 0x00c4 }
        com.huawei.v.c.e(r3, r4);	 Catch:{ IOException -> 0x0094, all -> 0x00c4 }
    L_0x002b:
        r4 = r1.length();	 Catch:{ IOException -> 0x0094, all -> 0x00c4 }
        r0 = (int) r4;
        r3 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x00e4, all -> 0x00c4 }
        r3.<init>(r1);	 Catch:{ IOException -> 0x00e4, all -> 0x00c4 }
        r1 = "OTATransferFile";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x00e8, all -> 0x00df }
        r5 = 0;
        r6 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00e8, all -> 0x00df }
        r6.<init>();	 Catch:{ IOException -> 0x00e8, all -> 0x00df }
        r7 = "file size = ";
        r6 = r6.append(r7);	 Catch:{ IOException -> 0x00e8, all -> 0x00df }
        r6 = r6.append(r0);	 Catch:{ IOException -> 0x00e8, all -> 0x00df }
        r6 = r6.toString();	 Catch:{ IOException -> 0x00e8, all -> 0x00df }
        r4[r5] = r6;	 Catch:{ IOException -> 0x00e8, all -> 0x00df }
        com.huawei.v.c.c(r1, r4);	 Catch:{ IOException -> 0x00e8, all -> 0x00df }
        r0 = new byte[r0];	 Catch:{ IOException -> 0x00e8, all -> 0x00df }
        r1 = r3.read(r0);	 Catch:{ IOException -> 0x00ed, all -> 0x00df }
        r2 = "OTATransferFile";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x00ed, all -> 0x00df }
        r5 = 0;
        r6 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00ed, all -> 0x00df }
        r6.<init>();	 Catch:{ IOException -> 0x00ed, all -> 0x00df }
        r7 = "getOTAFileByPath ret = ";
        r6 = r6.append(r7);	 Catch:{ IOException -> 0x00ed, all -> 0x00df }
        r1 = r6.append(r1);	 Catch:{ IOException -> 0x00ed, all -> 0x00df }
        r1 = r1.toString();	 Catch:{ IOException -> 0x00ed, all -> 0x00df }
        r4[r5] = r1;	 Catch:{ IOException -> 0x00ed, all -> 0x00df }
        com.huawei.v.c.c(r2, r4);	 Catch:{ IOException -> 0x00ed, all -> 0x00df }
        r3.close();	 Catch:{ IOException -> 0x00ed, all -> 0x00df }
        if (r3 == 0) goto L_0x000c;
    L_0x007c:
        r3.close();	 Catch:{ IOException -> 0x0080 }
        goto L_0x000c;
    L_0x0080:
        r1 = move-exception;
        r2 = "OTATransferFile";
        r3 = new java.lang.Object[r10];
        r4 = "IOException getOTAFileByPath() finally e = ";
        r3[r8] = r4;
        r1 = r1.getMessage();
        r3[r9] = r1;
        com.huawei.v.c.c(r2, r3);
        goto L_0x000c;
    L_0x0094:
        r1 = move-exception;
    L_0x0095:
        r3 = "OTATransferFile";
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00e1 }
        r5 = 0;
        r6 = "IOException getOTAFileByPath() e = ";
        r4[r5] = r6;	 Catch:{ all -> 0x00e1 }
        r5 = 1;
        r1 = r1.getMessage();	 Catch:{ all -> 0x00e1 }
        r4[r5] = r1;	 Catch:{ all -> 0x00e1 }
        com.huawei.v.c.c(r3, r4);	 Catch:{ all -> 0x00e1 }
        if (r2 == 0) goto L_0x000c;
    L_0x00ab:
        r2.close();	 Catch:{ IOException -> 0x00b0 }
        goto L_0x000c;
    L_0x00b0:
        r1 = move-exception;
        r2 = "OTATransferFile";
        r3 = new java.lang.Object[r10];
        r4 = "IOException getOTAFileByPath() finally e = ";
        r3[r8] = r4;
        r1 = r1.getMessage();
        r3[r9] = r1;
        com.huawei.v.c.c(r2, r3);
        goto L_0x000c;
    L_0x00c4:
        r0 = move-exception;
        r3 = r2;
    L_0x00c6:
        if (r3 == 0) goto L_0x00cb;
    L_0x00c8:
        r3.close();	 Catch:{ IOException -> 0x00cc }
    L_0x00cb:
        throw r0;
    L_0x00cc:
        r1 = move-exception;
        r2 = "OTATransferFile";
        r3 = new java.lang.Object[r10];
        r4 = "IOException getOTAFileByPath() finally e = ";
        r3[r8] = r4;
        r1 = r1.getMessage();
        r3[r9] = r1;
        com.huawei.v.c.c(r2, r3);
        goto L_0x00cb;
    L_0x00df:
        r0 = move-exception;
        goto L_0x00c6;
    L_0x00e1:
        r0 = move-exception;
        r3 = r2;
        goto L_0x00c6;
    L_0x00e4:
        r0 = move-exception;
        r1 = r0;
        r0 = r2;
        goto L_0x0095;
    L_0x00e8:
        r0 = move-exception;
        r1 = r0;
        r0 = r2;
        r2 = r3;
        goto L_0x0095;
    L_0x00ed:
        r1 = move-exception;
        r2 = r3;
        goto L_0x0095;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hwdevicemgr.a.j.d(java.lang.String):byte[]");
    }

    private boolean m23948a(File file, String str) throws IOException {
        if (file.getCanonicalPath().startsWith(new File(str).getCanonicalPath())) {
            return true;
        }
        C2538c.e("OTATransferFile", new Object[]{"File is outside extraction target directory."});
        return false;
    }

    private void m23945a(C5001d c5001d) {
        if (this.f18109x != null) {
            this.f18109x.removeMessages(6);
            C2538c.c("OTATransferFile", new Object[]{"is have message " + this.f18109x.hasMessages(6)});
        }
        int a = (int) c5001d.m24026a();
        int b = (int) c5001d.m24029b();
        List c = c5001d.m24031c();
        c.c("OTATransferFile", new Object[]{"APP收到单板申请数据主动上报,file_offset = " + a + ", file_length = " + b});
        m23939a(a, b, c);
        if (this.f18080F) {
            a = (int) ((((double) this.f18081G) / this.f18079E) * 100.0d);
            if (this.f18104s != null) {
                this.f18104s.a(a);
            }
            c.c("OTATransferFile", new Object[]{"当前升级进度为 progress = " + a + ", mAlreadySend = " + this.f18081G + ", file_length = " + this.f18111z.length + ". mOtaFileSizeV2 = " + this.f18079E});
        }
    }

    private void m23946a(C5002e c5002e) {
        C2538c.c("OTATransferFile", new Object[]{"OTA升级包大小主动上报，dataOtaPackageSizeReport = " + c5002e});
        this.f18080F = true;
        long a = c5002e.m24032a();
        this.f18079E = (double) a;
        int b = (int) (c5002e.m24034b() / a);
        C2538c.c("OTATransferFile", new Object[]{"OTA升级包大小主动上报，升级进度 = " + b + ", package_valid_size = " + a + ", receiver_file_size = " + c5002e.m24034b()});
    }

    private void m23938a(int i) {
        this.f18080F = false;
        this.f18109x.removeMessages(6);
        if (i == 0) {
            C2538c.c("OTATransferFile", new Object[]{"上报UI，升级失败 !!!"});
            if (this.f18104s != null) {
                this.f18104s.b(0);
            }
            m23986b();
        } else if (1 == i) {
            C2538c.c("OTATransferFile", new Object[]{"上报UI,升级成功 开启单板重启升级超时 : " + this.f18077C});
            if (this.f18104s != null) {
                this.f18104s.b(this.f18077C);
            }
            m23986b();
        }
    }

    public void m23986b() {
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(9);
        deviceCommand.setCommandID(6);
        deviceCommand.setDataContent(null);
        deviceCommand.setDataLen(0);
        m23979a(deviceCommand);
    }

    private void m23952b(int i) {
        C2538c.c("OTATransferFile", new Object[]{"设备升级状态上报,errorCode = " + i});
        if (100000 != i) {
            if (this.f18104s != null) {
                this.f18104s.a(i, "设备异常");
            }
            this.f18083I = true;
        }
    }

    private void m23939a(int i, int i2, List<Integer> list) {
        int i3;
        C2538c.c("OTATransferFile", new Object[]{"开始传输升级文件 otaFileDelivery Enter ... mMaxPacket = " + this.f18075A + ", file_Offset = " + i + ", fileLength = " + i2});
        int i4 = this.f18075A - 9;
        if (i2 % i4 == 0) {
            i3 = i2 / i4;
        } else {
            i3 = (i2 / i4) + 1;
        }
        C2538c.c("OTATransferFile", new Object[]{"otaFileDelivery, file_array = " + i3});
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < i3) {
            int i8;
            int length;
            if ((i2 - i6) / i4 != 0) {
                C2538c.c("OTATransferFile", new Object[]{"单次发送数据为： 协商最大 "});
                i8 = i4;
            } else {
                i8 = i2 % i4;
                C2538c.c("OTATransferFile", new Object[]{"单次发送数据为： 剩下的数据 size = " + i8});
            }
            if ((i + i2) - i6 > this.f18111z.length) {
                C2538c.c("OTATransferFile", new Object[]{"out of Index!!!"});
                length = this.f18111z.length - i;
            } else {
                length = i8;
            }
            if (length < 0) {
                C2538c.c("OTATransferFile", new Object[]{"偏移量大于文件长度"});
                if (this.f18104s != null) {
                    this.f18104s.a(104004, "传输异常");
                }
                this.f18083I = true;
                return;
            }
            int i9;
            Object obj;
            byte[] bArr = new byte[length];
            try {
                System.arraycopy(this.f18111z, i, bArr, 0, length);
            } catch (ArrayIndexOutOfBoundsException e) {
                C2538c.c("OTATransferFile", new Object[]{"ArrayIndexOutOfBoundsException = " + e.getMessage()});
            }
            if (i7 > 255) {
                i9 = 0;
            } else {
                i9 = i7;
            }
            if (list != null && i5 < list.size()) {
                C2538c.c("OTATransferFile", new Object[]{"check bitmap bitmapInfo.get(" + i5 + ") = " + list.get(i5)});
                if (((Integer) list.get(i5)).intValue() != 0) {
                    obj = null;
                    if (obj != null) {
                        m23941a(i9, bArr);
                        this.f18081G += length;
                        C2538c.c("OTATransferFile", new Object[]{"下发升级文件，序号 = " + i9 + "内容长度 = " + bArr.length + "ota_offset = " + i + "sended_length = " + i6});
                    }
                    i += i4;
                    i5++;
                    i6 += length;
                    i7 = i9 + 1;
                } else {
                    this.f18081G -= length;
                }
            }
            i8 = 1;
            if (obj != null) {
                m23941a(i9, bArr);
                this.f18081G += length;
                C2538c.c("OTATransferFile", new Object[]{"下发升级文件，序号 = " + i9 + "内容长度 = " + bArr.length + "ota_offset = " + i + "sended_length = " + i6});
            }
            i += i4;
            i5++;
            i6 += length;
            i7 = i9 + 1;
        }
        C2538c.c("OTATransferFile", new Object[]{"启动闲时等待超时"});
        if (this.f18109x == null) {
            this.f18108w = new HandlerThread("OTATransferFile");
            this.f18108w.start();
            this.f18109x = new C4997n(this, this.f18108w.getLooper());
            if (this.f18076B != 0) {
                this.f18109x.sendEmptyMessageDelayed(6, (long) this.f18076B);
            }
        } else if (this.f18076B != 0) {
            this.f18109x.sendEmptyMessageDelayed(6, (long) this.f18076B);
        }
    }

    private void m23941a(int i, byte[] bArr) {
        String a = C0973a.a(i);
        a = a + C0973a.a(bArr);
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(9);
        deviceCommand.setCommandID(4);
        deviceCommand.setDataContent(C0973a.b(a));
        deviceCommand.setDataLen(C0973a.b(a).length);
        m23979a(deviceCommand);
    }

    private void m23957c(byte[] bArr) {
        Object obj = new byte[(bArr.length - 2)];
        System.arraycopy(bArr, 2, obj, 0, obj.length);
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(9);
        deviceCommand.setCommandID(3);
        deviceCommand.setDataContent(obj);
        deviceCommand.setDataLen(obj.length);
        m23979a(deviceCommand);
    }

    private void m23961d(byte[] bArr) {
        int i = 0;
        if (this.f18083I) {
            C2538c.e("OTATransferFile", new Object[]{"OTA V2 Upgrade failed, do nothing."});
        } else if (bArr[i] == (byte) 9) {
            int i2;
            int length = bArr.length;
            int[] iArr = new int[length];
            for (i2 = i; i2 < length; i2++) {
                iArr[i2] = bArr[i2];
                if (iArr[i2] < 0) {
                    iArr[i2] = iArr[i2] + 256;
                }
            }
            if (3 == iArr[1]) {
                if (127 == iArr[2]) {
                    C2538c.c("OTATransferFile", new Object[]{"error,do nothing"});
                    return;
                }
                C2538c.c("OTATransferFile", new Object[]{"5.9.3设备数据申请主动上报"});
                if (this.f18078D) {
                    m23957c(bArr);
                }
                C5001d c5001d = new C5001d();
                try {
                    c5001d = this.f18084J.m24014d(bArr);
                } catch (Exception e) {
                    C2538c.c("OTATransferFile", new Object[]{"OTAV2NotificationMsg Error e = " + e.getMessage()});
                }
                m23945a(c5001d);
            } else if (5 == iArr[1]) {
                C2538c.c("OTATransferFile", new Object[]{"5.9.5升级包大小主动上报"});
                C5002e c5002e = new C5002e();
                try {
                    c5002e = this.f18084J.m24016e(bArr);
                } catch (Exception e2) {
                    C2538c.c("OTATransferFile", new Object[]{"Error e = " + e2.getMessage()});
                }
                m23946a(c5002e);
            } else if (6 == iArr[1]) {
                C2538c.c("OTATransferFile", new Object[]{"5.9.6升级包校验结果主动上报"});
                try {
                    i2 = this.f18084J.m24018f(bArr);
                } catch (Exception e3) {
                    C2538c.c("OTATransferFile", new Object[]{"Error e = " + e3.getMessage()});
                    i2 = i;
                }
                m23938a(i2);
            } else if (7 == iArr[1]) {
                C2538c.c("OTATransferFile", new Object[]{"5.9.7设备升级状态上报"});
                try {
                    i = this.f18084J.m24020g(bArr);
                } catch (Exception e32) {
                    C2538c.c("OTATransferFile", new Object[]{"Error e = " + e32.getMessage()});
                }
                m23952b(i);
            }
        } else if ((byte) 1 == bArr[i] && (byte) 17 == bArr[1]) {
            try {
                this.f18082H = this.f18084J.m24021h(bArr);
            } catch (Exception e322) {
                C2538c.e("OTATransferFile", new Object[]{"Error e = " + e322.getMessage()});
            }
            C2538c.c("OTATransferFile", new Object[]{"5.1.17 mSendInterval = " + this.f18082H});
        }
    }

    public void m23979a(DeviceCommand deviceCommand) {
        C2538c.c("OTATransferFile", new Object[]{"Enter sendDeviceData() with ServiceID = " + deviceCommand.getServiceID() + " CommandID = " + deviceCommand.getCommandID()});
        C4625b c4625b = new C4625b();
        ByteBuffer allocate = ByteBuffer.allocate(deviceCommand.getDataLen() + 2);
        allocate.put(C0973a.b(C0973a.a(deviceCommand.getServiceID())));
        allocate.put(C0973a.b(C0973a.a(deviceCommand.getCommandID())));
        if (deviceCommand.getDataContent() != null) {
            allocate.put(deviceCommand.getDataContent());
            C2538c.c("OTATransferFile", new Object[]{"command data = " + C0973a.a(deviceCommand.getDataContent())});
        } else {
            C2538c.e("OTATransferFile", new Object[]{"command data is null, if not OTA, data incorrect."});
        }
        allocate.flip();
        c4625b.m22111a(allocate.array());
        c4625b.m22108a(allocate.array().length);
        c4625b.m22110a(deviceCommand.getNeedAck());
        c4625b.m22113b(deviceCommand.getPriority());
        c4625b.m22109a(this.f18088b);
        c4625b.m22114b(deviceCommand.getNeedEncrypt());
        c4625b.m22119e(deviceCommand.getServiceID());
        c4625b.m22122f(deviceCommand.getCommandID());
        if (this.f18087a != null) {
            this.f18087a.a(c4625b);
        }
    }

    public void m23980a(String str, String str2, HWOTAParameter hWOTAParameter, int i, C0669b bVar) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || hWOTAParameter == null || bVar == null) {
            C2538c.e("OTATransferFile", new Object[]{"---startTransferOTAFile error, parameter is null---"});
            if (bVar != null) {
                bVar.a(109001, "参数非法");
                return;
            }
            return;
        }
        if (this.f18108w == null) {
            this.f18108w = new HandlerThread("OTATransferFile");
            this.f18108w.start();
            this.f18109x = new C4997n(this, this.f18108w.getLooper());
        }
        C2538c.c("OTATransferFile", new Object[]{" Enter transferOtaFile(), version-------" + str2});
        C2538c.c("OTATransferFile", new Object[]{" Enter transferOtaFile(), updateMode----" + i});
        C2538c.c("OTATransferFile", new Object[]{" Enter transferOtaFile(), filePath------" + str});
        this.f18096k = true;
        this.f18091f = str2;
        this.f18095j = 0;
        this.f18104s = bVar;
        this.f18102q = hWOTAParameter.getPackets_send_num();
        this.f18101p = hWOTAParameter.getTimeout();
        this.f18092g = hWOTAParameter.getPacket_send_size();
        C2538c.c("OTATransferFile", new Object[]{"sendOTAFileData,ota_send_num--------" + this.f18102q});
        C2538c.c("OTATransferFile", new Object[]{"sendOTAFileData,ota_timeout---------" + this.f18101p});
        C2538c.c("OTATransferFile", new Object[]{"sendOTAFileData,ota_send_size-------" + this.f18092g});
        m23963e(str);
        this.f18090e = 3;
        m23988c();
    }

    public void m23988c() {
        DeviceCommand deviceCommand = new DeviceCommand();
        String a = C0973a.a(4);
        String a2 = C0973a.a(2);
        a = a + a2 + (C0973a.a(7) + C0973a.a(1) + C0973a.a(2));
        deviceCommand.setDataContent(C0973a.b(a));
        deviceCommand.setDataLen(C0973a.b(a).length);
        m23953b(deviceCommand);
    }

    private boolean m23965e() {
        return this.f18103r;
    }

    private void m23963e(String str) {
        FileInputStream fileInputStream;
        IOException e;
        FileNotFoundException e2;
        Throwable th;
        if (m23983a(str)) {
            this.f18099n = new File(str);
            if (this.f18099n.exists()) {
                this.f18100o = (int) this.f18099n.length();
                this.f18094i = ((this.f18100o + this.f18092g) - 1) / this.f18092g;
                try {
                    fileInputStream = new FileInputStream(this.f18099n);
                    try {
                        this.f18093h = new byte[this.f18100o];
                        int read = fileInputStream.read(this.f18093h);
                        C2538c.b("OTATransferFile", new Object[]{"initOtaFile ret = " + read});
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                return;
                            } catch (IOException e3) {
                                C2538c.e("OTATransferFile", new Object[]{"IOException initOtaFile() finally e = ", e3.getMessage()});
                                return;
                            }
                        }
                        return;
                    } catch (FileNotFoundException e4) {
                        e2 = e4;
                        try {
                            if (this.f18096k && this.f18104s != null) {
                                this.f18104s.a(104003, "升级文件不存在 ");
                                this.f18095j = 0;
                                this.f18096k = false;
                            }
                            C2538c.e("OTATransferFile", new Object[]{"FileNotFoundException initOtaFile() e = ", e2.getMessage()});
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                    return;
                                } catch (IOException e32) {
                                    C2538c.e("OTATransferFile", new Object[]{"IOException initOtaFile() finally e = ", e32.getMessage()});
                                    return;
                                }
                            }
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e5) {
                                    C2538c.e("OTATransferFile", new Object[]{"IOException initOtaFile() finally e = ", e5.getMessage()});
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e6) {
                        e32 = e6;
                        if (this.f18096k && this.f18104s != null) {
                            this.f18104s.a(104004, "升级文件不存在 ");
                            this.f18095j = 0;
                            this.f18096k = false;
                        }
                        C2538c.e("OTATransferFile", new Object[]{"IOException initOtaFile() e = ", e32.getMessage()});
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                return;
                            } catch (IOException e322) {
                                C2538c.e("OTATransferFile", new Object[]{"IOException initOtaFile() finally e = ", e322.getMessage()});
                                return;
                            }
                        }
                        return;
                    }
                } catch (FileNotFoundException e7) {
                    e2 = e7;
                    fileInputStream = null;
                    this.f18104s.a(104003, "升级文件不存在 ");
                    this.f18095j = 0;
                    this.f18096k = false;
                    C2538c.e("OTATransferFile", new Object[]{"FileNotFoundException initOtaFile() e = ", e2.getMessage()});
                    if (fileInputStream != null) {
                        fileInputStream.close();
                        return;
                    }
                    return;
                } catch (IOException e8) {
                    e322 = e8;
                    fileInputStream = null;
                    this.f18104s.a(104004, "升级文件不存在 ");
                    this.f18095j = 0;
                    this.f18096k = false;
                    C2538c.e("OTATransferFile", new Object[]{"IOException initOtaFile() e = ", e322.getMessage()});
                    if (fileInputStream != null) {
                        fileInputStream.close();
                        return;
                    }
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = null;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            }
            C2538c.e("OTATransferFile", new Object[]{" Enter initOtaFile(),file not exists"});
            if (this.f18104s != null) {
                this.f18104s.a(104003, "升级文件不存在 ");
            }
            this.f18095j = 0;
            this.f18096k = false;
            return;
        }
        C2538c.e("OTATransferFile", new Object[]{"---initOtaFile() error, checkFilepath fail---"});
    }

    public byte[] m23984a(String str, int i, long j, int i2) {
        String a = C0973a.a(4);
        String a2 = C0973a.a(2);
        String str2 = C0973a.a(7) + C0973a.a(1) + C0973a.a(3);
        String str3 = C0973a.a(9) + C0973a.a(4) + C0973a.a((long) i);
        String toHexString = Long.toHexString(j);
        if (8 == toHexString.length()) {
            toHexString = toHexString.substring(4, 8) + toHexString.substring(0, 4);
        }
        toHexString = C0973a.a(10) + C0973a.a(toHexString.length() / 2) + toHexString;
        String e = C0973a.e(str);
        e = C0973a.a(22) + C0973a.a(e.length() / 2) + e;
        return C0973a.b(a + a2 + str2 + str3 + toHexString + e + (C0973a.a(21) + C0973a.a(1) + C0973a.a(i2)));
    }

    private void m23964e(byte[] bArr) {
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setDataContent(bArr);
        deviceCommand.setDataLen(bArr.length);
        m23953b(deviceCommand);
    }

    private void m23953b(DeviceCommand deviceCommand) {
        if (deviceCommand == null) {
            C2538c.e("OTATransferFile", new Object[]{"---otaBusinessCommand error, deviceCommand is null---"});
            return;
        }
        C2538c.c("OTATransferFile", new Object[]{"Enter otaBusinessCommand(), with data = " + C0973a.a(deviceCommand.getDataContent())});
        C4625b c4625b = new C4625b();
        c4625b.m22111a(deviceCommand.getDataContent());
        c4625b.m22108a(deviceCommand.getDataContent().length);
        c4625b.m22110a(deviceCommand.getNeedAck());
        c4625b.m22113b(deviceCommand.getPriority());
        c4625b.m22109a(this.f18088b);
        c4625b.m22114b(deviceCommand.getNeedEncrypt());
        c4625b.m22118d(2);
        if (this.f18087a != null) {
            this.f18087a.a(c4625b);
        }
        if (this.f18108w == null) {
            this.f18108w = new HandlerThread("OTATransferFile");
            this.f18108w.start();
            this.f18109x = new C4997n(this, this.f18108w.getLooper());
        }
        this.f18109x.sendEmptyMessageDelayed(7, (long) this.f18076B);
    }

    private void m23968f(byte[] bArr) {
        C2538c.c("OTATransferFile", new Object[]{"Enter writeBTFileData(),data = " + C0973a.a(bArr)});
        C4625b c4625b = new C4625b();
        c4625b.m22111a(bArr);
        c4625b.m22108a(bArr.length);
        c4625b.m22110a(m23965e());
        c4625b.m22113b(1);
        c4625b.m22109a(this.f18088b);
        c4625b.m22114b(false);
        c4625b.m22118d(3);
        if (this.f18087a != null) {
            this.f18087a.a(c4625b);
        }
    }

    private void m23942a(C4738c c4738c) {
        C2538c.c("OTATransferFile", new Object[]{"sendOTAFileData,ReceivedIndex()--------" + c4738c.m22667c()});
        C2538c.c("OTATransferFile", new Object[]{"sendOTAFileData,getPackageVersion------" + c4738c.m22665b()});
        C2538c.c("OTATransferFile", new Object[]{"sendOTAFileData,getPackageOffset()-----" + c4738c.m22659a()});
        List<Integer> d = c4738c.m22668d();
        if (d != null && d.size() > 0) {
            for (Integer num : d) {
                if (num.intValue() <= this.f18094i) {
                    this.f18097l.add(num);
                }
            }
        }
        byte[] bArr = null;
        int i;
        switch (this.f18090e) {
            case 1:
                if (this.f18091f.equals(c4738c.m22665b())) {
                    C2538c.c("OTATransferFile", new Object[]{"otaStatus.getPackageVersion. need breakpoint"});
                    C2538c.c("OTATransferFile", new Object[]{"getPackageReceivedIndex(),receivedIndex()=" + c4738c.m22667c()});
                    this.f18098m = (int) (c4738c.m22659a() / ((long) this.f18092g));
                    if (this.f18098m != c4738c.m22667c()) {
                        this.f18097l.clear();
                        this.f18098m = 0;
                        i = 0;
                    } else {
                        i = 1;
                    }
                } else {
                    C2538c.c("OTATransferFile", new Object[]{"mCurrentOtaVersion != otaStatus.getPackageVersion. don't need breakpoint,currentVersion=" + this.f18091f + ",otaStatus=" + c4738c.m22665b()});
                    if (this.f18097l.size() > 0) {
                        this.f18097l.clear();
                    }
                    this.f18098m = 0;
                    i = 0;
                }
                try {
                    bArr = m23984a(this.f18091f, this.f18100o, C4029b.m19826a(this.f18099n), i);
                } catch (IOException e) {
                    if (this.f18096k && this.f18104s != null) {
                        this.f18104s.a(104003, "升级文件不存在 ");
                        this.f18095j = 0;
                        this.f18096k = false;
                    }
                    C2538c.e("OTATransferFile", new Object[]{"Exception e = " + e.getMessage()});
                }
                C2538c.c("OTATransferFile", new Object[]{"OTA_MODE_AUTO:" + C0973a.a(bArr)});
                if (bArr == null) {
                    C2538c.e("OTATransferFile", new Object[]{"---data is null---"});
                    return;
                }
                m23964e(bArr);
                return;
            case 3:
                if (this.f18091f.equals(c4738c.m22665b())) {
                    C2538c.c("OTATransferFile", new Object[]{"mCurrentOtaVersion == otaStatus.getPackageVersion. need breakpoint"});
                    C2538c.c("OTATransferFile", new Object[]{"getPackageReceivedIndex(),receivedIndex()=" + c4738c.m22667c()});
                    this.f18098m = (int) (c4738c.m22659a() / ((long) this.f18092g));
                    if (this.f18098m != c4738c.m22667c()) {
                        this.f18097l.clear();
                        this.f18098m = 0;
                        i = 0;
                    } else {
                        i = 1;
                    }
                } else {
                    C2538c.c("OTATransferFile", new Object[]{"mCurrentOtaVersion != otaStatus.getPackageVersion. not need breakpoint,currentVersion=" + this.f18091f + ",getPackageVersion=" + c4738c.m22665b()});
                    if (this.f18097l.size() > 0) {
                        this.f18097l.clear();
                    }
                    this.f18098m = 0;
                    i = 0;
                }
                try {
                    bArr = m23984a(this.f18091f, this.f18100o, C4029b.m19826a(this.f18099n), i);
                } catch (IOException e2) {
                    if (this.f18096k && this.f18104s != null) {
                        this.f18104s.a(104003, "升级文件不存在 ");
                        this.f18095j = 0;
                        this.f18096k = false;
                    }
                    C2538c.e("OTATransferFile", new Object[]{"Exception e = " + e2.getMessage()});
                }
                C2538c.c("OTATransferFile", new Object[]{"OTA_MODE_TRANSFER:" + C0973a.a(bArr)});
                if (bArr != null) {
                    m23964e(bArr);
                    return;
                }
                return;
            case 5:
                if (this.f18097l.size() > 0) {
                    this.f18098m -= this.f18097l.size();
                    if (this.f18098m < 0) {
                        return;
                    }
                    int intValue;
                    if (1 == this.f18097l.size()) {
                        intValue = ((Integer) this.f18097l.get(0)).intValue();
                        this.f18097l.remove(0);
                        m23940a(intValue, true);
                        return;
                    }
                    C2538c.e("OTATransferFile", new Object[]{"OTA_MODE_ERROR_PACKAGE,mErrorPackages.size != 0 , mErrorPackages.size= " + this.f18097l.size()});
                    intValue = ((Integer) this.f18097l.get(0)).intValue();
                    this.f18097l.remove(0);
                    m23940a(intValue, false);
                    return;
                }
                m23940a(this.f18098m + 1, false);
                return;
            default:
                return;
        }
    }

    public void m23989d() {
        if (this.f18107v != null && this.f18105t != null && this.f18105t.m24053b() <= this.f18105t.m24050a()) {
            C2538c.e("OTATransferFile", new Object[]{"otaReportDisconnect, transfer error, bt disconnected..."});
            this.f18107v.mo4606a(104007, "传输文件蓝牙断开");
            this.f18107v = null;
            this.f18105t = null;
        }
    }

    public synchronized void m23978a(int i, byte[] bArr, C5008l c5008l, C4995c c4995c) {
        C5006j c5006j = new C5006j();
        this.f18107v = c4995c;
        this.f18105t = c5008l;
        ArrayList a = c5006j.m24046a(i, bArr, c5008l, c5008l.m24057d());
        C2538c.c("OTATransferFile", new Object[]{"Enter sendDfuFile(), mRawDfuFile = " + this.f18105t});
        if (a != null) {
            C4998a c4998a;
            this.f18106u.add(new C4998a(a));
            C2538c.c("OTATransferFile", new Object[]{" mDFUCmdBuffer size == " + this.f18106u.size()});
            if (this.f18106u.size() > 0) {
                c4998a = (C4998a) this.f18106u.get(0);
            } else {
                c4998a = null;
            }
            if (c4998a == null) {
                C2538c.c("OTATransferFile", new Object[]{" no dfu  cmdbuf to send."});
                if (this.f18107v != null) {
                    this.f18107v.mo4606a(104004, "传输文件异常");
                }
            } else if (c4998a.m24005b().size() <= c4998a.m24004a()) {
                this.f18106u.remove(0);
                if (this.f18107v != null) {
                    this.f18107v.mo4606a(104004, "传输文件异常");
                }
            } else {
                C2538c.c("OTATransferFile", new Object[]{" The Command to Send Is：HEX = " + C0973a.a((byte[]) c4998a.m24005b().get(c4998a.m24004a()))});
                if (c5008l.m24059e() || c5008l.m24053b() % this.f18102q == 0 || c5008l.m24053b() == c5008l.m24050a()) {
                    C2538c.e("OTATransferFile", new Object[]{"sendDfuFile mIsNeedACK, getPackage_index== " + c5008l.m24053b()});
                    this.f18103r = true;
                    m23968f((byte[]) c4998a.m24005b().get(c4998a.m24004a()));
                    if (this.f18109x != null) {
                        this.f18109x.sendEmptyMessageDelayed(3, (long) this.f18101p);
                    }
                } else {
                    C2538c.e("OTATransferFile", new Object[]{"not  NeedACK, getPackage_index = " + c5008l.m24053b()});
                    m23968f((byte[]) c4998a.m24005b().get(c4998a.m24004a()));
                    C2538c.c("OTATransferFile", new Object[]{"WRITE OVER"});
                    if (this.f18107v != null) {
                        this.f18106u.clear();
                        this.f18107v.mo4605a();
                    }
                }
            }
        }
    }

    private void m23940a(int i, boolean z) {
        C2538c.e("OTATransferFile", new Object[]{"startDfu, packageIndex = " + i + ",isNeedAcK = " + z});
        if (this.f18096k) {
            byte[] c = m23959c(i);
            if (c == null) {
                c.e("OTATransferFile", new Object[]{"startDfu, null == chunk"});
                return;
            }
            C5008l c5008l = new C5008l();
            c5008l.m24054b(i);
            c5008l.m24058d(this.f18092g);
            c5008l.m24056c(c.length);
            c5008l.m24051a(this.f18094i);
            c.c("OTATransferFile", new Object[]{"startDfu, mChunksTotal=" + this.f18094i});
            c5008l.m24052a(z);
            m23978a(c.length, c, c5008l, new C4996m(this));
            return;
        }
        C2538c.e("OTATransferFile", new Object[]{"mIsOTAState is false ,not OTA now"});
    }

    private byte[] m23959c(int i) {
        C2538c.c("OTATransferFile", new Object[]{"getPacketData, packageIndex = " + i});
        if (i < 0 || i > this.f18094i) {
            C2538c.e("OTATransferFile", new Object[]{"getPacketData, packageIndex < 0  or packageIndex > mChunksTotal"});
            return null;
        }
        int i2 = this.f18092g;
        if (i == this.f18094i) {
            if (this.f18100o % this.f18092g != 0) {
                i2 = this.f18100o % this.f18092g;
            }
            C2538c.c("OTATransferFile", new Object[]{"last package, size = " + i2});
        }
        C2538c.c("OTATransferFile", new Object[]{"getPacketData,size=" + i2});
        Object obj = new byte[i2];
        System.arraycopy(this.f18093h, (i - 1) * this.f18092g, obj, 0, i2);
        C2538c.c("OTATransferFile", new Object[]{"getPacketData , data = " + C0973a.a(obj)});
        return obj;
    }

    public boolean m23983a(String str) {
        if (str != null && str.indexOf("../") >= 0) {
            return false;
        }
        return true;
    }

    public void m23982a(byte[] bArr) {
        Object i;
        Exception e;
        C4992a c4992a;
        int[] iArr;
        C4992a c4992a2 = null;
        if (bArr == null) {
            C2538c.e("OTATransferFile", new Object[]{"---parseOTAReceivedData error ,data is null---"});
            return;
        }
        C2538c.c("OTATransferFile", new Object[]{"Enter parseOTAReceivedData data = " + C0973a.a(bArr)});
        C2538c.c("OTATransferFile", new Object[]{"parseOTAReceivedData mProductType = " + this.f18089c});
        if (5 == this.f18089c) {
            if (this.f18108w != null) {
                this.f18109x.removeMessages(7);
            }
            if ((byte) 4 == bArr[1]) {
                C4992a c4992a3;
                int i2 = bArr[3] & 128;
                int i3 = bArr[3];
                C2538c.c("OTATransferFile", new Object[]{"(data[3] & 0x80) = " + i2});
                if (i2 > 0) {
                    i3 = bArr[3] - 128;
                    if (i3 < 0) {
                        i3 += 256;
                    }
                }
                C2538c.c("OTATransferFile", new Object[]{"Current command is :" + i3});
                switch (i3) {
                    case 8:
                        m23972h(bArr);
                        c4992a3 = c4992a2;
                        break;
                    case 12:
                        C2538c.c("OTATransferFile", new Object[]{"enter switchOnlineType  ONLINE_PACKAGE_OFFSET"});
                        c4992a3 = this.f18085K;
                        i = m23974i(bArr);
                        break;
                    case 13:
                        c4992a3 = c4992a2;
                        break;
                    case 127:
                        try {
                            c4992a3 = this.f18086L;
                        } catch (Exception e2) {
                            e = e2;
                            c4992a = c4992a2;
                            C2538c.e("OTATransferFile", new Object[]{"Exception e = " + e.getMessage()});
                            c4992a3 = c4992a;
                            if (c4992a3 != null) {
                                C2538c.e("OTATransferFile", new Object[]{"---parseOTAReceivedData error, callback is null, command---" + i3});
                                return;
                            } else if (!this.f18110y) {
                                this.f18110y = false;
                                if (i == null) {
                                    iArr = (int[]) i;
                                    if (100000 == iArr[0]) {
                                        c4992a3.mo4603a(((int[]) i)[0], C4715d.m22592a(iArr[0]));
                                        return;
                                    } else if (1 == iArr.length) {
                                        c4992a3.mo4604a(C4715d.m22592a(100000));
                                        return;
                                    } else {
                                        c4992a3.mo4604a(iArr);
                                        return;
                                    }
                                }
                                return;
                            } else if (i == null) {
                                c4992a3.mo4603a(100001, HWDeviceDFXConstants.ERROR_CODE_INFO_UNKNOW);
                                return;
                            } else {
                                c4992a3.mo4604a(i);
                                return;
                            }
                        }
                        try {
                            this.f18110y = true;
                            i = m23987b(bArr);
                        } catch (Exception e3) {
                            Exception exception = e3;
                            c4992a = c4992a3;
                            e = exception;
                            C2538c.e("OTATransferFile", new Object[]{"Exception e = " + e.getMessage()});
                            c4992a3 = c4992a;
                            if (c4992a3 != null) {
                                C2538c.e("OTATransferFile", new Object[]{"---parseOTAReceivedData error, callback is null, command---" + i3});
                                return;
                            } else if (!this.f18110y) {
                                this.f18110y = false;
                                if (i == null) {
                                    iArr = (int[]) i;
                                    if (100000 == iArr[0]) {
                                        c4992a3.mo4603a(((int[]) i)[0], C4715d.m22592a(iArr[0]));
                                        return;
                                    } else if (1 == iArr.length) {
                                        c4992a3.mo4604a(iArr);
                                        return;
                                    } else {
                                        c4992a3.mo4604a(C4715d.m22592a(100000));
                                        return;
                                    }
                                }
                                return;
                            } else if (i == null) {
                                c4992a3.mo4604a(i);
                                return;
                            } else {
                                c4992a3.mo4603a(100001, HWDeviceDFXConstants.ERROR_CODE_INFO_UNKNOW);
                                return;
                            }
                        }
                    default:
                        c4992a3 = c4992a2;
                        break;
                }
                if (c4992a3 != null) {
                    C2538c.e("OTATransferFile", new Object[]{"---parseOTAReceivedData error, callback is null, command---" + i3});
                    return;
                } else if (!this.f18110y) {
                    this.f18110y = false;
                    if (i == null) {
                        iArr = (int[]) i;
                        if (100000 == iArr[0]) {
                            c4992a3.mo4603a(((int[]) i)[0], C4715d.m22592a(iArr[0]));
                            return;
                        } else if (1 == iArr.length) {
                            c4992a3.mo4604a(C4715d.m22592a(100000));
                            return;
                        } else {
                            c4992a3.mo4604a(iArr);
                            return;
                        }
                    }
                    return;
                } else if (i == null) {
                    c4992a3.mo4603a(100001, HWDeviceDFXConstants.ERROR_CODE_INFO_UNKNOW);
                    return;
                } else {
                    c4992a3.mo4604a(i);
                    return;
                }
            }
            m23970g(bArr);
            return;
        }
        m23961d(bArr);
    }

    private void m23970g(byte[] bArr) {
        String a = C0973a.a(bArr);
        C2538c.c("OTATransferFile", new Object[]{"parseOTAFileData(), responseHex = " + a + ", mProductType = " + this.f18089c});
        if (a.contains("AA0100496C")) {
            a = a.replace("AA0100496C", "");
            if (a.length() != 0) {
                bArr = C0973a.b(a);
            }
        }
        a = C0973a.a(bArr);
        if (this.f18107v == null) {
            return;
        }
        if (!a.startsWith("cc") && !a.startsWith("CC")) {
            return;
        }
        if (!this.f18103r || this.f18109x == null) {
            C2538c.e("OTATransferFile", new Object[]{"waiting ack is time out, return"});
            return;
        }
        this.f18103r = false;
        this.f18109x.removeMessages(3);
        C2538c.e("OTATransferFile", new Object[]{"need ACK_DFU : " + a});
        this.f18106u.clear();
        this.f18107v.mo4608a(bArr);
    }

    private void m23972h(byte[] bArr) {
        C2538c.c("OTATransferFile", new Object[]{"packageValidity enter..."});
        if ((byte) 0 == bArr[2]) {
            C2538c.c("OTATransferFile", new Object[]{"onDataReceived,notification,data=" + C0973a.a(bArr)});
            if (this.f18107v != null) {
                this.f18107v.mo4607a(Byte.valueOf(bArr[5]));
                this.f18107v = null;
                this.f18105t = null;
                C2538c.c("OTATransferFile", new Object[]{"packageValidity success..."});
            }
        }
    }

    private C4738c m23974i(byte[] bArr) throws Exception {
        C4738c c4738c;
        C2538c.c("OTATransferFile", new Object[]{"enter unGetOtaStatus   "});
        String a = C0973a.a(bArr);
        C4754u b = m23985b(a.substring(6, a.length()));
        C4738c c4738c2 = new C4738c();
        List<C4752s> list = b.f17337a;
        if (list.size() > 0) {
            C4738c c4738c3 = new C4738c();
            int i = 0;
            for (C4752s c4752s : list) {
                C4752s c4752s2;
                int i2;
                int parseInt = Integer.parseInt(c4752s2.m22732a(), 16);
                a = c4752s2.m22733b();
                switch (parseInt) {
                    case 12:
                        c4738c3.m22661a(Long.parseLong(a, 16));
                        i2 = i;
                        break;
                    case 22:
                        c4738c3.m22663a(C0973a.c(a));
                        i2 = i;
                        break;
                    case 23:
                        i = Integer.parseInt(a, 16);
                        c4738c3.m22660a(i);
                        i2 = i;
                        break;
                    case 24:
                        c4738c3.m22664a(m23937a(i, a));
                        i2 = i;
                        break;
                    default:
                        i2 = i;
                        break;
                }
                i = i2;
            }
            c4738c = c4738c3;
        } else {
            c4738c = c4738c2;
        }
        List list2 = b.f17338b;
        List arrayList = new ArrayList();
        C4745l c4745l = new C4745l();
        for (int i3 = 0; i3 < list2.size(); i3++) {
            C4754u c4754u = (C4754u) list2.get(i3);
            C4745l c4745l2 = new C4745l();
            List list3 = c4754u.f17337a;
            for (int i4 = 0; i4 < list3.size(); i4++) {
                c4752s2 = (C4752s) list3.get(i4);
                switch (Integer.parseInt(c4752s2.m22732a(), 16)) {
                    case 31:
                        c4745l.m22705a(Integer.parseInt(c4752s2.m22733b(), 16));
                        break;
                    case 32:
                        c4745l.m22706b(Integer.parseInt(c4752s2.m22733b(), 16));
                        break;
                    case 34:
                        c4745l2.m22705a(Integer.parseInt(c4752s2.m22733b(), 16));
                        break;
                    case 35:
                        c4745l2.m22706b(Integer.parseInt(c4752s2.m22733b(), 16));
                        arrayList.add(c4745l2);
                        break;
                    default:
                        break;
                }
            }
        }
        c4738c.m22666b(arrayList);
        c4738c.m22662a(c4745l);
        return c4738c;
    }

    private List<Integer> m23937a(int i, String str) {
        List<Integer> arrayList = new ArrayList();
        if (i == 0) {
            C2538c.e("OTATransferFile", new Object[]{"parseAck , received_index == 0 "});
            return arrayList;
        }
        int i2;
        byte[] b = C0973a.b(str);
        StringBuilder stringBuilder = new StringBuilder("");
        for (byte a : b) {
            stringBuilder.append(new StringBuffer(C4991j.m23936a(a)).reverse().toString());
        }
        String stringBuilder2 = stringBuilder.toString();
        C2538c.c("OTATransferFile", new Object[]{"parseAck, bufferStr = " + stringBuilder2});
        for (i2 = 0; i2 < stringBuilder2.length(); i2++) {
            if ("0".equalsIgnoreCase(stringBuilder2.charAt(i2) + "")) {
                if (i % this.f18102q == 0) {
                    arrayList.add(Integer.valueOf(((i2 + 1) + i) - this.f18102q));
                    C2538c.e("OTATransferFile", new Object[]{"mErrorPackages, package_index = " + r4});
                } else {
                    arrayList.add(Integer.valueOf(((i / this.f18102q) * this.f18102q) + (i2 + 1)));
                    C2538c.e("OTATransferFile", new Object[]{"mErrorPackages, package_index = " + r4});
                }
            }
        }
        return arrayList;
    }

    public static String m23936a(byte b) {
        return "" + ((byte) ((b >> 7) & 1)) + ((byte) ((b >> 6) & 1)) + ((byte) ((b >> 5) & 1)) + ((byte) ((b >> 4) & 1)) + ((byte) ((b >> 3) & 1)) + ((byte) ((b >> 2) & 1)) + ((byte) ((b >> 1) & 1)) + ((byte) ((b >> 0) & 1));
    }

    public int[] m23987b(byte[] bArr) throws Exception {
        C2538c.c("OTATransferFile", new Object[]{"Enter getErrorCode()"});
        String a = C0973a.a(bArr);
        C2538c.c("OTATransferFile", new Object[]{"Error Code:" + C4991j.m23949a(m23985b(a.substring(6, a.length())))[0]});
        return C4991j.m23949a(m23985b(a.substring(6, a.length())));
    }

    public static int[] m23949a(C4754u c4754u) {
        List list = c4754u.f17337a;
        int size = list.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            String b = ((C4752s) list.get(i)).m22733b();
            switch (Integer.parseInt(((C4752s) list.get(i)).m22732a(), 16)) {
                case 19:
                    if (iArr.length <= 1) {
                        break;
                    }
                    iArr[1] = Integer.parseInt(b, 16);
                    break;
                case 127:
                    if (iArr.length <= 0) {
                        break;
                    }
                    iArr[0] = Integer.parseInt(b, 16);
                    break;
                default:
                    break;
            }
        }
        return iArr;
    }

    public C4754u m23985b(String str) throws Exception {
        C4754u c4754u = new C4754u();
        int i = 0;
        while (i != str.length()) {
            String substring = str.substring(i, i + 2);
            C5005i a = m23934a(str, i + substring.length());
            int a2 = a.m24042a();
            i = a.m24043b();
            String str2 = "";
            if (a2 == 0) {
                C2538c.c("OTATransferFile", new Object[]{"TLVUtils", "_vl = 0"});
                c4754u.m22734a().add(new C4752s(substring, a2, str2));
            } else if ((a2 * 2) + i > str.length()) {
                throw new Exception();
            } else {
                str2 = str.substring(i, (a2 * 2) + i);
                i += str2.length();
                if ((Integer.parseInt(substring, 16) >>> 7) == 1) {
                    c4754u.m22735b().add(m23985b(str2));
                } else {
                    c4754u.m22734a().add(new C4752s(substring, a2, str2));
                }
            }
        }
        return c4754u;
    }

    private C5005i m23934a(String str, int i) throws Exception {
        int i2 = 0;
        int i3 = 0;
        int parseInt = Integer.parseInt(str.substring(i, i + 2), 16);
        int i4 = 0;
        while (((parseInt >>> 7) & 1) == 1) {
            if (i2 < 4) {
                i += 2;
                parseInt &= 127;
                switch (i2) {
                    case 0:
                        break;
                    case 1:
                        i4 = parseInt;
                        parseInt = i3;
                        break;
                    default:
                        parseInt = i3;
                        break;
                }
                i2++;
                i3 = parseInt;
                parseInt = Integer.parseInt(str.substring(i, i + 2), 16);
            } else {
                throw new Exception();
            }
        }
        if (2 == i2) {
            i4 = ((i4 * 128) + (i3 * 16384)) + parseInt;
        } else if (1 == i2) {
            i4 = (i3 * 128) + parseInt;
        } else {
            i4 = 0 + parseInt;
        }
        return new C5005i(i4, i + 2);
    }
}
