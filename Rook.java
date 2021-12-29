package Chess.Figure;

import Chess.ChessFigure;
import Chess.Field;
public class Rook extends ChessFigure {
   //rivate Field field;
//super-ссылка на родительский класс
  //  static private final Field field;

    //private ChessFigure ;

    public Rook(boolean colorIsWhite) {
        super(colorIsWhite, colorIsWhite ? '\u2656' : '\u265c');

    }

    @Override
    public boolean canMove(int[] xy){

        return (xy[0] == xy[2])||(xy[1] == xy[3]);

    }


}
