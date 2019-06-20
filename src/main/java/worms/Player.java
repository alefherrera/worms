package worms;

public class Player {

    public void join(final Match match) {
        match.addPlayer(this);
    }
}
