package com.huawei.hwid.core.p435d;

import android.util.Xml;
import com.sina.weibo.sdk.component.GameManager;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: XMLPackUtil */
public class C5184o {
    public static void m25072a(XmlSerializer xmlSerializer, String str, String str2) throws IllegalArgumentException, IllegalStateException, IOException {
        if (str2 != null && xmlSerializer != null && str != null) {
            xmlSerializer.startTag(null, str).text(str2).endTag(null, str);
        }
    }

    public static XmlSerializer m25071a(OutputStream outputStream) throws IllegalArgumentException, IllegalStateException, IOException {
        XmlSerializer newSerializer = Xml.newSerializer();
        newSerializer.setOutput(outputStream, GameManager.DEFAULT_CHARSET);
        return newSerializer;
    }

    public static XmlSerializer m25073b(OutputStream outputStream) throws IllegalArgumentException, IllegalStateException, IOException {
        XmlSerializer c5175f = new C5175f();
        c5175f.setOutput(outputStream, GameManager.DEFAULT_CHARSET);
        return c5175f;
    }

    public static XmlPullParser m25070a(byte[] bArr) throws XmlPullParserException {
        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
        newPullParser.setInput(new ByteArrayInputStream(bArr), GameManager.DEFAULT_CHARSET);
        return newPullParser;
    }
}
