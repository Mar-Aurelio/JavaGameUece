import java.util.Random;

enum Surprise {
  REGULAR,
  LUCKY,
  UNLUCKY
};

public class SpaceSurprise extends Space {
  private Random random = new Random();

  public SpaceSurprise() {
    super('?');
  }

  public void applyEffect(Player[] players, int playerSize, int currentPlayer) {
    Surprise card = Surprise.values()[random.nextInt(3)];

    switch (card) {
      case Surprise.REGULAR:
        players[currentPlayer] = new PlayerRegular(players[currentPlayer].getCor(), players[currentPlayer].getPos());
        System.out.println("Casa de surpresa: " + players[currentPlayer].getCor() + " agore é normal");
        break;
      case Surprise.LUCKY:
        players[currentPlayer] = new PlayerLucky(players[currentPlayer].getCor(), players[currentPlayer].getPos());
        System.out.println("Casa de surpresa: " + players[currentPlayer].getCor() + " agore é sortudo");
        break;
      case Surprise.UNLUCKY:
        players[currentPlayer] = new PlayerUnlucky(players[currentPlayer].getCor(), players[currentPlayer].getPos());
        System.out.println("Casa de surpresa: " + players[currentPlayer].getCor() + " agore é azarado");
        break;
    }
  }
}
