package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.amap.api.mapcore.bm.C3239a;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileProvider;

/* compiled from: ImageFetcher */
public class bb extends bc {
    private TileProvider f11490e = null;

    public bb(Context context, int i, int i2) {
        super(context, i, i2);
        m15608a(context);
    }

    private void m15608a(Context context) {
        m15609b(context);
    }

    public void m15612a(TileProvider tileProvider) {
        this.f11490e = tileProvider;
    }

    private void m15609b(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            bf.m15627a("ImageFetcher", "checkConnection - no connection found", 112);
        }
    }

    private Bitmap m15610c(C3239a c3239a) {
        bf.m15627a("ImageFetcher", "processBitmap - " + c3239a, 111);
        Bitmap bitmap = null;
        try {
            Tile tile = this.f11490e.getTile(c3239a.f11130a, c3239a.f11131b, c3239a.f11132c);
            if (!(tile == null || tile == TileProvider.NO_TILE)) {
                bitmap = BitmapFactory.decodeByteArray(tile.data, 0, tile.data.length);
            }
        } catch (Throwable th) {
        }
        return bitmap;
    }

    protected Bitmap mo4015a(Object obj) {
        return m15610c((C3239a) obj);
    }
}
