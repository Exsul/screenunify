package net.exsul.screenunify.distortion.managers;

import net.exsul.screenunify.distortion.Distortion;
import net.exsul.screenunify.distortion.info.DistortionInfo;

public class DistortionManager {
    private static DistortionByObjectChooser db = new DistortionByObjectChooser();

    public static DistortionByObjectChooser db() {
        return db;
    }

    public static <T> void addClassSupport( DistortionPerformerChooser<T> manager, T class_exemplar ) {
        db().put(class_exemplar, manager);
    }

    public static <DistortionObject, DistortionType extends DistortionInfo>
      Distortion<DistortionObject> getDistortion( final Class<DistortionType> type ) {
        Distortion<?> res = getPreDistortion(Distortion.class, type);
        // assert(res.getClass() == Distortion<DistortionObject>);
        return (Distortion<DistortionObject>)res;
    }

    private static <DistortionObject, DistortionType extends DistortionInfo>
      Distortion<?> getPreDistortion( final Class<DistortionObject> obj, final Class<DistortionType> type ) {
        DistortionPerformerChooser<?> performerChooser = db().get(obj);
        return performerChooser.get(type);
    }

    public static <DistortionObject, DistortionType extends DistortionInfo>
      DistortionObject applyDistortion( final DistortionObject obj, final DistortionType info ) {
        Distortion<DistortionObject> distortion = getDistortion(info.getClass());
        distortion.update(info);
        return distortion.apply(obj);
    }
}
