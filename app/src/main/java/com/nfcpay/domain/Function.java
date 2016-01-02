package com.nfcpay.domain;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by FengYang on 2015-12-31.
 */
public class Function {
    private String name;
    private Bitmap icon;

    public Function() {
    }

    public Function(String name,Resources res, int resId) {
        this.name = name;
        icon = BitmapFactory.decodeResource(res,resId);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getIcon() {
        return icon;
    }

    public void setIcon(Resources res, int resId) {
        icon = BitmapFactory.decodeResource(res,resId);
    }
}
