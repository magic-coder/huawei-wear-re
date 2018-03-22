package com.huawei.p108n;

import com.huawei.hwcloudmodel.b.i;
import com.huawei.hwcloudmodel.c.w;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdevicemgr.b;
import com.huawei.hwdevicemgr.d;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.p514d.C5999c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: DeviceInfoManager */
public class C5495a {
    private static C5496b f19360a = new C5496b();
    private static C5496b f19361b = new C5496b();
    private static C5496b f19362c = new C5496b();
    private static C5496b f19363d = new C5496b();
    private static C5496b f19364e = new C5496b();
    private static C5496b f19365f = new C5496b();
    private static C5496b f19366g = new C5496b();
    private static C5496b f19367h = new C5496b();
    private static C5496b f19368i = new C5496b();
    private static C5496b f19369j = new C5496b();
    private static C5496b f19370k = new C5496b();
    private static C5496b f19371l = new C5496b();
    private static C5496b f19372m = new C5496b();
    private static C5496b f19373n = new C5496b();
    private static C5496b f19374o = new C5496b();
    private static C5496b f19375p = new C5496b();
    private static C5496b f19376q = new C5496b();
    private static ArrayList<C5496b> f19377r = new ArrayList();
    private static HashMap<Integer, ArrayList<String>> f19378s = new HashMap();

    static {
        C2538c.c("DeviceInfoManager", new Object[]{"enter init start"});
        f19360a.m26256c(BaseApplication.b().getString(d.IDS_app_display_name_leo));
        f19360a.m26264g(10);
        f19360a.m26253b(BaseApplication.b().getString(d.IDS_add_device_smart_watch_content));
        f19360a.m26266h(b.device_icon_leo);
        f19360a.m26262f(b.device_icon_leo_disconnected);
        f19360a.m26260e(46);
        f19360a.m26252b(b.ic_spinner_watch);
        f19360a.m26255c(b.home_watch2);
        f19360a.m26249a(0);
        f19377r.add(f19360a);
        f19361b.m26256c(BaseApplication.b().getString(d.IDS_app_display_name_w1));
        f19361b.m26264g(3);
        f19361b.m26253b(BaseApplication.b().getString(d.IDS_add_device_smart_watch_content));
        f19361b.m26266h(b.device_icon_watch);
        f19361b.m26262f(b.device_icon_watch_disconnect);
        f19361b.m26260e(36);
        f19361b.m26252b(b.ic_spinner_watch);
        f19361b.m26255c(b.home_watch);
        f19361b.m26249a(0);
        f19377r.add(f19361b);
        f19362c.m26256c(BaseApplication.b().getString(d.IDS_app_display_name_porc));
        f19362c.m26264g(10);
        f19362c.m26253b(BaseApplication.b().getString(d.IDS_add_device_smart_watch_content));
        f19362c.m26266h(b.device_icon_leo2);
        f19362c.m26262f(b.device_icon_leo2_disconnect);
        f19362c.m26260e(46);
        f19362c.m26252b(b.ic_spinner_watch);
        f19363d.m26256c(C5999c.m27457f(BaseApplication.b()));
        f19363d.m26264g(8);
        f19363d.m26253b(String.format(BaseApplication.b().getString(d.IDS_S1_description_content), new Object[]{Integer.valueOf(50)}));
        f19363d.m26266h(b.device_icon_metis);
        f19363d.m26262f(b.device_icon_metis_disconnect);
        f19363d.m26260e(41);
        f19363d.m26258d(b.pic_pairing_metis);
        f19363d.m26252b(b.ic_spinner_metis);
        f19363d.m26255c(b.img_home_honorwatch);
        f19363d.m26250a("com.huawei.metis.firmware");
        f19363d.m26249a(2);
        ArrayList arrayList = new ArrayList();
        arrayList.add("metis");
        arrayList.add("honor watch S1");
        arrayList.add("HUAWEI FIT");
        f19378s.put(Integer.valueOf(8), arrayList);
        f19377r.add(f19363d);
        f19364e.m26256c(BaseApplication.b().getString(d.IDS_app_display_name_grus));
        f19364e.m26264g(14);
        f19364e.m26253b(BaseApplication.b().getString(d.IDS_startup_tablband_intro));
        f19364e.m26266h(b.device_icon_grus);
        f19364e.m26262f(b.device_icon_grus_disconnect);
        f19364e.m26260e(45);
        f19364e.m26258d(b.pic_grus);
        f19364e.m26252b(b.ic_spinner_talkband);
        f19364e.m26255c(b.img_home_talkbandb3_talk_lite);
        f19364e.m26250a("com.huawei.grus.firmware");
        f19364e.m26249a(1);
        arrayList = new ArrayList();
        arrayList.add("HUAWEI GRUS");
        arrayList.add("HUAWEI B3 Lite-");
        f19378s.put(Integer.valueOf(14), arrayList);
        f19377r.add(f19364e);
        f19365f.m26256c(BaseApplication.b().getString(d.IDS_app_display_name_eris));
        f19365f.m26264g(15);
        f19365f.m26253b(String.format(BaseApplication.b().getString(d.IDS_nyx_content), new Object[]{Integer.valueOf(50)}));
        f19365f.m26266h(b.device_icon_eris);
        f19365f.m26262f(b.device_icon_eris_disconnect);
        f19365f.m26260e(47);
        f19365f.m26258d(b.pic_eris);
        f19365f.m26252b(b.ic_spinner_talkband);
        f19365f.m26255c(b.img_home_eris);
        f19365f.m26250a("com.huawei.Eris.firmware");
        f19365f.m26249a(2);
        arrayList = new ArrayList();
        arrayList.add("Huawei Band 2-");
        f19378s.put(Integer.valueOf(15), arrayList);
        f19377r.add(f19365f);
        f19366g.m26256c(BaseApplication.b().getString(d.IDS_app_display_name_nys));
        f19366g.m26264g(13);
        f19366g.m26253b(String.format(BaseApplication.b().getString(d.IDS_nyx_content), new Object[]{Integer.valueOf(50)}));
        f19366g.m26266h(b.device_icon_nyx);
        f19366g.m26262f(b.device_icon_nyx_disconnect);
        f19366g.m26260e(42);
        f19366g.m26258d(b.pic_nyx);
        f19366g.m26252b(b.ic_spinner_talkband);
        f19366g.m26255c(b.img_home_nyx);
        f19366g.m26250a("com.huawei.nyx.firmware");
        f19366g.m26249a(2);
        arrayList = new ArrayList();
        arrayList.add("HUAWEI NYX");
        arrayList.add("HONOR NYX");
        arrayList.add("Honor Band 3-");
        f19378s.put(Integer.valueOf(13), arrayList);
        f19377r.add(f19366g);
        f19367h.m26256c(C5999c.m27458g(BaseApplication.b()));
        f19367h.m26264g(12);
        f19367h.m26253b(BaseApplication.b().getString(d.IDS_huawei_a1p_content));
        f19367h.m26266h(b.device_icon_a1);
        f19367h.m26262f(b.device_icon_a1_disconnect);
        f19367h.m26260e(44);
        f19367h.m26258d(b.pic_a1);
        f19367h.m26252b(b.ic_spinner_talkband);
        f19367h.m26255c(b.img_home_talkbanda1);
        f19367h.m26250a("com.huawei.aonepro.firmware");
        f19367h.m26249a(2);
        arrayList = new ArrayList();
        arrayList.add("HUAWEI band A2");
        arrayList.add("honor band A2");
        arrayList.add("AW61");
        arrayList.add("HUAWEI Color Band A2");
        f19378s.put(Integer.valueOf(12), arrayList);
        f19377r.add(f19367h);
        f19368i.m26256c(BaseApplication.b().getString(d.IDS_app_display_name_gemini));
        f19368i.m26264g(7);
        f19368i.m26253b(BaseApplication.b().getString(d.IDS_startup_tablband_intro));
        f19368i.m26266h(b.device_icon_gemini);
        f19368i.m26262f(b.device_icon_gemini_disconnect);
        f19368i.m26260e(39);
        f19368i.m26258d(b.pic_b3);
        f19368i.m26252b(b.ic_spinner_talkband);
        f19368i.m26255c(b.img_home_talkbandb3);
        f19368i.m26250a("com.huawei.gemini.firmware");
        f19368i.m26249a(1);
        arrayList = new ArrayList();
        arrayList.add("HUAWEI GE");
        arrayList.add("HUAWEI B3-");
        f19378s.put(Integer.valueOf(7), arrayList);
        f19377r.add(f19368i);
        f19369j.m26256c(BaseApplication.b().getString(d.IDS_select_device_b2_name));
        f19369j.m26264g(1);
        f19369j.m26253b(BaseApplication.b().getString(d.IDS_startup_tablband_intro));
        f19369j.m26266h(b.device_icon_b2);
        f19369j.m26262f(b.device_icon_b2_disconnect);
        f19369j.m26260e(22);
        f19369j.m26258d(b.pic_b2);
        f19369j.m26252b(b.ic_spinner_talkband);
        f19369j.m26255c(b.img_home_talkbandb2);
        f19369j.m26250a("com.huawei.btwo.firmware");
        f19369j.m26249a(1);
        arrayList = new ArrayList();
        arrayList.add("HUAWEI B2");
        f19378s.put(Integer.valueOf(1), arrayList);
        f19377r.add(f19369j);
        f19370k.m26256c(BaseApplication.b().getString(d.IDS_select_device_b1_name));
        f19370k.m26264g(0);
        f19370k.m26253b(BaseApplication.b().getString(d.IDS_startup_tablband_intro));
        f19370k.m26266h(b.device_icon_b1);
        f19370k.m26262f(b.device_icon_b1_disconnect);
        f19370k.m26260e(21);
        f19370k.m26258d(b.pic_b1);
        f19370k.m26252b(b.ic_spinner_talkband);
        f19370k.m26255c(b.img_home_talkbandb1);
        f19370k.m26249a(1);
        arrayList = new ArrayList();
        arrayList.add("HUAWEI B1");
        f19378s.put(Integer.valueOf(0), arrayList);
        f19377r.add(f19370k);
        f19371l.m26256c(C5999c.m27459h(BaseApplication.b()));
        f19371l.m26264g(5);
        f19371l.m26253b(BaseApplication.b().getString(d.IDS_talk_band_content_b0));
        f19371l.m26266h(b.device_icon_b0);
        f19371l.m26262f(b.device_icon_b0_disconnect);
        f19371l.m26260e(35);
        f19371l.m26258d(b.pic_b0);
        f19371l.m26252b(b.ic_spinner_metis);
        f19371l.m26255c(b.img_home_talkbandb0);
        f19371l.m26250a("com.huawei.bzero.firmware");
        f19371l.m26249a(2);
        arrayList = new ArrayList();
        arrayList.add("HONOR ZERO");
        arrayList.add("HUAWEI B0");
        arrayList.add("HUAWEI BAND-");
        arrayList.add("HONOR BAND Z1");
        f19378s.put(Integer.valueOf(5), arrayList);
        f19377r.add(f19371l);
        f19372m.m26256c(BaseApplication.b().getString(d.IDS_messagecenter_color_band_name));
        f19372m.m26264g(-2);
        f19372m.m26253b(BaseApplication.b().getString(d.IDS_startup_colorband_intro));
        f19372m.m26266h(b.device_icon_colorband);
        f19372m.m26262f(b.device_icon_colorband_disconnect);
        f19372m.m26260e(23);
        f19372m.m26255c(b.img_home_colorband);
        arrayList = new ArrayList();
        arrayList.add("ColorBand");
        f19378s.put(Integer.valueOf(-2), arrayList);
        f19377r.add(f19372m);
        f19373n.m26256c(BaseApplication.b().getString(d.IDS_app_display_name_k2));
        f19373n.m26264g(9);
        f19373n.m26253b(BaseApplication.b().getString(d.IDS_common_wear_kid_watch_k1_content));
        f19373n.m26266h(b.device_icon_k2);
        f19373n.m26262f(b.device_icon_k2_disconnect);
        f19373n.m26260e(62);
        f19373n.m26252b(b.ic_spinner_kidswatch);
        f19377r.add(f19373n);
        f19374o.m26256c(BaseApplication.b().getString(d.IDS_app_display_name_k1));
        f19374o.m26264g(2);
        f19374o.m26253b(BaseApplication.b().getString(d.IDS_common_wear_kid_watch_k1_content));
        f19374o.m26266h(b.device_icon_k1);
        f19374o.m26262f(b.device_icon_k1_disconnect);
        f19374o.m26260e(61);
        f19374o.m26252b(b.ic_spinner_kidswatch);
        f19374o.m26249a(2);
        f19377r.add(f19374o);
        f19375p.m26256c(BaseApplication.b().getString(d.IDS_huawei_r1_content));
        f19375p.m26264g(11);
        f19375p.m26253b(BaseApplication.b().getString(d.IDS_device_r1_name_title));
        f19375p.m26266h(b.device_icon_honorband_r1);
        f19375p.m26262f(b.device_icon_honorband_r1_disconnect);
        f19375p.m26260e(43);
        f19375p.m26252b(b.ic_home_spinner_r1);
        f19375p.m26255c(b.img_home_honorbandr1);
        f19375p.m26249a(1);
        f19377r.add(f19375p);
        f19376q.m26256c(BaseApplication.b().getString(d.IDS_huawei_r1_pro_content));
        f19376q.m26264g(11);
        f19376q.m26253b(BaseApplication.b().getString(d.IDS_device_r1_pro_name_title));
        f19376q.m26266h(b.id_devicemanager_r1_pro);
        f19376q.m26262f(b.id_devicemanager_r1_pro_disconnected);
        f19376q.m26260e(43);
        f19376q.m26252b(b.ic_home_spinner_r1);
        f19376q.m26255c(b.img_home_honorbandr1);
        f19376q.m26249a(1);
        arrayList = new ArrayList();
        arrayList.add("HUAWEI AM-R1");
        arrayList.add("HUAWEI CM-R1P");
        f19378s.put(Integer.valueOf(11), arrayList);
        C2538c.c("DeviceInfoManager", new Object[]{"enter init end   num:" + f19377r.size()});
    }

    public static ArrayList<String> m26237a() {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add(f19360a.m26268j());
        arrayList.add(f19361b.m26268j());
        arrayList.add(f19362c.m26268j());
        arrayList.add(f19363d.m26268j());
        return arrayList;
    }

    public static ArrayList<String> m26238b() {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add(f19364e.m26268j());
        arrayList.add(f19365f.m26268j());
        arrayList.add(f19366g.m26268j());
        arrayList.add(f19367h.m26268j());
        arrayList.add(f19368i.m26268j());
        arrayList.add(f19369j.m26268j());
        arrayList.add(f19370k.m26268j());
        arrayList.add(f19371l.m26268j());
        if (C5999c.m27453b(BaseApplication.b())) {
            arrayList.add(f19372m.m26268j());
        }
        return arrayList;
    }

    public static ArrayList<String> m26240c() {
        ArrayList<String> arrayList = new ArrayList();
        if (i.a(1) && com.huawei.hwcommonmodel.d.d.a(BaseApplication.b()) && !w.b()) {
            arrayList.add(f19373n.m26268j());
        }
        if (i.a(1) && com.huawei.hwcommonmodel.d.d.a(BaseApplication.b()) && !w.b()) {
            arrayList.add(f19374o.m26268j());
        }
        return arrayList;
    }

    public static ArrayList<String> m26241d() {
        ArrayList<String> arrayList = new ArrayList();
        if (i.a(61)) {
            arrayList.add(f19375p.m26268j());
            arrayList.add(f19376q.m26268j());
        }
        return arrayList;
    }

    public static ArrayList<C5496b> m26242e() {
        ArrayList<C5496b> arrayList = new ArrayList();
        arrayList.add(f19360a);
        arrayList.add(f19361b);
        arrayList.add(f19362c);
        arrayList.add(f19363d);
        return arrayList;
    }

    public static ArrayList<C5496b> m26243f() {
        ArrayList<C5496b> arrayList = new ArrayList();
        arrayList.add(f19364e);
        arrayList.add(f19365f);
        arrayList.add(f19366g);
        arrayList.add(f19367h);
        arrayList.add(f19368i);
        arrayList.add(f19369j);
        arrayList.add(f19370k);
        arrayList.add(f19371l);
        if (C5999c.m27453b(BaseApplication.b())) {
            arrayList.add(f19372m);
        }
        return arrayList;
    }

    public static ArrayList<C5496b> m26244g() {
        ArrayList<C5496b> arrayList = new ArrayList();
        if (i.a(1) && com.huawei.hwcommonmodel.d.d.a(BaseApplication.b()) && !w.b()) {
            arrayList.add(f19373n);
        }
        if (i.a(1) && com.huawei.hwcommonmodel.d.d.a(BaseApplication.b()) && !w.b()) {
            arrayList.add(f19374o);
        }
        return arrayList;
    }

    public static ArrayList<C5496b> m26245h() {
        ArrayList<C5496b> arrayList = new ArrayList();
        if (i.a(61)) {
            arrayList.add(f19375p);
            arrayList.add(f19376q);
        }
        return arrayList;
    }

    public static C5496b m26236a(int i) {
        C5496b c5496b = new C5496b();
        Iterator it = f19377r.iterator();
        while (it.hasNext()) {
            C5496b c5496b2 = (C5496b) it.next();
            if (c5496b2.m26263g() == i) {
                return c5496b2;
            }
        }
        return c5496b;
    }

    public static C5496b m26246i() {
        return f19362c;
    }

    public static C5496b m26247j() {
        return f19376q;
    }

    public static int m26235a(String str) {
        C2538c.b("DeviceInfoManager", new Object[]{"enter getTypeByName + name:" + str});
        for (Entry entry : f19378s.entrySet()) {
            Iterator it = ((ArrayList) entry.getValue()).iterator();
            while (it.hasNext()) {
                if (str.toUpperCase().contains(((String) it.next()).toUpperCase())) {
                    return ((Integer) entry.getKey()).intValue();
                }
            }
        }
        return -1;
    }

    public static ArrayList<String> m26239b(int i) {
        ArrayList<String> arrayList = new ArrayList();
        if (f19378s.containsKey(Integer.valueOf(i))) {
            return (ArrayList) f19378s.get(Integer.valueOf(i));
        }
        return arrayList;
    }
}
