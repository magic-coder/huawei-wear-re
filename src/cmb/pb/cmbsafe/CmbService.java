package cmb.pb.cmbsafe;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class CmbService extends Service {
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onStart(Intent intent, int i) {
        try {
            C2862b.m12958a().getClass().getMethod(C2862b.m12962b(), new Class[0]).invoke(C2862b.m12958a(), new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
