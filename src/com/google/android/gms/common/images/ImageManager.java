package com.google.android.gms.common.images;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.C0430l;
import com.google.android.gms.internal.ck;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public final class ImageManager {
    private static final Object f336a = new Object();
    private static HashSet<Uri> f337b = new HashSet();
    private final Context f338c;
    private final Handler f339d;
    private final ExecutorService f340e;
    private final C0410b f341f;
    private final ck f342g;
    private final Map<C0413e, ImageReceiver> f343h;
    private final Map<Uri, ImageReceiver> f344i;
    private final Map<Uri, Long> f345j;

    @KeepName
    final class ImageReceiver extends ResultReceiver {
        private final Uri mUri;
        private final ArrayList<C0413e> zzaEp = new ArrayList();
        final /* synthetic */ ImageManager zzaEq;

        ImageReceiver(ImageManager imageManager, Uri uri) {
            this.zzaEq = imageManager;
            super(new Handler(Looper.getMainLooper()));
            this.mUri = uri;
        }

        public void onReceiveResult(int i, Bundle bundle) {
            this.zzaEq.f340e.execute(new C0411c(this.zzaEq, this.mUri, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }

        public void zzb(C0413e c0413e) {
            C0430l.m677a("ImageReceiver.addImageRequest() must be called in the main thread");
            this.zzaEp.add(c0413e);
        }

        public void zzc(C0413e c0413e) {
            C0430l.m677a("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.zzaEp.remove(c0413e);
        }

        public void zzxr() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            this.zzaEq.f338c.sendBroadcast(intent);
        }
    }
}
