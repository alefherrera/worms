package physic;

import model.Position;

import java.time.LocalTime;
import java.util.function.Function;

public class PhysicCreator {

    private static Function<LocalTime, Position> createFunction(Double speed, Double angle, Position startPosition, LocalTime start) {
        double gravity = -9.8;
        double ax = 0;
        double vx = speed * Math.cos(angle * (Math.PI / 180.0));
        double vy = speed * Math.sin(angle * (Math.PI / 180.0));
        return localTime -> {
            int deltaTime = localTime.getSecond() - start.getSecond();
            double x = vx * deltaTime;
            double aux = gravity * getAux(deltaTime);
            double y = vy * deltaTime + aux;
            return new Position(startPosition.getX() + x,startPosition.getY() +  y);
        };
    }

    private static double getAux(int deltaTime) {
        double aux = 0;
        for (int i = 0; i < deltaTime; i++) {
            aux += i;
        }
        return aux;
    }

    public static void main(String[] args) {
        LocalTime time = LocalTime.now();
        Function<LocalTime, Position> function = createFunction(80D, 45D, new Position(0D, 0D), time);
        time.getSecond();
        for (int i = 0; i < 14; i++) {
            algo(time, function, i);
        }
    }

    private static void algo(LocalTime time, Function<LocalTime, Position> function, int TIME) {
        LocalTime time2 = LocalTime.of(time.getHour(), time.getMinute(), time.getSecond() + TIME);
        Position position = function.apply(time2);
    }

}
