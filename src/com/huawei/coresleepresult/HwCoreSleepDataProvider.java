package com.huawei.coresleepresult;

import com.android.volley.DefaultRetryPolicy;
import com.huawei.coresleepresult.p381a.C4359a;
import com.huawei.coresleepresult.p381a.C4360b;
import com.huawei.coresleepresult.p381a.C4361c;
import com.huawei.coresleepresult.p381a.C4362d;
import com.huawei.hihealth.p036a.C4509c;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.p190v.C2538c;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HwCoreSleepDataProvider {
    public static final String f16194a = HwCoreSleepDataProvider.class.getSimpleName();
    ArrayList<C4360b> f16195b = new ArrayList();
    ArrayList<C4362d> f16196c = new ArrayList();
    ArrayList<C4361c> f16197d = new ArrayList();
    private int f16198e = 0;
    private int f16199f = 30;

    private native String GetSleepResult(byte[] bArr, byte[] bArr2, int i);

    private native void SetUserInfo(int i, int i2);

    public HwCoreSleepDataProvider() {
        try {
            System.loadLibrary("DetailSleepJni");
            C2538c.c(f16194a, new Object[]{"load so success"});
        } catch (Exception e) {
            C2538c.c(f16194a, new Object[]{"load so fail" + e.getMessage()});
        }
    }

    public void m20947a(ArrayList<byte[]> arrayList, ArrayList<byte[]> arrayList2, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.c(f16194a, new Object[]{"enter getCoreSleepProcessResult()"});
        if (arrayList2 == null || arrayList2.size() <= 0) {
            if (iBaseResponseCallback != null) {
                iBaseResponseCallback.onResponse(100001, null);
            }
            C2538c.c(f16194a, new Object[]{"leave getCoreSleepProcessResult strStatusContent size == 0"});
            return;
        }
        int c = m20945c(m20946a(null));
        byte[] a = m20941a((ArrayList) arrayList2);
        if (a == null || a.length <= 0) {
            if (iBaseResponseCallback != null) {
                iBaseResponseCallback.onResponse(100001, null);
            }
            c.c(f16194a, new Object[]{"leave getCoreSleepProcessResult status size == 0"});
            return;
        }
        String GetSleepResult;
        if (arrayList == null || arrayList.size() <= 0) {
            c.c(f16194a, new Object[]{"parseByteList 2"});
            GetSleepResult = GetSleepResult(a, null, c);
        } else {
            c.c(f16194a, new Object[]{"parseByteList 1"});
            byte[] a2 = m20941a((ArrayList) arrayList);
            m20939a();
            SetUserInfo(this.f16199f, this.f16198e);
            GetSleepResult = GetSleepResult(a, a2, c);
        }
        c.c(f16194a, new Object[]{"jstr_ret =" + GetSleepResult});
        this.f16195b.clear();
        this.f16196c.clear();
        this.f16197d.clear();
        try {
            JSONObject jSONObject = new JSONObject(GetSleepResult);
            c = jSONObject.getInt("err_code");
            if (c == 0) {
                m20940a(jSONObject);
            }
            C4359a c4359a = new C4359a();
            c4359a.m20949a(this.f16196c);
            c4359a.m20951b(this.f16195b);
            c4359a.m20953c(this.f16197d);
            c.c(f16194a, new Object[]{"data = " + c4359a});
            iBaseResponseCallback.onResponse(c, c4359a);
        } catch (JSONException e) {
            c.c(f16194a, new Object[]{"data = null" + e.getMessage()});
            if (iBaseResponseCallback != null) {
                iBaseResponseCallback.onResponse(100001, null);
            }
        }
        c.c(f16194a, new Object[]{"leave getCoreSleepProcessResult"});
    }

    private void m20940a(JSONObject jSONObject) {
        try {
            JSONArray jSONArray;
            int i;
            if (jSONObject.has("status_in_minute_arr")) {
                C2538c.c(f16194a, new Object[]{"has status_in_minute_arr"});
                jSONArray = jSONObject.getJSONArray("status_in_minute_arr");
                for (i = 0; i < jSONArray.length(); i++) {
                    C4362d c4362d = new C4362d();
                    c4362d.m20980a(jSONArray.getJSONObject(i).getLong("start_time"));
                    c4362d.m20983b(jSONArray.getJSONObject(i).getLong("end_time"));
                    String string = jSONArray.getJSONObject(i).getString("status");
                    if (!string.isEmpty()) {
                        c4362d.m20981a(m20944b(string));
                    }
                    this.f16196c.add(c4362d);
                }
            }
            if (jSONObject.has("status_in_day_arr")) {
                C2538c.c(f16194a, new Object[]{"has status_in_day_arr"});
                jSONArray = jSONObject.getJSONArray("status_in_day_arr");
                for (i = 0; i < jSONArray.length(); i++) {
                    C4360b c4360b = new C4360b();
                    float f = (float) jSONArray.getJSONObject(i).getDouble("valid_data");
                    c4360b.m20955a(f);
                    if (f == DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
                        c4360b.m20957a(jSONArray.getJSONObject(i).getLong("start_time"));
                        c4360b.m20960b(jSONArray.getJSONObject(i).getLong("fall_asleep_time"));
                        c4360b.m20963c(jSONArray.getJSONObject(i).getLong("wake_up_time"));
                        this.f16195b.add(c4360b);
                    } else {
                        c4360b.m20957a(jSONArray.getJSONObject(i).getLong("start_time"));
                        c4360b.m20960b(jSONArray.getJSONObject(i).getLong("fall_asleep_time"));
                        c4360b.m20963c(jSONArray.getJSONObject(i).getLong("wake_up_time"));
                        c4360b.m20956a(jSONArray.getJSONObject(i).getInt("sleep_score"));
                        c4360b.m20959b(jSONArray.getJSONObject(i).getInt("sleep_latency"));
                        c4360b.m20966d(jSONArray.getJSONObject(i).getLong("go_bed_time"));
                        c4360b.m20962c(jSONArray.getJSONObject(i).getInt("sleep_efficiency"));
                        c4360b.m20968e(jSONArray.getJSONObject(i).getInt("snore_freq"));
                        c4360b.m20965d(jSONArray.getJSONObject(i).getInt("deep_sleep_part_cnt"));
                        this.f16195b.add(c4360b);
                    }
                }
            }
            if (jSONObject.has("err_code_arr")) {
                C2538c.c(f16194a, new Object[]{"has err_code_arr"});
                jSONArray = jSONObject.getJSONArray("err_code_arr");
                for (i = 0; i < jSONArray.length(); i++) {
                    C4361c c4361c = new C4361c();
                    c4361c.m20976a(jSONArray.getJSONObject(i).getLong("start_time"));
                    c4361c.m20978b(jSONArray.getJSONObject(i).getLong("end_time"));
                    c4361c.m20975a(jSONArray.getJSONObject(i).getInt("err_code"));
                    this.f16197d.add(c4361c);
                }
            }
        } catch (Exception e) {
            C2538c.c(f16194a, new Object[]{"procResultData FAIL" + e.getMessage()});
        }
    }

    private ArrayList<Integer> m20944b(String str) {
        ArrayList<Integer> arrayList = new ArrayList();
        for (int i = 0; i < str.length(); i++) {
            arrayList.add(i, Integer.valueOf(Integer.parseInt(str.substring(i, i + 1))));
        }
        C2538c.c(f16194a, new Object[]{"ret = " + arrayList});
        return arrayList;
    }

    private byte[] m20941a(ArrayList<byte[]> arrayList) {
        int i;
        int i2;
        if (arrayList.size() > 0) {
            i = 0;
            for (i2 = 0; i2 < arrayList.size(); i2++) {
                i += ((byte[]) arrayList.get(i2)).length;
            }
        } else {
            i = 0;
        }
        Object obj = new byte[i];
        i = 0;
        for (i2 = 0; i2 < arrayList.size(); i2++) {
            System.arraycopy(arrayList.get(i2), 0, obj, i, ((byte[]) arrayList.get(i2)).length);
            i += ((byte[]) arrayList.get(i2)).length;
        }
        return obj;
    }

    public String m20946a(String str) {
        if (str != null && !str.isEmpty()) {
            return str;
        }
        return new SimpleDateFormat("Z").format(Calendar.getInstance().getTime());
    }

    private int m20945c(String str) {
        int i = 1;
        if (str.contains("+")) {
            C2538c.c(f16194a, new Object[]{"+"});
            str = str.substring(1);
        } else if (str.contains("-")) {
            C2538c.c(f16194a, new Object[]{"-"});
            str = str.substring(1);
            i = -1;
        }
        return i * Integer.parseInt(str);
    }

    private void m20939a() {
        C2538c.c(f16194a, new Object[]{"enter getUserInfo"});
        C4509c.m21594a(BaseApplication.b()).m21617b(new C4363a(this));
    }
}
