package cn.com.xy.sms.sdk.p216h.p217a;

import cn.com.fmsh.tsm.business.constants.Constants.XMLNode;
import cn.com.xy.sms.sdk.p208d.p211c.C2934a;
import cn.com.xy.sms.sdk.p208d.p211c.C2937d;
import cn.com.xy.sms.sdk.p208d.p211c.p212a.C2931i;
import cn.com.xy.sms.sdk.p208d.p211c.p212a.C2932j;
import cn.com.xy.sms.sdk.p213e.C2973a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p220j.p224d.C3026b;
import cn.com.xy.sms.sdk.p229l.C3049n;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

final class C2992j implements Runnable {
    private final /* synthetic */ NodeList f10123a;

    C2992j(NodeList nodeList) {
        this.f10123a = nodeList;
    }

    public final void run() {
        try {
            int length = this.f10123a.getLength();
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < length; i++) {
                Element element = (Element) this.f10123a.item(i);
                String nodeValue = element.getFirstChild().getNodeValue();
                String attribute = element.getAttribute("attr1");
                String attribute2 = element.getAttribute("attr2");
                if (C3049n.m13644a(nodeValue, attribute, attribute2)) {
                    List a = C2932j.m13198a("content_sign=? ", new String[]{nodeValue}, 1);
                    C2931i c2931i = (a == null || a.size() <= 0) ? null : (C2931i) a.get(0);
                    if (c2931i != null) {
                        String[] a2 = C2973a.m13368a(C3049n.m13657h(c2931i.f9939a), attribute, attribute2);
                        if (a2 != null && a2.length >= 2) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("contentSign", nodeValue);
                            jSONObject.put(XMLNode.KEY_INDEX, attribute);
                            jSONObject.put("mod", attribute2);
                            jSONObject.put("characterSequence", a2[0]);
                            jSONObject.put("eof", a2[1]);
                            jSONArray.put(jSONObject);
                        }
                    }
                }
            }
            if (jSONArray.length() > 0) {
                C2934a.m13205a(jSONArray.toString(), C2937d.UPLOAD_SHARD, 0);
                C3026b.m13563a();
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "ServerUtil parseShardTask error:" + th.getMessage(), th);
        }
    }
}
