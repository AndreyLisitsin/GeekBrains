package lesson4;

import java.util.Random;
import java.util.Scanner;

public class Lesson4 {
    private final static char PLAYER_DOT = 'X';
    private final static char AI_DOT = '0';
    private final static char EMPTY_DOT = '•';

    private final static byte MAP_SIZE = 3;
    private final static char[][] MAP = new char[MAP_SIZE][MAP_SIZE];
    private static int endCount = MAP_SIZE*MAP_SIZE;

    private final static Scanner scanner = new Scanner(System.in);
    private final static Random random = new Random();

    private final static int pointsForVictory = 3;
    private  static int winCount = 0;
    private static boolean isWin = false;
    private static boolean isEnd = false;

    private  static int vertical;
    private  static int gorizontal;


    public static void main(String[] args) {

        fillTheMap(MAP);
        while (!isEnd) {
            drawMap(MAP);
            playerTern(MAP);
            checkWin(PLAYER_DOT);
            checkEnd(PLAYER_DOT);
            AI_Turn(MAP);
            checkWin(AI_DOT);
            checkEnd(AI_DOT);

        }
    }

    private static void fillTheMap(char[][] map){
        for (int i = 0; i <MAP_SIZE ; i++) {
            for (int j = 0; j <MAP_SIZE ; j++) {
                map[i][j] = EMPTY_DOT;
            }
        }
    }

    private static void drawMap(char[][] map){
        System.out.print('♦' + " ");
        for (int i = 0; i <MAP_SIZE; i++) {
            System.out.print(i+1+" ");
        }
        System.out.println();
        for (int i = 0; i <MAP_SIZE; i++) {
            System.out.print(i+1+" ");
            for (int j = 0; j <MAP_SIZE ; j++) {
                System.out.print(MAP[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void playerTern(char[][] map){

        System.out.println("Ход игрока!");
        while (true) {

            System.out.println("Введите координату по горизонтали:");
            int x = scanner.nextInt() - 1;


            System.out.println("Введите координату по Вертикали:");
            int y = scanner.nextInt() - 1;

            if (map[x][y] == EMPTY_DOT) {
                map[x][y] = PLAYER_DOT;
                fillTheLastIndex(x,y);
                break;
            }
            else
                System.out.println("Выберите другую координату, данная клетка уже заполнена!");
        }
        endCount--;
    }

    private static void AI_Turn(char[][] map) {
        while (true) {
            int x = random.nextInt(MAP_SIZE);
            int y = random.nextInt(MAP_SIZE);
            if (map[x][y] == EMPTY_DOT){
                map[x][y] = AI_DOT;
                fillTheLastIndex(x,y);
                break;
            }
        }
        endCount--;
    }

    private static void checkWin(char c){

        for (int j = 0; j < MAP_SIZE ; j++) {
            if(MAP[gorizontal][j] == c) {
                winCount++;
                if (winCount == pointsForVictory) {
                    if (c == PLAYER_DOT) {
                        System.out.println("Вы победили!");
                    }
                    else
                        System.out.println("Компьтер победил!");
                    isWin = true;
                    break;
                }
            }
            else {
                winCount = 0;
                isWin = false;
            }
        }
        for (int i = 0; i < MAP_SIZE ; i++) {
            if(MAP[i][vertical] == c) {
                winCount++;
                if (winCount == pointsForVictory) {
                    if (c == PLAYER_DOT) {
                        System.out.println("Вы победили!");
                    }
                    else
                        System.out.println("Компьтер победил!");
                    isWin = true;
                }
            }
            else {
                winCount = 0;
                isWin = false;
            }
        }
        checkDiagonal(gorizontal, vertical, c);
    }

    private static void fillTheLastIndex(int x, int y){
        gorizontal = x;
        vertical = y;
    }

    private static void checkDiagonal(int gorizontal, int vertical, char c) {
        while (vertical > 0 || gorizontal < MAP_SIZE-1) {
            if (vertical==0 || gorizontal==MAP_SIZE-1)
                break;
            vertical--;
            gorizontal++;
        }
        while (true) {
            if (vertical == MAP_SIZE-1 || gorizontal == 0)
                break;
            if (MAP[gorizontal][vertical] == c) {
                winCount++;
                if (winCount == pointsForVictory) {
                    if (c == PLAYER_DOT) {
                        System.out.println("Вы победили!");
                    } else
                        System.out.println("Компьтер победил!");
                    isWin = true;
                    break;
                }
            } else {
                winCount = 0;
                isWin = false;
            }
            vertical++;
            gorizontal--;
        }
    }

    private static void checkEnd(char c){
        if(isWin == true) {
            System.out.println("Game is over");
            isEnd = true;
        }
        else if (endCount == 0)
            isEnd = true;
        else
            isEnd = false;
    }


}
