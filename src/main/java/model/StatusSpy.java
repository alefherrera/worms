package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class StatusSpy {

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    void inform(GameStatus gameStatus) {
        String json = gson.toJson(gameStatus);
        print(json);
    }

    void inform(String s) {
        print(s);
    }

    private void print(String json) {
        System.out.println(json);
    }
}
