package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.huawei.hwappdfxmgr.upload.UploadFile;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import org.json.JSONObject;

/* compiled from: UpdateItem */
public class C3337r {
    public int f11829a = 6;
    private String f11830b = null;
    private String f11831c = null;
    private String f11832d = null;
    private String f11833e = null;
    private String f11834f = "";
    private long f11835g = 0;
    private long f11836h = 0;
    private String f11837i = "";
    private String f11838j;
    private int f11839k;
    private boolean f11840l = false;
    private int f11841m;
    private String f11842n = "";
    private Context f11843o;

    public C3337r(OfflineMapCity offlineMapCity, Context context) {
        this.f11843o = context;
        this.f11830b = offlineMapCity.getCity();
        this.f11832d = offlineMapCity.getAdcode();
        this.f11831c = offlineMapCity.getUrl();
        this.f11836h = offlineMapCity.getSize();
        m16235a();
        this.f11834f = offlineMapCity.getVersion();
        this.f11842n = offlineMapCity.getCode();
        this.f11840l = false;
        this.f11829a = offlineMapCity.getState();
        this.f11841m = offlineMapCity.getcompleteCode();
    }

    public C3337r(OfflineMapProvince offlineMapProvince, Context context) {
        this.f11843o = context;
        this.f11830b = offlineMapProvince.getProvinceName();
        this.f11832d = offlineMapProvince.getProvinceCode();
        this.f11831c = offlineMapProvince.getUrl();
        this.f11836h = offlineMapProvince.getSize();
        m16235a();
        this.f11834f = offlineMapProvince.getVersion();
        this.f11840l = true;
        this.f11829a = offlineMapProvince.getState();
        this.f11841m = offlineMapProvince.getcompleteCode();
    }

    protected void m16235a() {
        this.f11833e = bk.m15673b(this.f11843o) + this.f11832d + LightCloudConstants.ZIP_POSTFIX + ".tmp";
    }

    public void m16240b() {
        this.f11829a = 6;
        m16241b(0);
        m16237a(0);
    }

    public String m16244c() {
        return this.f11830b;
    }

    public void m16238a(String str) {
        this.f11830b = str;
    }

    public String m16247d() {
        return this.f11834f;
    }

    public void m16243b(String str) {
        this.f11834f = str;
    }

    public String m16249e() {
        return this.f11833e;
    }

    public void m16246c(String str) {
        this.f11833e = str;
    }

    public String m16251f() {
        return this.f11832d;
    }

    public void m16248d(String str) {
        this.f11832d = str;
    }

    public String m16253g() {
        return this.f11831c;
    }

    public void m16250e(String str) {
        this.f11831c = str;
    }

    public long m16255h() {
        return this.f11836h;
    }

    public void m16237a(long j) {
        this.f11835g = j;
    }

    public void m16236a(int i) {
        this.f11839k = i;
    }

    public int m16257i() {
        return this.f11839k;
    }

    public long m16259j() {
        return this.f11835g;
    }

    public void m16242b(long j) {
        this.f11835g = j;
    }

    public long m16260k() {
        return this.f11836h;
    }

    public void m16245c(long j) {
        this.f11836h = j;
    }

    public String m16261l() {
        return this.f11837i;
    }

    public void m16252f(String str) {
        this.f11837i = str;
    }

    public String m16262m() {
        return this.f11838j;
    }

    public void m16254g(String str) {
        this.f11838j = str;
    }

    public boolean m16263n() {
        return this.f11840l;
    }

    public void m16239a(boolean z) {
        this.f11840l = z;
    }

    public void m16241b(int i) {
        this.f11841m = i;
    }

    public int m16264o() {
        return this.f11841m;
    }

    public void m16256h(String str) {
        this.f11842n = str;
    }

    public String m16265p() {
        return this.f11842n;
    }

    public void m16258i(String str) {
        if (str != null) {
            try {
                if (!str.equals("")) {
                    JSONObject jSONObject = new JSONObject(str).getJSONObject("file");
                    if (jSONObject != null) {
                        this.f11830b = jSONObject.optString("title");
                        this.f11832d = jSONObject.optString("code");
                        this.f11831c = jSONObject.optString("url");
                        this.f11833e = jSONObject.optString(UploadFile.FILE_NAME);
                        this.f11835g = jSONObject.optLong("lLocalLength");
                        this.f11836h = jSONObject.optLong("lRemoteLength");
                        this.f11829a = jSONObject.optInt("mState");
                        this.f11834f = jSONObject.optString("version");
                        this.f11838j = jSONObject.optString("localPath");
                        this.f11837i = jSONObject.optString("vMapFileNames");
                        this.f11840l = jSONObject.optBoolean("isSheng");
                        this.f11841m = jSONObject.optInt("mCompleteCode");
                        this.f11842n = jSONObject.optString("mCityCode");
                    }
                }
            } catch (Throwable e) {
                ca.m15831a(e, "UpdateItem", "readFileToJSONObject");
                e.printStackTrace();
            }
        }
    }

    public void m16266q() {
        Throwable e;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("title", this.f11830b);
            jSONObject2.put("code", this.f11832d);
            jSONObject2.put("url", this.f11831c);
            jSONObject2.put(UploadFile.FILE_NAME, this.f11833e);
            jSONObject2.put("lLocalLength", this.f11835g);
            jSONObject2.put("lRemoteLength", this.f11836h);
            jSONObject2.put("mState", this.f11829a);
            jSONObject2.put("version", this.f11834f);
            jSONObject2.put("localPath", this.f11838j);
            if (this.f11837i != null) {
                jSONObject2.put("vMapFileNames", this.f11837i);
            }
            jSONObject2.put("isSheng", this.f11840l);
            jSONObject2.put("mCompleteCode", this.f11841m);
            jSONObject2.put("mCityCode", this.f11842n);
            jSONObject.put("file", jSONObject2);
            File file = new File(this.f11833e + ".dt");
            file.delete();
            OutputStreamWriter outputStreamWriter;
            try {
                outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file, true), "utf-8");
                try {
                    outputStreamWriter.write(jSONObject.toString());
                    if (outputStreamWriter != null) {
                        try {
                            outputStreamWriter.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        ca.m15831a(e, "UpdateItem", "saveJSONObjectToFile");
                        e.printStackTrace();
                        if (outputStreamWriter != null) {
                            try {
                                outputStreamWriter.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                        }
                    } catch (Throwable th) {
                        e = th;
                        if (outputStreamWriter != null) {
                            try {
                                outputStreamWriter.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw e;
                    }
                }
            } catch (IOException e5) {
                e = e5;
                outputStreamWriter = null;
                ca.m15831a(e, "UpdateItem", "saveJSONObjectToFile");
                e.printStackTrace();
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
            } catch (Throwable th2) {
                e = th2;
                outputStreamWriter = null;
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
                throw e;
            }
        } catch (Throwable e6) {
            ca.m15831a(e6, "UpdateItem", "saveJSONObjectToFile parseJson");
            e6.printStackTrace();
        }
    }
}
