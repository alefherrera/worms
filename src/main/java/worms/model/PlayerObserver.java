package worms.model;

import worms.engine.actions.states.PlayerState;

public interface PlayerObserver {

    void update(PlayerState playerState);

}
