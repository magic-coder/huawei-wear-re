package com.aps;

import com.amap.api.location.LocationManagerProxy;
import com.sina.weibo.sdk.component.GameManager;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.helpers.DefaultHandler;

/* compiled from: Parser */
public class bi {
    protected bi() {
    }

    ap m17420a(String str) {
        if (str == null || str.length() == 0 || str.contains("SuccessCode=\"0\"")) {
            return null;
        }
        InputStream byteArrayInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(str.getBytes(GameManager.DEFAULT_CHARSET));
        } catch (UnsupportedEncodingException e) {
            byteArrayInputStream = null;
        }
        SAXParserFactory newInstance = SAXParserFactory.newInstance();
        DefaultHandler bkVar = new bk();
        if (byteArrayInputStream != null) {
            try {
                newInstance.newSAXParser().parse(byteArrayInputStream, bkVar);
                byteArrayInputStream.close();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        bkVar.f13024a.m17302f(LocationManagerProxy.NETWORK_PROVIDER);
        if (bkVar.f13024a.m17305h() == 0) {
            bkVar.f13024a.m17287a(bu.m17450a());
        }
        return bkVar.f13024a;
    }
}
