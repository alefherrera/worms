import enums.Action;
import model.Controller;
import model.Game;
import model.Looper;
import model.Match;
import model.config.Configuration;
import model.elements.Player;
import service.SecuencialTurnManager;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Controller controller = new Controller("key-controller");

    private static Map<String, Action> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        Scanner keyboard = new Scanner(System.in);
        boolean exit = false;
        setUpActionsMap();
        Game game = new Game(new Looper(1000));
        System.out.println("Game Started");
        game.start();
        Configuration configuration = getConfiguration();
        Match match = game.createMatch(configuration, players -> new SecuencialTurnManager(players));
        match.addPlayer(new Player("player 1", configuration), controller);
        match.start();
        while (!exit) {
            System.out.println("Enter command (q to exit):");
            String input = keyboard.nextLine();
            if(input != null) {
                System.out.println("Your input is : " + input);
                if ("q".equals(input)) {
                    System.out.println("Exit programm");
                    exit = true;
                } else {
                    textToAction(input);
                }
            }
        }
        keyboard.close();

    }

    private static void setUpActionsMap() {
        map.put("a", Action.LEFT);
        map.put("s", Action.DOWN);
        map.put("d", Action.RIGHT);
        map.put("w", Action.UP);
        map.put("x", Action.EXECUTE);
        map.put("z", Action.CANCEL);
    }

    private static void textToAction(String input) {
        if (map.containsKey(input)) {
            controller.sendAction(map.get(input));
        }
    }

    private static final Double MOVING_SPEED = 10d;
    private static final Double AIMING_SPEED = 2d;
    private static final Double POWER_SPEED = 1d;

    private static Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        configuration.setMovingSpeed(MOVING_SPEED);
        configuration.setAimingSpeed(AIMING_SPEED);
        configuration.setPowerSpeed(POWER_SPEED);
        return configuration;
    }

}
