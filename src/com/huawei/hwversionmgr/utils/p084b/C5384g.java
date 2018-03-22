package com.huawei.hwversionmgr.utils.p084b;

import android.text.TextUtils;
import com.huawei.cloudservice.CloudAccount;
import com.huawei.hwappdfxmgr.upload.UploadFile;
import com.huawei.hwversionmgr.a.e;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.component.GameManager;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: BuildFileListXMLUtil */
public class C5384g {
    public static e m25894a(InputStream inputStream, e eVar) {
        if (eVar == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String str = "";
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            newPullParser.setInput(inputStream, GameManager.DEFAULT_CHARSET);
            String str2 = str;
            e eVar2 = null;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                String name = newPullParser.getName();
                newPullParser.getText();
                switch (eventType) {
                    case 2:
                        if (!"file".equalsIgnoreCase(name)) {
                            if (!"name".equalsIgnoreCase(name)) {
                                C5384g.m25896a(name, newPullParser, eVar2);
                                break;
                            }
                            str2 = newPullParser.nextText();
                            break;
                        }
                        C2538c.b("BuildFileListXMLUtil", new Object[]{"enter file!!!"});
                        eVar2 = new e();
                        eVar2.a = str2;
                        break;
                    case 3:
                        if ("file".equalsIgnoreCase(name) && eVar2 != null) {
                            arrayList.add(eVar2);
                            break;
                        }
                    default:
                        break;
                }
            }
        } catch (XmlPullParserException e) {
            C2538c.e("BuildFileListXMLUtil", new Object[]{"buildFileListXML, XmlPullParserException" + e.getMessage()});
        } catch (IOException e2) {
            C2538c.e("BuildFileListXMLUtil", new Object[]{"buildFileListXML, IOException" + e2.getMessage()});
        } catch (Exception e3) {
            C2538c.e("BuildFileListXMLUtil", new Object[]{"buildFileListXML, Exception" + e3.getMessage()});
        }
        C5384g.m25895a(eVar, arrayList);
        C2538c.c("BuildFileListXMLUtil", new Object[]{"parse filelist.xml: end newVersionInfo=" + eVar.toString()});
        return eVar;
    }

    private static void m25896a(String str, XmlPullParser xmlPullParser, e eVar) throws XmlPullParserException, IOException {
        C5384g.m25898c(str, xmlPullParser, eVar);
        C5384g.m25897b(str, xmlPullParser, eVar);
    }

    private static void m25897b(String str, XmlPullParser xmlPullParser, e eVar) throws XmlPullParserException, IOException {
        if (eVar == null) {
            return;
        }
        if (UploadFile.SIZE_LABEL.equalsIgnoreCase(str)) {
            eVar.m = Long.parseLong(xmlPullParser.nextText());
        } else if ("packageName".equalsIgnoreCase(str)) {
            eVar.k = xmlPullParser.nextText();
        } else if (CloudAccount.KEY_VERSION_NAME.equalsIgnoreCase(str)) {
            eVar.p = xmlPullParser.nextText();
        } else if ("versionCode".equalsIgnoreCase(str)) {
            eVar.n = xmlPullParser.nextText();
        }
    }

    private static void m25898c(String str, XmlPullParser xmlPullParser, e eVar) throws XmlPullParserException, IOException {
        if (eVar == null) {
            return;
        }
        if ("spath".equalsIgnoreCase(str)) {
            eVar.j = xmlPullParser.nextText();
        } else if ("dpath".equalsIgnoreCase(str)) {
            eVar.i = xmlPullParser.nextText();
        } else if ("md5".equalsIgnoreCase(str)) {
            eVar.r = xmlPullParser.nextText();
        } else if ("newmd5".equalsIgnoreCase(str)) {
            eVar.s = xmlPullParser.nextText();
        } else if ("newsize".equalsIgnoreCase(str)) {
            eVar.q = Long.parseLong(xmlPullParser.nextText());
        }
    }

    private static void m25895a(e eVar, ArrayList<e> arrayList) {
        C2538c.c("BuildFileListXMLUtil", new Object[]{"filelist.xml: list.size()=" + arrayList.size()});
        for (int i = 0; i < r3; i++) {
            e eVar2 = (e) arrayList.get(i);
            C2538c.c("BuildFileListXMLUtil", new Object[]{"filelist.xml: list i=" + i});
            if (!(eVar2 == null || TextUtils.isEmpty(eVar2.j))) {
                C2538c.c("BuildFileListXMLUtil", new Object[]{"filelist.xml: appInfo2 = " + eVar2});
                if (eVar2.j.endsWith(".apk") || eVar2.j.endsWith(".delta")) {
                    eVar.a = eVar2.a;
                    eVar.j = eVar2.j;
                    eVar.i = eVar2.i;
                    eVar.r = eVar2.r;
                    eVar.s = eVar2.s;
                    eVar.m = eVar2.m;
                    eVar.q = eVar2.q;
                    eVar.k = eVar2.k;
                    eVar.p = eVar2.p;
                    eVar.n = eVar2.n;
                    eVar.b = eVar2.b;
                    C2538c.c("BuildFileListXMLUtil", new Object[]{"filelist.xml: find apk! " + eVar.toString()});
                    return;
                }
            }
        }
    }
}
