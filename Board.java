import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Board{
  private Space[] spaces;
  private Player[] players;
  private int numPlayers;
  private int currPlayer;
  private String winner;

  private final int[] spaceSkip = {10, 25, 38};
  private final int[] spaceSurprise = {13};
  private final int[] spaceLuck = {5, 15, 30};
  private final int[] spaceFU = {17, 27};
  private final int[] spaceSwap = {20, 35};

  private boolean isInIntArray(int[] array, int value) {
    for (int i : array) {
      if (value == i) return true;
    }

    return false;
  }

  public Board(int numPlayers, String[] colors) {
    currPlayer = 0;
    this.numPlayers = numPlayers;
    spaces = new Space[40];
    players = new Player[numPlayers];

    for (int i = 0; i < 40; i++) {
      if (isInIntArray(spaceSkip, i))
        spaces[i] = new SpaceSkip();
      else if (isInIntArray(spaceSurprise, i))
        spaces[i] = new SpaceSurprise();
      else if (isInIntArray(spaceLuck, i))
        spaces[i] = new SpaceLuck();
      else if (isInIntArray(spaceFU, i))
        spaces[i] = new SpaceFU();
      else if (isInIntArray(spaceSwap, i))
        spaces[i] = new SpaceSwap();
      else
        spaces[i] = new SpaceRegular();
    }

    for (int i = 0; i < numPlayers; i++) {
      switch (i%3) {
        case 0:
          players[i] = new PlayerRegular(colors[i]);
          break;
        case 1:
          players[i] = new PlayerUnlucky(colors[i]);
          break;
        case 2:
          players[i] = new PlayerLucky(colors[i]);
          break;
      }
    }
  }
  
  public void executeTurn() {
    if (players[currPlayer].canPlayTurn()) {
      players[currPlayer].jogarDados();
      System.out.println("Rolou: " + players[currPlayer].getDice()[0] + ", " + players[currPlayer].getDice()[1]);
      
      if (players[currPlayer].getPos() >= 40)
        return;

      spaces[players[currPlayer].getPos()].applyEffect(players, numPlayers, currPlayer);
    } else
      players[currPlayer].playNextTurn();

    if (!players[currPlayer].areDiceEqual())
      currPlayer++;
    else
      players[currPlayer].resetDice();

    if (currPlayer >= numPlayers) {
      currPlayer -= numPlayers;
    }
  }

  public boolean checkWinners() {
    for (Player p : players)
      if (p.getPos() >= 40) {
        winner = p.getCor();
        return true;
      }

    return false;
  }

  public void getEndGameStats() {
    System.out.println(winner + " ganhou o jogo");
    for (Player p : players)
      System.out.println(p.getCor() + " jogou " + p.getTurnCount() + " turnos");
  }

  public String getCurrentTurn() {
    return players[currPlayer].getCor();
  }

  public Map<Integer,AbstractMap.SimpleEntry<Space,ArrayList<Character>>> getCurrentBoard() {
    Map<Integer,AbstractMap.SimpleEntry<Space,ArrayList<Character>>> currBoard = new HashMap<Integer,AbstractMap.SimpleEntry<Space,ArrayList<Character>>>();

    for (int i = 0; i < 40; i++) {
      ArrayList<Character> playersInSpace = new ArrayList<Character>();
      for (int j = 0; j < numPlayers; j++)
        if (players[j].getPos() == i) playersInSpace.add(players[j].getCor().charAt(0));

      currBoard.put(i, new AbstractMap.SimpleEntry<>(spaces[i], playersInSpace));
    }

    return currBoard;
  }
}
