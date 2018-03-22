package com.huawei.up.p520e;

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
public class C6135i {
    public static void m27928a(XmlSerializer xmlSerializer, String str, String str2) throws IllegalArgumentException, IllegalStateException, IOException {
        if (str2 != null && xmlSerializer != null && str != null) {
            xmlSerializer.startTag(null, str).text(str2).endTag(null, str);
        }
    }

    public static XmlSerializer m27927a(OutputStream outputStream) throws IllegalArgumentException, IllegalStateException, IOException {
        XmlSerializer newSerializer = Xml.newSerializer();
        newSerializer.setOutput(outputStream, GameManager.DEFAULT_CHARSET);
        return newSerializer;
    }

    public static XmlPullParser m27926a(byte[] bArr) throws XmlPullParserException {
        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
        newPullParser.setInput(new ByteArrayInputStream(bArr), GameManager.DEFAULT_CHARSET);
        return newPullParser;
    }
}
