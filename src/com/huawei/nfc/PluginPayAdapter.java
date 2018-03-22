package com.huawei.nfc;

import com.huawei.ah.C0640b;
import java.util.List;
import java.util.Map;

public interface PluginPayAdapter extends C0640b {
    public static final String KEY_DEVICE_INFO_BT_VERSION = "BT_version";
    public static final String KEY_DEVICE_INFO_MODEL = "device_model";
    public static final String KEY_DEVICE_INFO_SN = "device_sn";
    public static final String KEY_DEVICE_INFO_SOFT_VERSION = "soft_version";
    public static final String KEY_OPEN_CHANNEL_APDU = "apdu";
    public static final String KEY_OPEN_CHANNEL_ID = "channelID";

    boolean addBusCard(String str, String str2, String str3);

    boolean addCard2Watch(String str);

    void cardEvent(String str, int i);

    void closeChannel();

    void closeChannelSNB();

    boolean deleteCard(String str);

    String getBTCInfoResponse();

    String getCplc();

    int getDeviceBTType();

    int getDeviceConnectState();

    Map<String, String> getDeviceInfo();

    int getDeviceProtocol();

    int getLockscreenStatus();

    String getUserID();

    String getWalletAbility();

    boolean notificationOpenPageOfBand(String str);

    boolean notifyAfterTransferFile(List<Map<String, Object>> list);

    List<String> obtainCardList();

    Map<String, String> openChannel(String str, int i);

    byte[] openChannelSNB(byte[] bArr, int i);

    int sendAccount(String str);

    String sendApdu(String str, String str2);

    void sendFile(String str);

    byte[] transmitSNB(byte[] bArr);

    boolean updateCardInfo(String str);
}
