package com.huawei.ui.device.activity.update;

import android.os.Handler;
import android.os.Message;
import com.huawei.hwbasemgr.C0956c;
import com.huawei.hwdevicedfxmanager.constants.HWDeviceDFXConstants;
import com.huawei.p190v.C2538c;
import com.huawei.ui.device.i;
import java.lang.ref.WeakReference;

/* compiled from: DeviceOtaActivity */
class C2171e extends Handler {
    WeakReference<DeviceOtaActivity> f7751a;

    C2171e(DeviceOtaActivity deviceOtaActivity) {
        this.f7751a = new WeakReference(deviceOtaActivity);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        DeviceOtaActivity deviceOtaActivity = (DeviceOtaActivity) this.f7751a.get();
        if (deviceOtaActivity != null) {
            switch (message.what) {
                case 4:
                    C2538c.m12677c("DeviceOtaActivity", "MSG_UPGRADE_PROGRESS msg.arg1 = " + message.arg1);
                    deviceOtaActivity.m11112b(message.arg1);
                    return;
                case 5:
                    if (deviceOtaActivity.f7712z) {
                        C2538c.m12677c("DeviceOtaActivity", "is already failed");
                        return;
                    }
                    deviceOtaActivity.m11119e();
                    C2538c.m12677c("DeviceOtaActivity", "MSG_UPGRADE_SUCCESS");
                    return;
                case 6:
                    String format;
                    C2538c.m12677c("DeviceOtaActivity", "MSG_UPGRADE_FAILED msg.arg1 = " + message.arg1);
                    switch (message.arg1) {
                        case 1:
                            format = String.format(deviceOtaActivity.f7688a.getString(i.IDS_settings_firmware_upgrade_band_upgrade_timeout), new Object[]{deviceOtaActivity.f7706s.f6875j.getDeviceName()});
                            break;
                        case 1002:
                            format = deviceOtaActivity.f7688a.getString(i.IDS_settings_firmware_upgrade_crc_check_failed);
                            break;
                        case HWDeviceDFXConstants.ERROR_CODE_NUMBER_BATTERY_LOW_POWE /*104002*/:
                        case 109002:
                            format = C0956c.m3344a((double) DeviceOtaActivity.f7684w, 2, 0);
                            C2538c.m12677c("DeviceOtaActivity", "battery : " + format);
                            format = String.format(deviceOtaActivity.f7688a.getString(i.IDS_settings_firmware_upgrade_low_battery), new Object[]{deviceOtaActivity.f7706s.f6875j.getDeviceName(), format});
                            break;
                        case 104003:
                            format = deviceOtaActivity.f7688a.getString(i.IDS_settings_firmware_upgrade_file_not_exist);
                            break;
                        case 104007:
                            format = deviceOtaActivity.f7688a.getString(i.IDS_music_management_disconnection);
                            break;
                        default:
                            format = deviceOtaActivity.f7688a.getString(i.IDS_settings_firmware_upgrade_talk_band_failed);
                            break;
                    }
                    deviceOtaActivity.m11108a(format);
                    return;
                default:
                    return;
            }
        }
    }
}
