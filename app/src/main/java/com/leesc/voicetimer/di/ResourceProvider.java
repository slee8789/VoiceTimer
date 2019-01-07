package com.leesc.voicetimer.di;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ArrayRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

public class ResourceProvider {
    private final Context context;
    public ResourceProvider(Context context) {
        this.context = context;
    }

    public Drawable getDrawable(@DrawableRes int resId) {
        return context.getDrawable(resId);
    }

    public String[] getArray(@ArrayRes int resId) {
        return context.getResources().getStringArray(resId);
    }

    public String getString(@StringRes int resId) {
        return context.getString(resId);
    }

    public String getString(@StringRes int resId, Object... formatArgs) {
        return context.getString(resId, formatArgs);
    }

}