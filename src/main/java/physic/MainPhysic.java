package physic;

public class MainPhysic {

    public static void main(String[] args) {

        double speed = 80.0;
        double deltaTime = 1.0;
        double x = 0.0;
        double y = 0.0;
        double ay = -9.8;
        double ax = 0;
        double angle = 45;
        double vx = speed * Math.cos(angle * (Math.PI / 180.0));
        double vy = speed * Math.sin(angle * (Math.PI / 180.0));

        double time = 0.0;
        while (y >= 0) {
            time += deltaTime;
            x += vx * deltaTime;
            y += vy * deltaTime;
            System.out.println("vy: " + vy);
            vx += ax * deltaTime;
            vy += ay * deltaTime;
            System.out.println("x: " + x + ", y: " + y + ", time: " + time+ ", vy: " + vy);
        }
    }
}
