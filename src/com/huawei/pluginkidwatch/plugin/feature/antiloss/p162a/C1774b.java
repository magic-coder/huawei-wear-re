package com.huawei.pluginkidwatch.plugin.feature.antiloss.p162a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.huawei.p190v.C2538c;

/* compiled from: AntilossUtils */
class C1774b implements OnPreparedListener {
    final /* synthetic */ C1773a f4923a;

    C1774b(C1773a c1773a) {
        this.f4923a = c1773a;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        C2538c.m12674b("AntilossUtils", "mMediaPlayer OnPreparedListener start !!!");
        mediaPlayer.start();
    }
}
