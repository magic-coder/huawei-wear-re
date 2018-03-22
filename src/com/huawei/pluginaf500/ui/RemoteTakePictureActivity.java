package com.huawei.pluginaf500.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.ShutterCallback;
import android.hardware.Camera.Size;
import android.media.MediaPlayer;
import android.media.MediaScannerConnection;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.fenda.hwbracelet.connection.C3596n;
import com.fenda.hwbracelet.mode.C3622e;
import com.huawei.p190v.C2538c;
import com.huawei.pluginaf500.d;
import com.huawei.pluginaf500.e;
import com.huawei.pluginaf500.f;
import com.huawei.pluginaf500.h;
import com.huawei.pluginaf500.utils.C5821d;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class RemoteTakePictureActivity extends AF500BaseActivity implements Callback {
    private int f19768A = 0;
    private int f19769B = 0;
    private int f19770C = 0;
    private int f19771D = 0;
    private float f19772E;
    private int f19773F = 0;
    private int f19774G = 0;
    private int f19775H = 0;
    private int f19776I = 0;
    private int f19777J = 0;
    private boolean f19778K = false;
    private boolean f19779L = true;
    private final BroadcastReceiver f19780M = new at(this);
    private AutoFocusCallback f19781N = new au(this);
    private ShutterCallback f19782O = new av(this);
    private PictureCallback f19783P = new aw(this);
    private String f19784Q = null;
    protected List<Size> f19785a;
    protected List<Size> f19786b;
    protected Size f19787c;
    protected Size f19788d;
    private Camera f19789g = null;
    private Parameters f19790h;
    private ImageView f19791i;
    private SurfaceView f19792j;
    private ImageView f19793k;
    private int f19794l = 0;
    private int f19795m = -1;
    private int f19796n = 1;
    private MediaPlayer f19797o;
    private az f19798p = new az(this);
    private ba f19799q = new ba(this);
    private boolean f19800r = false;
    private boolean f19801s = false;
    private boolean f19802t = false;
    private boolean f19803u = false;
    private ay f19804v = new ay(this);
    private SurfaceHolder f19805w;
    private int f19806x;
    private int f19807y;
    private int f19808z = 0;

    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(128, 128);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        defaultDisplay.getMetrics(displayMetrics);
        this.f19808z = displayMetrics.widthPixels;
        this.f19768A = displayMetrics.heightPixels;
        if (VERSION.SDK_INT == 13) {
            try {
                this.f19768A = ((Integer) defaultDisplay.getClass().getMethod("getRealHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
            } catch (InvocationTargetException e) {
            } catch (NoSuchMethodException e2) {
            } catch (IllegalAccessException e3) {
            }
        } else if (VERSION.SDK_INT >= 19) {
            defaultDisplay.getRealMetrics(displayMetrics);
            this.f19777J = displayMetrics.heightPixels - this.f19768A;
            this.f19808z = displayMetrics.widthPixels;
            this.f19768A = displayMetrics.heightPixels;
        } else if (VERSION.SDK_INT > 13) {
            defaultDisplay.getRealMetrics(displayMetrics);
            this.f19777J = displayMetrics.heightPixels - this.f19768A;
            this.f19808z = displayMetrics.widthPixels;
            this.f19768A = displayMetrics.heightPixels;
        }
        this.f19791i = (ImageView) findViewById(e.id_iv_switch);
        this.f19791i.setOnClickListener(this.f19804v);
        this.f19792j = (SurfaceView) findViewById(e.id_camera_PreviewView);
        this.f19793k = (ImageView) findViewById(e.id_iv_takepicture);
        this.f19793k.setOnClickListener(this.f19804v);
        this.f19805w = this.f19792j.getHolder();
        this.f19805w.addCallback(this);
        this.f19805w.setType(3);
        Bitmap decodeResource = BitmapFactory.decodeResource(getApplicationContext().getResources(), d.camera_selected);
        this.f19773F = decodeResource.getWidth();
        this.f19774G = decodeResource.getHeight();
        decodeResource = BitmapFactory.decodeResource(getApplicationContext().getResources(), d.photo);
        this.f19775H = decodeResource.getWidth();
        this.f19776I = decodeResource.getHeight();
        this.f19778K = false;
    }

    protected void onStart() {
        super.onStart();
    }

    protected void onRestart() {
        super.onRestart();
    }

    protected void onResume() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.fenda.hwbracelet.CAMERA_SHUTTER");
        registerReceiver(this.f19780M, intentFilter, "com.af500.permission.MYBRODCAST", null);
        if (3 == C3596n.m18054a() && m26514e() != null) {
            m26514e().m26559a(new C3622e(true).m18153a());
        }
        this.f19803u = false;
        super.onResume();
    }

    public void mo5112a(Message message) {
        if (message.what == C5793b.BIND_SERVICE_SUCCESS.m26879a() && 3 == C3596n.m18054a() && m26514e() != null) {
            m26514e().m26559a(new C3622e(true).m18153a());
        }
    }

    protected void onPause() {
        if (this.f19780M != null) {
            unregisterReceiver(this.f19780M);
        }
        if (3 == C3596n.m18054a() && m26514e() != null) {
            m26514e().m26559a(new C3622e(false).m18153a());
        }
        if (this.f19797o != null) {
            try {
                this.f19797o.stop();
                this.f19797o.release();
                this.f19797o = null;
                this.f19800r = false;
            } catch (IllegalStateException e) {
            }
        }
        this.f19803u = true;
        super.onPause();
    }

    protected void onStop() {
        super.onStop();
        if (3 == C3596n.m18054a() && m26514e() != null) {
            m26514e().m26559a(new C3622e(false).m18153a());
        }
    }

    protected void onDestroy() {
        com.huawei.hwcommonmodel.d.d.n(this);
        super.onDestroy();
        getWindow().clearFlags(128);
        if (3 == C3596n.m18054a() && m26514e() != null) {
            m26514e().m26559a(new C3622e(false).m18153a());
        }
    }

    private boolean m26748a(byte[] bArr) {
        OutputStream bufferedOutputStream;
        Bitmap bitmap = null;
        if (bArr.length < 2048) {
            return false;
        }
        try {
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            Matrix matrix = new Matrix();
            matrix.reset();
            if (this.f19796n == 0) {
                matrix.postRotate(-90.0f);
            } else {
                matrix.postRotate(90.0f);
            }
            if (decodeByteArray != null) {
                try {
                    bitmap = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, true);
                } catch (OutOfMemoryError e) {
                    bitmap = decodeByteArray;
                }
            }
            this.f19784Q = C5821d.m26900a() + "IMG_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date()) + ".jpg";
            C5821d.m26903a(C5821d.m26900a());
            File file = new File(this.f19784Q);
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                if (bitmap != null) {
                    bitmap.compress(CompressFormat.JPEG, 100, bufferedOutputStream);
                }
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
            } catch (Exception e2) {
                bufferedOutputStream.close();
            } catch (Exception e3) {
                C2538c.e("RemoteTakePictureActivity", new Object[]{"Exception e = " + e3.getMessage()});
                if (!(bitmap == null || bitmap.isRecycled())) {
                    bitmap.recycle();
                }
                if (!(decodeByteArray == null || decodeByteArray.isRecycled())) {
                    decodeByteArray.recycle();
                }
                return false;
            } catch (Throwable th) {
                bufferedOutputStream.close();
            }
            if (file != null) {
                MediaScannerConnection.scanFile(this, new String[]{this.f19784Q}, null, null);
            }
            m26763j();
            if (!(bitmap == null || bitmap.isRecycled())) {
                bitmap.recycle();
            }
            if (!(decodeByteArray == null || decodeByteArray.isRecycled())) {
                decodeByteArray.recycle();
            }
            return true;
        } catch (OutOfMemoryError e4) {
            return false;
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        int numberOfCameras;
        if (VERSION.SDK_INT >= 9) {
            numberOfCameras = Camera.getNumberOfCameras();
            CameraInfo cameraInfo = new CameraInfo();
            for (int i = 0; i < numberOfCameras; i++) {
                Camera.getCameraInfo(i, cameraInfo);
                if (cameraInfo.facing == 1) {
                    this.f19795m = i;
                    break;
                }
            }
            if (this.f19794l == this.f19795m) {
                this.f19796n = 0;
            } else {
                this.f19796n = 1;
            }
            this.f19789g = Camera.open(this.f19794l);
        } else {
            this.f19794l = 0;
            this.f19796n = 1;
            this.f19789g = Camera.open();
            numberOfCameras = 1;
        }
        if (numberOfCameras < 2) {
            this.f19791i.setVisibility(4);
        } else {
            this.f19791i.setVisibility(0);
        }
        try {
            if (this.f19789g != null) {
                this.f19789g.setPreviewDisplay(this.f19805w);
                this.f19789g.startPreview();
                if (VERSION.SDK_INT < 8) {
                    this.f19790h.set("orientation", "portrait");
                } else {
                    this.f19789g.setDisplayOrientation(90);
                }
                if (this.f19789g != null) {
                    Toast.makeText(this, h.could_use_brand_photo, 1).show();
                }
            }
        } catch (IOException e) {
            finish();
        } catch (RuntimeException e2) {
            finish();
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.f19769B = i;
        if (surfaceHolder.getSurface() != null) {
            try {
                if (this.f19789g != null) {
                    m26765k();
                    this.f19789g.autoFocus(null);
                    Object obj = getResources().getConfiguration().orientation != 2 ? 1 : null;
                    try {
                        if (this.f19789g != null) {
                            this.f19790h = this.f19789g.getParameters();
                        }
                        this.f19785a = this.f19790h.getSupportedPreviewSizes();
                        if (this.f19785a != null) {
                            this.f19785a.size();
                            this.f19786b = this.f19790h.getSupportedPictureSizes();
                            if (this.f19786b != null) {
                                Camera camera;
                                int i4;
                                LayoutParams layoutParams;
                                int size = this.f19786b.size();
                                if (this.f19787c == null && this.f19789g != null) {
                                    camera = this.f19789g;
                                    camera.getClass();
                                    this.f19787c = new Size(camera, 0, 0);
                                }
                                if (this.f19788d == null && this.f19789g != null) {
                                    camera = this.f19789g;
                                    camera.getClass();
                                    this.f19788d = new Size(camera, 0, 0);
                                }
                                if (m26763j() >= 209715200) {
                                    i4 = size / 2;
                                } else if (size <= 2 || ((Size) this.f19786b.get(0)).height <= ((Size) this.f19786b.get(size - 1)).height) {
                                    i4 = 0;
                                } else {
                                    i4 = size - 1;
                                }
                                Size size2 = (Size) this.f19786b.get(i4);
                                this.f19788d.width = size2.width;
                                this.f19788d.height = size2.height;
                                this.f19787c = this.f19790h.getPreviewSize();
                                this.f19790h.setPictureSize(this.f19788d.width, this.f19788d.height);
                                float f = ((float) this.f19788d.height) / ((float) this.f19788d.width);
                                int i5 = 0;
                                int i6 = 0;
                                size = 0;
                                int i7 = 0;
                                if (((float) this.f19808z) / ((float) this.f19768A) < f) {
                                    this.f19806x = this.f19808z;
                                    this.f19807y = (int) (((float) this.f19806x) / f);
                                    i6 = this.f19768A - this.f19807y;
                                    if (i6 > (this.f19774G + this.f19776I) + this.f19777J) {
                                        i5 = (((i6 - this.f19774G) - this.f19776I) - this.f19777J) / 4;
                                        layoutParams = (LayoutParams) this.f19791i.getLayoutParams();
                                        layoutParams.topMargin = i5;
                                        layoutParams.bottomMargin = i5;
                                        this.f19791i.setLayoutParams(layoutParams);
                                        layoutParams = (LayoutParams) this.f19793k.getLayoutParams();
                                        layoutParams.topMargin = i5;
                                        layoutParams.bottomMargin = this.f19777J + i5;
                                        this.f19793k.setLayoutParams(layoutParams);
                                        i4 = (this.f19776I + this.f19777J) + (i5 * 2);
                                        i5 = (i5 * 2) + this.f19774G;
                                        i6 = i4;
                                    } else if (i6 > this.f19776I + this.f19777J) {
                                        i5 = ((i6 - this.f19776I) - this.f19777J) / 2;
                                        layoutParams = (LayoutParams) this.f19791i.getLayoutParams();
                                        layoutParams.topMargin = C5821d.m26898a((Context) this, 50.0f);
                                        this.f19791i.setLayoutParams(layoutParams);
                                        layoutParams = (LayoutParams) this.f19793k.getLayoutParams();
                                        layoutParams.topMargin = i5;
                                        layoutParams.bottomMargin = i5 + this.f19777J;
                                        this.f19793k.setLayoutParams(layoutParams);
                                        i5 = 0;
                                    } else {
                                        layoutParams = (LayoutParams) this.f19791i.getLayoutParams();
                                        layoutParams.topMargin = C5821d.m26898a((Context) this, 50.0f);
                                        this.f19791i.setLayoutParams(layoutParams);
                                        layoutParams = (LayoutParams) this.f19793k.getLayoutParams();
                                        layoutParams.bottomMargin = C5821d.m26898a((Context) this, 50.0f) + this.f19777J;
                                        this.f19793k.setLayoutParams(layoutParams);
                                        i5 = 0;
                                    }
                                } else {
                                    this.f19807y = this.f19768A;
                                    this.f19806x = (int) (((float) this.f19807y) * f);
                                    i7 = this.f19808z - this.f19806x;
                                    if (i7 > this.f19773F + this.f19775H) {
                                        i7 /= 2;
                                        layoutParams = (LayoutParams) this.f19791i.getLayoutParams();
                                        layoutParams.rightMargin = i7;
                                        layoutParams.leftMargin = i7;
                                        this.f19791i.setLayoutParams(layoutParams);
                                        layoutParams = (LayoutParams) this.f19793k.getLayoutParams();
                                        layoutParams.rightMargin = i7;
                                        layoutParams.leftMargin = i7;
                                        this.f19793k.setLayoutParams(layoutParams);
                                        size = i7;
                                    } else {
                                        layoutParams = (LayoutParams) this.f19793k.getLayoutParams();
                                        layoutParams.rightMargin = i7;
                                        layoutParams.leftMargin = i7;
                                        this.f19793k.setLayoutParams(layoutParams);
                                    }
                                }
                                layoutParams = (LayoutParams) this.f19792j.getLayoutParams();
                                layoutParams.width = this.f19806x;
                                layoutParams.height = this.f19807y;
                                layoutParams.topMargin = i5;
                                layoutParams.bottomMargin = i6;
                                layoutParams.leftMargin = size;
                                layoutParams.rightMargin = i7;
                                this.f19792j.setLayoutParams(layoutParams);
                                i5 = this.f19785a.size();
                                float f2 = 10.0f;
                                i6 = 0;
                                size = 0;
                                while (size < i5) {
                                    size2 = (Size) this.f19785a.get(size);
                                    float abs = Math.abs((((float) size2.height) / ((float) size2.width)) - f);
                                    if (abs < f2) {
                                        i7 = size;
                                    } else {
                                        abs = f2;
                                        i7 = i6;
                                    }
                                    size++;
                                    i6 = i7;
                                    f2 = abs;
                                }
                                if (this.f19787c != null) {
                                    this.f19787c.width = ((Size) this.f19785a.get(i6)).width;
                                    this.f19787c.height = ((Size) this.f19785a.get(i6)).height;
                                    this.f19790h.setPreviewSize(this.f19787c.width, this.f19787c.height);
                                }
                                if (obj != null) {
                                    if (VERSION.SDK_INT < 8) {
                                        this.f19790h.set("orientation", "portrait");
                                    } else {
                                        m26782a(this, this.f19794l, this.f19789g);
                                    }
                                } else if (VERSION.SDK_INT < 8) {
                                    this.f19790h.set("orientation", "landscape");
                                } else {
                                    m26782a(this, this.f19794l, this.f19789g);
                                }
                                if (VERSION.SDK_INT >= 19) {
                                    List supportedFocusModes = this.f19790h.getSupportedFocusModes();
                                    if (supportedFocusModes != null && supportedFocusModes.contains("continuous-picture")) {
                                        this.f19790h.setFocusMode("continuous-picture");
                                    }
                                }
                                if (this.f19789g != null) {
                                    this.f19789g.setParameters(this.f19790h);
                                    try {
                                        this.f19789g.setPreviewDisplay(surfaceHolder);
                                        this.f19789g.startPreview();
                                        this.f19789g.setPreviewCallback(new ax(this));
                                    } catch (IOException e) {
                                        m26765k();
                                        this.f19789g.release();
                                        this.f19789g = null;
                                    }
                                }
                            }
                        }
                    } catch (Exception e2) {
                        finish();
                    }
                }
            } catch (Exception e3) {
            }
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (this.f19789g != null) {
            try {
                m26765k();
                this.f19789g.release();
                this.f19789g = null;
            } catch (Exception e) {
                finish();
            }
        }
    }

    public void m26782a(Activity activity, int i, Camera camera) {
        int i2 = 0;
        CameraInfo cameraInfo = new CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        switch (activity.getWindowManager().getDefaultDisplay().getRotation()) {
            case 1:
                i2 = 90;
                break;
            case 2:
                i2 = 180;
                break;
            case 3:
                i2 = 270;
                break;
        }
        if (cameraInfo.facing == 1) {
            i2 = (360 - ((i2 + cameraInfo.orientation) % 360)) % 360;
        } else {
            i2 = ((cameraInfo.orientation - i2) + 360) % 360;
        }
        if (camera != null) {
            camera.setDisplayOrientation(i2);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.f19771D = 1;
                break;
            case 1:
                this.f19771D = 0;
                break;
            case 2:
                if (this.f19771D >= 2) {
                    float a = m26741a(motionEvent);
                    if (a > this.f19772E) {
                        m26784b(1);
                    }
                    if (a < this.f19772E) {
                        m26784b(2);
                        break;
                    }
                }
                break;
            case 5:
                this.f19772E = m26741a(motionEvent);
                this.f19771D++;
                break;
            case 6:
                this.f19771D--;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private float m26741a(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((double) ((x * x) + (y * y)));
    }

    public void m26784b(int i) {
        if (this.f19789g != null) {
            Parameters parameters = this.f19789g.getParameters();
            int maxZoom = parameters.getMaxZoom();
            if (i == 1) {
                if (this.f19770C < maxZoom * 5) {
                    this.f19770C++;
                    parameters.setZoom(this.f19770C / 5);
                }
            } else if (this.f19770C > 5) {
                this.f19770C--;
                parameters.setZoom(this.f19770C / 5);
            }
            try {
                this.f19789g.setParameters(parameters);
            } catch (IllegalStateException e) {
            }
        }
    }

    private long m26763j() {
        ActivityManager activityManager = (ActivityManager) getSystemService("activity");
        MemoryInfo memoryInfo = new MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    protected int mo5104a() {
        return f.activity_remote_takepicture;
    }

    public void onBackPressed() {
        this.f19793k.setVisibility(8);
        super.onBackPressed();
    }

    private void m26765k() {
        if (this.f19789g != null) {
            this.f19789g.setPreviewCallback(null);
            this.f19789g.stopPreview();
        }
    }
}
