public class SpaceSkip extends Space {
  public SpaceSkip() {
    super('x');
  }

  public void applyEffect(Player[] players, int playersSize, int currentPlayer) {
    players[currentPlayer].skipNextTurn();

    System.out.println("Casa de pulo: Proximo turno de " + players[currentPlayer].getCor() + " será pulado");
  }
}
