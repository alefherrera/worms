package model;

import java.util.concurrent.atomic.AtomicBoolean;

public class Looper implements Runnable {

    private Thread worker;
    private final AtomicBoolean running = new AtomicBoolean(false);
    private final Integer interval;
    private Game game;
    private GameStatus lastStatus;

    public Looper(Integer interval) {
        this.interval = interval;
    }

    public void start(Game game) {
        this.game = game;
        worker = new Thread(this);
        worker.start();
    }

    public void stop() {
        running.set(false);
    }

    @Override
    public void run() {
        running.set(true);
        while (running.get()) {
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.println(
                        "Thread was interrupted, Failed to complete operation");
            }
            printGameStatus();
        }
    }

    private void printGameStatus() {
        GameStatus gameStatus = game.getStatus();
        if (!gameStatus.equals(lastStatus)) {
            lastStatus = gameStatus;
            System.out.println(gameStatus);
        }
    }
}
