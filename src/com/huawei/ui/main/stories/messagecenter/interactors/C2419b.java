package com.huawei.ui.main.stories.messagecenter.interactors;

import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import com.huawei.pluginmessagecenter.a.g;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: ADNotificationInterActor */
class C2419b extends AsyncTask<String, Void, Bitmap> {
    Context f8702a;
    String f8703b;
    String f8704c;
    int f8705d;
    final /* synthetic */ C2418a f8706e;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m12162a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m12163a((Bitmap) obj);
    }

    public C2419b(C2418a c2418a, Context context) {
        this.f8706e = c2418a;
        this.f8702a = context;
    }

    protected Bitmap m12162a(String... strArr) {
        g.a("ImageHandler", "doInBackground start");
        this.f8703b = strArr[0];
        g.a("ImageHandler", "doInBackground | imageURL = " + this.f8703b);
        this.f8704c = strArr[1];
        g.a("ImageHandler", "doInBackground | msgTitle = " + this.f8704c);
        this.f8705d = Integer.parseInt(strArr[2]);
        try {
            if ("".equals(this.f8703b)) {
                return null;
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f8703b).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            return BitmapFactory.decodeStream(httpURLConnection.getInputStream());
        } catch (MalformedURLException e) {
            g.a("ImageHandler", "doInBackground | MalformedURLException " + e.getMessage());
            return null;
        } catch (IOException e2) {
            g.a("ImageHandler", "doInBackground | IOException " + e2.getMessage());
            return null;
        }
    }

    protected void m12163a(Bitmap bitmap) {
        g.a("ImageHandler", "onPostExecute start");
        super.onPostExecute(bitmap);
        if (bitmap != null) {
            this.f8706e.f8701d.setLargeIcon(bitmap).build();
        } else {
            this.f8706e.f8701d.build();
        }
        ((NotificationManager) this.f8702a.getSystemService("notification")).notify(this.f8705d, this.f8706e.f8701d.build());
        g.a("ImageHandler", "showNotification end | issue notification of AD \"" + this.f8704c + "\"");
        g.a("ImageHandler", "onPostExecute end");
    }
}
