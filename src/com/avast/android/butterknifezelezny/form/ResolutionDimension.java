package com.avast.android.butterknifezelezny.form;

import java.awt.Dimension;

/**
 * Simple resolution density - aware Dimension subclass
 *
 * Created by Michal Ursiny on 04.06.2017.
 */
class ResolutionDimension extends Dimension {

    ResolutionDimension(int width, int height) {
        super(
            Math.round(width * ResolutionHelper.getResolutionFactor()),
            Math.round(height * ResolutionHelper.getResolutionFactor())
        );
    }
}
