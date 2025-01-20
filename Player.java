import java.util.Random;

public abstract class Player {
  protected int position;
  protected int turnCount;
  protected int[] dice;
  protected boolean canPlay;
  protected String color;
  protected Random random = new Random();

  public Player(String color) {
    this.color = color;
    position = 0;
    turnCount = 0;
    canPlay = true;
    dice = new int[2];
    dice[0] = -1;
    dice[1] = 7;
  }

  public abstract void jogarDados();

  public void skipNextTurn() {
    canPlay = false;
  }

  public void playNextTurn() {
    canPlay = true;
  }

  public void setPos(int position) {
    this.position = position;
  }

  public boolean areDiceEqual() {
    return (dice[0] == dice[1]);
  }

  public boolean canPlayTurn() {
    return canPlay;
  }

  public void resetDice() {
    dice[0] = -1;
    dice[1] = 7;
  }

  public int getTurnCount() {
    return turnCount;
  }

  public int[] getDice() {
    return dice;
  }

  public String getCor() {
    return color;
  }

  public int getPos() {
    return position;
  }
}
