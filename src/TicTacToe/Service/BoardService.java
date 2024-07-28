package TicTacToe.Service;

import TicTacToe.Model.Board;

public class BoardService {

    public boolean insert(int x, int y, String c, Board board) {
        if(board.getBoard()[x][y].isEmpty()){
            board.getBoard()[x][y] = c;
            return true;
        }
        return false;
    }

    public boolean isWinner(String[][] board, int x, int y, String s) {

        boolean r=true,c=true,d=true;

        for(int i=0;i<3;i++){
            if(board[i][y].isEmpty() || !board[i][y].equalsIgnoreCase(s)){
                r=false;
                break;
            }
        }
        for(int i=0;i<3;i++){
            if(board[x][i].isEmpty() || !board[x][i].equalsIgnoreCase(s)){
                c=false;
                break;
            }
        }
        if(x==y){
            for(int i=0;i<3;i++){
                if(board[i][i].isEmpty() || !board[i][i].equalsIgnoreCase(s)){
                    d=false;
                    break;
                }
            }
        }
        else if(d && x+y==2){
            for(int i=0;i<3;i++){
                if(board[i][2-i].isEmpty() || !board[i][2-i].equalsIgnoreCase(s)){
                    d=false;
                    break;
                }
            }
        }
        else d=false;

        return r||c||d;
    }

    public boolean isFilled(String[][] board) {
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j].isEmpty()) return false;
            }
        }
        return true;
    }
}
