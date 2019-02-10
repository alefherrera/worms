package physic;

import model.Position;

import java.time.LocalTime;
import java.util.function.Function;

public class PhysicCreator {

    public Function<LocalTime, Position> createFunction(Double speed, Double angle, Position startPosition, LocalTime startTime) {
        final double gravity = -9.8;
        final double ax = 0;
        final double vx = speed * Math.cos(angle * (Math.PI / 180.0));
        final double vy = speed * Math.sin(angle * (Math.PI / 180.0));
        return localTime -> {
            final int deltaTime = localTime.getSecond() - startTime.getSecond();
            final double x = vx * deltaTime;
            final double aux = gravity * getAcumulated(deltaTime);
            final double y = vy * deltaTime + aux;
            return new Position(startPosition.getX() + x,startPosition.getY() +  y);
        };
    }

    private double getAcumulated(int deltaTime) {
        double aux = 0;
        for (int i = 0; i < deltaTime; i++) {
            aux += i;
        }
        return aux;
    }

}
