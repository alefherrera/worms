package physic;

import model.units.Position;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.function.Function;

public class PhysicCreator {

    public Function<LocalTime, Position> getSpaceAndTime(Double speed, Double angle, Position startPosition, LocalTime startTime) {
        final double gravity = -9.8;
        final double ax = 0;
        final double vx = speed * Math.cos(angle * (Math.PI / 180.0));
        final double vy = speed * Math.sin(angle * (Math.PI / 180.0));
        return localTime -> {
            final long deltaTime = startTime.until(localTime, ChronoUnit.SECONDS);
            final double x = vx * deltaTime;
            final double aux = gravity * getAcumulated(deltaTime);
            final double y = vy * deltaTime + aux;
            return new Position(startPosition.getX() + x,startPosition.getY() +  y);
        };
    }

    private double getAcumulated(long deltaTime) {
        double aux = 0;
        for (long i = 0; i < deltaTime; i++) {
            aux += i;
        }
        return aux;
    }

}
