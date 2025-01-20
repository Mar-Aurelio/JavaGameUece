public class PlayerUnlucky extends Player {
  public PlayerUnlucky(String color) {
    super(color);
  }
  
  public PlayerUnlucky (String color, int position) {
    super(color);
    this.position = position;
  }

  public void jogarDados() {
    do {
      for (int i = 0; i < 2; i++)
        dice[i] = random.nextInt(6) + 1;
    } while (dice[0] + dice[1] > 6);

    position += dice[0] + dice[1];
    turnCount++;
  }
}
