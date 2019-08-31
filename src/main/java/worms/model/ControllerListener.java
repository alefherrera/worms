package worms.model;

import worms.engine.actions.controller.ControllerAction;

public interface ControllerListener {

    void onControllerAction(ControllerAction action);

}
