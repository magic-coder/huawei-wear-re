package com.huawei.android.pushselfshow.richpush.p341c.p342a;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.richpush.p341c.p343b.C4181b;
import com.huawei.android.pushselfshow.richpush.p341c.p343b.C4186g;
import com.huawei.android.pushselfshow.richpush.p341c.p343b.C4189j;
import com.huawei.hwid.core.constants.HwAccountConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class C4174d implements OnCompletionListener, OnErrorListener, OnPreparedListener {
    public String f15695a = null;
    Handler f15696b = new Handler();
    Runnable f15697c = null;
    boolean f15698d = true;
    private C4175e f15699e = C4175e.MEDIA_NONE;
    private String f15700f = null;
    private int f15701g = 1000;
    private MediaPlayer f15702h = null;
    private int f15703i = 0;
    private C4181b f15704j;

    public C4174d(Context context) {
        e.e("PushSelfShowLog", "init AudioPlayer");
    }

    private void m20349a(C4175e c4175e) {
        this.f15699e = c4175e;
    }

    private boolean m20350c() {
        Throwable th;
        int ordinal = this.f15699e.ordinal();
        if (ordinal != C4175e.MEDIA_NONE.ordinal()) {
            return ordinal != C4175e.MEDIA_STARTING.ordinal();
        } else {
            if (this.f15702h == null) {
                this.f15702h = new MediaPlayer();
                this.f15702h.setOnErrorListener(this);
                this.f15702h.setOnPreparedListener(this);
                this.f15702h.setOnCompletionListener(this);
            }
            FileInputStream fileInputStream = null;
            try {
                if (C4186g.m20375a(this.f15700f)) {
                    this.f15702h.setDataSource(this.f15700f);
                    this.f15702h.setAudioStreamType(3);
                    m20349a(C4175e.MEDIA_STARTING);
                    this.f15702h.prepareAsync();
                } else {
                    File file = new File(this.f15700f);
                    if (file.exists()) {
                        FileInputStream fileInputStream2 = new FileInputStream(file);
                        try {
                            this.f15702h.setDataSource(fileInputStream2.getFD());
                            m20349a(C4175e.MEDIA_STARTING);
                            this.f15702h.prepare();
                            fileInputStream = fileInputStream2;
                        } catch (RuntimeException e) {
                            fileInputStream = fileInputStream2;
                            try {
                                e.e("PushSelfShowLog", "prepareAsync/prepare error");
                                m20349a(C4175e.MEDIA_NONE);
                                if (fileInputStream != null) {
                                    return false;
                                }
                                try {
                                    fileInputStream.close();
                                    return false;
                                } catch (Exception e2) {
                                    e.e("PushSelfShowLog", "close fileInputStream error");
                                    return false;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception e3) {
                                        e.e("PushSelfShowLog", "close fileInputStream error");
                                    }
                                }
                                throw th;
                            }
                        } catch (FileNotFoundException e4) {
                            fileInputStream = fileInputStream2;
                            e.e("PushSelfShowLog", "prepareAsync/prepare error");
                            m20349a(C4175e.MEDIA_NONE);
                            if (fileInputStream != null) {
                                return false;
                            }
                            try {
                                fileInputStream.close();
                                return false;
                            } catch (Exception e5) {
                                e.e("PushSelfShowLog", "close fileInputStream error");
                                return false;
                            }
                        } catch (IOException e6) {
                            fileInputStream = fileInputStream2;
                            e.e("PushSelfShowLog", "prepareAsync/prepare error");
                            m20349a(C4175e.MEDIA_NONE);
                            if (fileInputStream != null) {
                                return false;
                            }
                            try {
                                fileInputStream.close();
                                return false;
                            } catch (Exception e7) {
                                e.e("PushSelfShowLog", "close fileInputStream error");
                                return false;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw th;
                        }
                    }
                }
                if (fileInputStream == null) {
                    return false;
                }
                try {
                    fileInputStream.close();
                    return false;
                } catch (Exception e8) {
                    e.e("PushSelfShowLog", "close fileInputStream error");
                    return false;
                }
            } catch (RuntimeException e9) {
                e.e("PushSelfShowLog", "prepareAsync/prepare error");
                m20349a(C4175e.MEDIA_NONE);
                if (fileInputStream != null) {
                    return false;
                }
                fileInputStream.close();
                return false;
            } catch (FileNotFoundException e10) {
                e.e("PushSelfShowLog", "prepareAsync/prepare error");
                m20349a(C4175e.MEDIA_NONE);
                if (fileInputStream != null) {
                    return false;
                }
                fileInputStream.close();
                return false;
            } catch (IOException e11) {
                e.e("PushSelfShowLog", "prepareAsync/prepare error");
                m20349a(C4175e.MEDIA_NONE);
                if (fileInputStream != null) {
                    return false;
                }
                fileInputStream.close();
                return false;
            }
        }
    }

    public void m20351a() {
        try {
            this.f15702h.start();
            m20349a(C4175e.MEDIA_RUNNING);
            this.f15703i = 0;
        } catch (Throwable e) {
            e.d("PushSelfShowLog", "play() error ", e);
        }
    }

    public void m20352a(int i) {
        try {
            if (m20350c()) {
                this.f15702h.seekTo(i);
                e.a("PushSelfShowLog", "Send a onStatus update for the new seek");
                return;
            }
            this.f15703i = i;
        } catch (IllegalStateException e) {
            e.a("PushSelfShowLog", "seekToPlaying failed");
        } catch (Exception e2) {
            e.a("PushSelfShowLog", "seekToPlaying failed");
        }
    }

    public void m20353b() {
        e.e("PushSelfShowLog", "Audio reset/Destory");
        try {
            this.f15698d = true;
            if (this.f15702h != null) {
                if (this.f15699e == C4175e.MEDIA_RUNNING || this.f15699e == C4175e.MEDIA_PAUSED) {
                    this.f15702h.stop();
                }
                this.f15702h.release();
                this.f15702h = null;
            }
            this.f15700f = null;
            m20349a(C4175e.MEDIA_NONE);
            this.f15701g = 1000;
            this.f15703i = 0;
            if (this.f15697c != null) {
                this.f15696b.removeCallbacks(this.f15697c);
            }
            this.f15697c = null;
        } catch (IllegalStateException e) {
            e.a("PushSelfShowLog", "reset music error");
        } catch (Exception e2) {
            e.a("PushSelfShowLog", "reset music error");
        }
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        e.a("PushSelfShowLog", "on completion is calling stopped");
        m20349a(C4175e.MEDIA_STOPPED);
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        e.a("PushSelfShowLog", "AudioPlayer.onError(" + i + ", " + i2 + ")");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.f15700f);
            this.f15704j.m20372a(this.f15695a, C4189j.AUDIO_PLAY_ERROR, HwAccountConstants.EXTRA_OPLOG_ERROR, jSONObject);
        } catch (JSONException e) {
            e.e("PushSelfShowLog", "onError error");
        }
        m20353b();
        return false;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        m20352a(this.f15703i);
        m20351a();
    }
}
