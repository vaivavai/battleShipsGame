
package utils;

import java.util.Arrays;
import java.util.Scanner;

public class Board {

  public static Scanner scanner = new Scanner(System.in);
  public static int size = 8;

  // used for actual game logic
  public static char[][] gridFull = new char[size][size];

  // board used for game visuals (during the game, computer are ships not visible)
  public static char[][] gridForPlayerVisual = new char[size][size];

  public static void makeEmptyBoard(char[][] grid) {
    for (char[] row : grid) {
      Arrays.fill(row, '_');
    }
  }

  public static void drawBoard(char[][] grid) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < grid.length; i++) {
      if (i > 0) {
        result.append(i + 1); // vertical plane numbering
        result.append("  ");
      }

      if (i == 0) {
        result.append("   "); // instead of row number
        for (int k = 0; k < grid[i].length; k++) { //horizontal plane numbering
          result.append(k + 1);
          result.append("  ");
        }
        result.append("\n" + 1 + "  "); // 1st row numbering
      }

      for (int j = 0; j < grid[i].length; j++) {
        result.append(grid[i][j]);
        result.append("  ");
      }
      result.append("\n");
    }

    System.out.println(result);
  }

}
