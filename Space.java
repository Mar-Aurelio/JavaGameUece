public abstract class Space{
  protected char symbol;

  public Space(char symbol) {
    this.symbol = symbol;
  }

  public abstract void applyEffect(Player[] players, int playersSize, int currentPlayer);

  public char getSymbol() {
    return symbol;
  }
}
