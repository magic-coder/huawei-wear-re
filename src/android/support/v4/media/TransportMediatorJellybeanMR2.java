package android.support.v4.media;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.RemoteControlClient;
import android.media.RemoteControlClient.OnGetPlaybackPositionListener;
import android.media.RemoteControlClient.OnPlaybackPositionUpdateListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnWindowAttachListener;
import android.view.ViewTreeObserver.OnWindowFocusChangeListener;
import com.android.volley.DefaultRetryPolicy;
import net.sqlcipher.database.SQLiteDatabase;

class TransportMediatorJellybeanMR2 {
    OnAudioFocusChangeListener mAudioFocusChangeListener = new C00984();
    boolean mAudioFocused;
    final AudioManager mAudioManager;
    final Context mContext;
    boolean mFocused;
    final OnGetPlaybackPositionListener mGetPlaybackPositionListener = new C00995();
    final Intent mIntent;
    final BroadcastReceiver mMediaButtonReceiver = new C00973();
    PendingIntent mPendingIntent;
    int mPlayState = 0;
    final OnPlaybackPositionUpdateListener mPlaybackPositionUpdateListener = new C01006();
    final String mReceiverAction;
    final IntentFilter mReceiverFilter;
    RemoteControlClient mRemoteControl;
    final View mTargetView;
    final TransportMediatorCallback mTransportCallback;
    final OnWindowAttachListener mWindowAttachListener = new C00951();
    final OnWindowFocusChangeListener mWindowFocusListener = new C00962();

    class C00951 implements OnWindowAttachListener {
        C00951() {
        }

        public void onWindowAttached() {
            TransportMediatorJellybeanMR2.this.windowAttached();
        }

        public void onWindowDetached() {
            TransportMediatorJellybeanMR2.this.windowDetached();
        }
    }

    class C00962 implements OnWindowFocusChangeListener {
        C00962() {
        }

        public void onWindowFocusChanged(boolean z) {
            if (z) {
                TransportMediatorJellybeanMR2.this.gainFocus();
            } else {
                TransportMediatorJellybeanMR2.this.loseFocus();
            }
        }
    }

    class C00973 extends BroadcastReceiver {
        C00973() {
        }

        public void onReceive(Context context, Intent intent) {
            try {
                TransportMediatorJellybeanMR2.this.mTransportCallback.handleKey((KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT"));
            } catch (Throwable e) {
                Log.w("TransportController", e);
            }
        }
    }

    class C00984 implements OnAudioFocusChangeListener {
        C00984() {
        }

        public void onAudioFocusChange(int i) {
            TransportMediatorJellybeanMR2.this.mTransportCallback.handleAudioFocusChange(i);
        }
    }

    class C00995 implements OnGetPlaybackPositionListener {
        C00995() {
        }

        public long onGetPlaybackPosition() {
            return TransportMediatorJellybeanMR2.this.mTransportCallback.getPlaybackPosition();
        }
    }

    class C01006 implements OnPlaybackPositionUpdateListener {
        C01006() {
        }

        public void onPlaybackPositionUpdate(long j) {
            TransportMediatorJellybeanMR2.this.mTransportCallback.playbackPositionUpdate(j);
        }
    }

    public TransportMediatorJellybeanMR2(Context context, AudioManager audioManager, View view, TransportMediatorCallback transportMediatorCallback) {
        this.mContext = context;
        this.mAudioManager = audioManager;
        this.mTargetView = view;
        this.mTransportCallback = transportMediatorCallback;
        this.mReceiverAction = context.getPackageName() + ":transport:" + System.identityHashCode(this);
        this.mIntent = new Intent(this.mReceiverAction);
        this.mIntent.setPackage(context.getPackageName());
        this.mReceiverFilter = new IntentFilter();
        this.mReceiverFilter.addAction(this.mReceiverAction);
        this.mTargetView.getViewTreeObserver().addOnWindowAttachListener(this.mWindowAttachListener);
        this.mTargetView.getViewTreeObserver().addOnWindowFocusChangeListener(this.mWindowFocusListener);
    }

    public Object getRemoteControlClient() {
        return this.mRemoteControl;
    }

    public void destroy() {
        windowDetached();
        this.mTargetView.getViewTreeObserver().removeOnWindowAttachListener(this.mWindowAttachListener);
        this.mTargetView.getViewTreeObserver().removeOnWindowFocusChangeListener(this.mWindowFocusListener);
    }

    void windowAttached() {
        this.mContext.registerReceiver(this.mMediaButtonReceiver, this.mReceiverFilter);
        this.mPendingIntent = PendingIntent.getBroadcast(this.mContext, 0, this.mIntent, SQLiteDatabase.CREATE_IF_NECESSARY);
        this.mRemoteControl = new RemoteControlClient(this.mPendingIntent);
        this.mRemoteControl.setOnGetPlaybackPositionListener(this.mGetPlaybackPositionListener);
        this.mRemoteControl.setPlaybackPositionUpdateListener(this.mPlaybackPositionUpdateListener);
    }

    void gainFocus() {
        if (!this.mFocused) {
            this.mFocused = true;
            this.mAudioManager.registerMediaButtonEventReceiver(this.mPendingIntent);
            this.mAudioManager.registerRemoteControlClient(this.mRemoteControl);
            if (this.mPlayState == 3) {
                takeAudioFocus();
            }
        }
    }

    void takeAudioFocus() {
        if (!this.mAudioFocused) {
            this.mAudioFocused = true;
            this.mAudioManager.requestAudioFocus(this.mAudioFocusChangeListener, 3, 1);
        }
    }

    public void startPlaying() {
        if (this.mPlayState != 3) {
            this.mPlayState = 3;
            this.mRemoteControl.setPlaybackState(3);
        }
        if (this.mFocused) {
            takeAudioFocus();
        }
    }

    public void refreshState(boolean z, long j, int i) {
        if (this.mRemoteControl != null) {
            this.mRemoteControl.setPlaybackState(z ? 3 : 1, j, z ? DefaultRetryPolicy.DEFAULT_BACKOFF_MULT : 0.0f);
            this.mRemoteControl.setTransportControlFlags(i);
        }
    }

    public void pausePlaying() {
        if (this.mPlayState == 3) {
            this.mPlayState = 2;
            this.mRemoteControl.setPlaybackState(2);
        }
        dropAudioFocus();
    }

    public void stopPlaying() {
        if (this.mPlayState != 1) {
            this.mPlayState = 1;
            this.mRemoteControl.setPlaybackState(1);
        }
        dropAudioFocus();
    }

    void dropAudioFocus() {
        if (this.mAudioFocused) {
            this.mAudioFocused = false;
            this.mAudioManager.abandonAudioFocus(this.mAudioFocusChangeListener);
        }
    }

    void loseFocus() {
        dropAudioFocus();
        if (this.mFocused) {
            this.mFocused = false;
            this.mAudioManager.unregisterRemoteControlClient(this.mRemoteControl);
            this.mAudioManager.unregisterMediaButtonEventReceiver(this.mPendingIntent);
        }
    }

    void windowDetached() {
        loseFocus();
        if (this.mPendingIntent != null) {
            this.mContext.unregisterReceiver(this.mMediaButtonReceiver);
            this.mPendingIntent.cancel();
            this.mPendingIntent = null;
            this.mRemoteControl = null;
        }
    }
}
