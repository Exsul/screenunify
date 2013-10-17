package net.exsul.screenunify.distortion;

import net.exsul.screenunify.distortion.info.DistortionInfo;
import net.exsul.screenunify.distortion.info.RotationDistortionInfo;

public abstract class RotationDistortion<T> extends Distortion<T> {
    protected final RotationDistortionInfo info;

    @Override
    public void update( final DistortionInfo _info ) {
        update(_info);
    }

    public void update( final RotationDistortionInfo _info ) {
        info = _info;
    }
}
