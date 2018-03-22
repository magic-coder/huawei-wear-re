package cn.com.xy.sms.sdk.p229l;

import android.content.ContentValues;
import cn.com.xy.sms.sdk.p208d.C2922b;
import cn.com.xy.sms.sdk.p208d.p211c.C2938e;
import cn.com.xy.sms.sdk.p208d.p211c.C2939f;
import cn.com.xy.sms.sdk.p208d.p211c.C2946m;
import cn.com.xy.sms.sdk.p208d.p211c.af;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p216h.C2996a;
import com.sina.weibo.sdk.component.GameManager;
import java.io.Closeable;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public final class C3039d extends Thread {
    private static HashSet<String> f10282a = new HashSet();
    private static boolean f10283b = false;

    private C3039d() {
    }

    private static synchronized C2938e m13594a() {
        C2938e c2938e;
        synchronized (C3039d.class) {
            Iterator it = f10282a.iterator();
            c2938e = null;
            Object arrayList = new ArrayList();
            while (it != null && it.hasNext()) {
                String str = (String) it.next();
                C2938e b = C2939f.m13252b(str);
                arrayList.add(str);
                if (b != null) {
                    c2938e = b;
                    break;
                }
                c2938e = b;
            }
            f10282a.removeAll(arrayList);
            arrayList.clear();
        }
        return c2938e;
    }

    private static List<af> m13595a(Document document) {
        List<af> arrayList = new ArrayList();
        if (document != null) {
            try {
                NodeList elementsByTagName = document.getElementsByTagName("Scene");
                for (int i = 0; i < elementsByTagName.getLength(); i++) {
                    int i2;
                    af afVar = new af();
                    Element element = (Element) elementsByTagName.item(i);
                    NodeList childNodes = element.getChildNodes();
                    for (i2 = 0; i2 < childNodes.getLength(); i2++) {
                        Node item = childNodes.item(i2);
                        if (item.getNodeType() == (short) 1) {
                            String nodeName = item.getNodeName();
                            if ("sceneId".equalsIgnoreCase(nodeName)) {
                                afVar.f9952a = C3042g.m13612a(item);
                            } else if ("sceneVersion".equalsIgnoreCase(nodeName)) {
                                afVar.f9953b = C3042g.m13612a(item);
                            }
                        }
                    }
                    childNodes = element.getElementsByTagName("SceneRule");
                    if (childNodes != null) {
                        int length = childNodes.getLength();
                        for (i2 = 0; i2 < length; i2++) {
                            C2946m c2946m = new C2946m();
                            NodeList childNodes2 = ((Element) childNodes.item(i2)).getChildNodes();
                            for (int i3 = 0; i3 < childNodes2.getLength(); i3++) {
                                Node item2 = childNodes2.item(i3);
                                if (item2.getNodeType() == (short) 1) {
                                    String nodeName2 = item2.getNodeName();
                                    if (item2.getNodeType() == (short) 1) {
                                        if ("sceneId".equalsIgnoreCase(nodeName2)) {
                                            c2946m.f9997c = C3042g.m13612a(item2);
                                        } else if ("sceneRuleVersion".equalsIgnoreCase(nodeName2)) {
                                            c2946m.f9995a = C3042g.m13612a(item2);
                                        } else if ("province".equalsIgnoreCase(nodeName2)) {
                                            c2946m.f9998d = C3042g.m13612a(item2);
                                        } else if ("id".equalsIgnoreCase(nodeName2)) {
                                            c2946m.f9996b = C3042g.m13612a(item2);
                                        } else if ("operator".equalsIgnoreCase(nodeName2)) {
                                            c2946m.f9999e = C3042g.m13612a(item2);
                                        } else if ("expire_date".equalsIgnoreCase(nodeName2)) {
                                            c2946m.f10000f = C3042g.m13612a(item2);
                                        } else if ("fun_call".equalsIgnoreCase(nodeName2)) {
                                            c2946m.f10001g = Integer.parseInt(C3042g.m13612a(item2));
                                        } else if ("fun_acc_url".equalsIgnoreCase(nodeName2)) {
                                            c2946m.f10002h = Integer.parseInt(C3042g.m13612a(item2));
                                        } else if ("fun_reply_sms".equalsIgnoreCase(nodeName2)) {
                                            c2946m.f10003i = Integer.parseInt(C3042g.m13612a(item2));
                                        } else if ("fun_config".equalsIgnoreCase(nodeName2)) {
                                            c2946m.f10004j = C3042g.m13612a(item2);
                                        } else if ("res_urls".equalsIgnoreCase(nodeName2)) {
                                            c2946m.f10005k = C3042g.m13612a(item2);
                                        } else if ("s_version".equalsIgnoreCase(nodeName2)) {
                                            c2946m.f10006l = C3042g.m13612a(item2);
                                        } else if ("scene_page_conf".equalsIgnoreCase(nodeName2)) {
                                            c2946m.f10007m = C3042g.m13612a(item2);
                                        }
                                    }
                                }
                            }
                            afVar.m13236a(c2946m);
                        }
                        continue;
                    }
                    arrayList.add(afVar);
                }
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "getSceneconfig: " + th.getMessage(), th);
            }
        }
        new StringBuilder("sceneconfigList=").append(arrayList.toString());
        return arrayList;
    }

    private void m13596a(C2938e c2938e) {
        if (!C2996a.m13492a(2)) {
            return;
        }
        if (c2938e != null) {
            try {
                m13600b(c2938e);
                try {
                    Thread.sleep(2000);
                } catch (Throwable th) {
                    C2982a.m13415a("XIAOYUAN", "downLoadRes: " + th.getMessage(), th);
                }
                m13596a(C3039d.m13599b());
                return;
            } catch (Throwable th2) {
                C2982a.m13415a("XIAOYUAN", "downLoadRes: " + th2.getMessage(), th2);
            }
        } else {
            f10283b = false;
            return;
        }
        m13596a(C3039d.m13599b());
    }

    public static synchronized void m13597a(String str) {
        synchronized (C3039d.class) {
            if (!(C3049n.m13653e(str) || f10282a.contains(str))) {
                f10282a.add(str);
            }
        }
    }

    public static synchronized void m13598a(boolean z) {
        synchronized (C3039d.class) {
            if (!f10283b) {
                new C3039d().start();
            }
        }
    }

    private static synchronized C2938e m13599b() {
        C2938e a;
        synchronized (C3039d.class) {
            a = C3039d.m13594a();
            if (a == null) {
                a = C2939f.m13248a();
            }
        }
        return a;
    }

    private synchronized void m13600b(C2938e c2938e) {
        Throwable th;
        Object obj = 1;
        synchronized (this) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(c2938e.f9972b).openConnection();
                int responseCode = httpURLConnection.getResponseCode();
                new StringBuilder("url=").append(c2938e.f9972b).append(" ResponseCode=").append(responseCode);
                if (responseCode == 200) {
                    Closeable inputStream;
                    byte[] a;
                    try {
                        inputStream = httpURLConnection.getInputStream();
                        a = C3049n.m13645a(C3055t.m13705a((InputStream) inputStream));
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            C2982a.m13415a("XIAOYUAN", "XmlDownLloaderQueue.downloadzippackage", th);
                            if (obj != null) {
                                C2939f.m13249a(c2938e.f9971a, 1);
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            if (obj != null) {
                                C2939f.m13249a(c2938e.f9971a, 1);
                            }
                            throw th;
                        }
                    }
                    List a2 = C3039d.m13595a(C3049n.m13643a(new String(a, GameManager.DEFAULT_CHARSET), ""));
                    C3055t.m13696a(inputStream);
                    C3048m.m13632a(a2, c2938e.f9973c);
                } else {
                    obj = null;
                }
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("last_load_time", new StringBuilder(String.valueOf(currentTimeMillis)).toString());
                    C2922b.m13133a("tb_xml_res_download", contentValues, "id = ? ", new String[]{new StringBuilder(String.valueOf(c2938e.f9971a)).toString()});
                } catch (Throwable th4) {
                    C2982a.m13415a("XIAOYUAN", "updateLoadTime: " + th4.getMessage(), th4);
                }
                if (obj != null) {
                    C2939f.m13249a(c2938e.f9971a, 1);
                }
            } catch (Throwable th5) {
                th4 = th5;
                obj = null;
                if (obj != null) {
                    C2939f.m13249a(c2938e.f9971a, 1);
                }
                throw th4;
            }
        }
    }

    private static synchronized void m13601b(boolean z) {
        synchronized (C3039d.class) {
            f10283b = z;
        }
    }

    public final void run() {
        try {
            if (!f10283b) {
                C3039d.m13601b(true);
                Thread.sleep(3000);
                m13596a(C3039d.m13599b());
                C3039d.m13601b(false);
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "run: " + th.getMessage(), th);
        }
    }
}
