package net.exsul.screenunify.performer;

import net.exsul.screenunify.resource.distortion.Distortion;
import net.exsul.screenunify.resource.distortion.RotationDistortion;

public abstract class RotationPerformer<T> extends Performer<T> {
    protected RotationDistortion info;

    @Override
    public void update( final Distortion _info ) {
        update(_info);
    }

    public void update( final RotationDistortion _info ) {
        info = _info;
    }
}
