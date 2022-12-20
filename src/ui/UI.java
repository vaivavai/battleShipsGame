package ui;

import services.PrintingService;
import utils.Board;
import utils.Ships;

public class UI {

  public void startGame() {

    PrintingService.printGameStartInfo();

    // We start with empty boards
    produceEmptyBoards();

    //The board is printed for player visual before deploying its ships
    Board.drawBoard(Board.gridForPlayerVisual);

    //Player deploys ships (on both grids) and the "grid for player visual" board is printed with player ships (will be used throughout the game for visual)
    Ships.deployPLayerShips();

    // computer deploys ships (only on "gridFull" board used for actual game not for printing)
    Ships.deployComputerShips();

    processGuesses();

    processResults();
  }

  private static void produceEmptyBoards() {
    Board.makeEmptyBoard(Board.gridFull);
    Board.makeEmptyBoard(Board.gridForPlayerVisual);
  }

  private static void processResults() {
    if (Ships.shipsPlayer == 0) {
      System.out.println("Computer won the game! ");
    } else if (Ships.shipsComputer == 0) {
      System.out.println("Congratulations!! You won the game!");
    }
  }

  private static void processGuesses() {
    while (Ships.shipsPlayer != 0 && Ships.shipsComputer != 0) {
      GameActions.playerGuess();
      if (Ships.shipsPlayer != 0 && Ships.shipsComputer != 0) {
        GameActions.computerGuess();
      }
    }
  }
}


