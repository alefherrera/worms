package worms.engine.actions;

@FunctionalInterface
public interface Action<T> {

    T execute(T target);

}
