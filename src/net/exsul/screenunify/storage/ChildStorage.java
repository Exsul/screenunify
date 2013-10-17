package net.exsul.screenunify.storage;

import net.exsul.screenunify.distortion.Distortion;
import net.exsul.screenunify.distortion.info.DistortionInfo;

public class ChildStorage<BaseClassT, BaseSimilarT> extends GenericStorage<BaseClassT, String> {
    public <T extends BaseSimilarT> BaseClassT get( final T obj ) {
       String name = determineClassName(obj.getClass());
       return super.get(name);
    }

    private String determineClassName( final Class obj ) {
        // http://stackoverflow.com/questions/6271417/java-get-the-current-class-name
        Class<?> enclosingClass = getClass().getEnclosingClass();
        if (enclosingClass != null)
            return enclosingClass.getName();
        return getClass().getName();
    }
}
