package pieces;

public class Knight extends Piece {
  public Knight(int row, int col, String imageAddress) {
    super(row, col, imageAddress);
  }

  @Override
  public boolean isValidMove(int row, int col) {
    if (!super.isValidMove(row, col)) {
      return false;
    }
    int dx = Math.abs(row - this.getRow());
    int dy = Math.abs(col - this.gerCol());
    if (dx == 2 && dy == 1) {
      return true;
    }
    if (dx == 1 && dy == 2) {
      return true;
    }
    return false;
  }
}
