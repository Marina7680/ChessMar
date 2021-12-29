package Chess.Figure;

import Chess.ChessFigure;

public class Queen extends ChessFigure {

    public Queen(boolean colorIsWhite) {
        super(colorIsWhite, colorIsWhite ? '\u2655' : '\u265b');
    }

    @Override
    public boolean canMove(int[] xy) {

        return ((xy[0]+xy[1]==xy[2]+xy[3])||(xy[0]-xy[1]==xy[2]-xy[3])||(xy[0] == xy[2])||(xy[1] == xy[3]));
    }
}