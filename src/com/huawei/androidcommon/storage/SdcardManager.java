package com.huawei.androidcommon.storage;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.util.Log;
import com.huawei.androidcommon.constants.AC;
import com.huawei.androidcommon.utils.PreferenceUtils;
import java.util.ArrayList;
import java.util.List;

public class SdcardManager {
    public static final int EXTERNAL_FLAG = 1;
    public static final int INTERNAL_FLAG = 0;
    private static SdcardManager instance = new SdcardManager();
    private final String STORAGE_FLAG = "storage_flag";
    private List<SdcardObserverInterface> observers = new ArrayList();

    public static synchronized SdcardManager getInstance() {
        SdcardManager sdcardManager;
        synchronized (SdcardManager.class) {
            sdcardManager = instance;
        }
        return sdcardManager;
    }

    public boolean isMounted(Context context, String str) {
        try {
            boolean equals;
            if (VERSION.SDK_INT >= 23) {
                StorageManager from = StorageManager.from(context);
                Log.d(AC.TAG, "[SdcardManager.isMounted]Path:" + str);
                equals = "mounted".equals(from.getVolumeState(str));
                Log.d(AC.TAG, "[SdcardManager.isMounted]Mounted:" + str + ":" + equals);
                return equals;
            }
            equals = "mounted".equals(((StorageManager) context.getSystemService("storage")).getVolumeState(str));
            Log.d(AC.TAG, "[SdcardManager.isMounted]Path:" + str + ":" + equals);
            return equals;
        } catch (Throwable e) {
            Log.e(AC.TAG, "[SdcardManager.isMounted]Exception:", e);
            return false;
        }
    }

    public boolean isExternalMount(Context context) {
        return isMounted(context, getExternalStoragePath(context));
    }

    public String getInternalStoragePath() {
        return Environment.getExternalStorageDirectory().getPath();
    }

    public String getExternalStoragePath(Context context) {
        int i = 0;
        if (VERSION.SDK_INT < 23) {
            return System.getenv("SECONDARY_STORAGE");
        }
        StorageVolume[] volumeList = StorageManager.from(context).getVolumeList();
        Log.i(AC.TAG, "Storage num:" + volumeList.length);
        int length = volumeList.length;
        if (0 >= length) {
            return null;
        }
        while (i < length) {
            StorageVolume storageVolume = volumeList[i];
            Log.i(AC.TAG, "Path:" + storageVolume.getPath() + "--isPrimary:" + storageVolume.isPrimary() + "--isRemovable:" + storageVolume.isRemovable());
            if (storageVolume.isRemovable()) {
                return storageVolume.getPath();
            }
            i++;
        }
        return null;
    }

    public int getSDcardFlag(Context context) {
        return PreferenceUtils.getInt(context, "storage_flag", 0);
    }

    public void saveSDcardFlag(Context context, int i) {
        PreferenceUtils.putInt(context, "storage_flag", i);
    }

    public String getCurrentStoragePath(Context context) {
        int sDcardFlag = getSDcardFlag(context);
        if (sDcardFlag == 0) {
            if (isMounted(context, getInternalStoragePath())) {
                return getInternalStoragePath();
            }
        } else if (sDcardFlag == 1 && isMounted(context, getExternalStoragePath(context))) {
            return getExternalStoragePath(context);
        }
        return Environment.getExternalStorageDirectory().getPath();
    }

    public long getCurrentStorageSize(Context context) {
        try {
            String currentStoragePath = getCurrentStoragePath(context);
            if (currentStoragePath == null) {
                return 0;
            }
            StatFs statFs = new StatFs(currentStoragePath);
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public long getCurrentStorageFreeSize(Context context) {
        try {
            String currentStoragePath = getCurrentStoragePath(context);
            if (currentStoragePath == null) {
                return 0;
            }
            StatFs statFs = new StatFs(currentStoragePath);
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void registerSDcardObserver(SdcardObserverInterface sdcardObserverInterface) {
        if (!this.observers.contains(sdcardObserverInterface)) {
            this.observers.add(sdcardObserverInterface);
        }
    }

    public void unRegisterSDcardObserver(SdcardObserverInterface sdcardObserverInterface) {
        if (this.observers.contains(sdcardObserverInterface)) {
            this.observers.remove(sdcardObserverInterface);
        }
    }

    public void notifyMount() {
        int size = this.observers.size();
        for (int i = 0; i < size; i++) {
            ((SdcardObserverInterface) this.observers.get(i)).notificationMount();
        }
    }

    public void notifyUnmount() {
        int size = this.observers.size();
        for (int i = 0; i < size; i++) {
            ((SdcardObserverInterface) this.observers.get(i)).notificationUnmount();
        }
    }
}
