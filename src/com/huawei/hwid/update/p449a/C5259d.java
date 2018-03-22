package com.huawei.hwid.update.p449a;

import com.huawei.cloudservice.CloudAccount;
import com.huawei.hwappdfxmgr.upload.UploadFile;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.hwid.p075d.C5207c;
import com.sina.weibo.sdk.component.GameManager;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: FilelistResponse */
class C5259d {
    private String f18914a = "";
    private String f18915b = "";
    private String f18916c = "";
    private String f18917d = "";
    private String f18918e = "";
    private String f18919f = "";
    private String f18920g = "";
    private int f18921h = 0;

    C5259d() {
    }

    public String m25492a() {
        return this.f18915b;
    }

    public int m25493b() {
        try {
            return Integer.parseInt(this.f18916c);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public String m25494c() {
        return this.f18917d;
    }

    public int m25495d() {
        return this.f18921h;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');
        stringBuilder.append("Name: ").append(this.f18914a).append(", ");
        stringBuilder.append("File: ").append(this.f18915b).append(", ");
        stringBuilder.append("Size: ").append(this.f18916c).append(", ");
        stringBuilder.append("Hash: ").append(this.f18917d).append(", ");
        stringBuilder.append("PackageName: ").append(this.f18918e).append(", ");
        stringBuilder.append("PackageType: ").append(this.f18919f).append(", ");
        stringBuilder.append("VersionName: ").append(this.f18920g).append(", ");
        stringBuilder.append("VersionCode: ").append(this.f18921h);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public static C5259d m25489a(String str) {
        Exception e;
        C5259d c5259d = new C5259d();
        InputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes(Charset.defaultCharset()));
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            newPullParser.setInput(byteArrayInputStream, GameManager.DEFAULT_CHARSET);
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2) {
                    C5259d.m25490a(c5259d, newPullParser);
                }
            }
            C5207c.m25333a(byteArrayInputStream);
        } catch (XmlPullParserException e2) {
            e = e2;
            try {
                C5165e.m24910d("FilelistResponse", "In parseResponse, Failed to parse xml for get-filelist response." + e.getMessage());
                c5259d = new C5259d();
                return c5259d;
            } finally {
                C5207c.m25333a(byteArrayInputStream);
            }
        } catch (IOException e3) {
            e = e3;
            C5165e.m24910d("FilelistResponse", "In parseResponse, Failed to parse xml for get-filelist response." + e.getMessage());
            c5259d = new C5259d();
            return c5259d;
        }
        return c5259d;
    }

    private static void m25490a(C5259d c5259d, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (xmlPullParser.getDepth() == 3 && "name".equals(name)) {
            c5259d.f18914a = xmlPullParser.nextText();
        }
        if (xmlPullParser.getDepth() != 4) {
            return;
        }
        if ("spath".equals(name)) {
            c5259d.f18915b = xmlPullParser.nextText();
        } else if (UploadFile.SIZE_LABEL.equals(name)) {
            c5259d.f18916c = xmlPullParser.nextText();
        } else if ("sha256".equals(name)) {
            c5259d.f18917d = xmlPullParser.nextText();
        } else if ("packageName".equals(name)) {
            c5259d.f18918e = xmlPullParser.nextText();
        } else if ("packageType".equals(name)) {
            c5259d.f18919f = xmlPullParser.nextText();
        } else if (CloudAccount.KEY_VERSION_NAME.equals(name)) {
            c5259d.f18920g = xmlPullParser.nextText();
        } else if ("versionCode".equals(name)) {
            c5259d.f18921h = C5259d.m25491b(xmlPullParser.nextText());
        }
    }

    private static int m25491b(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
