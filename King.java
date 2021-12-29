package Chess.Figure;

import Chess.ChessFigure;

public class King extends ChessFigure {


    public King(boolean colorIsWhite) {
        super(colorIsWhite, colorIsWhite ? '\u2654' : '\u265a');

    }


    @Override
    public boolean canMove(int[] xy) {
        return (Math.abs(xy[0] - xy[2]) <= 1 && Math.abs(xy[1] - xy[3]) <= 1);
    }
}
