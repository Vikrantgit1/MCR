package TicTacToe;

import TicTacToe.Model.Players;
import TicTacToe.Service.PlayTTT;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        System.out.println("Let's TicTacToe ;) \nEnter players name :\n");
        Scanner scanner = new Scanner(System.in);

        String p1 = scanner.next();
        String p2 = scanner.next();

        List<Players> playersList = new ArrayList<>();
        playersList.add(new Players(p1,1,"X"));
        playersList.add(new Players(p2,2,"O"));

        PlayTTT playTTT = new PlayTTT(playersList,3);
        System.out.println("Result :" + playTTT.startGame());

    }
}
