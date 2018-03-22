package com.amap.api.services.help;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.C3409d;
import com.amap.api.services.core.C3413h;
import com.amap.api.services.core.C3414i;
import com.amap.api.services.core.C3418l;
import com.amap.api.services.core.C3428p;
import java.util.ArrayList;
import java.util.List;

public final class Inputtips {
    private Context f12608a;
    private InputtipsListener f12609b;
    private Handler f12610c = C3428p.m16969a();

    public interface InputtipsListener {
        void onGetInputtips(List<Tip> list, int i);
    }

    public Inputtips(Context context, InputtipsListener inputtipsListener) {
        this.f12608a = context.getApplicationContext();
        this.f12609b = inputtipsListener;
    }

    public void requestInputtips(final String str, final String str2) throws AMapException {
        if (str == null || str.equals("")) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        C3418l.m16960a(this.f12608a);
        new Thread(this) {
            final /* synthetic */ Inputtips f12607c;

            public void run() {
                C3413h c3413h = new C3413h(this.f12607c.f12608a, new C3414i(str, str2));
                Message obtainMessage = C3428p.m16969a().obtainMessage();
                obtainMessage.obj = this.f12607c.f12609b;
                obtainMessage.arg1 = 5;
                try {
                    ArrayList arrayList = (ArrayList) c3413h.m16577g();
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("result", arrayList);
                    obtainMessage.setData(bundle);
                    obtainMessage.what = 0;
                } catch (Throwable e) {
                    C3409d.m16881a(e, "Inputtips", "requestInputtips");
                    obtainMessage.what = e.getErrorCode();
                } finally {
                    this.f12607c.f12610c.sendMessage(obtainMessage);
                }
            }
        }.start();
    }
}
