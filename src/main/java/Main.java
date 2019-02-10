import model.*;
import model.actions.*;
import model.config.Configuration;
import model.elements.Character;
import model.equipment.Bullet;
import model.equipment.Weapon;
import service.SecuencialTurnManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Controller controller = new Controller("key-controller");

    private static Map<String, Action> map = new HashMap<>();

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        boolean exit = false;
        setUpActionsMap();
        Game game = new Game(new Looper(1000, new StatusSpy()));
        System.out.println("Game Started");
        game.start();
        Configuration configuration = getConfiguration();
        Match match = game.createMatch(configuration, new BattleGround(new Size(800D, 600D)), SecuencialTurnManager::new);
        Player player = match.addPlayer("player 1", controller);
        Bullet bullet = new Bullet(new Size(2D, 2D), 1D, new Power(1D));
        player.addWeapon(new Weapon(bullet, 2D));
        match.start();
        mockActions();
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

    private static void mockActions() {
        textToAction("x");
        textToAction("d");
        textToAction("d");
        textToAction("d");
        textToAction("x");
        textToAction("d");
        textToAction("d");
        textToAction("d");
        textToAction("d");
        textToAction("d");
    }

    private static void setUpActionsMap() {
        map.put("a", new LeftAction());
        map.put("s", new DownAction());
        map.put("d", new RightAction());
        map.put("w", new UpAction());
        map.put("x", new ExecuteAction());
        map.put("z", new CancelAction());
    }

    private static void textToAction(String input) {
        if (map.containsKey(input)) {
            controller.sendAction(map.get(input));
        }
    }

    private static final Double MOVING_SPEED = 10d;
    private static final Double AIMING_SPEED = 15d;
    private static final Double POWER_SPEED = 10d;

    private static Configuration getConfiguration() {
        Configuration.ConfigurationBuilder builder = new Configuration.ConfigurationBuilder();
        builder.addSetting(StatType.ANGLE, AIMING_SPEED)
                .addSetting(StatType.POWER, POWER_SPEED)
                .addSetting(StatType.SPEED, MOVING_SPEED);
        return builder.build();
    }

}
