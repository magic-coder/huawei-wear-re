package com.huawei.android.pushselfshow.p337b;

import android.text.TextUtils;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.p338c.C4152a;
import com.sina.weibo.sdk.component.GameManager;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C4149a implements Serializable {
    public String f15560A;
    public String f15561B;
    public String f15562C;
    public String f15563D;
    public String f15564E = "";
    public int f15565F = 1;
    public int f15566G = 0;
    public String f15567H;
    public String f15568I;
    public String f15569J;
    public int f15570K = C4152a.STYLE_1.ordinal();
    public int f15571L = 0;
    public String[] f15572M = null;
    public String[] f15573N = null;
    public String[] f15574O = null;
    public int f15575P = 0;
    public String[] f15576Q = null;
    public String f15577R = "";
    public String f15578S = "";
    public String f15579a;
    public String f15580b;
    public String f15581c;
    public String f15582d;
    public int f15583e;
    public String f15584f;
    public int f15585g;
    public String f15586h;
    public int f15587i;
    public int f15588j;
    public String f15589k;
    public String f15590l = "";
    public String f15591m;
    public String f15592n;
    public String f15593o;
    public String f15594p;
    public String f15595q = "";
    public String f15596r;
    public String f15597s;
    public String f15598t;
    public String f15599u;
    public String f15600v;
    public String f15601w;
    public String f15602x;
    public String f15603y = "";
    public String f15604z;

    public C4149a(byte[] bArr, byte[] bArr2) {
        try {
            this.f15568I = new String(bArr, GameManager.DEFAULT_CHARSET);
            this.f15569J = new String(bArr2, GameManager.DEFAULT_CHARSET);
        } catch (Exception e) {
            e.d("PushSelfShowLog", "get msg byte arr error");
        }
    }

    private boolean m20258a(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("param");
            if (jSONObject2.has("autoClear")) {
                this.f15583e = jSONObject2.getInt("autoClear");
            } else {
                this.f15583e = 0;
            }
            if ("app".equals(this.f15593o) || "cosa".equals(this.f15593o)) {
                if (jSONObject2.has("acn")) {
                    this.f15560A = jSONObject2.getString("acn");
                    this.f15584f = this.f15560A;
                }
                if (jSONObject2.has("intentUri")) {
                    this.f15584f = jSONObject2.getString("intentUri");
                }
                if (jSONObject2.has("appPackageName")) {
                    this.f15604z = jSONObject2.getString("appPackageName");
                } else {
                    e.a("PushSelfShowLog", "appPackageName is null");
                    return false;
                }
            } else if ("email".equals(this.f15593o)) {
                if (jSONObject2.has("emailAddr") && jSONObject2.has("emailSubject")) {
                    this.f15601w = jSONObject2.getString("emailAddr");
                    this.f15602x = jSONObject2.getString("emailSubject");
                    if (jSONObject2.has("emailContent")) {
                        this.f15603y = jSONObject2.getString("emailContent");
                    }
                } else {
                    e.a("PushSelfShowLog", "emailAddr or emailSubject is null");
                    return false;
                }
            } else if ("phone".equals(this.f15593o)) {
                if (jSONObject2.has("phoneNum")) {
                    this.f15600v = jSONObject2.getString("phoneNum");
                } else {
                    e.a("PushSelfShowLog", "phoneNum is null");
                    return false;
                }
            } else if ("url".equals(this.f15593o)) {
                if (jSONObject2.has("url")) {
                    this.f15561B = jSONObject2.getString("url");
                    if (jSONObject2.has("inBrowser")) {
                        this.f15565F = jSONObject2.getInt("inBrowser");
                    }
                    if (jSONObject2.has("needUserId")) {
                        this.f15566G = jSONObject2.getInt("needUserId");
                    }
                    if (jSONObject2.has("sign")) {
                        this.f15567H = jSONObject2.getString("sign");
                    }
                    if (jSONObject2.has("rpt") && jSONObject2.has("rpl")) {
                        this.f15562C = jSONObject2.getString("rpl");
                        this.f15563D = jSONObject2.getString("rpt");
                        if (jSONObject2.has("rpct")) {
                            this.f15564E = jSONObject2.getString("rpct");
                        }
                    }
                } else {
                    e.a("PushSelfShowLog", "url is null");
                    return false;
                }
            } else if ("rp".equals(this.f15593o)) {
                if (jSONObject2.has("rpt") && jSONObject2.has("rpl")) {
                    this.f15562C = jSONObject2.getString("rpl");
                    this.f15563D = jSONObject2.getString("rpt");
                    if (jSONObject2.has("rpct")) {
                        this.f15564E = jSONObject2.getString("rpct");
                    }
                    if (jSONObject2.has("needUserId")) {
                        this.f15566G = jSONObject2.getInt("needUserId");
                    }
                } else {
                    e.a("PushSelfShowLog", "rpl or rpt is null");
                    return false;
                }
            }
            return true;
        } catch (Throwable e) {
            e.c("PushSelfShowLog", "ParseParam error ", e);
            return false;
        }
    }

    private boolean m20259b(JSONObject jSONObject) {
        e.a("PushSelfShowLog", "enter parseNotifyParam");
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("notifyParam");
            if (!jSONObject2.has("style")) {
                return false;
            }
            int i;
            String str;
            this.f15570K = jSONObject2.getInt("style");
            e.a("PushSelfShowLog", "style:" + this.f15570K);
            if (jSONObject2.has("btnCount")) {
                this.f15571L = jSONObject2.getInt("btnCount");
            }
            if (this.f15571L > 0) {
                if (this.f15571L > 3) {
                    this.f15571L = 3;
                }
                e.a("PushSelfShowLog", "btnCount:" + this.f15571L);
                this.f15572M = new String[this.f15571L];
                this.f15573N = new String[this.f15571L];
                this.f15574O = new String[this.f15571L];
                for (i = 0; i < this.f15571L; i++) {
                    str = "btn" + (i + 1) + "Text";
                    String str2 = "btn" + (i + 1) + "Image";
                    String str3 = "btn" + (i + 1) + "Event";
                    if (jSONObject2.has(str)) {
                        this.f15572M[i] = jSONObject2.getString(str);
                    }
                    if (jSONObject2.has(str2)) {
                        this.f15573N[i] = jSONObject2.getString(str2);
                    }
                    if (jSONObject2.has(str3)) {
                        this.f15574O[i] = jSONObject2.getString(str3);
                    }
                }
            }
            C4152a c4152a = C4152a.STYLE_1;
            if (this.f15570K >= 0 && this.f15570K < C4152a.values().length) {
                c4152a = C4152a.values()[this.f15570K];
            }
            switch (C4150b.f15605a[c4152a.ordinal()]) {
                case 1:
                    if (jSONObject2.has("iconCount")) {
                        this.f15575P = jSONObject2.getInt("iconCount");
                    }
                    if (this.f15575P > 0) {
                        if (this.f15575P > 6) {
                            this.f15575P = 6;
                        }
                        e.a("PushSelfShowLog", "iconCount:" + this.f15575P);
                        this.f15576Q = new String[this.f15575P];
                        for (i = 0; i < this.f15575P; i++) {
                            str = "icon" + (i + 1);
                            if (jSONObject2.has(str)) {
                                this.f15576Q[i] = jSONObject2.getString(str);
                            }
                        }
                        break;
                    }
                    break;
                case 2:
                    if (jSONObject2.has("subTitle")) {
                        this.f15577R = jSONObject2.getString("subTitle");
                        e.a("PushSelfShowLog", "subTitle:" + this.f15577R);
                        break;
                    }
                    break;
                case 3:
                case 4:
                    if (jSONObject2.has("bigPic")) {
                        this.f15578S = jSONObject2.getString("bigPic");
                        e.a("PushSelfShowLog", "bigPicUrl:" + this.f15578S);
                        break;
                    }
                    break;
            }
            return true;
        } catch (JSONException e) {
            e.b("PushSelfShowLog", e.toString());
            return false;
        }
    }

    public String m20260a() {
        e.a("PushSelfShowLog", "msgId =" + this.f15590l);
        return this.f15590l;
    }

    public boolean m20261b() {
        try {
            if (this.f15569J == null || this.f15569J.length() == 0) {
                e.a("PushSelfShowLog", "token is null");
                return false;
            }
            this.f15586h = this.f15569J;
            if (this.f15568I == null || this.f15568I.length() == 0) {
                e.a("PushSelfShowLog", "msg is null");
                return false;
            }
            JSONObject jSONObject = new JSONObject(this.f15568I);
            this.f15585g = jSONObject.getInt("msgType");
            if (this.f15585g != 1) {
                e.a("PushSelfShowLog", "not a selefShowMsg");
                return false;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("msgContent");
            if (jSONObject2 == null) {
                e.b("PushSelfShowLog", "msgObj == null");
                return false;
            } else if (jSONObject2.has("msgId")) {
                Object obj = jSONObject2.get("msgId");
                if (obj instanceof String) {
                    this.f15590l = (String) obj;
                } else if (obj instanceof Integer) {
                    this.f15590l = String.valueOf(((Integer) obj).intValue());
                }
                if (jSONObject2.has("dispPkgName")) {
                    this.f15591m = jSONObject2.getString("dispPkgName");
                }
                if (jSONObject2.has("rtn")) {
                    this.f15588j = jSONObject2.getInt("rtn");
                } else {
                    this.f15588j = 1;
                }
                if (jSONObject2.has("fm")) {
                    this.f15587i = jSONObject2.getInt("fm");
                } else {
                    this.f15587i = 1;
                }
                if (jSONObject2.has("ap")) {
                    String string = jSONObject2.getString("ap");
                    StringBuilder stringBuilder = new StringBuilder();
                    if (TextUtils.isEmpty(string) || string.length() >= 48) {
                        this.f15589k = string.substring(0, 48);
                    } else {
                        for (int i = 0; i < 48 - string.length(); i++) {
                            stringBuilder.append("0");
                        }
                        stringBuilder.append(string);
                        this.f15589k = stringBuilder.toString();
                    }
                }
                if (jSONObject2.has("extras")) {
                    this.f15592n = jSONObject2.getJSONArray("extras").toString();
                }
                if (!jSONObject2.has("psContent")) {
                    return false;
                }
                jSONObject = jSONObject2.getJSONObject("psContent");
                if (jSONObject == null) {
                    return false;
                }
                this.f15593o = jSONObject.getString("cmd");
                if (jSONObject.has("content")) {
                    this.f15594p = jSONObject.getString("content");
                } else {
                    this.f15594p = "";
                }
                if (jSONObject.has("notifyIcon")) {
                    this.f15595q = jSONObject.getString("notifyIcon");
                } else {
                    this.f15595q = "" + this.f15590l;
                }
                if (jSONObject.has("statusIcon")) {
                    this.f15597s = jSONObject.getString("statusIcon");
                }
                if (jSONObject.has("notifyTitle")) {
                    this.f15596r = jSONObject.getString("notifyTitle");
                }
                if (jSONObject.has("notifyParam")) {
                    m20259b(jSONObject);
                }
                return jSONObject.has("param") ? m20258a(jSONObject) : false;
            } else {
                e.b("PushSelfShowLog", "msgId == null");
                return false;
            }
        } catch (Throwable e) {
            e.a("PushSelfShowLog", e.toString(), e);
            return false;
        }
    }

    public byte[] m20262c() {
        try {
            String str = "";
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("autoClear", this.f15583e);
            jSONObject4.put("s", this.f15579a);
            jSONObject4.put("r", this.f15580b);
            jSONObject4.put("smsC", this.f15581c);
            jSONObject4.put("mmsUrl", this.f15582d);
            jSONObject4.put("url", this.f15561B);
            jSONObject4.put("inBrowser", this.f15565F);
            jSONObject4.put("needUserId", this.f15566G);
            jSONObject4.put("sign", this.f15567H);
            jSONObject4.put("rpl", this.f15562C);
            jSONObject4.put("rpt", this.f15563D);
            jSONObject4.put("rpct", this.f15564E);
            jSONObject4.put("appPackageName", this.f15604z);
            jSONObject4.put("acn", this.f15560A);
            jSONObject4.put("intentUri", this.f15584f);
            jSONObject4.put("emailAddr", this.f15601w);
            jSONObject4.put("emailSubject", this.f15602x);
            jSONObject4.put("emailContent", this.f15603y);
            jSONObject4.put("phoneNum", this.f15600v);
            jSONObject4.put("replyToSms", this.f15599u);
            jSONObject4.put("smsNum", this.f15598t);
            jSONObject3.put("cmd", this.f15593o);
            jSONObject3.put("content", this.f15594p);
            jSONObject3.put("notifyIcon", this.f15595q);
            jSONObject3.put("notifyTitle", this.f15596r);
            jSONObject3.put("statusIcon", this.f15597s);
            jSONObject3.put("param", jSONObject4);
            jSONObject2.put("dispPkgName", this.f15591m);
            jSONObject2.put("msgId", this.f15590l);
            jSONObject2.put("fm", this.f15587i);
            jSONObject2.put("ap", this.f15589k);
            jSONObject2.put("rtn", this.f15588j);
            jSONObject2.put("psContent", jSONObject3);
            if (this.f15592n != null && this.f15592n.length() > 0) {
                jSONObject2.put("extras", new JSONArray(this.f15592n));
            }
            jSONObject.put("msgType", this.f15585g);
            jSONObject.put("msgContent", jSONObject2);
            return jSONObject.toString().getBytes(GameManager.DEFAULT_CHARSET);
        } catch (Throwable e) {
            e.a("PushSelfShowLog", "getMsgData failed JSONException:", e);
            return new byte[0];
        } catch (Throwable e2) {
            e.a("PushSelfShowLog", "getMsgData failed UnsupportedEncodingException:", e2);
            return new byte[0];
        }
    }

    public byte[] m20263d() {
        try {
            if (this.f15586h != null && this.f15586h.length() > 0) {
                return this.f15586h.getBytes(GameManager.DEFAULT_CHARSET);
            }
        } catch (Throwable e) {
            e.a("PushSelfShowLog", "getToken getByte failed ", e);
        }
        return new byte[0];
    }
}
