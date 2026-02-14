package pieces;

public class Knight extends Piece {
  public Knight(int x, int y, String imageAddress, boolean white) {
    super(x, y, imageAddress, white);
  }

  @Override
  public boolean isValidMove(int x, int y, boolean capture) {
    if (!super.isValidMove(x, y, capture)) {
      return false;
    }
    if ((x == 1 || x == -1) && (y == 2 || y == -2)) {
      return true;
    }
    if ((x == 2 || x == -2) && (y == 1 || y == -1)) {
      return true;
    }

    return false;
  }
}
