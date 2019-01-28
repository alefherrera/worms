package model.equipment;

import java.util.ArrayList;
import java.util.List;

public abstract class Equipment<T> {

    private List<T> items;

    Equipment() {
        items = new ArrayList<>();
    }

    public void add(T element) {
        items.add(element);
    }

}
