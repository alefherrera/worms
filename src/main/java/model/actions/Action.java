package model.actions;

public abstract class Action {

    // Esto es necesario para que el equals y hashcode funcionen correctamente
    private final Integer id = 1;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Action action = (Action) o;

        return id.equals(action.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
