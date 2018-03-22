package com.huawei.p111o;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.crowdtestsdk.db.DBConstants;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.hwdataaccessmodel.db.a;
import com.huawei.hwdataaccessmodel.db.backup.C0994a;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.o.d;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.component.GameManager;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: KeyManager */
public class C1210c {
    private static byte[] f2646a = new byte[1];
    private static final String f2647b = (DBConstants.SCHEME + BaseApplication.m2633c().m3521a() + ".data.backup.provider" + "/");

    public static byte[] m5489a(int i) {
        byte[] b;
        synchronized (f2646a) {
            String a = C0977d.m3528a(Process.myPid());
            C2538c.m12677c("KeyManager", "getSecurityKey---dataType:" + i, ";process id:" + r0, ";process name:" + a, ";main process:", BaseApplication.m2633c().m3521a());
            b = C1210c.m5496b(i);
        }
        return b;
    }

    static byte[] m5496b(int i) {
        byte[] f;
        synchronized (f2646a) {
            try {
                C2538c.m12677c("KeyManager", "get work key in cp");
                f = C1210c.m5508f(i);
            } catch (Exception e) {
                C2538c.m12680e("KeyManager", "getSecurityKey:", e.getMessage());
                f = null;
            }
        }
        return f;
    }

    private static byte[] m5508f(int i) {
        byte[] bArr;
        int i2 = 0;
        synchronized (f2646a) {
            d.a("KeyManager", new Object[]{"wt ------getWorkKeyByCP--------get work key begin"});
            byte[] bytes = C1210c.m5497c().getBytes(GameManager.DEFAULT_CHARSET);
            d.a("KeyManager", new Object[]{"wt ------getRootKeyByCP ok"});
            String e = C1210c.m5505e(i);
            d.a("KeyManager", new Object[]{"wt -------getWorkKeyByCP-------get work key xxx" + e});
            if (TextUtils.isEmpty(e)) {
                while (i2 <= 30) {
                    try {
                        f2646a.wait(300);
                    } catch (Exception e2) {
                        d.a("KeyManager", new Object[]{"wt ------sleep 1000"});
                    }
                    try {
                        d.a("KeyManager", new Object[]{"wt ---retry workkey---sleep 1000"});
                        e = C1210c.m5505e(i);
                        if (!"".equals(e)) {
                            d.a("KeyManager", new Object[]{"zzz ===retry work-sleep==ok "});
                            break;
                        }
                        i2++;
                    } catch (Exception e3) {
                        C2538c.m12680e("KeyManager", "getWorkKeyByCP:", e3.getMessage());
                        bArr = null;
                    }
                }
            }
            if (TextUtils.isEmpty(e) || e.length() < 24) {
                d.a("KeyManager", new Object[]{"wt --get workkey is null"});
                bArr = C1210c.m5490a(i, bytes);
            } else {
                d.a("KeyManager", new Object[]{"wt ---getWorkKeyByCP-----------get work key2"});
                d.a("KeyManager", new Object[]{"wt --------getWorkKeyByCP------get work key2, iv is:", e.substring(0, 24), ";key is:", e.substring(24, e.length())});
                try {
                    bArr = C1210c.m5491a(com.huawei.o.b.d.a(e.substring(24, e.length())), bytes, com.huawei.o.b.d.a(e.substring(0, 24)));
                } catch (Exception e4) {
                    bArr = C1210c.m5490a(i, bytes);
                }
                d.a("KeyManager", new Object[]{"wt-----getWorkKeyByCP-getWorkKey2----finish dec,secret is:", C0973a.m3509a(bArr)});
            }
        }
        return bArr;
    }

    static String m5498c(int i) {
        return C1210c.m5505e(i);
    }

    static String m5502d(int i) {
        return C1210c.m5497c();
    }

    private static String m5497c() {
        String h;
        synchronized (f2646a) {
            C2538c.m12680e("KeyManager", "getRootKeyByCP");
            h = C1210c.m5511h(1);
            d.a("KeyManager", new Object[]{"wt-----getRootKeyByCP tmp_oldC1StringAll:" + h});
            d.a("KeyManager", new Object[]{"wt-----getRootKeyByCP tmp_oldC1String:" + h.substring(2, h.length())});
            d.a("KeyManager", new Object[]{"wt-----getRootKeyByCP tmp_oldC2String:" + C1210c.m5511h(2)});
            d.a("KeyManager", new Object[]{"wt-----getRootKeyByCP tmp_oldC3String:" + C1210c.m5511h(3)});
            h = C1210c.m5485a(h, r2, r3);
        }
        return h;
    }

    static String m5505e(int i) {
        String string;
        SQLiteException e;
        d.a("KeyManager", new Object[]{"wt ------getWorkKeyEncryptByCP begin"});
        String str = "";
        try {
            Cursor query = BaseApplication.m2632b().getContentResolver().query(Uri.parse(a.a + "module_" + 1009 + HwAccountConstants.SPLIIT_UNDERLINE + "backup_table"), null, "backupKey like ?", new String[]{String.valueOf(i)}, null);
            d.a("KeyManager", new Object[]{"wt ------getWorkKeyEncryptByCP cursor"});
            if (query != null) {
                if (query.moveToNext()) {
                    string = query.getString(query.getColumnIndex("backupValue"));
                } else {
                    string = str;
                }
                try {
                    query.close();
                } catch (SQLiteException e2) {
                    e = e2;
                    d.a("KeyManager", new Object[]{"getWorkKeyEncryptByCP1, ", e.getMessage()});
                    d.a("KeyManager", new Object[]{"getWorkKeyEncryptByCP, data_type:", Integer.valueOf(i), ";value is:", string});
                    return string;
                }
            }
            string = str;
        } catch (SQLiteException e3) {
            e = e3;
            string = str;
            d.a("KeyManager", new Object[]{"getWorkKeyEncryptByCP1, ", e.getMessage()});
            d.a("KeyManager", new Object[]{"getWorkKeyEncryptByCP, data_type:", Integer.valueOf(i), ";value is:", string});
            return string;
        }
        d.a("KeyManager", new Object[]{"getWorkKeyEncryptByCP, data_type:", Integer.valueOf(i), ";value is:", string});
        return string;
    }

    private static String m5484a(String str) {
        String string;
        SQLiteException e;
        String str2 = "";
        try {
            Cursor query = BaseApplication.m2632b().getContentResolver().query(Uri.parse(a.a + "module_" + 1009 + HwAccountConstants.SPLIIT_UNDERLINE + "backup_table"), null, "backupKey like ?", new String[]{str}, null);
            if (query != null) {
                if (query.moveToNext()) {
                    string = query.getString(query.getColumnIndex("backupValue"));
                } else {
                    string = str2;
                }
                try {
                    query.close();
                } catch (SQLiteException e2) {
                    e = e2;
                    d.a("KeyManager", new Object[]{"getWorkKeyEncryptByCP, ", e.getMessage()});
                    d.a("KeyManager", new Object[]{"getWorkKeyEncryptByCP, key:", str, ";value is:", string});
                    return string;
                }
            }
            string = str2;
        } catch (SQLiteException e3) {
            e = e3;
            string = str2;
            d.a("KeyManager", new Object[]{"getWorkKeyEncryptByCP, ", e.getMessage()});
            d.a("KeyManager", new Object[]{"getWorkKeyEncryptByCP, key:", str, ";value is:", string});
            return string;
        }
        d.a("KeyManager", new Object[]{"getWorkKeyEncryptByCP, key:", str, ";value is:", string});
        return string;
    }

    private static void m5503d() {
        d.a("KeyManager", new Object[]{"zzzz ====moveALLRootTOCP="});
        String string = BaseApplication.m2632b().getSharedPreferences("encrypt_sharedpreferences_name4", 0).getString("id", "");
        if (!"".equals(string)) {
            d.a("KeyManager", new Object[]{"zzzz ====C1====savetoCP=" + string});
            C1210c.m5486a("key_1", string);
            d.a("KeyManager", new Object[]{"zzzz ====C2====savetoCP=" + BaseApplication.m2632b().getSharedPreferences("encrypt_sharedpreferences_name2", 0).getString("id", "")});
            C1210c.m5486a("key_2", string);
            d.a("KeyManager", new Object[]{"zzzz ====C3====savetoCP=" + BaseApplication.m2632b().getSharedPreferences("encrypt_sharedpreferences_name3", 0).getString("id", "")});
            C1210c.m5486a("key_3", string);
        }
    }

    private static void m5510g(int i) {
        d.a("KeyManager", new Object[]{"zzzz ====moveWorkKeyToCP=" + i});
        String string = BaseApplication.m2632b().getSharedPreferences("encrypt_sharedpreferences_name1", 0).getString(String.valueOf(i), "");
        d.a("KeyManager", new Object[]{"zzzz ====moveWorkKeyToCP=" + string});
        if (!"".equals(string)) {
            d.a("KeyManager", new Object[]{"zzzz ====save to CP======"});
            C1210c.m5486a(String.valueOf(i), string);
        }
    }

    private static String m5511h(int i) {
        String a = C1210c.m5484a("key_" + i);
        com.huawei.whitebox.a a2 = com.huawei.whitebox.a.a();
        if ("".equals(a)) {
            for (int i2 = 0; i2 <= 30; i2++) {
                try {
                    f2646a.wait(300);
                } catch (Exception e) {
                    d.a("KeyManager", new Object[]{"wt ---retry---sleep "});
                }
                d.a("KeyManager", new Object[]{"wt -----retry -sleep for C", Integer.valueOf(i)});
                a = C1210c.m5484a("key_" + i);
                if (!"".equals(a)) {
                    d.a("KeyManager", new Object[]{"wt -----retry -sleep ok break for C", Integer.valueOf(i)});
                    break;
                }
            }
        }
        if ("".equals(a)) {
            d.a("KeyManager", new Object[]{"wt -----get-alwalys is null for C", Integer.valueOf(i)});
            return C1210c.m5515j(i);
        }
        try {
            CharSequence str = new String(a2.a(com.huawei.o.b.d.a(a)), GameManager.DEFAULT_CHARSET);
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            C2538c.m12680e("KeyManager", "getError for C", Integer.valueOf(i));
            return C1210c.m5515j(i);
        } catch (Exception e2) {
            C2538c.m12680e("KeyManager", "getKeyByString() Exception:", e2.getMessage());
            return C1210c.m5515j(i);
        }
    }

    private static byte[] m5506e() {
        try {
            SecureRandom secureRandom = new SecureRandom();
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init(256, secureRandom);
            return instance.generateKey().getEncoded();
        } catch (RuntimeException e) {
            return new byte[0];
        } catch (Exception e2) {
            return new byte[0];
        }
    }

    static byte[] m5488a() {
        try {
            SecureRandom secureRandom = new SecureRandom();
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init(128, secureRandom);
            return instance.generateKey().getEncoded();
        } catch (RuntimeException e) {
            return new byte[0];
        } catch (Exception e2) {
            return new byte[0];
        }
    }

    private static byte[] m5507f() {
        try {
            SecureRandom secureRandom = new SecureRandom();
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init(192, secureRandom);
            return instance.generateKey().getEncoded();
        } catch (RuntimeException e) {
            return new byte[0];
        } catch (Exception e2) {
            return new byte[0];
        }
    }

    private static String m5492b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int i = 0;
        String substring = com.huawei.o.b.d.b(bArr).substring(0, 32);
        String substring2 = com.huawei.o.b.d.b(bArr2).substring(0, 32);
        String substring3 = com.huawei.o.b.d.b(bArr3).substring(0, 32);
        char[] toCharArray = substring.toCharArray();
        char[] toCharArray2 = substring2.toCharArray();
        char[] toCharArray3 = substring3.toCharArray();
        char[] cArr = new char[toCharArray.length];
        while (i < cArr.length) {
            cArr[i] = (char) ((((toCharArray[i] << 4) ^ toCharArray2[i]) >> 6) ^ toCharArray3[i]);
            i++;
        }
        return String.valueOf(cArr);
    }

    private static void m5487a(String str, byte[] bArr, byte[] bArr2) {
        String b = com.huawei.o.b.d.b(bArr2);
        b = b + com.huawei.o.b.d.b(bArr);
        C2538c.m12677c("KeyManager", "-----saveWorkKeyToCP, ok:", "; data_type:" + str);
        C1210c.m5486a(str, b);
    }

    private static byte[] m5501c(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(1, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(bArr3));
        return instance.doFinal(bArr);
    }

    static byte[] m5491a(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        d.a("KeyManager", new Object[]{"desEncryptByte data is:", C0973a.m3509a(bArr), ";secret is:", C0973a.m3509a(bArr2), ";iv is:", C0973a.m3509a(bArr3)});
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(2, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(bArr3));
        return instance.doFinal(bArr);
    }

    private static String m5485a(String str, String str2, String str3) {
        char[] toCharArray = str.toCharArray();
        char[] toCharArray2 = str2.toCharArray();
        char[] toCharArray3 = str3.toCharArray();
        char[] cArr = new char[toCharArray.length];
        for (int i = 0; i < cArr.length; i++) {
            cArr[i] = (char) ((((toCharArray[i] << 4) ^ toCharArray2[i]) >> 6) ^ toCharArray3[i]);
        }
        return String.valueOf(cArr);
    }

    private static void m5486a(String str, String str2) {
        synchronized (f2646a) {
            C2538c.m12674b("KeyManager", "backUpSecretKey:", str);
            a.a(BaseApplication.m2632b(), String.valueOf(1009), "backup_table", 2, "backupKey  varchar primary key ,backupValue varchar");
            ContentValues contentValues = new ContentValues();
            contentValues.put("backupKey", str);
            contentValues.put("backupValue", str2);
            if (!C1210c.m5495b(str)) {
                a.a(BaseApplication.m2632b(), String.valueOf(1009), "backup_table", 2, contentValues);
            }
            C1210c.m5494b(str, str2);
        }
    }

    private static boolean m5495b(String str) {
        boolean z;
        SQLiteException e;
        try {
            Cursor query = BaseApplication.m2632b().getContentResolver().query(Uri.parse(a.a + "module_" + 1009 + HwAccountConstants.SPLIIT_UNDERLINE + "backup_table"), null, "backupKey like ?", new String[]{str}, null);
            if (query != null) {
                if (query.getCount() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                try {
                    query.close();
                } catch (SQLiteException e2) {
                    e = e2;
                    d.a("KeyManager", new Object[]{"isHave, ", e.getMessage()});
                    C2538c.m12674b("KeyManager", "isHave:", Boolean.valueOf(z));
                    return z;
                }
            }
            z = false;
        } catch (SQLiteException e3) {
            e = e3;
            z = false;
            d.a("KeyManager", new Object[]{"isHave, ", e.getMessage()});
            C2538c.m12674b("KeyManager", "isHave:", Boolean.valueOf(z));
            return z;
        }
        C2538c.m12674b("KeyManager", "isHave:", Boolean.valueOf(z));
        return z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m5493b() {
        /*
        r1 = 0;
        r3 = f2646a;
        monitor-enter(r3);
        r0 = "KeyManager";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x014c }
        r4 = 0;
        r5 = "initAllKey begin";
        r2[r4] = r5;	 Catch:{ all -> 0x014c }
        com.huawei.o.d.a(r0, r2);	 Catch:{ all -> 0x014c }
        r0 = com.huawei.hwcommonmodel.application.BaseApplication.m2632b();	 Catch:{ all -> 0x014c }
        r0 = r0.getFilesDir();	 Catch:{ all -> 0x014c }
        r0 = r0.getAbsolutePath();	 Catch:{ all -> 0x014c }
        r2 = new java.io.File;	 Catch:{ all -> 0x014c }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x014c }
        r4.<init>();	 Catch:{ all -> 0x014c }
        r4 = r4.append(r0);	 Catch:{ all -> 0x014c }
        r5 = "/lock.xml";
        r4 = r4.append(r5);	 Catch:{ all -> 0x014c }
        r4 = r4.toString();	 Catch:{ all -> 0x014c }
        r2.<init>(r4);	 Catch:{ all -> 0x014c }
        r4 = r2.exists();	 Catch:{ FileNotFoundException -> 0x035b, IOException -> 0x01be, Exception -> 0x0251, all -> 0x02e4 }
        if (r4 != 0) goto L_0x0053;
    L_0x003b:
        r2 = r2.createNewFile();	 Catch:{ FileNotFoundException -> 0x035b, IOException -> 0x01be, Exception -> 0x0251, all -> 0x02e4 }
        r4 = "KeyManager";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ FileNotFoundException -> 0x035b, IOException -> 0x01be, Exception -> 0x0251, all -> 0x02e4 }
        r6 = 0;
        r7 = "initAllKey create file result: ";
        r5[r6] = r7;	 Catch:{ FileNotFoundException -> 0x035b, IOException -> 0x01be, Exception -> 0x0251, all -> 0x02e4 }
        r6 = 1;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ FileNotFoundException -> 0x035b, IOException -> 0x01be, Exception -> 0x0251, all -> 0x02e4 }
        r5[r6] = r2;	 Catch:{ FileNotFoundException -> 0x035b, IOException -> 0x01be, Exception -> 0x0251, all -> 0x02e4 }
        com.huawei.o.d.a(r4, r5);	 Catch:{ FileNotFoundException -> 0x035b, IOException -> 0x01be, Exception -> 0x0251, all -> 0x02e4 }
    L_0x0053:
        r2 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x035b, IOException -> 0x01be, Exception -> 0x0251, all -> 0x02e4 }
        r4 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x035b, IOException -> 0x01be, Exception -> 0x0251, all -> 0x02e4 }
        r4.<init>();	 Catch:{ FileNotFoundException -> 0x035b, IOException -> 0x01be, Exception -> 0x0251, all -> 0x02e4 }
        r0 = r4.append(r0);	 Catch:{ FileNotFoundException -> 0x035b, IOException -> 0x01be, Exception -> 0x0251, all -> 0x02e4 }
        r4 = "/lock.xml";
        r0 = r0.append(r4);	 Catch:{ FileNotFoundException -> 0x035b, IOException -> 0x01be, Exception -> 0x0251, all -> 0x02e4 }
        r0 = r0.toString();	 Catch:{ FileNotFoundException -> 0x035b, IOException -> 0x01be, Exception -> 0x0251, all -> 0x02e4 }
        r4 = 1;
        r2.<init>(r0, r4);	 Catch:{ FileNotFoundException -> 0x035b, IOException -> 0x01be, Exception -> 0x0251, all -> 0x02e4 }
        r2 = r2.getChannel();	 Catch:{ FileNotFoundException -> 0x035b, IOException -> 0x01be, Exception -> 0x0251, all -> 0x02e4 }
    L_0x0070:
        if (r1 != 0) goto L_0x0078;
    L_0x0072:
        r1 = r2.tryLock();	 Catch:{ Exception -> 0x00bb, FileNotFoundException -> 0x00df, IOException -> 0x0358 }
        if (r1 == 0) goto L_0x00b3;
    L_0x0078:
        com.huawei.p111o.C1210c.m5509g();	 Catch:{ FileNotFoundException -> 0x00df, IOException -> 0x0358, Exception -> 0x0355 }
        r0 = 14;
        com.huawei.p111o.C1210c.m5514i(r0);	 Catch:{ FileNotFoundException -> 0x00df, IOException -> 0x0358, Exception -> 0x0355 }
        r0 = 13;
        com.huawei.p111o.C1210c.m5514i(r0);	 Catch:{ FileNotFoundException -> 0x00df, IOException -> 0x0358, Exception -> 0x0355 }
        r0 = 1;
        com.huawei.p111o.C1210c.m5514i(r0);	 Catch:{ FileNotFoundException -> 0x00df, IOException -> 0x0358, Exception -> 0x0355 }
        r0 = 2;
        com.huawei.p111o.C1210c.m5514i(r0);	 Catch:{ FileNotFoundException -> 0x00df, IOException -> 0x0358, Exception -> 0x0355 }
        if (r1 == 0) goto L_0x009f;
    L_0x008f:
        r0 = "KeyManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x014f }
        r5 = 0;
        r6 = "initAllKey  release";
        r4[r5] = r6;	 Catch:{ IOException -> 0x014f }
        com.huawei.o.d.a(r0, r4);	 Catch:{ IOException -> 0x014f }
        r1.release();	 Catch:{ IOException -> 0x014f }
    L_0x009f:
        if (r2 == 0) goto L_0x00b1;
    L_0x00a1:
        r0 = "KeyManager";
        r1 = 1;
        r1 = new java.lang.Object[r1];	 Catch:{ IOException -> 0x0174 }
        r4 = 0;
        r5 = "initAllKey  close";
        r1[r4] = r5;	 Catch:{ IOException -> 0x0174 }
        com.huawei.o.d.a(r0, r1);	 Catch:{ IOException -> 0x0174 }
        r2.close();	 Catch:{ IOException -> 0x0174 }
    L_0x00b1:
        monitor-exit(r3);	 Catch:{ all -> 0x014c }
        return;
    L_0x00b3:
        r0 = f2646a;	 Catch:{ Exception -> 0x00bb, FileNotFoundException -> 0x00df, IOException -> 0x0358 }
        r4 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r0.wait(r4);	 Catch:{ Exception -> 0x00bb, FileNotFoundException -> 0x00df, IOException -> 0x0358 }
        goto L_0x0070;
    L_0x00bb:
        r0 = move-exception;
        r4 = "KeyManager";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ FileNotFoundException -> 0x00df, IOException -> 0x0358, Exception -> 0x0355 }
        r6 = 0;
        r7 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x00df, IOException -> 0x0358, Exception -> 0x0355 }
        r7.<init>();	 Catch:{ FileNotFoundException -> 0x00df, IOException -> 0x0358, Exception -> 0x0355 }
        r8 = "initAllKey lock get error ";
        r7 = r7.append(r8);	 Catch:{ FileNotFoundException -> 0x00df, IOException -> 0x0358, Exception -> 0x0355 }
        r0 = r0.getMessage();	 Catch:{ FileNotFoundException -> 0x00df, IOException -> 0x0358, Exception -> 0x0355 }
        r0 = r7.append(r0);	 Catch:{ FileNotFoundException -> 0x00df, IOException -> 0x0358, Exception -> 0x0355 }
        r0 = r0.toString();	 Catch:{ FileNotFoundException -> 0x00df, IOException -> 0x0358, Exception -> 0x0355 }
        r5[r6] = r0;	 Catch:{ FileNotFoundException -> 0x00df, IOException -> 0x0358, Exception -> 0x0355 }
        com.huawei.o.d.a(r4, r5);	 Catch:{ FileNotFoundException -> 0x00df, IOException -> 0x0358, Exception -> 0x0355 }
        goto L_0x0070;
    L_0x00df:
        r0 = move-exception;
    L_0x00e0:
        r4 = "KeyManager";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0353 }
        r6 = 0;
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0353 }
        r7.<init>();	 Catch:{ all -> 0x0353 }
        r8 = "initAllKey exception1 ";
        r7 = r7.append(r8);	 Catch:{ all -> 0x0353 }
        r0 = r0.getMessage();	 Catch:{ all -> 0x0353 }
        r0 = r7.append(r0);	 Catch:{ all -> 0x0353 }
        r0 = r0.toString();	 Catch:{ all -> 0x0353 }
        r5[r6] = r0;	 Catch:{ all -> 0x0353 }
        com.huawei.o.d.a(r4, r5);	 Catch:{ all -> 0x0353 }
        if (r1 == 0) goto L_0x0114;
    L_0x0104:
        r0 = "KeyManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x0199 }
        r5 = 0;
        r6 = "initAllKey  release";
        r4[r5] = r6;	 Catch:{ IOException -> 0x0199 }
        com.huawei.o.d.a(r0, r4);	 Catch:{ IOException -> 0x0199 }
        r1.release();	 Catch:{ IOException -> 0x0199 }
    L_0x0114:
        if (r2 == 0) goto L_0x00b1;
    L_0x0116:
        r0 = "KeyManager";
        r1 = 1;
        r1 = new java.lang.Object[r1];	 Catch:{ IOException -> 0x0127 }
        r4 = 0;
        r5 = "initAllKey  close";
        r1[r4] = r5;	 Catch:{ IOException -> 0x0127 }
        com.huawei.o.d.a(r0, r1);	 Catch:{ IOException -> 0x0127 }
        r2.close();	 Catch:{ IOException -> 0x0127 }
        goto L_0x00b1;
    L_0x0127:
        r0 = move-exception;
        r1 = "KeyManager";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x014c }
        r4 = 0;
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x014c }
        r5.<init>();	 Catch:{ all -> 0x014c }
        r6 = "initAllKey exception6 ";
        r5 = r5.append(r6);	 Catch:{ all -> 0x014c }
        r0 = r0.getMessage();	 Catch:{ all -> 0x014c }
        r0 = r5.append(r0);	 Catch:{ all -> 0x014c }
        r0 = r0.toString();	 Catch:{ all -> 0x014c }
        r2[r4] = r0;	 Catch:{ all -> 0x014c }
        com.huawei.o.d.a(r1, r2);	 Catch:{ all -> 0x014c }
        goto L_0x00b1;
    L_0x014c:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x014c }
        throw r0;
    L_0x014f:
        r0 = move-exception;
        r1 = "KeyManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x014c }
        r5 = 0;
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x014c }
        r6.<init>();	 Catch:{ all -> 0x014c }
        r7 = "initAllKey exception5 ";
        r6 = r6.append(r7);	 Catch:{ all -> 0x014c }
        r0 = r0.getMessage();	 Catch:{ all -> 0x014c }
        r0 = r6.append(r0);	 Catch:{ all -> 0x014c }
        r0 = r0.toString();	 Catch:{ all -> 0x014c }
        r4[r5] = r0;	 Catch:{ all -> 0x014c }
        com.huawei.o.d.a(r1, r4);	 Catch:{ all -> 0x014c }
        goto L_0x009f;
    L_0x0174:
        r0 = move-exception;
        r1 = "KeyManager";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x014c }
        r4 = 0;
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x014c }
        r5.<init>();	 Catch:{ all -> 0x014c }
        r6 = "initAllKey exception6 ";
        r5 = r5.append(r6);	 Catch:{ all -> 0x014c }
        r0 = r0.getMessage();	 Catch:{ all -> 0x014c }
        r0 = r5.append(r0);	 Catch:{ all -> 0x014c }
        r0 = r0.toString();	 Catch:{ all -> 0x014c }
        r2[r4] = r0;	 Catch:{ all -> 0x014c }
        com.huawei.o.d.a(r1, r2);	 Catch:{ all -> 0x014c }
        goto L_0x00b1;
    L_0x0199:
        r0 = move-exception;
        r1 = "KeyManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x014c }
        r5 = 0;
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x014c }
        r6.<init>();	 Catch:{ all -> 0x014c }
        r7 = "initAllKey exception5 ";
        r6 = r6.append(r7);	 Catch:{ all -> 0x014c }
        r0 = r0.getMessage();	 Catch:{ all -> 0x014c }
        r0 = r6.append(r0);	 Catch:{ all -> 0x014c }
        r0 = r0.toString();	 Catch:{ all -> 0x014c }
        r4[r5] = r0;	 Catch:{ all -> 0x014c }
        com.huawei.o.d.a(r1, r4);	 Catch:{ all -> 0x014c }
        goto L_0x0114;
    L_0x01be:
        r0 = move-exception;
        r2 = r1;
    L_0x01c0:
        r4 = "KeyManager";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0353 }
        r6 = 0;
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0353 }
        r7.<init>();	 Catch:{ all -> 0x0353 }
        r8 = "initAllKey exception2 ";
        r7 = r7.append(r8);	 Catch:{ all -> 0x0353 }
        r0 = r0.getMessage();	 Catch:{ all -> 0x0353 }
        r0 = r7.append(r0);	 Catch:{ all -> 0x0353 }
        r0 = r0.toString();	 Catch:{ all -> 0x0353 }
        r5[r6] = r0;	 Catch:{ all -> 0x0353 }
        com.huawei.o.d.a(r4, r5);	 Catch:{ all -> 0x0353 }
        if (r1 == 0) goto L_0x01f4;
    L_0x01e4:
        r0 = "KeyManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x022d }
        r5 = 0;
        r6 = "initAllKey  release";
        r4[r5] = r6;	 Catch:{ IOException -> 0x022d }
        com.huawei.o.d.a(r0, r4);	 Catch:{ IOException -> 0x022d }
        r1.release();	 Catch:{ IOException -> 0x022d }
    L_0x01f4:
        if (r2 == 0) goto L_0x00b1;
    L_0x01f6:
        r0 = "KeyManager";
        r1 = 1;
        r1 = new java.lang.Object[r1];	 Catch:{ IOException -> 0x0208 }
        r4 = 0;
        r5 = "initAllKey  close";
        r1[r4] = r5;	 Catch:{ IOException -> 0x0208 }
        com.huawei.o.d.a(r0, r1);	 Catch:{ IOException -> 0x0208 }
        r2.close();	 Catch:{ IOException -> 0x0208 }
        goto L_0x00b1;
    L_0x0208:
        r0 = move-exception;
        r1 = "KeyManager";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x014c }
        r4 = 0;
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x014c }
        r5.<init>();	 Catch:{ all -> 0x014c }
        r6 = "initAllKey exception6 ";
        r5 = r5.append(r6);	 Catch:{ all -> 0x014c }
        r0 = r0.getMessage();	 Catch:{ all -> 0x014c }
        r0 = r5.append(r0);	 Catch:{ all -> 0x014c }
        r0 = r0.toString();	 Catch:{ all -> 0x014c }
        r2[r4] = r0;	 Catch:{ all -> 0x014c }
        com.huawei.o.d.a(r1, r2);	 Catch:{ all -> 0x014c }
        goto L_0x00b1;
    L_0x022d:
        r0 = move-exception;
        r1 = "KeyManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x014c }
        r5 = 0;
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x014c }
        r6.<init>();	 Catch:{ all -> 0x014c }
        r7 = "initAllKey exception5 ";
        r6 = r6.append(r7);	 Catch:{ all -> 0x014c }
        r0 = r0.getMessage();	 Catch:{ all -> 0x014c }
        r0 = r6.append(r0);	 Catch:{ all -> 0x014c }
        r0 = r0.toString();	 Catch:{ all -> 0x014c }
        r4[r5] = r0;	 Catch:{ all -> 0x014c }
        com.huawei.o.d.a(r1, r4);	 Catch:{ all -> 0x014c }
        goto L_0x01f4;
    L_0x0251:
        r0 = move-exception;
        r2 = r1;
    L_0x0253:
        r4 = "KeyManager";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0353 }
        r6 = 0;
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0353 }
        r7.<init>();	 Catch:{ all -> 0x0353 }
        r8 = "initAllKey exception4 ";
        r7 = r7.append(r8);	 Catch:{ all -> 0x0353 }
        r0 = r0.getMessage();	 Catch:{ all -> 0x0353 }
        r0 = r7.append(r0);	 Catch:{ all -> 0x0353 }
        r0 = r0.toString();	 Catch:{ all -> 0x0353 }
        r5[r6] = r0;	 Catch:{ all -> 0x0353 }
        com.huawei.o.d.a(r4, r5);	 Catch:{ all -> 0x0353 }
        if (r1 == 0) goto L_0x0287;
    L_0x0277:
        r0 = "KeyManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x02c0 }
        r5 = 0;
        r6 = "initAllKey  release";
        r4[r5] = r6;	 Catch:{ IOException -> 0x02c0 }
        com.huawei.o.d.a(r0, r4);	 Catch:{ IOException -> 0x02c0 }
        r1.release();	 Catch:{ IOException -> 0x02c0 }
    L_0x0287:
        if (r2 == 0) goto L_0x00b1;
    L_0x0289:
        r0 = "KeyManager";
        r1 = 1;
        r1 = new java.lang.Object[r1];	 Catch:{ IOException -> 0x029b }
        r4 = 0;
        r5 = "initAllKey  close";
        r1[r4] = r5;	 Catch:{ IOException -> 0x029b }
        com.huawei.o.d.a(r0, r1);	 Catch:{ IOException -> 0x029b }
        r2.close();	 Catch:{ IOException -> 0x029b }
        goto L_0x00b1;
    L_0x029b:
        r0 = move-exception;
        r1 = "KeyManager";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x014c }
        r4 = 0;
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x014c }
        r5.<init>();	 Catch:{ all -> 0x014c }
        r6 = "initAllKey exception6 ";
        r5 = r5.append(r6);	 Catch:{ all -> 0x014c }
        r0 = r0.getMessage();	 Catch:{ all -> 0x014c }
        r0 = r5.append(r0);	 Catch:{ all -> 0x014c }
        r0 = r0.toString();	 Catch:{ all -> 0x014c }
        r2[r4] = r0;	 Catch:{ all -> 0x014c }
        com.huawei.o.d.a(r1, r2);	 Catch:{ all -> 0x014c }
        goto L_0x00b1;
    L_0x02c0:
        r0 = move-exception;
        r1 = "KeyManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x014c }
        r5 = 0;
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x014c }
        r6.<init>();	 Catch:{ all -> 0x014c }
        r7 = "initAllKey exception5 ";
        r6 = r6.append(r7);	 Catch:{ all -> 0x014c }
        r0 = r0.getMessage();	 Catch:{ all -> 0x014c }
        r0 = r6.append(r0);	 Catch:{ all -> 0x014c }
        r0 = r0.toString();	 Catch:{ all -> 0x014c }
        r4[r5] = r0;	 Catch:{ all -> 0x014c }
        com.huawei.o.d.a(r1, r4);	 Catch:{ all -> 0x014c }
        goto L_0x0287;
    L_0x02e4:
        r0 = move-exception;
        r2 = r1;
    L_0x02e6:
        if (r1 == 0) goto L_0x02f8;
    L_0x02e8:
        r4 = "KeyManager";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ IOException -> 0x030b }
        r6 = 0;
        r7 = "initAllKey  release";
        r5[r6] = r7;	 Catch:{ IOException -> 0x030b }
        com.huawei.o.d.a(r4, r5);	 Catch:{ IOException -> 0x030b }
        r1.release();	 Catch:{ IOException -> 0x030b }
    L_0x02f8:
        if (r2 == 0) goto L_0x030a;
    L_0x02fa:
        r1 = "KeyManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x032f }
        r5 = 0;
        r6 = "initAllKey  close";
        r4[r5] = r6;	 Catch:{ IOException -> 0x032f }
        com.huawei.o.d.a(r1, r4);	 Catch:{ IOException -> 0x032f }
        r2.close();	 Catch:{ IOException -> 0x032f }
    L_0x030a:
        throw r0;	 Catch:{ all -> 0x014c }
    L_0x030b:
        r1 = move-exception;
        r4 = "KeyManager";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x014c }
        r6 = 0;
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x014c }
        r7.<init>();	 Catch:{ all -> 0x014c }
        r8 = "initAllKey exception5 ";
        r7 = r7.append(r8);	 Catch:{ all -> 0x014c }
        r1 = r1.getMessage();	 Catch:{ all -> 0x014c }
        r1 = r7.append(r1);	 Catch:{ all -> 0x014c }
        r1 = r1.toString();	 Catch:{ all -> 0x014c }
        r5[r6] = r1;	 Catch:{ all -> 0x014c }
        com.huawei.o.d.a(r4, r5);	 Catch:{ all -> 0x014c }
        goto L_0x02f8;
    L_0x032f:
        r1 = move-exception;
        r2 = "KeyManager";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x014c }
        r5 = 0;
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x014c }
        r6.<init>();	 Catch:{ all -> 0x014c }
        r7 = "initAllKey exception6 ";
        r6 = r6.append(r7);	 Catch:{ all -> 0x014c }
        r1 = r1.getMessage();	 Catch:{ all -> 0x014c }
        r1 = r6.append(r1);	 Catch:{ all -> 0x014c }
        r1 = r1.toString();	 Catch:{ all -> 0x014c }
        r4[r5] = r1;	 Catch:{ all -> 0x014c }
        com.huawei.o.d.a(r2, r4);	 Catch:{ all -> 0x014c }
        goto L_0x030a;
    L_0x0353:
        r0 = move-exception;
        goto L_0x02e6;
    L_0x0355:
        r0 = move-exception;
        goto L_0x0253;
    L_0x0358:
        r0 = move-exception;
        goto L_0x01c0;
    L_0x035b:
        r0 = move-exception;
        r2 = r1;
        goto L_0x00e0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.o.c.b():void");
    }

    private static void m5509g() {
        synchronized (f2646a) {
            C1210c.m5512h();
            C1210c.m5513i();
            C1210c.m5516j();
        }
    }

    private static void m5512h() {
        synchronized (f2646a) {
            String format = new SimpleDateFormat("MM").format(new Date(System.currentTimeMillis()));
            Object a = C1210c.m5484a("key_1");
            com.huawei.whitebox.a a2 = com.huawei.whitebox.a.a();
            if ("".equals(a)) {
                C1210c.m5503d();
                a = C1210c.m5484a("key_1");
                d.a("KeyManager", new Object[]{"zzzz ========-retry c1=====" + a});
            }
            if ("".equals(a)) {
                C1210c.m5486a("key_1", com.huawei.o.b.d.b(a2.a(format + com.huawei.o.b.d.b(C1210c.m5507f()))));
            }
        }
    }

    private static void m5513i() {
        synchronized (f2646a) {
            String a = C1210c.m5484a("key_2");
            com.huawei.whitebox.a a2 = com.huawei.whitebox.a.a();
            if ("".equals(a)) {
                C1210c.m5486a("key_2", com.huawei.o.b.d.b(a2.a(com.huawei.o.b.d.b(C1210c.m5507f()))));
            }
        }
    }

    private static void m5516j() {
        synchronized (f2646a) {
            String a = C1210c.m5484a("key_3");
            com.huawei.whitebox.a a2 = com.huawei.whitebox.a.a();
            if ("".equals(a)) {
                C1210c.m5486a("key_3", com.huawei.o.b.d.b(a2.a(com.huawei.o.b.d.b(C1210c.m5507f()))));
            }
        }
    }

    private static void m5514i(int i) {
        synchronized (f2646a) {
            String a = C0977d.m3528a(Process.myPid());
            C2538c.m12677c("KeyManager", "initSecurityKey---dataType:" + i, ";process id:" + r0, ";process name:" + a, ";main process:", BaseApplication.m2633c().m3521a());
            try {
                d.a("KeyManager", new Object[]{"wt ------initSecurityKey ok"});
                CharSequence e = C1210c.m5505e(i);
                d.a("KeyManager", new Object[]{"wt -------initSecurityKey-------get work key xxx" + e});
                if (TextUtils.isEmpty(e)) {
                    C1210c.m5510g(i);
                    e = C1210c.m5505e(i);
                    d.a("KeyManager", new Object[]{"zzzz ====initSecurityKey retry workkey=" + e});
                }
                if (TextUtils.isEmpty(e)) {
                    byte[] a2 = C1210c.m5488a();
                    d.a("KeyManager", new Object[]{"wt -------initSecurityKey-------get work key secret_info is null"});
                    byte[] e2 = C1210c.m5506e();
                    byte[] e3 = C1210c.m5506e();
                    byte[] e4 = C1210c.m5506e();
                    d.a("KeyManager", new Object[]{"wt -------initSecurityKey-------get work key null getkey"});
                    d.a("KeyManager", new Object[]{"wt -------initSecurityKey-------get work key secret is " + C0973a.m3509a(C1210c.m5492b(e2, e3, e4).getBytes(GameManager.DEFAULT_CHARSET))});
                    d.a("KeyManager", new Object[]{"wt -------initSecurityKey-------get work key work enc key:" + C0973a.m3509a(C1210c.m5501c(e2, C1210c.m5497c().getBytes(GameManager.DEFAULT_CHARSET), a2))});
                    C2538c.m12677c("KeyManager", "----initSecurityKey---------clearSharedPreferences1, ok: dataType:" + i);
                    C1210c.m5487a(String.valueOf(i), e2, a2);
                    d.a("KeyManager", new Object[]{"wt ---initSecurityKey-----------completed"});
                } else {
                    d.a("KeyManager", new Object[]{"wt ---initSecurityKey-----------get work key2"});
                }
            } catch (Exception e5) {
                C2538c.m12680e("KeyManager", "initSecurityKey:", e5.getMessage());
            }
        }
    }

    private static String m5515j(int i) {
        d.a("KeyManager", new Object[]{"getCxByBackupCP() begin C", Integer.valueOf(i)});
        String c = C1210c.m5499c("key_" + i);
        com.huawei.whitebox.a a = com.huawei.whitebox.a.a();
        if ("".equals(c)) {
            d.a("KeyManager", new Object[]{"wt -----getCxByBackupCP is null, in C", Integer.valueOf(i)});
            return "";
        }
        try {
            String str = new String(a.a(com.huawei.o.b.d.a(c)), GameManager.DEFAULT_CHARSET);
            C1210c.m5500c("key_" + i, c);
            return str;
        } catch (Exception e) {
            C2538c.m12680e("KeyManager", "getCxByBackupCP(),C", Integer.valueOf(i), " Exception:", e.getMessage());
            return "";
        }
    }

    static byte[] m5490a(int i, byte[] bArr) {
        d.a("KeyManager", new Object[]{"wt ------getWorkKeyByBackupCP begin"});
        String[] strArr = new String[]{String.valueOf(i)};
        Cursor query = BaseApplication.m2632b().getContentResolver().query(Uri.parse(f2647b + "backupCp"), null, "backupKey like ?", strArr, null);
        String str = "";
        if (query != null) {
            if (query.moveToNext()) {
                str = query.getString(query.getColumnIndex("backupValue"));
            }
            query.close();
        }
        d.a("KeyManager", new Object[]{"getWorkKeyByBackupCP, data_type:", Integer.valueOf(i), ";value is:", str});
        if (TextUtils.isEmpty(str) || str.length() < 24) {
            d.a("KeyManager", new Object[]{"wt ---getWorkKeyByBackupCP-----------length error"});
            return null;
        }
        d.a("KeyManager", new Object[]{"wt ---getWorkKeyByBackupCP-----------get work key2"});
        d.a("KeyManager", new Object[]{"wt --------getWorkKeyByBackupCP------get work key2, iv is:", str.substring(0, 24), ";key is:", str.substring(24, str.length())});
        try {
            byte[] a = C1210c.m5491a(com.huawei.o.b.d.a(str.substring(24, str.length())), bArr, com.huawei.o.b.d.a(str.substring(0, 24)));
            C1210c.m5500c(r6, str);
            return a;
        } catch (Exception e) {
            d.a("KeyManager", new Object[]{"wt --------getWorkKeyByBackupCP------get work key iv is:", r3, ";key is:", r4});
            return null;
        }
    }

    private static String m5499c(String str) {
        String[] strArr = new String[]{str};
        Cursor query = BaseApplication.m2632b().getContentResolver().query(Uri.parse(f2647b + "backupCp"), null, "backupKey like ?", strArr, null);
        String str2 = "";
        if (query != null) {
            if (query.moveToNext()) {
                str2 = query.getString(query.getColumnIndex("backupValue"));
            }
            query.close();
        }
        d.a("KeyManager", new Object[]{"getBackupCPData, key:", str, ";value is:", str2});
        return str2;
    }

    private static void m5494b(String str, String str2) {
        synchronized (f2646a) {
            C2538c.m12674b("KeyManager", "backUpSecretKeyRetry:", str);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("create table IF NOT EXISTS backupCp(");
            stringBuffer.append("backupKey  varchar primary key ,backupValue varchar");
            stringBuffer.append(")");
            C0994a.m3605a(BaseApplication.m2632b()).m3607a(String.valueOf(stringBuffer));
            ContentValues contentValues = new ContentValues();
            contentValues.put("backupKey", str);
            contentValues.put("backupValue", str2);
            if (!C1210c.m5504d(str)) {
                BaseApplication.m2632b().getContentResolver().insert(Uri.parse(f2647b + "backupCp"), contentValues);
            }
        }
    }

    private static boolean m5504d(String str) {
        boolean z;
        String[] strArr = new String[]{str};
        Cursor query = BaseApplication.m2632b().getContentResolver().query(Uri.parse(f2647b + "backupCp"), null, "backupKey like ?", strArr, null);
        if (query != null) {
            if (query.getCount() > 0) {
                z = true;
            } else {
                z = false;
            }
            query.close();
        } else {
            z = false;
        }
        C2538c.m12674b("KeyManager", "isHaveInBackupCp:", Boolean.valueOf(z));
        return z;
    }

    private static void m5500c(String str, String str2) {
        synchronized (f2646a) {
            C2538c.m12674b("KeyManager", "updateSecretKey:", str);
            a.a(BaseApplication.m2632b(), String.valueOf(1009), "backup_table", 2, "backupKey  varchar primary key ,backupValue varchar");
            ContentValues contentValues = new ContentValues();
            contentValues.put("backupKey", str);
            contentValues.put("backupValue", str2);
            if (C1210c.m5495b(str)) {
                try {
                    BaseApplication.m2632b().getContentResolver().update(Uri.parse(a.a + "module_" + 1009 + HwAccountConstants.SPLIIT_UNDERLINE + "backup_table"), contentValues, "backupKey like ?", new String[]{str});
                } catch (SQLiteException e) {
                    d.a("KeyManager", new Object[]{"updateSecretKey, ", e.getMessage()});
                }
            }
        }
    }
}
