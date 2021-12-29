package Chess;
import Chess.Figure.*;
import sun.applet.Main;

import java.util.Arrays;

public class
Field {
    protected ChessFigure[][] field;
    static private boolean isLog;

    static {
        isLog = false;

    }
//создаем новое поле белые вверху
    public Field() {
        this.field = new ChessFigure[8][8];

        for (int i = 0; i < field.length; i++) {
            field[1][i] = new Pawn(true);
            field[6][i] = new Pawn(false);
        }
        field[0][0] = new Rook(true);
        field[0][7] = new Rook(true);
        field[0][1] = new Knight(true);
        field[0][6] = new Knight(true);
        field[0][2] = new Bishop(true);
        field[0][5] = new Bishop(true);
        field[7][0] = new Rook(false);
        field[7][7] = new Rook(false);
        field[7][1] = new Knight(false);
        field[7][6] = new Knight(false);
        field[7][2] = new Bishop(false);
        field[7][5] = new Bishop(false);
        field[0][3] = new King(true);
        field[7][3] = new King(false);
        field[0][4] = new Queen(true);
        field[7][4] = new Queen(false);
    }
//проверка возможности хода: если в клетке, куда нужно перейти стоит фигура того же цвета, то ходить нельзя
    public boolean canMove(int[] xy) {
        // xy = { fx, fy, tx, ty }: массив с координатами - откуда и куда: A->(fx, fy) -> B->(tx, ty)
        //проверка на то, что A<>B
        if (xy[1] == xy[3] && xy[0] == xy[2]) return false;
        /*Проверяем наличие препятствий между клетками на пути по вертикальной прямой
        если координата х совпадает,нужно проверить разность межну текущей и будущей координатой у.
   Если она больше единицы,мы проверяем,не стоят ли фигуры между текущей и будущей координатой у.
   Если она равна 1,проверять не нужно,ведь между ними нет клеток.*/
        if (xy[0] == xy[2]) {
            if (Math.abs(xy[3]-xy[1])>1) {
  //определение, в каком направлении двигаться:если знак +,двигаемся вверх,если -,то вниз.
                int sgn=(int)Math.signum(xy[3]-xy[1]);
                for (int i = 1; i <= Math.abs(xy[3] - xy[1])-1; i++)
                    if (field[xy[1] + i*sgn][xy[0]] != null)
                        return false;
            }
        }
//та же самая проверка,только  по горизонтали ,зафиксирована координата у
        if (xy[1] == xy[3]) {
            if (Math.abs(xy[2]-xy[0])>1) {
                int sgn=(int)Math.signum(xy[2]-xy[0]);
                for (int i = 1; i <= Math.abs(xy[2] - xy[0])-1; i++)
                    if (field[xy[1]][xy[0] + i*sgn] != null)
                        return false;
            }
        }
        //проверка,есть ли фигуры на пути по диагонали
        if (xy[0]+xy[1]==xy[2]+xy[3]||xy[0]-xy[1]==xy[2]-xy[3]){
            int d= Math.abs(xy[3]-xy[1]);
            if (d>1){
                int sgn1=(int)Math.signum(xy[2]-xy[0]);
                int sgn2=(int)Math.signum(xy[3]-xy[1]);
                for (int i = 1; i <=d-1; i++)
                    if (field[xy[1]+i*sgn2][xy[0] + i*sgn1] != null)
                        return false;
            }
        }
 // в точке А есть фигура
        if (field[xy[1]][xy[0]] != null) {
            if (field[xy[3]][xy[2]] == null )
                return field[xy[1]][xy[0]].canMove(xy);
            else
                if (field[xy[3]][xy[2]].colorIsWhite != field[xy[1]][xy[0]].colorIsWhite){
                    //проверка рубки пешки (сначала белые, потом черные)
                    if (field[xy[1]][xy[0]].symbol=='\u2659')
                        if ( xy[3]-xy[1]==1 && Math.abs(xy[2]-xy[0])==1)
                            return true;
                        else return false;
                    if (field[xy[1]][xy[0]].symbol=='\u265f')
                        if (xy[3]-xy[1]==-1 && Math.abs(xy[2]-xy[0])==1)
                            return true;
                        else return false;
                    return field[xy[1]][xy[0]].canMove(xy);
                }
                else   return false;
        } else return false;
    }

    public void move(int[] xy) {
// xy = { fx, fy, tx, ty }: массив с координатами - откуда и куда: A->(fx, fy) -> B->(tx, ty)
// field[xy[1]][xy[0]].move(xy[3], xy[2]);
        field[xy[3]][xy[2]] = field[xy[1]][xy[0]];
        field[xy[1]][xy[0]] = null;
           }
    public boolean gtiswhitecolor(int[] xy){
        return field[xy[1]][xy[0]].colorIsWhite;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < field.length; i++) {
            result.append(8 - i).append("|");
            for (ChessFigure chessFigure : field[7 - i])
                result.append(chessFigure !=null ?chessFigure: "  ");
            result.append("\n");
        }
        result.append("------------------\n  A B C D E F G H");
        return result.toString();

    }
}