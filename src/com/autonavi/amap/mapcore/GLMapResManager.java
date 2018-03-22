package com.autonavi.amap.mapcore;

import android.content.Context;
import com.amap.api.mapcore.AMapDelegateImp;
import com.autonavi.amap.mapcore.MapTilsCacheAndResManager.RetStyleIconsFile;

public class GLMapResManager {
    private static final int AM_DATA_FORMAT_TYPE_GZIP = 1;
    public static final int AM_STYLEDATA_INDOOR = 1;
    private static final int AM_STYLE_DATA_TYPE_BASE_MAP = 0;
    public static final int TEXTURE_BACKGROUND = 1;
    public static final int TEXTURE_BIG_ICON = 20;
    public static final int TEXTURE_CHANGDUAN = 10;
    public static final int TEXTURE_GJ_GAOSU_GUIDE_BOARD = 12;
    public static final int TEXTURE_GUODAO_GUIDE_BOARD = 14;
    public static final int TEXTURE_HK_GAOSU_GUIDE_BOARD = 11;
    public static final int TEXTURE_ICON = 0;
    public static final int TEXTURE_INDOORICON = 31;
    public static final int TEXTURE_RAILWAY = 8;
    public static final int TEXTURE_ROADARROW = 2;
    public static final int TEXTURE_ROADROUND = 3;
    public static final int TEXTURE_SHENGDAO_GUIDE_BOARD = 15;
    public static final int TEXTURE_SHENG_GAOSU_GUIDE_BOARD = 13;
    public static final int TEXTURE_TIANQIAO = 9;
    public static final int TEXTURE_TMC_BLACK = 7;
    public static final int TEXTURE_TMC_GRAY = 18;
    public static final int TEXTURE_TMC_GREEN = 6;
    public static final int TEXTURE_TMC_RED = 4;
    public static final int TEXTURE_TMC_YELLOW = 5;
    public static final int TEXTURE_TOP_COVER = 41;
    public static final int TEXTURE_XIANDAO_GUIDE_BOARD = 16;
    public static final int TEXTURE_XIANGDAO_GUIDE_BOARD = 17;
    private static final String iconName1 = "icons_1_7_1444880368.data";
    private static final String iconName2 = "icons_2_7_1445580283.data";
    private static final String iconName3 = "icons_3_7_1444880372.data";
    private static final String iconName4 = "icons_4_6_1437480571.data";
    private static final String iconName50 = "icons_50_7_1444880375.data";
    private static final String styleName1 = "style_1_7_1445219169.data";
    private static final String styleName2 = "style_1_7_1445219169.data";
    private static final String styleName3 = "style_3_7_1445827513.data";
    private static final String styleName4 = "style_4_7_1445391691.data";
    private static final String styleName5 = "style_5_7_1445391719.data";
    private static final String styleName50 = "style_50_7_1445670996.data";
    private static final String styleName6 = "style_6_7_1445325996.data";
    private static final String styleName7 = "style_6_7_1445325996.data";
    private static final String styleName8 = "style_8_7_1445391734.data";
    private static final String styleName9 = "style_9_7_1445327958.data";
    public boolean isBigIcon = true;
    private Context mContext = null;
    private MapCore mMapCore = null;
    private AMapDelegateImp mapDelegateImp = null;

    public enum MapViewMode {
        NORAML,
        SATELLITE,
        BUS
    }

    public enum MapViewModeState {
        NORMAL,
        PREVIEW_CAR,
        PREVIEW_BUS,
        PREVIEW_FOOT,
        NAVI_CAR,
        NAVI_BUS,
        NAVI_FOOT
    }

    public enum MapViewTime {
        DAY,
        NIGHT
    }

    public GLMapResManager(AMapDelegateImp aMapDelegateImp, Context context) {
        this.mapDelegateImp = aMapDelegateImp;
        this.mContext = context;
        this.mMapCore = this.mapDelegateImp.m14544a();
    }

    public void setStyleData() {
        if (this.mapDelegateImp != null) {
            RetStyleIconsFile retStyleIconsFile = new RetStyleIconsFile();
            this.mMapCore.setStyleData(MapTilsCacheAndResManager.getInstance(this.mContext).getStyleData(getStyleName(), retStyleIconsFile), 0, 1);
            this.mMapCore.setStyleData(MapTilsCacheAndResManager.getInstance(this.mContext).getStyleData(styleName50, retStyleIconsFile), 1, 1);
        }
    }

    public void setIconsData(boolean z) {
        if (this.mapDelegateImp != null) {
            byte[] bArr = null;
            RetStyleIconsFile retStyleIconsFile = new RetStyleIconsFile();
            String iconName = getIconName();
            String bigIconName = getBigIconName(iconName);
            final byte[] iconsData = MapTilsCacheAndResManager.getInstance(this.mContext).getIconsData(iconName, retStyleIconsFile);
            if (this.isBigIcon) {
                bArr = MapTilsCacheAndResManager.getInstance(this.mContext).getIconsData(bigIconName, new RetStyleIconsFile());
            }
            final byte[] iconsData2 = MapTilsCacheAndResManager.getInstance(this.mContext).getIconsData(iconName50, retStyleIconsFile);
            if (z) {
                this.mMapCore.setInternaltexture(iconsData, 0);
                this.mMapCore.setInternaltexture(iconsData2, 31);
                if (this.isBigIcon) {
                    this.mMapCore.setInternaltexture(bArr, 20);
                    return;
                }
                return;
            }
            this.mapDelegateImp.m14584a(new Runnable(this) {
                final /* synthetic */ GLMapResManager f13257d;

                public void run() {
                    this.f13257d.mMapCore.setInternaltexture(iconsData, 0);
                    this.f13257d.mMapCore.setInternaltexture(iconsData2, 31);
                    if (this.f13257d.isBigIcon) {
                        this.f13257d.mMapCore.setInternaltexture(bArr, 20);
                    }
                }
            });
        }
    }

    private String getBigIconName(String str) {
        if (str.equals(iconName1)) {
            this.isBigIcon = true;
            return iconName4;
        }
        this.isBigIcon = false;
        return null;
    }

    public String getStyleName() {
        String str = "";
        if (this.mapDelegateImp == null) {
            return str;
        }
        MapViewTime X = this.mapDelegateImp.m14531X();
        MapViewMode Y = this.mapDelegateImp.m14532Y();
        MapViewModeState Z = this.mapDelegateImp.m14533Z();
        if (MapViewTime.DAY == X) {
            if (MapViewMode.NORAML == Y) {
                if (MapViewModeState.NAVI_CAR == Z) {
                    return styleName4;
                }
                if (MapViewModeState.PREVIEW_BUS == Z) {
                    return "style_6_7_1445325996.data";
                }
                if (MapViewModeState.PREVIEW_CAR == Z) {
                    return styleName8;
                }
                if (MapViewModeState.NAVI_BUS == Z) {
                    return styleName9;
                }
                return "style_1_7_1445219169.data";
            } else if (MapViewMode.SATELLITE == Y) {
                if (MapViewModeState.NAVI_CAR == Z) {
                    return styleName4;
                }
                if (MapViewModeState.PREVIEW_BUS == Z) {
                    return "style_6_7_1445325996.data";
                }
                return styleName3;
            } else if (MapViewMode.BUS != Y) {
                return str;
            } else {
                if (MapViewModeState.NAVI_CAR == Z) {
                    return styleName4;
                }
                if (MapViewModeState.PREVIEW_BUS == Z) {
                    return "style_6_7_1445325996.data";
                }
                return "style_6_7_1445325996.data";
            }
        } else if (MapViewTime.NIGHT != X) {
            return str;
        } else {
            if (MapViewMode.NORAML == Y) {
                if (MapViewModeState.NAVI_CAR == Z) {
                    return styleName5;
                }
                if (MapViewModeState.PREVIEW_BUS == Z) {
                    return "style_6_7_1445325996.data";
                }
                return "style_1_7_1445219169.data";
            } else if (MapViewMode.SATELLITE == Y) {
                if (MapViewModeState.NAVI_CAR == Z) {
                    return styleName5;
                }
                if (MapViewModeState.PREVIEW_BUS == Z) {
                    return "style_6_7_1445325996.data";
                }
                return styleName3;
            } else if (MapViewMode.BUS != Y) {
                return str;
            } else {
                if (MapViewModeState.NAVI_CAR == Z) {
                    return styleName5;
                }
                if (MapViewModeState.PREVIEW_BUS == Z) {
                    return "style_6_7_1445325996.data";
                }
                return "style_6_7_1445325996.data";
            }
        }
    }

    public String getIconName() {
        String str = "";
        if (this.mapDelegateImp == null) {
            return str;
        }
        MapViewTime X = this.mapDelegateImp.m14531X();
        MapViewMode Y = this.mapDelegateImp.m14532Y();
        if (MapViewTime.DAY == X) {
            if (MapViewMode.BUS == Y) {
                return iconName3;
            }
            return iconName1;
        } else if (MapViewTime.NIGHT != X) {
            return str;
        } else {
            if (MapViewMode.BUS == Y) {
                return iconName3;
            }
            return iconName2;
        }
    }

    public void setTrafficTexture(boolean z) {
        byte[] otherResData;
        byte[] otherResData2;
        byte[] otherResData3;
        byte[] otherResData4;
        byte[] otherResData5;
        if (this.mapDelegateImp.m14531X() != MapViewTime.NIGHT) {
            otherResData = MapTilsCacheAndResManager.getInstance(this.mContext).getOtherResData("tgl_l.data");
            otherResData2 = MapTilsCacheAndResManager.getInstance(this.mContext).getOtherResData("trl_l.data");
            otherResData3 = MapTilsCacheAndResManager.getInstance(this.mContext).getOtherResData("tyl_l.data");
            otherResData4 = MapTilsCacheAndResManager.getInstance(this.mContext).getOtherResData("tbl_l.data");
            otherResData5 = MapTilsCacheAndResManager.getInstance(this.mContext).getOtherResData("tnl_l.data");
        } else {
            otherResData = MapTilsCacheAndResManager.getInstance(this.mContext).getOtherResData("tgl_n.data");
            otherResData2 = MapTilsCacheAndResManager.getInstance(this.mContext).getOtherResData("trl_n.data");
            otherResData3 = MapTilsCacheAndResManager.getInstance(this.mContext).getOtherResData("tyl_n.data");
            otherResData4 = MapTilsCacheAndResManager.getInstance(this.mContext).getOtherResData("tbl_n.data");
            otherResData5 = MapTilsCacheAndResManager.getInstance(this.mContext).getOtherResData("tnl_n.data");
        }
        if (z) {
            this.mMapCore.setInternaltexture(otherResData, 6);
            this.mMapCore.setInternaltexture(otherResData2, 4);
            this.mMapCore.setInternaltexture(otherResData3, 5);
            this.mMapCore.setInternaltexture(otherResData4, 7);
            this.mMapCore.setInternaltexture(otherResData5, 18);
            return;
        }
        this.mapDelegateImp.m14584a(new Runnable(this) {
            final /* synthetic */ GLMapResManager f13263f;

            public void run() {
                this.f13263f.mMapCore.setInternaltexture(otherResData, 6);
                this.f13263f.mMapCore.setInternaltexture(otherResData2, 4);
                this.f13263f.mMapCore.setInternaltexture(otherResData3, 5);
                this.f13263f.mMapCore.setInternaltexture(otherResData4, 7);
                this.f13263f.mMapCore.setInternaltexture(otherResData5, 18);
            }
        });
    }

    public void setBkTexture(boolean z) {
        byte[] otherResData;
        byte[] otherResData2;
        if (this.mapDelegateImp.m14531X() != MapViewTime.NIGHT) {
            otherResData = MapTilsCacheAndResManager.getInstance(this.mContext).getOtherResData("bktile.data");
            otherResData2 = MapTilsCacheAndResManager.getInstance(this.mContext).getOtherResData("3d_sky_day.dat");
        } else {
            otherResData = MapTilsCacheAndResManager.getInstance(this.mContext).getOtherResData("bktile_n.data");
            otherResData2 = MapTilsCacheAndResManager.getInstance(this.mContext).getOtherResData("3d_sky_night.dat");
        }
        if (z) {
            this.mMapCore.setInternaltexture(otherResData, 1);
            this.mMapCore.setInternaltexture(otherResData2, 41);
            return;
        }
        this.mapDelegateImp.m14584a(new Runnable(this) {
            final /* synthetic */ GLMapResManager f13266c;

            public void run() {
                this.f13266c.mMapCore.setInternaltexture(otherResData, 1);
                this.f13266c.mMapCore.setInternaltexture(otherResData2, 41);
            }
        });
    }

    public void setRoadGuideTexture(boolean z) {
    }

    public void setOtherMapTexture(boolean z) {
        final byte[] otherResData = MapTilsCacheAndResManager.getInstance(this.mContext).getOtherResData("roadarrow.data");
        final byte[] otherResData2 = MapTilsCacheAndResManager.getInstance(this.mContext).getOtherResData("lineround.data");
        final byte[] otherResData3 = MapTilsCacheAndResManager.getInstance(this.mContext).getOtherResData("dash.data");
        final byte[] otherResData4 = MapTilsCacheAndResManager.getInstance(this.mContext).getOtherResData("dash_tq.data");
        final byte[] otherResData5 = MapTilsCacheAndResManager.getInstance(this.mContext).getOtherResData("dash_cd.data");
        if (z) {
            this.mMapCore.setInternaltexture(otherResData, 2);
            this.mMapCore.setInternaltexture(otherResData2, 3);
            this.mMapCore.setInternaltexture(otherResData3, 8);
            this.mMapCore.setInternaltexture(otherResData4, 9);
            this.mMapCore.setInternaltexture(otherResData5, 10);
            return;
        }
        this.mapDelegateImp.m14584a(new Runnable(this) {
            final /* synthetic */ GLMapResManager f13272f;

            public void run() {
                this.f13272f.mMapCore.setInternaltexture(otherResData, 2);
                this.f13272f.mMapCore.setInternaltexture(otherResData2, 3);
                this.f13272f.mMapCore.setInternaltexture(otherResData3, 8);
                this.f13272f.mMapCore.setInternaltexture(otherResData4, 9);
                this.f13272f.mMapCore.setInternaltexture(otherResData5, 10);
            }
        });
    }
}
