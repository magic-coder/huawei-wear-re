package com.huawei.appmarket;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Handler;
import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a;
import com.huawei.appmarket.sdk.service.download.bean.DownloadTask;
import com.huawei.appmarket.service.deamon.download.DownloadService;
import com.huawei.appmarket.service.deamon.download.SecurityDownloadTask;

public class C4234a {
    private static C4234a f15874c = null;
    String[][] f15875a;
    protected Handler f15876b;
    private Context f15877d;
    private Handler f15878e;
    private String f15879f = "";
    private BroadcastReceiver f15880g;
    private BroadcastReceiver f15881h;

    public C4234a() {
        r0 = new String[4][];
        r0[0] = new String[]{"http://122.11.38.214/dl/appdl/application/apk/fe/fed86042e0904b7db47d7efab94e4267/com.huawei.appmarket.1511121357.apk?sign=a90010110011100320000000@146152CDB7ECDD3CCC494B129ACEF0C8&source=search&subsource=%E5%BA%94%E7%94%A8&listId=16&position=1&hcrId=9528A3E4F1134CC7838A477F5AF52058&extendStr=complete%3Bdetail%3A1%3B&encryptType=1", "6841126", "http://appimg.hicloud.com/hwmarket/files/application/icon144/fed86042e0904b7db47d7efab94e4267_1.png", "C27162"};
        r0[1] = new String[]{"http://testhiapp.hicloud.com:39080/hwmarket3/files/application/apk/fe/fed86042e0904b7db47d7efab94e4267/com.huawei.appmarket.1511121357.apk?sign=a9001011ct11100320000000@146152CDB7ECDD3CCC494B129ACEF0C8&source=search&subsource=%E5%BA%94%E7%94%A8%E5%B8%82&listId=16&position=1&hcrId=9528A3E4F1134CC7838A477F5AF52058&extendStr=complete%3Bdetail%3A1%3B&encryptType=1", "6841126", "http://testhiapp.hicloud.com:39080/hwmarket3/files/application/icon144/fed86042e0904b7db47d7efab94e4267.png", "C27162"};
        r0[2] = new String[]{"http://testhiapp.hicloud.com:39080/hwmarket2/files/application/apk/26/2604519d8a69478db9a04f90b157fb50/com.huawei.appmarket.1506120947.apk?sign=a9001011cr11100320000000@146152CDB7ECDD3CCC494B129ACEF0C8&source=search&subsource=%E5%BA%94%E7%94%A8%E5%B8%82&listId=16&position=1&hcrId=9F054C9B3197463A967285E21081357F&extendStr=complete%3Bdetail%3A1%3B&encryptType=1", "6400933", "http://testhiapp.hicloud.com:39080/hwmarket2/files/application/icon144/2604519d8a69478db9a04f90b157fb50_1.png", "C27162"};
        r0[3] = new String[]{"http://testhiapp.hicloud.com:39080/hwmarket2/files/application/apk/26/2604519d8a69478db9a04f90b157fb50/com.huawei.appmarket.1506120947.apk?sign=a9001011cr11100320000000@146152CDB7ECDD3CCC494B129ACEF0C8&source=search&subsource=%E5%BA%94%E7%94%A8%E5%B8%82&listId=16&position=1&hcrId=9F054C9B3197463A967285E21081357F&extendStr=complete%3Bdetail%3A1%3B&encryptType=1", "6400933", "http://testhiapp.hicloud.com:39080/hwmarket2/files/application/icon144/2604519d8a69478db9a04f90b157fb50_1.png", "C27162"};
        this.f15875a = r0;
        this.f15876b = new C4235b(this);
        this.f15880g = new C4236c(this);
        this.f15881h = new C4237d(this);
    }

    public static C4234a m20519a() {
        if (f15874c == null) {
            f15874c = new C4234a();
        }
        return f15874c;
    }

    private void m20520a(Context context, DownloadService downloadService, String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        if (str != null && str.length() > 0 && downloadService != null) {
            DownloadTask a = downloadService.m20839a(str3);
            if (a == null) {
                DownloadTask securityDownloadTask = new SecurityDownloadTask();
                securityDownloadTask.setInstallType(z ? 0 : 2);
                securityDownloadTask.setUrl(str);
                securityDownloadTask.setName(str2);
                securityDownloadTask.setPackageName(str3);
                securityDownloadTask.setAppID(str6);
                long j = 0;
                try {
                    j = Long.valueOf(str4).longValue();
                } catch (Exception e) {
                    C4241a.m20532b("UpdateSdk", "startNewTask(...) " + e.toString());
                }
                securityDownloadTask.setFileSize(j);
                securityDownloadTask.setIconUrl(str5);
                downloadService.m20843b(securityDownloadTask);
            } else if (a.getStatus() > 4) {
                downloadService.m20844c(a);
            }
        }
    }

    public Context m20523b() {
        return this.f15877d;
    }
}
