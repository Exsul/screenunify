package net.exsul.screenunify.performer;

import net.exsul.screenunify.distortion.Distortion;

public abstract class RotationPerformer<T> extends Performer<T> {
    protected net.exsul.screenunify.distortion.RotationDistortion info;

    @Override
    public void update( final Distortion _info ) {
        update(_info);
    }

    public void update( final net.exsul.screenunify.distortion.RotationDistortion _info ) {
        info = _info;
    }
}
