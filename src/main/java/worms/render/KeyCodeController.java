package worms.render;

import javafx.scene.input.KeyCode;
import worms.engine.actions.controller.ControllerAction;
import worms.model.Controller;

import java.util.Map;

public class KeyCodeController extends Controller {

    private final Map<KeyCode, ControllerAction> map;

    public KeyCodeController(final String name, final Map<KeyCode, ControllerAction> map) {
        super(name);
        this.map = map;
    }

    public void onKeyCode(KeyCode keyCode) {
        if (map.containsKey(keyCode)) {
            final ControllerAction controllerAction = map.get(keyCode);
            sendAction(controllerAction);
        }
    }

}
