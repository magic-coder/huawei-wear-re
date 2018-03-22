package com.google.tagmanager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: DataLayer */
public class C3681f {
    public static final Object f14330a = new Object();
    static final String[] f14331b = "gtm.lifetime".toString().split("\\.");
    private static final Pattern f14332c = Pattern.compile("(\\d+)\\s*([smhd]?)");
    private final ConcurrentHashMap<C3675j, Integer> f14333d;
    private final Map<Object, Object> f14334e;
    private final ReentrantLock f14335f;
    private final LinkedList<Map<Object, Object>> f14336g;
    private final C3682k f14337h;
    private final CountDownLatch f14338i;

    C3681f() {
        this(new C3683g());
    }

    C3681f(C3682k c3682k) {
        this.f14337h = c3682k;
        this.f14333d = new ConcurrentHashMap();
        this.f14334e = new HashMap();
        this.f14335f = new ReentrantLock();
        this.f14336g = new LinkedList();
        this.f14338i = new CountDownLatch(1);
        m18557a();
    }

    public void m18571a(Map<Object, Object> map) {
        try {
            this.f14338i.await();
        } catch (InterruptedException e) {
            C3700z.m18626b("DataLayer.push: unexpected InterruptedException");
        }
        m18561b(map);
    }

    private void m18561b(Map<Object, Object> map) {
        this.f14335f.lock();
        try {
            this.f14336g.offer(map);
            if (this.f14335f.getHoldCount() == 1) {
                m18560b();
            }
            m18562c(map);
        } finally {
            this.f14335f.unlock();
        }
    }

    private void m18557a() {
        this.f14337h.mo4292a(new C3685h(this));
    }

    private void m18562c(Map<Object, Object> map) {
        Long d = m18563d(map);
        if (d != null) {
            List f = m18565f(map);
            f.remove("gtm.lifetime");
            this.f14337h.mo4293a(f, d.longValue());
        }
    }

    private Long m18563d(Map<Object, Object> map) {
        Object e = m18564e(map);
        if (e == null) {
            return null;
        }
        return C3681f.m18555a(e.toString());
    }

    private Object m18564e(Map<Object, Object> map) {
        String[] strArr = f14331b;
        int length = strArr.length;
        int i = 0;
        Object obj = map;
        while (i < length) {
            Object obj2 = strArr[i];
            if (!(obj instanceof Map)) {
                return null;
            }
            i++;
            Map<Object, Object> map2 = ((Map) obj).get(obj2);
        }
        return obj;
    }

    private List<C3686i> m18565f(Map<Object, Object> map) {
        Object arrayList = new ArrayList();
        m18559a(map, "", arrayList);
        return arrayList;
    }

    private void m18559a(Map<Object, Object> map, String str, Collection<C3686i> collection) {
        for (Entry entry : map.entrySet()) {
            String str2 = str + (str.length() == 0 ? "" : ".") + entry.getKey();
            if (entry.getValue() instanceof Map) {
                m18559a((Map) entry.getValue(), str2, collection);
            } else if (!str2.equals("gtm.lifetime")) {
                collection.add(new C3686i(str2, entry.getValue()));
            }
        }
    }

    static Long m18555a(String str) {
        Matcher matcher = f14332c.matcher(str);
        if (matcher.matches()) {
            long parseLong;
            try {
                parseLong = Long.parseLong(matcher.group(1));
            } catch (NumberFormatException e) {
                C3700z.m18626b("illegal number in _lifetime value: " + str);
                parseLong = 0;
            }
            if (parseLong <= 0) {
                C3700z.m18627c("non-positive _lifetime: " + str);
                return null;
            }
            String group = matcher.group(2);
            if (group.length() == 0) {
                return Long.valueOf(parseLong);
            }
            switch (group.charAt(0)) {
                case 'd':
                    return Long.valueOf((((parseLong * 1000) * 60) * 60) * 24);
                case 'h':
                    return Long.valueOf(((parseLong * 1000) * 60) * 60);
                case 'm':
                    return Long.valueOf((parseLong * 1000) * 60);
                case 's':
                    return Long.valueOf(parseLong * 1000);
                default:
                    C3700z.m18626b("unknown units in _lifetime: " + str);
                    return null;
            }
        }
        C3700z.m18627c("unknown _lifetime: " + str);
        return null;
    }

    private void m18560b() {
        int i = 0;
        while (true) {
            Map map = (Map) this.f14336g.poll();
            if (map != null) {
                m18566g(map);
                int i2 = i + 1;
                if (i2 > 500) {
                    this.f14336g.clear();
                    throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
                }
                i = i2;
            } else {
                return;
            }
        }
    }

    private void m18566g(Map<Object, Object> map) {
        synchronized (this.f14334e) {
            for (Object next : map.keySet()) {
                m18572a(m18568a(next, map.get(next)), this.f14334e);
            }
        }
        m18567h(map);
    }

    void m18569a(C3675j c3675j) {
        this.f14333d.put(c3675j, Integer.valueOf(0));
    }

    private void m18567h(Map<Object, Object> map) {
        for (C3675j a : this.f14333d.keySet()) {
            a.mo4270a(map);
        }
    }

    Map<Object, Object> m18568a(Object obj, Object obj2) {
        Map hashMap = new HashMap();
        String[] split = obj.toString().split("\\.");
        int i = 0;
        Map map = hashMap;
        while (i < split.length - 1) {
            HashMap hashMap2 = new HashMap();
            map.put(split[i], hashMap2);
            i++;
            Object obj3 = hashMap2;
        }
        map.put(split[split.length - 1], obj2);
        return hashMap;
    }

    void m18572a(Map<Object, Object> map, Map<Object, Object> map2) {
        for (Object next : map.keySet()) {
            Object obj = map.get(next);
            if (obj instanceof List) {
                if (!(map2.get(next) instanceof List)) {
                    map2.put(next, new ArrayList());
                }
                m18570a((List) obj, (List) map2.get(next));
            } else if (obj instanceof Map) {
                if (!(map2.get(next) instanceof Map)) {
                    map2.put(next, new HashMap());
                }
                m18572a((Map) obj, (Map) map2.get(next));
            } else {
                map2.put(next, obj);
            }
        }
    }

    void m18570a(List<Object> list, List<Object> list2) {
        while (list2.size() < list.size()) {
            list2.add(null);
        }
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            if (obj instanceof List) {
                if (!(list2.get(i) instanceof List)) {
                    list2.set(i, new ArrayList());
                }
                m18570a((List) obj, (List) list2.get(i));
            } else if (obj instanceof Map) {
                if (!(list2.get(i) instanceof Map)) {
                    list2.set(i, new HashMap());
                }
                m18572a((Map) obj, (Map) list2.get(i));
            } else if (obj != f14330a) {
                list2.set(i, obj);
            }
        }
    }
}
