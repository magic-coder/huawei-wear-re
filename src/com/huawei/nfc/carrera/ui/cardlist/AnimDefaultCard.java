package com.huawei.nfc.carrera.ui.cardlist;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;

public class AnimDefaultCard {
    public ObjectAnimator createAnimForView(View view, int i) {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("translationY", new float[]{(float) i});
        return ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{ofFloat}).setDuration(500);
    }
}
