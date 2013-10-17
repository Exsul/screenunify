package net.exsul.screenunify.performer;

import net.exsul.screenunify.resource.distortion.Distortion;
import net.exsul.screenunify.resource.distortion.ScaleDistortion;

public abstract class ScalePerformer<T> extends Performer<T> {
    protected ScaleDistortion info;

    @Override
    public void update( final Distortion _info ) {
        update(_info);
    }

    public void update( final ScaleDistortion _info ) {
        info = _info;
    }
}
