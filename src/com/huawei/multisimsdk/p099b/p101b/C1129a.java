package com.huawei.multisimsdk.p099b.p101b;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;
import com.huawei.multisimsdk.p099b.p100a.C1128a;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: CarrierConfigResolveXml */
public class C1129a {
    private static TelephonyManager f2389a = null;

    public static String m5031a(Context context) {
        if (context != null) {
            if (f2389a == null) {
                f2389a = (TelephonyManager) context.getSystemService("phone");
            }
            if (5 == f2389a.getSimState()) {
                C1183h.m5282b("CarrierConfigResolveXml", "SimState is ready.");
                return f2389a.getSimOperator();
            }
        }
        return null;
    }

    public static C1128a m5029a(Context context, String str) {
        C1128a c1128a = null;
        if (context == null) {
            C1183h.m5282b("CarrierConfigResolveXml", "context is null");
        } else {
            if (str == null) {
                str = C1129a.m5031a(context);
            }
            if (C1183h.f2599a.booleanValue()) {
                C1183h.m5282b("CarrierConfigResolveXml", "CarrierConfigInfo resolveXML simoperator:" + str);
            }
            if (TextUtils.isEmpty(str)) {
                C1183h.m5286d("CarrierConfigResolveXml", "the simOperator is error , card is missing or the context is null...");
            } else {
                try {
                    XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                    StringBuffer append = new StringBuffer("carrier_config_").append(str).append(".xml");
                    if (newPullParser != null) {
                        newPullParser.setInput(context.getAssets().open(append.toString()), "utf-8");
                    }
                    c1128a = C1129a.m5030a(newPullParser);
                } catch (IOException e) {
                    C1183h.m5282b("CarrierConfigResolveXml", "resolveXML exception, it maybe the card is not support multisim");
                    return c1128a;
                } catch (XmlPullParserException e2) {
                    C1183h.m5282b("CarrierConfigResolveXml", "resolveXML exception, it maybe the card is not support multisim");
                    return c1128a;
                }
            }
        }
        return c1128a;
    }

    private static C1128a m5030a(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        if (xmlPullParser != null) {
            C1128a c1128a = new C1128a();
            int eventType = xmlPullParser.getEventType();
            while (eventType != 1) {
                switch (eventType) {
                    case 2:
                        if (!"carrier_config".equals(xmlPullParser.getName())) {
                            if (!"BindDevicesAndCardState".equals(xmlPullParser.getName())) {
                                if (!"SignTimes".equals(xmlPullParser.getName())) {
                                    if (!"CDMURL".equals(xmlPullParser.getName())) {
                                        if (!"DeleteProfile".equals(xmlPullParser.getName())) {
                                            if (!"AuthenType".equals(xmlPullParser.getName())) {
                                                break;
                                            }
                                            c1128a.m5025b(xmlPullParser.nextText());
                                            break;
                                        }
                                        c1128a.m5028e(xmlPullParser.nextText());
                                        break;
                                    }
                                    c1128a.m5024a(xmlPullParser.nextText());
                                    break;
                                }
                                c1128a.m5026c(xmlPullParser.nextText());
                                break;
                            }
                            c1128a.m5027d(xmlPullParser.nextText());
                            break;
                        }
                        break;
                    default:
                        break;
                }
                eventType = xmlPullParser.next();
            }
            return c1128a;
        }
        C1183h.m5286d("CarrierConfigResolveXml", "parser or configmessage is null");
        return null;
    }
}
