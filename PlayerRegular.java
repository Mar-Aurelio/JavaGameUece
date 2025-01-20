public class PlayerRegular extends Player {
  public PlayerRegular(String color) {
    super(color);
  }

  public PlayerRegular (String color, int position) {
    super(color);
    this.position = position;
  }

  public void jogarDados() {
    for (int i = 0; i < 2; i++)
      dice[i] = random.nextInt(6) + 1;

    position += dice[0] + dice[1];
    turnCount++;
  }
}
