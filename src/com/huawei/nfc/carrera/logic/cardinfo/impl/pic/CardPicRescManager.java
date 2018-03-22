package com.huawei.nfc.carrera.logic.cardinfo.impl.pic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import com.huawei.nfc.carrera.logic.cardinfo.callback.RefreshLocalIconCallback;
import com.huawei.nfc.carrera.logic.cardinfo.callback.RefreshLocalRFConfCallback;
import com.huawei.nfc.carrera.logic.model.AppInfo;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.p190v.C2538c;
import com.huawei.pay.p473a.p476b.C5721c;
import com.huawei.wallet.R;
import com.huawei.wallet.storage.path.NfcStorageUtil;
import com.huawei.wallet.utils.bitmap.BitmapLruCacheForLocal;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class CardPicRescManager implements CardIconDownloadResultCallback {
    private static final float CIRCLE_ANGLE = 20.0f;
    public static final int DOWNLOAD_APKICON = 2;
    public static final int DOWNLOAD_CARD_ICON = 0;
    public static final int DOWNLOAD_LOGO = 1;
    public static final int DOWNLOAD_RFCONF_FILE = 3;
    private static final int DOWNLOAD_THREAD_POOL_NUMBER = 3;
    private static final byte[] SYNC_LOCK = new byte[0];
    private static final String TAG = "CardPicRescManager";
    private static CardPicRescManager instance = null;
    private static ExecutorService pool;
    private static final Object poolLock = new Object();
    private int iconHeight;
    private int iconWidth;
    private HashMap<String, Bitmap> mApkIconCache = new HashMap();
    private Context mContext;
    private WeakReference<Bitmap> mDefaultIcon;
    private WeakReference<Bitmap> mDefaultLogo;
    private HashMap<String, Bitmap> mLogoCache = new HashMap();
    private Paint mPaint;
    private Xfermode mXfermodeSRC_IN = new PorterDuffXfermode(Mode.SRC_IN);
    private Map<String, RefreshLocalIconCallback> refreshApkIconCallbacks;
    private final Object refreshApkIconLock = new Object();
    private final Object refreshIconAidsLock = new Object();
    private Map<String, RefreshLocalIconCallback> refreshIconCallbacks;
    private Map<String, RefreshLocalIconCallback> refreshLogoCallbacks;
    private final Object refreshLogoLock = new Object();
    private Map<String, RefreshLocalIconCallback> refreshRFConfCallbacks;
    private final Object refreshRFConfLock = new Object();

    private CardPicRescManager(Context context) {
        this.mContext = context.getApplicationContext();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.iconWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.card_default_card_width);
        this.iconHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.card_default_card_height);
    }

    public static CardPicRescManager getInstance(Context context) {
        CardPicRescManager cardPicRescManager;
        synchronized (SYNC_LOCK) {
            if (instance == null) {
                instance = new CardPicRescManager(context);
            }
            cardPicRescManager = instance;
        }
        return cardPicRescManager;
    }

    private Bitmap getCardIconBitmap(String str) {
        if (StringUtil.isEmpty(str, true)) {
            LogX.e("getCardIcon, productId is illegal.");
            return null;
        }
        String a = NfcStorageUtil.m28133a(this.mContext, str);
        LogX.d("getCardIcon cardIconPath : " + a);
        return BitmapLruCacheForLocal.m28495a().m28497a(a);
    }

    public Bitmap getCardIcon(String str, int i) {
        Bitmap cardIconBitmap = getCardIconBitmap(str);
        if (cardIconBitmap != null) {
            return cardIconBitmap;
        }
        LogX.d("getCardIcon , get default card icon.");
        if (this.mDefaultIcon == null || this.mDefaultIcon.get() == null) {
            Object bitmapFromApk;
            if (1 == i) {
                bitmapFromApk = getBitmapFromApk(R.drawable.card_default);
            } else if (2 == i) {
                bitmapFromApk = getBitmapFromApk(R.drawable.nfc_card_icon_default);
            } else {
                bitmapFromApk = getBitmapFromApk(R.drawable.nfc_card_icon_default);
                LogX.e("cardtype illeage........");
            }
            this.mDefaultIcon = new WeakReference(bitmapFromApk);
        }
        return (Bitmap) this.mDefaultIcon.get();
    }

    public void removeCardIcon(String str) {
        if (StringUtil.isEmpty(str, true)) {
            LogX.e("removeCardIcon, productId is illegal.");
            return;
        }
        String a = NfcStorageUtil.m28133a(this.mContext, str);
        File file = new File(a);
        if (file.exists() && file.delete()) {
            BitmapLruCacheForLocal.m28495a().m28498b(a);
            LogX.i("removeCardIcon finished.productId : " + str);
        }
    }

    public void removeLogo(String str) {
        if (StringUtil.isEmpty(str, true)) {
            LogX.e("removeLogo, productId is illegal.");
            return;
        }
        File file = new File(CardPicPathConfig.getCardLogoPath(this.mContext, str));
        if (file.exists() && file.delete()) {
            this.mLogoCache.remove(str);
            LogX.i("removeLogo finished.issuerId : " + str);
        }
    }

    public Bitmap getCardLogo(String str) {
        if (StringUtil.isEmpty(str, true)) {
            LogX.e("getCardLogo, issuerId is illegal.");
            return null;
        }
        Bitmap bitmap = (Bitmap) this.mLogoCache.get(str);
        if (bitmap != null) {
            return bitmap;
        }
        String cardLogoPath = CardPicPathConfig.getCardLogoPath(this.mContext, str);
        LogX.d("getCardLogo cardLogoPath : " + cardLogoPath);
        bitmap = getBitmapFromStorage(cardLogoPath);
        if (bitmap == null) {
            LogX.d("getCardLogo , get default card logo.");
            if (this.mDefaultLogo == null || this.mDefaultLogo.get() == null) {
                this.mDefaultLogo = new WeakReference(getBitmapFromApk(R.drawable.nfc_card_logo_default));
            }
            return (Bitmap) this.mDefaultLogo.get();
        }
        this.mLogoCache.put(str, bitmap);
        return bitmap;
    }

    public void getCardApkIcons(List<AppInfo> list) {
        if (list != null && !list.isEmpty()) {
            for (AppInfo appInfo : list) {
                appInfo.setApkIcon(getCardApkIcon(appInfo.getIssuerAppMarketId()));
            }
        }
    }

    private Bitmap getCardApkIcon(String str) {
        if (StringUtil.isEmpty(str, true)) {
            LogX.e("getCardLogo, issuerId is illegal.");
            return null;
        }
        Bitmap bitmap = (Bitmap) this.mApkIconCache.get(str);
        if (bitmap != null) {
            return bitmap;
        }
        String cardApkIconPath = CardPicPathConfig.getCardApkIconPath(this.mContext, str);
        LogX.d("getCardApkIcon cardApkIconPath : " + cardApkIconPath);
        bitmap = getBitmapFromStorage(cardApkIconPath);
        if (bitmap == null) {
            return bitmap;
        }
        this.mApkIconCache.put(str, bitmap);
        return bitmap;
    }

    public void refreshLocalCardIcon(String str, String str2, RefreshLocalIconCallback refreshLocalIconCallback) {
        boolean z = true;
        if (refreshLocalIconCallback == null || StringUtil.isEmpty(str, true) || StringUtil.isEmpty(str2, true)) {
            LogX.e("refreshLocalCardIcon, params illegal.");
            return;
        }
        synchronized (this.refreshIconAidsLock) {
            if (this.refreshIconCallbacks == null) {
                this.refreshIconCallbacks = new HashMap();
            }
            if (!this.refreshIconCallbacks.containsKey(str)) {
                this.refreshIconCallbacks.put(str, refreshLocalIconCallback);
                z = false;
            }
        }
        if (z) {
            LogX.d("refreshLocalCardIcon, but refresh task already existed.");
            refreshLocalIconCallback.refreshPicResult(0);
            return;
        }
        LogX.d("refreshLocalCardIcon, handle the product = " + str);
        String a = NfcStorageUtil.m28133a(this.mContext, str);
        LogX.d("refreshLocalCardIcon, handle the iconFilePath = " + a);
        if (new File(a).exists()) {
            synchronized (this.refreshIconAidsLock) {
                if (this.refreshIconCallbacks != null) {
                    this.refreshIconCallbacks.remove(str);
                }
            }
            refreshLocalIconCallback.refreshPicResult(0);
            return;
        }
        LogX.i("file not exists, download product = " + str);
        startIconDownloadTask(str, str2);
    }

    public void refreshLocalCardLogo(String str, String str2, RefreshLocalIconCallback refreshLocalIconCallback) {
        boolean z = true;
        if (StringUtil.isEmpty(str, true) || StringUtil.isEmpty(str2, true)) {
            LogX.e("refreshLocalCardLogo, params illegal.");
            return;
        }
        synchronized (this.refreshLogoLock) {
            if (this.refreshLogoCallbacks == null) {
                this.refreshLogoCallbacks = new HashMap();
            }
            if (!this.refreshLogoCallbacks.containsKey(str)) {
                this.refreshLogoCallbacks.put(str, refreshLocalIconCallback);
                z = false;
            }
        }
        if (z) {
            LogX.d("refreshLocalCardLogo, but refresh task already existed.");
            refreshLocalIconCallback.refreshPicResult(0);
        } else if (new File(NfcStorageUtil.m28135b(this.mContext, str)).exists()) {
            synchronized (this.refreshLogoLock) {
                this.refreshLogoCallbacks.remove(str);
            }
            refreshLocalIconCallback.refreshPicResult(0);
        } else {
            LogX.d("startLogoDownloadTask, issuerId = " + str);
            startLogoDownloadTask(str, str2);
        }
    }

    private void refreshLocalCardApkIcon(String str, String str2, RefreshLocalIconCallback refreshLocalIconCallback) {
        boolean z = true;
        if (StringUtil.isEmpty(str, true) || StringUtil.isEmpty(str2, true)) {
            LogX.e("refreshLocalCardApkIcon, params illegal.");
            return;
        }
        synchronized (this.refreshApkIconLock) {
            if (this.refreshApkIconCallbacks == null) {
                this.refreshApkIconCallbacks = new HashMap();
            }
            if (!this.refreshApkIconCallbacks.containsKey(str)) {
                this.refreshApkIconCallbacks.put(str, refreshLocalIconCallback);
                z = false;
            }
        }
        if (z) {
            LogX.d("refreshLocalCardLogo, but refresh task already existed.");
            refreshLocalIconCallback.refreshPicResult(0);
        } else if (new File(NfcStorageUtil.m28137c(this.mContext, str)).exists()) {
            synchronized (this.refreshApkIconLock) {
                this.refreshApkIconCallbacks.remove(str);
            }
            refreshLocalIconCallback.refreshPicResult(0);
        } else {
            LogX.d("startApkIconDownloadTask, appId = " + str);
            startApkIconDownloadTask(str, str2);
        }
    }

    public void refreshCardSmlPics(String str, String str2, List<AppInfo> list, RefreshLocalIconCallback refreshLocalIconCallback) {
        refreshLocalCardLogo(str, str2, refreshLocalIconCallback);
        if (list != null && !list.isEmpty()) {
            for (AppInfo appInfo : list) {
                refreshLocalCardApkIcon(appInfo.getIssuerAppMarketId(), appInfo.getApkIconUrl(), refreshLocalIconCallback);
            }
        }
    }

    public void refreshLocalRFConfFiles(String str, String str2, RefreshLocalIconCallback refreshLocalIconCallback) {
        boolean z = true;
        if (StringUtil.isEmpty(str, true) || StringUtil.isEmpty(str2, true)) {
            LogX.e("refreshLocalRFConfFiles, params illegal.");
            return;
        }
        synchronized (this.refreshRFConfLock) {
            if (this.refreshRFConfCallbacks == null) {
                this.refreshRFConfCallbacks = new HashMap();
            }
            if (!this.refreshRFConfCallbacks.containsKey(str)) {
                this.refreshRFConfCallbacks.put(str, refreshLocalIconCallback);
                z = false;
            }
        }
        if (z) {
            LogX.d("refreshLocalRFConfFiles, but refresh task already existed.");
            if (refreshLocalIconCallback == null) {
                return;
            }
            if (refreshLocalIconCallback instanceof RefreshLocalRFConfCallback) {
                ((RefreshLocalRFConfCallback) refreshLocalIconCallback).refreshPicResult(str, 0);
            } else {
                refreshLocalIconCallback.refreshPicResult(0);
            }
        } else if (new File(NfcStorageUtil.m28139d(this.mContext, str)).exists()) {
            synchronized (this.refreshRFConfLock) {
                this.refreshRFConfCallbacks.remove(str);
            }
            if (refreshLocalIconCallback == null) {
                return;
            }
            if (refreshLocalIconCallback instanceof RefreshLocalRFConfCallback) {
                ((RefreshLocalRFConfCallback) refreshLocalIconCallback).refreshPicResult(str, 0);
            } else {
                refreshLocalIconCallback.refreshPicResult(0);
            }
        } else {
            LogX.d("startLogoDownloadTask, issuerId = " + str);
            startRFConfDownloadTask(str, str2);
        }
    }

    private void startLogoDownloadTask(String str, String str2) {
        Runnable cardLogoDownloadTask = new CardLogoDownloadTask(this.mContext, str, str2, this);
        synchronized (poolLock) {
            if (pool == null) {
                pool = Executors.newFixedThreadPool(3);
            }
            pool.execute(cardLogoDownloadTask);
        }
    }

    private void startApkIconDownloadTask(String str, String str2) {
        Runnable cardApkIconDownTask = new CardApkIconDownTask(this.mContext, str, str2, this);
        synchronized (poolLock) {
            if (pool == null) {
                pool = Executors.newFixedThreadPool(3);
            }
            pool.execute(cardApkIconDownTask);
        }
    }

    private void startRFConfDownloadTask(String str, String str2) {
        Runnable cardRFConfFileDownloadTask = new CardRFConfFileDownloadTask(this.mContext, str, str2, this);
        synchronized (poolLock) {
            if (pool == null) {
                pool = Executors.newFixedThreadPool(3);
            }
            pool.execute(cardRFConfFileDownloadTask);
        }
    }

    private void startIconDownloadTask(String str, String str2) {
        Runnable cardIconDownloadTask = new CardIconDownloadTask(this.mContext, str, str2, this);
        synchronized (poolLock) {
            if (pool == null) {
                pool = Executors.newFixedThreadPool(3);
            }
            pool.execute(cardIconDownloadTask);
        }
    }

    private Bitmap getBitmapFromStorage(String str) {
        Bitmap bitmap = null;
        if (C5721c.m26377a(this.mContext, "android.permission.READ_EXTERNAL_STORAGE")) {
            try {
                bitmap = BitmapFactory.decodeFile(str);
            } catch (OutOfMemoryError e) {
                LogX.e("getBitmapFromStorage, out of memory error!");
            }
        } else {
            LogX.e("getBitmapFromStorage, but no read sdcard permission.");
        }
        return bitmap;
    }

    private Bitmap getBitmapFromApk(int i) {
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeResource(this.mContext.getResources(), i);
        } catch (OutOfMemoryError e) {
            LogX.e("getBitmapFromApk, out of memory error!");
        }
        return bitmap;
    }

    public void downloadIconResult(int i, String str, int i2) {
        if (StringUtil.isEmpty(str, true)) {
            LogX.d("downloadIconResult, aid is illegal.");
            return;
        }
        LogX.i("downloadIconResult async task, aid: " + str + ",resultCode: " + i2);
        RefreshLocalIconCallback refreshLocalIconCallback = null;
        if (i == 0) {
            synchronized (this.refreshIconAidsLock) {
                if (this.refreshIconCallbacks != null) {
                    refreshLocalIconCallback = (RefreshLocalIconCallback) this.refreshIconCallbacks.get(str);
                    this.refreshIconCallbacks.remove(str);
                }
            }
            if (refreshLocalIconCallback != null) {
                refreshLocalIconCallback.refreshPicResult(i2);
            }
        }
        if (i == 1) {
            synchronized (this.refreshLogoLock) {
                if (this.refreshLogoCallbacks != null) {
                    refreshLocalIconCallback = (RefreshLocalIconCallback) this.refreshLogoCallbacks.get(str);
                    this.refreshLogoCallbacks.remove(str);
                }
            }
            if (refreshLocalIconCallback != null) {
                refreshLocalIconCallback.refreshPicResult(i2);
            }
        }
        if (i == 2) {
            notifyApkIconResult(str, i2);
        }
        if (i == 3) {
            notifyRFConfFileResult(str, i2);
        }
    }

    private void notifyApkIconResult(String str, int i) {
        RefreshLocalIconCallback refreshLocalIconCallback = null;
        synchronized (this.refreshApkIconLock) {
            if (this.refreshApkIconCallbacks != null) {
                refreshLocalIconCallback = (RefreshLocalIconCallback) this.refreshApkIconCallbacks.get(str);
                this.refreshApkIconCallbacks.remove(str);
            }
        }
        if (refreshLocalIconCallback != null) {
            refreshLocalIconCallback.refreshPicResult(i);
        }
    }

    private void notifyRFConfFileResult(String str, int i) {
        RefreshLocalIconCallback refreshLocalIconCallback = null;
        synchronized (this.refreshRFConfLock) {
            if (this.refreshRFConfCallbacks != null) {
                refreshLocalIconCallback = (RefreshLocalIconCallback) this.refreshRFConfCallbacks.get(str);
                this.refreshRFConfCallbacks.remove(str);
            }
        }
        if (refreshLocalIconCallback == null) {
            return;
        }
        if (refreshLocalIconCallback instanceof RefreshLocalRFConfCallback) {
            C2538c.b(TAG, new Object[]{"notifyRFConfFileResult instanceof refreshPicResult  resultCode : " + i});
            ((RefreshLocalRFConfCallback) refreshLocalIconCallback).refreshPicResult(str, i);
            return;
        }
        C2538c.b(TAG, new Object[]{"notifyRFConfFileResult refreshPicResult  resultCode : " + i});
        refreshLocalIconCallback.refreshPicResult(i);
    }

    public Bitmap getRoundedCornerBitmap(Bitmap bitmap, int i, int i2) {
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        boolean z;
        Bitmap createBitmap;
        if (i2 <= this.iconHeight || i <= this.iconWidth) {
            z = false;
        } else {
            z = true;
        }
        Canvas canvas = new Canvas();
        if (z) {
            float f = ((float) this.iconHeight) / ((float) i2);
            createBitmap = Bitmap.createBitmap((int) (((float) i) * f), (int) (((float) i2) * f), Config.ARGB_8888);
            if (createBitmap == null) {
                return bitmap;
            }
            canvas.setBitmap(createBitmap);
            canvas.save();
            canvas.scale(f, f);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, null);
            bitmap.recycle();
            canvas.restore();
            bitmap = createBitmap;
        }
        Paint paint = new Paint();
        RectF rectF = new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight());
        paint.setAntiAlias(true);
        createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        if (createBitmap == null) {
            return bitmap;
        }
        canvas.setBitmap(createBitmap);
        this.mPaint.setXfermode(null);
        canvas.drawRoundRect(rectF, CIRCLE_ANGLE, CIRCLE_ANGLE, this.mPaint);
        this.mPaint.setXfermode(this.mXfermodeSRC_IN);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.mPaint);
        canvas.setBitmap(null);
        bitmap.recycle();
        return createBitmap;
    }

    public String getCardIconDirPath(String str) {
        return NfcStorageUtil.m28133a(this.mContext, str);
    }

    public String getCardRFConfFilePath(String str) {
        return NfcStorageUtil.m28139d(this.mContext, str);
    }
}
