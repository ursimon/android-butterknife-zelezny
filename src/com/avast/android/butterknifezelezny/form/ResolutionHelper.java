package com.avast.android.butterknifezelezny.form;

import java.awt.Toolkit;

import org.jetbrains.annotations.Nullable;

/**
 * Few helper methods to get resolution density factor
 * taken from https://stackoverflow.com/a/36626250/823934
 * <p>
 * Created by Michal Ursiny on 04.06.2017.
 */

class ResolutionHelper {

    private ResolutionHelper() {
    }

    @Nullable
    private static Float getRetinaScaleFactor() {
        Object obj = Toolkit.getDefaultToolkit().getDesktopProperty("apple.awt.contentScaleFactor");
        if (obj != null) {
            if (obj instanceof Float)
                return (Float)obj;
        }
        return null;
    }


    private static boolean hasRetinaDisplay() {
        Float fRetinaFactor = getRetinaScaleFactor();
        if (fRetinaFactor != null) {
            if (fRetinaFactor > 0) {
                int nScale = fRetinaFactor.intValue();
                return (nScale == 2); // 1 indicates a regular mac display, 2 is for retina
            }
        }
        return false;
    }


    static float getResolutionFactor() {
        float fResolutionFactor = ((float)Toolkit.getDefaultToolkit().getScreenResolution() / 96f);
        if (hasRetinaDisplay()) {
            //noinspection ConstantConditions
            fResolutionFactor = fResolutionFactor * getRetinaScaleFactor();
        }
        return fResolutionFactor;
    }

}
