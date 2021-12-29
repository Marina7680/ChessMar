import Chess.Field;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static private final Field field;
    static private boolean isGameFinish;
    static private boolean isLog;
    static public int counthod;
//создаём новое поле, запускаем игру
    static {
        field = new Field();
        isGameFinish = false;
        isLog = false;
        counthod=1;
    }

  //  private Main main;

    public static void main(String[] args) {
        //распечатываем доску, продолжаем игру, пока isGameFinish=false,
        showBoard();

        // пока не конец игры ждем правильно введенных данных хода,и в случае их получения перемещаем фигуру в новую позицию(проверяем возможность хода фигурой процедурой canmove)
        while (!isGameFinish) {
            int[] data = isInputDataCorrect();
            if ((field.gtiswhitecolor(data)==true && counthod % 2==1 )||(field.gtiswhitecolor(data)==false && counthod % 2==0)) {
                if (field.canMove(data)) {
                    field.move(data);
                    counthod++;
                } else {
                    showError();
                    continue;
                }
            } else  {System.out.println("Ожидается ход фигуры другого цвета!");
                continue;}
            showBoard();
        }
    }
// метод формирует строку ошибки
private static void showError(){
    System.out.println("Совершить указанный ход невозможно!");
}


    /**
     * Чтение данных о ходе
     *
     * @return строка с координатами
     */

    private static String readInputData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ход в виде \'e2e4\'");
        return sc.nextLine().toLowerCase(Locale.ROOT);
    }

    /**
     * Вывод на экран актуального состояния шахматного поля
     */
    private static void showBoard() {
        System.out.println(field);
    }

    /**
     * Обработка данных после ввода и проверка на валидность координат
     */

    private static int[] isInputDataCorrect() {
        int count = 0;
        int[] coor = new int[4];  // массив с координатами - откуда и куда: A->(fx, fy) -> B->(tx, ty)
        do {
            count = 0;
            char[] data = readInputData().toCharArray();
            if (isLog)
                System.out.println(Arrays.toString(data));
            if (data.length == 4) {
                if (data[0] >= 'a' && data[0] <= 'h') {
                    coor[0] = data[0] - 'a';
                    count++;
                }
                if (data[1] >= '1' && data[1] <= '8') {
                    coor[1] = data[1] - '1';
                    count++;
                }
                if (data[2] >= 'a' && data[2] <= 'h') {
                    coor[2] = data[2] - 'a';
                    count++;
                }
                if (data[3] >= '1' && data[3] <= '8') {
                    coor[3] = data[3] - '1';
                    count++;
                }
                if (isLog)
                    System.out.println(Arrays.toString(coor));
            }
            if (data.length == 5) {
                if (data[0] >= 'a' && data[0] <= 'h') {
                    coor[0] = data[0] - 'a';
                    count++;
                }
                if (data[1] >= '1' && data[1] <= '8') {
                    coor[1] = data[1] - '1';
                    count++;
                }
                if (data[3] >= 'a' && data[3] <= 'h') {
                    coor[2] = data[3] - 'a';
                    count++;
                }
                if (data[4] >= '1' && data[4] <= '8') {
                    coor[3] = data[4] - '1';
                    count++;
                }
                if (isLog)
                    System.out.println(Arrays.toString(coor));
            }
            if (count != 4) System.out.println("Incorrect input data. Try again");
            else if (isLog) System.out.println("Input data is correct. Thank you");
        } while (count != 4);
        return coor;
    }
}
