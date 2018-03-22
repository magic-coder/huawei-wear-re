package com.huawei.pluginkidwatch.plugin.chat;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.lib.p147b.C1465a;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1395k;
import com.huawei.pluginkidwatch.common.ui.view.C1565a;
import com.huawei.pluginkidwatch.common.ui.view.ac;
import com.huawei.pluginkidwatch.h;
import com.huawei.pluginkidwatch.plugin.chat.p161a.C1744a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* compiled from: ChatAdapter */
public class as extends BaseAdapter {
    private List<C1744a> f4825a;
    private LayoutInflater f4826b;
    private Context f4827c;
    private OnClickListener f4828d;
    private Handler f4829e;
    private OnLongClickListener f4830f;
    private OnClickListener f4831g;
    private int f4832h = 0;

    public as(Context context, List<C1744a> list, OnClickListener onClickListener, OnLongClickListener onLongClickListener, OnClickListener onClickListener2, Handler handler) {
        this.f4825a = list;
        this.f4827c = context;
        this.f4828d = onClickListener;
        this.f4831g = onClickListener2;
        this.f4826b = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f4830f = onLongClickListener;
        this.f4829e = handler;
    }

    public void m8494a(int i) {
        this.f4832h = i;
        super.notifyDataSetChanged();
    }

    public int getCount() {
        return this.f4825a.size();
    }

    public Object getItem(int i) {
        return this.f4825a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C1744a c1744a = (C1744a) this.f4825a.get(i);
        if (c1744a == null) {
            C2538c.m12674b("ChatAdapter", "==========getView:   modal is null,return null");
            return null;
        }
        av avVar;
        View view2;
        C2538c.m12674b("ChatAdapter", "==========getView:" + c1744a.toString());
        int itemViewType = getItemViewType(i);
        if (view != null) {
            C2538c.m12674b("ChatAdapter", "==========else:" + c1744a.f4768c);
            switch (itemViewType) {
                case 0:
                    avVar = (ChatSenderCell) view.getTag();
                    view2 = view;
                    break;
                case 1:
                    avVar = (ChatReceiverCell) view.getTag();
                    view2 = view;
                    break;
                default:
                    avVar = null;
                    view2 = view;
                    break;
            }
        }
        View inflate;
        av avVar2;
        av avVar3;
        switch (itemViewType) {
            case 0:
                inflate = this.f4826b.inflate(h.activity_chatsendercell, null);
                avVar2 = (ChatSenderCell) inflate;
                inflate.setTag(avVar2);
                avVar3 = avVar2;
                view2 = inflate;
                avVar = avVar3;
                break;
            case 1:
                inflate = this.f4826b.inflate(h.activity_chatcell, null);
                avVar2 = (ChatReceiverCell) inflate;
                inflate.setTag(avVar2);
                avVar3 = avVar2;
                view2 = inflate;
                avVar = avVar3;
                break;
            default:
                avVar = null;
                view2 = view;
                break;
        }
        if (avVar != null) {
            m8488a(i, avVar, c1744a);
            if ("0".equals(c1744a.f4784s)) {
                avVar.setFrameTextVisiable(false);
                avVar.setPlay(c1744a.f4774i);
                avVar.setFrameVideoVisiable(true);
                avVar.setTimeLength(c1744a.f4773h);
                avVar.setIsReaded(c1744a.f4776k);
            } else {
                avVar.setFrameTextVisiable(true);
                avVar.setFrameVideoVisiable(false);
                avVar.setPlay(false);
                avVar.setIsReaded(true);
                avVar.setTextContent(c1744a.f4785t);
            }
            avVar.setStatus(c1744a.f4772g);
            avVar.setTime(m8487a(i, c1744a));
            avVar.setClickListener(this.f4828d);
            avVar.setLoneClickListener(this.f4830f);
            avVar.setResendListener(this.f4831g);
            avVar.setmRelationText(c1744a.f4775j);
            avVar.m8466a(c1744a.f4786u);
            avVar.setCheckStatus(c1744a.f4787v);
            if (this.f4832h == 1) {
                C2538c.m12674b("ChatAdapter", "DELETE_MODE:");
                m8490a(avVar, c1744a);
            }
        }
        return view2;
    }

    private void m8490a(av avVar, C1744a c1744a) {
        avVar.setOnCheckChangeListener(new at(this, c1744a, avVar));
    }

    private void m8488a(int i, av avVar, C1744a c1744a) {
        C2538c.m12674b("ChatAdapter", "=============Enter setHeadImage");
        if (!c1744a.f4781p.equals(c1744a.f4782q)) {
            String str = (String) C1462f.m6712A().get(c1744a.f4781p);
            if (str != null && !"".equals(str.trim())) {
                C2538c.m12674b("ChatAdapter", "=============Enter setHeadImage1");
                m8489a(i, avVar, (String) C1462f.m6712A().get(c1744a.f4781p));
            } else if ("".equals(c1744a.f4780o)) {
                C2538c.m12674b("ChatAdapter", "=============Enter setHeadImage3");
                m8492b(i, avVar, c1744a);
            } else {
                C2538c.m12674b("ChatAdapter", "=============Enter setHeadImage2");
                C1462f.m6712A().remove(c1744a.f4781p);
                C1462f.m6712A().put(c1744a.f4781p, c1744a.f4780o);
                m8489a(i, avVar, c1744a.f4780o);
            }
        } else if (C1462f.m6748k() == null) {
            C2538c.m12674b("ChatAdapter", "KWCache.getCurDeviceInfo() = null");
            C1395k a = C1392h.m6269a(this.f4827c, C1462f.m6744i(), C1462f.m6746j());
            if ("".equals(a.f3098r)) {
                C2538c.m12674b("ChatAdapter", " 空串 equals(table.PortraitUrl");
                if (1 == a.f3091k) {
                    C2538c.m12674b("ChatAdapter", "WCache.Gender.FEMALE == table.Sex)");
                    avVar.setPhoto(C1617f.kw_pic_user_girl);
                    return;
                }
                avVar.setPhoto(C1617f.kw_pic_user_boy);
                return;
            }
            m8489a(i, avVar, a.f3098r);
        } else if (!"".equals(C1462f.m6748k().f3098r)) {
            C2538c.m12674b("ChatAdapter", "=============setHeadTo getCurDeviceInfo url");
            m8489a(i, avVar, C1462f.m6748k().f3098r);
        } else if (1 == C1462f.m6748k().f3091k) {
            avVar.setPhoto(C1617f.kw_pic_user_girl);
        } else {
            C2538c.m12674b("ChatAdapter", "=============KWCache.curDeviceInfo is null, head boy");
            avVar.setPhoto(C1617f.kw_pic_user_boy);
        }
    }

    private void m8492b(int i, av avVar, C1744a c1744a) {
        C2538c.m12674b("ChatAdapter", "=============Enter setHeadToDefult");
        if (avVar == null || c1744a == null) {
            C2538c.m12674b("ChatAdapter", "=============Enter setHeadToDefult,null return");
            return;
        }
        String str = (String) C1462f.m6713B().get(c1744a.f4781p);
        if (str != null && !"".equals(str)) {
            C2538c.m12674b("ChatAdapter", "=========管理员是默认头像");
            if (str.equals("0")) {
                avVar.setPhoto(C1617f.kw_pic_ist_user_common);
            } else if (str.equals("1")) {
                avVar.setPhoto(C1617f.kw_pic_relation_mid_dad);
            } else if (str.equals("2")) {
                avVar.setPhoto(C1617f.kw_pic_relation_mid_mom);
            } else if (str.equals("3")) {
                avVar.setPhoto(C1617f.kw_pic_relation_mid_grandpa);
            } else if (str.equals("4")) {
                avVar.setPhoto(C1617f.kw_pic_relation_mid_grandma);
            } else if (str.equals("5")) {
                avVar.setPhoto(C1617f.kw_pic_user_boy);
            } else if (str.equals("6")) {
                avVar.setPhoto(C1617f.kw_pic_user_girl);
            }
        }
    }

    private void m8489a(int i, av avVar, String str) {
        C2538c.m12674b("ChatAdapter", "=============Enter setHeadByUrl" + str);
        if (avVar == null || i >= this.f4825a.size()) {
            C2538c.m12674b("ChatAdapter", "=============Enter setHeadToDefult,null return");
            return;
        }
        Bitmap b = C1465a.m6770a().m6776b(str);
        if (b == null || b.isRecycled()) {
            C2538c.m12674b("ChatAdapter", "=========Read From File");
            b = ac.m7222a(this.f4827c, str);
            if (b == null || b.isRecycled()) {
                C2538c.m12674b("ChatAdapter", "  ==================从网络下载");
                C1565a.m7217a(new au(this, i, i, i), str, this.f4827c);
                return;
            }
            C2538c.m12674b("ChatAdapter", "=========从文件读到");
            b = C1492l.m6903a(b);
            if (b != null) {
                avVar.setPhoto(b);
                return;
            }
            C2538c.m12674b("ChatAdapter", "=========设置到头像失败");
            return;
        }
        C2538c.m12674b("ChatAdapter", "=========Read From Cache");
        C2538c.m12674b("ChatAdapter", "========BitmapCache " + new Date().toString());
        b = C1492l.m6903a(b);
        if (b != null) {
            C2538c.m12674b("ChatAdapter", "==========roundBitmap is not null");
            avVar.setPhoto(b);
            return;
        }
        C2538c.m12674b("ChatAdapter", "=========roundBitmap is null");
    }

    private String m8487a(int i, C1744a c1744a) {
        String str = "";
        if (c1744a.f4769d == null || c1744a.f4769d.length() <= 1) {
            return str;
        }
        int d = C1492l.m6920d(new SimpleDateFormat("dd", Locale.US).format(Long.valueOf(System.currentTimeMillis())));
        int d2 = C1492l.m6920d(new SimpleDateFormat("dd", Locale.US).format(Long.valueOf(c1744a.f4769d)));
        Date date = new Date(Long.parseLong(c1744a.f4769d));
        if (i > 0) {
            String str2;
            C1744a c1744a2 = (C1744a) this.f4825a.get(i - 1);
            if (c1744a2 == null || Long.parseLong(c1744a.f4769d) - Long.parseLong(c1744a2.f4769d) <= 600000) {
                str2 = str;
            } else if (d != d2) {
                str2 = new SimpleDateFormat("MM月dd日 HH:mm", Locale.US).format(date);
            } else {
                str2 = new SimpleDateFormat("HH:mm", Locale.US).format(date);
            }
            return str2;
        } else if (d != d2) {
            return new SimpleDateFormat("MM月dd日 HH:mm", Locale.US).format(date);
        } else {
            return new SimpleDateFormat("HH:mm", Locale.US).format(date);
        }
    }

    public int getItemViewType(int i) {
        if (((C1744a) this.f4825a.get(i)).f4768c) {
            return 0;
        }
        return 1;
    }

    public int getViewTypeCount() {
        return 2;
    }
}
