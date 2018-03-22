package android.support.graphics.drawable;

import android.graphics.Path;
import android.support.graphics.drawable.PathParser.PathDataNode;
import android.util.Log;
import com.huawei.hwid.core.constants.HwAccountConstants;

/* compiled from: VectorDrawableCompat */
class C0009m {
    protected PathDataNode[] f43m = null;
    String f44n;
    int f45o;

    public void m23a(int i) {
        String str = "";
        for (int i2 = 0; i2 < i; i2++) {
            str = str + "    ";
        }
        Log.v("VectorDrawableCompat", str + "current path is :" + this.f44n + " pathData is " + m22a(this.f43m));
    }

    public String m22a(PathDataNode[] pathDataNodeArr) {
        String str = HwAccountConstants.BLANK;
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            String str2 = str + pathDataNodeArr[i].type + ":";
            str = str2;
            for (float f : pathDataNodeArr[i].params) {
                str = str + f + ",";
            }
        }
        return str;
    }

    public C0009m(C0009m c0009m) {
        this.f44n = c0009m.f44n;
        this.f45o = c0009m.f45o;
        this.f43m = PathParser.m14a(c0009m.f43m);
    }

    public void m24a(Path path) {
        path.reset();
        if (this.f43m != null) {
            PathDataNode.nodesToPath(this.f43m, path);
        }
    }

    public String m26b() {
        return this.f44n;
    }

    public boolean mo22a() {
        return false;
    }
}
