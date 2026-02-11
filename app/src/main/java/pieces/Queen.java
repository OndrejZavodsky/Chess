package pieces;

public class Queen extends Piece {
  public Queen(int x, int y, String imageAddress) {
    super(x, y, imageAddress);
  }

  public boolean isValidMove(int x, int y) {
    if (!super.isValidMove(x, y)) {
      return false;
    }
    if (((x == 0) || (y == 0)) || ((x == y) || (x == -y))) {
      return true;
    }
    return false;
  }
}
