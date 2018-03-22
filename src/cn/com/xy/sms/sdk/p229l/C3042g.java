package cn.com.xy.sms.sdk.p229l;

import cn.com.xy.sms.sdk.p215g.C2982a;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public final class C3042g {
    public static int m13610a(String str) {
        if (!C3049n.m13653e(str)) {
            try {
                return Integer.parseInt(str);
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "getIntContent: " + th.getMessage(), th);
            }
        }
        return 0;
    }

    public static String m13611a(Element element, String str) {
        try {
            NodeList elementsByTagName = element.getElementsByTagName(str);
            if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                return C3042g.m13612a(elementsByTagName.item(0)).toString();
            }
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "getContentByTag: " + th.getMessage(), th);
        }
        return "";
    }

    public static String m13612a(Node node) {
        if (node != null) {
            try {
                Node firstChild = node.getFirstChild();
                if (firstChild != null) {
                    return firstChild.getNodeValue().trim();
                }
            } catch (Throwable th) {
            }
        }
        return "";
    }
}
