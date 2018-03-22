package com.huawei.hwservicesmgr.p076a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.media.ThumbnailUtils;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.datatypes.C4737b;
import com.huawei.hwcommonmodel.datatypes.C4739d;
import com.huawei.hwcommonmodel.datatypes.C4741g;
import com.huawei.hwcommonmodel.datatypes.C4751r;
import com.huawei.hwcommonmodel.datatypes.DataPromptData;
import com.huawei.hwcommonmodel.datatypes.MsgImage;
import com.huawei.hwcommonmodel.datatypes.MsgText;
import com.huawei.hwcommonmodel.datatypes.f;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: NotifySendUtil */
public class C5348g {
    private static boolean f19088a = false;
    private static boolean f19089b = false;
    private static int f19090c = 30;
    private static int f19091d = 30;
    private static int f19092e = 240;

    public static Bitmap m25807a(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[(width * height)];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        for (int i3 = 0; i3 < height; i3++) {
            for (int i4 = 0; i4 < width; i4++) {
                int i5 = iArr[(width * i3) + i4];
                i5 = (int) (((((double) ((MotionEventCompat.ACTION_POINTER_INDEX_MASK & i5) >> 8)) * 0.59d) + (((double) ((16711680 & i5) >> 16)) * 0.3d)) + (((double) (i5 & 255)) * 0.11d));
                iArr[(width * i3) + i4] = i5 | (((i5 << 16) | ViewCompat.MEASURED_STATE_MASK) | (i5 << 8));
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Config.RGB_565);
        createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return ThumbnailUtils.extractThumbnail(createBitmap, i, i2);
    }

    public static C4739d m25808a(int i, boolean z, List<MsgImage> list, List<MsgText> list2, int i2, int i3) {
        C2538c.c("NotifySendUtil", new Object[]{"getDataPromptContent, mYellowPagesFomat :" + i2 + "mContentSignFomat:" + i3});
        C4739d c4739d = new C4739d();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        c4739d.m22673b(i);
        if (z) {
            c4739d.m22670a(1);
        } else {
            c4739d.m22670a(0);
        }
        C4751r c4751r = new C4751r();
        byte[] bArr = null;
        if (list != null && list.size() > 0) {
            for (MsgImage msgImage : list) {
                C4737b c4737b = new C4737b();
                if (msgImage != null) {
                    Bitmap imageBitmap = msgImage.getImageBitmap();
                    if (imageBitmap != null) {
                        bArr = c4751r.m22731a(C5348g.m25807a(imageBitmap, 33, 24));
                    }
                    c4737b.m22656b(msgImage.getImageType());
                    c4737b.m22655a(bArr);
                    c4737b.m22656b(msgImage.getImageType());
                    c4737b.m22658d(1);
                    c4737b.m22657c(33);
                    c4737b.m22654a(24);
                    arrayList.add(c4737b);
                }
            }
        }
        if (list2 != null && list2.size() > 0) {
            for (MsgText msgText : list2) {
                if (msgText != null) {
                    C4741g c4741g = new C4741g();
                    c4741g.m22679a(msgText.getTextType());
                    if (msgText.getTextType() == 5) {
                        c4741g.m22682b(i2);
                    } else if (msgText.getTextType() == 6) {
                        c4741g.m22682b(i3);
                    } else {
                        c4741g.m22682b(2);
                    }
                    c4741g.m22680a(msgText.getTextContent());
                    arrayList2.add(c4741g);
                }
            }
        }
        c4739d.m22674b(arrayList);
        c4739d.m22671a(arrayList2);
        return c4739d;
    }

    public static String m25813a(StringBuilder stringBuilder, String str, String str2, String str3, ArrayList<C4741g> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C4741g c4741g = (C4741g) it.next();
                int a = c4741g.m22678a();
                C2538c.c("NotifySendUtil", new Object[]{"notificationMsgToTLVS, textType = " + a});
                if ((a != 5 || f19088a) && (a != 6 || f19089b)) {
                    String str4 = a.a(14) + a.a(1) + a.a(c4741g.m22678a());
                    int b = c4741g.m22681b();
                    String str5 = a.a(15) + a.a(1) + a.a(b);
                    String str6 = "...";
                    if (c4741g.m22683c() != null) {
                        if (2 == b) {
                            str3 = a.e(c4741g.m22683c());
                            str6 = a.e(str6);
                        } else if (1 == b) {
                            str3 = a.a(c4741g.m22683c());
                            str6 = a.a(str6);
                        } else if (3 == b) {
                            str3 = a.e(c4741g.m22683c());
                            str6 = a.e(str6);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            C2538c.c("NotifySendUtil", new Object[]{"notificationMsgToTLVS, text_contentL = " + (str3.length() / 2) + ", mContentLength = " + f19092e});
                            int a2 = C5348g.m25806a(c4741g);
                            if (str3.length() / 2 > a2) {
                                str3 = str3.substring(0, (a2 - 6) * 2) + str6;
                                C2538c.c("NotifySendUtil", new Object[]{"notificationMsgToTLVS, text_contentHex---------" + str3});
                            }
                            str = a.a(16) + C5348g.m25809a(str3.length() / 2) + str3;
                        }
                    }
                    stringBuilder.append(a.a(141) + C5348g.m25809a((str4 + str5 + str).length() / 2)).append(str4).append(str5).append(str);
                }
            }
            if (stringBuilder.length() != 0) {
                str2 = C0973a.a(140) + C5348g.m25809a(stringBuilder.length() / 2);
            }
        }
        C2538c.c("NotifySendUtil", new Object[]{"notificationMsgToTLVS, text_listTlHex---------" + str2});
        return str2;
    }

    private static int m25806a(C4741g c4741g) {
        if (c4741g.m22678a() == 5) {
            return f19090c;
        }
        if (c4741g.m22678a() == 6) {
            return f19091d;
        }
        return f19092e;
    }

    private static String m25809a(int i) {
        if (i <= 127) {
            return C0973a.a(i);
        }
        return C0973a.a((i >> 7) + 128) + C0973a.a(i & 127);
    }

    public static void m25814a(boolean z, boolean z2, int i, int i2, int i3) {
        f19088a = z;
        f19089b = z2;
        f19092e = i;
        f19090c = i2;
        f19091d = i3;
    }

    public static String m25810a(int i, String str, String str2, String str3) {
        if (str != null) {
            if (2 == i) {
                str3 = C0973a.e(str);
            } else if (1 == i) {
                str3 = C0973a.a(str);
            }
            if (str3.equals("")) {
                str2 = C0973a.a(0);
            } else {
                str2 = C0973a.a(str3.length() / 2);
            }
        }
        return C0973a.a(16) + str2 + str3;
    }

    public static String m25811a(f fVar, DataPromptData dataPromptData) {
        String str;
        String str2;
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        if (fVar.f()) {
            str3 = "";
            str = "";
            str = "";
            if (fVar.g()) {
                str4 = C0973a.a(15) + C0973a.a(1) + C0973a.a(dataPromptData.getText_format());
                if (fVar.h()) {
                    str5 = C5348g.m25810a(dataPromptData.getText_format(), dataPromptData.getText_content(), str3, str);
                }
            }
            str3 = C0973a.a(141) + C5348g.m25809a((str4 + str5).length() / 2);
            str6 = C0973a.a(140) + C5348g.m25809a(((str4 + str5).length() / 2) + 2);
            str2 = str5;
            str = str4;
        } else {
            str2 = str5;
            str = str4;
        }
        return C5348g.m25812a(fVar, dataPromptData, str3, str, str2, str6);
    }

    public static String m25812a(f fVar, DataPromptData dataPromptData, String str, String str2, String str3, String str4) {
        String str5 = "";
        String str6 = "";
        String str7 = "";
        String str8 = "";
        String str9 = "";
        String str10;
        if (fVar.a()) {
            if (fVar.e()) {
                if (fVar.b()) {
                    str6 = C0973a.a(8) + C0973a.a(2) + C0973a.b(dataPromptData.getDot_metrix_height());
                }
                if (fVar.c()) {
                    str7 = C0973a.a(9) + C0973a.a(2) + C0973a.b(dataPromptData.getDot_metrix_width());
                }
                if (fVar.d()) {
                    str8 = C0973a.a(10) + C0973a.a(1) + C0973a.a(dataPromptData.getDot_metrix_color());
                }
                if (fVar.e() && dataPromptData.getDot_metrix_data() != null) {
                    str9 = C0973a.a(dataPromptData.getDot_metrix_data());
                    str10 = C0973a.a(11) + C5348g.m25809a(str9.length() / 2) + str9;
                    str9 = str6;
                    str6 = str10;
                    str5 = C0973a.a(134) + C5348g.m25809a((str9 + str7 + str8 + str6).length() / 2);
                }
            }
            str10 = str9;
            str9 = str6;
            str6 = str10;
            str5 = C0973a.a(134) + C5348g.m25809a((str9 + str7 + str8 + str6).length() / 2);
        } else {
            str10 = str9;
            str9 = str6;
            str6 = str10;
        }
        String str11 = C0973a.a(132) + C5348g.m25809a((str5 + str4 + str + str2 + str3 + str9 + str7 + str8 + str6).length() / 2);
        String str12 = C0973a.a(2) + C0973a.a(1) + C0973a.a(dataPromptData.getPrompt_type());
        C2538c.c("NotifySendUtil", new Object[]{"promptMsgToTLVS sCmd---------------" + (str12 + (C0973a.a(3) + C0973a.a(1) + C0973a.a(dataPromptData.getMotor_enable())) + str11 + str5 + str9 + str7 + str8 + str6 + str4 + str + str2 + str3)});
        return str12 + (C0973a.a(3) + C0973a.a(1) + C0973a.a(dataPromptData.getMotor_enable())) + str11 + str5 + str9 + str7 + str8 + str6 + str4 + str + str2 + str3;
    }
}
