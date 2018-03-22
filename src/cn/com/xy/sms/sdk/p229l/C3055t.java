package cn.com.xy.sms.sdk.p229l;

import android.content.res.AssetManager;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipFile;
import org.apache.log4j.spi.LocationInfo;

public final class C3055t {
    private static String f10305a = "FileUtils";

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m13692a(java.lang.String r12, java.lang.String r13, java.lang.String r14, boolean r15) {
        /*
        r4 = 0;
        r2 = 0;
        r1 = 0;
        r0 = cn.com.xy.sms.sdk.p229l.C3049n.m13653e(r12);	 Catch:{ MalformedURLException -> 0x01f0, Throwable -> 0x0216, all -> 0x023c }
        if (r0 == 0) goto L_0x0017;
    L_0x0009:
        r0 = 0;
        cn.com.xy.sms.sdk.p229l.C3055t.m13696a(r0);
        r0 = 0;
        cn.com.xy.sms.sdk.p229l.C3055t.m13696a(r0);
        r0 = 0;
        cn.com.xy.sms.sdk.p229l.C3055t.m13701a(r0);
        r0 = -1;
    L_0x0016:
        return r0;
    L_0x0017:
        r0 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x01f0, Throwable -> 0x0216, all -> 0x023c }
        r3 = java.lang.String.valueOf(r13);	 Catch:{ MalformedURLException -> 0x01f0, Throwable -> 0x0216, all -> 0x023c }
        r0.<init>(r3);	 Catch:{ MalformedURLException -> 0x01f0, Throwable -> 0x0216, all -> 0x023c }
        r0 = r0.append(r14);	 Catch:{ MalformedURLException -> 0x01f0, Throwable -> 0x0216, all -> 0x023c }
        r0 = r0.toString();	 Catch:{ MalformedURLException -> 0x01f0, Throwable -> 0x0216, all -> 0x023c }
        r0 = cn.com.xy.sms.sdk.p229l.C3055t.m13704a(r0);	 Catch:{ MalformedURLException -> 0x01f0, Throwable -> 0x0216, all -> 0x023c }
        if (r0 == 0) goto L_0x0042;
    L_0x002e:
        r0 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x01f0, Throwable -> 0x0216, all -> 0x023c }
        r3 = java.lang.String.valueOf(r13);	 Catch:{ MalformedURLException -> 0x01f0, Throwable -> 0x0216, all -> 0x023c }
        r0.<init>(r3);	 Catch:{ MalformedURLException -> 0x01f0, Throwable -> 0x0216, all -> 0x023c }
        r0 = r0.append(r14);	 Catch:{ MalformedURLException -> 0x01f0, Throwable -> 0x0216, all -> 0x023c }
        r0 = r0.toString();	 Catch:{ MalformedURLException -> 0x01f0, Throwable -> 0x0216, all -> 0x023c }
        cn.com.xy.sms.sdk.p229l.C3055t.m13709c(r0);	 Catch:{ MalformedURLException -> 0x01f0, Throwable -> 0x0216, all -> 0x023c }
    L_0x0042:
        r0 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x01f0, Throwable -> 0x0216, all -> 0x023c }
        r3 = java.lang.String.valueOf(r13);	 Catch:{ MalformedURLException -> 0x01f0, Throwable -> 0x0216, all -> 0x023c }
        r0.<init>(r3);	 Catch:{ MalformedURLException -> 0x01f0, Throwable -> 0x0216, all -> 0x023c }
        r0 = r0.append(r14);	 Catch:{ MalformedURLException -> 0x01f0, Throwable -> 0x0216, all -> 0x023c }
        r3 = ".temp";
        r0 = r0.append(r3);	 Catch:{ MalformedURLException -> 0x01f0, Throwable -> 0x0216, all -> 0x023c }
        r0 = r0.toString();	 Catch:{ MalformedURLException -> 0x01f0, Throwable -> 0x0216, all -> 0x023c }
        r0 = cn.com.xy.sms.sdk.p229l.C3055t.m13704a(r0);	 Catch:{ MalformedURLException -> 0x01f0, Throwable -> 0x0216, all -> 0x023c }
        if (r0 == 0) goto L_0x0079;
    L_0x005f:
        r0 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x01f0, Throwable -> 0x0216, all -> 0x023c }
        r3 = java.lang.String.valueOf(r13);	 Catch:{ MalformedURLException -> 0x01f0, Throwable -> 0x0216, all -> 0x023c }
        r0.<init>(r3);	 Catch:{ MalformedURLException -> 0x01f0, Throwable -> 0x0216, all -> 0x023c }
        r0 = r0.append(r14);	 Catch:{ MalformedURLException -> 0x01f0, Throwable -> 0x0216, all -> 0x023c }
        r3 = ".temp";
        r0 = r0.append(r3);	 Catch:{ MalformedURLException -> 0x01f0, Throwable -> 0x0216, all -> 0x023c }
        r0 = r0.toString();	 Catch:{ MalformedURLException -> 0x01f0, Throwable -> 0x0216, all -> 0x023c }
        cn.com.xy.sms.sdk.p229l.C3055t.m13709c(r0);	 Catch:{ MalformedURLException -> 0x01f0, Throwable -> 0x0216, all -> 0x023c }
    L_0x0079:
        r0 = "https";
        r0 = r12.startsWith(r0);	 Catch:{ MalformedURLException -> 0x01f0, Throwable -> 0x0216, all -> 0x023c }
        if (r0 != 0) goto L_0x0089;
    L_0x0081:
        r0 = "HTTPS";
        r0 = r12.startsWith(r0);	 Catch:{ MalformedURLException -> 0x01f0, Throwable -> 0x0216, all -> 0x023c }
        if (r0 == 0) goto L_0x00b3;
    L_0x0089:
        r0 = 0;
        r3 = cn.com.xy.sms.sdk.p216h.C2999d.m13520a(r12, r0);	 Catch:{ MalformedURLException -> 0x01f0, Throwable -> 0x0216, all -> 0x023c }
    L_0x008e:
        r0 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        r3.setConnectTimeout(r0);	 Catch:{ MalformedURLException -> 0x0262, Throwable -> 0x025d }
        r0 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        r3.setReadTimeout(r0);	 Catch:{ MalformedURLException -> 0x0262, Throwable -> 0x025d }
        r4 = r3.getInputStream();	 Catch:{ MalformedURLException -> 0x0262, Throwable -> 0x025d }
        r0 = r3.getResponseCode();	 Catch:{ MalformedURLException -> 0x0266, Throwable -> 0x025d }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r0 == r2) goto L_0x00c0;
    L_0x00a6:
        cn.com.xy.sms.sdk.p229l.C3055t.m13696a(r4);
        r0 = 0;
        cn.com.xy.sms.sdk.p229l.C3055t.m13696a(r0);
        cn.com.xy.sms.sdk.p229l.C3055t.m13701a(r3);
        r0 = -1;
        goto L_0x0016;
    L_0x00b3:
        r0 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x01f0, Throwable -> 0x0216, all -> 0x023c }
        r0.<init>(r12);	 Catch:{ MalformedURLException -> 0x01f0, Throwable -> 0x0216, all -> 0x023c }
        r0 = r0.openConnection();	 Catch:{ MalformedURLException -> 0x01f0, Throwable -> 0x0216, all -> 0x023c }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ MalformedURLException -> 0x01f0, Throwable -> 0x0216, all -> 0x023c }
        r3 = r0;
        goto L_0x008e;
    L_0x00c0:
        r0 = r3.getURL();	 Catch:{ MalformedURLException -> 0x0266, Throwable -> 0x025d }
        r0 = r0.toString();	 Catch:{ MalformedURLException -> 0x0266, Throwable -> 0x025d }
        r0 = cn.com.xy.sms.sdk.p229l.C3055t.m13708b(r0, r12);	 Catch:{ MalformedURLException -> 0x0266, Throwable -> 0x025d }
        if (r0 != 0) goto L_0x00db;
    L_0x00ce:
        cn.com.xy.sms.sdk.p229l.C3055t.m13696a(r4);
        r0 = 0;
        cn.com.xy.sms.sdk.p229l.C3055t.m13696a(r0);
        cn.com.xy.sms.sdk.p229l.C3055t.m13701a(r3);
        r0 = -1;
        goto L_0x0016;
    L_0x00db:
        r0 = 0;
        r2 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r5 = new byte[r2];	 Catch:{ MalformedURLException -> 0x0266, Throwable -> 0x025d }
        r2 = r3.getContentLength();	 Catch:{ MalformedURLException -> 0x0266, Throwable -> 0x025d }
        r6 = (long) r2;	 Catch:{ MalformedURLException -> 0x0266, Throwable -> 0x025d }
        r8 = new java.io.File;	 Catch:{ MalformedURLException -> 0x0266, Throwable -> 0x025d }
        r2 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x0266, Throwable -> 0x025d }
        r9 = java.lang.String.valueOf(r13);	 Catch:{ MalformedURLException -> 0x0266, Throwable -> 0x025d }
        r2.<init>(r9);	 Catch:{ MalformedURLException -> 0x0266, Throwable -> 0x025d }
        r2 = r2.append(r14);	 Catch:{ MalformedURLException -> 0x0266, Throwable -> 0x025d }
        r9 = ".temp";
        r2 = r2.append(r9);	 Catch:{ MalformedURLException -> 0x0266, Throwable -> 0x025d }
        r2 = r2.toString();	 Catch:{ MalformedURLException -> 0x0266, Throwable -> 0x025d }
        r8.<init>(r2);	 Catch:{ MalformedURLException -> 0x0266, Throwable -> 0x025d }
        r2 = new java.io.BufferedOutputStream;	 Catch:{ MalformedURLException -> 0x0266, Throwable -> 0x025d }
        r9 = new java.io.FileOutputStream;	 Catch:{ MalformedURLException -> 0x0266, Throwable -> 0x025d }
        r9.<init>(r8);	 Catch:{ MalformedURLException -> 0x0266, Throwable -> 0x025d }
        r2.<init>(r9);	 Catch:{ MalformedURLException -> 0x0266, Throwable -> 0x025d }
        r1 = r0;
    L_0x010c:
        r0 = java.lang.Thread.interrupted();	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        if (r0 != 0) goto L_0x0119;
    L_0x0112:
        r0 = r4.read(r5);	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        r9 = -1;
        if (r0 != r9) goto L_0x017b;
    L_0x0119:
        r2.flush();	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        r0 = 0;
        r5 = ".";
        r5 = r14.lastIndexOf(r5);	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        r5 = r14.substring(r0, r5);	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        r10 = (long) r1;	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        r0 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1));
        if (r0 != 0) goto L_0x0182;
    L_0x012c:
        r0 = 1;
        if (r15 == 0) goto L_0x013a;
    L_0x012f:
        r8 = cn.com.xy.sms.sdk.p229l.aa.m13583a(r8);	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        r5 = r5.equals(r8);	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        if (r5 != 0) goto L_0x013a;
    L_0x0139:
        r0 = 0;
    L_0x013a:
        if (r0 != 0) goto L_0x0144;
    L_0x013c:
        r0 = "duoqu_";
        r0 = r14.startsWith(r0);	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        if (r0 == 0) goto L_0x0248;
    L_0x0144:
        r0 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        r5 = "size=";
        r0.<init>(r5);	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        r0 = r0.append(r6);	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        r5 = " mHasRead=";
        r0 = r0.append(r5);	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        r0.append(r1);	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        r0 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        r1 = java.lang.String.valueOf(r14);	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        r0.<init>(r1);	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        r1 = ".temp";
        r0 = r0.append(r1);	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        r0 = r0.toString();	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        cn.com.xy.sms.sdk.p229l.C3055t.m13699a(r13, r0, r14);	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        cn.com.xy.sms.sdk.p229l.C3055t.m13696a(r4);
        cn.com.xy.sms.sdk.p229l.C3055t.m13696a(r2);
        cn.com.xy.sms.sdk.p229l.C3055t.m13701a(r3);
        r0 = 0;
        goto L_0x0016;
    L_0x017b:
        r9 = 0;
        r2.write(r5, r9, r0);	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        r0 = r0 + r1;
        r1 = r0;
        goto L_0x010c;
    L_0x0182:
        r0 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        r1 = java.lang.String.valueOf(r13);	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        r0.<init>(r1);	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        r0 = r0.append(r14);	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        r0 = r0.toString();	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        r0 = cn.com.xy.sms.sdk.p229l.C3055t.m13704a(r0);	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        if (r0 == 0) goto L_0x01ad;
    L_0x0199:
        r0 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        r1 = java.lang.String.valueOf(r13);	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        r0.<init>(r1);	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        r0 = r0.append(r14);	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        r0 = r0.toString();	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        cn.com.xy.sms.sdk.p229l.C3055t.m13709c(r0);	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
    L_0x01ad:
        r0 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        r1 = java.lang.String.valueOf(r13);	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        r0.<init>(r1);	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        r0 = r0.append(r14);	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        r1 = ".temp";
        r0 = r0.append(r1);	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        r0 = r0.toString();	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        r0 = cn.com.xy.sms.sdk.p229l.C3055t.m13704a(r0);	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        if (r0 == 0) goto L_0x01e4;
    L_0x01ca:
        r0 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        r1 = java.lang.String.valueOf(r13);	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        r0.<init>(r1);	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        r0 = r0.append(r14);	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        r1 = ".temp";
        r0 = r0.append(r1);	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        r0 = r0.toString();	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
        cn.com.xy.sms.sdk.p229l.C3055t.m13709c(r0);	 Catch:{ MalformedURLException -> 0x026a, Throwable -> 0x025f, all -> 0x0256 }
    L_0x01e4:
        cn.com.xy.sms.sdk.p229l.C3055t.m13696a(r4);
        cn.com.xy.sms.sdk.p229l.C3055t.m13696a(r2);
        cn.com.xy.sms.sdk.p229l.C3055t.m13701a(r3);
        r0 = -1;
        goto L_0x0016;
    L_0x01f0:
        r0 = move-exception;
        r3 = r4;
    L_0x01f2:
        r4 = "XIAOYUAN";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0259 }
        r6 = "downFile: ";
        r5.<init>(r6);	 Catch:{ all -> 0x0259 }
        r6 = r0.getMessage();	 Catch:{ all -> 0x0259 }
        r5 = r5.append(r6);	 Catch:{ all -> 0x0259 }
        r5 = r5.toString();	 Catch:{ all -> 0x0259 }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r4, r5, r0);	 Catch:{ all -> 0x0259 }
        cn.com.xy.sms.sdk.p229l.C3055t.m13696a(r3);
        cn.com.xy.sms.sdk.p229l.C3055t.m13696a(r1);
        cn.com.xy.sms.sdk.p229l.C3055t.m13701a(r2);
        r0 = -1;
        goto L_0x0016;
    L_0x0216:
        r0 = move-exception;
        r3 = r2;
    L_0x0218:
        r2 = "XIAOYUAN";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0254 }
        r6 = "downFile: ";
        r5.<init>(r6);	 Catch:{ all -> 0x0254 }
        r6 = r0.getMessage();	 Catch:{ all -> 0x0254 }
        r5 = r5.append(r6);	 Catch:{ all -> 0x0254 }
        r5 = r5.toString();	 Catch:{ all -> 0x0254 }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r2, r5, r0);	 Catch:{ all -> 0x0254 }
        cn.com.xy.sms.sdk.p229l.C3055t.m13696a(r4);
        cn.com.xy.sms.sdk.p229l.C3055t.m13696a(r1);
        cn.com.xy.sms.sdk.p229l.C3055t.m13701a(r3);
        r0 = -1;
        goto L_0x0016;
    L_0x023c:
        r0 = move-exception;
        r3 = r2;
    L_0x023e:
        cn.com.xy.sms.sdk.p229l.C3055t.m13696a(r4);
        cn.com.xy.sms.sdk.p229l.C3055t.m13696a(r1);
        cn.com.xy.sms.sdk.p229l.C3055t.m13701a(r3);
        throw r0;
    L_0x0248:
        cn.com.xy.sms.sdk.p229l.C3055t.m13696a(r4);
        cn.com.xy.sms.sdk.p229l.C3055t.m13696a(r2);
        cn.com.xy.sms.sdk.p229l.C3055t.m13701a(r3);
        r0 = -1;
        goto L_0x0016;
    L_0x0254:
        r0 = move-exception;
        goto L_0x023e;
    L_0x0256:
        r0 = move-exception;
        r1 = r2;
        goto L_0x023e;
    L_0x0259:
        r0 = move-exception;
        r4 = r3;
        r3 = r2;
        goto L_0x023e;
    L_0x025d:
        r0 = move-exception;
        goto L_0x0218;
    L_0x025f:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0218;
    L_0x0262:
        r0 = move-exception;
        r2 = r3;
        r3 = r4;
        goto L_0x01f2;
    L_0x0266:
        r0 = move-exception;
        r2 = r3;
        r3 = r4;
        goto L_0x01f2;
    L_0x026a:
        r0 = move-exception;
        r1 = r2;
        r2 = r3;
        r3 = r4;
        goto L_0x01f2;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.l.t.a(java.lang.String, java.lang.String, java.lang.String, boolean):int");
    }

    public static AssetManager m13693a() {
        AssetManager a;
        try {
            a = C3041f.m13609b().m13093a();
        } catch (Throwable e) {
            C2982a.m13415a("XIAOYUAN", "getExtendAssetManager" + e.getMessage(), e);
            a = null;
        }
        return a == null ? C2917a.m13105a().getResources().getAssets() : a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.File m13694a(java.lang.String r7, java.lang.String r8, java.io.InputStream r9) {
        /*
        r1 = 0;
        if (r9 != 0) goto L_0x0005;
    L_0x0003:
        r0 = r1;
    L_0x0004:
        return r0;
    L_0x0005:
        r0 = new java.io.File;	 Catch:{ Throwable -> 0x009e, all -> 0x0093 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x009e, all -> 0x0093 }
        r3 = java.lang.String.valueOf(r7);	 Catch:{ Throwable -> 0x009e, all -> 0x0093 }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x009e, all -> 0x0093 }
        r2 = r2.append(r8);	 Catch:{ Throwable -> 0x009e, all -> 0x0093 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x009e, all -> 0x0093 }
        r0.<init>(r2);	 Catch:{ Throwable -> 0x009e, all -> 0x0093 }
        r2 = new java.io.FileOutputStream;	 Catch:{ Throwable -> 0x00a4, all -> 0x0093 }
        r2.<init>(r0);	 Catch:{ Throwable -> 0x00a4, all -> 0x0093 }
        r1 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r1 = new byte[r1];	 Catch:{ Throwable -> 0x0039 }
    L_0x0024:
        r3 = r9.read(r1);	 Catch:{ Throwable -> 0x0039 }
        if (r3 > 0) goto L_0x0034;
    L_0x002a:
        r2.flush();	 Catch:{ Throwable -> 0x0039 }
        cn.com.xy.sms.sdk.p229l.C3055t.m13696a(r2);
        cn.com.xy.sms.sdk.p229l.C3055t.m13696a(r9);
        goto L_0x0004;
    L_0x0034:
        r4 = 0;
        r2.write(r1, r4, r3);	 Catch:{ Throwable -> 0x0039 }
        goto L_0x0024;
    L_0x0039:
        r1 = move-exception;
    L_0x003a:
        r3 = "XIAOYUAN";
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009c }
        r5 = "downFileFromInput: ";
        r4.<init>(r5);	 Catch:{ all -> 0x009c }
        r5 = r1.getMessage();	 Catch:{ all -> 0x009c }
        r4 = r4.append(r5);	 Catch:{ all -> 0x009c }
        r4 = r4.toString();	 Catch:{ all -> 0x009c }
        cn.com.xy.sms.sdk.p215g.C2982a.m13415a(r3, r4, r1);	 Catch:{ all -> 0x009c }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009c }
        r4 = "e=";
        r3.<init>(r4);	 Catch:{ all -> 0x009c }
        r1 = r1.getLocalizedMessage();	 Catch:{ all -> 0x009c }
        r3.append(r1);	 Catch:{ all -> 0x009c }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009c }
        r3 = java.lang.String.valueOf(r7);	 Catch:{ all -> 0x009c }
        r1.<init>(r3);	 Catch:{ all -> 0x009c }
        r1 = r1.append(r8);	 Catch:{ all -> 0x009c }
        r1 = r1.toString();	 Catch:{ all -> 0x009c }
        r1 = cn.com.xy.sms.sdk.p229l.C3055t.m13704a(r1);	 Catch:{ all -> 0x009c }
        if (r1 == 0) goto L_0x008b;
    L_0x0077:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009c }
        r3 = java.lang.String.valueOf(r7);	 Catch:{ all -> 0x009c }
        r1.<init>(r3);	 Catch:{ all -> 0x009c }
        r1 = r1.append(r8);	 Catch:{ all -> 0x009c }
        r1 = r1.toString();	 Catch:{ all -> 0x009c }
        cn.com.xy.sms.sdk.p229l.C3055t.m13709c(r1);	 Catch:{ all -> 0x009c }
    L_0x008b:
        cn.com.xy.sms.sdk.p229l.C3055t.m13696a(r2);
        cn.com.xy.sms.sdk.p229l.C3055t.m13696a(r9);
        goto L_0x0004;
    L_0x0093:
        r0 = move-exception;
        r2 = r1;
    L_0x0095:
        cn.com.xy.sms.sdk.p229l.C3055t.m13696a(r2);
        cn.com.xy.sms.sdk.p229l.C3055t.m13696a(r9);
        throw r0;
    L_0x009c:
        r0 = move-exception;
        goto L_0x0095;
    L_0x009e:
        r0 = move-exception;
        r2 = r1;
        r6 = r0;
        r0 = r1;
        r1 = r6;
        goto L_0x003a;
    L_0x00a4:
        r2 = move-exception;
        r6 = r2;
        r2 = r1;
        r1 = r6;
        goto L_0x003a;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.xy.sms.sdk.l.t.a(java.lang.String, java.lang.String, java.io.InputStream):java.io.File");
    }

    public static String m13695a(int i) {
        return i == 1 ? "X8448A" : "X4667U";
    }

    public static void m13696a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "close: " + th.getMessage(), th);
            }
        }
    }

    public static void m13697a(File file) {
        if (file != null) {
            try {
                if (!file.exists()) {
                    return;
                }
                if (file.isFile()) {
                    file.delete();
                } else if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles == null) {
                        file.delete();
                        return;
                    }
                    for (File a : listFiles) {
                        C3055t.m13697a(a);
                    }
                    file.delete();
                }
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "deleteAllFile: " + th.getMessage(), th);
            }
        }
    }

    public static void m13698a(String str, String str2) {
        try {
            File file = new File(str);
            if (file.exists()) {
                file.renameTo(new File(str2));
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "renameFile: " + th.getMessage(), th);
        }
    }

    public static void m13699a(String str, String str2, String str3) {
        C3055t.m13698a(new StringBuilder(String.valueOf(str)).append(str2).toString(), new StringBuilder(String.valueOf(str)).append(str3).toString());
    }

    public static void m13700a(String str, String str2, String str3, String str4) {
        try {
            List e = C3055t.m13713e(str, str2, str3);
            f10305a = "deleteFile";
            C3055t.m13702a(e, str4);
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "deleteFile: " + th.getMessage(), th);
        }
    }

    private static void m13701a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "closeUrlConnection: " + th.getMessage(), th);
            }
        }
    }

    private static void m13702a(List<File> list, String str) {
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    Iterator it = list.iterator();
                    while (it != null && it.hasNext()) {
                        File file = (File) it.next();
                        String str2;
                        if (file.getName().equals(str)) {
                            str2 = f10305a;
                            new StringBuilder("不删除").append(file.getAbsolutePath());
                        } else {
                            file.delete();
                            str2 = f10305a;
                            new StringBuilder(String.valueOf(f10305a)).append("=").append(file.getAbsolutePath());
                        }
                    }
                }
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "deleteFile: " + th.getMessage(), th);
            }
        }
    }

    public static void m13703a(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "close: " + th.getMessage(), th);
            }
        }
    }

    public static boolean m13704a(String str) {
        return new File(str).exists();
    }

    public static byte[] m13705a(InputStream inputStream) {
        Closeable dataInputStream;
        Throwable th;
        Throwable th2;
        byte[] bArr = new byte[2560];
        Closeable byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            dataInputStream = new DataInputStream(inputStream);
            while (true) {
                int read = dataInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                try {
                    byteArrayOutputStream.write(bArr, 0, read);
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            bArr = byteArrayOutputStream.toByteArray();
            C3055t.m13696a(dataInputStream);
            C3055t.m13696a((Closeable) inputStream);
            C3055t.m13696a(byteArrayOutputStream);
        } catch (Throwable th4) {
            th2 = th4;
            dataInputStream = null;
            C3055t.m13696a(dataInputStream);
            C3055t.m13696a((Closeable) inputStream);
            C3055t.m13696a(byteArrayOutputStream);
            throw th2;
        }
        return bArr;
    }

    public static InputStream m13706b(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return new FileInputStream(file);
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "getInputStreamFromFile: " + th.getMessage(), th);
        }
        return null;
    }

    public static void m13707b(String str, String str2, String str3) {
        try {
            File dir = C2917a.m13105a().getDir("outdex", 0);
            if (dir != null) {
                List e = C3055t.m13713e(dir.getCanonicalPath(), str, str2);
                f10305a = "deleteDex";
                C3055t.m13702a(e, str3);
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "deleteDex: " + th.getMessage(), th);
        }
    }

    private static boolean m13708b(String str, String str2) {
        try {
            if (str.length() > str2.length()) {
                int indexOf = str.indexOf(LocationInfo.NA);
                if (!(indexOf == -1 || str.substring(indexOf + 1).indexOf(str2.replaceFirst("https://", "").replaceFirst("HTTPS://", "").replaceFirst("http://", "").replaceFirst("HTTP://", "")) == -1)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            C2982a.m13415a("xiaoyuan", "FileUtils.validUrl: " + th.getMessage(), th);
            return false;
        }
    }

    public static boolean m13709c(String str) {
        try {
            if (C3049n.m13653e(str)) {
                return false;
            }
            File file = new File(str);
            if (!file.exists() || !file.isFile()) {
                return false;
            }
            file.delete();
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean m13710c(String str, String str2, String str3) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdir();
            }
            File[] listFiles = file.listFiles(new ac(str2, str3));
            if (listFiles != null && listFiles.length > 0) {
                return true;
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "isFileExists: " + th.getMessage(), th);
        }
        return false;
    }

    public static String m13711d(String str, String str2, String str3) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdir();
            }
            File[] listFiles = file.listFiles(new ac(str2, str3));
            if (listFiles != null && listFiles.length > 0) {
                return listFiles[0].getCanonicalPath();
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "getFilePath: " + th.getMessage(), th);
        }
        return "";
    }

    public static void m13712d(String str) {
        C3055t.m13697a(new File(str));
    }

    public static List<File> m13713e(String str, String str2, String str3) {
        List<File> arrayList = new ArrayList();
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdir();
            }
            File[] listFiles = file.listFiles(new ac(str2, str3));
            if (listFiles != null && listFiles.length > 0) {
                arrayList = Arrays.asList(listFiles);
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "getFileList: " + th.getMessage(), th);
        }
        return arrayList;
    }

    public static byte[] m13714e(String str) {
        return C3055t.m13705a(new FileInputStream(str));
    }

    public static int m13715f(String str, String str2, String str3) {
        return C3055t.m13692a(str, str2, str3, false);
    }

    public static String m13716f(String str) {
        Closeable closeable = null;
        String str2;
        try {
            closeable = C3055t.m13693a().open(str);
            byte[] bArr = new byte[closeable.available()];
            closeable.read(bArr);
            closeable.close();
            str2 = new String(bArr, "GB2312");
            if (!C3049n.m13653e(str2)) {
                return str2;
            }
            C3055t.m13696a(closeable);
            return "-1";
        } catch (IOException e) {
            str2 = e;
            C2982a.m13415a("XIAOYUAN", "getAssetsTxtFileContent: " + str2.getMessage(), str2);
        } catch (Throwable th) {
            str2 = th;
            C2982a.m13415a("XIAOYUAN", "getAssetsTxtFileContent: " + str2.getMessage(), str2);
        } finally {
            C3055t.m13696a(closeable);
        }
    }

    public static List<String> m13717g(String str) {
        Closeable open;
        Closeable bufferedReader;
        Closeable closeable;
        Throwable th;
        try {
            open = C3055t.m13693a().open(str);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(open, "GB2312"));
                try {
                    List<String> arrayList = new ArrayList();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            C3055t.m13696a(bufferedReader);
                            C3055t.m13696a(open);
                            return arrayList;
                        }
                        arrayList.add(readLine);
                    }
                } catch (IOException e) {
                    closeable = bufferedReader;
                    bufferedReader = open;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e2) {
                closeable = null;
                bufferedReader = open;
                C3055t.m13696a(closeable);
                C3055t.m13696a(bufferedReader);
                return null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                C3055t.m13696a(bufferedReader);
                C3055t.m13696a(open);
                throw th;
            }
        } catch (IOException e3) {
            closeable = null;
            bufferedReader = null;
            C3055t.m13696a(closeable);
            C3055t.m13696a(bufferedReader);
            return null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            open = null;
            C3055t.m13696a(bufferedReader);
            C3055t.m13696a(open);
            throw th;
        }
    }

    public static String m13718h(String str) {
        Closeable open;
        Closeable bufferedReader;
        Throwable th;
        Closeable closeable = null;
        try {
            open = C3055t.m13693a().open(str);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(open, "GB2312"));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        } else if (!C3049n.m13653e(readLine) && readLine.indexOf("PVER:") != -1) {
                            readLine = readLine.substring(5).trim();
                            C3055t.m13696a(bufferedReader);
                            C3055t.m13696a(open);
                            return readLine;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                C3055t.m13696a(bufferedReader);
                C3055t.m13696a(open);
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                C3055t.m13696a(bufferedReader);
                C3055t.m13696a(open);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            open = null;
            C3055t.m13696a(bufferedReader);
            C3055t.m13696a(open);
            throw th;
        }
        return "";
    }
}
