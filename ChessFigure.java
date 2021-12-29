package Chess;

public abstract class ChessFigure {
    protected boolean colorIsWhite; // true = white, false = black
    protected boolean isOnBoard;  // true = onBoard
    protected char symbol; // '\u2654'..'\u265f';
    //protected int x, y;
   // private final ChessFigure chessFigure;

    // protected Field field;
//класс шахматная фигура, характеризуется цветом(colorIsWhite), флагом наличия на доске(isOnBoard), типом фигуры(symbol) и координатами x,y
    public ChessFigure(boolean colorIsWhite, char symbol) {
        this.colorIsWhite = colorIsWhite;
        this.isOnBoard = true;
        this.symbol = symbol;

    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }


    public abstract boolean canMove(int[] xy);

}
