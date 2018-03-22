package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.C0550m;
import java.io.IOException;
import java.io.InputStream;

public class C0551k implements C0550m {
    private final Status f1060a;
    private volatile ParcelFileDescriptor f1061b;
    private volatile InputStream f1062c;
    private volatile boolean f1063d = false;

    public C0551k(Status status, ParcelFileDescriptor parcelFileDescriptor) {
        this.f1060a = status;
        this.f1061b = parcelFileDescriptor;
    }

    public void mo1750a() {
        if (this.f1061b != null) {
            if (this.f1063d) {
                throw new IllegalStateException("releasing an already released result.");
            }
            try {
                if (this.f1062c != null) {
                    this.f1062c.close();
                } else {
                    this.f1061b.close();
                }
                this.f1063d = true;
                this.f1061b = null;
                this.f1062c = null;
            } catch (IOException e) {
            }
        }
    }

    public InputStream mo2022b() {
        if (this.f1063d) {
            throw new IllegalStateException("Cannot access the input stream after release().");
        } else if (this.f1061b == null) {
            return null;
        } else {
            if (this.f1062c == null) {
                this.f1062c = new AutoCloseInputStream(this.f1061b);
            }
            return this.f1062c;
        }
    }

    public Status getStatus() {
        return this.f1060a;
    }
}
