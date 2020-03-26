public class Piece{
    private char symbol;
    private int value;

    public Piece(char input_symbol, int input_val){
        this.symbol= input_symbol;
        this.value= input_val;
    }
    public char getSymbol(){
        return this.symbol;
    }
    public int getValue(){
        return this.value;
    }
}