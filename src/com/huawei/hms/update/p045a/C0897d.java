package com.huawei.hms.update.p045a;

import com.huawei.cloudservice.CloudAccount;
import com.huawei.hms.p039c.C0854c;
import com.huawei.hms.support.log.C0887a;
import com.huawei.hwappdfxmgr.upload.UploadFile;
import com.sina.weibo.sdk.component.GameManager;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: FilelistResponse */
class C0897d {
    private String f1460a = "";
    private String f1461b = "";
    private String f1462c = "";
    private String f1463d = "";
    private String f1464e = "";
    private String f1465f = "";
    private String f1466g = "";
    private int f1467h = 0;

    C0897d() {
    }

    public String m3138a() {
        return this.f1461b;
    }

    public int m3139b() {
        try {
            return Integer.parseInt(this.f1462c);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public String m3140c() {
        return this.f1463d;
    }

    public int m3141d() {
        return this.f1467h;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');
        stringBuilder.append("Name: ").append(this.f1460a).append(", ");
        stringBuilder.append("File: ").append(this.f1461b).append(", ");
        stringBuilder.append("Size: ").append(this.f1462c).append(", ");
        stringBuilder.append("Hash: ").append(this.f1463d).append(", ");
        stringBuilder.append("PackageName: ").append(this.f1464e).append(", ");
        stringBuilder.append("PackageType: ").append(this.f1465f).append(", ");
        stringBuilder.append("VersionName: ").append(this.f1466g).append(", ");
        stringBuilder.append("VersionCode: ").append(this.f1467h);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public static C0897d m3135a(String str) {
        Exception e;
        C0897d c0897d = new C0897d();
        InputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes(Charset.defaultCharset()));
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            newPullParser.setInput(byteArrayInputStream, GameManager.DEFAULT_CHARSET);
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2) {
                    C0897d.m3136a(c0897d, newPullParser);
                }
            }
            C0854c.m3009a(byteArrayInputStream);
        } catch (XmlPullParserException e2) {
            e = e2;
            try {
                C0887a.m3098d("FilelistResponse", "In parseResponse, Failed to parse xml for get-filelist response." + e.getMessage());
                c0897d = new C0897d();
                return c0897d;
            } finally {
                C0854c.m3009a(byteArrayInputStream);
            }
        } catch (IOException e3) {
            e = e3;
            C0887a.m3098d("FilelistResponse", "In parseResponse, Failed to parse xml for get-filelist response." + e.getMessage());
            c0897d = new C0897d();
            return c0897d;
        }
        return c0897d;
    }

    private static void m3136a(C0897d c0897d, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (xmlPullParser.getDepth() == 3 && "name".equals(name)) {
            c0897d.f1460a = xmlPullParser.nextText();
        }
        if (xmlPullParser.getDepth() != 4) {
            return;
        }
        if ("spath".equals(name)) {
            c0897d.f1461b = xmlPullParser.nextText();
        } else if (UploadFile.SIZE_LABEL.equals(name)) {
            c0897d.f1462c = xmlPullParser.nextText();
        } else if ("sha256".equals(name)) {
            c0897d.f1463d = xmlPullParser.nextText();
        } else if ("packageName".equals(name)) {
            c0897d.f1464e = xmlPullParser.nextText();
        } else if ("packageType".equals(name)) {
            c0897d.f1465f = xmlPullParser.nextText();
        } else if (CloudAccount.KEY_VERSION_NAME.equals(name)) {
            c0897d.f1466g = xmlPullParser.nextText();
        } else if ("versionCode".equals(name)) {
            c0897d.f1467h = C0897d.m3137b(xmlPullParser.nextText());
        }
    }

    private static int m3137b(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
