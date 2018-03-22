package com.google.tagmanager;

import com.google.analytics.p268a.p269a.C3630a;
import com.google.analytics.p273b.p274a.p275a.C3644b;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: Runtime */
class aw {
    private static final ak<C3644b> f14273a = new ak(bl.m18529a(), true);
    private final C3696v f14274b;
    private final Map<String, C3697w> f14275c;
    private final Map<String, C3697w> f14276d;
    private final Map<String, C3697w> f14277e;
    private final C3677b<at, ak<C3644b>> f14278f;
    private final C3677b<String, ba> f14279g;
    private final Set<au> f14280h;
    private final C3681f f14281i;
    private final Map<String, bb> f14282j;
    private volatile String f14283k;

    public synchronized void m18499a(String str) {
        m18500b(str);
        C3695u a = this.f14274b.m18612a(str);
        C3687m a2 = a.m18610a();
        for (at a3 : (Set) m18498a(this.f14280h, a2.m18580b()).m18468a()) {
            m18492a(this.f14275c, a3, new HashSet(), a2.m18579a());
        }
        a.m18611b();
        m18500b(null);
    }

    synchronized void m18500b(String str) {
        this.f14283k = str;
    }

    ak<Set<at>> m18497a(String str, Set<au> set, Map<au, List<at>> map, Map<au, List<String>> map2, Map<au, List<at>> map3, Map<au, List<String>> map4, Set<String> set2, av avVar) {
        return m18493a((Set) set, (Set) set2, new ax(this, map, map2, map3, map4), avVar);
    }

    ak<Set<at>> m18498a(Set<au> set, av avVar) {
        return m18493a((Set) set, new HashSet(), new ay(this), avVar);
    }

    private ak<Set<at>> m18493a(Set<au> set, Set<String> set2, az azVar, av avVar) {
        Set hashSet = new HashSet();
        Collection hashSet2 = new HashSet();
        boolean z = true;
        for (au auVar : set) {
            ar a = avVar.mo4284a();
            ak a2 = m18496a(auVar, (Set) set2, a);
            if (((Boolean) a2.m18468a()).booleanValue()) {
                azVar.mo4291a(auVar, hashSet, hashSet2, a);
            }
            boolean z2 = z && a2.m18469b();
            z = z2;
        }
        hashSet.removeAll(hashSet2);
        avVar.mo4285a(hashSet);
        return new ak(hashSet, z);
    }

    ak<Boolean> m18495a(at atVar, Set<String> set, ao aoVar) {
        ak a = m18492a(this.f14276d, atVar, (Set) set, aoVar);
        Object b = bl.m18533b((C3644b) a.m18468a());
        aoVar.mo4274a(bl.m18535c(b));
        return new ak(b, a.m18469b());
    }

    ak<Boolean> m18496a(au auVar, Set<String> set, ar arVar) {
        boolean z = true;
        for (at a : auVar.m18483b()) {
            ak a2 = m18495a(a, (Set) set, arVar.mo4276a());
            if (((Boolean) a2.m18468a()).booleanValue()) {
                arVar.mo4277a(bl.m18535c(Boolean.valueOf(false)));
                return new ak(Boolean.valueOf(false), a2.m18469b());
            }
            boolean z2;
            if (z && a2.m18469b()) {
                z2 = true;
            } else {
                z2 = false;
            }
            z = z2;
        }
        for (at a3 : auVar.m18482a()) {
            a2 = m18495a(a3, (Set) set, arVar.mo4278b());
            if (((Boolean) a2.m18468a()).booleanValue()) {
                z = z && a2.m18469b();
            } else {
                arVar.mo4277a(bl.m18535c(Boolean.valueOf(false)));
                return new ak(Boolean.valueOf(false), a2.m18469b());
            }
        }
        arVar.mo4277a(bl.m18535c(Boolean.valueOf(true)));
        return new ak(Boolean.valueOf(true), z);
    }

    private ak<C3644b> m18491a(String str, Set<String> set, ac acVar) {
        ba baVar = (ba) this.f14279g.m18504a(str);
        if (baVar == null || this.f14274b.m18613a()) {
            bb bbVar = (bb) this.f14282j.get(str);
            if (bbVar == null) {
                C3700z.m18624a("Invalid macro: " + str);
                return f14273a;
            }
            at f;
            ak a = m18497a(str, bbVar.m18508a(), bbVar.m18509b(), bbVar.m18510c(), bbVar.m18512e(), bbVar.m18511d(), set, acVar.mo4272b());
            if (((Set) a.m18468a()).isEmpty()) {
                f = bbVar.m18513f();
            } else {
                if (((Set) a.m18468a()).size() > 1) {
                    C3700z.m18626b("Multiple macros active for macroName " + str);
                }
                f = (at) ((Set) a.m18468a()).iterator().next();
            }
            if (f == null) {
                return f14273a;
            }
            ak a2 = m18492a(this.f14277e, f, (Set) set, acVar.mo4271a());
            boolean z = a.m18469b() && a2.m18469b();
            ak<C3644b> akVar = a2 == f14273a ? f14273a : new ak(a2.m18468a(), z);
            C3644b b = f.m18481b();
            if (akVar.m18469b()) {
                this.f14279g.m18505a(str, new ba(akVar, b));
            }
            m18494a(b, (Set) set);
            return akVar;
        }
        m18494a(baVar.m18507b(), (Set) set);
        return baVar.m18506a();
    }

    private void m18494a(C3644b c3644b, Set<String> set) {
        if (c3644b != null) {
            ak a = m18490a(c3644b, (Set) set, new aj());
            if (a != f14273a) {
                Object c = bl.m18536c((C3644b) a.m18468a());
                if (c instanceof Map) {
                    this.f14281i.m18571a((Map) c);
                } else if (c instanceof List) {
                    for (Object c2 : (List) c2) {
                        if (c2 instanceof Map) {
                            this.f14281i.m18571a((Map) c2);
                        } else {
                            C3700z.m18626b("pushAfterEvaluate: value not a Map");
                        }
                    }
                } else {
                    C3700z.m18626b("pushAfterEvaluate: value not a Map or List");
                }
            }
        }
    }

    private ak<C3644b> m18490a(C3644b c3644b, Set<String> set, bm bmVar) {
        if (!c3644b.f14038n) {
            return new ak(c3644b, true);
        }
        C3644b a;
        int i;
        ak a2;
        switch (c3644b.f14026b) {
            case 2:
                a = as.m18478a(c3644b);
                a.f14028d = new C3644b[c3644b.f14028d.length];
                for (i = 0; i < c3644b.f14028d.length; i++) {
                    a2 = m18490a(c3644b.f14028d[i], (Set) set, bmVar.mo4287a(i));
                    if (a2 == f14273a) {
                        return f14273a;
                    }
                    a.f14028d[i] = (C3644b) a2.m18468a();
                }
                return new ak(a, false);
            case 3:
                a = as.m18478a(c3644b);
                if (c3644b.f14029e.length != c3644b.f14030f.length) {
                    C3700z.m18624a("Invalid serving value: " + c3644b.toString());
                    return f14273a;
                }
                a.f14029e = new C3644b[c3644b.f14029e.length];
                a.f14030f = new C3644b[c3644b.f14029e.length];
                for (i = 0; i < c3644b.f14029e.length; i++) {
                    a2 = m18490a(c3644b.f14029e[i], (Set) set, bmVar.mo4288b(i));
                    ak a3 = m18490a(c3644b.f14030f[i], (Set) set, bmVar.mo4289c(i));
                    if (a2 == f14273a || a3 == f14273a) {
                        return f14273a;
                    }
                    a.f14029e[i] = (C3644b) a2.m18468a();
                    a.f14030f[i] = (C3644b) a3.m18468a();
                }
                return new ak(a, false);
            case 4:
                if (set.contains(c3644b.f14031g)) {
                    C3700z.m18624a("Macro cycle detected.  Current macro reference: " + c3644b.f14031g + "." + "  Previous macro references: " + set.toString() + ".");
                    return f14273a;
                }
                set.add(c3644b.f14031g);
                ak<C3644b> a4 = bn.m18542a(m18491a(c3644b.f14031g, (Set) set, bmVar.mo4286a()), c3644b.f14037m);
                set.remove(c3644b.f14031g);
                return a4;
            case 7:
                a = as.m18478a(c3644b);
                a.f14035k = new C3644b[c3644b.f14035k.length];
                for (i = 0; i < c3644b.f14035k.length; i++) {
                    a2 = m18490a(c3644b.f14035k[i], (Set) set, bmVar.mo4290d(i));
                    if (a2 == f14273a) {
                        return f14273a;
                    }
                    a.f14035k[i] = (C3644b) a2.m18468a();
                }
                return new ak(a, false);
            default:
                C3700z.m18624a("Unknown type: " + c3644b.f14026b);
                return f14273a;
        }
    }

    private ak<C3644b> m18492a(Map<String, C3697w> map, at atVar, Set<String> set, ao aoVar) {
        boolean z = true;
        C3644b c3644b = (C3644b) atVar.m18479a().get(C3630a.FUNCTION.toString());
        if (c3644b == null) {
            C3700z.m18624a("No function id in properties");
            return f14273a;
        }
        String str = c3644b.f14032h;
        C3697w c3697w = (C3697w) map.get(str);
        if (c3697w == null) {
            C3700z.m18624a(str + " has no backing implementation.");
            return f14273a;
        }
        ak<C3644b> akVar = (ak) this.f14278f.m18504a(atVar);
        if (akVar != null && !this.f14274b.m18613a()) {
            return akVar;
        }
        Map hashMap = new HashMap();
        boolean z2 = true;
        for (Entry entry : atVar.m18479a().entrySet()) {
            ak a = m18490a((C3644b) entry.getValue(), (Set) set, aoVar.mo4273a((String) entry.getKey()).mo4275a((C3644b) entry.getValue()));
            if (a == f14273a) {
                return f14273a;
            }
            boolean z3;
            if (a.m18469b()) {
                atVar.m18480a((String) entry.getKey(), (C3644b) a.m18468a());
                z3 = z2;
            } else {
                z3 = false;
            }
            hashMap.put(entry.getKey(), a.m18468a());
            z2 = z3;
        }
        if (c3697w.m18616a(hashMap.keySet())) {
            if (!(z2 && c3697w.m18615a())) {
                z = false;
            }
            akVar = new ak(c3697w.m18614a(hashMap), z);
            if (z) {
                this.f14278f.m18505a(atVar, akVar);
            }
            aoVar.mo4274a((C3644b) akVar.m18468a());
            return akVar;
        }
        C3700z.m18624a("Incorrect keys for function " + str + " required " + c3697w.m18617b() + " had " + hashMap.keySet());
        return f14273a;
    }
}
