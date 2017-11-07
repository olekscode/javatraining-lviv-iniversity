package mySpring;

import factory.InjectRandomInt;

import java.lang.reflect.Field;
import java.util.Random;

public class RandomObjectConfigurator implements ObjectConfigurator {
    private Random random = new Random();

    public <T> void configureFields(T o, Class<T> type) throws IllegalAccessException {
        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {

            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                int min = annotation.min();
                int max = annotation.max();
                int randomIntValue = random.nextInt(max - min) + min;
                field.setAccessible(true);
                field.set(o, randomIntValue);
            }
        }
    }
}
