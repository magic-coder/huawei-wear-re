package com.amap.api.mapcore;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView.Renderer;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

@SuppressLint({"NewApi"})
/* compiled from: GLTextureView */
public class C3253x extends TextureView implements SurfaceTextureListener {
    private static final C3358j f11229a = new C3358j();
    private final WeakReference<C3253x> f11230b = new WeakReference(this);
    private C3357i f11231c;
    private Renderer f11232d;
    private boolean f11233e;
    private C3349e f11234f;
    private C3352f f11235g;
    private C3354g f11236h;
    private C3359k f11237i;
    private int f11238j;
    private int f11239k;
    private boolean f11240l;

    /* compiled from: GLTextureView */
    public interface C3349e {
        EGLConfig mo4068a(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* compiled from: GLTextureView */
    abstract class C3350a implements C3349e {
        protected int[] f11893a;
        final /* synthetic */ C3253x f11894b;

        abstract EGLConfig mo4069a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public C3350a(C3253x c3253x, int[] iArr) {
            this.f11894b = c3253x;
            this.f11893a = m16348a(iArr);
        }

        public EGLConfig mo4068a(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.f11893a, null, 0, iArr)) {
                int i = iArr[0];
                if (i <= 0) {
                    throw new IllegalArgumentException("No configs match configSpec");
                }
                EGLConfig[] eGLConfigArr = new EGLConfig[i];
                if (egl10.eglChooseConfig(eGLDisplay, this.f11893a, eGLConfigArr, i, iArr)) {
                    EGLConfig a = mo4069a(egl10, eGLDisplay, eGLConfigArr);
                    if (a != null) {
                        return a;
                    }
                    throw new IllegalArgumentException("No config chosen");
                }
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }

        private int[] m16348a(int[] iArr) {
            if (this.f11894b.f11239k != 2 && this.f11894b.f11239k != 3) {
                return iArr;
            }
            int length = iArr.length;
            Object obj = new int[(length + 2)];
            System.arraycopy(iArr, 0, obj, 0, length - 1);
            obj[length - 1] = 12352;
            if (this.f11894b.f11239k == 2) {
                obj[length] = 4;
            } else {
                obj[length] = 64;
            }
            obj[length + 1] = 12344;
            return obj;
        }
    }

    /* compiled from: GLTextureView */
    class C3351b extends C3350a {
        protected int f11895c;
        protected int f11896d;
        protected int f11897e;
        protected int f11898f;
        protected int f11899g;
        protected int f11900h;
        final /* synthetic */ C3253x f11901i;
        private int[] f11902j = new int[1];

        public C3351b(C3253x c3253x, int i, int i2, int i3, int i4, int i5, int i6) {
            this.f11901i = c3253x;
            super(c3253x, new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344});
            this.f11895c = i;
            this.f11896d = i2;
            this.f11897e = i3;
            this.f11898f = i4;
            this.f11899g = i5;
            this.f11900h = i6;
        }

        public EGLConfig mo4069a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a = m16351a(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int a2 = m16351a(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (a >= this.f11899g && a2 >= this.f11900h) {
                    a = m16351a(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int a3 = m16351a(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int a4 = m16351a(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    a2 = m16351a(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (a == this.f11895c && a3 == this.f11896d && a4 == this.f11897e && a2 == this.f11898f) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        private int m16351a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.f11902j)) {
                return this.f11902j[0];
            }
            return i2;
        }
    }

    /* compiled from: GLTextureView */
    public interface C3352f {
        EGLContext mo4070a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void mo4071a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* compiled from: GLTextureView */
    class C3353c implements C3352f {
        final /* synthetic */ C3253x f11903a;
        private int f11904b;

        private C3353c(C3253x c3253x) {
            this.f11903a = c3253x;
            this.f11904b = 12440;
        }

        public EGLContext mo4070a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = new int[]{this.f11904b, this.f11903a.f11239k, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (this.f11903a.f11239k == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        public void mo4071a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                C3356h.m16362a("eglDestroyContex", egl10.eglGetError());
            }
        }
    }

    /* compiled from: GLTextureView */
    public interface C3354g {
        EGLSurface mo4072a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void mo4073a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* compiled from: GLTextureView */
    class C3355d implements C3354g {
        private C3355d() {
        }

        public EGLSurface mo4072a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            EGLSurface eGLSurface = null;
            try {
                eGLSurface = egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (Throwable e) {
                Log.e("GLSurfaceView", "eglCreateWindowSurface", e);
            }
            return eGLSurface;
        }

        public void mo4073a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* compiled from: GLTextureView */
    class C3356h {
        EGL10 f11905a;
        EGLDisplay f11906b;
        EGLSurface f11907c;
        EGLConfig f11908d;
        EGLContext f11909e;
        private WeakReference<C3253x> f11910f;

        public C3356h(WeakReference<C3253x> weakReference) {
            this.f11910f = weakReference;
        }

        public void m16366a() {
            this.f11905a = (EGL10) EGLContext.getEGL();
            this.f11906b = this.f11905a.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.f11906b == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (this.f11905a.eglInitialize(this.f11906b, new int[2])) {
                C3253x c3253x = (C3253x) this.f11910f.get();
                if (c3253x == null) {
                    this.f11908d = null;
                    this.f11909e = null;
                } else {
                    this.f11908d = c3253x.f11234f.mo4068a(this.f11905a, this.f11906b);
                    this.f11909e = c3253x.f11235g.mo4070a(this.f11905a, this.f11906b, this.f11908d);
                }
                if (this.f11909e == null || this.f11909e == EGL10.EGL_NO_CONTEXT) {
                    this.f11909e = null;
                    m16361a("createContext");
                }
                this.f11907c = null;
                return;
            }
            throw new RuntimeException("eglInitialize failed");
        }

        public boolean m16367b() {
            if (this.f11905a == null) {
                throw new RuntimeException("egl not initialized");
            } else if (this.f11906b == null) {
                throw new RuntimeException("eglDisplay not initialized");
            } else if (this.f11908d == null) {
                throw new RuntimeException("mEglConfig not initialized");
            } else {
                m16365g();
                C3253x c3253x = (C3253x) this.f11910f.get();
                if (c3253x != null) {
                    this.f11907c = c3253x.f11236h.mo4072a(this.f11905a, this.f11906b, this.f11908d, c3253x.getSurfaceTexture());
                } else {
                    this.f11907c = null;
                }
                if (this.f11907c == null || this.f11907c == EGL10.EGL_NO_SURFACE) {
                    if (this.f11905a.eglGetError() == 12299) {
                        Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    }
                    return false;
                } else if (this.f11905a.eglMakeCurrent(this.f11906b, this.f11907c, this.f11907c, this.f11909e)) {
                    return true;
                } else {
                    C3356h.m16363a("EGLHelper", "eglMakeCurrent", this.f11905a.eglGetError());
                    return false;
                }
            }
        }

        GL m16368c() {
            GL gl = this.f11909e.getGL();
            C3253x c3253x = (C3253x) this.f11910f.get();
            if (c3253x == null) {
                return gl;
            }
            if (c3253x.f11237i != null) {
                gl = c3253x.f11237i.m16394a(gl);
            }
            if ((c3253x.f11238j & 3) == 0) {
                return gl;
            }
            Writer c3360l;
            int i = 0;
            if ((c3253x.f11238j & 1) != 0) {
                i = 1;
            }
            if ((c3253x.f11238j & 2) != 0) {
                c3360l = new C3360l();
            } else {
                c3360l = null;
            }
            return GLDebugHelper.wrap(gl, i, c3360l);
        }

        public int m16369d() {
            if (this.f11905a.eglSwapBuffers(this.f11906b, this.f11907c)) {
                return 12288;
            }
            return this.f11905a.eglGetError();
        }

        public void m16370e() {
            m16365g();
        }

        private void m16365g() {
            if (this.f11907c != null && this.f11907c != EGL10.EGL_NO_SURFACE) {
                this.f11905a.eglMakeCurrent(this.f11906b, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                C3253x c3253x = (C3253x) this.f11910f.get();
                if (c3253x != null) {
                    c3253x.f11236h.mo4073a(this.f11905a, this.f11906b, this.f11907c);
                }
                this.f11907c = null;
            }
        }

        public void m16371f() {
            if (this.f11909e != null) {
                C3253x c3253x = (C3253x) this.f11910f.get();
                if (c3253x != null) {
                    c3253x.f11235g.mo4071a(this.f11905a, this.f11906b, this.f11909e);
                }
                this.f11909e = null;
            }
            if (this.f11906b != null) {
                this.f11905a.eglTerminate(this.f11906b);
                this.f11906b = null;
            }
        }

        private void m16361a(String str) {
            C3356h.m16362a(str, this.f11905a.eglGetError());
        }

        public static void m16362a(String str, int i) {
            throw new RuntimeException(C3356h.m16364b(str, i));
        }

        public static void m16363a(String str, String str2, int i) {
            Log.w(str, C3356h.m16364b(str2, i));
        }

        public static String m16364b(String str, int i) {
            return str + " failed: " + i;
        }
    }

    /* compiled from: GLTextureView */
    class C3357i extends Thread {
        private boolean f11911a;
        private boolean f11912b;
        private boolean f11913c;
        private boolean f11914d;
        private boolean f11915e;
        private boolean f11916f;
        private boolean f11917g;
        private boolean f11918h;
        private boolean f11919i;
        private boolean f11920j;
        private boolean f11921k;
        private int f11922l = 0;
        private int f11923m = 0;
        private int f11924n = 1;
        private boolean f11925o = true;
        private boolean f11926p;
        private ArrayList<Runnable> f11927q = new ArrayList();
        private boolean f11928r = true;
        private C3356h f11929s;
        private WeakReference<C3253x> f11930t;

        C3357i(WeakReference<C3253x> weakReference) {
            this.f11930t = weakReference;
        }

        public void run() {
            setName("GLThread " + getId());
            try {
                m16375j();
            } catch (InterruptedException e) {
            } finally {
                C3253x.f11229a.m16388a(this);
            }
        }

        private void m16373h() {
            if (this.f11919i) {
                this.f11919i = false;
                this.f11929s.m16370e();
            }
        }

        private void m16374i() {
            if (this.f11918h) {
                this.f11929s.m16371f();
                this.f11918h = false;
                C3253x.f11229a.m16393c(this);
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void m16375j() throws java.lang.InterruptedException {
            /*
            r18 = this;
            r1 = new com.amap.api.mapcore.x$h;
            r0 = r18;
            r2 = r0.f11930t;
            r1.<init>(r2);
            r0 = r18;
            r0.f11929s = r1;
            r1 = 0;
            r0 = r18;
            r0.f11918h = r1;
            r1 = 0;
            r0 = r18;
            r0.f11919i = r1;
            r3 = 0;
            r12 = 0;
            r1 = 0;
            r11 = 0;
            r10 = 0;
            r9 = 0;
            r8 = 0;
            r2 = 0;
            r7 = 0;
            r6 = 0;
            r5 = 0;
            r4 = 0;
            r14 = r3;
            r3 = r5;
            r5 = r7;
            r7 = r8;
            r8 = r9;
            r9 = r10;
            r10 = r11;
            r11 = r1;
            r17 = r2;
            r2 = r4;
            r4 = r6;
            r6 = r17;
        L_0x0031:
            r15 = com.amap.api.mapcore.C3253x.f11229a;	 Catch:{ all -> 0x01d5 }
            monitor-enter(r15);	 Catch:{ all -> 0x01d5 }
        L_0x0036:
            r0 = r18;
            r1 = r0.f11911a;	 Catch:{ all -> 0x01d2 }
            if (r1 == 0) goto L_0x004d;
        L_0x003c:
            monitor-exit(r15);	 Catch:{ all -> 0x01d2 }
            r2 = com.amap.api.mapcore.C3253x.f11229a;
            monitor-enter(r2);
            r18.m16373h();	 Catch:{ all -> 0x004a }
            r18.m16374i();	 Catch:{ all -> 0x004a }
            monitor-exit(r2);	 Catch:{ all -> 0x004a }
            return;
        L_0x004a:
            r1 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x004a }
            throw r1;
        L_0x004d:
            r0 = r18;
            r1 = r0.f11927q;	 Catch:{ all -> 0x01d2 }
            r1 = r1.isEmpty();	 Catch:{ all -> 0x01d2 }
            if (r1 != 0) goto L_0x0081;
        L_0x0057:
            r0 = r18;
            r1 = r0.f11927q;	 Catch:{ all -> 0x01d2 }
            r2 = 0;
            r1 = r1.remove(r2);	 Catch:{ all -> 0x01d2 }
            r1 = (java.lang.Runnable) r1;	 Catch:{ all -> 0x01d2 }
            r2 = r6;
            r6 = r4;
            r4 = r1;
            r1 = r11;
            r11 = r10;
            r10 = r9;
            r9 = r8;
            r8 = r7;
            r7 = r5;
            r5 = r3;
        L_0x006c:
            monitor-exit(r15);	 Catch:{ all -> 0x01d2 }
            if (r4 == 0) goto L_0x01f9;
        L_0x006f:
            r4.run();	 Catch:{ all -> 0x01d5 }
            r4 = 0;
            r3 = r5;
            r5 = r7;
            r7 = r8;
            r8 = r9;
            r9 = r10;
            r10 = r11;
            r11 = r1;
            r17 = r2;
            r2 = r4;
            r4 = r6;
            r6 = r17;
            goto L_0x0031;
        L_0x0081:
            r1 = 0;
            r0 = r18;
            r13 = r0.f11914d;	 Catch:{ all -> 0x01d2 }
            r0 = r18;
            r0 = r0.f11913c;	 Catch:{ all -> 0x01d2 }
            r16 = r0;
            r0 = r16;
            if (r13 == r0) goto L_0x02f2;
        L_0x0090:
            r0 = r18;
            r1 = r0.f11913c;	 Catch:{ all -> 0x01d2 }
            r0 = r18;
            r13 = r0.f11913c;	 Catch:{ all -> 0x01d2 }
            r0 = r18;
            r0.f11914d = r13;	 Catch:{ all -> 0x01d2 }
            r13 = com.amap.api.mapcore.C3253x.f11229a;	 Catch:{ all -> 0x01d2 }
            r13.notifyAll();	 Catch:{ all -> 0x01d2 }
            r13 = r1;
        L_0x00a4:
            r0 = r18;
            r1 = r0.f11921k;	 Catch:{ all -> 0x01d2 }
            if (r1 == 0) goto L_0x00b6;
        L_0x00aa:
            r18.m16373h();	 Catch:{ all -> 0x01d2 }
            r18.m16374i();	 Catch:{ all -> 0x01d2 }
            r1 = 0;
            r0 = r18;
            r0.f11921k = r1;	 Catch:{ all -> 0x01d2 }
            r5 = 1;
        L_0x00b6:
            if (r9 == 0) goto L_0x00bf;
        L_0x00b8:
            r18.m16373h();	 Catch:{ all -> 0x01d2 }
            r18.m16374i();	 Catch:{ all -> 0x01d2 }
            r9 = 0;
        L_0x00bf:
            if (r13 == 0) goto L_0x00ca;
        L_0x00c1:
            r0 = r18;
            r1 = r0.f11919i;	 Catch:{ all -> 0x01d2 }
            if (r1 == 0) goto L_0x00ca;
        L_0x00c7:
            r18.m16373h();	 Catch:{ all -> 0x01d2 }
        L_0x00ca:
            if (r13 == 0) goto L_0x00ee;
        L_0x00cc:
            r0 = r18;
            r1 = r0.f11918h;	 Catch:{ all -> 0x01d2 }
            if (r1 == 0) goto L_0x00ee;
        L_0x00d2:
            r0 = r18;
            r1 = r0.f11930t;	 Catch:{ all -> 0x01d2 }
            r1 = r1.get();	 Catch:{ all -> 0x01d2 }
            r1 = (com.amap.api.mapcore.C3253x) r1;	 Catch:{ all -> 0x01d2 }
            if (r1 != 0) goto L_0x01ab;
        L_0x00de:
            r1 = 0;
        L_0x00df:
            if (r1 == 0) goto L_0x00eb;
        L_0x00e1:
            r1 = com.amap.api.mapcore.C3253x.f11229a;	 Catch:{ all -> 0x01d2 }
            r1 = r1.m16390a();	 Catch:{ all -> 0x01d2 }
            if (r1 == 0) goto L_0x00ee;
        L_0x00eb:
            r18.m16374i();	 Catch:{ all -> 0x01d2 }
        L_0x00ee:
            if (r13 == 0) goto L_0x0101;
        L_0x00f0:
            r1 = com.amap.api.mapcore.C3253x.f11229a;	 Catch:{ all -> 0x01d2 }
            r1 = r1.m16391b();	 Catch:{ all -> 0x01d2 }
            if (r1 == 0) goto L_0x0101;
        L_0x00fa:
            r0 = r18;
            r1 = r0.f11929s;	 Catch:{ all -> 0x01d2 }
            r1.m16371f();	 Catch:{ all -> 0x01d2 }
        L_0x0101:
            r0 = r18;
            r1 = r0.f11915e;	 Catch:{ all -> 0x01d2 }
            if (r1 != 0) goto L_0x0127;
        L_0x0107:
            r0 = r18;
            r1 = r0.f11917g;	 Catch:{ all -> 0x01d2 }
            if (r1 != 0) goto L_0x0127;
        L_0x010d:
            r0 = r18;
            r1 = r0.f11919i;	 Catch:{ all -> 0x01d2 }
            if (r1 == 0) goto L_0x0116;
        L_0x0113:
            r18.m16373h();	 Catch:{ all -> 0x01d2 }
        L_0x0116:
            r1 = 1;
            r0 = r18;
            r0.f11917g = r1;	 Catch:{ all -> 0x01d2 }
            r1 = 0;
            r0 = r18;
            r0.f11916f = r1;	 Catch:{ all -> 0x01d2 }
            r1 = com.amap.api.mapcore.C3253x.f11229a;	 Catch:{ all -> 0x01d2 }
            r1.notifyAll();	 Catch:{ all -> 0x01d2 }
        L_0x0127:
            r0 = r18;
            r1 = r0.f11915e;	 Catch:{ all -> 0x01d2 }
            if (r1 == 0) goto L_0x013f;
        L_0x012d:
            r0 = r18;
            r1 = r0.f11917g;	 Catch:{ all -> 0x01d2 }
            if (r1 == 0) goto L_0x013f;
        L_0x0133:
            r1 = 0;
            r0 = r18;
            r0.f11917g = r1;	 Catch:{ all -> 0x01d2 }
            r1 = com.amap.api.mapcore.C3253x.f11229a;	 Catch:{ all -> 0x01d2 }
            r1.notifyAll();	 Catch:{ all -> 0x01d2 }
        L_0x013f:
            if (r6 == 0) goto L_0x014f;
        L_0x0141:
            r7 = 0;
            r6 = 0;
            r1 = 1;
            r0 = r18;
            r0.f11926p = r1;	 Catch:{ all -> 0x01d2 }
            r1 = com.amap.api.mapcore.C3253x.f11229a;	 Catch:{ all -> 0x01d2 }
            r1.notifyAll();	 Catch:{ all -> 0x01d2 }
        L_0x014f:
            r1 = r18.m16376k();	 Catch:{ all -> 0x01d2 }
            if (r1 == 0) goto L_0x01f0;
        L_0x0155:
            r0 = r18;
            r1 = r0.f11918h;	 Catch:{ all -> 0x01d2 }
            if (r1 != 0) goto L_0x015e;
        L_0x015b:
            if (r5 == 0) goto L_0x01b1;
        L_0x015d:
            r5 = 0;
        L_0x015e:
            r0 = r18;
            r1 = r0.f11918h;	 Catch:{ all -> 0x01d2 }
            if (r1 == 0) goto L_0x02ee;
        L_0x0164:
            r0 = r18;
            r1 = r0.f11919i;	 Catch:{ all -> 0x01d2 }
            if (r1 != 0) goto L_0x02ee;
        L_0x016a:
            r1 = 1;
            r0 = r18;
            r0.f11919i = r1;	 Catch:{ all -> 0x01d2 }
            r11 = 1;
            r10 = 1;
            r8 = 1;
            r1 = r8;
            r8 = r10;
        L_0x0174:
            r0 = r18;
            r10 = r0.f11919i;	 Catch:{ all -> 0x01d2 }
            if (r10 == 0) goto L_0x01ee;
        L_0x017a:
            r0 = r18;
            r10 = r0.f11928r;	 Catch:{ all -> 0x01d2 }
            if (r10 == 0) goto L_0x02e4;
        L_0x0180:
            r7 = 1;
            r0 = r18;
            r3 = r0.f11922l;	 Catch:{ all -> 0x01d2 }
            r0 = r18;
            r1 = r0.f11923m;	 Catch:{ all -> 0x01d2 }
            r4 = 1;
            r10 = 1;
            r11 = 0;
            r0 = r18;
            r0.f11928r = r11;	 Catch:{ all -> 0x01d2 }
        L_0x0190:
            r11 = 0;
            r0 = r18;
            r0.f11925o = r11;	 Catch:{ all -> 0x01d2 }
            r11 = com.amap.api.mapcore.C3253x.f11229a;	 Catch:{ all -> 0x01d2 }
            r11.notifyAll();	 Catch:{ all -> 0x01d2 }
            r11 = r8;
            r8 = r4;
            r4 = r2;
            r2 = r6;
            r6 = r3;
            r17 = r1;
            r1 = r10;
            r10 = r9;
            r9 = r7;
            r7 = r5;
            r5 = r17;
            goto L_0x006c;
        L_0x01ab:
            r1 = r1.f11240l;	 Catch:{ all -> 0x01d2 }
            goto L_0x00df;
        L_0x01b1:
            r1 = com.amap.api.mapcore.C3253x.f11229a;	 Catch:{ all -> 0x01d2 }
            r0 = r18;
            r1 = r1.m16392b(r0);	 Catch:{ all -> 0x01d2 }
            if (r1 == 0) goto L_0x015e;
        L_0x01bd:
            r0 = r18;
            r1 = r0.f11929s;	 Catch:{ RuntimeException -> 0x01e3 }
            r1.m16366a();	 Catch:{ RuntimeException -> 0x01e3 }
            r1 = 1;
            r0 = r18;
            r0.f11918h = r1;	 Catch:{ all -> 0x01d2 }
            r12 = 1;
            r1 = com.amap.api.mapcore.C3253x.f11229a;	 Catch:{ all -> 0x01d2 }
            r1.notifyAll();	 Catch:{ all -> 0x01d2 }
            goto L_0x015e;
        L_0x01d2:
            r1 = move-exception;
            monitor-exit(r15);	 Catch:{ all -> 0x01d2 }
            throw r1;	 Catch:{ all -> 0x01d5 }
        L_0x01d5:
            r1 = move-exception;
            r2 = com.amap.api.mapcore.C3253x.f11229a;
            monitor-enter(r2);
            r18.m16373h();	 Catch:{ all -> 0x02db }
            r18.m16374i();	 Catch:{ all -> 0x02db }
            monitor-exit(r2);	 Catch:{ all -> 0x02db }
            throw r1;
        L_0x01e3:
            r1 = move-exception;
            r2 = com.amap.api.mapcore.C3253x.f11229a;	 Catch:{ all -> 0x01d2 }
            r0 = r18;
            r2.m16393c(r0);	 Catch:{ all -> 0x01d2 }
            throw r1;	 Catch:{ all -> 0x01d2 }
        L_0x01ee:
            r10 = r8;
            r8 = r1;
        L_0x01f0:
            r1 = com.amap.api.mapcore.C3253x.f11229a;	 Catch:{ all -> 0x01d2 }
            r1.wait();	 Catch:{ all -> 0x01d2 }
            goto L_0x0036;
        L_0x01f9:
            if (r1 == 0) goto L_0x02e1;
        L_0x01fb:
            r0 = r18;
            r3 = r0.f11929s;	 Catch:{ all -> 0x01d5 }
            r3 = r3.m16367b();	 Catch:{ all -> 0x01d5 }
            if (r3 == 0) goto L_0x02ad;
        L_0x0205:
            r3 = com.amap.api.mapcore.C3253x.f11229a;	 Catch:{ all -> 0x01d5 }
            monitor-enter(r3);	 Catch:{ all -> 0x01d5 }
            r1 = 1;
            r0 = r18;
            r0.f11920j = r1;	 Catch:{ all -> 0x02aa }
            r1 = com.amap.api.mapcore.C3253x.f11229a;	 Catch:{ all -> 0x02aa }
            r1.notifyAll();	 Catch:{ all -> 0x02aa }
            monitor-exit(r3);	 Catch:{ all -> 0x02aa }
            r1 = 0;
            r3 = r1;
        L_0x0219:
            if (r11 == 0) goto L_0x02de;
        L_0x021b:
            r0 = r18;
            r1 = r0.f11929s;	 Catch:{ all -> 0x01d5 }
            r1 = r1.m16368c();	 Catch:{ all -> 0x01d5 }
            r1 = (javax.microedition.khronos.opengles.GL10) r1;	 Catch:{ all -> 0x01d5 }
            r11 = com.amap.api.mapcore.C3253x.f11229a;	 Catch:{ all -> 0x01d5 }
            r11.m16389a(r1);	 Catch:{ all -> 0x01d5 }
            r11 = 0;
            r13 = r1;
        L_0x022e:
            if (r12 == 0) goto L_0x024a;
        L_0x0230:
            r0 = r18;
            r1 = r0.f11930t;	 Catch:{ all -> 0x01d5 }
            r1 = r1.get();	 Catch:{ all -> 0x01d5 }
            r1 = (com.amap.api.mapcore.C3253x) r1;	 Catch:{ all -> 0x01d5 }
            if (r1 == 0) goto L_0x0249;
        L_0x023c:
            r1 = r1.f11232d;	 Catch:{ all -> 0x01d5 }
            r0 = r18;
            r12 = r0.f11929s;	 Catch:{ all -> 0x01d5 }
            r12 = r12.f11908d;	 Catch:{ all -> 0x01d5 }
            r1.onSurfaceCreated(r13, r12);	 Catch:{ all -> 0x01d5 }
        L_0x0249:
            r12 = 0;
        L_0x024a:
            if (r9 == 0) goto L_0x0260;
        L_0x024c:
            r0 = r18;
            r1 = r0.f11930t;	 Catch:{ all -> 0x01d5 }
            r1 = r1.get();	 Catch:{ all -> 0x01d5 }
            r1 = (com.amap.api.mapcore.C3253x) r1;	 Catch:{ all -> 0x01d5 }
            if (r1 == 0) goto L_0x025f;
        L_0x0258:
            r1 = r1.f11232d;	 Catch:{ all -> 0x01d5 }
            r1.onSurfaceChanged(r13, r6, r5);	 Catch:{ all -> 0x01d5 }
        L_0x025f:
            r9 = 0;
        L_0x0260:
            r0 = r18;
            r1 = r0.f11930t;	 Catch:{ all -> 0x01d5 }
            r1 = r1.get();	 Catch:{ all -> 0x01d5 }
            r1 = (com.amap.api.mapcore.C3253x) r1;	 Catch:{ all -> 0x01d5 }
            if (r1 == 0) goto L_0x0273;
        L_0x026c:
            r1 = r1.f11232d;	 Catch:{ all -> 0x01d5 }
            r1.onDrawFrame(r13);	 Catch:{ all -> 0x01d5 }
        L_0x0273:
            r0 = r18;
            r1 = r0.f11929s;	 Catch:{ all -> 0x01d5 }
            r1 = r1.m16369d();	 Catch:{ all -> 0x01d5 }
            switch(r1) {
                case 12288: goto L_0x0297;
                case 12302: goto L_0x02d6;
                default: goto L_0x027e;
            };	 Catch:{ all -> 0x01d5 }
        L_0x027e:
            r14 = "GLThread";
            r15 = "eglSwapBuffers";
            com.amap.api.mapcore.C3253x.C3356h.m16363a(r14, r15, r1);	 Catch:{ all -> 0x01d5 }
            r14 = com.amap.api.mapcore.C3253x.f11229a;	 Catch:{ all -> 0x01d5 }
            monitor-enter(r14);	 Catch:{ all -> 0x01d5 }
            r1 = 1;
            r0 = r18;
            r0.f11916f = r1;	 Catch:{ all -> 0x02d8 }
            r1 = com.amap.api.mapcore.C3253x.f11229a;	 Catch:{ all -> 0x02d8 }
            r1.notifyAll();	 Catch:{ all -> 0x02d8 }
            monitor-exit(r14);	 Catch:{ all -> 0x02d8 }
        L_0x0297:
            if (r8 == 0) goto L_0x02f5;
        L_0x0299:
            r1 = 1;
        L_0x029a:
            r2 = r4;
            r14 = r13;
            r4 = r6;
            r6 = r1;
            r17 = r7;
            r7 = r8;
            r8 = r9;
            r9 = r10;
            r10 = r11;
            r11 = r3;
            r3 = r5;
            r5 = r17;
            goto L_0x0031;
        L_0x02aa:
            r1 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x02aa }
            throw r1;	 Catch:{ all -> 0x01d5 }
        L_0x02ad:
            r3 = com.amap.api.mapcore.C3253x.f11229a;	 Catch:{ all -> 0x01d5 }
            monitor-enter(r3);	 Catch:{ all -> 0x01d5 }
            r13 = 1;
            r0 = r18;
            r0.f11920j = r13;	 Catch:{ all -> 0x02d3 }
            r13 = 1;
            r0 = r18;
            r0.f11916f = r13;	 Catch:{ all -> 0x02d3 }
            r13 = com.amap.api.mapcore.C3253x.f11229a;	 Catch:{ all -> 0x02d3 }
            r13.notifyAll();	 Catch:{ all -> 0x02d3 }
            monitor-exit(r3);	 Catch:{ all -> 0x02d3 }
            r3 = r5;
            r5 = r7;
            r7 = r8;
            r8 = r9;
            r9 = r10;
            r10 = r11;
            r11 = r1;
            r17 = r2;
            r2 = r4;
            r4 = r6;
            r6 = r17;
            goto L_0x0031;
        L_0x02d3:
            r1 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x02d3 }
            throw r1;	 Catch:{ all -> 0x01d5 }
        L_0x02d6:
            r10 = 1;
            goto L_0x0297;
        L_0x02d8:
            r1 = move-exception;
            monitor-exit(r14);	 Catch:{ all -> 0x02d8 }
            throw r1;	 Catch:{ all -> 0x01d5 }
        L_0x02db:
            r1 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x02db }
            throw r1;
        L_0x02de:
            r13 = r14;
            goto L_0x022e;
        L_0x02e1:
            r3 = r1;
            goto L_0x0219;
        L_0x02e4:
            r10 = r11;
            r17 = r4;
            r4 = r7;
            r7 = r1;
            r1 = r3;
            r3 = r17;
            goto L_0x0190;
        L_0x02ee:
            r1 = r8;
            r8 = r10;
            goto L_0x0174;
        L_0x02f2:
            r13 = r1;
            goto L_0x00a4;
        L_0x02f5:
            r1 = r2;
            goto L_0x029a;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.x.i.j():void");
        }

        public boolean m16380a() {
            return this.f11918h && this.f11919i && m16376k();
        }

        private boolean m16376k() {
            return !this.f11914d && this.f11915e && !this.f11916f && this.f11922l > 0 && this.f11923m > 0 && (this.f11925o || this.f11924n == 1);
        }

        public void m16377a(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (C3253x.f11229a) {
                this.f11924n = i;
                C3253x.f11229a.notifyAll();
            }
        }

        public int m16381b() {
            int i;
            synchronized (C3253x.f11229a) {
                i = this.f11924n;
            }
            return i;
        }

        public void m16382c() {
            synchronized (C3253x.f11229a) {
                this.f11925o = true;
                C3253x.f11229a.notifyAll();
            }
        }

        public void m16383d() {
            synchronized (C3253x.f11229a) {
                this.f11915e = true;
                this.f11920j = false;
                C3253x.f11229a.notifyAll();
                while (this.f11917g && !this.f11920j && !this.f11912b) {
                    try {
                        C3253x.f11229a.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void m16384e() {
            synchronized (C3253x.f11229a) {
                this.f11915e = false;
                C3253x.f11229a.notifyAll();
                while (!this.f11917g && !this.f11912b) {
                    try {
                        C3253x.f11229a.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void m16378a(int i, int i2) {
            synchronized (C3253x.f11229a) {
                this.f11922l = i;
                this.f11923m = i2;
                this.f11928r = true;
                this.f11925o = true;
                this.f11926p = false;
                C3253x.f11229a.notifyAll();
                while (!this.f11912b && !this.f11914d && !this.f11926p && m16380a()) {
                    try {
                        C3253x.f11229a.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void m16385f() {
            synchronized (C3253x.f11229a) {
                this.f11911a = true;
                C3253x.f11229a.notifyAll();
                while (!this.f11912b) {
                    try {
                        C3253x.f11229a.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void m16386g() {
            this.f11921k = true;
            C3253x.f11229a.notifyAll();
        }

        public void m16379a(Runnable runnable) {
            if (runnable == null) {
                throw new IllegalArgumentException("r must not be null");
            }
            synchronized (C3253x.f11229a) {
                this.f11927q.add(runnable);
                C3253x.f11229a.notifyAll();
            }
        }
    }

    /* compiled from: GLTextureView */
    class C3358j {
        private static String f11931a = "GLThreadManager";
        private boolean f11932b;
        private int f11933c;
        private boolean f11934d;
        private boolean f11935e;
        private boolean f11936f;
        private C3357i f11937g;

        private C3358j() {
        }

        public synchronized void m16388a(C3357i c3357i) {
            c3357i.f11912b = true;
            if (this.f11937g == c3357i) {
                this.f11937g = null;
            }
            notifyAll();
        }

        public boolean m16392b(C3357i c3357i) {
            if (this.f11937g == c3357i || this.f11937g == null) {
                this.f11937g = c3357i;
                notifyAll();
                return true;
            }
            m16387c();
            if (this.f11935e) {
                return true;
            }
            if (this.f11937g != null) {
                this.f11937g.m16386g();
            }
            return false;
        }

        public void m16393c(C3357i c3357i) {
            if (this.f11937g == c3357i) {
                this.f11937g = null;
            }
            notifyAll();
        }

        public synchronized boolean m16390a() {
            return this.f11936f;
        }

        public synchronized boolean m16391b() {
            m16387c();
            return !this.f11935e;
        }

        public synchronized void m16389a(GL10 gl10) {
            boolean z = true;
            synchronized (this) {
                if (!this.f11934d) {
                    m16387c();
                    String glGetString = gl10.glGetString(7937);
                    if (this.f11933c < 131072) {
                        this.f11935e = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    if (this.f11935e) {
                        z = false;
                    }
                    this.f11936f = z;
                    this.f11934d = true;
                }
            }
        }

        private void m16387c() {
            if (!this.f11932b) {
                this.f11933c = 131072;
                if (this.f11933c >= 131072) {
                    this.f11935e = true;
                }
                this.f11932b = true;
            }
        }
    }

    /* compiled from: GLTextureView */
    public interface C3359k {
        GL m16394a(GL gl);
    }

    /* compiled from: GLTextureView */
    class C3360l extends Writer {
        private StringBuilder f11938a = new StringBuilder();

        C3360l() {
        }

        public void close() {
            m16395a();
        }

        public void flush() {
            m16395a();
        }

        public void write(char[] cArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                char c = cArr[i + i3];
                if (c == '\n') {
                    m16395a();
                } else {
                    this.f11938a.append(c);
                }
            }
        }

        private void m16395a() {
            if (this.f11938a.length() > 0) {
                Log.v("GLSurfaceView", this.f11938a.toString());
                this.f11938a.delete(0, this.f11938a.length());
            }
        }
    }

    /* compiled from: GLTextureView */
    class C3361m extends C3351b {
        final /* synthetic */ C3253x f11939j;

        public C3361m(C3253x c3253x, boolean z) {
            int i;
            this.f11939j = c3253x;
            if (z) {
                i = 16;
            } else {
                i = 0;
            }
            super(c3253x, 8, 8, 8, 0, i, 0);
        }
    }

    public C3253x(Context context) {
        super(context);
        mo3978a();
    }

    public C3253x(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo3978a();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.f11231c != null) {
                this.f11231c.m16385f();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    private void mo3978a() {
        setSurfaceTextureListener(this);
    }

    public void setRenderer(Renderer renderer) {
        m15271c();
        if (this.f11234f == null) {
            this.f11234f = new C3361m(this, true);
        }
        if (this.f11235g == null) {
            this.f11235g = new C3353c();
        }
        if (this.f11236h == null) {
            this.f11236h = new C3355d();
        }
        this.f11232d = renderer;
        this.f11231c = new C3357i(this.f11230b);
        this.f11231c.start();
    }

    public void setRenderMode(int i) {
        this.f11231c.m16377a(i);
    }

    public void requestRender() {
        this.f11231c.m16382c();
    }

    public void queueEvent(Runnable runnable) {
        this.f11231c.m16379a(runnable);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f11233e && this.f11232d != null) {
            int b;
            if (this.f11231c != null) {
                b = this.f11231c.m16381b();
            } else {
                b = 1;
            }
            this.f11231c = new C3357i(this.f11230b);
            if (b != 1) {
                this.f11231c.m16377a(b);
            }
            this.f11231c.start();
        }
        this.f11233e = false;
    }

    protected void onDetachedFromWindow() {
        if (this.f11231c != null) {
            this.f11231c.m16385f();
        }
        this.f11233e = true;
        super.onDetachedFromWindow();
    }

    private void m15271c() {
        if (this.f11231c != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f11231c.m16383d();
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f11231c.m16384e();
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f11231c.m16378a(i, i2);
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        onSurfaceTextureSizeChanged(getSurfaceTexture(), i3 - i, i4 - i2);
        super.onLayout(z, i, i2, i3, i4);
    }
}
