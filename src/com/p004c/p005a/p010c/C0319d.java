package com.p004c.p005a.p010c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import com.huawei.nfc.carrera.storage.db.DataModel.RFConfInfoColumns;
import com.p004c.p005a.p006a.p007a.C0312a;
import com.p004c.p005a.p008b.p009a.C0313a;
import com.p004c.p005a.p008b.p009a.C0314b;
import com.p004c.p005a.p008b.p009a.C0315c;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.Cipher;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class C0319d implements Runnable {
    boolean f165a;
    private Context f166b;
    private JSONObject f167c;

    public C0319d(Context context, JSONObject jSONObject, boolean z) {
        this.f166b = context;
        this.f167c = jSONObject;
        this.f165a = z;
    }

    private String m160a(byte[] bArr) {
        String format = String.format("%016d", new Object[]{Long.valueOf(Math.abs(new SecureRandom().nextLong() % 10000000000000000L))});
        try {
            byte[] a = C0314b.m148a(format, bArr);
            byte[] bytes = format.getBytes(GameManager.DEFAULT_CHARSET);
            RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(new BigInteger("24907259431961377209480304447420314675278854956424737688244507998454379688588314890162679979323703303509240796245532111474023047392580178709435281576624542294613207523485034492914828565153172773053351891188090398210811384185501117117991603774176386409127476628856566065613009756131651597266262540467980974946876675842468600552312158771248419700603327630677244315755445967726919102965015263135288381740211593751262078285738436597133664401598420056690274760726854877181978220226448211936820860496708860964018593025172845041095854180953040116559241637133730839837036910305932797451786785855051024967644159284784940216337"), new BigInteger("65537")));
            if (rSAPublicKey == null) {
                throw new UnsupportedEncodingException();
            }
            Cipher instance = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-1ANDMGF1PADDING");
            instance.init(1, rSAPublicKey);
            byte[] doFinal = instance.doFinal(bytes);
            return "{\"vs\":\"" + C0313a.m141e(this.f166b) + "\",\"ed\":\"" + C0313a.m136b(a) + "\",\"ek\":\"" + C0313a.m136b(doFinal) + "\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean m161a(JSONObject jSONObject, String str) {
        String toLowerCase = str.toLowerCase();
        try {
            byte[] a = C0313a.m132a(jSONObject.toString().getBytes(GameManager.DEFAULT_CHARSET));
            if (a == null) {
                return false;
            }
            String a2 = m160a(a);
            if (a2 == null) {
                return false;
            }
            try {
                a = a2.getBytes(GameManager.DEFAULT_CHARSET);
                if (toLowerCase.indexOf("https") >= 0) {
                    return false;
                }
                C0313a.m146h();
                return C0318c.m159a(str, a);
            } catch (UnsupportedEncodingException e) {
                new StringBuilder("UnsupportedEncodingException:").append(e.getMessage());
                C0313a.m146h();
                return false;
            }
        } catch (UnsupportedEncodingException e2) {
            new StringBuilder("UnsupportedEncodingException:").append(e2.getMessage());
            C0313a.m146h();
            return false;
        }
    }

    public final void run() {
        try {
            if (this.f167c.getString("type") != null) {
                Context context = this.f166b;
                JSONObject jSONObject = this.f167c;
                boolean z = this.f165a;
                String a = C0312a.m127a(context);
                if (a == null) {
                    C0313a.m146h();
                    return;
                }
                JSONObject b = C0315c.m151b(context, "cached");
                JSONObject jSONObject2 = new JSONObject();
                try {
                    String string = jSONObject.getString("type");
                    if (string != null) {
                        JSONArray jSONArray;
                        jSONObject.remove("type");
                        Object obj = 1;
                        if (b == null) {
                            b = new JSONObject();
                            jSONArray = new JSONArray();
                        } else if (b.isNull(string)) {
                            jSONArray = new JSONArray();
                        } else {
                            obj = null;
                            jSONArray = b.getJSONArray(string);
                        }
                        if (!z || r2 == null) {
                            if (!z) {
                                jSONArray.put(jSONObject);
                            }
                            JSONArray jSONArray2 = new JSONArray();
                            int length = jSONArray.length();
                            for (int i = 0; i <= length - 1; i++) {
                                JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                                JSONArray jSONArray3;
                                if (jSONObject3.has("b")) {
                                    jSONArray3 = jSONObject3.getJSONArray("b");
                                    if (jSONArray3 != null && jSONArray3.length() > 0) {
                                        String[] split = jSONArray3.getString(jSONArray3.length() - 1).split(",");
                                        if (((System.currentTimeMillis() / 1000) - C0313a.m128a(split[1])) - Long.parseLong(split[2]) < C0313a.m133b().longValue()) {
                                            jSONArray2.put(jSONObject3);
                                        } else {
                                            C0313a.m146h();
                                        }
                                    }
                                } else if (jSONObject3.has("e")) {
                                    jSONArray3 = jSONObject3.getJSONArray("e");
                                    if (jSONArray3 != null && jSONArray3.length() > 0) {
                                        if ((System.currentTimeMillis() / 1000) - C0313a.m128a(jSONArray3.getString(jSONArray3.length() - 1).split(",")[2]) < C0313a.m133b().longValue()) {
                                            jSONArray2.put(jSONObject3);
                                        } else {
                                            C0313a.m146h();
                                        }
                                    }
                                }
                            }
                            if (jSONArray2.length() <= 0) {
                                C0313a.m146h();
                                return;
                            }
                            b.remove(string);
                            b.put(string, jSONArray2);
                            jSONObject2.put("g", a);
                            jSONObject2.put("s", jSONArray2);
                            new StringBuilder("message=").append(jSONObject2.toString());
                            C0313a.m146h();
                            if (m161a(jSONObject2, C0313a.m147i())) {
                                SharedPreferences a2 = C0315c.m149a(context, "flag");
                                if (C0313a.m144f(context)) {
                                    Editor edit = a2.edit();
                                    edit.putString(RFConfInfoColumns.COLUMN_NAME_ROM_VERSION, Build.DISPLAY);
                                    edit.commit();
                                }
                                C0315c.m152c(context, "cached");
                                C0313a.m146h();
                                return;
                            }
                            C0315c.m150a(context, b, "cached");
                            C0313a.m146h();
                            return;
                        }
                        C0313a.m146h();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    C0315c.m152c(context, "cached");
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            C0315c.m152c(this.f166b, "cached");
        }
    }
}
