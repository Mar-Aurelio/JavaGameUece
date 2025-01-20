public class PlayerLucky extends Player {
  public PlayerLucky(String color) {
    super(color);
  }

  public PlayerLucky(String color, int position) {
    super(color);
    this.position = position;
  }

  public void jogarDados() {
    do {
      for (int i = 0; i < 2; i++)
        dice[i] = random.nextInt(6) + 1;
    } while (dice[0] + dice[1] < 7);

    position += dice[0] + dice[1];
    turnCount++;
  }
}
