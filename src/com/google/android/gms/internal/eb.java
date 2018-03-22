package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.C0571r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public final class eb {
    private static int m1270a(String str, ef[] efVarArr) {
        int i = 14;
        for (ef efVar : efVarArr) {
            if (i == 14) {
                if (efVar.f717a == 9 || efVar.f717a == 2 || efVar.f717a == 6) {
                    i = efVar.f717a;
                } else if (efVar.f717a != 14) {
                    throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 48).append("Unexpected TypedValue type: ").append(efVar.f717a).append(" for key ").append(str).toString());
                }
            } else if (efVar.f717a != i) {
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + TransportMediator.KEYCODE_MEDIA_PLAY).append("The ArrayList elements should all be the same type, but ArrayList with key ").append(str).append(" contains items of type ").append(i).append(" and ").append(efVar.f717a).toString());
            }
        }
        return i;
    }

    static int m1271a(List<Asset> list, Asset asset) {
        list.add(asset);
        return list.size() - 1;
    }

    public static ec m1272a(C0571r c0571r) {
        ed edVar = new ed();
        List arrayList = new ArrayList();
        edVar.f712a = m1277a(c0571r, arrayList);
        return new ec(edVar, arrayList);
    }

    private static ef m1273a(List<Asset> list, Object obj) {
        ef efVar = new ef();
        if (obj == null) {
            efVar.f717a = 14;
            return efVar;
        }
        efVar.f718b = new eg();
        if (obj instanceof String) {
            efVar.f717a = 2;
            efVar.f718b.f720b = (String) obj;
        } else if (obj instanceof Integer) {
            efVar.f717a = 6;
            efVar.f718b.f724f = ((Integer) obj).intValue();
        } else if (obj instanceof Long) {
            efVar.f717a = 5;
            efVar.f718b.f723e = ((Long) obj).longValue();
        } else if (obj instanceof Double) {
            efVar.f717a = 3;
            efVar.f718b.f721c = ((Double) obj).doubleValue();
        } else if (obj instanceof Float) {
            efVar.f717a = 4;
            efVar.f718b.f722d = ((Float) obj).floatValue();
        } else if (obj instanceof Boolean) {
            efVar.f717a = 8;
            efVar.f718b.f726h = ((Boolean) obj).booleanValue();
        } else if (obj instanceof Byte) {
            efVar.f717a = 7;
            efVar.f718b.f725g = ((Byte) obj).byteValue();
        } else if (obj instanceof byte[]) {
            efVar.f717a = 1;
            efVar.f718b.f719a = (byte[]) obj;
        } else if (obj instanceof String[]) {
            efVar.f717a = 11;
            efVar.f718b.f729k = (String[]) obj;
        } else if (obj instanceof long[]) {
            efVar.f717a = 12;
            efVar.f718b.f730l = (long[]) obj;
        } else if (obj instanceof float[]) {
            efVar.f717a = 15;
            efVar.f718b.f731m = (float[]) obj;
        } else if (obj instanceof Asset) {
            efVar.f717a = 13;
            efVar.f718b.f732n = (long) m1271a((List) list, (Asset) obj);
        } else if (obj instanceof C0571r) {
            efVar.f717a = 9;
            C0571r c0571r = (C0571r) obj;
            TreeSet treeSet = new TreeSet(c0571r.m2251b());
            ee[] eeVarArr = new ee[treeSet.size()];
            Iterator it = treeSet.iterator();
            r1 = 0;
            while (it.hasNext()) {
                r0 = (String) it.next();
                eeVarArr[r1] = new ee();
                eeVarArr[r1].f714a = r0;
                eeVarArr[r1].f715b = m1273a((List) list, c0571r.m2234a(r0));
                r1++;
            }
            efVar.f718b.f727i = eeVarArr;
        } else if (obj instanceof ArrayList) {
            efVar.f717a = 10;
            ArrayList arrayList = (ArrayList) obj;
            ef[] efVarArr = new ef[arrayList.size()];
            Object obj2 = null;
            int size = arrayList.size();
            int i = 0;
            int i2 = 14;
            while (i < size) {
                Object obj3 = arrayList.get(i);
                ef a = m1273a((List) list, obj3);
                if (a.f717a == 14 || a.f717a == 2 || a.f717a == 6 || a.f717a == 9) {
                    if (i2 == 14 && a.f717a != 14) {
                        r1 = a.f717a;
                    } else if (a.f717a != i2) {
                        String valueOf = String.valueOf(obj2.getClass());
                        r0 = String.valueOf(obj3.getClass());
                        throw new IllegalArgumentException(new StringBuilder((String.valueOf(valueOf).length() + 80) + String.valueOf(r0).length()).append("ArrayList elements must all be of the sameclass, but this one contains a ").append(valueOf).append(" and a ").append(r0).toString());
                    } else {
                        obj3 = obj2;
                        r1 = i2;
                    }
                    efVarArr[i] = a;
                    i++;
                    i2 = r1;
                    obj2 = obj3;
                } else {
                    r0 = String.valueOf(obj3.getClass());
                    throw new IllegalArgumentException(new StringBuilder(String.valueOf(r0).length() + TransportMediator.KEYCODE_MEDIA_RECORD).append("The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a ").append(r0).toString());
                }
            }
            efVar.f718b.f728j = efVarArr;
        } else {
            String str = "newFieldValueFromValue: unexpected value ";
            r0 = String.valueOf(obj.getClass().getSimpleName());
            throw new RuntimeException(r0.length() != 0 ? str.concat(r0) : new String(str));
        }
        return efVar;
    }

    public static C0571r m1274a(ec ecVar) {
        C0571r c0571r = new C0571r();
        for (ee eeVar : ecVar.f708a.f712a) {
            m1276a(ecVar.f709b, c0571r, eeVar.f714a, eeVar.f715b);
        }
        return c0571r;
    }

    private static ArrayList m1275a(List<Asset> list, eg egVar, int i) {
        ArrayList arrayList = new ArrayList(egVar.f728j.length);
        for (ef efVar : egVar.f728j) {
            if (efVar.f717a == 14) {
                arrayList.add(null);
            } else if (i == 9) {
                C0571r c0571r = new C0571r();
                for (ee eeVar : efVar.f718b.f727i) {
                    m1276a(list, c0571r, eeVar.f714a, eeVar.f715b);
                }
                arrayList.add(c0571r);
            } else if (i == 2) {
                arrayList.add(efVar.f718b.f720b);
            } else if (i == 6) {
                arrayList.add(Integer.valueOf(efVar.f718b.f724f));
            } else {
                throw new IllegalArgumentException("Unexpected typeOfArrayList: " + i);
            }
        }
        return arrayList;
    }

    private static void m1276a(List<Asset> list, C0571r c0571r, String str, ef efVar) {
        int i = efVar.f717a;
        if (i == 14) {
            c0571r.m2243a(str, null);
            return;
        }
        eg egVar = efVar.f718b;
        if (i == 1) {
            c0571r.m2246a(str, egVar.f719a);
        } else if (i == 11) {
            c0571r.m2249a(str, egVar.f729k);
        } else if (i == 12) {
            c0571r.m2248a(str, egVar.f730l);
        } else if (i == 15) {
            c0571r.m2247a(str, egVar.f731m);
        } else if (i == 2) {
            c0571r.m2243a(str, egVar.f720b);
        } else if (i == 3) {
            c0571r.m2237a(str, egVar.f721c);
        } else if (i == 4) {
            c0571r.m2238a(str, egVar.f722d);
        } else if (i == 5) {
            c0571r.m2240a(str, egVar.f723e);
        } else if (i == 6) {
            c0571r.m2239a(str, egVar.f724f);
        } else if (i == 7) {
            c0571r.m2236a(str, (byte) egVar.f725g);
        } else if (i == 8) {
            c0571r.m2245a(str, egVar.f726h);
        } else if (i == 13) {
            if (list == null) {
                String str2 = "populateBundle: unexpected type for: ";
                String valueOf = String.valueOf(str);
                throw new RuntimeException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            }
            c0571r.m2241a(str, (Asset) list.get((int) egVar.f732n));
        } else if (i == 9) {
            C0571r c0571r2 = new C0571r();
            for (ee eeVar : egVar.f727i) {
                m1276a(list, c0571r2, eeVar.f714a, eeVar.f715b);
            }
            c0571r.m2242a(str, c0571r2);
        } else if (i == 10) {
            i = m1270a(str, egVar.f728j);
            ArrayList a = m1275a(list, egVar, i);
            if (i == 14) {
                c0571r.m2253c(str, a);
            } else if (i == 9) {
                c0571r.m2244a(str, a);
            } else if (i == 2) {
                c0571r.m2253c(str, a);
            } else if (i == 6) {
                c0571r.m2252b(str, a);
            } else {
                throw new IllegalStateException("Unexpected typeOfArrayList: " + i);
            }
        } else {
            throw new RuntimeException("populateBundle: unexpected type " + i);
        }
    }

    private static ee[] m1277a(C0571r c0571r, List<Asset> list) {
        TreeSet treeSet = new TreeSet(c0571r.m2251b());
        ee[] eeVarArr = new ee[treeSet.size()];
        Iterator it = treeSet.iterator();
        int i = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            Object a = c0571r.m2234a(str);
            eeVarArr[i] = new ee();
            eeVarArr[i].f714a = str;
            eeVarArr[i].f715b = m1273a((List) list, a);
            i++;
        }
        return eeVarArr;
    }
}
