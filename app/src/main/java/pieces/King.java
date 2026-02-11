package pieces;

public class King extends Piece {
  public King(int x, int y, String imageAddress, boolean white) {
    super(x, y, imageAddress, white);
  }

  @Override
  public boolean isValidMove(int x, int y, boolean capture) {
    if (super.isValidMove(x, y, capture)) {
      if ((x >= -1 && x <= 1) && (y >= -1 && y <= 1))
        return true;
    }
    return false;
  }
}
