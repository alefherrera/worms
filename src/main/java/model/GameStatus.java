package model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class GameStatus {

    private final Collection<Match> matches;

    public GameStatus(Collection<Match> matches) {
        this.matches = matches;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameStatus that = (GameStatus) o;
        return Arrays.equals(matches.toArray(), that.matches.toArray());
    }

    @Override
    public int hashCode() {
        return Objects.hash(matches);
    }

    @Override
    public String toString() {
        return "GameStatus{" +
                "matches=" + matches +
                '}';
    }
}
