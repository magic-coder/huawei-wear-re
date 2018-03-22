package com.huawei.hms.support.api.client;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import java.util.Arrays;

public final class Status {
    public static final Status CoreException = new Status(500);
    public static final Status FAILURE = new Status(1);
    public static final Status MessageNotFound = new Status(HttpStatus.SC_NOT_FOUND);
    public static final Status SUCCESS = new Status(0);
    private int f1375a;
    private String f1376b;
    private final PendingIntent f1377c;

    public Status(int i) {
        this(i, null);
    }

    public Status(int i, String str) {
        this(i, str, null);
    }

    public Status(int i, String str, PendingIntent pendingIntent) {
        this.f1375a = i;
        this.f1376b = str;
        this.f1377c = pendingIntent;
    }

    public boolean hasResolution() {
        return this.f1377c != null;
    }

    public void startResolutionForResult(Activity activity, int i) throws SendIntentException {
        if (hasResolution()) {
            activity.startIntentSenderForResult(this.f1377c.getIntentSender(), i, null, 0, 0, 0);
        }
    }

    public int getStatusCode() {
        return this.f1375a;
    }

    public String getStatusMessage() {
        return this.f1376b;
    }

    public PendingIntent getResolution() {
        return this.f1377c;
    }

    public boolean isSuccess() {
        return this.f1375a <= 0;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f1375a), this.f1376b, this.f1377c});
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        if (this.f1375a == status.f1375a && m3072a(this.f1376b, status.f1376b) && m3072a(this.f1377c, status.f1377c)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "{statusCode: " + this.f1375a + ", " + "statusMessage: " + this.f1376b + ", " + "pendingIntent: " + this.f1377c + ", " + "}";
    }

    private static boolean m3072a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
