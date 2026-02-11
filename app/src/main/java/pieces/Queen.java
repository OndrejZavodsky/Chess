package pieces;

public class Queen extends Piece {
  public Queen(int x, int y, String imageAddress, boolean white) {
    super(x, y, imageAddress, white);
  }

  @Override
  public boolean isValidMove(int x, int y, boolean capture) {
    if (!super.isValidMove(x, y, capture)) {
      return false;
    }
    if (((x == 0) || (y == 0)) || ((x == y) || (x == -y))) {
      return true;
    }
    return false;
  }
}
