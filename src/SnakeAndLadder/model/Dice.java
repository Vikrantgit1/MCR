package SnakeAndLadder.model;

import java.util.Random;

public class Dice {
    int n;
    Random random;

    public Dice(int n) {
        this.n = n;
        this.random = new Random();
    }

    public int rollDice(){
        return this.random.nextInt(n)+1;
    }

}
