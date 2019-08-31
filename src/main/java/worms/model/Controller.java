package worms.model;

import worms.engine.actions.controller.ControllerAction;

import java.util.ArrayList;
import java.util.Collection;

public class Controller {

    private final Collection<ControllerListener> listeners;

    public Controller(String name) {
        this.name = name;
        listeners = new ArrayList<>();
    }

    private String name;

    public String getName() {
        return name;
    }

    public void addListener(ControllerListener listener) {
        this.listeners.add(listener);
    }

    public void removeListener(ControllerListener listener) {
        this.listeners.remove(listener);
    }

    public void sendAction(ControllerAction action) {
        this.listeners.forEach(listener -> listener.onControllerAction(action));
    }

}
