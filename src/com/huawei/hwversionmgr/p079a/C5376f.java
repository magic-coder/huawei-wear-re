package com.huawei.hwversionmgr.p079a;

import android.content.Context;
import com.huawei.p111o.C5704b;
import com.huawei.p190v.C2538c;

import java.io.Serializable;
import org.json.JSONObject;

/* compiled from: RuleAttrInfo */
public class C5376f implements Serializable {
    public int f19136a = 0;
    public String f19137b = "";
    public String f19138c = "";

    public void m25850a(Context context, String str) {
        C2538c.b("RuleAttrInfo", new Object[]{"parseRuleAttr=  ruleAttr json : " + str});
        String a = C5704b.m26317a(context).m26326a(str);
        C2538c.b("RuleAttrInfo", new Object[]{"decrypt ruleAttr json : " + a});
        if (a != null) {
            try {
                JSONObject jSONObject = new JSONObject(a);
                if (jSONObject.has("mincode")) {
                    this.f19136a = Integer.parseInt(jSONObject.getString("mincode"));
                }
                if (jSONObject.has("forcedupdate")) {
                    this.f19137b = jSONObject.getString("forcedupdate");
                }
                if (jSONObject.has("appforcedupdate")) {
                    this.f19138c = jSONObject.getString("appforcedupdate");
                }
            } catch (Exception e) {
                C2538c.e("RuleAttrInfo", new Object[]{"Exception e1 = " + e.getMessage()});
            }
        }
    }
}
