package com.huawei.nfc.carrera.logic.cardoperate.impl;

import android.content.Context;
import android.os.Handler;
import android.util.SparseArray;
import com.huawei.nfc.carrera.constant.Constant;
import com.huawei.nfc.carrera.logic.cardoperate.bus.TrafficCardOperator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.fm.FMTrafficCardOperatorImpl;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.serveraccess.ServerAccessImp;
import com.huawei.nfc.carrera.logic.cardoperate.bus.task.snb.SNBTrafficCardOperatorImpl;
import com.huawei.nfc.carrera.logic.cardoperate.citic.CITICCardOperator;
import com.huawei.nfc.carrera.logic.cardoperate.cmb.CMBCardOperator;
import com.huawei.nfc.carrera.logic.cardoperate.cup.CUPCardOperator;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import java.util.ArrayList;
import java.util.List;

public class SPIOperatorManager {
    private CITICCardOperator citicCardOperator;
    private CMBCardOperator cmbCardOperator;
    private CUPCardOperator cupCardOperator;
    private final Object lock = new Object();
    private Context mContext;
    private SparseArray<TrafficCardOperator> mTrafficCardOperators = new SparseArray();
    private Handler operateHandler;

    public SPIOperatorManager(Context context, Handler handler) {
        this.mContext = context;
        this.operateHandler = handler;
        this.mTrafficCardOperators.put(14, new FMTrafficCardOperatorImpl(context));
        this.mTrafficCardOperators.put(22, new SNBTrafficCardOperatorImpl(context));
        this.mTrafficCardOperators.put(20, new ServerAccessImp(context));
    }

    public CUPCardOperator getCUPOperator() {
        CUPCardOperator cUPCardOperator;
        synchronized (this.lock) {
            if (this.cupCardOperator == null) {
                this.cupCardOperator = new CUPCardOperator(this.mContext, this.operateHandler);
            }
            cUPCardOperator = this.cupCardOperator;
        }
        return cUPCardOperator;
    }

    public CMBCardOperator getCMBOperator() {
        CMBCardOperator cMBCardOperator;
        synchronized (this.lock) {
            if (this.cmbCardOperator == null) {
                this.cmbCardOperator = new CMBCardOperator(this.mContext, this.operateHandler);
            }
            cMBCardOperator = this.cmbCardOperator;
        }
        return cMBCardOperator;
    }

    public CITICCardOperator getCITICOperator() {
        CITICCardOperator cITICCardOperator;
        synchronized (this.lock) {
            if (this.citicCardOperator == null) {
                this.citicCardOperator = new CITICCardOperator(this.mContext, this.operateHandler);
            }
            cITICCardOperator = this.citicCardOperator;
        }
        return cITICCardOperator;
    }

    public TrafficCardOperator getTrafficCardOpertor(int i) {
        TrafficCardOperator trafficCardOperator;
        synchronized (this.lock) {
            trafficCardOperator = (TrafficCardOperator) this.mTrafficCardOperators.get(i);
        }
        return trafficCardOperator;
    }

    public List<Integer> getSupportModeList() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11));
        arrayList.add(Integer.valueOf(12));
        arrayList.add(Integer.valueOf(13));
        return arrayList;
    }

    public boolean isCiticMode(int i) {
        return 11 == i;
    }

    public boolean isCiticMode(int i, String str) {
        boolean z = false;
        synchronized (this.lock) {
            if (i == 11) {
                TACardInfo card = WalletTaManager.getInstance(this.mContext).getCard(str);
                if (card != null && Constant.CITIC_CARD_AID.equals(card.getAid())) {
                    z = true;
                }
            }
        }
        return z;
    }

    public boolean isCmbMode(int i) {
        return 12 == i;
    }

    public boolean isCupMode(int i) {
        return 13 == i;
    }

    public boolean isFmMode(int i) {
        return 14 == i;
    }
}
