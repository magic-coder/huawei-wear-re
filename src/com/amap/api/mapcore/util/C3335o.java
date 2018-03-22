package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.amap.api.mapcore.C3264r;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.huawei.hwid.core.datatype.SMSKeyInfo;
import com.snowballtech.business.BuildConfig;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: OfflineUpdateCityHandler */
public class C3335o extends aj<String, List<OfflineMapProvince>> {
    private Context f11824j;

    protected /* synthetic */ Object mo4064b(String str) throws AMapException {
        return m16222a(str);
    }

    protected /* synthetic */ Object mo4067b(byte[] bArr) throws AMapException {
        return mo4066a(bArr);
    }

    public C3335o(Context context, String str) {
        super(context, str);
        getClass();
        m15468a(5000);
        getClass();
        m15471b(50000);
    }

    public void m16224a(Context context) {
        this.f11824j = context;
    }

    protected List<OfflineMapProvince> mo4066a(byte[] bArr) throws AMapException {
        List<OfflineMapProvince> arrayList = new ArrayList();
        try {
            String str = new String(bArr, "utf-8");
            bk.m15663a(str);
            if (!(str == null || "".equals(str))) {
                String optString = new JSONObject(str).optString("status");
                if (!(optString == null || optString.equals("") || optString.equals("0"))) {
                    arrayList = m16222a(str);
                }
            }
        } catch (Throwable th) {
            ca.m15831a(th, "OfflineUpdateCityHandler", "loadData jsonInit");
            th.printStackTrace();
        }
        return arrayList;
    }

    private void m16220c(String str) {
        OutputStream fileOutputStream;
        Throwable e;
        if (!bk.m15673b(this.f11824j).equals("")) {
            File file = new File(bk.m15673b(this.f11824j) + "offlinemapv4.png");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Throwable e2) {
                    ca.m15831a(e2, "OfflineUpdateCityHandler", "writeSD dirCreate");
                    e2.printStackTrace();
                }
            }
            if (b_() > 1048576) {
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        fileOutputStream.write(str.getBytes("utf-8"));
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                    } catch (FileNotFoundException e4) {
                        e = e4;
                        try {
                            ca.m15831a(e, "OfflineUpdateCityHandler", "writeSD filenotfound");
                            e.printStackTrace();
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e32) {
                                    e32.printStackTrace();
                                }
                            }
                        } catch (Throwable th) {
                            e = th;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            throw e;
                        }
                    } catch (IOException e6) {
                        e = e6;
                        ca.m15831a(e, "OfflineUpdateCityHandler", "writeSD io");
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e322) {
                                e322.printStackTrace();
                            }
                        }
                    }
                } catch (FileNotFoundException e7) {
                    e = e7;
                    fileOutputStream = null;
                    ca.m15831a(e, "OfflineUpdateCityHandler", "writeSD filenotfound");
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (IOException e8) {
                    e = e8;
                    fileOutputStream = null;
                    ca.m15831a(e, "OfflineUpdateCityHandler", "writeSD io");
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (Throwable th2) {
                    e = th2;
                    fileOutputStream = null;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw e;
                }
            }
        }
    }

    public long b_() {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return 0;
        }
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    public String mo4002a() {
        return "http://restapi.amap.com/v3/config/resource";
    }

    protected List<OfflineMapProvince> m16222a(String str) throws AMapException {
        List<OfflineMapProvince> list = null;
        try {
            if (this.f11824j != null) {
                m16220c(str);
            }
        } catch (Throwable th) {
            ca.m15831a(th, "OfflineUpdateCityHandler", "loadData jsonInit");
            th.printStackTrace();
        }
        try {
            list = ag.m15460c(str);
        } catch (Throwable th2) {
            ca.m15831a(th2, "OfflineUpdateCityHandler", "loadData parseJson");
            th2.printStackTrace();
        }
        return list;
    }

    public Map<String, String> mo4003b() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put(SMSKeyInfo.TAG_KEY, bm.m15690f(this.f11824j));
        hashMap.put("opertype", "offlinemap_with_province_vfour");
        hashMap.put("plattype", "android");
        hashMap.put(BuildConfig.environment, C3264r.f11366b);
        hashMap.put("version", "3.2.0.1");
        hashMap.put("ext", "standard");
        hashMap.put("output", "json");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=").append(bm.m15690f(this.f11824j));
        stringBuffer.append("&opertype=offlinemap_with_province_vfour");
        stringBuffer.append("&plattype=android");
        stringBuffer.append("&product=").append(C3264r.f11366b);
        stringBuffer.append("&version=").append("3.2.0.1");
        stringBuffer.append("&ext=standard");
        stringBuffer.append("&output=json");
        String a = bw.m15798a(stringBuffer.toString());
        String a2 = bo.m15699a();
        hashMap.put("ts", a2);
        hashMap.put("scode", bo.m15702a(this.f11824j, a2, a));
        return hashMap;
    }
}
