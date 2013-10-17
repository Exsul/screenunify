package net.exsul.screenunify.storage;

public class ChildStorage<BaseClassT, BaseSimilarT> extends GenericStorage<BaseClassT, String> {

    public /*<T extends BaseSimilarT>*/ BaseClassT get( final Class obj ) {
       String name = determineClassName(obj);
       return super.get(name);
    }

    public /*<T extends BaseSimilarT>*/ BaseClassT put( final Class exemplar, BaseClassT chooser ) {
        String name = determineClassName(exemplar);
        return super.put(name, chooser);
    }

    private String determineClassName( final Class obj ) {
        // http://stackoverflow.com/questions/6271417/java-get-the-current-class-name
        Class<?> enclosingClass = getClass().getEnclosingClass();
        if (enclosingClass != null)
            return enclosingClass.getName();
        return getClass().getName();
    }
}
