package com.livetl.android;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;

import java.util.ArrayList;
import java.util.List;

public class GestureExclusionUtil {
    private static final List<Rect> exclusionRects = new ArrayList<>();

    public static void updateGestureExclusion(Activity activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) return;

        exclusionRects.clear();
        int width = getScreenWidth(activity);
        int height = getScreenHeight(activity);
        exclusionRects.add(new Rect(0, 0, width, height));

        activity.findViewById(android.R.id.content).setSystemGestureExclusionRects(exclusionRects);
    }

    private static int getScreenHeight(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    private static int getScreenWidth(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }
}
