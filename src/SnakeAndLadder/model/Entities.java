package SnakeAndLadder.model;

import java.util.Map;

public class Entities {
    Map<Integer,Integer> snakes;
    Map<Integer,Integer> ladders;

    public Entities(Map<Integer, Integer> snakes, Map<Integer, Integer> ladders) {
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public Map<Integer, Integer> getSnakes() {
        return snakes;
    }

    public void setSnakes(Map<Integer, Integer> snakes) {
        this.snakes = snakes;
    }

    public Map<Integer, Integer> getLadders() {
        return ladders;
    }

    public void setLadders(Map<Integer, Integer> ladders) {
        this.ladders = ladders;
    }
}
