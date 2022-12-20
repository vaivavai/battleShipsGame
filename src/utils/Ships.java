package utils;

import java.util.Random;
import java.util.Scanner;

public class Ships {

  public static Scanner scanner = new Scanner(System.in);
  public static int shipsPlayer = 5;
  public static int shipsComputer = 5;

  public static int getShipsPlayer() {
    return shipsPlayer;
  }

  public static int getShipsComputer() {
    return shipsComputer;
  }

  public static void deployPLayerShips() {
    System.out.println("Please deploy your ships on the board.");

    for (int i = 0; i < shipsPlayer; i++) {
      int x = getXCoordinate();
      int y = getYCoordinate();
      if (x > 0 && x <= Board.gridFull.length && y > 0 && y <= Board.size) {
        Board.gridFull[x - 1][y - 1] = '#';
        Board.gridForPlayerVisual[x - 1][y - 1] = '#';
      } else {
        System.out.println(
            "Out of bounds! The coordinates must be between 1 and " + Board.size + ".");
        i--;
      }
    }
    System.out.println("Your ships on board: ");
    Board.drawBoard(Board.gridForPlayerVisual);
  }

  public static void deployComputerShips() {
    System.out.println("Computer is deploying the ships.....");
    Random rand = new Random();
    int maxNumber = Board.size;
    for (int i = 0; i < shipsComputer; i++) {
      int x = rand.nextInt(maxNumber);
      int y = rand.nextInt(maxNumber);
      if (x < Board.gridFull.length && y < Board.size && Board.gridFull[x][y] != 'X'
          && Board.gridFull[x][y] != '#') {
        Board.gridFull[x][y] = 'X';
        System.out.println("Ship nr. " + (i + 1) + " is deployed.");
      } else {
        i--;
      }
    }
    System.out.println("Computer deployed all of its ships.");
  }

  private static int getYCoordinate() {
    System.out.println("Coordinate y: ");
    int y = scanner.nextInt();
    return y;
  }

  private static int getXCoordinate() {
    System.out.println("Coordinate x: ");
    int x = scanner.nextInt();
    return x;
  }
}




