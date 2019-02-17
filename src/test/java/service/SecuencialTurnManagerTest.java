package service;

import model.Match;
import model.Player;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class SecuencialTurnManagerTest {

    @Test
    public void next() {
        Match match = mock(Match.class);
        Player player = new Player("player1", match);
        Player player2 = new Player("player1", match);
        Player player3 = new Player("player1", match);
        List<Player> players = new ArrayList<>();
        players.add(player);
        players.add(player2);
        players.add(player3);
        TurnManager turnManager = new SecuencialTurnManager(players);
        assertEquals(player, turnManager.getCurrent());

        turnManager.next();

        assertEquals(player2, turnManager.getCurrent());

        turnManager.next();

        assertEquals(player3, turnManager.getCurrent());

        turnManager.next();

        assertEquals(player, turnManager.getCurrent());

        players.remove(player2);

        turnManager.next();

        assertEquals(player3, turnManager.getCurrent());


    }
}