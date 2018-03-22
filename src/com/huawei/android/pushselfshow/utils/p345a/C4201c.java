package com.huawei.android.pushselfshow.utils.p345a;

import android.content.Context;
import android.database.Cursor;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.p337b.C4149a;
import com.huawei.android.pushselfshow.richpush.p339a.C4158b;
import com.huawei.android.pushselfshow.richpush.p340b.C4170h;
import com.huawei.android.pushselfshow.richpush.provider.C4198a;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.sina.weibo.sdk.component.GameManager;
import java.util.ArrayList;

public class C4201c {
    public static ArrayList m20402a(Context context, String str) {
        String str2;
        String[] strArr;
        Cursor cursor = null;
        ArrayList arrayList = new ArrayList();
        String str3 = "";
        if (str == null) {
            str2 = "SELECT pushmsg._id,pushmsg.msg,pushmsg.token,pushmsg.url,notify.bmp  FROM pushmsg LEFT OUTER JOIN notify ON pushmsg.url = notify.url order by pushmsg._id desc limit 1000;";
            strArr = null;
        } else {
            str2 = "SELECT pushmsg._id,pushmsg.msg,pushmsg.token,pushmsg.url,notify.bmp  FROM pushmsg LEFT OUTER JOIN notify ON pushmsg.url = notify.url and pushmsg.url = ? order by pushmsg._id desc";
            strArr = new String[]{str};
        }
        try {
            cursor = C4158b.m20304a().m20305a(context, C4198a.f15804f, str2, strArr);
        } catch (Throwable e) {
            e.c("PushSelfShowLog", e.toString(), e);
        }
        if (cursor == null) {
            e.a("PushSelfShowLog", "cursor is null.");
        } else {
            while (cursor.moveToNext()) {
                try {
                    int i = cursor.getInt(0);
                    byte[] blob = cursor.getBlob(1);
                    if (blob == null) {
                        e.d("PushSelfShowLog", "msg is null");
                    } else {
                        C4149a c4149a = new C4149a(blob, HwAccountConstants.BLANK.getBytes(GameManager.DEFAULT_CHARSET));
                        if (!c4149a.m20261b()) {
                            e.a("PushSelfShowLog", "parseMessage failed");
                        }
                        str2 = cursor.getString(3);
                        C4170h c4170h = new C4170h();
                        c4170h.m20336a(i);
                        c4170h.m20338a(str2);
                        c4170h.m20337a(c4149a);
                        arrayList.add(c4170h);
                    }
                } catch (Throwable e2) {
                    e.c("TAG", "query favo error " + e2.toString(), e2);
                } finally {
                    cursor.close();
                }
            }
            e.e("PushSelfShowLog", "query favo size is " + arrayList.size());
        }
        return arrayList;
    }
}
