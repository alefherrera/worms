package model;

public class Controller {

    public Controller(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Controller{" +
                "name='" + name + '\'' +
                '}';
    }
}
