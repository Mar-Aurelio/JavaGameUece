public class SpaceLuck extends Space {
  public SpaceLuck() {
    super('!');
  }

  public void applyEffect(Player[] players, int playersSize, int currentPlayer) {
    if (!(players[currentPlayer] instanceof PlayerUnlucky)) {
      players[currentPlayer].setPos(players[currentPlayer].getPos() + 3);
      System.out.println("Casa de sorte: Movendo jogador " + players[currentPlayer].getCor() + " 3 casas extras");
    } else {
      System.out.println("Casa de sorte: " + players[currentPlayer].getCor() + " não moveu casas extras por ser azarado");
    }
  }
}
