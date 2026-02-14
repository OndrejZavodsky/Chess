package pieces;

public class Queen extends Piece {
  public Queen(int row, int col, String imageAddress) {
    super(row, col, imageAddress);
  }

  @Override
  public boolean isValidMove(int row, int col) {
    if (!super.isValidMove(row, col)) {
      return false;
    }
    int dRow = row - this.getRow();
    int dCol = col - this.gerCol();
    if ((dRow == 0) || (dCol == 0)) {
      return true;
    }
    if ((dRow == dCol) || (dRow == -dCol)) {
      return true;
    }
    return false;
  }
}
