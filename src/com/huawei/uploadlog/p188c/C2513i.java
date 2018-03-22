package com.huawei.uploadlog.p188c;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ScrollView;
import com.huawei.androidcommon.utils.BitmapUtils;
import com.huawei.androidcommon.utils.FileUtils;
import com.huawei.androidcommon.utils.StringUtils;
import com.huawei.crowdtestsdk.common.AppContext;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.crowdtestsdk.devices.CommonDevice;
import com.huawei.crowdtestsdk.devices.DeviceHelper;
import com.huawei.crowdtestsdk.receiver.LogSendResultReceiver;
import com.huawei.crowdtestsdk.utils.ResUtil;
import com.huawei.hwappdfxmgr.upload.UploadFile;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Calendar;
import org.apache.log4j.helpers.DateLayout;
import org.apache.log4j.spi.LocationInfo;

/* compiled from: OtherUtils */
public class C2513i {
    public static boolean m12498a(android.widget.ScrollView r5, java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = 0;
        if (r5 == 0) goto L_0x0009;
    L_0x0003:
        r1 = com.huawei.androidcommon.utils.StringUtils.isNullOrEmpty(r6);
        if (r1 == 0) goto L_0x000a;
    L_0x0009:
        return r0;
    L_0x000a:
        r2 = 0;
        r2 = com.huawei.uploadlog.p188c.C2513i.m12491a(r5);	 Catch:{ IOException -> 0x0061, all -> 0x0075 }
        if (r2 != 0) goto L_0x001d;
    L_0x0011:
        if (r2 == 0) goto L_0x0009;
    L_0x0013:
        r1 = r2.isRecycled();
        if (r1 != 0) goto L_0x0009;
    L_0x0019:
        r2.recycle();
        goto L_0x0009;
    L_0x001d:
        r1 = new java.io.File;	 Catch:{ IOException -> 0x0061, all -> 0x0075 }
        r3 = r6.trim();	 Catch:{ IOException -> 0x0061, all -> 0x0075 }
        r1.<init>(r3);	 Catch:{ IOException -> 0x0061, all -> 0x0075 }
        r3 = r1.exists();	 Catch:{ IOException -> 0x0061, all -> 0x0075 }
        if (r3 != 0) goto L_0x0039;	 Catch:{ IOException -> 0x0061, all -> 0x0075 }
    L_0x002c:
        r3 = r1.createNewFile();	 Catch:{ IOException -> 0x0061, all -> 0x0075 }
        if (r3 == 0) goto L_0x0059;	 Catch:{ IOException -> 0x0061, all -> 0x0075 }
    L_0x0032:
        r3 = "BETACLUB_SDK";	 Catch:{ IOException -> 0x0061, all -> 0x0075 }
        r4 = "[OtherUtils.saveScrollViewToImage] file log delete succeed!";	 Catch:{ IOException -> 0x0061, all -> 0x0075 }
        com.huawei.uploadlog.p188c.C2511g.m12481b(r3, r4);	 Catch:{ IOException -> 0x0061, all -> 0x0075 }
    L_0x0039:
        r3 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x0061, all -> 0x0075 }
        r3.<init>(r1);	 Catch:{ IOException -> 0x0061, all -> 0x0075 }
        r1 = android.graphics.Bitmap.CompressFormat.JPEG;	 Catch:{ IOException -> 0x0061, all -> 0x0075 }
        r4 = 50;	 Catch:{ IOException -> 0x0061, all -> 0x0075 }
        r1 = r2.compress(r1, r4, r3);	 Catch:{ IOException -> 0x0061, all -> 0x0075 }
        r3.flush();	 Catch:{ IOException -> 0x0061, all -> 0x0075 }
        r3.close();	 Catch:{ IOException -> 0x0061, all -> 0x0075 }
        if (r2 == 0) goto L_0x0057;
    L_0x004e:
        r0 = r2.isRecycled();
        if (r0 != 0) goto L_0x0057;
    L_0x0054:
        r2.recycle();
    L_0x0057:
        r0 = r1;
        goto L_0x0009;
    L_0x0059:
        r3 = "BETACLUB_SDK";	 Catch:{ IOException -> 0x0061, all -> 0x0075 }
        r4 = "[OtherUtils.saveScrollViewToImage] file log delete filed!";	 Catch:{ IOException -> 0x0061, all -> 0x0075 }
        com.huawei.uploadlog.p188c.C2511g.m12481b(r3, r4);	 Catch:{ IOException -> 0x0061, all -> 0x0075 }
        goto L_0x0039;
    L_0x0061:
        r1 = move-exception;
        r3 = "BETACLUB_SDK";	 Catch:{ IOException -> 0x0061, all -> 0x0075 }
        r4 = "[OtherUtils.saveScrollViewToImage]Exception:";	 Catch:{ IOException -> 0x0061, all -> 0x0075 }
        com.huawei.uploadlog.p188c.C2511g.m12482b(r3, r4, r1);	 Catch:{ IOException -> 0x0061, all -> 0x0075 }
        if (r2 == 0) goto L_0x0009;
    L_0x006b:
        r1 = r2.isRecycled();
        if (r1 != 0) goto L_0x0009;
    L_0x0071:
        r2.recycle();
        goto L_0x0009;
    L_0x0075:
        r0 = move-exception;
        if (r2 == 0) goto L_0x0081;
    L_0x0078:
        r1 = r2.isRecycled();
        if (r1 != 0) goto L_0x0081;
    L_0x007e:
        r2.recycle();
    L_0x0081:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uploadlog.c.i.a(android.widget.ScrollView, java.lang.String):boolean");
    }

    public static void m12496a(Context context, String str, long j, long j2, int i, int i2, int i3) {
        C2513i.m12501b(context, str, j, j2, i, i2, i3);
    }

    public static void m12501b(Context context, String str, long j, long j2, int i, int i2, int i3) {
        try {
            C2511g.m12477a("BETACLUB_SDK", "[OtherUtils.sendLogImpWithChannelID]Start send log");
            C2511g.m12477a("BETACLUB_SDK", "[OtherUtils.sendLogImpWithChannelID]Path:" + str);
            C2511g.m12477a("BETACLUB_SDK", "[OtherUtils.sendLogImpWithChannelID]logId:" + j);
            C2511g.m12477a("BETACLUB_SDK", "[OtherUtils.sendLogImpWithChannelID]Size:" + j2);
            C2511g.m12477a("BETACLUB_SDK", "[OtherUtils.sendLogImpWithChannelID]netType:" + i);
            C2511g.m12477a("BETACLUB_SDK", "[OtherUtils.sendLogImpWithChannelID]userType:" + i2);
            if (!StringUtils.isNullOrEmpty(context.getPackageName())) {
                C2511g.m12481b("BETACLUB_SDK", "[OtherUtils.sendLogImpWithChannelID]packageName:" + context.getPackageName());
            }
            Intent intent = new Intent(SdkConstants.ACTION_UPLOAD_REQUEST_INTENT);
            intent.setPackage(context.getPackageName());
            intent.putExtra("alert_visible", false);
            intent.putExtra("filepath", str);
            intent.putExtra("id", j);
            intent.putExtra(UploadFile.SIZE_LABEL, j2);
            intent.putExtra("encrypt", true);
            intent.putExtra("privacy", false);
            intent.putExtra("flags", i);
            intent.putExtra(UploadFile.SYS_ID_CHANNEL, i3);
            intent.putExtra("usertype", i2);
            intent.putExtra("feedBackPackageName", context.getPackageName());
            intent.putExtra("feedBackClassName", LogSendResultReceiver.class.getName());
            context.startService(intent);
            C2511g.m12481b("BETACLUB_SDK", "[OtherUtils.sendLogImpWithChannelID]Start LogUploadService");
        } catch (Exception e) {
            C2511g.m12483c("BETACLUB_SDK", "[OtherUtils.sendLogImpWithChannelID]Start send log exception:" + e.toString());
        }
    }

    public static Bitmap m12490a(Context context, String str, int i) {
        if (FileUtils.isImageFormatByFileName(str)) {
            return BitmapUtils.getImageThumbnail(str, i, i);
        }
        if (FileUtils.isAudioFormatByFileName(str)) {
            return ((BitmapDrawable) context.getResources().getDrawable(ResUtil.getResId(context, "sdk_crowdtest_audio_icon", ResUtil.TYPE_DRAWABLE))).getBitmap();
        }
        if (FileUtils.isVideoFormatByFileName(str)) {
            return ((BitmapDrawable) context.getResources().getDrawable(ResUtil.getResId(context, "sdk_crowdtest_video_icon", ResUtil.TYPE_DRAWABLE))).getBitmap();
        }
        if (FileUtils.isCompressedFormatByFileName(str)) {
            return ((BitmapDrawable) context.getResources().getDrawable(ResUtil.getResId(context, "sdk_crowdtest_zip_icon", ResUtil.TYPE_DRAWABLE))).getBitmap();
        }
        return ((BitmapDrawable) context.getResources().getDrawable(ResUtil.getResId(context, "sdk_crowdtest_attachment_icon", ResUtil.TYPE_DRAWABLE))).getBitmap();
    }

    public static boolean m12499a(String str) {
        return str == null ? false : str.endsWith(".mp4");
    }

    public static boolean m12502b(String str) {
        return str == null ? false : str.endsWith(".mp3");
    }

    public static boolean m12503c(String str) {
        return str == null ? false : str.endsWith(LightCloudConstants.ZIP_POSTFIX);
    }

    public static boolean m12497a(Context context, Intent intent) {
        if (context.getPackageManager().queryIntentActivities(intent, 0).size() > 0) {
            return true;
        }
        return false;
    }

    public static void m12495a(Context context, int i, OnClickListener onClickListener) {
        new Builder(context).setMessage(i).setPositiveButton(ResUtil.getResId(context, "sdk_crowdtest_text_ok", ResUtil.TYPE_STRING), onClickListener).setNegativeButton(ResUtil.getResId(context, "sdk_crowdtest_text_cancel", ResUtil.TYPE_STRING), null).show();
    }

    public static Bitmap m12491a(ScrollView scrollView) {
        int i = 0;
        int i2 = 0;
        while (i < scrollView.getChildCount()) {
            i2 += scrollView.getChildAt(i).getHeight();
            scrollView.getChildAt(i).setBackgroundColor(Color.parseColor("#FFFFFF"));
            i++;
        }
        Bitmap createBitmap = Bitmap.createBitmap(scrollView.getWidth(), i2, Config.RGB_565);
        scrollView.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public static String m12493a(int i, String str, CommonDevice commonDevice) {
        String str2 = HwAccountConstants.SPLIIT_UNDERLINE;
        String str3 = "QUES";
        Calendar instance = Calendar.getInstance();
        String format = String.format("%04d%02d%02d%02d%02d%02d", new Object[]{Integer.valueOf(instance.get(1)), Integer.valueOf(instance.get(2) + 1), Integer.valueOf(instance.get(5)), Integer.valueOf(instance.get(11)), Integer.valueOf(instance.get(12)), Integer.valueOf(instance.get(13))});
        StringBuilder stringBuilder = new StringBuilder();
        String a = C2513i.m12494a(commonDevice);
        String productName = commonDevice.getProductName() != null ? commonDevice.getProductName() : "crowdtest";
        String versionName = commonDevice.getVersionName() != null ? commonDevice.getVersionName() : "unknown";
        String deviceId = commonDevice.getDeviceId() != null ? commonDevice.getDeviceId() : "deviceId";
        if (i == 0) {
            stringBuilder.append(productName).append(str2).append(versionName).append(str2).append(str3).append(str).append(str2).append(a);
            stringBuilder.append(str2).append("log.zip");
        } else if (i == 1) {
            stringBuilder.append(productName).append(str2).append(C2513i.m12504d(versionName)).append(str2).append(str3).append(str).append(str2).append(a);
            stringBuilder.append(str2).append("Manual.zip");
        } else if (i == 3) {
            stringBuilder.append(productName).append(str2).append(C2513i.m12504d(versionName)).append(str2).append("USERDATA").append(str2).append(deviceId).append(str2).append(format).append(str2).append("BetaUXR.zip");
        } else if (i == 2) {
            stringBuilder.append(productName).append(str2).append(C2513i.m12504d(versionName)).append(str2).append("AUTOLOG").append(str2).append(deviceId).append(str2).append(format).append(str2).append("Auto.zip");
        } else if (i == 4) {
            stringBuilder.append(productName).append(str2).append(C2513i.m12504d(versionName)).append(str2).append(deviceId).append(str2).append(format).append(str2).append("WearableBeta.zip");
        }
        productName = stringBuilder.toString().trim();
        C2511g.m12481b("BETACLUB_SDK", "[OtherUtils.getName()]fileName result：" + productName);
        C2511g.m12481b("BETACLUB_SDK", "[OtherUtils.getName()]fileName result：" + C2513i.m12505e(productName));
        return C2513i.m12505e(productName);
    }

    private static String m12504d(String str) {
        if (StringUtils.isNullOrEmpty(str)) {
            return DateLayout.NULL_DATE_FORMAT;
        }
        String str2 = "-";
        String trim = str.trim();
        while (trim.contains("  ")) {
            trim = trim.replaceAll("  ", HwAccountConstants.BLANK);
        }
        if (trim.contains(HwAccountConstants.BLANK)) {
            trim = trim.replaceAll(HwAccountConstants.BLANK, str2);
        }
        if (trim.contains(HwAccountConstants.SPLIIT_UNDERLINE)) {
            return trim.replaceAll(HwAccountConstants.SPLIIT_UNDERLINE, str2);
        }
        return trim;
    }

    private static String m12505e(String str) {
        for (String str2 : Arrays.asList(new String[]{"*", "/", "\\", ":", "\"", LocationInfo.NA, "<", ">", "|"})) {
            if (str.contains(str2)) {
                C2511g.m12481b("BETACLUB_SDK", "Log name contains special char : " + str2);
                str = str.replaceAll(str2, "");
            }
        }
        return str;
    }

    private static String m12494a(CommonDevice commonDevice) {
        String str = "";
        int indexOf = str.indexOf(86);
        if (indexOf != -1) {
            str = str.substring(0, indexOf) + HwAccountConstants.SPLIIT_UNDERLINE + str.substring(indexOf);
        }
        String b = C2514j.m12520b(AppContext.getInstance().getApplicationContext());
        if (StringUtils.isNullOrEmpty(b)) {
            b = "unknown";
        }
        str = (str + b) + HwAccountConstants.SPLIIT_UNDERLINE;
        Calendar instance = Calendar.getInstance();
        return (str + String.format("%04d%02d%02d%02d%02d%02d", new Object[]{Integer.valueOf(instance.get(1)), Integer.valueOf(instance.get(2) + 1), Integer.valueOf(instance.get(5)), Integer.valueOf(instance.get(11)), Integer.valueOf(instance.get(12)), Integer.valueOf(instance.get(13))})).trim();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.huawei.crowdtestsdk.devices.DeviceHelper m12492a(byte[] r7) {
        /*
        r0 = new com.huawei.crowdtestsdk.devices.UnknownDevice;
        r0.<init>();
        r1 = r0.getDeviceHelper();
        if (r7 != 0) goto L_0x0014;
    L_0x000b:
        r0 = "BETACLUB_SDK";
        r2 = "[OtherUtils.getDeviceHelperFromData]data is null";
        com.huawei.uploadlog.p188c.C2511g.m12483c(r0, r2);
        r0 = r1;
    L_0x0013:
        return r0;
    L_0x0014:
        r2 = new java.io.ByteArrayInputStream;
        r2.<init>(r7);
        r3 = new java.io.ObjectInputStream;	 Catch:{ RuntimeException -> 0x0043, Exception -> 0x0045 }
        r3.<init>(r2);	 Catch:{ RuntimeException -> 0x0043, Exception -> 0x0045 }
        r0 = r3.readObject();	 Catch:{ RuntimeException -> 0x0043, Exception -> 0x0045 }
        r0 = (com.huawei.crowdtestsdk.devices.DeviceHelper) r0;	 Catch:{ RuntimeException -> 0x0043, Exception -> 0x0045 }
        r1 = "BETACLUB_SDK";
        r4 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x0043, Exception -> 0x0051 }
        r4.<init>();	 Catch:{ RuntimeException -> 0x0043, Exception -> 0x0051 }
        r5 = "OtherUtils.getDeviceHelperFromData deviceHelper : ";
        r4 = r4.append(r5);	 Catch:{ RuntimeException -> 0x0043, Exception -> 0x0051 }
        r4 = r4.append(r0);	 Catch:{ RuntimeException -> 0x0043, Exception -> 0x0051 }
        r4 = r4.toString();	 Catch:{ RuntimeException -> 0x0043, Exception -> 0x0051 }
        com.huawei.uploadlog.p188c.C2511g.m12481b(r1, r4);	 Catch:{ RuntimeException -> 0x0043, Exception -> 0x0051 }
        r3.close();	 Catch:{ RuntimeException -> 0x0043, Exception -> 0x0051 }
        r2.close();	 Catch:{ RuntimeException -> 0x0043, Exception -> 0x0051 }
        goto L_0x0013;
    L_0x0043:
        r0 = move-exception;
        throw r0;
    L_0x0045:
        r0 = move-exception;
        r6 = r0;
        r0 = r1;
        r1 = r6;
    L_0x0049:
        r2 = "BETACLUB_SDK";
        r3 = "OtherUtils.getDeviceHelperFromData error";
        com.huawei.uploadlog.p188c.C2511g.m12482b(r2, r3, r1);
        goto L_0x0013;
    L_0x0051:
        r1 = move-exception;
        goto L_0x0049;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uploadlog.c.i.a(byte[]):com.huawei.crowdtestsdk.devices.DeviceHelper");
    }

    public static byte[] m12500a(DeviceHelper deviceHelper) {
        byte[] toByteArray;
        Exception e;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(deviceHelper);
            objectOutputStream.flush();
            toByteArray = byteArrayOutputStream.toByteArray();
            try {
                objectOutputStream.close();
                byteArrayOutputStream.close();
            } catch (Exception e2) {
                e = e2;
                C2511g.m12483c("BETACLUB_SDK", "OtherUtils.writeProjectListToLocal write device error" + e.toString());
                return toByteArray;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            toByteArray = null;
            e = exception;
            C2511g.m12483c("BETACLUB_SDK", "OtherUtils.writeProjectListToLocal write device error" + e.toString());
            return toByteArray;
        }
        return toByteArray;
    }
}
