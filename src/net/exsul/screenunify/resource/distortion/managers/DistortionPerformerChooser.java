package net.exsul.screenunify.resource.distortion.managers;

import net.exsul.screenunify.performer.NullPerformer;
import net.exsul.screenunify.resource.distortion.Distortion;
import net.exsul.screenunify.performer.Performer;
import net.exsul.screenunify.storage.ChildStorage;

public class DistortionPerformerChooser<T> extends ChildStorage<Performer<T>, Distortion> {
    @Override
    protected Performer<T> onKeyMiss( final String id ) {
        if ("NullDistortion" == id)
            return new NullPerformer<T>();
        return null;
    }
}
