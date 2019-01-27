package cs3500.marblesolitaire.model.hw02;

/**
 * Class implementation of MarbleSolitaireModel
 */
public final class MarbleSolitaireModelImpl implements MarbleSolitaireModel {
  private String[][] board;
  private final int DEFAULT_ARM = 3;

  public MarbleSolitaireModelImpl() {
    this.getGameState();
  }

  public MarbleSolitaireModelImpl(int sRow, int sCol) {

  }

  public MarbleSolitaireModelImpl(int thicc) {

  }
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {

  }

  @Override
  public boolean isGameOver() {
    return false;
  }

  @Override
  public String getGameState() {
    int width = DEFAULT_ARM * 4 + 1;
    int boardSize = width * width;
    for (int x = 0; x <  boardSize - 1; ++x) {
      for (int y = 0; y < boardSize - 1; ++y) {
        this.board[x][y] = "0";
      }
    }
    return this.board.toString();

  }

  @Override
  public int getScore() {
    return 0;
  }

}
