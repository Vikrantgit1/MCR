package TicTacToe.Model;

import java.util.List;

public class Board {
    int n;
    String [][] board;
    public Board(int n){
        this.n = n;
        board = new String[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]="";
            }
        }
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    public void showBoard() {
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print("|"+board[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
