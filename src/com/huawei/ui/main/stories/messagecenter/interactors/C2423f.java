package com.huawei.ui.main.stories.messagecenter.interactors;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.pluginmessagecenter.provider.data.MessageObject;
import com.huawei.ui.commonui.d.c;
import com.huawei.ui.main.f;
import com.huawei.ui.main.g;
import com.huawei.ui.main.h;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: MessageCenterListAdapter */
public class C2423f extends BaseAdapter {
    private List<MessageObject> f8712a;
    private Context f8713b;
    private Pattern f8714c = Pattern.compile("assets://(.*)");

    public C2423f(Context context, List<MessageObject> list) {
        this.f8712a = list;
        this.f8713b = context;
    }

    public void m12176a(List<MessageObject> list) {
        this.f8712a = list;
    }

    public int getCount() {
        return this.f8712a.size();
    }

    public Object getItem(int i) {
        return this.f8712a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C2425h c2425h;
        if (view == null) {
            view = LayoutInflater.from(this.f8713b).inflate(g.message_center_item, null);
            c2425h = new C2425h();
            c2425h.f8715a = (TextView) view.findViewById(f.MessageCenter_titleleft_tv);
            c2425h.f8716b = (TextView) view.findViewById(f.MessageCenter_content_tv);
            c2425h.f8717c = (ImageView) view.findViewById(f.MessageCenter_head_40iv);
            view.setTag(c2425h);
        } else {
            c2425h = (C2425h) view.getTag();
        }
        MessageObject messageObject = (MessageObject) this.f8712a.get(i);
        c2425h.f8715a.setText(messageObject.getMsgTitle());
        CharSequence msgContent = messageObject.getMsgContent();
        if (TextUtils.isEmpty(msgContent)) {
            c2425h.f8716b.setVisibility(8);
        } else {
            c2425h.f8716b.setVisibility(0);
            c2425h.f8716b.setText(msgContent);
        }
        String imgUri = messageObject.getImgUri();
        com.huawei.pluginmessagecenter.a.g.a("MessageCenterListAdapter", "imgUri:" + imgUri);
        if (imgUri == null) {
            c2425h.f8717c.setImageDrawable(this.f8713b.getResources().getDrawable(h.ic_default_message_icon));
        } else {
            String scheme = Uri.parse(imgUri).getScheme();
            if ("http".equals(scheme) || "https".equals(scheme)) {
                Picasso.with(this.f8713b).load(imgUri).resize(c.a(this.f8713b, 40.0f), c.a(this.f8713b, 40.0f)).placeholder(h.ic_default_message_icon).into(c2425h.f8717c);
            } else if ("assets".equals(scheme)) {
                Matcher matcher = this.f8714c.matcher(imgUri);
                imgUri = matcher.find() ? matcher.group(1) : "";
                if (imgUri == null || imgUri.isEmpty()) {
                    c2425h.f8717c.setImageDrawable(this.f8713b.getResources().getDrawable(h.ic_default_message_icon));
                } else {
                    try {
                        Drawable bitmapDrawable;
                        Bitmap decodeStream = BitmapFactory.decodeStream(this.f8713b.getAssets().open(imgUri));
                        ImageView imageView = c2425h.f8717c;
                        if (decodeStream != null) {
                            bitmapDrawable = new BitmapDrawable(decodeStream);
                        } else {
                            bitmapDrawable = null;
                        }
                        imageView.setImageDrawable(bitmapDrawable);
                    } catch (IOException e) {
                        com.huawei.pluginmessagecenter.a.g.b("MessageCenterListAdapter", e.getMessage());
                    }
                }
            } else {
                c2425h.f8717c.setImageDrawable(this.f8713b.getResources().getDrawable(h.ic_default_message_icon));
            }
        }
        return view;
    }
}
