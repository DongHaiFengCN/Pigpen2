package com.doaing.common.util;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.DisplayMetrics;
import android.view.View;

public class Utils {

    private static float sNonCompatScaledDensity = 0;
    private static float sNonScaledDensity = 0;

    @RequiresApi(api = Build.VERSION_CODES.M)
    public static void setAndroidNativeLightStatusBar(Activity activity, boolean dark) {
        View decor = activity.getWindow().getDecorView();
        if (dark) {
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        } else {
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }
    }

    public static void set360dpDensity(final Activity activity) {

        final DisplayMetrics appDisplayMetrics = activity.getResources().getDisplayMetrics();

        if (sNonCompatScaledDensity == 0) {

            sNonCompatScaledDensity = appDisplayMetrics.scaledDensity;

            sNonScaledDensity = appDisplayMetrics.density;
            activity.registerComponentCallbacks(new ComponentCallbacks() {
                @Override
                public void onConfigurationChanged(Configuration newConfig) {
                    if (newConfig != null && newConfig.fontScale > 0) {
                        sNonCompatScaledDensity = activity.getResources().getDisplayMetrics().scaledDensity;
                    }
                }
                @Override
                public void onLowMemory() {

                }
            });
        }
        final float targetDensity = appDisplayMetrics.widthPixels / 360f;
        final int targetDensityDpi = (int) (160 * targetDensity);

       // appDisplayMetrics.density = appDisplayMetrics.scaledDensity = targetDensity;
        //appDisplayMetrics.densityDpi = targetDensityDpi;

        final DisplayMetrics activityDisplayMetrics = activity.getResources().getDisplayMetrics();
        activityDisplayMetrics.density = activityDisplayMetrics.scaledDensity = targetDensity;
        activityDisplayMetrics.densityDpi = targetDensityDpi;


    }

}
