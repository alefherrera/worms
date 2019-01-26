package model;

import java.util.concurrent.atomic.AtomicBoolean;

public class Looper implements Runnable {

    private Thread worker;

    private final AtomicBoolean running = new AtomicBoolean(false);
    private final Integer interval;
    private final StatusSpy statusSpy;
    private Game game;
    private final AtomicBoolean needRefresh = new AtomicBoolean(true);

    public Looper(Integer interval, StatusSpy statusSpy) {
        this.interval = interval;
        this.statusSpy = statusSpy;
    }

    void start(Game game) {
        this.game = game;
        worker = new Thread(this);
        worker.start();
    }

    void stop() {
        running.set(false);
    }

    void needToRefresh() {
        needRefresh.set(true);
    }

    @Override
    public void run() {
        running.set(true);
        while (running.get()) {
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                statusSpy.inform("Thread was interrupted, Failed to complete operation");
            }

            if (needRefresh.compareAndSet(true, false)) {
                GameStatus gameStatus = game.getStatus();
                statusSpy.inform(gameStatus);
            }
        }
    }
}
