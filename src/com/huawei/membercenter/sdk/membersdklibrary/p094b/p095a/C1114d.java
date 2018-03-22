package com.huawei.membercenter.sdk.membersdklibrary.p094b.p095a;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

/* compiled from: RetData */
public class C1114d {
    @SerializedName("responseCode")
    private String f2352a;
    @SerializedName("responseDesc")
    private String f2353b;
    @SerializedName("responseData")
    private JsonObject f2354c;

    public String m4975a() {
        return this.f2352a;
    }

    public void m4976a(String str) {
        this.f2352a = str;
    }

    public String m4977b() {
        return this.f2353b;
    }

    public void m4978b(String str) {
        this.f2353b = str;
    }

    public JsonObject m4979c() {
        return this.f2354c;
    }
}
