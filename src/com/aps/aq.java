package com.aps;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.amap.api.location.core.C3191c;
import com.amap.api.location.core.C3193e;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.WeightedLatLng;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: Cache */
public class aq {
    String f12939a = null;
    private LinkedHashMap<String, List<ar>> f12940b = new LinkedHashMap();
    private bn f12941c = null;
    private long f12942d = 0;

    aq(Context context) {
        try {
            if (this.f12939a == null) {
                this.f12939a = C3193e.m14147a("MD5", C3191c.m14122b());
            }
            if (context != null) {
                File a = m17331a(context);
                if (a != null) {
                    this.f12941c = bn.m17428a(a, 1, 1048576);
                }
            }
        } catch (Throwable th) {
        }
    }

    private File m17331a(Context context) {
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getExternalCacheDir().getAbsolutePath()).append(File.separator);
        stringBuilder.append("locationCache");
        try {
            m17332a(new File(stringBuilder.toString()));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        stringBuilder.delete(0, stringBuilder.length());
        stringBuilder.append(context.getExternalCacheDir().getAbsolutePath()).append(File.separator);
        stringBuilder.append("newlocationCache");
        return new File(stringBuilder.toString());
    }

    private void m17332a(File file) {
        if (file != null && file.exists()) {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File a : listFiles) {
                    m17332a(a);
                }
                file.delete();
            }
        }
    }

    void m17338a(String str, ap apVar, StringBuilder stringBuilder) {
        if (!ax.f12981k) {
            m17337a();
        } else if (m17339a(str, apVar) && !apVar.m17307i().equals("mem")) {
            int i;
            String d;
            if (str == null || !str.contains("wifi")) {
                if (!(str == null || !str.contains("cell") || stringBuilder.indexOf(",") == -1)) {
                    return;
                }
            } else if (!TextUtils.isEmpty(stringBuilder)) {
                if (apVar.m17303g() >= BitmapDescriptorFactory.HUE_MAGENTA) {
                    i = 0;
                    for (String d2 : stringBuilder.toString().split("#")) {
                        if (d2.contains(",")) {
                            i++;
                        }
                    }
                    if (i >= 6) {
                        return;
                    }
                } else if (apVar.m17303g() <= 10.0f) {
                    return;
                }
            } else {
                return;
            }
            this.f12942d = bu.m17460b();
            ar arVar = new ar();
            apVar.m17304g("mem");
            arVar.m17342a(apVar);
            if (stringBuilder != null) {
                arVar.m17343a(stringBuilder.toString());
            }
            if (this.f12940b == null) {
                this.f12940b = new LinkedHashMap();
            }
            if (str != null) {
                List list;
                if (this.f12940b.containsKey(str)) {
                    list = (List) this.f12940b.get(str);
                    if (!(list == null || list.contains(arVar))) {
                        list.add(0, arVar);
                    }
                    if (list != null) {
                        this.f12940b.remove(str);
                        this.f12940b.put(str, list);
                    }
                } else {
                    list = new ArrayList();
                    list.add(arVar);
                    this.f12940b.put(str, list);
                }
                try {
                    Map a;
                    if (this.f12939a == null) {
                        this.f12939a = C3193e.m14147a("MD5", C3191c.m14122b());
                    }
                    if (stringBuilder == null || stringBuilder.length() == 0) {
                        stringBuilder = new StringBuilder("cell#");
                    }
                    if (this.f12941c != null) {
                        a = this.f12941c.m17433a(str);
                    } else {
                        a = null;
                    }
                    d2 = C3193e.m14160d(stringBuilder.toString().getBytes(), this.f12939a);
                    String d3 = C3193e.m14160d(apVar.m17328u().getBytes(), this.f12939a);
                    String str2;
                    Iterator it;
                    if (a == null || a.size() == 0) {
                        Map hashMap = new HashMap();
                        hashMap.put(d2, d3);
                        if (this.f12941c != null) {
                            this.f12941c.m17435b(str, hashMap);
                        }
                        str2 = "";
                        if (this.f12940b.size() > 360) {
                            it = this.f12940b.entrySet().iterator();
                            if (it != null && it.hasNext()) {
                                this.f12940b.remove((String) ((Entry) it.next()).getKey());
                                return;
                            }
                        }
                    }
                    Iterator it2 = a.entrySet().iterator();
                    while (it2 != null && it2.hasNext()) {
                        Entry entry = (Entry) it2.next();
                        if (m17334a(C3193e.m14153b((String) entry.getKey(), this.f12939a), stringBuilder.toString())) {
                            a.remove(entry.getKey());
                            a.put(d2, d3);
                            this.f12941c.m17435b(str, a);
                            i = 0;
                            break;
                        }
                    }
                    i = 1;
                    if (i != 0) {
                        a.put(d2, d3);
                        this.f12941c.m17435b(str, a);
                    }
                    str2 = "";
                    if (this.f12940b.size() > 360) {
                        it = this.f12940b.entrySet().iterator();
                        if (it != null) {
                        }
                    }
                } catch (IOException e) {
                } catch (Exception e2) {
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    com.aps.ap m17336a(java.lang.String r7, java.lang.StringBuilder r8, java.lang.String r9) {
        /*
        r6 = this;
        r1 = -1;
        r2 = 0;
        r0 = "mem";
        r0 = r9.equals(r0);
        if (r0 == 0) goto L_0x0012;
    L_0x000a:
        r0 = com.aps.ax.f12981k;
        if (r0 != 0) goto L_0x0012;
    L_0x000e:
        r6.m17337a();
    L_0x0011:
        return r2;
    L_0x0012:
        r0 = "";
        if (r7 == 0) goto L_0x00c1;
    L_0x0016:
        r0 = "#cellwifi";
        r0 = r7.indexOf(r0);
        if (r0 == r1) goto L_0x00c1;
    L_0x001e:
        r0 = "#cellwifi";
        r0 = r6.m17330a(r7, r8, r0, r9);
        if (r0 == 0) goto L_0x00bd;
    L_0x0026:
        r1 = "found#cellwifi";
    L_0x0028:
        r1 = r6.f12939a;
        if (r1 != 0) goto L_0x0032;
    L_0x002c:
        r1 = com.amap.api.location.core.C3191c.m14122b();
        r6.f12939a = r1;
    L_0x0032:
        if (r0 != 0) goto L_0x0177;
    L_0x0034:
        if (r8 == 0) goto L_0x003c;
    L_0x0036:
        r1 = r8.length();	 Catch:{ JSONException -> 0x0164, IOException -> 0x0159, Throwable -> 0x014e }
        if (r1 != 0) goto L_0x0043;
    L_0x003c:
        r8 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x0164, IOException -> 0x0159, Throwable -> 0x014e }
        r1 = "cell#";
        r8.<init>(r1);	 Catch:{ JSONException -> 0x0164, IOException -> 0x0159, Throwable -> 0x014e }
    L_0x0043:
        r1 = r6.f12941c;	 Catch:{ JSONException -> 0x0164, IOException -> 0x0159, Throwable -> 0x014e }
        if (r1 == 0) goto L_0x0174;
    L_0x0047:
        r1 = r6.f12941c;	 Catch:{ JSONException -> 0x0164, IOException -> 0x0159, Throwable -> 0x014e }
        r1 = r1.m17433a(r7);	 Catch:{ JSONException -> 0x0164, IOException -> 0x0159, Throwable -> 0x014e }
    L_0x004d:
        if (r1 == 0) goto L_0x0171;
    L_0x004f:
        r1 = r1.entrySet();	 Catch:{ JSONException -> 0x0164, IOException -> 0x0159, Throwable -> 0x014e }
        r4 = r1.iterator();	 Catch:{ JSONException -> 0x0164, IOException -> 0x0159, Throwable -> 0x014e }
        r3 = r0;
    L_0x0058:
        if (r4 == 0) goto L_0x00b4;
    L_0x005a:
        r0 = r4.hasNext();	 Catch:{ JSONException -> 0x0168, IOException -> 0x015d, Throwable -> 0x0152 }
        if (r0 == 0) goto L_0x00b4;
    L_0x0060:
        r0 = r4.next();	 Catch:{ JSONException -> 0x0168, IOException -> 0x015d, Throwable -> 0x0152 }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ JSONException -> 0x0168, IOException -> 0x015d, Throwable -> 0x0152 }
        r1 = r0.getKey();	 Catch:{ JSONException -> 0x0168, IOException -> 0x015d, Throwable -> 0x0152 }
        r1 = (java.lang.String) r1;	 Catch:{ JSONException -> 0x0168, IOException -> 0x015d, Throwable -> 0x0152 }
        r5 = r6.f12939a;	 Catch:{ JSONException -> 0x0168, IOException -> 0x015d, Throwable -> 0x0152 }
        r1 = com.amap.api.location.core.C3193e.m14153b(r1, r5);	 Catch:{ JSONException -> 0x0168, IOException -> 0x015d, Throwable -> 0x0152 }
        r5 = r8.toString();	 Catch:{ JSONException -> 0x0168, IOException -> 0x015d, Throwable -> 0x0152 }
        r1 = r6.m17334a(r1, r5);	 Catch:{ JSONException -> 0x0168, IOException -> 0x015d, Throwable -> 0x0152 }
        if (r1 == 0) goto L_0x016f;
    L_0x007c:
        r0 = r0.getValue();	 Catch:{ JSONException -> 0x0168, IOException -> 0x015d, Throwable -> 0x0152 }
        r0 = (java.lang.String) r0;	 Catch:{ JSONException -> 0x0168, IOException -> 0x015d, Throwable -> 0x0152 }
        r1 = r6.f12939a;	 Catch:{ JSONException -> 0x0168, IOException -> 0x015d, Throwable -> 0x0152 }
        r0 = com.amap.api.location.core.C3193e.m14153b(r0, r1);	 Catch:{ JSONException -> 0x0168, IOException -> 0x015d, Throwable -> 0x0152 }
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0168, IOException -> 0x015d, Throwable -> 0x0152 }
        r1.<init>(r0);	 Catch:{ JSONException -> 0x0168, IOException -> 0x015d, Throwable -> 0x0152 }
        r0 = new com.aps.ap;	 Catch:{ JSONException -> 0x0168, IOException -> 0x015d, Throwable -> 0x0152 }
        r0.<init>(r1);	 Catch:{ JSONException -> 0x0168, IOException -> 0x015d, Throwable -> 0x0152 }
        r1 = "mem";
        r0.m17304g(r1);	 Catch:{ JSONException -> 0x0168, IOException -> 0x015d, Throwable -> 0x0152 }
        r1 = new com.aps.ar;	 Catch:{ JSONException -> 0x0168, IOException -> 0x015d, Throwable -> 0x0152 }
        r1.<init>();	 Catch:{ JSONException -> 0x0168, IOException -> 0x015d, Throwable -> 0x0152 }
        r1.m17342a(r0);	 Catch:{ JSONException -> 0x016c, IOException -> 0x0161, Throwable -> 0x0156 }
        r0 = r8.toString();	 Catch:{ JSONException -> 0x016c, IOException -> 0x0161, Throwable -> 0x0156 }
        r1.m17343a(r0);	 Catch:{ JSONException -> 0x016c, IOException -> 0x0161, Throwable -> 0x0156 }
        r0 = r6.f12940b;	 Catch:{ JSONException -> 0x016c, IOException -> 0x0161, Throwable -> 0x0156 }
        if (r0 != 0) goto L_0x00b1;
    L_0x00aa:
        r0 = new java.util.LinkedHashMap;	 Catch:{ JSONException -> 0x016c, IOException -> 0x0161, Throwable -> 0x0156 }
        r0.<init>();	 Catch:{ JSONException -> 0x016c, IOException -> 0x0161, Throwable -> 0x0156 }
        r6.f12940b = r0;	 Catch:{ JSONException -> 0x016c, IOException -> 0x0161, Throwable -> 0x0156 }
    L_0x00b1:
        if (r7 != 0) goto L_0x0113;
    L_0x00b3:
        r3 = r1;
    L_0x00b4:
        r1 = r3;
    L_0x00b5:
        if (r1 == 0) goto L_0x0011;
    L_0x00b7:
        r2 = r1.m17341a();
        goto L_0x0011;
    L_0x00bd:
        r1 = "no found";
        goto L_0x0028;
    L_0x00c1:
        if (r7 == 0) goto L_0x00db;
    L_0x00c3:
        r0 = "#wifi";
        r0 = r7.indexOf(r0);
        if (r0 == r1) goto L_0x00db;
    L_0x00cb:
        r0 = "#wifi";
        r0 = r6.m17330a(r7, r8, r0, r9);
        if (r0 == 0) goto L_0x00d7;
    L_0x00d3:
        r1 = "found#wifi";
        goto L_0x0028;
    L_0x00d7:
        r1 = "no found";
        goto L_0x0028;
    L_0x00db:
        if (r7 == 0) goto L_0x017c;
    L_0x00dd:
        r0 = "#cell";
        r0 = r7.indexOf(r0);
        if (r0 == r1) goto L_0x017c;
    L_0x00e5:
        r0 = "mem";
        r0 = r9.equals(r0);
        if (r0 == 0) goto L_0x017a;
    L_0x00ed:
        r0 = r6.f12940b;
        r0 = r0.get(r7);
        r0 = (java.util.List) r0;
        if (r0 == 0) goto L_0x017a;
    L_0x00f7:
        r1 = r0.size();
        if (r1 <= 0) goto L_0x017a;
    L_0x00fd:
        r1 = r0.size();
        r1 = r1 + -1;
        r0 = r0.get(r1);
        r0 = (com.aps.ar) r0;
    L_0x0109:
        if (r0 == 0) goto L_0x010f;
    L_0x010b:
        r1 = "found#cell";
        goto L_0x0028;
    L_0x010f:
        r1 = "no found";
        goto L_0x0028;
    L_0x0113:
        r0 = r6.f12940b;	 Catch:{ JSONException -> 0x016c, IOException -> 0x0161, Throwable -> 0x0156 }
        r0 = r0.containsKey(r7);	 Catch:{ JSONException -> 0x016c, IOException -> 0x0161, Throwable -> 0x0156 }
        if (r0 == 0) goto L_0x013f;
    L_0x011b:
        r0 = r6.f12940b;	 Catch:{ JSONException -> 0x016c, IOException -> 0x0161, Throwable -> 0x0156 }
        r0 = r0.get(r7);	 Catch:{ JSONException -> 0x016c, IOException -> 0x0161, Throwable -> 0x0156 }
        r0 = (java.util.List) r0;	 Catch:{ JSONException -> 0x016c, IOException -> 0x0161, Throwable -> 0x0156 }
        if (r0 == 0) goto L_0x012f;
    L_0x0125:
        r3 = r0.contains(r1);	 Catch:{ JSONException -> 0x016c, IOException -> 0x0161, Throwable -> 0x0156 }
        if (r3 != 0) goto L_0x012f;
    L_0x012b:
        r3 = 0;
        r0.add(r3, r1);	 Catch:{ JSONException -> 0x016c, IOException -> 0x0161, Throwable -> 0x0156 }
    L_0x012f:
        if (r0 == 0) goto L_0x013b;
    L_0x0131:
        r3 = r6.f12940b;	 Catch:{ JSONException -> 0x016c, IOException -> 0x0161, Throwable -> 0x0156 }
        r3.remove(r7);	 Catch:{ JSONException -> 0x016c, IOException -> 0x0161, Throwable -> 0x0156 }
        r3 = r6.f12940b;	 Catch:{ JSONException -> 0x016c, IOException -> 0x0161, Throwable -> 0x0156 }
        r3.put(r7, r0);	 Catch:{ JSONException -> 0x016c, IOException -> 0x0161, Throwable -> 0x0156 }
    L_0x013b:
        r0 = r1;
    L_0x013c:
        r3 = r0;
        goto L_0x0058;
    L_0x013f:
        r0 = new java.util.ArrayList;	 Catch:{ JSONException -> 0x016c, IOException -> 0x0161, Throwable -> 0x0156 }
        r0.<init>();	 Catch:{ JSONException -> 0x016c, IOException -> 0x0161, Throwable -> 0x0156 }
        r0.add(r1);	 Catch:{ JSONException -> 0x016c, IOException -> 0x0161, Throwable -> 0x0156 }
        r3 = r6.f12940b;	 Catch:{ JSONException -> 0x016c, IOException -> 0x0161, Throwable -> 0x0156 }
        r3.put(r7, r0);	 Catch:{ JSONException -> 0x016c, IOException -> 0x0161, Throwable -> 0x0156 }
        r0 = r1;
        goto L_0x013c;
    L_0x014e:
        r1 = move-exception;
        r1 = r0;
        goto L_0x00b5;
    L_0x0152:
        r0 = move-exception;
        r1 = r3;
        goto L_0x00b5;
    L_0x0156:
        r0 = move-exception;
        goto L_0x00b5;
    L_0x0159:
        r1 = move-exception;
        r1 = r0;
        goto L_0x00b5;
    L_0x015d:
        r0 = move-exception;
        r1 = r3;
        goto L_0x00b5;
    L_0x0161:
        r0 = move-exception;
        goto L_0x00b5;
    L_0x0164:
        r1 = move-exception;
        r1 = r0;
        goto L_0x00b5;
    L_0x0168:
        r0 = move-exception;
        r1 = r3;
        goto L_0x00b5;
    L_0x016c:
        r0 = move-exception;
        goto L_0x00b5;
    L_0x016f:
        r0 = r3;
        goto L_0x013c;
    L_0x0171:
        r3 = r0;
        goto L_0x00b4;
    L_0x0174:
        r1 = r2;
        goto L_0x004d;
    L_0x0177:
        r1 = r0;
        goto L_0x00b5;
    L_0x017a:
        r0 = r2;
        goto L_0x0109;
    L_0x017c:
        r0 = r2;
        goto L_0x0028;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aps.aq.a(java.lang.String, java.lang.StringBuilder, java.lang.String):com.aps.ap");
    }

    boolean m17339a(String str, ap apVar) {
        if (str == null || apVar == null || str.indexOf("#network") == -1 || apVar.m17299e() == 0.0d) {
            return false;
        }
        return true;
    }

    void m17337a() {
        this.f12942d = 0;
        this.f12940b.clear();
    }

    void m17340b() {
        if (this.f12941c != null) {
            this.f12941c.m17434a();
        }
    }

    private ar m17330a(String str, StringBuilder stringBuilder, String str2, String str3) {
        Iterator it;
        ar arVar = null;
        Hashtable hashtable = new Hashtable();
        Hashtable hashtable2 = new Hashtable();
        Hashtable hashtable3 = new Hashtable();
        if (str3.equals("mem")) {
            it = this.f12940b.entrySet().iterator();
        } else {
            it = null;
        }
        Object obj = 1;
        while (it != null && it.hasNext()) {
            List list;
            Object obj2;
            String str4;
            if (obj != null) {
                str4 = str;
                list = (List) this.f12940b.get(str);
                obj2 = null;
            } else {
                Entry entry = (Entry) it.next();
                str4 = (String) entry.getKey();
                list = (List) entry.getValue();
                obj2 = obj;
            }
            if (arVar != null) {
                break;
            } else if (list == null) {
                obj = obj2;
            } else {
                ar arVar2;
                for (int i = 0; i < list.size(); i++) {
                    arVar2 = (ar) list.get(i);
                    if (!(TextUtils.isEmpty(arVar2.m17344b()) || TextUtils.isEmpty(stringBuilder) || r11.indexOf(str2) == -1)) {
                        Object obj3;
                        if (!m17335a(arVar2.m17344b(), stringBuilder)) {
                            obj3 = null;
                        } else if (arVar2.m17341a().m17303g() > BitmapDescriptorFactory.HUE_MAGENTA) {
                            obj3 = null;
                        } else {
                            int i2 = 1;
                        }
                        m17333a(arVar2.m17344b(), hashtable);
                        m17333a(stringBuilder.toString(), hashtable2);
                        hashtable3.clear();
                        for (String put : hashtable.keySet()) {
                            hashtable3.put(put, "");
                        }
                        for (String put2 : hashtable2.keySet()) {
                            hashtable3.put(put2, "");
                        }
                        Set<String> keySet = hashtable3.keySet();
                        double[] dArr = new double[keySet.size()];
                        double[] dArr2 = new double[keySet.size()];
                        int i3 = 0;
                        for (String put22 : keySet) {
                            dArr[i3] = hashtable.containsKey(put22) ? WeightedLatLng.DEFAULT_INTENSITY : 0.0d;
                            dArr2[i3] = hashtable2.containsKey(put22) ? WeightedLatLng.DEFAULT_INTENSITY : 0.0d;
                            i3++;
                        }
                        keySet.clear();
                        double a = m17329a(dArr, dArr2);
                        if (str3.equals("mem")) {
                            if (obj3 != null && a > 0.8500000238418579d) {
                                break;
                            } else if (a > 0.8500000238418579d) {
                                break;
                            }
                        } else {
                            if (str3.equals("db") && a > 0.8500000238418579d) {
                                break;
                            }
                        }
                    }
                }
                arVar2 = arVar;
                obj = obj2;
                arVar = arVar2;
            }
        }
        hashtable.clear();
        hashtable2.clear();
        hashtable3.clear();
        return arVar;
    }

    private boolean m17334a(String str, String str2) {
        Hashtable hashtable = new Hashtable();
        Hashtable hashtable2 = new Hashtable();
        Hashtable hashtable3 = new Hashtable();
        m17333a(str2, hashtable);
        m17333a(str, hashtable2);
        hashtable3.clear();
        for (String put : hashtable.keySet()) {
            hashtable3.put(put, "");
        }
        for (String put2 : hashtable2.keySet()) {
            hashtable3.put(put2, "");
        }
        Set<String> keySet = hashtable3.keySet();
        double[] dArr = new double[keySet.size()];
        double[] dArr2 = new double[keySet.size()];
        int i = 0;
        for (String put22 : keySet) {
            dArr[i] = hashtable.containsKey(put22) ? WeightedLatLng.DEFAULT_INTENSITY : 0.0d;
            dArr2[i] = hashtable2.containsKey(put22) ? WeightedLatLng.DEFAULT_INTENSITY : 0.0d;
            i++;
        }
        keySet.clear();
        double a = m17329a(dArr, dArr2);
        hashtable.clear();
        hashtable2.clear();
        hashtable3.clear();
        if (a > 0.8500000238418579d) {
            return true;
        }
        return false;
    }

    private boolean m17335a(String str, StringBuilder stringBuilder) {
        int indexOf = str.indexOf(",access");
        if (indexOf == -1 || indexOf < 17 || stringBuilder.indexOf(",access") == -1) {
            return false;
        }
        if (stringBuilder.toString().indexOf(str.substring(indexOf - 17, indexOf) + ",access") != -1) {
            return true;
        }
        return false;
    }

    private void m17333a(String str, Hashtable<String, String> hashtable) {
        hashtable.clear();
        for (String str2 : str.split("#")) {
            if (str2.length() > 0) {
                hashtable.put(str2, "");
            }
        }
    }

    private double m17329a(double[] dArr, double[] dArr2) {
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        for (int i = 0; i < dArr.length; i++) {
            d2 += dArr[i] * dArr[i];
            d += dArr2[i] * dArr2[i];
            d3 += dArr[i] * dArr2[i];
        }
        return d3 / (Math.sqrt(d2) * Math.sqrt(d));
    }
}
