package com.tencent.map.p535b;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Message;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.maps.model.WeightedLatLng;
import com.tencent.map.p533a.p534a.C6303a;
import com.tencent.map.p533a.p534a.C6304b;
import com.tencent.map.p533a.p534a.C6305c;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class C6313f implements C6307b, C6312p {
    private static boolean f21961r = false;
    private static C6313f f21962s = null;
    private int f21963A;
    private int f21964B;
    private String f21965C;
    private String f21966D;
    private String f21967E;
    private String f21968F;
    private String f21969G;
    private String f21970H;
    private boolean f21971I;
    private long f21972J;
    private long f21973a;
    private Context f21974b;
    private C6317i f21975c;
    private C6315g f21976d;
    private int f21977e;
    private int f21978f;
    private C6309d f21979g;
    private C6306a f21980h;
    private C6303a f21981i;
    private int f21982j;
    private int f21983k;
    private int f21984l;
    private byte[] f21985m;
    private boolean f21986n;
    private C6311c f21987o;
    private C6322n f21988p;
    private C6321m f21989q;
    private long f21990t;
    private C6320l f21991u;
    private C6318j f21992v;
    private C6323o f21993w;
    private C6305c f21994x;
    private C6305c f21995y;
    private int f21996z;

    final class C6311c extends Handler {
        private /* synthetic */ C6313f f21960a;

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    C6313f.m28941a(this.f21960a, (C6320l) message.obj);
                    return;
                case 2:
                    C6313f.m28940a(this.f21960a, (C6318j) message.obj);
                    return;
                case 3:
                    C6313f.m28942a(this.f21960a, (C6323o) message.obj);
                    return;
                case 4:
                    C6313f.m28938a(this.f21960a, message.arg1);
                    return;
                case 5:
                    C6313f.m28950b(this.f21960a, message.arg1);
                    return;
                case 6:
                    C6313f.m28939a(this.f21960a, (Location) message.obj);
                    return;
                case 8:
                    if (message.arg1 == 0) {
                        this.f21960a.m28944a((String) message.obj);
                        return;
                    } else if (this.f21960a.f21991u == null || !this.f21960a.f21991u.m28988a()) {
                        this.f21960a.m28955c();
                        return;
                    } else {
                        return;
                    }
                case 16:
                    if (message.obj != null) {
                        C6313f.m28943a(this.f21960a, (String) message.obj);
                        this.f21960a.f21989q = null;
                        return;
                    }
                    return;
                case 256:
                    if (this.f21960a.f21996z == 1) {
                        this.f21960a.m28949b();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private static ArrayList<C6304b> m28936a(JSONArray jSONArray) throws Exception {
        int length = jSONArray.length();
        ArrayList<C6304b> arrayList = new ArrayList();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            arrayList.add(new C6304b(jSONObject.getString("name"), jSONObject.getString("addr"), jSONObject.getString("catalog"), jSONObject.getDouble("dist"), Double.parseDouble(jSONObject.getString("latitude")), Double.parseDouble(jSONObject.getString("longitude"))));
        }
        return arrayList;
    }

    static /* synthetic */ void m28938a(C6313f c6313f, int i) {
        if (i == 0) {
            c6313f.f21991u = null;
        }
        c6313f.f21977e = i == 0 ? 1 : 2;
        if (c6313f.f21981i != null) {
            c6313f.f21981i.m28909a(c6313f.f21977e);
        }
    }

    static /* synthetic */ void m28939a(C6313f c6313f, Location location) {
        if (location == null || location.getLatitude() > 359.0d || location.getLongitude() > 359.0d) {
            if (c6313f.f21991u == null || !c6313f.f21991u.m28988a()) {
                c6313f.m28955c();
            } else {
                c6313f.m28952b(true);
            }
        }
        c6313f.f21994x = new C6305c();
        c6313f.f21994x.f21938z = 0;
        c6313f.f21994x.f21937y = 0;
        c6313f.f21994x.f21914b = C6325r.m28993a(location.getLatitude(), 6);
        c6313f.f21994x.f21915c = C6325r.m28993a(location.getLongitude(), 6);
        if (c6313f.f21991u != null && c6313f.f21991u.m28988a()) {
            c6313f.f21994x.f21917e = C6325r.m28993a((double) c6313f.f21991u.m28989b().getAccuracy(), 1);
            c6313f.f21994x.f21916d = C6325r.m28993a(c6313f.f21991u.m28989b().getAltitude(), 1);
            c6313f.f21994x.f21918f = C6325r.m28993a((double) c6313f.f21991u.m28989b().getSpeed(), 1);
            c6313f.f21994x.f21919g = C6325r.m28993a((double) c6313f.f21991u.m28989b().getBearing(), 1);
            c6313f.f21994x.f21913a = 0;
        }
        c6313f.f21994x.f21936x = true;
        if (!(c6313f.f21983k == 0 || c6313f.f21995y == null || c6313f.f21996z != 0)) {
            if ((c6313f.f21983k == 3 || c6313f.f21983k == 4) && c6313f.f21983k == c6313f.f21995y.f21938z) {
                c6313f.f21994x.f21921i = c6313f.f21995y.f21921i;
                c6313f.f21994x.f21922j = c6313f.f21995y.f21922j;
                c6313f.f21994x.f21923k = c6313f.f21995y.f21923k;
                c6313f.f21994x.f21924l = c6313f.f21995y.f21924l;
                c6313f.f21994x.f21925m = c6313f.f21995y.f21925m;
                c6313f.f21994x.f21926n = c6313f.f21995y.f21926n;
                c6313f.f21994x.f21927o = c6313f.f21995y.f21927o;
                c6313f.f21994x.f21928p = c6313f.f21995y.f21928p;
                c6313f.f21994x.f21938z = 3;
            }
            if (c6313f.f21983k == 4 && c6313f.f21983k == c6313f.f21995y.f21938z && c6313f.f21995y.f21935w != null) {
                c6313f.f21994x.f21935w = new ArrayList();
                Iterator it = c6313f.f21995y.f21935w.iterator();
                while (it.hasNext()) {
                    c6313f.f21994x.f21935w.add(new C6304b((C6304b) it.next()));
                }
                c6313f.f21994x.f21938z = 4;
            }
            if (c6313f.f21983k == 7 && c6313f.f21983k == c6313f.f21995y.f21938z) {
                c6313f.f21994x.f21938z = 7;
                c6313f.f21994x.f21920h = c6313f.f21995y.f21920h;
                c6313f.f21994x.f21921i = c6313f.f21995y.f21921i;
                if (c6313f.f21995y.f21920h == 0) {
                    c6313f.f21994x.f21922j = c6313f.f21995y.f21922j;
                    c6313f.f21994x.f21923k = c6313f.f21995y.f21923k;
                    c6313f.f21994x.f21924l = c6313f.f21995y.f21924l;
                    c6313f.f21994x.f21925m = c6313f.f21995y.f21925m;
                    c6313f.f21994x.f21926n = c6313f.f21995y.f21926n;
                    c6313f.f21994x.f21927o = c6313f.f21995y.f21927o;
                    c6313f.f21994x.f21928p = c6313f.f21995y.f21928p;
                } else {
                    c6313f.f21994x.f21929q = c6313f.f21995y.f21929q;
                    c6313f.f21994x.f21930r = c6313f.f21995y.f21930r;
                    c6313f.f21994x.f21931s = c6313f.f21995y.f21931s;
                    c6313f.f21994x.f21932t = c6313f.f21995y.f21932t;
                    c6313f.f21994x.f21933u = c6313f.f21995y.f21933u;
                    c6313f.f21994x.f21934v = c6313f.f21995y.f21934v;
                }
            }
        }
        if (c6313f.f21996z != 0 || c6313f.f21995y != null) {
            if (c6313f.f21996z != 0) {
                c6313f.f21994x.f21937y = c6313f.f21996z;
            }
            if (System.currentTimeMillis() - c6313f.f21990t >= c6313f.f21973a && c6313f.f21981i != null && c6313f.f21982j == 1) {
                c6313f.f21981i.m28910a(c6313f.f21994x);
                c6313f.f21990t = System.currentTimeMillis();
            }
        }
    }

    static /* synthetic */ void m28940a(C6313f c6313f, C6318j c6318j) {
        c6313f.f21992v = c6318j;
        if (c6313f.f21976d != null && c6313f.f21976d.m28985a() && c6313f.f21976d.m28986b()) {
            c6313f.f21976d.m28984a(0);
            return;
        }
        if (c6313f.f21963A > 0 && !C6325r.m28999a(c6318j.f22012a, c6318j.f22013b, c6318j.f22014c, c6318j.f22015d, c6318j.f22016e)) {
            c6313f.f21963A--;
        }
        c6313f.m28949b();
    }

    static /* synthetic */ void m28941a(C6313f c6313f, C6320l c6320l) {
        if (c6320l != null) {
            c6313f.f21991u = c6320l;
            if (c6313f.f21982j != 1 || c6313f.f21991u == null || !c6313f.f21991u.m28988a()) {
                return;
            }
            if (c6313f.f21984l == 0) {
                c6313f.m28952b(false);
            } else if (c6313f.f21984l == 1 && c6313f.f21980h != null) {
                C6306a c6306a = c6313f.f21980h;
                double latitude = c6313f.f21991u.m28989b().getLatitude();
                double longitude = c6313f.f21991u.m28989b().getLongitude();
                Context context = c6313f.f21974b;
                c6306a.m28919a(latitude, longitude, (C6307b) c6313f);
            }
        }
    }

    static /* synthetic */ void m28942a(C6313f c6313f, C6323o c6323o) {
        if (c6323o != null) {
            c6313f.f21993w = c6323o;
            c6313f.m28949b();
        }
    }

    static /* synthetic */ void m28943a(C6313f c6313f, String str) {
        if (C6325r.m29000a(str)) {
            if (c6313f.f21982j != 0 || c6313f.f21981i == null) {
                String b = c6313f.f21979g == null ? null : (c6313f.f21992v == null || c6313f.f21993w == null) ? null : c6313f.f21979g.m28931b(c6313f.f21992v.f22013b, c6313f.f21992v.f22014c, c6313f.f21992v.f22015d, c6313f.f21992v.f22016e, c6313f.f21993w.m28991a());
                if (b != null) {
                    c6313f.m28944a(b);
                    return;
                }
                if (!(c6313f.f21979g == null || c6313f.f21992v == null || c6313f.f21993w == null)) {
                    c6313f.f21979g.m28929a(c6313f.f21992v.f22013b, c6313f.f21992v.f22014c, c6313f.f21992v.f22015d, c6313f.f21992v.f22016e, c6313f.f21993w.m28991a());
                }
                if (!c6313f.f21986n) {
                    if (c6313f.f21988p != null) {
                        c6313f.f21988p.interrupt();
                    }
                    c6313f.f21988p = null;
                    c6313f.f21988p = new C6322n(c6313f, str);
                    c6313f.f21988p.start();
                    return;
                }
                return;
            }
            byte[] bytes;
            try {
                bytes = str.getBytes();
            } catch (Exception e) {
                bytes = null;
            }
            c6313f.f21981i.m28911a(bytes, 0);
        } else if (c6313f.f21963A > 0) {
            c6313f.f21963A--;
        } else if (c6313f.f21982j == 0 && c6313f.f21981i != null) {
            c6313f.f21981i.m28911a(null, -1);
        } else if (c6313f.f21982j == 1 && c6313f.f21981i != null) {
            c6313f.f21994x = new C6305c();
            c6313f.f21996z = 3;
            c6313f.f21994x.f21937y = 3;
            c6313f.f21994x.f21938z = -1;
            c6313f.f21981i.m28910a(c6313f.f21994x);
        }
    }

    private void m28944a(String str) {
        int i = 0;
        try {
            double d;
            this.f21994x = new C6305c();
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject(LocationManagerProxy.KEY_LOCATION_CHANGED);
            this.f21994x.f21913a = 1;
            this.f21994x.f21914b = C6325r.m28993a(jSONObject2.getDouble("latitude"), 6);
            this.f21994x.f21915c = C6325r.m28993a(jSONObject2.getDouble("longitude"), 6);
            this.f21994x.f21916d = C6325r.m28993a(jSONObject2.getDouble("altitude"), 1);
            this.f21994x.f21917e = C6325r.m28993a(jSONObject2.getDouble("accuracy"), 1);
            this.f21994x.f21936x = this.f21984l == 1;
            String string = jSONObject.getString("bearing");
            int i2 = -100;
            if (string != null && string.split(",").length > 1) {
                i = Integer.parseInt(string.split(",")[1]);
            }
            if (this.f21992v != null) {
                i2 = this.f21992v.f22017f;
            }
            C6305c c6305c = this.f21994x;
            double d2 = this.f21994x.f21917e;
            if (i >= 6) {
                d = 40.0d;
            } else if (i == 5) {
                d = 60.0d;
            } else if (i == 4) {
                d = 70.0d;
            } else if (i == 3) {
                d = 90.0d;
            } else if (i == 2) {
                d = 110.0d;
            } else {
                i2 = (i2 < -72 || i != 0) ? d2 <= 100.0d ? ((int) (((d2 - WeightedLatLng.DEFAULT_INTENSITY) / 10.0d) + WeightedLatLng.DEFAULT_INTENSITY)) * 10 : (d2 <= 100.0d || d2 > 800.0d) ? ((int) ((0.8d * d2) / 10.0d)) * 10 : ((int) ((0.85d * d2) / 10.0d)) * 10 : ((int) ((0.45d * d2) / 10.0d)) * 10;
                d = (double) i2;
            }
            c6305c.f21917e = d;
            this.f21994x.f21938z = 0;
            if ((this.f21983k == 3 || this.f21983k == 4) && this.f21984l == 1) {
                jSONObject2 = jSONObject.getJSONObject("details").getJSONObject("subnation");
                this.f21994x.m28913a(jSONObject2.getString("name"));
                this.f21994x.f21925m = jSONObject2.getString("town");
                this.f21994x.f21926n = jSONObject2.getString("village");
                this.f21994x.f21927o = jSONObject2.getString("street");
                this.f21994x.f21928p = jSONObject2.getString("street_no");
                this.f21994x.f21938z = 3;
                this.f21994x.f21920h = 0;
            }
            if (this.f21983k == 4 && this.f21984l == 1) {
                this.f21994x.f21935w = C6313f.m28936a(jSONObject.getJSONObject("details").getJSONArray("poilist"));
                this.f21994x.f21938z = 4;
            }
            if (this.f21983k == 7 && this.f21984l == 1) {
                jSONObject2 = jSONObject.getJSONObject("details");
                i = jSONObject2.getInt("stat");
                jSONObject2 = jSONObject2.getJSONObject("subnation");
                if (i == 0) {
                    this.f21994x.m28913a(jSONObject2.getString("name"));
                    this.f21994x.f21925m = jSONObject2.getString("town");
                    this.f21994x.f21926n = jSONObject2.getString("village");
                    this.f21994x.f21927o = jSONObject2.getString("street");
                    this.f21994x.f21928p = jSONObject2.getString("street_no");
                } else if (i == 1) {
                    this.f21994x.f21921i = jSONObject2.getString("nation");
                    this.f21994x.f21929q = jSONObject2.getString("admin_level_1");
                    this.f21994x.f21930r = jSONObject2.getString("admin_level_2");
                    this.f21994x.f21931s = jSONObject2.getString("admin_level_3");
                    this.f21994x.f21932t = jSONObject2.getString("locality");
                    this.f21994x.f21933u = jSONObject2.getString("sublocality");
                    this.f21994x.f21934v = jSONObject2.getString("route");
                }
                this.f21994x.f21920h = i;
                this.f21994x.f21938z = 7;
            }
            this.f21994x.f21937y = 0;
            this.f21995y = new C6305c(this.f21994x);
            this.f21996z = 0;
            if (this.f21979g != null) {
                this.f21979g.m28930a(str);
            }
        } catch (Exception e) {
            this.f21994x = new C6305c();
            this.f21994x.f21938z = -1;
            this.f21994x.f21937y = 2;
            this.f21996z = 2;
        }
        if (this.f21981i != null && this.f21982j == 1) {
            if (this.f21991u == null || !this.f21991u.m28988a()) {
                this.f21981i.m28910a(this.f21994x);
                this.f21990t = System.currentTimeMillis();
            }
        }
    }

    private void m28949b() {
        if (this.f21989q == null) {
            this.f21989q = new C6321m(this, this.f21991u, this.f21992v, this.f21993w);
            this.f21989q.start();
        }
    }

    static /* synthetic */ void m28950b(C6313f c6313f, int i) {
        int i2 = 3;
        if (i == 3) {
            i2 = 4;
        }
        c6313f.f21978f = i2;
        if (c6313f.f21981i != null) {
            c6313f.f21981i.m28909a(c6313f.f21978f);
        }
    }

    private void m28952b(boolean z) {
        if (this.f21991u != null && this.f21991u.m28988a()) {
            Location b = this.f21991u.m28989b();
            this.f21994x = new C6305c();
            this.f21994x.f21914b = C6325r.m28993a(b.getLatitude(), 6);
            this.f21994x.f21915c = C6325r.m28993a(b.getLongitude(), 6);
            this.f21994x.f21916d = C6325r.m28993a(b.getAltitude(), 1);
            this.f21994x.f21917e = C6325r.m28993a((double) b.getAccuracy(), 1);
            this.f21994x.f21918f = C6325r.m28993a((double) b.getSpeed(), 1);
            this.f21994x.f21919g = C6325r.m28993a((double) b.getBearing(), 1);
            this.f21994x.f21913a = 0;
            this.f21994x.f21936x = false;
            if (z) {
                this.f21994x.f21937y = 1;
            } else {
                this.f21994x.f21937y = 0;
            }
            this.f21994x.f21938z = 0;
            this.f21995y = new C6305c(this.f21994x);
            this.f21996z = 0;
            if (System.currentTimeMillis() - this.f21990t >= this.f21973a && this.f21981i != null && this.f21982j == 1) {
                this.f21981i.m28910a(this.f21994x);
                this.f21990t = System.currentTimeMillis();
            }
        }
    }

    private void m28955c() {
        this.f21994x = new C6305c();
        this.f21996z = 1;
        this.f21994x.f21937y = 1;
        this.f21994x.f21938z = -1;
        this.f21994x.f21913a = 1;
        if (this.f21981i != null && this.f21982j == 1) {
            this.f21981i.m28910a(this.f21994x);
        }
    }

    static /* synthetic */ void m28963h(C6313f c6313f) {
    }

    public final void mo5302a(double d, double d2) {
        synchronized (this.f21985m) {
            Message obtainMessage = this.f21987o.obtainMessage(6);
            Location location = new Location("Deflect");
            location.setLatitude(d);
            location.setLongitude(d2);
            obtainMessage.obj = location;
            this.f21987o.sendMessage(obtainMessage);
        }
    }

    public final void mo5303a(int i) {
        synchronized (this.f21985m) {
            this.f21987o.sendMessage(this.f21987o.obtainMessage(5, i, 0));
        }
    }

    public final void mo5304a(C6323o c6323o) {
        synchronized (this.f21985m) {
            this.f21987o.sendMessage(this.f21987o.obtainMessage(3, c6323o));
        }
    }
}
