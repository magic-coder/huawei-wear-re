package com.huawei.crowdtestsdk.devices;

import android.content.Context;
import android.database.Cursor;
import com.huawei.androidcommon.utils.IOUtils;
import com.huawei.crowdtestsdk.constants.FeedbackProjectConstants;
import com.huawei.uploadlog.p188c.C2511g;
import com.huawei.uploadlog.p188c.C2513i;

public class DeviceFactory {
    public static final int PROD_TYPE_UNKOWN = -1;
    public static final int PROD_TYPE_WEARABLE = 1;

    public static CommonDevice getMyDevice(DeviceHelper deviceHelper) {
        if (deviceHelper == null) {
            return new UnknownDevice();
        }
        int prodType = deviceHelper.getProdType();
        String prodConnType = deviceHelper.getProdConnType();
        int prodSpecificCode = deviceHelper.getProdSpecificCode();
        String prodSpecificName = deviceHelper.getProdSpecificName();
        C2511g.m12481b("BETACLUB_SDK", String.format("[DeviceFactory.getMyDevice]prodType,prodConnType,prodSpecificCode,prodSpecificName are %d,%s,%d,%s", new Object[]{Integer.valueOf(prodType), prodConnType, Integer.valueOf(prodSpecificCode), prodSpecificName}));
        switch (prodType) {
            case -1:
                C2511g.m12481b("BETACLUB_SDK", "[DeviceFactory.getMyDevice]unknown device");
                return new UnknownDevice();
            default:
                C2511g.m12481b("BETACLUB_SDK", "[DeviceFactory.getMyDevice]unknown");
                return new UnknownDevice(deviceHelper);
        }
    }

    public static CommonDevice getDeviceByProjectIdFromLocal(Context context, String str) {
        CommonDevice commonDevice;
        Object obj;
        Throwable th;
        UnknownDevice unknownDevice;
        C2511g.m12481b("BETACLUB_SDK", "[DeviceFactory.getDeviceByProjectIdFromLocal]start...");
        CommonDevice commonDevice2;
        try {
            Cursor query = context.getContentResolver().query(FeedbackProjectConstants.CONTENT_URI_PROJECT, null, "project_id = " + str, null, null);
            if (query == null || query.getCount() <= 0) {
                commonDevice = null;
            } else {
                query.moveToFirst();
                commonDevice2 = null;
                while (!query.isAfterLast()) {
                    try {
                        commonDevice2 = getMyDevice(C2513i.m12492a(query.getBlob(7)));
                        C2511g.m12481b("BETACLUB_SDK", "[DeviceFactory.getDeviceByProjectIdFromLocal] device.getProductName : " + commonDevice2.getProductName());
                        query.moveToNext();
                    } catch (Exception e) {
                        Exception exception = e;
                        commonDevice = commonDevice2;
                        obj = exception;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                commonDevice = commonDevice2;
            }
            try {
                IOUtils.close(query);
                if (commonDevice == null) {
                    commonDevice = new UnknownDevice();
                }
            } catch (Exception e2) {
                obj = e2;
                try {
                    C2511g.m12481b("BETACLUB_SDK", "getDeviceByProjectIdFromLocal error : " + obj);
                    if (commonDevice == null) {
                        commonDevice = new UnknownDevice();
                    }
                    return getMyDevice(commonDevice.getDeviceHelper());
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    commonDevice2 = commonDevice;
                    th = th4;
                    if (commonDevice2 == null) {
                        unknownDevice = new UnknownDevice();
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            Exception exception2 = e3;
            commonDevice = null;
            C2511g.m12481b("BETACLUB_SDK", "getDeviceByProjectIdFromLocal error : " + obj);
            if (commonDevice == null) {
                commonDevice = new UnknownDevice();
            }
            return getMyDevice(commonDevice.getDeviceHelper());
        } catch (Throwable th5) {
            th = th5;
            commonDevice2 = null;
            if (commonDevice2 == null) {
                unknownDevice = new UnknownDevice();
            }
            throw th;
        }
        return getMyDevice(commonDevice.getDeviceHelper());
    }
}
