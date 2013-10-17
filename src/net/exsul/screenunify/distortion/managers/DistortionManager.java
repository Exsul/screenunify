package net.exsul.screenunify.distortion.managers;

import net.exsul.screenunify.distortion.Distortion;
import net.exsul.screenunify.performer.Performer;

public class DistortionManager {
    private static DistortionByObjectChooser db = new DistortionByObjectChooser();

    public static DistortionByObjectChooser db() {
        return db;
    }

    public static <T> void addClassSupport( DistortionPerformerChooser<T> manager, T class_exemplar ) {
        db().put(class_exemplar, manager);
    }

    public static <DistortionObject, DistortionType extends Distortion>
    Performer<DistortionObject> getDistortion( final Class<DistortionType> type ) {
        Performer<?> res = getPreDistortion(Performer.class, type);
        // assert(res.getClass() == Performer<DistortionObject>);
        return (Performer<DistortionObject>)res;
    }

    private static <DistortionObject, DistortionType extends Distortion>
    Performer<?> getPreDistortion( final Class<DistortionObject> obj, final Class<DistortionType> type ) {
        DistortionPerformerChooser<?> performerChooser = db().get(obj);
        return performerChooser.get(type);
    }

    public static <DistortionObject, DistortionType extends Distortion>
      DistortionObject applyDistortion( final DistortionObject obj, final DistortionType info ) {
        Performer<DistortionObject> performer = getDistortion(info.getClass());
        performer.update(info);
        return performer.apply(obj);
    }
}
