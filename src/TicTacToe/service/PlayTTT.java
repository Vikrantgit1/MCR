package TicTacToe.service;

import TicTacToe.model.Board;
import TicTacToe.model.Players;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PlayTTT {

    int boardSize;

    Board board;

    List<Players> playersList;

    public PlayTTT(List<Players> playersList, int i) {
        boardSize = i;
        board = new Board(boardSize);
        this.playersList = playersList;
    }

    BoardService boardService = new BoardService();

    public String startGame() {
        boolean result = false;

        Deque<Players> dq = new LinkedList<>();

        for(Players players:playersList) dq.addLast(players);

        while (!result){
            board.showBoard();
            Players players = dq.removeFirst();
            System.out.println(players.getName()+"'s turn : Enter position (x,y)");

            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();
            String [] inputArr = input.split(",");

            if(inputArr[0].equalsIgnoreCase("quit")){
                System.out.println("Match abandoned");
                return "";
            }
            if(inputArr.length<2){
                System.out.println("The entered position is invalid, please try again");
                dq.addFirst(players);
                continue;
            }

            int x = Integer.parseInt(inputArr[0]);
            int y = Integer.parseInt(inputArr[1]);

            String c = players.getSymbol();

            if(!boardService.insert(x,y,c,board)){
                System.out.println("The selected position is already occupied. Please try again");
                dq.addFirst(players);
                continue;
            }
            if(boardService.isWinner(board.getBoard(),x,y,c)){
                return "The winner is : "+ players.showPLayer();
            }

            result = boardService.isFilled(board.getBoard());

            dq.addLast(players);
        }
        return "The match is tied";
    }
}
