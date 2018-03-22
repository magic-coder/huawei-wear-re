package com.autonavi.amap.mapcore;

import com.huawei.hwid.core.constants.HwAccountConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class NormalMapLoader extends BaseMapLoader {
    public NormalMapLoader(MapCore mapCore, BaseMapCallImplement baseMapCallImplement, int i) {
        this.datasource = i;
        this.mGLMapEngine = mapCore;
        this.mMapCallback = baseMapCallImplement;
        this.createtime = System.currentTimeMillis();
    }

    public String getGridParmaV4() {
        String str = ";";
        int i = 0;
        String str2 = null;
        while (i < this.mapTiles.size()) {
            String str3;
            String gridName = ((MapSourceGridData) this.mapTiles.get(i)).getGridName();
            if (gridName == null || gridName.length() == 0 || containllegal(gridName)) {
                str3 = str2;
            } else if (isAssic(gridName)) {
                if (this.datasource != 4 || ((MapSourceGridData) this.mapTiles.get(i)).obj == null) {
                    str3 = gridName;
                } else {
                    try {
                        str3 = gridName + "-" + URLEncoder.encode((String) ((MapSourceGridData) this.mapTiles.get(i)).obj, "utf-8");
                    } catch (UnsupportedEncodingException e) {
                        str3 = str2;
                    }
                }
                str3 = str2 == null ? str3 + str : str2 + str3 + str;
            } else {
                str3 = str2;
            }
            i++;
            str2 = str3;
        }
        if (str2 == null) {
            return null;
        }
        if (str2.length() > 0) {
            str3 = str2;
            while (str3 != null && (str3.endsWith(str) || str3.endsWith(HwAccountConstants.BLANK))) {
                str3 = str2.substring(0, str3.length() - 1);
            }
            str2 = str3;
        }
        if (str2.length() <= 0) {
            return null;
        }
        if (this.datasource == 0) {
            return "mapdataver=5&type=20&mesh=" + str2;
        }
        if (this.datasource == 1) {
            return "mapdataver=5&type=11&mesh=" + str2;
        }
        if (this.datasource == 7) {
            return "mapdataver=5&type=1&mesh=" + str2;
        }
        if (this.datasource == 8) {
            return "mapdataver=5&type=13&mesh=" + str2;
        }
        if (this.datasource == 9) {
            return "mapdataver=5&type=40&mesh=" + str2;
        }
        if (this.datasource == 2) {
            return "t=BMPBM&mapdataver=5&mesh=" + str2;
        }
        if (this.datasource == 3) {
            return "mapdataver=5&mesh=" + str2;
        }
        if (this.datasource == 4) {
            return "mapdataver=5&v=6.0.0&bver=2&mesh=" + str2;
        }
        if (this.datasource == 6) {
            return "t=VMMV3&mapdataver=5&type=mod&cp=0&mid=" + str2;
        }
        return null;
    }

    protected String getGridParma() {
        return getGridParmaV4();
    }

    protected String getMapSvrPath() {
        switch (this.datasource) {
            case 0:
            case 1:
            case 7:
            case 8:
            case 9:
                return "/ws/mps/vmap?";
            case 2:
            case 6:
                return "/amapsrv/MPS?";
            case 3:
                return "/ws/mps/smap?";
            case 4:
                return "/ws/mps/rtt?";
            default:
                return null;
        }
    }

    protected String getMapAddress() {
        return this.mMapCallback.getMapSvrAddress();
    }

    public boolean isRequestValid() {
        return this.mMapCallback.isGridsInScreen(this.mapTiles, this.datasource);
    }

    protected void processRecivedVersionOrScenicWidgetData() {
        if (this.datasource == 9) {
            processRecivedVersionData(this.recievedDataBuffer, 0, this.recievedDataSize);
        }
    }

    protected void processRecivedDataByType() {
        if (this.datasource == 0 || this.datasource == 1 || this.datasource == 8 || this.datasource == 7) {
            processReceivedDataV4();
        } else {
            super.processRecivedData();
        }
    }

    protected boolean processReceivedDataHeader(int i) {
        if (this.recievedDataSize <= 7) {
            return false;
        }
        if (Convert.getInt(this.recievedDataBuffer, 0) != 0) {
            doCancel();
            return false;
        }
        Convert.moveArray(this.recievedDataBuffer, 8, this.recievedDataBuffer, 0, i - 8);
        this.recievedDataSize -= 8;
        this.nextImgDataLength = 0;
        this.recievedHeader = true;
        if (this.datasource == 0 || this.datasource == 1 || this.datasource == 8 || this.datasource == 7) {
            processReceivedDataV4();
        } else {
            super.processRecivedData();
        }
        return true;
    }

    protected boolean isNeedProcessReturn() {
        if (this.datasource == 9) {
            return true;
        }
        return false;
    }

    void processRecivedTileData(byte[] bArr, int i, int i2) {
        if (i == 0) {
            super.processRecivedTileData(bArr, i, i2);
        } else if (this.datasource == 2 || this.datasource == 3) {
            processRecivedTileDataBmp(bArr, i, i2);
        } else if (this.datasource == 4) {
            processRecivedTileDataVTmc(bArr, i, i2);
        } else if (this.datasource == 6) {
            processRecivedModels(bArr, i, i2);
        } else {
            super.processRecivedTileData(bArr, i, i2);
        }
    }

    void processRecivedTileDataBmp(byte[] bArr, int i, int i2) {
        String str;
        int i3 = i + 4;
        int i4 = i3 + 1;
        byte b = bArr[i3];
        String str2 = "";
        if (b <= (byte) 0 || (i4 + b) - 1 >= i2) {
            str = str2;
        } else {
            str = new String(bArr, i4, b);
        }
        i3 = i4 + b;
        if (this.mGLMapEngine.isMapEngineValid() && i2 > i) {
            int i5 = !this.mMapCallback.isGridInScreen(this.datasource, str) ? 1 : 0;
            if (this.mGLMapEngine.putMapData(bArr, i, i2 - i, this.datasource, 0)) {
                VMapDataCache.getInstance().putRecoder(null, str, this.datasource);
            }
            if (i5 != 0) {
                doCancel();
            }
        }
    }

    void processRecivedTileDataVTmc(byte[] bArr, int i, int i2) {
        int i3 = i + 4;
        int i4 = i3 + 1;
        byte b = bArr[i3];
        if (i4 + b <= bArr.length && i4 <= bArr.length - 1 && b >= (byte) 0) {
            String str = new String(bArr, i4, b);
            i3 = b + i4;
            i3 = (bArr[i3] + (i3 + 1)) + 4;
            if (this.mGLMapEngine.isMapEngineValid()) {
                VTMCDataCache instance = VTMCDataCache.getInstance();
                if (i2 > i) {
                    Object obj = new byte[(i2 - i)];
                    System.arraycopy(bArr, i, obj, 0, i2 - i);
                    C3526f putData = instance.putData(obj);
                    int i5 = !this.mMapCallback.isGridInScreen(this.datasource, str) ? 1 : 0;
                    if (putData != null) {
                        this.mGLMapEngine.putMapData(putData.f13288a, 0, putData.f13288a.length, this.datasource, putData.f13290c);
                    }
                    if (i5 != 0) {
                        doCancel();
                    }
                }
            }
        }
    }

    void processRecivedModels(byte[] bArr, int i, int i2) {
        int i3 = i + 1;
        byte b = bArr[i];
        if (b >= (byte) 0) {
            String str = new String(bArr, i3, b);
            if (this.mGLMapEngine.isMapEngineValid() && i2 > i) {
                int i4 = !this.mMapCallback.isGridInScreen(this.datasource, str) ? 1 : 0;
                this.mGLMapEngine.putMapData(bArr, i, i2 - i, this.datasource, 0);
                if (i4 != 0) {
                    doCancel();
                }
            }
        }
    }
}
