package pieces;

public class King extends Piece {
  public King(int x, int y, String imageAddress) {
    super(x, y, imageAddress);
  }

  @Override
  public boolean isValidMove(int x, int y) {
    if (super.isValidMove(x, y)) {
      if ((x >= -1 && x <= 1) && (y >= 1 && y <= 1))
        return true;
    }
    return false;
  }
}
