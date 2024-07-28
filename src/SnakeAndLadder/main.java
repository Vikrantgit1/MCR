package SnakeAndLadder;

import SnakeAndLadder.model.Entities;
import SnakeAndLadder.service.Initializer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        System.out.println("Let's play Snakes n Ladders !!!");

        Initializer initializer = new Initializer();
        initializer.setupGame();
        initializer.startGame();
    }
}
