package TicTacToe.model;

public class Players {
    String name;
    Integer id;
    String symbol;

    public Players(String p1, int i, String x) {
        name = p1;
        id = i;
        symbol = x;
    }

    public String showPLayer() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nName : "+name);
        stringBuilder.append("\nSymbol : "+symbol);
        return stringBuilder.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
