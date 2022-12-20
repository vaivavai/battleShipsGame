package ui;

import static utils.Board.gridFull;
import static utils.Board.gridForPlayerVisual;
import static utils.Board.scanner;

import java.util.Random;
import services.PrintingService;
import utils.Board;
import utils.Ships;

public class GameActions {

  public static void playerGuess() {
    while (true) {
      int x = getXCoordinate();
      int y = getYCoordinate();

      if (x > 0 && x <= Board.size && y > 0 && y <= Board.size) {

        if ('X' == gridFull[x - 1][y - 1]) {
          System.out.println("You sunk opponents ship!");
          gridFull[x - 1][y - 1] = '*';
          gridForPlayerVisual[x - 1][y - 1] = '*';
          Ships.shipsComputer--;
          break;
        } else if (gridFull[x - 1][y - 1] == '#') {
          System.out.println("You can't sink your own ship!!!");
        } else if (gridFull[x - 1][y - 1] == 'O') {
          System.out.println("Shoot again!");
        } else if ('_' == gridFull[x - 1][y - 1]) {
          System.out.println("You missed!");
          gridFull[x - 1][y - 1] = 'O';
          gridForPlayerVisual[x - 1][y - 1] = 'O';
          break;
        }

      } else {
        System.out.println("Out of bounds! The coordinates must be between 1 and 8.");
      }

    }
    PrintingService.printScoreInfo();
    Board.drawBoard(gridForPlayerVisual);
  }


  public static void computerGuess() {
    Random rand = new Random();
    int maxNumber = Board.size;

    while (true) {
      int x = rand.nextInt(maxNumber);
      int y = rand.nextInt(maxNumber);
      if (x <= Board.size - 1 && y <= Board.size - 1) {

        if ('#' == gridFull[x][y]) {
          System.out.println("Computer hit player ship!");
          gridFull[x][y] = '*';
          gridForPlayerVisual[x][y] = '*';
          Ships.shipsPlayer--;
          break;
        } else if (gridFull[x][y] == 'X'
            || gridFull[x - 1][y - 1] == 'O') { // can't sink its own ship
          System.out.println("Oops! Can't shoot here. Choosing other coordinates!");
        } else if ('_' == gridFull[x][y]) {
          System.out.println("Computer missed.");
          gridFull[x][y] = 'O';
          gridForPlayerVisual[x][y] = 'O';
          break;
        }

      } else {
        System.out.println("Out of bounds! The coordinates must be between 1 and 8.");
      }
    }
    PrintingService.printScoreInfo();
    Board.drawBoard(gridForPlayerVisual);
  }

  private static int getYCoordinate() {
    System.out.println("Guess y coordinate");
    int y = scanner.nextInt();
    return y;
  }

  private static int getXCoordinate() {
    System.out.println("\nGuess x coordinate");
    int x = scanner.nextInt();
    return x;
  }
}
