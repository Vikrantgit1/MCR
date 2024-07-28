package SnakeAndLadder.service;

import SnakeAndLadder.model.Dice;
import SnakeAndLadder.model.Entities;
import SnakeAndLadder.model.Player;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Initializer {
    static Dice dice = new Dice(6);
    static List<Player> playerList = new ArrayList<>();
    static Entities entities;

    public void setupGame() {
        System.out.println("Enter no. of players and names of each.\nThen enter snake and ladder values");
        Scanner scanner = new Scanner(System.in);

        int playerCount = scanner.nextInt();
        while(playerCount-- > 0){
            playerList.add(new Player(1, scanner.next(), 0));
        }

        Map<Integer,Integer> snakes = new HashMap<>();
        Map<Integer,Integer> ladders = new HashMap<>();

        int snakesCount = scanner.nextInt();
        while(snakesCount-- > 0){
            int head = scanner.nextInt();
            int tail = scanner.nextInt();
            snakes.put(head,tail);
        }
        int ladderCount = scanner.nextInt();
        while(ladderCount-- > 0){
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            ladders.put(start,end);
        }
        this.entities = new Entities(snakes,ladders);
    }

    public void startGame() {
        Deque<Player> dq = new LinkedList<>();
        for(Player p:playerList){
            dq.addLast(p);
        }
        boolean result = false;
        while(!result){
            Player player = dq.removeFirst();
            int move = dice.rollDice();
            if(move+player.getPosition()>100){
                dq.addFirst(player);
                System.out.println("\n"+player.getName()+" rolled a "+move+", but cannot move above 100");
                continue;
            }
            player.setPosition(player.getPosition()+move);
            StringBuilder stringBuilder = new StringBuilder("\n"+player.getName()+" rolled a "+move+" and moved to "+player.getPosition());
            if(entities.getSnakes().containsKey(player.getPosition())){
                player.setPosition(entities.getSnakes().get(player.getPosition()));
                stringBuilder.append("\nMoreover, caught a snake, and fallen to "+player.getPosition());
            }
            else if(entities.getLadders().containsKey(player.getPosition())){
                player.setPosition(entities.getLadders().get(player.getPosition()));
                stringBuilder.append("\nMoreover, caught a ladder, and jumped to "+player.getPosition());
            }
            System.out.println(stringBuilder);
            if(player.getPosition()==100){
                System.out.println();
                System.out.println(player.getName() + " is the winner!!!");
                result = true;
            }
            dq.addLast(player);
        }
    }
}
