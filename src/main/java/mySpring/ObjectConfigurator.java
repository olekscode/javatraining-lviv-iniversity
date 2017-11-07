package mySpring;

public interface ObjectConfigurator {
    <T> void configureFields(T o, Class<T> type) throws IllegalAccessException;
}
