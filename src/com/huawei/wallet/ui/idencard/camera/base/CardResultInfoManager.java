package com.huawei.wallet.ui.idencard.camera.base;

import android.graphics.Bitmap;
import android.util.LruCache;

public class CardResultInfoManager {
    private LruCache<String, Bitmap> f21584a;

    class ResultInfoInstance {
        static CardResultInfoManager f21583a = new CardResultInfoManager();

        private ResultInfoInstance() {
        }
    }

    public Bitmap m28423a() {
        return (Bitmap) this.f21584a.get("key_bankcard");
    }

    public void m28424a(Bitmap bitmap) {
        this.f21584a.put("key_bankcard", bitmap);
    }

    public Bitmap m28425b() {
        return (Bitmap) this.f21584a.get("key_hcoincard");
    }

    public void m28426b(Bitmap bitmap) {
        this.f21584a.put("key_hcoincard", bitmap);
    }

    public void m28427c() {
        Bitmap b = m28422d().m28425b();
        if (b != null) {
            if (!b.isRecycled()) {
                b.recycle();
            }
            this.f21584a.remove("key_hcoincard");
        }
    }

    private CardResultInfoManager() {
        this.f21584a = new LruCache(2);
    }

    public static CardResultInfoManager m28422d() {
        return ResultInfoInstance.f21583a;
    }
}
