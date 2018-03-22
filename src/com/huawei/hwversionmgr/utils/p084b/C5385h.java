package com.huawei.hwversionmgr.utils.p084b;

import android.text.TextUtils;
import com.huawei.hwappdfxmgr.upload.UploadFile;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwversionmgr.a.e;
import com.huawei.hwversionmgr.p079a.C5376f;
import com.huawei.p190v.C2538c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BuildNewVersionInfoXMLUtil */
public class C5385h {
    public static e m25899a(String str) {
        Object e;
        RuntimeException runtimeException;
        String str2 = "";
        e eVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int parseInt = Integer.parseInt(jSONObject.getString("status"));
            C2538c.c("BuildNewVersionInfoXML", new Object[]{"check new version status= " + parseInt});
            if (parseInt == 1) {
                eVar = new e();
                try {
                    eVar.t = parseInt;
                } catch (RuntimeException e2) {
                    e = e2;
                    C2538c.c("BuildNewVersionInfoXML", new Object[]{"RuntimeException e1 = " + e});
                    return eVar;
                } catch (Exception e3) {
                    e = e3;
                    C2538c.c("BuildNewVersionInfoXML", new Object[]{"Exception e = " + e});
                    return eVar;
                }
                return eVar;
            }
            JSONObject jSONObject2;
            if (jSONObject.has("components")) {
                JSONArray jSONArray = jSONObject.getJSONArray("components");
                if (jSONArray.length() == 1) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(0);
                    C2538c.c("BuildNewVersionInfoXML", new Object[]{"componentjson is " + jSONObject3.toString()});
                    e eVar2 = new e();
                    try {
                        eVar2.t = parseInt;
                        C5385h.m25901a(eVar2, jSONObject3);
                        if (jSONObject3.has("ruleAttr")) {
                            str2 = jSONObject3.getString("ruleAttr");
                            C2538c.c("BuildNewVersionInfoXML", new Object[]{"ruleAttr = " + str2});
                            if (!TextUtils.isEmpty(str2)) {
                                C5385h.m25900a(eVar2, str2);
                            }
                        }
                        eVar = eVar2;
                        if (jSONObject.has("config")) {
                            jSONObject2 = jSONObject.getJSONObject("config");
                            if (!(jSONObject2 == null || !jSONObject2.has("forceRemind") || eVar == null)) {
                                eVar.o = Integer.parseInt(jSONObject2.getString("forceRemind"));
                            }
                        }
                        if (jSONObject.has("autoPollingCycle") && eVar != null) {
                            eVar.v = Integer.parseInt(jSONObject.getString("autoPollingCycle"));
                            C2538c.c("BuildNewVersionInfoXML", new Object[]{"autoPollingCycle return,autoPollingCycle=" + eVar.v});
                        }
                    } catch (RuntimeException e4) {
                        runtimeException = e4;
                        eVar = eVar2;
                        C2538c.c("BuildNewVersionInfoXML", new Object[]{"RuntimeException e1 = " + e});
                        return eVar;
                    } catch (Exception e5) {
                        Exception exception = e5;
                        eVar = eVar2;
                        C2538c.c("BuildNewVersionInfoXML", new Object[]{"Exception e = " + e});
                        return eVar;
                    }
                    return eVar;
                }
            }
            eVar = null;
            if (jSONObject.has("config")) {
                jSONObject2 = jSONObject.getJSONObject("config");
                eVar.o = Integer.parseInt(jSONObject2.getString("forceRemind"));
            }
            eVar.v = Integer.parseInt(jSONObject.getString("autoPollingCycle"));
            C2538c.c("BuildNewVersionInfoXML", new Object[]{"autoPollingCycle return,autoPollingCycle=" + eVar.v});
            return eVar;
        } catch (RuntimeException e42) {
            RuntimeException runtimeException2 = e42;
            eVar = null;
            runtimeException = runtimeException2;
            C2538c.c("BuildNewVersionInfoXML", new Object[]{"RuntimeException e1 = " + e});
            return eVar;
        } catch (Exception e52) {
            Exception exception2 = e52;
            eVar = null;
            e = exception2;
            C2538c.c("BuildNewVersionInfoXML", new Object[]{"Exception e = " + e});
            return eVar;
        }
    }

    private static void m25901a(e eVar, JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("name")) {
            eVar.a = jSONObject.getString("name");
        }
        if (jSONObject.has("version")) {
            eVar.b = jSONObject.getString("version");
        }
        if (jSONObject.has("versionID")) {
            eVar.c = jSONObject.getString("versionID");
        }
        if (jSONObject.has("description")) {
            eVar.d = jSONObject.getString("description");
        }
        if (jSONObject.has("url")) {
            eVar.e = jSONObject.getString("url");
        }
        if (jSONObject.has("createTime")) {
            eVar.f = jSONObject.getString("createTime");
        }
        if (jSONObject.has(UploadFile.SIZE_LABEL)) {
            eVar.h = jSONObject.getString(UploadFile.SIZE_LABEL);
        }
        if (jSONObject.has("componentID")) {
            eVar.g = Integer.parseInt(jSONObject.getString("componentID"));
        }
    }

    private static void m25900a(e eVar, String str) {
        C5376f c5376f = new C5376f();
        c5376f.m25850a(BaseApplication.b(), str);
        C2538c.c("BuildNewVersionInfoXML", new Object[]{"minAppCode is " + c5376f.f19136a});
        C2538c.c("BuildNewVersionInfoXML", new Object[]{"appForcedUpdate is " + c5376f.f19138c});
        C2538c.c("BuildNewVersionInfoXML", new Object[]{"forcedUpdate is " + c5376f.f19137b});
        if (c5376f.f19136a != 0) {
            eVar.w = c5376f.f19136a;
        }
        if (!TextUtils.isEmpty(c5376f.f19138c) && c5376f.f19138c.equals("true")) {
            eVar.y = c5376f.f19138c;
        }
        if (!TextUtils.isEmpty(c5376f.f19137b) && c5376f.f19137b.equals("true")) {
            eVar.x = c5376f.f19137b;
        }
    }
}
