package com.huawei.login.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.google.gson.Gson;
import com.huawei.account.aidl.AccountAidlInfo;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.login.ui.login.C1093a;
import com.huawei.p190v.C2538c;
import com.huawei.up.model.UserInfomation;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Type;

public class UserInfoReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            C2538c.m12677c("UserInfoReceiver", "no context or intent");
            return;
        }
        if ("com.huawei.bone.health.GET_USER_INFO".equals(intent.getAction())) {
            Bitmap decodeFile;
            String name = m4737a(context).getName();
            String portraitUrl = m4737a(context).getPortraitUrl();
            String c = C1093a.m4739a(context).m4750c();
            String g = C1093a.m4739a(context).m4754g();
            String f = C1093a.m4739a(context).m4753f();
            String str = "" + C1093a.m4739a(context).m4752e();
            C2538c.m12674b("UserInfoReceiver", "LoginStatusReceiver userPic = " + portraitUrl);
            C2538c.m12674b("UserInfoReceiver", "LoginStatusReceiver headLocalPic = " + m4737a(context).getPicPath());
            Bitmap bitmap = null;
            try {
                decodeFile = BitmapFactory.decodeFile(m4737a(context).getPicPath());
            } catch (OutOfMemoryError e) {
                C2538c.m12674b("UserInfoReceiver", "LoginStatusReceiver OutOfMemoryError :" + e.getMessage());
                decodeFile = bitmap;
            }
            byte[] bArr = null;
            if (decodeFile == null) {
                C2538c.m12674b("UserInfoReceiver", "LoginStatusReceiver headImage = null");
            } else {
                bArr = m4736a(decodeFile, 40000);
                C2538c.m12674b("UserInfoReceiver", "LoginStatusReceiver headImage != null");
            }
            Object accountAidlInfo = new AccountAidlInfo();
            accountAidlInfo.setUserName(name);
            accountAidlInfo.setHuid(c);
            accountAidlInfo.setServeToken(g);
            accountAidlInfo.setAccessToken(f);
            accountAidlInfo.setSitId(str);
            accountAidlInfo.setPhotoPath(portraitUrl);
            accountAidlInfo.setHeadPicByts(bArr);
            C2538c.m12674b("UserInfoReceiver", "getRemoteAccountInfo():" + accountAidlInfo.toString());
            Intent intent2 = new Intent();
            intent2.setAction("com.huawei.bone.GET_USER_INFO_RETURN");
            intent2.setPackage(context.getPackageName());
            intent2.putExtra("value", new Gson().toJson(accountAidlInfo, (Type) AccountAidlInfo.class));
            C2538c.m12674b("UserInfoReceiver", "getRemoteAccountInfo() gson:" + new Gson().toJson(accountAidlInfo, (Type) AccountAidlInfo.class));
            context.sendBroadcast(intent2, C0976c.f1642a);
        }
    }

    private static final byte[] m4736a(Bitmap bitmap, long j) {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
            int i = 90;
            C2538c.m12674b("UserInfoReceiver", "baos.toByteArray:" + byteArrayOutputStream.toByteArray().length);
            while (((long) byteArrayOutputStream.toByteArray().length) > j) {
                C2538c.m12674b("UserInfoReceiver", "baos.toByteArray2:" + byteArrayOutputStream.toByteArray().length);
                byteArrayOutputStream.reset();
                bitmap.compress(CompressFormat.JPEG, i, byteArrayOutputStream);
                i -= 10;
            }
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return toByteArray;
        } catch (IOException e) {
            return null;
        }
    }

    public UserInfomation m4737a(Context context) {
        UserInfomation userInfomation = (UserInfomation) new Gson().fromJson(C0996a.m3612a(context, String.valueOf(1004), UserInfomation.KEY_USER_INFO), UserInfomation.class);
        if (userInfomation != null) {
            C2538c.m12674b("UserInfoReceiver", " getUserInfo  userInfo=" + userInfomation);
            return userInfomation;
        }
        userInfomation = new UserInfomation();
        C2538c.m12677c("UserInfoReceiver", " getUserInfo  userInfo=null");
        return userInfomation;
    }
}
