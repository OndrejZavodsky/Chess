package pieces;

public class Rook extends Piece {
  public Rook(int x, int y, String imageAddress, boolean white) {
    super(x, y, imageAddress);
  }

  @Override
  public boolean isValidMove(int row, int col) {
    if (!super.isValidMove(row, col)) {
      return false;
    }
    int dx = row - this.getRow();
    int dy = col - this.gerCol();
    if ((dx == 0) || (dy == 0)) {
      return true;
    }
    return false;
  }
}
