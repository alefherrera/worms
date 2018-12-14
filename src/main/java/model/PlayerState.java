package model;

import enums.Action;
import model.elements.Player;

public interface PlayerState {

    PlayerState onAction(Action action, Player player);

}
