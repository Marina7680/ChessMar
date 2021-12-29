package Chess.Figure;

import Chess.ChessFigure;

public class Bishop extends ChessFigure {

    public Bishop(boolean colorIsWhite) {
        super(colorIsWhite, colorIsWhite ? '\u2657' : '\u265d');
    }

    @Override
    public boolean canMove(int[] xy ) {

        return ((xy[0]+xy[1]==xy[2]+xy[3])||(xy[0]-xy[1]==xy[2]-xy[3]));
    }
}
