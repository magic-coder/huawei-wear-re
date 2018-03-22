package com.huawei.crowdtestsdk.utils;

import android.app.Activity;
import com.huawei.uploadlog.p188c.C2511g;
import java.lang.ref.WeakReference;
import java.util.Stack;

public class ActivityManagerUtils {
    private static Stack<WeakReference<Activity>> mStack = new Stack();
    private static ActivityManagerUtils sInstance;

    private ActivityManagerUtils() {
    }

    public static ActivityManagerUtils getInstance() {
        if (sInstance == null) {
            sInstance = new ActivityManagerUtils();
        }
        return sInstance;
    }

    public void addActivity(Activity activity) {
        mStack.add(new WeakReference(activity));
    }

    public void removeActivity(Activity activity) {
        int size = mStack.size() - 1;
        while (size >= 0) {
            if (mStack.get(size) != null && ((WeakReference) mStack.get(size)).get() == activity) {
                mStack.remove(size);
            }
            size--;
        }
    }

    public void finishAllActivity() {
        C2511g.m12481b("BETACLUB_SDK", "[ActivityManagerUtils.finishAllActivity] is called!");
        for (int size = mStack.size() - 1; size >= 0; size--) {
            WeakReference weakReference = (WeakReference) mStack.get(size);
            if (weakReference != null) {
                Activity activity = (Activity) weakReference.get();
                if (activity != null) {
                    activity.finish();
                }
            }
        }
    }
}
