package net.exsul.screenunify.distortion.info;

import net.exsul.screenunify.distortion.managers.DistortionManager;

public class NullDistortionInfo extends DistortionInfo {
    @Override
    public Object apply( final Object obj ) {
        return obj;
    }
}
