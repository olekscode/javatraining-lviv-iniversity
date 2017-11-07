package mySpring;

import lombok.SneakyThrows;

import java.util.Random;

public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig();
    private ObjectConfigurator objectConfigurator = new RandomObjectConfigurator();

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    private ObjectFactory() {
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        if (type.isInterface()) {
           type =  config.getImpl(type);
        }

        T o = null;

        try {
            o = type.newInstance();
            objectConfigurator.configureFields(o, type);
        }
        catch (InstantiationException e) {
            System.out.println("I can't instantiate an object of this class");
        }
        catch (IllegalAccessException e) {
            System.out.println("I don't have enough access to configure this object");
        }

        return o;
    }
}
