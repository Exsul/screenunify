package net.exsul.screenunify.distortion;

import net.exsul.screenunify.distortion.info.RotationDistortionInfo;

public abstract class RotationDistortion<T> implements Distortion<T> {
    protected final RotationDistortionInfo info;

    protected RotationDistortion( final RotationDistortionInfo a ) {
      info = a;
    }
}
