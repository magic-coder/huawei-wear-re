package com.huawei.openalliance.ad.p112a.p122h;

import android.content.Context;
import android.content.SharedPreferences;

public class C1289h {
    private static C1289h f2737b;
    private SharedPreferences f2738a;

    private C1289h(Context context) {
        this.f2738a = context.getSharedPreferences("HiAdSharedPreferences", 0);
    }

    public static C1289h m5695a(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (f2737b == null) {
            synchronized (C1289h.class) {
                if (f2737b == null) {
                    f2737b = new C1289h(applicationContext);
                }
            }
        }
        return f2737b;
    }

    public int m5696a() {
        return this.f2738a.getInt("splash_cache_num", 10);
    }

    public void m5697a(int i) {
        this.f2738a.edit().putInt("splash_cache_num", i).commit();
    }

    public void m5698a(long j) {
        this.f2738a.edit().putLong("splash_show_time_interval", j).commit();
    }

    public void m5699a(String str) {
        this.f2738a.edit().putString("today_date", str).commit();
    }

    public void m5700a(boolean z) {
        this.f2738a.edit().putBoolean("enable_user_info", z).commit();
    }

    public int m5701b() {
        return this.f2738a.getInt("splash_show_time", 3000);
    }

    public void m5702b(int i) {
        this.f2738a.edit().putInt("splash_show_time", i).commit();
    }

    public void m5703b(long j) {
        this.f2738a.edit().putLong("slogan_real_min_show_time", j).commit();
    }

    public void m5704b(String str) {
        this.f2738a.edit().putString("reduce_disturb_rule", str).commit();
    }

    public int m5705c() {
        return this.f2738a.getInt("splash_show_mode", 1);
    }

    public void m5706c(int i) {
        this.f2738a.edit().putInt("splash_show_mode", i).commit();
    }

    public void m5707c(long j) {
        this.f2738a.edit().putLong("no_show_ad_time", j).commit();
    }

    public void m5708c(String str) {
        this.f2738a.edit().putString("maglock_show_id", str).commit();
    }

    public int m5709d() {
        return this.f2738a.getInt("splash_skip_area", 0);
    }

    public void m5710d(int i) {
        this.f2738a.edit().putInt("splash_skip_area", i).commit();
    }

    public int m5711e() {
        int i = 2000;
        if (1 == m5705c()) {
            i = 0;
        }
        return this.f2738a.getInt("slogan_show_time", i);
    }

    public void m5712e(int i) {
        this.f2738a.edit().putInt("slogan_show_time", i).commit();
    }

    public long m5713f() {
        return this.f2738a.getLong("splash_show_time_interval", 0);
    }

    public void m5714f(int i) {
        this.f2738a.edit().putInt("splash_app_day_impfc", i).commit();
    }

    public long m5715g() {
        return this.f2738a.getLong("slogan_real_min_show_time", 300);
    }

    public void m5716g(int i) {
        this.f2738a.edit().putInt("today_show_times", i).commit();
    }

    public int m5717h() {
        return this.f2738a.getInt("splash_app_day_impfc", 0);
    }

    public void m5718h(int i) {
        this.f2738a.edit().putInt("gif_time_upper_limit", i).commit();
    }

    public int m5719i() {
        return this.f2738a.getInt("today_show_times", 0);
    }

    public void m5720i(int i) {
        this.f2738a.edit().putInt("gif_time_lower_limit_frame", i).commit();
    }

    public String m5721j() {
        return this.f2738a.getString("today_date", "");
    }

    public void m5722j(int i) {
        this.f2738a.edit().putInt("gif_size_upper_limit", i).commit();
    }

    public String m5723k() {
        return this.f2738a.getString("reduce_disturb_rule", null);
    }

    public void m5724k(int i) {
        this.f2738a.edit().putInt("img_size_upper_limit", i).commit();
    }

    public int m5725l() {
        return this.f2738a.getInt("gif_time_upper_limit", 8000);
    }

    public void m5726l(int i) {
        this.f2738a.edit().putInt("long_edge_pix", i).commit();
    }

    public int m5727m() {
        return this.f2738a.getInt("gif_time_lower_limit_frame", 100);
    }

    public void m5728m(int i) {
        this.f2738a.edit().putInt("short_edge_pix", i).commit();
    }

    public int m5729n() {
        return this.f2738a.getInt("gif_size_upper_limit", 2048);
    }

    public int m5730o() {
        return this.f2738a.getInt("img_size_upper_limit", 500);
    }

    public boolean m5731p() {
        return this.f2738a.getBoolean("enable_user_info", true);
    }

    public String m5732q() {
        return this.f2738a.getString("maglock_show_id", "");
    }

    public int m5733r() {
        return this.f2738a.getInt("long_edge_pix", -1);
    }

    public int m5734s() {
        return this.f2738a.getInt("short_edge_pix", -1);
    }

    public long m5735t() {
        return this.f2738a.getLong("no_show_ad_time", 0);
    }
}
