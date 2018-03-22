package com.huawei.hwdevicedfxmanager.utils;

import android.util.Log;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdataaccessmodel.sharedpreference.a;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MaintenanceUtil implements MaintenaceInterface {
    public static final int LOG_BT_DEBUG = 4;
    public static final int LOG_LEVEL_ALL = 0;
    public static final int LOG_LEVEL_DEBUG = 2;
    public static final int LOG_LEVEL_DUMP = 3;
    public static final int LOG_LEVEL_EVENT = 1;
    public static final int LOG_MCU_DEBUG = 5;
    public static final String LOG_PATH = (BaseApplication.b().getFilesDir().getAbsolutePath() + "/log/com.huawei.bone/MaintenanceLog");
    public static final String LOG_PATH_TEMP = (BaseApplication.b().getFilesDir().getAbsolutePath() + "/log/com.huawei.bone/MaintenanceLogTemp");
    private static final String MAINT_KEY_CHECK_TIME = "MAINT_KEY_CHECK_TIME";
    private static final String MAINT_KEY_RESULT = "MAINT_KEY_RESULT";
    private static final String MAINT_KEY_RETRY_TIME = "MAINT_KEY_RETRY_TIME";
    private static final int MAX_DATA_SIZE = 200000;
    private static final String TAG = "MaintenanceUtil";
    private static MaintenanceUtil instance = null;
    private ByteBuffer buff;
    private Queue<byte[]> catchLogs = new ConcurrentLinkedQueue();
    private long dataSize = 0;
    private String deviceMac = "";
    private int deviceType = 7;
    private String deviceVersion = "";
    Executor executor = Executors.newSingleThreadExecutor();
    private FileChannel fc;
    private String fileName = "";
    private FileOutputStream fileOutputStream;
    private boolean isWrite = false;
    private LogThread logThread = null;
    private IBaseResponseCallback mCallback;
    private Date mDate = null;
    final ArrayList<byte[]> maintLogs2 = new ArrayList();
    private Queue<byte[]> queLogs = new ConcurrentLinkedQueue();
    private Date tmpDate = null;
    private String tmpFileName = "";

    class C49801 implements Runnable {
        C49801() {
        }

        public void run() {
            MaintenanceUtil.this.writeLog(MaintenanceUtil.this.tmpDate, MaintenanceUtil.this.maintLogs2, MaintenanceUtil.this.tmpFileName);
        }
    }

    public void cutFolder(java.lang.String r14, java.lang.String r15) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:135:0x01f5
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.modifyBlocksTree(BlockProcessor.java:248)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r13 = this;
        r0 = "MaintenanceUtil";
        r1 = 1;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "cutFolder old ";
        r3 = r3.append(r4);
        r3 = r3.append(r14);
        r4 = " newPath: ";
        r3 = r3.append(r4);
        r3 = r3.append(r15);
        r3 = r3.toString();
        r1[r2] = r3;
        com.huawei.v.c.c(r0, r1);
        r6 = new java.io.File;
        r6.<init>(r14);
        r0 = r6.exists();
        if (r0 != 0) goto L_0x0041;
    L_0x0033:
        r0 = "MaintenanceUtil";
        r1 = 1;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r3 = "cutFolder old file is not exists";
        r1[r2] = r3;
        com.huawei.v.c.c(r0, r1);
    L_0x0040:
        return;
    L_0x0041:
        r0 = new java.io.File;
        r0.<init>(r15);
        r1 = r0.exists();
        if (r1 != 0) goto L_0x0070;
    L_0x004c:
        r1 = r0.mkdirs();
        r2 = "MaintenanceUtil";
        r3 = 4;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = "newFile.mkdirs result = ";
        r3[r4] = r5;
        r4 = 1;
        r1 = java.lang.Boolean.valueOf(r1);
        r3[r4] = r1;
        r1 = 2;
        r4 = ", newFile path = ";
        r3[r1] = r4;
        r1 = 3;
        r0 = r0.getAbsolutePath();
        r3[r1] = r0;
        com.huawei.v.c.c(r2, r3);
    L_0x0070:
        r7 = r6.list();
        if (r7 != 0) goto L_0x0084;
    L_0x0076:
        r0 = "MaintenanceUtil";
        r1 = 1;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r3 = "cutFolder old file list = null";
        r1[r2] = r3;
        com.huawei.v.c.c(r0, r1);
        goto L_0x0040;
    L_0x0084:
        r0 = 0;
        r1 = r0;
    L_0x0086:
        r0 = r7.length;
        if (r1 >= r0) goto L_0x0040;
    L_0x0089:
        r0 = java.io.File.separator;
        r0 = r14.endsWith(r0);
        if (r0 == 0) goto L_0x0186;
    L_0x0091:
        r0 = new java.io.File;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2 = r2.append(r14);
        r3 = r7[r1];
        r2 = r2.append(r3);
        r2 = r2.toString();
        r0.<init>(r2);
    L_0x00a9:
        r2 = r0.isFile();
        if (r2 == 0) goto L_0x034d;
    L_0x00af:
        r2 = r0.exists();
        if (r2 == 0) goto L_0x034d;
    L_0x00b5:
        r3 = 0;
        r4 = 0;
        r5 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x039d, all -> 0x0390 }
        r5.<init>(r0);	 Catch:{ IOException -> 0x039d, all -> 0x0390 }
        r3 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x03a3, all -> 0x0395 }
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x03a3, all -> 0x0395 }
        r2.<init>();	 Catch:{ IOException -> 0x03a3, all -> 0x0395 }
        r2 = r2.append(r15);	 Catch:{ IOException -> 0x03a3, all -> 0x0395 }
        r8 = java.io.File.separator;	 Catch:{ IOException -> 0x03a3, all -> 0x0395 }
        r2 = r2.append(r8);	 Catch:{ IOException -> 0x03a3, all -> 0x0395 }
        r8 = r0.getName();	 Catch:{ IOException -> 0x03a3, all -> 0x0395 }
        r2 = r2.append(r8);	 Catch:{ IOException -> 0x03a3, all -> 0x0395 }
        r2 = r2.toString();	 Catch:{ IOException -> 0x03a3, all -> 0x0395 }
        r3.<init>(r2);	 Catch:{ IOException -> 0x03a3, all -> 0x0395 }
        r2 = 5120; // 0x1400 float:7.175E-42 double:2.5296E-320;
        r2 = new byte[r2];	 Catch:{ IOException -> 0x01b1, all -> 0x01f5 }
    L_0x00e0:
        r4 = r5.read(r2);	 Catch:{ IOException -> 0x00ec, all -> 0x01ed }
        r8 = -1;	 Catch:{ IOException -> 0x00ec, all -> 0x01ed }
        if (r4 == r8) goto L_0x01a6;	 Catch:{ IOException -> 0x00ec, all -> 0x01ed }
    L_0x00e7:
        r8 = 0;	 Catch:{ IOException -> 0x00ec, all -> 0x01ed }
        r3.write(r2, r8, r4);	 Catch:{ IOException -> 0x00ec, all -> 0x01ed }
        goto L_0x00e0;
    L_0x00ec:
        r2 = move-exception;
        r4 = "MaintenanceUtil";	 Catch:{ IOException -> 0x00ec, all -> 0x01ed }
        r8 = 1;	 Catch:{ IOException -> 0x00ec, all -> 0x01ed }
        r8 = new java.lang.Object[r8];	 Catch:{ IOException -> 0x00ec, all -> 0x01ed }
        r9 = 0;	 Catch:{ IOException -> 0x00ec, all -> 0x01ed }
        r10 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00ec, all -> 0x01ed }
        r10.<init>();	 Catch:{ IOException -> 0x00ec, all -> 0x01ed }
        r11 = "copy crashLog failed";	 Catch:{ IOException -> 0x00ec, all -> 0x01ed }
        r10 = r10.append(r11);	 Catch:{ IOException -> 0x00ec, all -> 0x01ed }
        r2 = r2.getMessage();	 Catch:{ IOException -> 0x00ec, all -> 0x01ed }
        r2 = r10.append(r2);	 Catch:{ IOException -> 0x00ec, all -> 0x01ed }
        r2 = r2.toString();	 Catch:{ IOException -> 0x00ec, all -> 0x01ed }
        r8[r9] = r2;	 Catch:{ IOException -> 0x00ec, all -> 0x01ed }
        com.huawei.v.c.e(r4, r8);	 Catch:{ IOException -> 0x00ec, all -> 0x01ed }
        r3.close();
        r5.close();
    L_0x0115:
        if (r5 == 0) goto L_0x011a;
    L_0x0117:
        r5.close();	 Catch:{ IOException -> 0x021b, all -> 0x023f }
    L_0x011a:
        r2 = "MaintenanceUtil";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r8 = "copyFolder input close finally";
        r4[r5] = r8;
        com.huawei.v.c.e(r2, r4);
    L_0x0127:
        if (r3 == 0) goto L_0x012c;
    L_0x0129:
        r3.close();	 Catch:{ IOException -> 0x024e, all -> 0x0272 }
    L_0x012c:
        r2 = "MaintenanceUtil";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = "copyFolder output close finally";
        r3[r4] = r5;
        com.huawei.v.c.e(r2, r3);
    L_0x0139:
        r2 = r0.delete();
        r3 = "MaintenanceUtil";
        r4 = 4;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r8 = "deleteFolder file name = ";
        r4[r5] = r8;
        r5 = 1;
        r0 = r0.getAbsolutePath();
        r4[r5] = r0;
        r0 = 2;
        r5 = ", result = ";
        r4[r0] = r5;
        r0 = 3;
        r2 = java.lang.Boolean.valueOf(r2);
        r4[r0] = r2;
        com.huawei.v.c.c(r3, r4);
    L_0x015d:
        r0 = r6.delete();
        r2 = "MaintenanceUtil";
        r3 = 4;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = "deleteFolder file name = ";
        r3[r4] = r5;
        r4 = 1;
        r5 = r6.getAbsolutePath();
        r3[r4] = r5;
        r4 = 2;
        r5 = ", result = ";
        r3[r4] = r5;
        r4 = 3;
        r0 = java.lang.Boolean.valueOf(r0);
        r3[r4] = r0;
        com.huawei.v.c.c(r2, r3);
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0086;
    L_0x0186:
        r0 = new java.io.File;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2 = r2.append(r14);
        r3 = java.io.File.separator;
        r2 = r2.append(r3);
        r3 = r7[r1];
        r2 = r2.append(r3);
        r2 = r2.toString();
        r0.<init>(r2);
        goto L_0x00a9;
    L_0x01a6:
        r3.flush();	 Catch:{ IOException -> 0x00ec, all -> 0x01ed }
        r3.close();
        r5.close();
        goto L_0x0115;
    L_0x01b1:
        r2 = move-exception;
        r4 = r5;
    L_0x01b3:
        r5 = "MaintenanceUtil";	 Catch:{ all -> 0x0399 }
        r8 = 2;	 Catch:{ all -> 0x0399 }
        r8 = new java.lang.Object[r8];	 Catch:{ all -> 0x0399 }
        r9 = 0;	 Catch:{ all -> 0x0399 }
        r10 = "copyFolder e = ";	 Catch:{ all -> 0x0399 }
        r8[r9] = r10;	 Catch:{ all -> 0x0399 }
        r9 = 1;	 Catch:{ all -> 0x0399 }
        r2 = r2.getMessage();	 Catch:{ all -> 0x0399 }
        r8[r9] = r2;	 Catch:{ all -> 0x0399 }
        com.huawei.v.c.e(r5, r8);	 Catch:{ all -> 0x0399 }
        if (r4 == 0) goto L_0x01cc;
    L_0x01c9:
        r4.close();	 Catch:{ IOException -> 0x0281, all -> 0x02a5 }
    L_0x01cc:
        r2 = "MaintenanceUtil";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r8 = "copyFolder input close finally";
        r4[r5] = r8;
        com.huawei.v.c.e(r2, r4);
    L_0x01d9:
        if (r3 == 0) goto L_0x01de;
    L_0x01db:
        r3.close();	 Catch:{ IOException -> 0x02b4, all -> 0x02d8 }
    L_0x01de:
        r2 = "MaintenanceUtil";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = "copyFolder output close finally";
        r3[r4] = r5;
        com.huawei.v.c.e(r2, r3);
        goto L_0x0139;
    L_0x01ed:
        r2 = move-exception;
        r3.close();	 Catch:{ IOException -> 0x01b1, all -> 0x01f5 }
        r5.close();	 Catch:{ IOException -> 0x01b1, all -> 0x01f5 }
        throw r2;	 Catch:{ IOException -> 0x01b1, all -> 0x01f5 }
    L_0x01f5:
        r0 = move-exception;
    L_0x01f6:
        if (r5 == 0) goto L_0x01fb;
    L_0x01f8:
        r5.close();	 Catch:{ IOException -> 0x02e7, all -> 0x030b }
    L_0x01fb:
        r1 = "MaintenanceUtil";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r4 = 0;
        r5 = "copyFolder input close finally";
        r2[r4] = r5;
        com.huawei.v.c.e(r1, r2);
    L_0x0208:
        if (r3 == 0) goto L_0x020d;
    L_0x020a:
        r3.close();	 Catch:{ IOException -> 0x031a, all -> 0x033e }
    L_0x020d:
        r1 = "MaintenanceUtil";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = "copyFolder output close finally";
        r2[r3] = r4;
        com.huawei.v.c.e(r1, r2);
    L_0x021a:
        throw r0;
    L_0x021b:
        r2 = move-exception;
        r4 = "MaintenanceUtil";	 Catch:{ IOException -> 0x021b, all -> 0x023f }
        r5 = 2;	 Catch:{ IOException -> 0x021b, all -> 0x023f }
        r5 = new java.lang.Object[r5];	 Catch:{ IOException -> 0x021b, all -> 0x023f }
        r8 = 0;	 Catch:{ IOException -> 0x021b, all -> 0x023f }
        r9 = "copyFolder input close e = ";	 Catch:{ IOException -> 0x021b, all -> 0x023f }
        r5[r8] = r9;	 Catch:{ IOException -> 0x021b, all -> 0x023f }
        r8 = 1;	 Catch:{ IOException -> 0x021b, all -> 0x023f }
        r2 = r2.getMessage();	 Catch:{ IOException -> 0x021b, all -> 0x023f }
        r5[r8] = r2;	 Catch:{ IOException -> 0x021b, all -> 0x023f }
        com.huawei.v.c.e(r4, r5);	 Catch:{ IOException -> 0x021b, all -> 0x023f }
        r2 = "MaintenanceUtil";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r8 = "copyFolder input close finally";
        r4[r5] = r8;
        com.huawei.v.c.e(r2, r4);
        goto L_0x0127;
    L_0x023f:
        r0 = move-exception;
        r1 = "MaintenanceUtil";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = "copyFolder input close finally";
        r2[r3] = r4;
        com.huawei.v.c.e(r1, r2);
        throw r0;
    L_0x024e:
        r2 = move-exception;
        r3 = "MaintenanceUtil";	 Catch:{ IOException -> 0x024e, all -> 0x0272 }
        r4 = 2;	 Catch:{ IOException -> 0x024e, all -> 0x0272 }
        r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x024e, all -> 0x0272 }
        r5 = 0;	 Catch:{ IOException -> 0x024e, all -> 0x0272 }
        r8 = "copyFolder output close e = ";	 Catch:{ IOException -> 0x024e, all -> 0x0272 }
        r4[r5] = r8;	 Catch:{ IOException -> 0x024e, all -> 0x0272 }
        r5 = 1;	 Catch:{ IOException -> 0x024e, all -> 0x0272 }
        r2 = r2.getMessage();	 Catch:{ IOException -> 0x024e, all -> 0x0272 }
        r4[r5] = r2;	 Catch:{ IOException -> 0x024e, all -> 0x0272 }
        com.huawei.v.c.e(r3, r4);	 Catch:{ IOException -> 0x024e, all -> 0x0272 }
        r2 = "MaintenanceUtil";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = "copyFolder output close finally";
        r3[r4] = r5;
        com.huawei.v.c.e(r2, r3);
        goto L_0x0139;
    L_0x0272:
        r0 = move-exception;
        r1 = "MaintenanceUtil";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = "copyFolder output close finally";
        r2[r3] = r4;
        com.huawei.v.c.e(r1, r2);
        throw r0;
    L_0x0281:
        r2 = move-exception;
        r4 = "MaintenanceUtil";	 Catch:{ IOException -> 0x0281, all -> 0x02a5 }
        r5 = 2;	 Catch:{ IOException -> 0x0281, all -> 0x02a5 }
        r5 = new java.lang.Object[r5];	 Catch:{ IOException -> 0x0281, all -> 0x02a5 }
        r8 = 0;	 Catch:{ IOException -> 0x0281, all -> 0x02a5 }
        r9 = "copyFolder input close e = ";	 Catch:{ IOException -> 0x0281, all -> 0x02a5 }
        r5[r8] = r9;	 Catch:{ IOException -> 0x0281, all -> 0x02a5 }
        r8 = 1;	 Catch:{ IOException -> 0x0281, all -> 0x02a5 }
        r2 = r2.getMessage();	 Catch:{ IOException -> 0x0281, all -> 0x02a5 }
        r5[r8] = r2;	 Catch:{ IOException -> 0x0281, all -> 0x02a5 }
        com.huawei.v.c.e(r4, r5);	 Catch:{ IOException -> 0x0281, all -> 0x02a5 }
        r2 = "MaintenanceUtil";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r8 = "copyFolder input close finally";
        r4[r5] = r8;
        com.huawei.v.c.e(r2, r4);
        goto L_0x01d9;
    L_0x02a5:
        r0 = move-exception;
        r1 = "MaintenanceUtil";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = "copyFolder input close finally";
        r2[r3] = r4;
        com.huawei.v.c.e(r1, r2);
        throw r0;
    L_0x02b4:
        r2 = move-exception;
        r3 = "MaintenanceUtil";	 Catch:{ IOException -> 0x02b4, all -> 0x02d8 }
        r4 = 2;	 Catch:{ IOException -> 0x02b4, all -> 0x02d8 }
        r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x02b4, all -> 0x02d8 }
        r5 = 0;	 Catch:{ IOException -> 0x02b4, all -> 0x02d8 }
        r8 = "copyFolder output close e = ";	 Catch:{ IOException -> 0x02b4, all -> 0x02d8 }
        r4[r5] = r8;	 Catch:{ IOException -> 0x02b4, all -> 0x02d8 }
        r5 = 1;	 Catch:{ IOException -> 0x02b4, all -> 0x02d8 }
        r2 = r2.getMessage();	 Catch:{ IOException -> 0x02b4, all -> 0x02d8 }
        r4[r5] = r2;	 Catch:{ IOException -> 0x02b4, all -> 0x02d8 }
        com.huawei.v.c.e(r3, r4);	 Catch:{ IOException -> 0x02b4, all -> 0x02d8 }
        r2 = "MaintenanceUtil";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = "copyFolder output close finally";
        r3[r4] = r5;
        com.huawei.v.c.e(r2, r3);
        goto L_0x0139;
    L_0x02d8:
        r0 = move-exception;
        r1 = "MaintenanceUtil";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = "copyFolder output close finally";
        r2[r3] = r4;
        com.huawei.v.c.e(r1, r2);
        throw r0;
    L_0x02e7:
        r1 = move-exception;
        r2 = "MaintenanceUtil";	 Catch:{ IOException -> 0x02e7, all -> 0x030b }
        r4 = 2;	 Catch:{ IOException -> 0x02e7, all -> 0x030b }
        r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x02e7, all -> 0x030b }
        r5 = 0;	 Catch:{ IOException -> 0x02e7, all -> 0x030b }
        r6 = "copyFolder input close e = ";	 Catch:{ IOException -> 0x02e7, all -> 0x030b }
        r4[r5] = r6;	 Catch:{ IOException -> 0x02e7, all -> 0x030b }
        r5 = 1;	 Catch:{ IOException -> 0x02e7, all -> 0x030b }
        r1 = r1.getMessage();	 Catch:{ IOException -> 0x02e7, all -> 0x030b }
        r4[r5] = r1;	 Catch:{ IOException -> 0x02e7, all -> 0x030b }
        com.huawei.v.c.e(r2, r4);	 Catch:{ IOException -> 0x02e7, all -> 0x030b }
        r1 = "MaintenanceUtil";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r4 = 0;
        r5 = "copyFolder input close finally";
        r2[r4] = r5;
        com.huawei.v.c.e(r1, r2);
        goto L_0x0208;
    L_0x030b:
        r0 = move-exception;
        r1 = "MaintenanceUtil";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = "copyFolder input close finally";
        r2[r3] = r4;
        com.huawei.v.c.e(r1, r2);
        throw r0;
    L_0x031a:
        r1 = move-exception;
        r2 = "MaintenanceUtil";	 Catch:{ IOException -> 0x031a, all -> 0x033e }
        r3 = 2;	 Catch:{ IOException -> 0x031a, all -> 0x033e }
        r3 = new java.lang.Object[r3];	 Catch:{ IOException -> 0x031a, all -> 0x033e }
        r4 = 0;	 Catch:{ IOException -> 0x031a, all -> 0x033e }
        r5 = "copyFolder output close e = ";	 Catch:{ IOException -> 0x031a, all -> 0x033e }
        r3[r4] = r5;	 Catch:{ IOException -> 0x031a, all -> 0x033e }
        r4 = 1;	 Catch:{ IOException -> 0x031a, all -> 0x033e }
        r1 = r1.getMessage();	 Catch:{ IOException -> 0x031a, all -> 0x033e }
        r3[r4] = r1;	 Catch:{ IOException -> 0x031a, all -> 0x033e }
        com.huawei.v.c.e(r2, r3);	 Catch:{ IOException -> 0x031a, all -> 0x033e }
        r1 = "MaintenanceUtil";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = "copyFolder output close finally";
        r2[r3] = r4;
        com.huawei.v.c.e(r1, r2);
        goto L_0x021a;
    L_0x033e:
        r0 = move-exception;
        r1 = "MaintenanceUtil";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = "copyFolder output close finally";
        r2[r3] = r4;
        com.huawei.v.c.e(r1, r2);
        throw r0;
    L_0x034d:
        r2 = r0.isDirectory();
        if (r2 == 0) goto L_0x015d;
    L_0x0353:
        r0 = r0.exists();
        if (r0 == 0) goto L_0x015d;
    L_0x0359:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0 = r0.append(r14);
        r2 = java.io.File.separator;
        r0 = r0.append(r2);
        r2 = r7[r1];
        r0 = r0.append(r2);
        r0 = r0.toString();
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2 = r2.append(r15);
        r3 = java.io.File.separator;
        r2 = r2.append(r3);
        r3 = r7[r1];
        r2 = r2.append(r3);
        r2 = r2.toString();
        r13.cutFolder(r0, r2);
        goto L_0x015d;
    L_0x0390:
        r0 = move-exception;
        r5 = r3;
        r3 = r4;
        goto L_0x01f6;
    L_0x0395:
        r0 = move-exception;
        r3 = r4;
        goto L_0x01f6;
    L_0x0399:
        r0 = move-exception;
        r5 = r4;
        goto L_0x01f6;
    L_0x039d:
        r2 = move-exception;
        r12 = r4;
        r4 = r3;
        r3 = r12;
        goto L_0x01b3;
    L_0x03a3:
        r2 = move-exception;
        r3 = r4;
        r4 = r5;
        goto L_0x01b3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hwdevicedfxmanager.utils.MaintenanceUtil.cutFolder(java.lang.String, java.lang.String):void");
    }

    public static MaintenanceUtil getMainInstance() {
        if (instance == null) {
            instance = new MaintenanceUtil();
        }
        return instance;
    }

    public ArrayList filtertFile(ArrayList arrayList, int i) {
        ArrayList arrayList2 = new ArrayList();
        String str = "";
        C2538c.b(TAG, new Object[]{" Enter filtertFile() logLevel = " + i});
        String str2;
        switch (i) {
            case 1:
                str2 = "event.log";
                break;
            case 2:
                str2 = "debug.log";
                break;
            case 3:
                str2 = "dump.log";
                break;
            case 4:
                str2 = "btdebug.log";
                break;
            case 5:
                str2 = "mcudebug.log";
                break;
            default:
                Object obj = str;
                break;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (((String) arrayList.get(i2)).toLowerCase(Locale.ENGLISH).equals(obj)) {
                C2538c.b(TAG, new Object[]{" Enter filterEventFile()  fileList.get(l) " + arrayList.get(i2)});
                arrayList2.add(arrayList.get(i2));
            }
        }
        return arrayList2;
    }

    private String getFileName() {
        String deviceName = getDeviceName(this.deviceType);
        C2538c.b(TAG, new Object[]{" getFileName()  deviceName " + deviceName + ",+ deviceMac " + this.deviceMac + ",+ deviceVersion" + this.deviceVersion});
        String replace = this.deviceMac.replace(":", "");
        if (this.deviceVersion == null || "".equals(this.deviceVersion)) {
            this.deviceVersion = "00.00.00";
        }
        deviceName = LOG_PATH_TEMP + "/" + deviceName + HwAccountConstants.SPLIIT_UNDERLINE + this.deviceVersion + HwAccountConstants.SPLIIT_UNDERLINE + replace + HwAccountConstants.SPLIIT_UNDERLINE + new SimpleDateFormat("yyyyMMddHHmmss").format(this.mDate) + "_WearableBeta_" + this.fileName;
        C2538c.b(TAG, new Object[]{" getFileName()  deviceVersion targetPath " + deviceName});
        return deviceName;
    }

    public String getDeviceName(int i) {
        String str = "HUAWEI WEAR";
        switch (i) {
            case 0:
                return "B1";
            case 1:
                return "B2";
            case 2:
                return "K1";
            case 3:
                return "W1";
            case 4:
                return "N1";
            case 5:
                return "B0";
            case 7:
                return "Gemini";
            case 8:
                return "Metis";
            case 10:
                return "Leo";
            case 13:
                return "NYX";
            case 14:
                return "GRUS";
            case 15:
                return "Eris";
            default:
                return "HUAWEI WEAR";
        }
    }

    public void initMaintenanceParame(int i, String str, String str2) {
        C2538c.b(TAG, new Object[]{" initMaintenanceParame(), device" + i + ",+mac " + str + ",+version " + str2});
        this.deviceType = i;
        this.deviceVersion = str2;
        this.deviceMac = str;
    }

    public String getDayDateTime() {
        Log.e("Utils", "getCurrentTime: strCurTime");
        try {
            Long valueOf = Long.valueOf(Calendar.getInstance().getTime().getTime());
            Log.e("Utils", "getCurrentTime: strCurTime = " + String.valueOf(valueOf));
            return String.valueOf(valueOf);
        } catch (Exception e) {
            C2538c.e(TAG, new Object[]{"Exception e = " + e.getMessage()});
            return null;
        }
    }

    public void deleteTenDayFile() {
        ArrayList storageFileList = getStorageFileList();
        if (storageFileList == null) {
            C2538c.b(TAG, new Object[]{"deleteTenDayFile(), not have ten days log"});
            return;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH);
        String format = simpleDateFormat.format(new Date());
        C2538c.b(TAG, new Object[]{"deleteTenDayFile(), newDate = " + format});
        String str = "";
        for (int i = 0; i < storageFileList.size(); i++) {
            File file = (File) storageFileList.get(i);
            String[] split = file.getName().split(HwAccountConstants.SPLIIT_UNDERLINE);
            if (split.length > 4) {
                str = split[4];
            }
            try {
                if ((simpleDateFormat.parse(format).getTime() - simpleDateFormat.parse(str).getTime()) / 86400000 > 10) {
                    C2538c.b(TAG, new Object[]{"deleteTenDayFile(), delete days = " + r6 + ",+file = " + file.getName()});
                    boolean delete = file.delete();
                    C2538c.b(TAG, new Object[]{"deleteTenDayFile isDelete" + delete});
                }
            } catch (Exception e) {
                C2538c.b(TAG, new Object[]{"deleteTenDayFile(), Exception " + e.getMessage()});
            }
        }
    }

    private ArrayList<File> getStorageFileList() {
        ArrayList<File> arrayList = new ArrayList();
        File[] listFiles = new File(LOG_PATH_TEMP).listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return null;
        }
        C2538c.b(TAG, new Object[]{"getStorageFileList(), size = " + listFiles.length});
        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].isDirectory()) {
                C2538c.b(TAG, new Object[]{" getStorageFileList(), is error file = " + listFiles[i].getAbsolutePath()});
            } else {
                arrayList.add(listFiles[i]);
            }
        }
        return arrayList;
    }

    public void writeLogToFile(ArrayList<byte[]> arrayList, String str, Date date) {
        C2538c.b(TAG, new Object[]{"Enter writeLogToFile"});
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                byte[] bArr = (byte[]) arrayList.get(i);
                if (bArr != null) {
                    this.dataSize += (long) bArr.length;
                }
            }
            C2538c.b(TAG, new Object[]{"writeLogToFile dataSize:" + this.dataSize});
            this.maintLogs2.addAll(arrayList);
            this.tmpFileName = str;
            if (date != null) {
                this.tmpDate = (Date) date.clone();
            }
        }
    }

    private void writeLog(Date date, ArrayList<byte[]> arrayList, String str) {
        try {
            this.isWrite = true;
            if (date != null) {
                this.mDate = new Date(date.getTime());
            }
            C2538c.b(TAG, new Object[]{" writeLogToFile(), maintLogs = " + arrayList.size() + ",+file_name = " + str + ",+date" + date});
            if ("".equals(this.fileName) || !this.fileName.equals(str)) {
                C2538c.c(TAG, new Object[]{",+file_name = " + str});
                this.fileName = str;
                initMaintenanceFile();
            }
            this.queLogs.clear();
            this.catchLogs.clear();
            for (int i = 0; i < arrayList.size(); i++) {
                this.catchLogs.add((byte[]) arrayList.get(i));
            }
            arrayList.clear();
            this.queLogs = this.catchLogs;
            if (this.logThread == null) {
                this.logThread = new LogThread(this, null);
                this.logThread.start();
                return;
            }
            synchronized (this.logThread) {
                if (this.logThread != null) {
                    this.logThread.notifyAll();
                }
            }
        } catch (OutOfMemoryError e) {
            C2538c.c(TAG, new Object[]{"Exception: " + e.getMessage()});
        } catch (IndexOutOfBoundsException e2) {
            C2538c.c(TAG, new Object[]{"IndexOutOfBoundsException: " + e2.getMessage()});
        } catch (Exception e3) {
            C2538c.c(TAG, new Object[]{"Exception: " + e3.getMessage()});
        }
    }

    public void initMaintenanceFile() {
        if (!this.isWrite) {
            C2538c.e(TAG, new Object[]{"initMaintenanceFile isWrite" + this.isWrite});
        }
        if (this.fc != null) {
            try {
                this.fc.close();
                this.fc = null;
            } catch (IOException e) {
                C2538c.e(TAG, new Object[]{"IOException e" + e.getMessage()});
            }
        }
        try {
            File file = new File(LOG_PATH_TEMP);
            if (!file.exists()) {
                boolean mkdirs = file.mkdirs();
                C2538c.b(TAG, new Object[]{"initMaintenanceFile isMk" + mkdirs});
            }
            String fileName = getFileName();
            File file2 = new File(fileName);
            if (!file2.exists()) {
                boolean createNewFile = file2.createNewFile();
                C2538c.b(TAG, new Object[]{"initMaintenanceFile isCreN" + createNewFile});
            }
            this.fileOutputStream = new FileOutputStream(fileName, true);
            this.fc = this.fileOutputStream.getChannel();
        } catch (IOException e2) {
            C2538c.b(TAG, new Object[]{e2.getMessage()});
            try {
                if (this.fc != null) {
                    this.fc.close();
                }
                if (this.fileOutputStream != null && true == this.fileOutputStream.getFD().valid()) {
                    this.fileOutputStream.close();
                }
            } catch (Exception e3) {
                C2538c.e(TAG, new Object[]{"Exception e = " + e3.getMessage()});
            }
        }
    }

    public void onDestroyMaintenance() {
        C2538c.b(TAG, new Object[]{"ondestroyMaintenance"});
        try {
            if (this.fc != null) {
                this.fc.close();
            }
            if (this.fileOutputStream != null && true == this.fileOutputStream.getFD().valid()) {
                this.fileOutputStream.close();
            }
        } catch (IOException e) {
            C2538c.e(TAG, new Object[]{e.getMessage()});
        }
        this.fc = null;
        this.maintLogs2.clear();
        this.dataSize = 0;
    }

    public void setMaintCheckTime(String str) {
        C2538c.c(TAG, new Object[]{"setMaintCheckTime,time-----------" + str});
        com.huawei.hwdataaccessmodel.a.c cVar = new com.huawei.hwdataaccessmodel.a.c();
        cVar.a = 0;
        a.a(BaseApplication.b(), String.valueOf(10), MAINT_KEY_CHECK_TIME, str, cVar);
    }

    public String getMaintCheckTime() {
        String a = a.a(BaseApplication.b(), String.valueOf(10), MAINT_KEY_CHECK_TIME);
        C2538c.c(TAG, new Object[]{"getMaintCheckTime,maintCheckTime-----------" + a});
        return a;
    }

    public void setMaintRetryResult(boolean z) {
        C2538c.c(TAG, new Object[]{"setMaintRetryResult,result-----------" + z});
        com.huawei.hwdataaccessmodel.a.c cVar = new com.huawei.hwdataaccessmodel.a.c();
        cVar.a = 0;
        a.a(BaseApplication.b(), String.valueOf(10), MAINT_KEY_RESULT, String.valueOf(z), cVar);
    }

    public boolean getMaintRetryResult() {
        if (a.a(BaseApplication.b(), String.valueOf(10), MAINT_KEY_RESULT).equals("true")) {
            return true;
        }
        return false;
    }

    public void setMaintRetryNum(int i) {
        C2538c.c(TAG, new Object[]{"setMaintRetryTime,retry-----------" + i});
        com.huawei.hwdataaccessmodel.a.c cVar = new com.huawei.hwdataaccessmodel.a.c();
        cVar.a = 0;
        a.a(BaseApplication.b(), String.valueOf(10), MAINT_KEY_RETRY_TIME, String.valueOf(i), cVar);
    }

    public int getMaintRetryNum() {
        try {
            int parseInt = Integer.parseInt(a.a(BaseApplication.b(), String.valueOf(10), MAINT_KEY_RETRY_TIME));
            C2538c.c(TAG, new Object[]{"getMaintRetryTime,retry-----------" + parseInt});
            return parseInt;
        } catch (Exception e) {
            C2538c.e(TAG, new Object[]{"getMaintRetryTime: " + e.getMessage()});
            return 0;
        }
    }

    public DeviceCommand maintParametersCommand() {
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(10);
        deviceCommand.setCommandID(2);
        C2538c.c(TAG, new Object[]{"getMaintenanceParameters  deviceCommand = " + deviceCommand.toString()});
        return deviceCommand;
    }

    public DeviceCommand transferFileEndProcess() {
        return null;
    }

    public String getmTransferDataContentPath() {
        return null;
    }

    public String getmTransferStateContentPath() {
        return null;
    }

    public void save2File(IBaseResponseCallback iBaseResponseCallback, boolean z) {
        C2538c.e(TAG, new Object[]{"save2File: "});
        this.mCallback = iBaseResponseCallback;
        if (this.dataSize >= 200000 || z) {
            if (this.executor == null) {
                this.executor = Executors.newSingleThreadExecutor();
            }
            this.executor.execute(new C49801());
        } else if (iBaseResponseCallback != null) {
            this.mCallback.onResponse(100000, LightCloudConstants.RESPONSE_RESULT_SUCCESS);
        }
    }
}
