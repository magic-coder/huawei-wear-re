package com.android.internal.telephony;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import android.telephony.NeighboringCellInfo;
import java.util.List;

public interface ITelephony extends IInterface {
    void answerRingingCall() throws RemoteException;

    void call(String str) throws RemoteException;

    void cancelMissedCallsNotification() throws RemoteException;

    void dial(String str) throws RemoteException;

    int disableApnType(String str) throws RemoteException;

    boolean disableDataConnectivity() throws RemoteException;

    void disableLocationUpdates() throws RemoteException;

    int enableApnType(String str) throws RemoteException;

    boolean enableDataConnectivity() throws RemoteException;

    void enableLocationUpdates() throws RemoteException;

    boolean endCall() throws RemoteException;

    boolean endCallForSubscriber(int i) throws RemoteException;

    int getActivePhoneType() throws RemoteException;

    int getCallState() throws RemoteException;

    int getCdmaEriIconIndex() throws RemoteException;

    int getCdmaEriIconMode() throws RemoteException;

    String getCdmaEriText() throws RemoteException;

    Bundle getCellLocation() throws RemoteException;

    int getDataActivity() throws RemoteException;

    int getDataState() throws RemoteException;

    int getLteOnCdmaMode() throws RemoteException;

    List<NeighboringCellInfo> getNeighboringCellInfo() throws RemoteException;

    int getNetworkType() throws RemoteException;

    int getVoiceMessageCount() throws RemoteException;

    boolean handlePinMmi(String str) throws RemoteException;

    boolean hasIccCard() throws RemoteException;

    boolean isDataConnectivityPossible() throws RemoteException;

    boolean isIdle() throws RemoteException;

    boolean isOffhook() throws RemoteException;

    boolean isRadioOn() throws RemoteException;

    boolean isRinging() throws RemoteException;

    boolean isSimPinEnabled() throws RemoteException;

    boolean needsOtaServiceProvisioning() throws RemoteException;

    boolean setRadio(boolean z) throws RemoteException;

    boolean showCallScreen() throws RemoteException;

    boolean showCallScreenWithDialpad(boolean z) throws RemoteException;

    void silenceRinger() throws RemoteException;

    boolean supplyPin(String str) throws RemoteException;

    boolean supplyPuk(String str, String str2) throws RemoteException;

    void toggleRadioOnOff() throws RemoteException;

    void updateServiceLocation() throws RemoteException;
}
