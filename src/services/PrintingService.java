package services;

import utils.Ships;

public class PrintingService {

  public static void printScoreInfo() {
    if (Ships.getShipsPlayer() == 1) {
      System.out.println("You have " + Ships.getShipsPlayer() + " ship left.");
    } else {
      System.out.println("You have " + Ships.getShipsPlayer() + " ships left.");
    }
    if (Ships.getShipsComputer() == 1) {
      System.out.println("Computer has " + Ships.getShipsComputer() + " ship left.");
    } else {
      System.out.println("Computer has " + Ships.getShipsComputer() + " ships left.");
    }

  }

  public static void printGameStartInfo() {
    System.out.println("\n========= Welcome to Battle Ships game! =========");
    System.out.println("| You will be playing against the computer.     |");
    System.out.println(
        "| On the game board:                            |"
            + "\n|    # - marks your ships                       | "
            + "\n|    0 - marks missed shots                    | "
            + "\n|    * - marks sunk ship                        | "
            + "\n================================================= \n");
  }

}
