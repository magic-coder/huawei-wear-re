package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.text.Editable;
import android.text.TextWatcher;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import java.util.regex.Pattern;

/* compiled from: InviteManagerActivity */
class aj implements TextWatcher {
    final /* synthetic */ InviteManagerActivity f6590a;
    private CharSequence f6591b;
    private int f6592c;
    private int f6593d;

    aj(InviteManagerActivity inviteManagerActivity) {
        this.f6590a = inviteManagerActivity;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f6591b = charSequence;
        String trim = this.f6590a.f6348n.getText().toString().trim();
        C2538c.m12674b("InviteManagerActivity", "relation=" + trim);
        if (trim.equals("") || trim.length() == 0) {
            this.f6590a.f6360z = "0";
            this.f6590a.f6343i.setVisibility(4);
            this.f6590a.f6344j.setVisibility(4);
            this.f6590a.f6345k.setVisibility(4);
            this.f6590a.f6346l.setVisibility(4);
            this.f6590a.f6350p = "";
        } else if (!trim.equals(this.f6590a.f6353s) && !trim.equals(this.f6590a.f6352r) && !trim.equals(this.f6590a.f6354t) && !trim.equals(this.f6590a.f6355u)) {
            C2538c.m12674b("InviteManagerActivity", "=====checkInputChar is enter");
            if (C1492l.m6917b(trim)) {
                C2538c.m12674b("InviteManagerActivity", "=====checkInputChar is true");
                C1462f.m6743h(trim);
                this.f6590a.f6350p = this.f6590a.f6348n.getText().toString().trim();
            } else {
                C2538c.m12674b("InviteManagerActivity", "=====checkInputChar is false");
                this.f6590a.f6350p = this.f6590a.f6350p + "";
                if (this.f6590a.f6350p.equals("") || this.f6590a.f6350p.length() == 0) {
                    this.f6590a.f6348n.setText(this.f6590a.f6350p);
                } else {
                    this.f6590a.f6348n.setText(this.f6590a.f6350p);
                    this.f6590a.f6348n.setSelection(this.f6590a.f6350p.length());
                }
            }
            if (this.f6590a.f6350p.equals(this.f6590a.f6353s)) {
                this.f6590a.f6360z = "1";
                this.f6590a.f6343i.setVisibility(4);
                this.f6590a.f6344j.setVisibility(0);
                this.f6590a.f6345k.setVisibility(4);
                this.f6590a.f6346l.setVisibility(4);
            } else if (this.f6590a.f6350p.equals(this.f6590a.f6352r)) {
                this.f6590a.f6360z = "2";
                this.f6590a.f6343i.setVisibility(0);
                this.f6590a.f6344j.setVisibility(4);
                this.f6590a.f6345k.setVisibility(4);
                this.f6590a.f6346l.setVisibility(4);
            } else if (this.f6590a.f6350p.equals(this.f6590a.f6354t)) {
                this.f6590a.f6360z = "3";
                this.f6590a.f6343i.setVisibility(4);
                this.f6590a.f6344j.setVisibility(4);
                this.f6590a.f6345k.setVisibility(4);
                this.f6590a.f6346l.setVisibility(0);
            } else if (this.f6590a.f6350p.equals(this.f6590a.f6355u)) {
                this.f6590a.f6360z = "4";
                this.f6590a.f6343i.setVisibility(4);
                this.f6590a.f6344j.setVisibility(4);
                this.f6590a.f6345k.setVisibility(0);
                this.f6590a.f6346l.setVisibility(4);
            } else {
                this.f6590a.f6360z = "0";
                this.f6590a.f6343i.setVisibility(4);
                this.f6590a.f6344j.setVisibility(4);
                this.f6590a.f6345k.setVisibility(4);
                this.f6590a.f6346l.setVisibility(4);
            }
        } else if (trim.equals(this.f6590a.f6353s)) {
            this.f6590a.f6350p = this.f6590a.f6348n.getText().toString().trim();
            this.f6590a.f6360z = "1";
            this.f6590a.f6343i.setVisibility(4);
            this.f6590a.f6344j.setVisibility(0);
            this.f6590a.f6345k.setVisibility(4);
            this.f6590a.f6346l.setVisibility(4);
        } else if (trim.equals(this.f6590a.f6352r)) {
            this.f6590a.f6350p = this.f6590a.f6348n.getText().toString().trim();
            this.f6590a.f6360z = "2";
            this.f6590a.f6343i.setVisibility(0);
            this.f6590a.f6344j.setVisibility(4);
            this.f6590a.f6345k.setVisibility(4);
            this.f6590a.f6346l.setVisibility(4);
        } else if (trim.equals(this.f6590a.f6354t)) {
            this.f6590a.f6350p = this.f6590a.f6348n.getText().toString().trim();
            this.f6590a.f6360z = "3";
            this.f6590a.f6343i.setVisibility(4);
            this.f6590a.f6344j.setVisibility(4);
            this.f6590a.f6345k.setVisibility(4);
            this.f6590a.f6346l.setVisibility(0);
        } else if (trim.equals(this.f6590a.f6355u)) {
            this.f6590a.f6350p = this.f6590a.f6348n.getText().toString().trim();
            this.f6590a.f6360z = "4";
            this.f6590a.f6343i.setVisibility(4);
            this.f6590a.f6344j.setVisibility(4);
            this.f6590a.f6345k.setVisibility(0);
            this.f6590a.f6346l.setVisibility(4);
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        try {
            Pattern compile = Pattern.compile("^[一-龥豈-鶴]+$");
            Pattern compile2 = Pattern.compile("[a-zA-Z0-9]*");
            this.f6592c = this.f6590a.f6348n.getSelectionStart();
            this.f6593d = this.f6590a.f6348n.getSelectionEnd();
            if (compile.matcher(this.f6591b).matches() && this.f6591b.length() > this.f6590a.f6332C) {
                editable.delete(this.f6592c - 1, this.f6593d);
                this.f6590a.f6348n.setText(editable);
                this.f6590a.f6348n.setSelection(editable.length());
            } else if (compile2.matcher(this.f6591b).matches() && this.f6591b.length() > this.f6590a.f6333D) {
                editable.delete(this.f6592c - 1, this.f6593d);
                this.f6590a.f6348n.setText(editable);
                this.f6590a.f6348n.setSelection(editable.length());
            } else if (this.f6591b.length() > this.f6590a.f6332C && this.f6590a.m9837a(this.f6591b.toString())) {
                editable.delete(this.f6592c - 1, this.f6593d);
                this.f6590a.f6348n.setText(editable);
                this.f6590a.f6348n.setSelection(editable.length());
            } else if (this.f6591b.length() > this.f6590a.f6333D) {
                editable.delete(this.f6592c - 1, this.f6593d);
                this.f6590a.f6348n.setText(editable);
                this.f6590a.f6348n.setSelection(editable.length());
            }
        } catch (RuntimeException e) {
            C2538c.m12680e("InviteManagerActivity", "Exception e = " + e.getMessage());
        } catch (Exception e2) {
            C2538c.m12680e("InviteManagerActivity", "Exception e = " + e2.getMessage());
        }
    }
}
