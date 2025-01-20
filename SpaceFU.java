import java.util.Scanner;

public class SpaceFU extends Space {
  Scanner input = new Scanner(System.in);

  public SpaceFU() {
    super('↰');
  }

  public void applyEffect(Player[] players, int playersSize, int currentPlayer) {
    int selected = 0;
    while (selected < 1 || selected > 4) {
      System.out.println("Casa de FU: Escolha um jogador para mandar para o inicio :");
      for (int i = 0; i < playersSize; i++) {
        System.out.println(i + " - " + players[i].getCor());
      }
      selected = input.nextInt();
    }

    players[selected - 1].setPos(0);
  }
}
