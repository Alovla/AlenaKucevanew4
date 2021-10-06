package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static char[][] map;
    public static final int SIZE = 3;
    public static int DotsToWin = 3;

    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static final char DOT_EMPTY = '.';

    public static void main(String[] args) {
        // инициировать игровое поле
        initMap();

        // отоброжение игрового поля в консоле
        printMap();
        // циклично
        // ход игрока
        // проверка на победу
        // проверка на ничью
        // ход ИИ
        // проверка на победу
        // проверка на ничью
while (true) {
    humanTurn();
    printMap();
    if( Winner(DOT_X)) {
        System.out.println("Победил игрок!");
        break;}
        if (isMapFull()) {
            System.out.println("Ничья");
            break;
        }
    iiTurn();
    printMap();
    if( Winner(DOT_O)) {
        System.out.println("Победил компьютер!");
        break;
    }
    if(isMapFull()) {
        System.out.println("Ничья!");

    }}
}

    public static void initMap(){
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    public static void printMap() {
        for(int i = 0; i <= SIZE; i++){
            System.out.print(i+" ");
        }
            System.out.println();

            for (int i = 0; i<SIZE; i++) {
                System.out.print((i+1)+" ");
                for(int j=0;j<SIZE; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }
        public static void humanTurn(){
        int x;
        int y;

            Scanner scanner = new Scanner(System.in);
            do {
                System.out.println("Введите Х или У");
                x = scanner.nextInt() - 1;
                y = scanner.nextInt() - 1;
            } while (!isCellValid(x,y));


            map [y][x] = DOT_X;
        }
    public static boolean isMapFull(){
        for (int i= 0; i<SIZE; i++) {
            for( int j= 0; j< SIZE; j++) {
                if ( map[i][j] == DOT_EMPTY)
                    return false;
            }
        }
        return true;
    }
        public static void iiTurn(){
        int x;
        int y;
            Random random = new Random();
            do {
                System.out.println("Введите Х или У");
                x = random.nextInt(SIZE) - 1;
                y = random.nextInt(SIZE) - 1;
            } while (!isCellValid(x,y));
            map[y][x]= DOT_O;
        }


        public static boolean isCellValid(int x, int y){
        if(0 < x || 0 < y || x >= SIZE || y >= SIZE){
            return false;
        }
        if ( map[y][x] == DOT_EMPTY ){
            return true;
        }
        return false;
        }
        public static boolean Winner (char symb) {
            int endOffset = map.length - DotsToWin;
            for (int rowoffset = 0; rowoffset <= endOffset; rowoffset++) {
                for (int colomnOffset = 0; colomnOffset <= endOffset; colomnOffset++) {
                    boolean hasWin =
                            isLinesFilledWith(symb, rowoffset, colomnOffset) ||
                                    isDiagonalsFilledWith(symb, rowoffset, colomnOffset);
                    if (hasWin) {
                        return true;
                    }
                }
            }
            return false;
        }
        public static boolean isLinesFilledWith (char symb, int rowOffset, int colomnOffset) {
            for (int row = rowOffset; row < (DotsToWin + rowOffset); row++) {
                int gorizontWin = 0;
                int vertikalWin = 0;
                for (int colomn = colomnOffset; colomn < (DotsToWin + colomnOffset); colomn++) {
                    // проверка горизонтали
                    if (map[row][colomn] == symb) {
                        gorizontWin++;
                    } else {
                        gorizontWin = 0;
                    }
                    // проверка по вертикали
                    if (map[colomn][row] == symb) {
                        vertikalWin++;
                    } else {
                        vertikalWin = 0;
                    }
                    if ((gorizontWin == DotsToWin) || (vertikalWin == DotsToWin)) {
                        return true;
                    }
                }
                return false;
            }
        public static boolean isDiagonalsFilledWith(char symb; int rowOffset; int colomnOffset)
            {
                for ( int colomn = rowOffset; colomn< (DotsToWin = colomnOffset); colomn++ ){
                int mainDiagonalCounter = 0;
                int sideDiagonalCounter = 0;
                for (int row = 0; row < DotsToWin; row++) {
                    // проверка главно диагонали
                    if (map[row + rowOffset][row + colomnOffset] == symb) {
                        mainDiagonalCounter++;
                    } else {
                        mainDiagonalCounter = 0;
                    }
                    // проверка побочной диагонали
                    if (map[row + rowOffset][DotsToWin - 1 - row + colomnOffset] == symb) {
                        sideDiagonalCounter++;
                    } else {
                        sideDiagonalCounter = 0;
                    }
                    return (mainDiagonalCounter == DotsToWin) || (sideDiagonalCounter == DotsToWin);
                }
                        }
                    }
    }}
