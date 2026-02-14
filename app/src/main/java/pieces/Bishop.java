package pieces;

public class Bishop extends Piece {
  public Bishop(int row, int col, String imageaddress) {
    super(row, col, imageaddress);
  }

  @Override
  public boolean isValidMove(int row, int col) {
    if (!super.isValidMove(row, col)) {
      return false;
    }
    int dx = row - this.getRow();
    int dy = col - this.gerCol();
    if ((dx == dy) || (dx == -dy)) {
      return true;
    }
    return false;
  }
}
