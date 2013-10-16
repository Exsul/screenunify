package net.exsul.screenunify.distortion;

import net.exsul.screenunify.distortion.info.RotationDistortionInfo;

public abstract class RotationDistortion<T> extends Distortion<T> {
    final RotationDistortionInfo info;

    RotationDistortion( final RotationDistortionInfo a ) {
      info = a;
    }
}
