public class SpaceSwap extends Space {
  public SpaceSwap() {
    super('⇄');
  }

  public void applyEffect(Player[] players, int playersSize, int currentPlayer) {
    int far = 40;
    int playerIndex = 0;
    
    for (int i = 0; i < playersSize; i++) {
      if (far > players[i].getPos()) {
        far = players[i].getPos();
        playerIndex = i;
      }
    }

    if (players[currentPlayer].getPos() == players[playerIndex].getPos())
      return;

    int temp = players[currentPlayer].getPos();
    players[currentPlayer].setPos(players[playerIndex].getPos());
    players[playerIndex].setPos(temp);

    System.out.println("Casa de troca: " + players[currentPlayer].getCor() + " e " + players[playerIndex].getCor() + " trocaram de posição");
  }
}
