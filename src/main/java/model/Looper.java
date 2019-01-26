package model;

import com.google.gson.Gson;

import java.util.concurrent.atomic.AtomicBoolean;

public class Looper implements Runnable {

    private Thread worker;
    private Gson gson = new Gson();
    private final AtomicBoolean running = new AtomicBoolean(false);
    private final Integer interval;
    private Game game;
    private final AtomicBoolean needRefresh = new AtomicBoolean(false);

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

    public void needToRefresh() {
        needRefresh.set(true);
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
            if (needRefresh.get()) {
                needRefresh.set(false);
                GameStatus gameStatus = game.getStatus();
                System.out.println(gson.toJson(gameStatus));
            }
        }
    }
}
