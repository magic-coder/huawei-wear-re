package com.huawei.nfc.carrera.logic.spi;

import android.content.Context;
import com.huawei.nfc.carrera.logic.spi.citic.CITICService;
import com.huawei.nfc.carrera.logic.spi.citic.impl.CITICServiceImpl;
import com.huawei.nfc.carrera.logic.spi.cmb.CMBService;
import com.huawei.nfc.carrera.logic.spi.cmb.impl.CMBServiceImpl;
import com.huawei.nfc.carrera.logic.spi.fm.FMService;
import com.huawei.nfc.carrera.logic.spi.fm.impl.FMAIDUtil;
import com.huawei.nfc.carrera.logic.spi.fm.impl.FMServiceImpl;
import com.huawei.nfc.carrera.logic.spi.serveraccess.ServerAccessService;
import com.huawei.nfc.carrera.logic.spi.serveraccess.impl.ServerAccessServiceImpl;
import com.huawei.nfc.carrera.logic.spi.snb.SNBService;
import com.huawei.nfc.carrera.logic.spi.snb.impl.SNBServiceImpl;
import com.huawei.nfc.carrera.logic.spi.tsm.LaserTSMService;
import com.huawei.nfc.carrera.logic.spi.tsm.laser.LaserTSMServiceImpl;
import com.huawei.nfc.carrera.logic.spi.unionpay.CUPService;
import com.huawei.nfc.carrera.logic.spi.unionpay.impl.CUPServiceImp;
import com.huawei.nfc.carrera.util.LogX;

public class SPIServiceFactory {
    public static LaserTSMService createLaserTSMService(Context context) {
        return LaserTSMServiceImpl.getInstance(context);
    }

    public static CITICService createCITICService(Context context) {
        return new CITICServiceImpl(context);
    }

    public static CUPService createUPService(Context context) {
        return new CUPServiceImp(context);
    }

    public static CMBService createCMBService(Context context) {
        return new CMBServiceImpl(context);
    }

    public static FMService createFMService(Context context, String str) {
        LogX.i("createFMService myAid : " + str);
        FMAIDUtil.setAid(str);
        return FMServiceImpl.getInstance(context);
    }

    public static SNBService createSNBService(Context context) {
        return SNBServiceImpl.getSNBServiceInstance(context);
    }

    public static ServerAccessService createServerAccessService(Context context) {
        LogX.i("createServerAccessService start");
        return ServerAccessServiceImpl.getInstance(context);
    }
}
