package pieces;

public class Rook extends Piece {
  public Rook(int x, int y, String imageAddress) {
    super(x, y, imageAddress);
  }

  @Override
  public boolean isValidMove(int x, int y) {
    if (!super.isValidMove(x, y)) {
      return false;
    }
    if ((x == 0) || (y == 0)) {
      return true;
    }
    return false;
  }
}
