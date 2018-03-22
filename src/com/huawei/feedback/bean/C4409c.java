package com.huawei.feedback.bean;

import com.huawei.feedback.logic.C4413c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FeedbackBaseInfo */
public class C4409c implements Serializable {
    private int f16328a;
    private String f16329b;
    private String f16330c;
    private String f16331d;
    private boolean f16332e;
    private boolean f16333f;
    private String f16334g;
    private int f16335h;
    private String f16336i;
    private String f16337j;
    private String f16338k;
    private String f16339l;
    private int f16340m;
    private int f16341n;
    private List<C4413c> f16342o;
    private String f16343p;
    private String f16344q;

    /* compiled from: FeedbackBaseInfo */
    public class C4408a {
        private int f16312a;
        private String f16313b = "";
        private String f16314c = "";
        private String f16315d = "";
        private List<C4413c> f16316e = new ArrayList();
        private boolean f16317f = false;
        private boolean f16318g = false;
        private String f16319h = "";
        private int f16320i = 1;
        private String f16321j = "";
        private String f16322k = "";
        private String f16323l = "";
        private int f16324m = 0;
        private String f16325n;
        private String f16326o;
        private String f16327p;

        public C4408a(int i) {
            this.f16312a = i;
        }

        public C4409c m21155a() {
            return new C4409c();
        }
    }

    public String m21156a() {
        return this.f16339l;
    }

    public void m21158a(String str) {
        this.f16339l = str;
    }

    public List<C4413c> m21161b() {
        return this.f16342o;
    }

    public void m21159a(List<C4413c> list) {
        this.f16342o = list;
    }

    public int m21165c() {
        return this.f16341n;
    }

    public void m21157a(int i) {
        this.f16341n = i;
    }

    public String m21168d() {
        return this.f16343p;
    }

    public void m21163b(String str) {
        this.f16343p = str;
    }

    public String m21171e() {
        return this.f16344q;
    }

    public void m21167c(String str) {
        this.f16344q = str;
    }

    private C4409c(C4408a c4408a) {
        this.f16341n = 0;
        this.f16342o = new ArrayList();
        this.f16328a = c4408a.f16312a;
        this.f16329b = c4408a.f16313b;
        this.f16330c = c4408a.f16314c;
        this.f16331d = c4408a.f16315d;
        this.f16342o = c4408a.f16316e;
        this.f16332e = c4408a.f16317f;
        this.f16333f = c4408a.f16318g;
        this.f16334g = c4408a.f16319h;
        this.f16335h = c4408a.f16320i;
        this.f16336i = c4408a.f16321j;
        this.f16337j = c4408a.f16322k;
        this.f16338k = c4408a.f16323l;
        this.f16340m = c4408a.f16324m;
        this.f16339l = c4408a.f16325n;
        this.f16343p = c4408a.f16326o;
        this.f16344q = c4408a.f16327p;
    }

    public C4409c() {
        this.f16341n = 0;
        this.f16342o = new ArrayList();
    }

    public void m21162b(int i) {
        this.f16328a = i;
    }

    public int m21173f() {
        return this.f16340m;
    }

    public void m21166c(int i) {
        this.f16340m = i;
    }

    public String m21175g() {
        return this.f16329b;
    }

    public void m21170d(String str) {
        this.f16329b = str;
    }

    public void m21172e(String str) {
        this.f16330c = str;
    }

    public void m21174f(String str) {
        this.f16331d = str;
    }

    public boolean m21178h() {
        return this.f16332e;
    }

    public void m21160a(boolean z) {
        this.f16332e = z;
    }

    public boolean m21180i() {
        return this.f16333f;
    }

    public void m21164b(boolean z) {
        this.f16333f = z;
    }

    public String m21181j() {
        return this.f16334g;
    }

    public void m21176g(String str) {
        this.f16334g = str;
    }

    public int m21183k() {
        return this.f16335h;
    }

    public void m21169d(int i) {
        this.f16335h = i;
    }

    public String m21184l() {
        return this.f16336i;
    }

    public void m21177h(String str) {
        this.f16336i = str;
    }

    public String m21185m() {
        return this.f16337j;
    }

    public void m21179i(String str) {
        this.f16337j = str;
    }

    public String m21186n() {
        return this.f16338k;
    }

    public void m21182j(String str) {
        this.f16338k = str;
    }
}
