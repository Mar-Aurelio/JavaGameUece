import java.util.Map;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);

    int numPlayers = 0;
    while (numPlayers < 1 || numPlayers > 6) {
      System.out.print("Quantos jogadores vão jogar (1 a 6)? ");
      numPlayers = input.nextInt();
      input.nextLine();
    }
    
    String[] colors = {"Azul", "Marrom", "Verde", "Preto", "Branco", "Roxo"};
    Board gameBoard = new Board(numPlayers, colors);

    boolean endGame = false;
    while (!endGame) {
      System.out.println("\nTabuleiro");
      showBoard(gameBoard);

      displayTurnInfo(gameBoard);
      
      System.out.println("Pressione enter para jogar seus dados");
      input.nextLine();
      System.out.println("Lançando dados");

      try {
        TimeUnit.MILLISECONDS.sleep(700);
      } catch (Exception e) {
        e.printStackTrace();
      }

      gameBoard.executeTurn();
      endGame = gameBoard.checkWinners();

      if (endGame) {
        gameBoard.getEndGameStats();
      }

      System.out.println("Movendo peça");
      try {
        TimeUnit.MILLISECONDS.sleep(1500);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    input.close();
  }

  private static void displayTurnInfo(Board board) {
    System.out.println("\nTurno de: " + board.getCurrentTurn());
  }

  private static void showBoard(Board board) {
    Map<Integer,AbstractMap.SimpleEntry<Space, ArrayList<Character>>> currBoard = board.getCurrentBoard();

    printBoardLine(currBoard, 0, 7);
    printBoardLine(currBoard, 8, 15);
    printBoardLine(currBoard, 16, 23);
    printBoardLine(currBoard, 24, 31);
    printBoardLine(currBoard, 32, 39);

    System.out.println("--------\n| *40* |\n| **** |\n--------");
  }

  private static void printBoardLine(Map<Integer,AbstractMap.SimpleEntry<Space, ArrayList<Character>>> board, int start, int end) {
    System.out.println("----------------------------------------------------------------");
    
    for (Integer i = start; i <= end; i++) {
      System.out.print("| " + board.get(i).getKey().getSymbol() + String.format("%2s", i.toString()) + board.get(i).getKey().getSymbol() +" |");
    }
    System.out.println();

    for (int i = start; i <= end; i++) {
      StringBuilder sb = new StringBuilder();
      for (Character element : board.get(i).getValue())
        sb.append(element);

      String str = String.format("%-6s", sb.toString());

      System.out.print("|" + str + "|");
    }
    System.out.println();

    System.out.println("----------------------------------------------------------------");
  }
}
