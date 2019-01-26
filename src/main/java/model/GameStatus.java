package model;

import java.util.Collection;

public class GameStatus {

    private final Collection<Match> matches;

    public GameStatus(Collection<Match> matches) {
        this.matches = matches;
    }

}
