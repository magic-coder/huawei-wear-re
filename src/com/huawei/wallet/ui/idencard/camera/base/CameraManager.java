package com.huawei.wallet.ui.idencard.camera.base;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.os.Handler;
import android.view.SurfaceHolder;
import com.huawei.wallet.utils.log.LogC;
import com.huawei.wallet.utils.log.LogErrorConstant;

public final class CameraManager {
    static final /* synthetic */ boolean f21570a;
    private static CameraManager f21571b;
    private static final byte[] f21572m = new byte[0];
    private final Context f21573c;
    private final CameraConfigurationManager f21574d;
    private Camera f21575e;
    private int f21576f;
    private boolean f21577g;
    private boolean f21578h;
    private byte[] f21579i;
    private final PreviewCallback f21580j;
    private final AutoFocusCallback f21581k;
    private boolean f21582l = true;

    static {
        boolean z;
        if (CameraManager.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        f21570a = z;
    }

    private CameraManager(Context context) {
        this.f21573c = context;
        this.f21574d = new CameraConfigurationManager(this.f21573c);
        this.f21580j = new PreviewCallback();
        this.f21581k = new AutoFocusCallback();
    }

    public static void m28406a(Context context) {
        synchronized (f21572m) {
            if (f21571b == null) {
                f21571b = new CameraManager(context);
            }
        }
    }

    public static CameraManager m28405a() {
        CameraManager cameraManager;
        synchronized (f21572m) {
            cameraManager = f21571b;
        }
        return cameraManager;
    }

    public CameraConfigurationManager m28415b() {
        return this.f21574d;
    }

    private Camera m28408h() {
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras == 0) {
            LogC.m28532c("No cameras!", false);
            return null;
        }
        int i = 0;
        while (i < numberOfCameras) {
            CameraInfo cameraInfo = new CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == 0) {
                break;
            }
            i++;
        }
        if (i < numberOfCameras) {
            LogC.m28530b("Opening camera #" + i, false);
            Camera open = Camera.open(i);
            this.f21576f = i;
            return open;
        }
        LogC.m28530b("No camera facing back; returning camera #0", false);
        open = Camera.open(0);
        this.f21576f = 0;
        return open;
    }

    private Camera m28409i() {
        if (this.f21582l) {
            try {
                return m28408h();
            } catch (Throwable e) {
                LogC.m28525a("RuntimeException while open camera.", e, 907118122, LogErrorConstant.m28535a("CameraManager.connectToCamera", e.getMessage()), false, false);
            } catch (Throwable e2) {
                LogC.m28525a("Unexpected exception. Please report it to support@card.io", e2, 907118100, LogErrorConstant.m28535a("CameraManager.connectToCamera", e2.getMessage()), false, false);
            }
        }
        LogC.m28532c("camera connect error.", false);
        return null;
    }

    public void m28411a(Activity activity) {
        if (this.f21574d != null && this.f21575e != null) {
            this.f21574d.m28400a(activity, this.f21576f, this.f21575e);
        }
    }

    private boolean m28410j() {
        LogC.m28530b("prepareScanner()", false);
        if (this.f21582l && this.f21575e == null) {
            this.f21575e = m28409i();
            if (this.f21575e == null) {
                LogC.m28534d("prepare scanner couldn't connect to camera!", false);
                return false;
            }
            LogC.m28530b("camera is connected", false);
            try {
                if (!this.f21577g) {
                    this.f21577g = true;
                    this.f21574d.m28401a(this.f21575e);
                }
                this.f21574d.m28403b(this.f21575e);
            } catch (RuntimeException e) {
                this.f21575e = null;
                this.f21577g = false;
                LogC.m28532c("mCamera initParameters error", false);
                return false;
            }
        } else if (!this.f21582l) {
            LogC.m28532c("useCamera is false!", false);
            return false;
        } else if (this.f21575e != null) {
            LogC.m28530b("we already have a camera instance.", false);
        }
        return true;
    }

    public boolean m28413a(SurfaceHolder surfaceHolder, Activity activity) {
        LogC.m28530b("resumeScanning", false);
        if (this.f21575e == null) {
            LogC.m28530b("preparing the scanner...", false);
            m28410j();
            LogC.m28530b("preparations complete", false);
        }
        if (this.f21582l && this.f21575e == null) {
            LogC.m28530b("null camera. failure", false);
            return false;
        } else if (f21570a || surfaceHolder != null) {
            if (this.f21582l && this.f21579i == null) {
                this.f21579i = new byte[this.f21574d.m28404c(this.f21575e)];
                this.f21575e.addCallbackBuffer(this.f21579i);
            }
            if (this.f21582l) {
                this.f21575e.setPreviewCallbackWithBuffer(this.f21580j);
            }
            m28411a(activity);
            m28407a(surfaceHolder);
            return true;
        } else {
            throw new AssertionError();
        }
    }

    private boolean m28407a(SurfaceHolder surfaceHolder) {
        if (!f21570a && surfaceHolder == null) {
            throw new AssertionError();
        } else if (f21570a || surfaceHolder.getSurface() != null) {
            LogC.m28530b("surfaceFrame: " + String.valueOf(surfaceHolder.getSurfaceFrame()), false);
            if (this.f21582l) {
                try {
                    this.f21575e.setPreviewDisplay(surfaceHolder);
                } catch (Throwable e) {
                    LogC.m28525a("can't set preview display", e, 907118101, LogErrorConstant.m28535a("CameraManager.makePreviewGo", e.getMessage()), false, false);
                    return false;
                }
            }
            return true;
        } else {
            throw new AssertionError();
        }
    }

    public void m28417c() {
        m28414a(false);
        if (this.f21575e != null) {
            this.f21575e.release();
            this.f21579i = null;
            LogC.m28530b("- released camera", false);
            this.f21575e = null;
        }
        LogC.m28530b("scan paused", false);
    }

    public void m28418d() {
        if (this.f21575e != null) {
            m28417c();
        }
        this.f21579i = null;
    }

    public void m28419e() {
        if (this.f21575e != null && !this.f21578h) {
            this.f21575e.startPreview();
            this.f21578h = true;
        }
    }

    public void m28420f() {
        if (this.f21575e != null && this.f21578h) {
            this.f21579i = null;
            this.f21575e.setPreviewCallbackWithBuffer(null);
            this.f21575e.stopPreview();
            this.f21580j.m28428a(null, 0);
            this.f21581k.m28394a(null, 0);
            this.f21578h = false;
        }
    }

    public boolean m28421g() {
        if (!this.f21582l || this.f21575e == null) {
            return false;
        }
        return "torch".equals(this.f21575e.getParameters().getFlashMode());
    }

    public boolean m28414a(boolean z) {
        if (this.f21575e == null) {
            return false;
        }
        LogC.m28530b("setFlashOn: " + z, false);
        try {
            Parameters parameters = this.f21575e.getParameters();
            parameters.setFlashMode(z ? "torch" : "off");
            this.f21575e.setParameters(parameters);
            return true;
        } catch (Throwable e) {
            LogC.m28526a("Could not set flash mode: ", e, false);
            return false;
        }
    }

    public void m28412a(Handler handler, int i) {
        if (this.f21575e != null && this.f21578h) {
            this.f21580j.m28428a(handler, i);
            this.f21575e.setPreviewCallbackWithBuffer(this.f21580j);
        }
    }

    public void m28416b(Handler handler, int i) {
        if (this.f21575e != null && this.f21578h) {
            this.f21581k.m28394a(handler, i);
            try {
                this.f21575e.autoFocus(this.f21581k);
            } catch (Throwable th) {
                LogC.m28534d("requestAutoFocus autofocus failed", false);
            }
        }
    }
}
